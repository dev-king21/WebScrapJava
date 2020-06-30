// 
// Decompiled by Procyon v0.5.36
// 

package bot.utils;

import java.util.regex.Pattern;

public class Constants
{
    public static final String POST = "POST";
    public static final String GET = "GET";
    public static final String PUT = "PUT";
    public static final int TIMEOUT = 60000;
    public static final int READTIMEOUT = 60000;
    public static final String CACHE_CONTROL = "Cache-Control";
    public static final String NO_STORE = "no-store";
    public static final String X_API_KEY = "x-api-key";
    public static final String USER_AGENT = "User-Agent";
    public static final String SESSION_ID = "session_id";
    public static final String VERSION = "version";
    public static final String SIGNATURE = "signature";
    public static final String CHARSET = "charset";
    public static final String VALUE_CHARSET = "utf-8";
    public static final String APP_NAME = "app_name";
    public static final String VALUE_APP_NAME = "skout";
    public static final String APP_VERSION = "app_version";
    public static final String APP_DEVICE = "app_device";
    public static final String VALUE_APP_DEVICE = "android";
    public static final String ACCEPT_CHARSET = "Accept-Charset";
    public static final String valueAcceptCharset = "UTF-8";
    public static final String IF_MODIFIED_SINCE = "If-Modified-Since";
    public static final String ACCEPT_ENCODING = "Accept-Encoding";
    public static final String ACCEPT = "Accept";
    public static final String ValueAcceptAny = "*/*";
    public static final String ValueAcceptJson = "application/json";
    public static final String GZIP = "gzip";
    public static final String ValueAcceptEncoding2 = "deflate, gzip";
    public static final String ValueAcceptEncoding3 = "zstd, gzip, deflate";
    public static final String SSOTOKEN = "ssotoken";
    public static String APPKEY;
    public static final String DEVICEID = "deviceId";
    public static final String UNIQUEID = "uniqueId";
    public static final String DEVICETYPE = "devicetype";
    public static final String VERSIONCODE = "versionCode";
    public static final String LANGUAGEID = "languageId";
    public static final String OSVERSION = "osVersion";
    public static final String OS = "os";
    public static final String USERID = "userId";
    public static final String USERGROUP = "usergroup";
    public static final String OKHTTPUSERAGENT = "okhttp/3.6.0";
    public static final String ValueForXTwitterClientVersion = "7.6.0";
    public static final String X_TWITTER_ACTIVE_USER = "X-Twitter-Active-User";
    public static final String ValueForXTwitterActiveUserNo = "no";
    public static final String ValueForXTwitterActiveUserYes = "yes";
    public static final String X_CLIENT_UUID = "X-Client-UUID";
    public static final String AUTHORIZATION = "Authorization";
    public static final String ACCEPT_LANGUAGE = "Accept-Language";
    public static final String ValueForAcceptLanguage = "en-EN";
    public static final String LBCOOKIE = "lbcookie";
    public static final String CONTENT_TYPE = "Content-Type";
    public static final String ValueContentTypeXwwwFormUrlEncoded = "application/x-www-form-urlencoded";
    public static final String ValueContentTypeXml = "application/xml";
    public static final String ValueContentTypeOctet = "application/octet-stream";
    public static final String ValueContentTypeProtobuf = "application/x-protobuf";
    public static final String APPLICATION_JSON_CHARSET_UTF8 = "application/json; charset=UTF-8";
    public static final String CONTENT_LENGTH = "Content-Length";
    public static final String ValueForContentLength = "%d";
    public static final String CONNECTION = "Connection";
    public static final String KeepAlive = "Keep-Alive";
    public static final String CloseConnect = "close";
    public static final String HTTP1_1 = "HTTP/1.1";
    public static final String SPACE = " ";
    public static final String STROKE = "\r\n";
    public static final String HOSTHEADER = "Host";
    public static final String oauthNonce = "oauthNonce";
    public static final String oauthConsumerKey = "oauthConsumerKey";
    public static final String oauthTimestamp = "oauthTimestamp";
    public static final String oauthSignature = "oauthSignature";
    public static final String password = "password";
    public static final String username = "username";
    public static final String alfabet = "abcdefgh12345678";
    public static final String POINT2 = ": ";
    public static final String X_TWITTER_CLIENT_ADID = "X-Twitter-Client-AdID";
    public static final String X_TWITTER_CLIENT_LIMIT_AD_TRACKING = "X-Twitter-Client-Limit-Ad-Tracking";
    public static final String COOKIE = "Cookie";
    public static final String X_GUEST_TOKEN = "X-Guest-Token";
    public static final String KDT = "kdt";
    public static final Pattern contentLengthPattern;
    public static final Pattern locationURLPattern;
    public static final Pattern transferEncodingPattern;
    public static final Pattern contentEncodingPattern;
    public static final Pattern setCookiePattern;
    public static String placeHolderForData;
    
    static {
        Constants.APPKEY = "appkey";
        contentLengthPattern = Pattern.compile("\r\n[Cc]ontent-[Ll]ength: (?<size>.*?)\r\n");
        locationURLPattern = Pattern.compile("\r\n[Ll]ocation: (?<url>.*?)\r\n");
        transferEncodingPattern = Pattern.compile("\r\n[Tt]ransfer-[Ee]ncoding: chunked\r\n");
        contentEncodingPattern = Pattern.compile("\r\n[Cc]ontent-[Ee]ncoding: gzip\r\n");
        setCookiePattern = Pattern.compile("[Ss]et-[Cc]ookie: (?<cookie>.*?);.*?\r\n");
        Constants.placeHolderForData = "PlaceHolder777";
    }
}
