// 
// Decompiled by Procyon v0.5.36
// 

package bot.network;

import javax.net.ssl.SSLSession;
import java.security.GeneralSecurityException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.TrustManager;
import javax.net.ssl.KeyManager;
import java.security.SecureRandom;
import javax.net.ssl.SSLContext;
import java.security.cert.CertificateException;
import bot.utils.Log;
import java.util.Arrays;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

public class TLSTrustAll
{
    private void exampleUsage() {
        final X509TrustManager[] x509TrustManagers = getTrustAllManagers();
        final SSLSocketFactory sslSocketFactory = getTrustAllSSLSocketFactory();
        final X509TrustManager x509TrustManager = getTrustAllManagers()[0];
        final HostnameVerifier verifier = getTrustAllHostnameVerifier();
    }
    
    public static X509TrustManager[] getTrustAllManagers() {
        return new X509TrustManager[] { new X509TrustManager() {
                @Override
                public void checkClientTrusted(final X509Certificate[] chain, final String authType) throws CertificateException {
                    Log.log("checkClientTrusted, authType = " + authType + "\n" + Arrays.toString(chain));
                }
                
                @Override
                public void checkServerTrusted(final X509Certificate[] chain, final String authType) throws CertificateException {
                }
                
                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[0];
                }
            } };
    }
    
    public static SSLSocketFactory getTrustAllSSLSocketFactory() {
        SSLContext sslContext = null;
        try {
            sslContext = SSLContext.getInstance("TLSv1.2");
            sslContext.init(null, getTrustAllManagers(), new SecureRandom());
        }
        catch (NoSuchAlgorithmException | KeyManagementException ex2) {
			/*
			 * final GeneralSecurityException ex; final GeneralSecurityException e = ex;
			 */
        	ex2.printStackTrace();
            return null;
        }
        return sslContext.getSocketFactory();
    }
    
    public static HostnameVerifier getTrustAllHostnameVerifier() {
        return new HostnameVerifier() {
            @Override
            public boolean verify(final String s, final SSLSession sslSession) {
                return true;
            }
        };
    }
}
