// 
// Decompiled by Procyon v0.5.36
// 

package bot.model;

import java.util.Arrays;

public enum SmsServiceCountry
{
    RU(new SMSService[] { SMSService.SMSActivate, SMSService.SMSPVA, SMSService.SMSSms, SMSService.GetSMS }), 
    CN(new SMSService[] { SMSService.SMSActivate, SMSService.ChineSMS }), 
    KZ(new SMSService[] { SMSService.SMSActivate, SMSService.SMSPVA, SMSService.SMSSms, SMSService.GetSMS }), 
    UK(new SMSService[] { SMSService.SMSPVA, SMSService.SMSSms, SMSService.GetSMS }), 
    UA(new SMSService[] { SMSService.SMSActivate, SMSService.SMSPVA, SMSService.SMSSms, SMSService.GetSMS }), 
    PH(new SMSService[] { SMSService.SMSActivate, SMSService.SMSPVA, SMSService.SMSSms }), 
    VN(new SMSService[] { SMSService.SMSActivate }), 
    ID(new SMSService[] { SMSService.SMSActivate, SMSService.SMSPVA, SMSService.SMSSms }), 
    MY(new SMSService[] { SMSService.SMSActivate }), 
    TZ(new SMSService[] { SMSService.SMSActivate }), 
    LV(new SMSService[] { SMSService.SMSPVA, SMSService.SMSSms });
    
    private SMSService[] supportSmsServices;
    
    private SmsServiceCountry(final SMSService[] supportSmsServices) {
        this.supportSmsServices = supportSmsServices;
    }
    
    public static SmsServiceCountry getCountryByCountryPhoneCode(final String countryPhoneCode) {
        if (countryPhoneCode.equalsIgnoreCase("7")) {
            return SmsServiceCountry.RU;
        }
        if (countryPhoneCode.equalsIgnoreCase("380")) {
            return SmsServiceCountry.UA;
        }
        if (countryPhoneCode.equalsIgnoreCase("44")) {
            return SmsServiceCountry.UK;
        }
        if (countryPhoneCode.equalsIgnoreCase("86")) {
            return SmsServiceCountry.CN;
        }
        if (countryPhoneCode.equalsIgnoreCase("62")) {
            return SmsServiceCountry.ID;
        }
        if (countryPhoneCode.equalsIgnoreCase("84")) {
            return SmsServiceCountry.VN;
        }
        if (countryPhoneCode.equalsIgnoreCase("371")) {
            return SmsServiceCountry.LV;
        }
        if (countryPhoneCode.equalsIgnoreCase("60")) {
            return SmsServiceCountry.MY;
        }
        if (countryPhoneCode.equalsIgnoreCase("63")) {
            return SmsServiceCountry.PH;
        }
        if (countryPhoneCode.equalsIgnoreCase("255")) {
            return SmsServiceCountry.TZ;
        }
        return SmsServiceCountry.RU;
    }
    
    public String getISOCountryForSMSServiceCountry() {
        switch (this) {
            case RU: {
                return "RU";
            }
            case KZ: {
                return "KZ";
            }
            case UA: {
                return "UA";
            }
            case UK: {
                return "GB";
            }
            case CN: {
                return "CN";
            }
            case ID: {
                return "ID";
            }
            case TZ: {
                return "TZ";
            }
            case LV: {
                return "LV";
            }
            case PH: {
                return "PH";
            }
            case MY: {
                return "MY";
            }
            case VN: {
                return "VN";
            }
            default: {
                return null;
            }
        }
    }
    
    public String getLocaleForSMSServiceCountry() {
        switch (this) {
            case RU: {
                return "ru";
            }
            case KZ: {
                return "kz";
            }
            case UA: {
                return "ua";
            }
            case UK: {
                return "en";
            }
            case CN: {
                return "cn";
            }
            case TZ: {
                return "tz";
            }
            case MY: {
                return "my";
            }
            case LV: {
                return "lv";
            }
            case VN: {
                return "vn";
            }
            case ID: {
                return "id";
            }
            case PH: {
                return "ph";
            }
            default: {
                return null;
            }
        }
    }
    
    public String getCountryPhoneCode() {
        switch (this) {
            case RU: {
                return "7";
            }
            case KZ: {
                return "7";
            }
            case UA: {
                return "380";
            }
            case UK: {
                return "44";
            }
            case CN: {
                return "86";
            }
            case ID: {
                return "62";
            }
            case VN: {
                return "84";
            }
            case LV: {
                return "371";
            }
            case MY: {
                return "60";
            }
            case PH: {
                return "63";
            }
            case TZ: {
                return "255";
            }
            default: {
                return null;
            }
        }
    }
    
    public static String getLocaleFromCountryISO(final String countryISO) {
        return countryISO.toLowerCase() + "_" + countryISO.toUpperCase();
    }
    
    public String getCodeCountryForSmaActivate() {
        switch (this) {
            case RU: {
                return "0";
            }
            case KZ: {
                return "2";
            }
            case UA: {
                return "1";
            }
            case CN: {
                return "3";
            }
            case ID: {
                return "6";
            }
            case VN: {
                return "10";
            }
            case MY: {
                return "7";
            }
            case PH: {
                return "4";
            }
            case TZ: {
                return "9";
            }
            default: {
                return null;
            }
        }
    }
    
    @Override
    public String toString() {
        return super.toString() + ", support : " + Arrays.toString(this.supportSmsServices);
    }
    
    public String myToString() {
        return super.toString();
    }
}
