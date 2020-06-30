// 
// Decompiled by Procyon v0.5.36
// 

package bot.network;

import javax.net.ssl.SSLSocketFactory;
import java.util.concurrent.Future;
import java.util.concurrent.ExecutorService;
import javax.net.ssl.HandshakeCompletedEvent;
import javax.net.ssl.HandshakeCompletedListener;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.Executors;
import java.net.Socket;
import bot.utils.Log;
import java.net.SocketAddress;
import java.net.InetSocketAddress;
import java.net.InetAddress;
import java.net.PasswordAuthentication;
import java.net.Authenticator;
import java.io.IOException;
import java.net.Proxy;
import utils.TextUtils;
import javax.net.ssl.SSLSocket;
import bot.main.User;

public class SocketControllerFactory
{
    public static SSLSocket createSocket(final User user, final String host, final int port) throws IOException {
        final String proxyHost = user.getProxyHost();
        final int proxyPort = user.getProxyPort();
        if (TextUtils.isEmpty(proxyHost) || proxyPort == 0) {
            final SSLSocket sslSocket = (SSLSocket)TLSTrustAll.getTrustAllSSLSocketFactory().createSocket(host, port);
            return sslSocket;
        }
        final String proxyUser = user.getProxyUser();
        final String proxyPassword = user.getProxyPassword();
        final Proxy.Type type = user.getProxyType();
        final SSLSocket sslSocket = getSSLProxySocket(host, port, proxyUser, proxyPassword, proxyHost, proxyPort, type);
        return sslSocket;
    }
    
    private static SSLSocket getSSLProxySocket(final String host, final int port, final String proxyUser, final String proxyPassword, final String proxyHost, final int proxyPort, final Proxy.Type type) throws IOException {
        if (!TextUtils.isEmpty(proxyUser) && !TextUtils.isEmpty(proxyPassword)) {
            Authenticator.setDefault(new Authenticator() {
                public PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(proxyUser, proxyPassword.toCharArray());
                }
            });
        }
        if (type == null) {
            throw new IllegalArgumentException("You didn't set Type Proxy. You need set Type Proxy : SOCKS or HTTP. Or don't use proxy at all - for it don't set proxy Host and proxy Port");
        }
        final Proxy proxy = new Proxy(type, new InetSocketAddress(InetAddress.getByName(proxyHost).getHostAddress(), proxyPort));
        Log.log("Set Proxy in SSL socket : " + proxyHost + ":" + proxyPort + ":" + type);
        final Socket tunnel = new Socket(proxy);
        ExecutorService executor = Executors.newFixedThreadPool(1);
        final ExecutorCompletionService<Boolean> completionService = new ExecutorCompletionService<Boolean>(executor);
        final Callable<Boolean> callable = new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                tunnel.connect(new InetSocketAddress(host, port));
                return true;
            }
        };
        completionService.submit(callable);
        try {
            final Future<Boolean> future = completionService.poll(1L, TimeUnit.MINUTES);
            if (future == null || !future.get()) {
                throw new IOException("BAD PROXY, Can't connect to proxy " + proxy);
            }
        }
        catch (InterruptedException ex) {}
        catch (ExecutionException e) {
            e.printStackTrace();
            throw new IOException("BAD PROXY, Can't connect to proxy " + proxy);
        }
        finally {
            if (executor != null) {
                executor.shutdownNow();
                executor = null;
            }
        }
        final SSLSocketFactory factory = TLSTrustAll.getTrustAllSSLSocketFactory();
        final SSLSocket socket = (SSLSocket)factory.createSocket(tunnel, host, port, true);
        socket.addHandshakeCompletedListener(new HandshakeCompletedListener() {
            @Override
            public void handshakeCompleted(final HandshakeCompletedEvent event) {
            }
        });
        socket.startHandshake();
        return socket;
    }
    
    public static Socket createUsualSocket(final User user, final String host, final int port) throws Exception {
        final String proxyHost = user.getProxyHost();
        final int proxyPort = user.getProxyPort();
        if (TextUtils.isEmpty(proxyHost) || proxyPort == 0) {
            final Socket socket = new Socket(host, port);
            return socket;
        }
        final String proxyUser = user.getProxyUser();
        final String proxyPassword = user.getProxyPassword();
        final Proxy.Type type = user.getProxyType();
        final Socket socket = getUsualProxySocket(host, port, proxyUser, proxyPassword, proxyHost, proxyPort, type);
        return socket;
    }
    
    private static Socket getUsualProxySocket(final String host, final int port, final String proxyUser, final String proxyPassword, final String proxyHost, final int proxyPort, final Proxy.Type type) throws Exception {
        if (!TextUtils.isEmpty(proxyUser) && !TextUtils.isEmpty(proxyPassword)) {
            Log.log("Set1 proxy auth " + proxyUser + ":" + proxyPassword);
            Authenticator.setDefault(new Authenticator() {
                public PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(proxyUser, proxyPassword.toCharArray());
                }
            });
        }
        if (type == null) {
            throw new IllegalArgumentException("You didn't set Type Proxy. You need set Type Proxy : SOCKS or HTTP. Or don't use proxy at all - for it don't set proxy Host and proxy Port");
        }
        final Proxy proxy = new Proxy(type, new InetSocketAddress(InetAddress.getByName(proxyHost).getHostAddress(), proxyPort));
        Log.log("Set Proxy in usual socket : " + proxyHost + ":" + proxyPort + ":" + type);
        final Socket socket = new Socket(proxy);
        socket.connect(new InetSocketAddress(host, port));
        return socket;
    }
}
