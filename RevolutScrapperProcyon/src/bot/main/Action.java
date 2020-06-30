// 
// Decompiled by Procyon v0.5.36
// 

package bot.main;

import java.util.Iterator;
import java.io.IOException;
import bot.network.json.user.ContactModel;
import com.fasterxml.jackson.core.type.TypeReference;
import bot.network.StatusCode;
import bot.network.requests.UserExistRequest;
import java.util.regex.Matcher;
import java.io.OutputStream;
import bot.network.json.base.JsonReadable;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;
import java.io.ByteArrayInputStream;
import bot.utils.Constants;
import java.io.ByteArrayOutputStream;
import java.io.Writer;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import bot.utils.Log;
import bot.network.Response;
import bot.network.Request;
import bot.network.SocketControllerFactory;
import java.net.Socket;
import com.fasterxml.jackson.databind.DeserializationFeature;
import java.util.HashMap;
import com.fasterxml.jackson.databind.ObjectMapper;
import bot.network.SocketTimer;
import java.util.Map;
import bot.network.CookieUtils;

public class Action
{
    private long previousRequestTime;
    private long server_latency;
    private CookieUtils cookieUtils;
    private Map<Integer, SocketTimer> mapWithSocket;
    private long timeLiveKeepAliveSocket;
    ObjectMapper mapper;
    private final RevolutUser user;
    
    public Action(final RevolutUser user) {
        this.server_latency = 0L;
        this.mapWithSocket = new HashMap<Integer, SocketTimer>();
        this.timeLiveKeepAliveSocket = 120000L;
        this.user = user;
        this.cookieUtils = new CookieUtils();
        (this.mapper = new ObjectMapper()).configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        this.mapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
    }
    
    private CookieUtils getCookieUtils() {
        return this.cookieUtils;
    }
    
    public Socket getSocket(final String host, final int port, final boolean isSSLSocket, final boolean isKeepAlive) throws Exception {
        final int hash = host.hashCode() + 31 * port + (isSSLSocket ? 1 : 0);
        if (!this.mapWithSocket.containsKey(hash)) {
            final Socket socket = isSSLSocket ? SocketControllerFactory.createSocket(this.user, host, port) : SocketControllerFactory.createUsualSocket(this.user, host, port);
            socket.setSoTimeout(60000);
            socket.setKeepAlive(isKeepAlive);
            final SocketTimer socketTimer = new SocketTimer(socket, System.currentTimeMillis());
            this.mapWithSocket.put(hash, socketTimer);
            return socket;
        }
        SocketTimer socketTimer2 = this.mapWithSocket.get(hash);
        if (System.currentTimeMillis() - socketTimer2.getTimeLastUsing() > this.timeLiveKeepAliveSocket || socketTimer2.getSocket().isClosed() || !socketTimer2.getSocket().isConnected()) {
            socketTimer2.close();
            this.mapWithSocket.remove(socketTimer2);
            socketTimer2 = null;
            final Socket socket2 = isSSLSocket ? SocketControllerFactory.createSocket(this.user, host, port) : SocketControllerFactory.createUsualSocket(this.user, host, port);
            socket2.setSoTimeout(60000);
            socket2.setKeepAlive(isKeepAlive);
            final SocketTimer newSocketTimer = new SocketTimer(socket2, System.currentTimeMillis());
            this.mapWithSocket.put(hash, newSocketTimer);
            return socket2;
        }
        socketTimer2.setTimeLastUsing(System.currentTimeMillis());
        return socketTimer2.getSocket();
    }
    
