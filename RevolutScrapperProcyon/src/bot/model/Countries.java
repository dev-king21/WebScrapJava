// 
// Decompiled by Procyon v0.5.36
// 

package bot.model;

import java.util.Arrays;

public enum Countries
{
    RU(new SMSService[] { SMSService.SMSActivate, SMSService.SMSPVA, SMSService.SMSSms, SMSService.GetSMS, SMSService.SMSActivate }), 
    CN(new SMSService[] { SMSService.SMSActivate, SMSService.SMSActivate }), 
    KZ(new SMSService[] { SMSService.SMSActivate, SMSService.SMSPVA, SMSService.SMSSms, SMSService.GetSMS }), 
    UK(new SMSService[] { SMSService.SMSPVA, SMSService.SMSSms, SMSService.GetSMS, SMSService.SMSActivate }), 
    UA(new SMSService[] { SMSService.SMSActivate, SMSService.SMSPVA, SMSService.SMSSms, SMSService.GetSMS }), 
    PH(new SMSService[] { SMSService.SMSActivate, SMSService.SMSPVA, SMSService.SMSSms, SMSService.SMSActivate }), 
    VN(new SMSService[] { SMSService.SMSActivate, SMSService.SMSActivate }), 
    ID(new SMSService[] { SMSService.SMSActivate, SMSService.SMSPVA, SMSService.SMSSms, SMSService.SMSActivate }), 
    MY(new SMSService[] { SMSService.SMSActivate, SMSService.SMSActivate }), 
    TZ(new SMSService[] { SMSService.SMSActivate, SMSService.SMSActivate }), 
    LV(new SMSService[] { SMSService.SMSActivate, SMSService.SMSPVA, SMSService.SMSSms, SMSService.SMSActivate }), 
    AE(new SMSService[] { SMSService.SMSActivate }), 
    AF(new SMSService[] { SMSService.SMSActivate }), 
    AM(new SMSService[] { SMSService.SMSActivate }), 
    AO(new SMSService[] { SMSService.SMSActivate }), 
    AU(new SMSService[] { SMSService.SMSActivate }), 
    BD(new SMSService[] { SMSService.SMSActivate, SMSService.SMSActivate }), 
    BE(new SMSService[] { SMSService.SMSActivate }), 
    BF(new SMSService[] { SMSService.SMSActivate }), 
    BH(new SMSService[] { SMSService.SMSActivate }), 
    BJ(new SMSService[] { SMSService.SMSActivate }), 
    BW(new SMSService[] { SMSService.SMSActivate, SMSService.SMSActivate }), 
    BY(new SMSService[] { SMSService.SMSActivate }), 
    CD(new SMSService[] { SMSService.SMSActivate }), 
    CG(new SMSService[] { SMSService.SMSActivate, SMSService.SMSActivate }), 
    CH(new SMSService[] { SMSService.SMSActivate }), 
    CM(new SMSService[] { SMSService.SMSActivate }), 
    CO(new SMSService[] { SMSService.SMSActivate, SMSService.SMSActivate }), 
    CZ(new SMSService[] { SMSService.SMSActivate, SMSService.SMSActivate }), 
    DE(new SMSService[] { SMSService.SMSActivate }), 
    DJ(new SMSService[] { SMSService.SMSActivate }), 
    DO(new SMSService[] { SMSService.SMSActivate }), 
    DZ(new SMSService[] { SMSService.SMSActivate, SMSService.SMSActivate }), 
    EE(new SMSService[] { SMSService.SMSActivate, SMSService.SMSActivate }), 
    EG(new SMSService[] { SMSService.SMSActivate, SMSService.SMSActivate }), 
    ES(new SMSService[] { SMSService.SMSActivate, SMSService.SMSActivate }), 
    ET(new SMSService[] { SMSService.SMSActivate }), 
    FR(new SMSService[] { SMSService.SMSActivate }), 
    GE(new SMSService[] { SMSService.SMSActivate }), 
    GM(new SMSService[] { SMSService.SMSActivate, SMSService.SMSActivate }), 
    GN(new SMSService[] { SMSService.SMSActivate }), 
    GT(new SMSService[] { SMSService.SMSActivate }), 
    HK(new SMSService[] { SMSService.SMSActivate, SMSService.SMSActivate }), 
    HT(new SMSService[] { SMSService.SMSActivate, SMSService.SMSActivate }), 
    HU(new SMSService[] { SMSService.SMSActivate }), 
    IL(new SMSService[] { SMSService.SMSActivate, SMSService.SMSActivate }), 
    IQ(new SMSService[] { SMSService.SMSActivate, SMSService.SMSActivate }), 
    IRL(new SMSService[] { SMSService.SMSActivate, SMSService.SMSActivate }), 
    IT(new SMSService[] { SMSService.SMSActivate }), 
    JM(new SMSService[] { SMSService.SMSActivate }), 
    JO(new SMSService[] { SMSService.SMSActivate }), 
    KAZ(new SMSService[] { SMSService.SMSActivate }), 
    KE(new SMSService[] { SMSService.SMSActivate, SMSService.SMSActivate }), 
    KH(new SMSService[] { SMSService.SMSActivate, SMSService.SMSActivate }), 
    KT(new SMSService[] { SMSService.SMSActivate }), 
    KW(new SMSService[] { SMSService.SMSActivate }), 
    KY(new SMSService[] { SMSService.SMSActivate }), 
    LA(new SMSService[] { SMSService.SMSActivate, SMSService.SMSActivate }), 
    LK(new SMSService[] { SMSService.SMSActivate, SMSService.SMSActivate }), 
    LR(new SMSService[] { SMSService.SMSActivate }), 
    LS(new SMSService[] { SMSService.SMSActivate }), 
    LT(new SMSService[] { SMSService.SMSActivate, SMSService.SMSActivate }), 
    LU(new SMSService[] { SMSService.SMSActivate }), 
    LY(new SMSService[] { SMSService.SMSActivate }), 
    MA(new SMSService[] { SMSService.SMSActivate, SMSService.SMSActivate }), 
    MD(new SMSService[] { SMSService.SMSActivate }), 
    MG(new SMSService[] { SMSService.SMSActivate, SMSService.SMSActivate }), 
    ML(new SMSService[] { SMSService.SMSActivate, SMSService.SMSActivate }), 
    MM(new SMSService[] { SMSService.SMSActivate, SMSService.SMSActivate }), 
    MN(new SMSService[] { SMSService.SMSActivate }), 
    MO(new SMSService[] { SMSService.SMSActivate, SMSService.SMSActivate }), 
    MV(new SMSService[] { SMSService.SMSActivate }), 
    MW(new SMSService[] { SMSService.SMSActivate }), 
    MX(new SMSService[] { SMSService.SMSActivate, SMSService.SMSActivate }), 
    MZ(new SMSService[] { SMSService.SMSActivate }), 
    NA(new SMSService[] { SMSService.SMSActivate }), 
    NE(new SMSService[] { SMSService.SMSActivate }), 
    NG(new SMSService[] { SMSService.SMSActivate, SMSService.SMSActivate }), 
    NL(new SMSService[] { SMSService.SMSActivate, SMSService.SMSActivate }), 
    NO(new SMSService[] { SMSService.SMSActivate }), 
    NP(new SMSService[] { SMSService.SMSActivate }), 
    OM(new SMSService[] { SMSService.SMSActivate }), 
    PA(new SMSService[] { SMSService.SMSActivate }), 
    PG(new SMSService[] { SMSService.SMSActivate }), 
    PK(new SMSService[] { SMSService.SMSActivate, SMSService.SMSActivate }), 
    PL(new SMSService[] { SMSService.SMSActivate, SMSService.SMSActivate }), 
    PR(new SMSService[] { SMSService.SMSActivate }), 
    PT(new SMSService[] { SMSService.SMSActivate }), 
    QA(new SMSService[] { SMSService.SMSActivate }), 
    ROM(new SMSService[] { SMSService.SMSActivate }), 
    RW(new SMSService[] { SMSService.SMSActivate }), 
    SA(new SMSService[] { SMSService.SMSActivate, SMSService.SMSActivate }), 
    SD(new SMSService[] { SMSService.SMSActivate }), 
    SG(new SMSService[] { SMSService.SMSActivate }), 
    SK(new SMSService[] { SMSService.SMSActivate }), 
    SN(new SMSService[] { SMSService.SMSActivate, SMSService.SMSActivate }), 
    SS(new SMSService[] { SMSService.SMSActivate }), 
    SZ(new SMSService[] { SMSService.SMSActivate }), 
    TD(new SMSService[] { SMSService.SMSActivate, SMSService.SMSActivate }), 
    TG(new SMSService[] { SMSService.SMSActivate }), 
    TH(new SMSService[] { SMSService.SMSActivate, SMSService.SMSActivate }), 
    TN(new SMSService[] { SMSService.SMSActivate }), 
    TR(new SMSService[] { SMSService.SMSActivate, SMSService.SMSActivate }), 
    UG(new SMSService[] { SMSService.SMSActivate }), 
    UKR(new SMSService[] { SMSService.SMSActivate }), 
    US(new SMSService[] { SMSService.SMSActivate }), 
    UZ(new SMSService[] { SMSService.SMSActivate, SMSService.SMSActivate }), 
    VE(new SMSService[] { SMSService.SMSActivate, SMSService.SMSActivate }), 
    YE(new SMSService[] { SMSService.SMSActivate, SMSService.SMSActivate }), 
    ZM(new SMSService[] { SMSService.SMSActivate }), 
    ZW(new SMSService[] { SMSService.SMSActivate }), 
    ZA(new SMSService[] { SMSService.SMSActivate, SMSService.SMSActivate }), 
    IN(new SMSService[] { SMSService.SMSActivate }), 
    CI(new SMSService[] { SMSService.SMSActivate }), 
    RS(new SMSService[] { SMSService.SMSActivate }), 
    RO(new SMSService[] { SMSService.SMSActivate }), 
    AZ(new SMSService[] { SMSService.SMSActivate }), 
    CA(new SMSService[] { SMSService.SMSActivate }), 
    GH(new SMSService[] { SMSService.SMSActivate }), 
    AR(new SMSService[] { SMSService.SMSActivate }), 
    HR(new SMSService[] { SMSService.SMSActivate }), 
    AT(new SMSService[] { SMSService.SMSActivate }), 
    TW(new SMSService[] { SMSService.SMSActivate }), 
    IR(new SMSService[] { SMSService.SMSActivate }), 
    SI(new SMSService[] { SMSService.SMSActivate }), 
    PE(new SMSService[] { SMSService.SMSActivate }), 
    NZ(new SMSService[] { SMSService.SMSActivate }), 
    GQ(new SMSService[] { SMSService.SMSActivate }), 
    KG(new SMSService[] { SMSService.SMSActivate });
    
