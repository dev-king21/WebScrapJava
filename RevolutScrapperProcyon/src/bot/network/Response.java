// 
// Decompiled by Procyon v0.5.36
// 

package bot.network;

import java.net.ProtocolException;
import java.io.IOException;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.StringReader;

public class Response<T>
{
    private T postBody;
    private Headers headers;
    private StatusCode statusCode;
    private String statusMessage;
    private Protocol protocol;
    
    public Response() {
        this.headers = new Headers();
    }
    
    public T getBody() {
        return this.postBody;
    }
    
    public void setPostBody(final T postBody) {
        this.postBody = postBody;
    }
    
    public void setHeaders(final String responseHeaders) throws IOException {
        final BufferedReader reader = new BufferedReader(new StringReader(responseHeaders));
        this.parseStatusLine(reader.readLine());
        for (String header = reader.readLine(); header.length() > 0; header = reader.readLine()) {
            this.appendHeader(header);
        }
    }
    
    private void parseStatusLine(final String statusLine) throws ProtocolException {
        int codeStart;
        if (statusLine.startsWith("HTTP/1.")) {
            if (statusLine.length() < 9 || statusLine.charAt(8) != ' ') {
                throw new ProtocolException("Unexpected status line: " + statusLine);
            }
            final int httpMinorVersion = statusLine.charAt(7) - '0';
            codeStart = 9;
            if (httpMinorVersion == 0) {
                final Protocol protocol = Protocol.HTTP_1_0;
            }
            else {
                if (httpMinorVersion != 1) {
                    throw new ProtocolException("Unexpected status line: " + statusLine);
                }
                final Protocol protocol = Protocol.HTTP_1_1;
            }
        }
        else {
            if (!statusLine.startsWith("ICY ")) {
                throw new ProtocolException("Unexpected status line: " + statusLine);
            }
            final Protocol protocol = Protocol.HTTP_1_0;
            codeStart = 4;
        }
        if (statusLine.length() < codeStart + 3) {
            throw new ProtocolException("Unexpected status line: " + statusLine);
        }
        try {
            final int code = Integer.parseInt(statusLine.substring(codeStart, codeStart + 3));
            this.statusCode = StatusCode.parseCode(code);
        }
        catch (NumberFormatException e) {
            throw new ProtocolException("Unexpected status line: " + statusLine);
        }
        final String message = "";
        if (statusLine.length() > codeStart + 3) {
            if (statusLine.charAt(codeStart + 3) != ' ') {
                throw new ProtocolException("Unexpected status line: " + statusLine);
            }
            this.statusMessage = statusLine.substring(codeStart + 4);
        }
    }
    
    private void appendHeader(final String headerLine) throws ProtocolException {
        final int delimeterIndex = headerLine.indexOf(58);
        if (delimeterIndex == -1) {
            throw new ProtocolException("Bad format header line, header line don't contain :\n" + headerLine);
        }
        final String headerName = headerLine.substring(0, delimeterIndex).trim();
        final String headerValue = headerLine.substring(delimeterIndex + 1, headerLine.length()).trim();
        this.headers.add(headerName, headerValue);
    }
    
    public Headers getHeaders() {
        return this.headers;
    }
    
    public StatusCode getStatusCode() {
        return this.statusCode;
    }
    
    public Protocol getProtocol() {
        return this.protocol;
    }
    
    public String getStatusMessage() {
        return this.statusMessage;
    }
}
