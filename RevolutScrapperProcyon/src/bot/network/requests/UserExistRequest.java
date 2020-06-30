// 
// Decompiled by Procyon v0.5.36
// 

package bot.network.requests;

import java.security.spec.InvalidKeySpecException;
import java.security.NoSuchProviderException;
import javax.crypto.ShortBufferException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import bot.utils.Base64;
import java.util.LinkedHashMap;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidAlgorithmParameterException;
import javax.crypto.BadPaddingException;
import java.security.InvalidKeyException;
import javax.crypto.IllegalBlockSizeException;
import java.security.NoSuchAlgorithmException;
import utils.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import bot.main.RevolutUser;
import bot.network.Request;

public class UserExistRequest implements Request<String>
{
    public static String host;
    public static int port;
    RevolutUser user;
    private String requestBody;
    private String path;
    
    public UserExistRequest(final RevolutUser user) {
        this.path = "/user/exist?phones=%s";
        this.user = user;
    }
    
    @Override
    public final String getPath() throws UnsupportedEncodingException {
        return String.format(this.path, URLEncoder.encode(this.user.getPhoneNumber(), "UTF-8"));
    }
    
    @Override
    public String getHeadersAndBodyRequest() throws Exception {
        final String body = this.getRequestBody();
        final String header = this.getHeaders();
        final String headerAndBody = header + "\r\n" + body;
        return headerAndBody;
    }
    
    @Override
    public final String getRequestBody() throws UnsupportedEncodingException, NoSuchAlgorithmException, IllegalBlockSizeException, InvalidKeyException, BadPaddingException, InvalidAlgorithmParameterException, NoSuchPaddingException {
        if (TextUtils.isEmpty(this.requestBody)) {
            this.requestBody = "";
        }
        return this.requestBody;
    }
    
    @Override
    public byte[] getRequestBodyInBytes() throws Exception {
        return new byte[0];
    }
    
    @Override
    public String getHeaders() throws IOException, NoSuchPaddingException, ShortBufferException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, NoSuchProviderException, InvalidKeyException, InvalidKeySpecException, InvalidAlgorithmParameterException {
        final StringBuilder request = new StringBuilder();
        final Map<String, String> headerMap = new LinkedHashMap<String, String>();
        request.append("GET").append(" ").append(this.getPath()).append(" ").append("HTTP/1.1").append("\r\n");
        headerMap.put("Host", UserExistRequest.host);
        headerMap.put("Connection", "Keep-Alive");
        headerMap.put("Accept-Encoding", "gzip");
        headerMap.put("X-Api-Version", "1");
        headerMap.put("X-Device-Id", this.user.getDeviceId());
        headerMap.put("X-Device-Model", String.format("%s %s", this.user.getPhoneManufacture(), this.user.getPhoneModel()));
        headerMap.put("Accept-Language", "en-GB");
        headerMap.put("X-Push-Id", this.user.getFCMToken());
        headerMap.put("X-Client-Version", "5.12");
        headerMap.put("User-Agent", String.format("Revolut/%s %s (%s; Android %s)", "5.12", "501200372", this.user.getPhoneModel(), this.user.getAndroidOsVersion()));
        headerMap.put("Authorization", String.format("Basic %s", Base64.encodeToString("App:S9WUnSFBy67gWan7".getBytes("UTF-8"), 2)));
        for (final Map.Entry<String, String> entry : headerMap.entrySet()) {
            request.append(entry.getKey()).append(": ").append(TextUtils.isEmpty(entry.getValue()) ? "" : entry.getValue()).append("\r\n");
        }
        return request.toString();
    }
    
    @Override
    public String getHost() {
        return UserExistRequest.host;
    }
    
    @Override
    public int getPort() {
        return UserExistRequest.port;
    }
    
    @Override
    public boolean isSSLConnection() {
        return UserExistRequest.port == 443;
    }
    
    @Override
    public boolean isKeepAliveConnection() {
        return true;
    }
    
    @Override
    public boolean isBytesBody() {
        return false;
    }
    
    public static void main(final String[] args) throws Exception {
    }
    
    static {
        UserExistRequest.host = "api.revolut.com";
        UserExistRequest.port = 443;
    }
}
