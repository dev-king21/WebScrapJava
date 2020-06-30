// 
// Decompiled by Procyon v0.5.36
// 

package bot.model;

public enum SMSService
{
    SMSActivate, 
    SMSPVA, 
    SMSSms, 
    GetSMS, 
    ChineSMS;
    
    public int getMaxCountTryReceiveVerificationCode() {
        return 1;
    }
}
