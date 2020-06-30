// 
// Decompiled by Procyon v0.5.36
// 

package bot.model;

import java.io.FileInputStream;
import java.util.Collection;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.HashMap;
import java.io.IOException;
import com.google.gson.Gson;
import java.io.FileOutputStream;
import java.util.List;
import sample.Main;
import java.util.Map;
import java.net.Proxy;

public class Bot
{
    public static Bot botStore;
    private static String nameBotStoreFile;
    public static boolean isJsonFormatFiles;
    public int QuantityNewUsers;
    public String PathToFolderForSaveNewAccounts;
    public String PathToFileWithNewUsersInfo;
    public String PathToFolderWithProfileImages;
    public String PathToFileWithProxies;
    public Gender Gender;
    public String ApiKeyFromSMSService;
    public Countries CountryFromSMSService;
    public SMSService SMSService;
    public MobileOperator MobileOperator;
    public String PhoneNumberForVerification;
    public String ISOCodeCountryPhone;
    public String VerificationCode;
    public String UserID;
    public String UserName;
    public String UserEmail;
    public String UserPassword;
    public String StatusMessage;
    public String PathToProfileImage;
    public String ProxyHost;
    public int ProxyPort;
    public Proxy.Type ProxyType;
    public String ProxyUser;
    public String ProxyPassword;
    public String PathToFolderWithCreatedAccounts;
    public String PathToFolderForSaveUsers;
    public String FromPhoneNumber;
    public int QuantityPhonesForCheck;
    public String PathToFileWithPhones;
    public String PathToFileWithLineUsers;
    public String PathToFolderForBlockedChannels;
    public String PathToFolderForRepeatRecepients;
    public String PathToFileWithProfileNames;
    public CHANGE_PROFILE_NAME ChangeProfileName;
    public String TextMessage1;
    public String TextMessage2;
    public String TextMessage3;
    public String TextMessage4;
    public String TextMessage5;
    public String PathToImageFile;
    public String PathToVideoFile;
    public String vCard;
    public String PathToFileForAttachement;
    public String PathToAudioFile;
    public int DelayBetweenMessages;
    public String PathToFolderForSaveLogFile;
    public ChooseTypeAutoReplay AutoReplayForAll;
    public String KeywordsForAutoReply;
    public String TextMessage;
    public String PathToFileWithPhonesforScrape;
    public String PathToFolderForSaveScrapeResult;
    public String PhoneNumberForCheck;
    public String ToPhoneNumber;
    private transient Map<Main.State, List<Main.GUIView>> mapWithGUIFields;
    
