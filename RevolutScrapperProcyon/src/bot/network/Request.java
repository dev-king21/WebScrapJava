// 
// Decompiled by Procyon v0.5.36
// 

package bot.network;

import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;

public interface Request<T>
{
    public static final ObjectMapper mapper = new ObjectMapper();
    
    String getPath() throws IOException;
    
    String getRequestBody() throws Exception;
    
    byte[] getRequestBodyInBytes() throws Exception;
    
    String getHeaders() throws Exception;
    
    String getHeadersAndBodyRequest() throws Exception;
    
    String getHost();
    
    int getPort();
    
    boolean isSSLConnection();
    
    boolean isKeepAliveConnection();
    
    boolean isBytesBody();
}
