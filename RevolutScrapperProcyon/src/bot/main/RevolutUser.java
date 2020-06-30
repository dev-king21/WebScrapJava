// 
// Decompiled by Procyon v0.5.36
// 

package bot.main;

import bot.utils.PhoneUtils;
import utils.TextUtils;
import java.io.FileInputStream;
import java.io.IOException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileOutputStream;
import bot.utils.Log;
import bot.model.SmsServiceCountry;
import bot.model.MobileOperator;
import bot.model.SMSService;
import java.net.Proxy;

public class RevolutUser implements User
{
    private transient Action action;
    private transient String proxyHost;
    private transient int proxyPort;
    private transient String proxyUser;
    private transient String proxyPassword;
    private transient Proxy.Type proxyType;
    private transient StringBuilder networkLog;
    private transient SMSService smsService;
    private transient MobileOperator mobileOperator;
    private transient SmsServiceCountry smsServiceCountry;
    private String phoneModel;
    private String androidOsVersion;
    private String phoneNumber;
    private String phoneManufacture;
    private String FCMToken;
    private String deviceId;
    private String passcode;
    private String accessToken;
    private String userId;
    private boolean alreadyDoneOTPverification;
    
    public RevolutUser() {
        this.networkLog = new StringBuilder();
        this.action = new Action(this);
    }
    
    public String userExistRequest() throws Exception {
        return this.action.userExistRequest();
    }
    
    Action getAction() {
        return this.action;
    }
    
    public static void saveLoggingState(final RevolutUser user, final String pathToFileForSaveLoggingState) throws IOException {
        if (user == null) {
            return;
        }
        Log.log("Save logging state Json");
        final FileOutputStream fileOutputStream = new FileOutputStream(pathToFileForSaveLoggingState);
        final Gson gson = new GsonBuilder().setPrettyPrinting().create();
        final String stringJson = gson.toJson((Object)user);
        fileOutputStream.write(stringJson.getBytes());
        fileOutputStream.flush();
        fileOutputStream.close();
    }
    
    public static RevolutUser restoreLoggingState(final String pathToFileWithSavedLoggingState) throws IOException {
        Log.log("Restore logging state");
        final FileInputStream fileInputStream = new FileInputStream(pathToFileWithSavedLoggingState);
        final int sizeImage = fileInputStream.available();
        final byte[] jsonBytes = new byte[sizeImage];
        final int realReaded = fileInputStream.read(jsonBytes);
        fileInputStream.close();
        if (realReaded != sizeImage) {
            throw new IOException("Something wrong in restoreLoggingState, size file don't match real reading bytes");
        }
        final Gson gson = new Gson();
        final RevolutUser user = (RevolutUser)gson.fromJson(new String(jsonBytes), (Class)RevolutUser.class);
        return user;
    }
    
    public void setProxyHost(final String proxyHost) {
        this.proxyHost = proxyHost;
    }
    
    public void setProxyPort(final int proxyPort) {
        this.proxyPort = proxyPort;
    }
    
    public void setProxyUser(final String proxyUser) {
        this.proxyUser = proxyUser;
    }
    
    public void setProxyPassword(final String proxyPassword) {
        this.proxyPassword = proxyPassword;
    }
    
    public void setProxyType(final Proxy.Type proxyType) {
        this.proxyType = proxyType;
    }
    
    @Override
    public String getProxyHost() {
        return this.proxyHost;
    }
    
    @Override
    public int getProxyPort() {
        return this.proxyPort;
    }
    
    @Override
    public Proxy.Type getProxyType() {
        return this.proxyType;
    }
    
    @Override
    public String getProxyUser() {
        return this.proxyUser;
    }
    
    @Override
    public String getProxyPassword() {
        return this.proxyPassword;
    }
    
    @Override
    public SMSService getSMSService() {
        return this.smsService;
    }
    
    @Override
    public MobileOperator getMobileOperator() {
        return this.mobileOperator;
    }
    
    @Override
    public SmsServiceCountry getCountryForSmsService() {
        return this.smsServiceCountry;
    }
    
