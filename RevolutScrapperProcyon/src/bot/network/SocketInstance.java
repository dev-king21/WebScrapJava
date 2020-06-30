// 
// Decompiled by Procyon v0.5.36
// 

package bot.network;

import java.io.IOException;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.net.Socket;
import java.io.OutputStream;
import java.io.BufferedReader;

public class SocketInstance
{
    private final BufferedReader reader;
    private final OutputStream rawOutputStream;
    private Socket socket;
    private InputStream rawInputstream;
    private BufferedWriter writer;
    private String host;
    private int port;
    
    public SocketInstance(final Socket socket, final String host, final int port) throws IOException {
        this.socket = socket;
        this.host = host;
        this.port = port;
        this.rawInputstream = socket.getInputStream();
        this.rawOutputStream = socket.getOutputStream();
        this.reader = new BufferedReader(new InputStreamReader(this.rawInputstream));
        this.writer = new BufferedWriter(new OutputStreamWriter(this.rawOutputStream));
    }
    
    public OutputStream getRawOutputStream() {
        return this.rawOutputStream;
    }
    
    public InputStream getRawInputstream() {
        return this.rawInputstream;
    }
    
    public BufferedWriter getWriter() {
        return this.writer;
    }
    
    public void closeSocket() {
        try {
            if (this.socket != null) {
                this.socket.close();
            }
            if (this.rawInputstream != null) {
                this.rawInputstream.close();
            }
            if (this.writer != null) {
                this.writer.close();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public String getHost() {
        return this.host;
    }
    
    public int getPort() {
        return this.port;
    }
    
    public BufferedReader getReader() {
        return this.reader;
    }
}
