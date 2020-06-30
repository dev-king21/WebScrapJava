// 
// Decompiled by Procyon v0.5.36
// 

package bot.network;

import java.io.IOException;
import java.net.Socket;

public class SocketTimer
{
    Socket socket;
    long timeLastUsing;
    
    public SocketTimer(final Socket socket, final long timeLastUsing) {
        this.socket = socket;
        this.timeLastUsing = timeLastUsing;
    }
    
    public Socket getSocket() {
        return this.socket;
    }
    
    public void setSocket(final Socket socket) {
        this.socket = socket;
    }
    
    public long getTimeLastUsing() {
        return this.timeLastUsing;
    }
    
    public void setTimeLastUsing(final long timeLastUsing) {
        this.timeLastUsing = timeLastUsing;
    }
    
    public void close() throws IOException {
        this.socket.close();
        this.socket = null;
    }
}