    private <T> Response<T> makeRequest(final Request<T> request, final Class<T> tClass) throws Exception {
        final String logMessage = "******************************" + request.getClass().getSimpleName() + "************************************************";
        Log.log();
        Log.log(logMessage);
        ByteArrayOutputStream byteArrayOutputStream = null;
        ByteArrayInputStream byteArrayInputStream = null;
        final BufferedReader reader = null;
        Writer writer = null;
        InputStream inputStream = null;
        Socket socket = null;
        final Response<T> response = new Response<T>();
        try {
            final long delay = System.currentTimeMillis() - this.previousRequestTime;
            if (delay < this.server_latency) {
                Thread.sleep(this.server_latency - delay);
            }
            socket = this.getSocket(request.getHost(), request.getPort(), request.isSSLConnection(), request.isKeepAliveConnection());
            final OutputStream outputStream = socket.getOutputStream();
            writer = new BufferedWriter(new OutputStreamWriter(outputStream));
            String fullRequest = request.getHeadersAndBodyRequest();
            Log.log(fullRequest);
            writer.write(fullRequest);
            writer.flush();
            if (request.isBytesBody()) {
                fullRequest = new String(request.getRequestBodyInBytes());
                Log.log(fullRequest);
                outputStream.write(request.getRequestBodyInBytes());
            }
            outputStream.flush();
            inputStream = socket.getInputStream();
            byteArrayOutputStream = new ByteArrayOutputStream();
            final StringBuilder builder = new StringBuilder();
            do {
                final int data = inputStream.read();
                if (data == -1) {
                    Log.log("Server break connection while read header");
                    throw new Exception("Exception in makeRequest!!! Server break connection,  while read headers from response)");
                }
                builder.append((char)data);
            } while (builder.indexOf("\n\r\n") == -1);
            String responseHeaders = builder.toString();
            Log.log("\n" + responseHeaders);
            builder.setLength(0);
            if (responseHeaders.startsWith("\r\n")) {
                responseHeaders = responseHeaders.replaceFirst("\r\n", "");
            }
            response.setHeaders(responseHeaders);
            this.cookieUtils.saveFromResponse(request.getHost(), response);
            if (responseHeaders.contains("Content-Length: 0")) {
                return response;
            }
            int size = 0;
            boolean isChunked = false;
            final Matcher matcherContentLength = Constants.contentLengthPattern.matcher(responseHeaders);
            if (matcherContentLength.find()) {
                size = Integer.decode(matcherContentLength.group("size"));
            }
            else {
                final Matcher matcherTransferEncoding = Constants.transferEncodingPattern.matcher(responseHeaders);
                if (matcherTransferEncoding.find()) {
                    isChunked = true;
                }
                else {
                    if (responseHeaders.contains("No Content")) {
                        return response;
                    }
                    throw new Exception("Something wrong in makeRequest, response don't contain content-length and don't chunked\n" + (Object)builder);
                }
            }
            byte[] bodyResponseArray = new byte[0];
            if (!isChunked) {
                if (size == 0) {
                    return response;
                }
                bodyResponseArray = new byte[size];
                for (int count = 0; count < size; ++count) {
                    bodyResponseArray[count] = (byte)inputStream.read();
                }
                byteArrayInputStream = new ByteArrayInputStream(bodyResponseArray);
            }
            else {
                while (true) {
                    final int data = inputStream.read();
                    if (data == -1) {
                        Log.log("Server break connection");
                        throw new Exception("Exception in makeRequest!!! Server break connection,  while read body from response)");
                    }
                    builder.append((char)data);
                    if (builder.indexOf("\r\n") == -1) {
                        continue;
                    }
                    final String sizeChunked = builder.toString().replaceAll("(\r\n|\n)", "");
                    if (sizeChunked.isEmpty()) {
                        builder.setLength(0);
                    }
                    else {
                        final int sizeChunk = Integer.valueOf(sizeChunked, 16);
                        builder.setLength(0);
                        if (sizeChunk == 0) {
                            byteArrayOutputStream.flush();
                            bodyResponseArray = byteArrayOutputStream.toByteArray();
                            byteArrayInputStream = new ByteArrayInputStream(bodyResponseArray);
                            break;
                        }
                        final byte[] chunk = new byte[sizeChunk];
                        for (int j = 0; j < sizeChunk; ++j) {
                            chunk[j] = (byte)inputStream.read();
                        }
                        byteArrayOutputStream.write(chunk);
                    }
                }
            }
            final Matcher matcherContentEncoding = Constants.contentEncodingPattern.matcher(responseHeaders);
            String jsonResult = "";
            if (matcherContentEncoding.find()) {
                if (tClass == byte[].class) {
                    final GZIPInputStream readerGZip = new GZIPInputStream(byteArrayInputStream);
                    final ByteArrayOutputStream outputStreamBuffer = new ByteArrayOutputStream();
                    final byte[] buffer = new byte[1024];
                    int count2;
                    while ((count2 = readerGZip.read(buffer)) != -1) {
                        outputStreamBuffer.write(buffer, 0, count2);
                    }
                    outputStreamBuffer.flush();
                    final byte[] result = outputStreamBuffer.toByteArray();
                    Log.log(String.format("Received %d bytes array from server", result.length));
                    response.setPostBody((T)(Object)result);
                    readerGZip.close();
                    outputStreamBuffer.close();
                    return response;
                }
                final BufferedReader readerGZip2 = new BufferedReader(new InputStreamReader(new GZIPInputStream(byteArrayInputStream)));
                String temp;
                while ((temp = readerGZip2.readLine()) != null) {
                    jsonResult += temp;
                }
                readerGZip2.close();
            }
            else {
                if (tClass == byte[].class) {
                    final byte[] result2 = new byte[byteArrayInputStream.available()];
                    byteArrayInputStream.read(result2);
                    Log.log("Received bytes array from server as image file");
                    response.setPostBody((T)(Object)result2);
                    return response;
                }
                jsonResult = new String(bodyResponseArray);
            }
            Log.log(jsonResult);
            if (tClass != String.class) {
                final ObjectMapper mapper = new ObjectMapper();
                mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                mapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
                final T result3 = (T)mapper.readValue(jsonResult, (Class)tClass);
                if (result3 instanceof JsonReadable) {
                    ((JsonReadable)result3).setJsonFullString(jsonResult);
                }
                response.setPostBody(result3);
                return response;
            }
            response.setPostBody((T)jsonResult);
            return response;
        }
        catch (Exception e) {
            e.printStackTrace();
            Log.log("Exception in makeRequest. Close socket");
            throw e;
        }
        finally {
            Log.log("In finally makeRequest, connection close = " + !request.isKeepAliveConnection());
            this.previousRequestTime = System.currentTimeMillis();
            if (!request.isKeepAliveConnection()) {
                if (writer != null) {
                    writer.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (reader != null) {
                    reader.close();
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                if (byteArrayInputStream != null) {
                    byteArrayInputStream.close();
                }
                if (socket != null) {
                    socket.close();
                }
                System.gc();
            }
        }
    }
    
    String userExistRequest() throws Exception {
        final Request<String> request = new UserExistRequest(this.user);
        final Response<String> response = this.makeRequest(request, String.class);
        if (response.getStatusCode() != StatusCode.HTTP_OK) {
            throw new Exception("Something wrong in " + request.getClass() + ", response from server bad\n" + response.getStatusMessage());
        }
        final TypeReference<Map<String, ContactModel>> typeReference = new TypeReference<Map<String, ContactModel>>() {};
        final Map<String, ContactModel> map = (Map<String, ContactModel>)this.mapper.readValue((String)response.getBody(), (TypeReference)typeReference);
        if (map.isEmpty()) {
            return String.format("%s:%s", this.user.getPhoneNumber(), "NO");
        }
        return String.format("%s:%s", this.user.getPhoneNumber(), "YES");
    }
    
    public void closeAllResources() {
        if (this.mapWithSocket != null && !this.mapWithSocket.isEmpty()) {
            for (final Map.Entry<Integer, SocketTimer> entry : this.mapWithSocket.entrySet()) {
                SocketTimer socketTimer = entry.getValue();
                try {
                    socketTimer.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
                this.mapWithSocket.remove(socketTimer);
                socketTimer = null;
            }
        }
    }
    
    public static void main(final String[] args) {
    }
}
