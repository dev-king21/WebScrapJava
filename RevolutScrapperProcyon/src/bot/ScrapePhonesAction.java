// 
// Decompiled by Procyon v0.5.36
// 

package bot;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.google.gson.Gson;

import bot.main.RevolutUser;
import bot.model.Bot;
import bot.model.CancelExecution;
import bot.model.Proxy;
import bot.model.ResultScrapePhones;
import bot.utils.Helper;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import utils.TextUtils;

public class ScrapePhonesAction
{
    private volatile CancelExecution cancel;
    private static int countThreads;
    private ExecutorService executor;
    ExecutorCompletionService<String> completionService;
    private Gson gson;
    private SecureRandom rand;
    
    public ScrapePhonesAction() {
        this.cancel = new CancelExecution();
        this.executor = Executors.newFixedThreadPool(ScrapePhonesAction.countThreads);
        this.completionService = new ExecutorCompletionService<String>(this.executor);
        this.gson = new Gson();
        this.rand = new SecureRandom();
    }
    
    public ResultScrapePhones startManualCreate(final Alert alertWaiting, final Button cancelButton, final TextArea textAreaLog, final Label labelShowAmountAccounts, final Bot bot) throws Exception {
        String phoneNumber = null;
        if (TextUtils.isEmpty(bot.PhoneNumberForCheck)) {
            Helper.showErrorDialog(alertWaiting, "ERROR", "Error phone!", "You must set phone");
            return null;
        }
        phoneNumber = bot.PhoneNumberForCheck;
        if (!phoneNumber.startsWith("+")) {
            phoneNumber = "+" + phoneNumber;
        }
        final String proxyHost = bot.ProxyHost;
        final int proxyPort = bot.ProxyPort;
        final java.net.Proxy.Type type = bot.ProxyType;
        final String proxyUser = bot.ProxyUser;
        final String proxyPassword = bot.ProxyPassword;
        final Proxy proxy = new Proxy(proxyHost, proxyPort, proxyUser, proxyPassword, type);
        final RevolutUser user = new RevolutUser();
        user.setPhoneNumber(phoneNumber);
        for (int i = 0; i < 1; ++i) {
            final Callable<String> callableRegisterOneUser = new Callable<String>() {
                @Override
                public String call() throws Exception {
                    try {
                        return ScrapePhonesAction.this.scrapeOnePhone(user, proxy);
                    }
                    catch (Throwable throwable) {
                        throwable.printStackTrace();
                        throw new Exception(throwable);
                    }
                    finally {
                        user.closeAllResources();
                    }
                }
            };
            this.completionService.submit(callableRegisterOneUser);
        }
        Platform.runLater((Runnable)new Runnable() {
            @Override
            public void run() {
                cancelButton.setOnAction(new EventHandler<ActionEvent>() {
                    public void handle(final ActionEvent event) {
                        ScrapePhonesAction.this.executor.shutdownNow();
                        ScrapePhonesAction.this.cancel.setStopped(true);
                    }
                });
            }
        });
        final ResultScrapePhones result = new ResultScrapePhones();
        final int[] successed = { 0 };
        for (int j = 0; j < 1 && !this.cancel.getStopped(); ++j) {
            Throwable throwable1 = null;
            String resultScrape = null;
            try {
                final Future<String> future = this.completionService.take();
                resultScrape = future.get();
            }
            catch (Throwable throwable2) {
                throwable1 = throwable2;
                throwable2.printStackTrace();
                result.addNewThrowable(throwable2);
            }
            if (!TextUtils.isEmpty(resultScrape)) {
                final String[] res = resultScrape.split(":");
                System.out.println(String.format("Success scrape phone %s, is Revolut user : %s", res[0], res[1]));
                result.addAmountSuccessCreatedAccounts(1);
                result.setResult(resultScrape);
            }
            else {
                System.out.println("Error!!! user don't success created");
                result.addAmountDontSuccessAccounts(1);
            }
            final String finalResultScrape = resultScrape;
            final Throwable finalThrowable = throwable1;
            Platform.runLater((Runnable)new Runnable() {
                @Override
                public void run() {
                    if (!TextUtils.isEmpty(finalResultScrape)) {
                        final String[] res = finalResultScrape.split(":");
                        final int[] val$successed = successed;
                        final int n = 0;
                        ++val$successed[n];
                        textAreaLog.appendText(String.format("Success scrape phone %s, is Revolut user : %s%s", res[0], res[1], "\n"));
                    }
                    else {
                        textAreaLog.appendText("Error!!! user don't success scraped\n");
                        if (finalThrowable != null) {
                            textAreaLog.appendText(finalThrowable.getMessage() + "\n");
                        }
                    }
                }
            });
        }
        this.executor.shutdownNow();
        Platform.runLater((Runnable)new Runnable() {
            @Override
            public void run() {
                alertWaiting.close();
                final StringBuilder throwableBuilder = new StringBuilder();
                for (final Throwable throwable : result.getThrowables()) {
                    throwableBuilder.append(throwable.getMessage()).append("\n");
                }
                final Alert alertDialog = new Alert(Alert.AlertType.INFORMATION);
                alertDialog.setTitle("DONE");
                alertDialog.setHeaderText("Manual scrape finished");
                if (!TextUtils.isEmpty(result.getResult())) {
                    final String[] res = result.getResult().split(":");
                    alertDialog.setContentText(String.format("Success scrape phone %s, is Revolut user : %s%s", res[0], res[1], "\n" + ((ScrapePhonesAction.this.cancel.getStopped() || throwableBuilder.toString().isEmpty()) ? "" : ("\nThrowables\n" + throwableBuilder.toString()))));
                }
                else {
                    alertDialog.setContentText((ScrapePhonesAction.this.cancel.getStopped() || throwableBuilder.toString().isEmpty()) ? "" : ("\nThrowables\n" + throwableBuilder.toString()));
                }
                alertDialog.show();
            }
        });
        return result;
    }
    