    @Override
    public void setProxy(final bot.model.Proxy proxy) {
        if (!TextUtils.isEmpty(proxy.getProxyHost()) && proxy.getProxyPort() != null) {
            this.proxyHost = proxy.getProxyHost();
            this.proxyPort = proxy.getProxyPort();
            if (proxy.getProxyType() != null) {
                this.proxyType = proxy.getProxyType();
            }
            else {
                this.proxyType = Proxy.Type.HTTP;
            }
            if (!TextUtils.isEmpty(proxy.getProxyUser()) && !TextUtils.isEmpty(proxy.getProxyPassword())) {
                this.proxyUser = proxy.getProxyUser();
                this.proxyPassword = proxy.getProxyPassword();
            }
        }
    }
    
    public void setSmsService(final SMSService smsService) {
        this.smsService = smsService;
    }
    
    public void setMobileOperator(final MobileOperator mobileOperator) {
        this.mobileOperator = mobileOperator;
    }
    
    public void setSmsServiceCountry(final SmsServiceCountry smsServiceCountry) {
        this.smsServiceCountry = smsServiceCountry;
    }
    
    public String getPhoneModel() {
        if (TextUtils.isEmpty(this.phoneModel)) {
            this.phoneModel = PhoneUtils.getRandomPhoneModel();
        }
        return this.phoneModel;
    }
    
    public void setPhoneModel(final String phoneModel) {
        this.phoneModel = phoneModel;
    }
    
    public String getAndroidOsVersion() {
        if (TextUtils.isEmpty(this.androidOsVersion)) {
            this.androidOsVersion = PhoneUtils.getRandomAndroidOS();
        }
        return this.androidOsVersion;
    }
    
    public void setAndroidOsVersion(final String androidOsVersion) {
        this.androidOsVersion = androidOsVersion;
    }
    
    public String getPhoneNumber() {
        if (TextUtils.isEmpty(this.phoneNumber)) {
            this.phoneNumber = PhoneUtils.getUSAPhoneNumberWithoutCountryCode();
        }
        return this.phoneNumber;
    }
    
    public void setPhoneNumber(final String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    public void closeAllResources() {
        this.action.closeAllResources();
        System.gc();
    }
    
    public String getPhoneManufacture() {
        if (TextUtils.isEmpty(this.phoneManufacture)) {
            this.phoneManufacture = PhoneUtils.getRandomPhoneManufacture();
        }
        return this.phoneManufacture;
    }
    
    public void setPhoneManufacture(final String phoneManufacture) {
        this.phoneManufacture = phoneManufacture;
    }
    
    public String getFCMToken() {
        if (TextUtils.isEmpty(this.FCMToken)) {
            this.FCMToken = PhoneUtils.getRandomGCMToken();
        }
        return this.FCMToken;
    }
    
    public void setFCMToken(final String fcmToken) {
        this.FCMToken = fcmToken;
    }
    
    public String getDeviceId() {
        if (TextUtils.isEmpty(this.deviceId)) {
            this.deviceId = PhoneUtils.getRandomAndroidID();
        }
        return this.deviceId;
    }
    
    public void setDeviceId(final String deviceId) {
        this.deviceId = deviceId;
    }
    
    public void setPasscode(final String passcode) {
        this.passcode = passcode;
    }
    
    public String getPasscode() {
        return this.passcode;
    }
    
    public void setAccessToken(final String accessToken) {
        this.accessToken = accessToken;
    }
    
    public String getAccessToken() {
        return this.accessToken;
    }
    
    public void setUserId(final String userId) {
        this.userId = userId;
    }
    
    public String getUserId() {
        return this.userId;
    }
    
    public void setAlreadyDoneOTPverification(final boolean alreadyDoneOTPverification) {
        this.alreadyDoneOTPverification = alreadyDoneOTPverification;
    }
    
    public boolean isAlreadyDoneOTPverification() {
        return this.alreadyDoneOTPverification;
    }
    
    static {
        System.setProperty("jdk.http.auth.tunneling.disabledSchemes", "");
    }
}
