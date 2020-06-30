// 
// Decompiled by Procyon v0.5.36
// 

package bot.network;

import java.util.ArrayList;
import java.util.Iterator;
import utils.TextUtils;
import java.util.List;
import java.util.HashMap;

public class CookieUtils
{
    private final HashMap<String, List<Cookie>> cookieStore;
    
    public CookieUtils() {
        this.cookieStore = new HashMap<String, List<Cookie>>();
    }
    
    public void saveFromResponse(final String host, final Response response) {
        final List<Cookie> cookieList = Cookie.parseAll(host, response.getHeaders());
        this.cookieStore.put(host, cookieList);
    }
    
    public String getCookieHeader(final String host) {
        final List<Cookie> cookies = this.cookieStore.get(host);
        if (cookies == null) {
            return null;
        }
        final StringBuilder builder = new StringBuilder();
        for (final Cookie cookie : cookies) {
            builder.append(cookie.toString()).append("; ");
        }
        builder.setLength(builder.length() - 2);
        final String cookieHeader = builder.toString();
        return TextUtils.isEmpty(cookieHeader) ? null : cookieHeader;
    }
    
    public List<Cookie> loadForRequest(final String host) {
        final List<Cookie> cookies = this.cookieStore.get(host);
        return (cookies != null) ? cookies : new ArrayList<Cookie>();
    }
    
    public void clearCookie() {
        this.cookieStore.clear();
    }
}