    public static void storeCurrentState() {
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(Bot.nameBotStoreFile);
            final Gson gson = new Gson();
            final String botStoreJson = gson.toJson((Object)Bot.botStore);
            final byte[] bytesBotStore = botStoreJson.getBytes();
            outputStream.write(bytesBotStore);
        }
        catch (IOException e) {
            e.printStackTrace();
            if (outputStream != null) {
                try {
                    outputStream.flush();
                    outputStream.close();
                }
                catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        finally {
            if (outputStream != null) {
                try {
                    outputStream.flush();
                    outputStream.close();
                }
                catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }
    
    public Bot(final boolean isRestore) {
        this();
        if (isRestore) {
            this.PathToFileWithPhonesforScrape = Bot.botStore.PathToFileWithPhonesforScrape;
            this.PathToFolderForSaveScrapeResult = Bot.botStore.PathToFolderForSaveScrapeResult;
            this.PhoneNumberForCheck = Bot.botStore.PhoneNumberForCheck;
            this.QuantityNewUsers = Bot.botStore.QuantityNewUsers;
            this.PathToFolderForSaveNewAccounts = Bot.botStore.PathToFolderForSaveNewAccounts;
            this.PathToFileWithNewUsersInfo = Bot.botStore.PathToFileWithNewUsersInfo;
            this.PathToFolderWithProfileImages = Bot.botStore.PathToFolderWithProfileImages;
            this.PathToFileWithProxies = Bot.botStore.PathToFileWithProxies;
            this.Gender = Bot.botStore.Gender;
            this.ApiKeyFromSMSService = Bot.botStore.ApiKeyFromSMSService;
            this.CountryFromSMSService = Bot.botStore.CountryFromSMSService;
            this.SMSService = Bot.botStore.SMSService;
            this.MobileOperator = Bot.botStore.MobileOperator;
            this.ISOCodeCountryPhone = Bot.botStore.ISOCodeCountryPhone;
            this.PathToProfileImage = Bot.botStore.PathToProfileImage;
            this.ProxyHost = Bot.botStore.ProxyHost;
            this.ProxyPort = Bot.botStore.ProxyPort;
            this.ProxyType = Bot.botStore.ProxyType;
            this.ProxyUser = Bot.botStore.ProxyUser;
            this.ProxyPassword = Bot.botStore.ProxyPassword;
            this.PathToFolderWithCreatedAccounts = Bot.botStore.PathToFolderWithCreatedAccounts;
            this.PathToFolderForSaveUsers = Bot.botStore.PathToFolderForSaveUsers;
            this.PathToFileWithPhones = Bot.botStore.PathToFileWithPhones;
            this.FromPhoneNumber = Bot.botStore.FromPhoneNumber;
            this.QuantityPhonesForCheck = Bot.botStore.QuantityPhonesForCheck;
            this.ToPhoneNumber = Bot.botStore.ToPhoneNumber;
            this.PathToFileWithLineUsers = Bot.botStore.PathToFileWithLineUsers;
            this.PathToFolderForBlockedChannels = Bot.botStore.PathToFolderForBlockedChannels;
            this.PathToFolderForRepeatRecepients = Bot.botStore.PathToFolderForRepeatRecepients;
            this.PathToFileWithProfileNames = Bot.botStore.PathToFileWithProfileNames;
            this.ChangeProfileName = Bot.botStore.ChangeProfileName;
            this.TextMessage1 = Bot.botStore.TextMessage1;
            this.PathToImageFile = Bot.botStore.PathToImageFile;
            this.PathToVideoFile = Bot.botStore.PathToVideoFile;
            this.vCard = Bot.botStore.vCard;
            this.DelayBetweenMessages = Bot.botStore.DelayBetweenMessages;
            this.TextMessage2 = Bot.botStore.TextMessage2;
            this.TextMessage3 = Bot.botStore.TextMessage3;
            this.TextMessage4 = Bot.botStore.TextMessage4;
            this.TextMessage5 = Bot.botStore.TextMessage5;
            this.PathToFileForAttachement = Bot.botStore.PathToFileForAttachement;
            this.PathToAudioFile = Bot.botStore.PathToAudioFile;
            this.PathToFolderForSaveLogFile = Bot.botStore.PathToFolderForSaveLogFile;
            this.KeywordsForAutoReply = Bot.botStore.KeywordsForAutoReply;
            this.TextMessage = Bot.botStore.TextMessage;
            this.AutoReplayForAll = Bot.botStore.AutoReplayForAll;
        }
    }
    
    private Bot() {
        this.QuantityNewUsers = 1;
        this.Gender = bot.model.Gender.FEMALE;
        this.CountryFromSMSService = Countries.RU;
        this.SMSService = bot.model.SMSService.SMSActivate;
        this.MobileOperator = bot.model.MobileOperator.MTS;
        this.ProxyType = Proxy.Type.HTTP;
        this.ChangeProfileName = CHANGE_PROFILE_NAME.NotChange;
        this.DelayBetweenMessages = 0;
        this.AutoReplayForAll = ChooseTypeAutoReplay.ALLMessages;
        this.mapWithGUIFields = new HashMap<Main.State, List<Main.GUIView>>();
        final List<Main.GUIView> listWithAutoCreateNewUsers = new LinkedList<Main.GUIView>();
        listWithAutoCreateNewUsers.addAll(Arrays.asList(new Main.GUIView("Path To File With Phones for Scrape", "File with list phones for scrape", Main.TYPEFIELD.FileChooser), new Main.GUIView("Path To Folder For Save Scrape Result", "Folder where need store files with existing and don't existing Revolut users", Main.TYPEFIELD.FolderChooserWithShowing), new Main.GUIView("Path To File With Proxies", "File in text format, that contain proxies for scrape actions. If don't set, program will not use proxy\nbut its very not secure using. Format one proxy - host:port:type:user:password, for example 127.0.0.1:8888:http:secretname:secretpassword\nor for proxy without username and password - 127.0.0.1:8888:http", Main.TYPEFIELD.FileChooser)));
        this.mapWithGUIFields.put(Main.State.AutoScrapePhonesState, listWithAutoCreateNewUsers);
        final List<Main.GUIView> listWithManualCreateNewUser = new LinkedList<Main.GUIView>();
        listWithManualCreateNewUser.addAll(Arrays.asList(new Main.GUIView("Phone Number For Check", "Phone number in full international format", Main.TYPEFIELD.SimpleInput), new Main.GUIView("Proxy Host", "Host for your proxy.\nIf don't set, program will work without proxy", Main.TYPEFIELD.SimpleInput), new Main.GUIView("Proxy Port", "Number proxy port. If don't set, program will work without proxy", Main.TYPEFIELD.SimpleInput), new Main.GUIView("Proxy Type", "Type proxy, available HTTP and SOCKS", Main.TYPEFIELD.ChoiseBox), new Main.GUIView("Proxy User", "Authentification user name for your proxy, if requested", Main.TYPEFIELD.SimpleInput), new Main.GUIView("Proxy Password", "Authentification password for your proxy, if requested", Main.TYPEFIELD.SimpleInput)));
        this.mapWithGUIFields.put(Main.State.ManualScrapePhones, listWithManualCreateNewUser);
        final List<Main.GUIView> listWithSearchingUsers = new LinkedList<Main.GUIView>();
        listWithSearchingUsers.addAll(Arrays.asList(new Main.GUIView("Path To Folder With Created Accounts", "Set path to folder with already created accounts/channels", Main.TYPEFIELD.FolderChooserWithShowing), new Main.GUIView("Path To Folder For Blocked Channels", "Set path to folder where program will remove blocked accounts/channels", Main.TYPEFIELD.FolderChooser), new Main.GUIView("Path To Folder For Save Users", "Folder where need story file with data Line users", Main.TYPEFIELD.FolderChooser), new Main.GUIView("Path To File With Proxies", "File in json format, that contain proxy for every account.\nIf don't set, program will not use proxies.\nIf amount proxies in file less, than amount new users, proxies will be repeat", Main.TYPEFIELD.FileChooser), new Main.GUIView("Path To File With Phones", "File, in json format,  that contain list phones .\nIf don't set, program will be use phone generator", Main.TYPEFIELD.FileChooser), new Main.GUIView("From Phone Number", "From this phone, phone generator begin search Line users (inclusive).\n", Main.TYPEFIELD.SimpleInput), new Main.GUIView("Quantity Phones For Check", "How many phones need search, beginning from above phone number", Main.TYPEFIELD.SimpleInput), new Main.GUIView("To Phone Number", "To this phone, phone generator stop search Line users before this phone", Main.TYPEFIELD.SimpleInput)));
        this.mapWithGUIFields.put(Main.State.SearchUsersByPhoneState, listWithSearchingUsers);
        final List<Main.GUIView> listWithSendMessages = new LinkedList<Main.GUIView>();
        listWithSendMessages.addAll(Arrays.asList(new Main.GUIView("Path To Folder With Created Accounts", "Set path to folder with already created accounts/channels", Main.TYPEFIELD.FolderChooserWithShowing), new Main.GUIView("Path To Folder For Blocked Channels", "Set path to folder where program will remove blocked accounts/channels", Main.TYPEFIELD.FolderChooser), new Main.GUIView("Path To Folder For Repeat Recepients", "Set path to folder were program will save file with recepients from  blocked accounts/channels\nYou must repeat send messages for this recepients from not blocked accounts/channels", Main.TYPEFIELD.FolderChooser), new Main.GUIView("Path To File With Line Users", "File, that contain list Line users", Main.TYPEFIELD.FileChooser), new Main.GUIView("Path To Folder For Save Log File", "Set path to folder where program will save log file with conversations", Main.TYPEFIELD.FolderChooser), new Main.GUIView("Path To File With Proxies", "File in json format, that contain proxy for every account.\nIf don't set, program will not use proxies.\nIf amount proxies in file less, than amount new users, proxies will be repeat", Main.TYPEFIELD.FileChooser), new Main.GUIView("Path To Folder With Profile Images", "Folder, that contain new profile images.\nSelect this option, if you want to change the profile image each time before sending the message.\nIf amount images in folder less, than amount channels, images will be repeat", Main.TYPEFIELD.FolderChooser), new Main.GUIView("Change Profile Name", "Select this option, if you want to change the profile name by new random name each time before sending the message", Main.TYPEFIELD.ChoiseBox), new Main.GUIView("Path To File With Profile Names", "File, that contain new profile namess.\nSelect this option, if you want to change the profile name each time before sending the message.\nIf amount names in file less, than amount channels, names will be repeat", Main.TYPEFIELD.FileChooser), new Main.GUIView("Delay Between Messages", "Delay between outcoming messages in seconds", Main.TYPEFIELD.SimpleInput), new Main.GUIView("Text Message1", "Type here text message, that you want include in all messages. Text for current recepient will be randomly choose from all Text Messages. You can input text in any quality Text Messages", Main.TYPEFIELD.MessageText), new Main.GUIView("Text Message2", "Type here text message, that you want include in all messages. Text for current recepient will be randomly choose from all Text Messages. You can input text in any quality Text Messages", Main.TYPEFIELD.MessageText), new Main.GUIView("Text Message3", "Type here text message, that you want include in all messages. Text for current recepient will be randomly choose from all Text Messages. You can input text in any quality Text Messages", Main.TYPEFIELD.MessageText), new Main.GUIView("Text Message4", "Type here text message, that you want include in all messages. Text for current recepient will be randomly choose from all Text Messages. You can input text in any quality Text Messages", Main.TYPEFIELD.MessageText), new Main.GUIView("Text Message5", "Type here text message, that you want include in all messages. Text for current recepient will be randomly choose from all Text Messages. You can input text in any quality Text Messages", Main.TYPEFIELD.MessageText), new Main.GUIView("Path To Image File", "File, that contain image.\nSelect this option, if you want to include image in all messages", Main.TYPEFIELD.FileChooser), new Main.GUIView("Path To Video File", "File, that contain video.\nSelect this option, if you want to include video in all messages", Main.TYPEFIELD.FileChooser), new Main.GUIView("Path To Audio File", "File, that contain audio.\nSelect this option, if you want to include audio in all messages", Main.TYPEFIELD.FileChooser), new Main.GUIView("Path To File For Attachement", "File for attach to message.\nSelect this option, if you want to include this file in all messages. Impotant, LINE support very many format files for attach, I success tried txt, pdf, rar, zip. Don't support apk format, but you can before archive apk into rar and send", Main.TYPEFIELD.FileChooser), new Main.GUIView("vCard", "Set hash number account/channel, if you want send vCard messages", Main.TYPEFIELD.SimpleInput)));
        this.mapWithGUIFields.put(Main.State.AutoSendMessagesState, listWithSendMessages);
        final List<Main.GUIView> listWithReadMessages = new LinkedList<Main.GUIView>();
        listWithReadMessages.addAll(Arrays.asList(new Main.GUIView("Path To Folder With Created Accounts", "Set path to folder with already created accounts/channels", Main.TYPEFIELD.FolderChooserWithShowing), new Main.GUIView("Path To Folder For Save Log File", "Set path to folder where program will save log file with conversations", Main.TYPEFIELD.FolderChooser), new Main.GUIView("Path To Folder For Blocked Channels", "Set path to folder where program will remove blocked accounts/channels", Main.TYPEFIELD.FolderChooser), new Main.GUIView("Path To Folder For Repeat Recepients", "Set path to folder were program will save file with recepients from  blocked accounts/channels\nYou must repeat send messages for this recepients from not blocked accounts/channels", Main.TYPEFIELD.FolderChooser), new Main.GUIView("Path To File With Proxies", "File in json format, that contain proxy for every account.\nIf don't set, program will not use proxies.\nIf amount proxies in file less, than amount new users, proxies will be repeat", Main.TYPEFIELD.FileChooser), new Main.GUIView("Auto Replay For All", "Select,  you want auto replay for all incoming messages or only for messages, contained keywords", Main.TYPEFIELD.ChoiseBox), new Main.GUIView("Keywords For Auto Reply", "Type here keywords through a comma, that you want search in incoming messages for auto replay.\nIf don't set, program will be only manage incoming messages, without auto replay", Main.TYPEFIELD.MessageText), new Main.GUIView("Text Message", "Type here text message, that you want include in all auto reply messages", Main.TYPEFIELD.MessageText), new Main.GUIView("Path To Image File", "File, that contain image.\nSelect this option, if you want to include image in all auto reply messages", Main.TYPEFIELD.FileChooser), new Main.GUIView("Path To Video File", "File, that contain video.\nSelect this option, if you want to include video in all auto reply messages", Main.TYPEFIELD.FileChooser), new Main.GUIView("Path To Audio File", "File, that contain audio.\nSelect this option, if you want to include audio in all auto reply messages", Main.TYPEFIELD.FileChooser), new Main.GUIView("Path To File For Attachement", "File for attach to message.\nSelect this option, if you want to include this file in all auto reply messages. Impotant, LINE support very many format files for attach, I success tried txt, pdf, rar, zip. Don't support apk format, but you can before archive apk into rar and send", Main.TYPEFIELD.FileChooser), new Main.GUIView("vCard", "Set hash number account/channel, if you want send vCard messages", Main.TYPEFIELD.SimpleInput)));
        this.mapWithGUIFields.put(Main.State.ReadIncomingMessagesAndReply, listWithReadMessages);
        final List<Main.GUIView> listWithCheckBlockChannel = new LinkedList<Main.GUIView>();
        listWithCheckBlockChannel.addAll(Arrays.asList(new Main.GUIView("Path To Folder With Created Accounts", "Set path to folder with already created accounts/channels", Main.TYPEFIELD.FolderChooserWithShowing), new Main.GUIView("Path To Folder For Blocked Channels", "Set path to folder where program will remove blocked accounts/channels", Main.TYPEFIELD.FolderChooser), new Main.GUIView("Path To File With Proxies", "File in json format, that contain proxy for every account.\nIf don't set, program will not use proxies.\nIf amount proxies in file less, than amount new users, proxies will be repeat", Main.TYPEFIELD.FileChooser)));
        this.mapWithGUIFields.put(Main.State.CheckBlockChannel, listWithCheckBlockChannel);
    }
    
    public Map<Main.State, List<Main.GUIView>> getGUIMapFields() {
        return this.mapWithGUIFields;
    }
    
    static {
        Bot.botStore = new Bot();
        Bot.nameBotStoreFile = "botStore.store";
        Bot.isJsonFormatFiles = false;
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(Bot.nameBotStoreFile);
            final byte[] bytesBotStore = new byte[inputStream.available()];
            inputStream.read(bytesBotStore);
            final Gson gson = new Gson();
            Bot.botStore = (Bot)gson.fromJson(new String(bytesBotStore), (Class)Bot.class);
        }
        catch (IOException e) {
            e.printStackTrace();
            if (inputStream != null) {
                try {
                    inputStream.close();
                }
                catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                }
                catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