    private SMSService[] supportSmsServices;
    
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
            case MM: {
                return "5";
            }
            case KE: {
                return "8";
            }
            case KG: {
                return "11";
            }
            case US: {
                return "12";
            }
            case IL: {
                return "13";
            }
            case HK: {
                return "14";
            }
            case PL: {
                return "15";
            }
            case UK: {
                return "16";
            }
            case MG: {
                return "17";
            }
            case CG: {
                return "18";
            }
            case NG: {
                return "19";
            }
            case MO: {
                return "20";
            }
            case EG: {
                return "21";
            }
            case IN: {
                return "22";
            }
            case IRL: {
                return "23";
            }
            case KH: {
                return "24";
            }
            case LA: {
                return "25";
            }
            case HT: {
                return "26";
            }
            case CI: {
                return "27";
            }
            case GM: {
                return "28";
            }
            case RS: {
                return "29";
            }
            case YE: {
                return "30";
            }
            case ZA: {
                return "31";
            }
            case RO: {
                return "32";
            }
            case CO: {
                return "33";
            }
            case EE: {
                return "34";
            }
            case AZ: {
                return "35";
            }
            case CA: {
                return "36";
            }
            case MA: {
                return "37";
            }
            case GH: {
                return "38";
            }
            case AR: {
                return "39";
            }
            case UZ: {
                return "40";
            }
            case CM: {
                return "41";
            }
            case TD: {
                return "42";
            }
            case DE: {
                return "43";
            }
            case LT: {
                return "44";
            }
            case HR: {
                return "45";
            }
            case IQ: {
                return "47";
            }
            case NL: {
                return "48";
            }
            case LV: {
                return "49";
            }
            case AT: {
                return "50";
            }
            case BY: {
                return "51";
            }
            case TH: {
                return "52";
            }
            case SA: {
                return "53";
            }
            case MX: {
                return "54";
            }
            case TW: {
                return "55";
            }
            case ES: {
                return "56";
            }
            case IR: {
                return "57";
            }
            case DZ: {
                return "58";
            }
            case SI: {
                return "59";
            }
            case BD: {
                return "60";
            }
            case SN: {
                return "61";
            }
            case TR: {
                return "62";
            }
            case CZ: {
                return "63";
            }
            case LK: {
                return "64";
            }
            case PE: {
                return "65";
            }
            case PK: {
                return "66";
            }
            case NZ: {
                return "67";
            }
            case GQ: {
                return "68";
            }
            case ML: {
                return "69";
            }
            case VE: {
                return "70";
            }
            case ET: {
                return "71";
            }
            default: {
                return null;
            }
        }
    }
    
    private Countries(final SMSService[] supportSmsServices) {
        this.supportSmsServices = supportSmsServices;
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
            case PL: {
                return "48";
            }
            case MM: {
                return "95";
            }
            case KE: {
                return "254";
            }
            case KG: {
                return "996";
            }
            case US: {
                return "1";
            }
            case IL: {
                return "972";
            }
            case HK: {
                return "852";
            }
            case MG: {
                return "261";
            }
            case CG: {
                return "242";
            }
            case NG: {
                return "234";
            }
            case MO: {
                return "853";
            }
            case EG: {
                return "20";
            }
            case IN: {
                return "91";
            }
            case IRL: {
                return "353";
            }
            case KH: {
                return "855";
            }
            case LA: {
                return "856";
            }
            case HT: {
                return "509";
            }
            case CI: {
                return "225";
            }
            case GM: {
                return "220";
            }
            case RS: {
                return "381";
            }
            case YE: {
                return "58";
            }
            case ZA: {
                return "27";
            }
            case RO: {
                return "40";
            }
            case CO: {
                return "57";
            }
            case EE: {
                return "372";
            }
            case AZ: {
                return "994";
            }
            case CA: {
                return "1";
            }
            case MA: {
                return "212";
            }
            case GH: {
                return "233";
            }
            case AR: {
                return "54";
            }
            case UZ: {
                return "998";
            }
            case CM: {
                return "237";
            }
            case TD: {
                return "235";
            }
            case DE: {
                return "49";
            }
            case LT: {
                return "370";
            }
            case HR: {
                return "385";
            }
            case IQ: {
                return "964";
            }
            case NL: {
                return "31";
            }
            case AT: {
                return "43";
            }
            case BY: {
                return "375";
            }
            case TH: {
                return "66";
            }
            case SA: {
                return "966";
            }
            case MX: {
                return "52";
            }
            case TW: {
                return "886";
            }
            case ES: {
                return "34";
            }
            case IR: {
                return "98";
            }
            case DZ: {
                return "213";
            }
            case SI: {
                return "386";
            }
            case BD: {
                return "880";
            }
            case SN: {
                return "221";
            }
            case TR: {
                return "90";
            }
            case CZ: {
                return "420";
            }
            case LK: {
                return "94";
            }
            case PE: {
                return "51";
            }
            case PK: {
                return "92";
            }
            case NZ: {
                return "64";
            }
            case GQ: {
                return "240";
            }
            case ML: {
                return "223";
            }
            case VE: {
                return "58";
            }
            case ET: {
                return "251";
            }
            default: {
                return "";
            }
        }
    }
    
    public static String getLocaleFromCountryISO(final String countryISO) {
        return countryISO.toLowerCase() + "_" + countryISO.toUpperCase();
    }
    
    public String getCodeCountryForSMSActivateService() {
        return this.name();
    }
    
    @Override
    public String toString() {
        return super.toString() + ", support : " + Arrays.toString(this.supportSmsServices);
    }
    
    public String myToString() {
        return super.toString();
    }
    
    public String getISOCountryForLine() {
        switch (this) {
            case UK: {
                return "GB";
            }
            case IRL: {
                return "IE";
            }
            case KAZ: {
                return "KZ";
            }
            case ROM: {
                return "RO";
            }
            case UKR: {
                return "UA";
            }
            default: {
                return this.name();
            }
        }
    }
    
    public String getLocaleForLine() {
        switch (this) {
            case UK: {
                return "en_GB";
            }
            case IRL: {
                return "ie_IE";
            }
            case KAZ: {
                return "kz_KZ";
            }
            case ROM: {
                return "ro_RO";
            }
            case UKR: {
                return "ua_UA";
            }
            case US: {
                return "us_GB";
            }
            default: {
                return this.name().toLowerCase() + "_" + this.name().toUpperCase();
            }
        }
    }
}