    public ResultScrapePhones startAutoCreate(final Alert alertWaiting, final Button cancelButton, final TextArea textAreaLog, final Label labelShowAmountAccounts, final Bot bot) throws Exception {
        return this.executeAutoRegisterNewUsers(alertWaiting, cancelButton, textAreaLog, labelShowAmountAccounts, bot.PathToFolderForSaveScrapeResult, bot.PathToFileWithPhonesforScrape, bot.PathToFileWithProxies);
    }
    
    private ResultScrapePhones executeAutoRegisterNewUsers(final Alert waitingDialog, final Button cancelButton, final TextArea textAreaLog, final Label labelshowAmountAccounts, final String pathToFolderForSaveScrapeResult, final String pathToFileWithPhonesforScrape, final String pathToFileWithProxies) throws Exception {
    	int pgSize = 1000;
    	if (TextUtils.isEmpty(pathToFolderForSaveScrapeResult)) {
            Helper.showErrorDialog(waitingDialog, "ERROR", "Error path!", "You don't set path to folder for save scrape result");
            return null;
        }
        if (!Helper.isFileOrFolderRealExistWithErrorDialog(pathToFolderForSaveScrapeResult, false, waitingDialog, "Can't find folder for save scrape result on this path " + pathToFolderForSaveScrapeResult)) {
            return null;
        }
        final List<RevolutUser> userList = new LinkedList<RevolutUser>();
        if (TextUtils.isEmpty(pathToFileWithPhonesforScrape)) {
            Helper.showErrorDialog(waitingDialog, "ERROR", "Error path!", "You don't set path to file with phones for scrape");
            return null;
        }
        if (!Helper.isFileOrFolderRealExistWithErrorDialog(pathToFileWithPhonesforScrape, true, waitingDialog, "Can't find file with phones on this path " + pathToFileWithPhonesforScrape)) {
            return null;
        }
        
        List<Proxy> proxiesList = new LinkedList<Proxy>();
        if (!TextUtils.isEmpty(pathToFileWithProxies)) {
            if (!Helper.isFileOrFolderRealExistWithErrorDialog(pathToFileWithProxies, true, waitingDialog, "Can't find file with list proxies on this path " + pathToFileWithProxies)) {
                return null;
            }
            final String strProxies = Helper.readFileToString(pathToFileWithProxies);
            if (TextUtils.isEmpty(strProxies)) {
                Helper.showErrorDialog(waitingDialog, "ERROR", "Error in reading file process!", "Proxy files empty");
                return null;
            }
            final String[] split2 = strProxies.split("\r\n");
            for (final String oneRecord : split2) {
                final String[] proxyParts = oneRecord.split(":");
                Label_0621: {
                    if (proxyParts.length >= 2 && !TextUtils.isEmpty(proxyParts[0].trim())) {
                        if (!TextUtils.isEmpty(proxyParts[1].trim())) {
                            final Proxy proxy = new Proxy();
                            proxy.setProxyHost(proxyParts[0].trim());
                            try {
                                proxy.setProxyPort(Integer.decode(proxyParts[1].trim()));
                            }
                            catch (Exception e) {
                                e.printStackTrace();
                                break Label_0621;
                            }
                            if (proxyParts.length > 2) {
                                final String type = proxyParts[2].trim();
                                if (TextUtils.isEmpty(type)) {
                                    proxy.setProxyType(java.net.Proxy.Type.HTTP);
                                }
                                else if (type.equalsIgnoreCase("Socks")) {
                                    proxy.setProxyType(java.net.Proxy.Type.SOCKS);
                                }
                                else {
                                    proxy.setProxyType(java.net.Proxy.Type.HTTP);
                                }
                                if (proxyParts.length > 4) {
                                    proxy.setProxyUser(proxyParts[3].trim());
                                    proxy.setProxyPassword(proxyParts[4].trim());
                                }
                            }
                            else {
                                proxy.setProxyType(java.net.Proxy.Type.HTTP);
                            }
                            proxiesList.add(proxy);
                        }
                    }
                }
            }
        }
        if (proxiesList.size() == 0) {
            proxiesList = null;
        }
        if (proxiesList == null || proxiesList.isEmpty()) {
            this.executor = Executors.newFixedThreadPool(1);
            this.completionService = new ExecutorCompletionService<String>(this.executor);
        }
        
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                cancelButton.setOnAction(new EventHandler<ActionEvent>() {
                    public void handle(final ActionEvent event) {
                        ScrapePhonesAction.this.executor.shutdownNow();
                        ScrapePhonesAction.this.cancel.setStopped(true);
                    }
                });
            }
        });
        
        final String fileNameRealRevolutUser = pathToFolderForSaveScrapeResult + File.separator + "revolutUser.txt";
        final String fileNameNotRevolutUser = pathToFolderForSaveScrapeResult + File.separator + "notUser.txt";
        final ResultScrapePhones result = new ResultScrapePhones();
        final int[] successed = { 0 };
        
        for (int pg = 0; !this.cancel.getStopped(); pg++) {
        	ArrayList<String> phonesList = Helper.readFileLines(pathToFileWithPhonesforScrape, pg, pgSize);
        	userList.clear();
        	if (phonesList == null || phonesList.isEmpty())
        		break;
			/*
			 * if (pg == 6) break;
			 */
        	int cursorUser = pg * pgSize;
        	for (String pnumber: phonesList) {
        		final int userIdx = cursorUser++;
        		final RevolutUser user = new RevolutUser();
        		final List<Proxy> prxList = proxiesList;
                user.setPhoneNumber(pnumber);
                final Callable<String> callableRegisterOneUser = new Callable<String>() {
                    @Override
                    public String call() throws Exception {
                        String result = null;
                        Proxy prx = (prxList != null) ? prxList.get(userIdx % prxList.size()) : null;
                        
                        try {
                            result = ScrapePhonesAction.this.scrapeOnePhone(user, prx);
                        }
                        catch (Throwable throwable) {
                            throwable.printStackTrace();
                            throw new Exception(throwable);
                        }
                        finally {
                            user.closeAllResources();
                        }
                        return result;
                    }
                };
                this.completionService.submit(callableRegisterOneUser);
                
                
        	}
        	
        	for (int i=0; i<phonesList.size(); i++) {
        		Throwable throwable1 = null;
                String resultScrape = null;
                try {
                    final Future<String> future = this.completionService.take();
                    resultScrape = future.get();
                }
                catch (Throwable throwable2) {
                    throwable1 = throwable2;
                    throwable2.printStackTrace();
                    result.addNewThrowable(throwable2);
                }
                if (!TextUtils.isEmpty(resultScrape)) {
                    System.out.println("Success scrape one phone : " + resultScrape);
                    result.addAmountSuccessCreatedAccounts(1);
                    final String[] res = resultScrape.split(":");
                    final String phone = res[0].replace("+", "");
                    final String isUser = res[1];
                    if (isUser.equalsIgnoreCase("YES")) {
                        result.addRevolutUser(1);
                        this.addInFile(fileNameRealRevolutUser, phone);
                    }
                    else {
                        result.addNotRevolutUser(1);
                        this.addInFile(fileNameNotRevolutUser, phone);
                    }
                }
                else {
                    System.out.println("Error!!! Don't success scrape");
                    result.addAmountDontSuccessAccounts(1);
                }
                final String finalResultScrape = resultScrape;
                final Throwable finalThrowable = throwable1;
                Platform.runLater((Runnable)new Runnable() {
                    @Override
                    public void run() {
                        if (!TextUtils.isEmpty(finalResultScrape)) {
                            final int[] val$successed = successed;
                            final int n = 0;
                            ++val$successed[n];
                            final String[] res = finalResultScrape.split(":");
                            textAreaLog.appendText(String.format("%s : success scrape phone  %s with result : %s%s", successed[0], res[0], res[1], "\n"));
                            int currentAmount = Integer.parseInt(labelshowAmountAccounts.getText());
                            ++currentAmount;
                            labelshowAmountAccounts.setText(String.valueOf(currentAmount));
                        }
                        else {
                            textAreaLog.appendText("Error!!! one phone scrape error\n");
                            if (finalThrowable != null) {
                                textAreaLog.appendText(finalThrowable.getMessage() + "\n");
                            }
                        }
                    }
                });
        	}
        }
        
		/*
		 * for (int j = 0; j < amountNewUsers && !this.cancel.getStopped(); ++j) {
		 * 
		 * }
		 */
        this.executor.shutdown();
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                waitingDialog.close();
                final StringBuilder throwableBuilder = new StringBuilder();
                for (final Throwable throwable : result.getThrowables()) {
                    throwableBuilder.append(throwable.getMessage()).append("\n");
                }
                final Alert alertDialog = new Alert(Alert.AlertType.INFORMATION);
                alertDialog.setTitle("DONE");
                alertDialog.setHeaderText("Auto scrape finished");
                alertDialog.setContentText("Auto create result\nSuccess scraped phones = " + result.getAmountSuccessCreatedAccounts() + "\nDidn't success scraped phones = " + result.getAmountDontSuccessAccounts() + "\nFound Revolut user : " + result.getRevolutUserAmount() + "\nNot Revolut user : " + result.getNotRevolutUserAmount() + ((ScrapePhonesAction.this.cancel.getStopped() || throwableBuilder.toString().isEmpty()) ? "" : ("\nThrowables\n" + throwableBuilder.toString())));
                alertDialog.show();
            }
        });
        return result;
    }
    
	public synchronized void addInFile(final String fileName, final String phone) throws IOException {
        final FileOutputStream fileOutputStream = new FileOutputStream(fileName, true);
        fileOutputStream.write(phone.getBytes("UTF-8"));
        fileOutputStream.write("\r\n".getBytes("UTF-8"));
        fileOutputStream.flush();
        fileOutputStream.close();
    }
    
    public String scrapeOnePhone(final RevolutUser user, final Proxy proxy) throws Throwable {
        if (user == null) {
            throw new Exception("You can't put user == null in scrapeOnePhone method");
        }
        if (proxy != null) {
            System.out.println("We set proxy\nHost " + proxy.getProxyHost() + "\nPort " + proxy.getProxyPort() + "\nUser " + proxy.getProxyUser() + "\nPassword " + proxy.getProxyPassword() + "\nType " + proxy.getProxyType());
            user.setProxy(proxy);
        }
        final String result = user.userExistRequest();
        System.out.println("Finish scrapeOnePhone() for number : " + user.getPhoneNumber());
        return result;
    }
    
    public static void main(final String[] args) {
    }
    
    static {
        ScrapePhonesAction.countThreads = 10;
    }
}
