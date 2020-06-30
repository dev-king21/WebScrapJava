// 
// Decompiled by Procyon v0.5.36
// 

package bot.main;

import bot.model.SmsServiceCountry;
import bot.model.MobileOperator;
import bot.model.SMSService;
import java.net.Proxy;

public interface User
{
    String getProxyHost();
    
    int getProxyPort();
    
    Proxy.Type getProxyType();
    
    String getProxyUser();
    
    String getProxyPassword();
    
    SMSService getSMSService();
    
    MobileOperator getMobileOperator();
    
    SmsServiceCountry getCountryForSmsService();
    
    void setProxy(final bot.model.Proxy p0);
}
