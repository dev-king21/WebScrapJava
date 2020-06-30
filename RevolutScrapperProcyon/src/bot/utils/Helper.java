// 
// Decompiled by Procyon v0.5.36
// 

package bot.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javafx.application.Platform;
import javafx.scene.control.Alert;

public class Helper
{
    public static boolean isFileOrFolderRealExist(final String pathToFileOrFolder, final boolean isFile) {
        final File file = new File(pathToFileOrFolder);
        return (isFile && file.isFile() && file.exists()) || (!isFile && file.isDirectory() && file.exists());
    }
    
    public static boolean isFileOrFolderRealExistWithErrorDialog(final String pathToFileOrFolder, final boolean isFile, final Alert alertWaiting, final String errorMessage) {
        final File file = new File(pathToFileOrFolder);
        if (isFile && file.isFile() && file.exists()) {
            return true;
        }
        if (!isFile && file.isDirectory() && file.exists()) {
            return true;
        }
        Platform.runLater((Runnable)new Runnable() {
            @Override
            public void run() {
                if (alertWaiting != null) {
                    alertWaiting.close();
                }
                final Alert alertDialog = new Alert(Alert.AlertType.ERROR);
                alertDialog.setTitle("ERROR");
                alertDialog.setHeaderText("Error path!");
                alertDialog.setContentText(errorMessage);
                alertDialog.show();
            }
        });
        return false;
    }
    
    public static void showErrorDialog(final Alert alertWaiting, final String alertTitle, final String contextTitle, final String errorMessage) {
        Platform.runLater((Runnable)new Runnable() {
            @Override
            public void run() {
                if (alertWaiting != null) {
                    alertWaiting.close();
                }
                final Alert alertDialog = new Alert(Alert.AlertType.ERROR);
                alertDialog.setTitle(alertTitle);
                alertDialog.setHeaderText(contextTitle);
                alertDialog.setContentText(errorMessage);
                alertDialog.show();
            }
        });
    }
    
    public static void showInfoDialog(final Alert alertWaiting, final String alertTitle, final String contextTitle, final String infoMessage) {
        Platform.runLater((Runnable)new Runnable() {
            @Override
            public void run() {
                if (alertWaiting != null) {
                    alertWaiting.close();
                }
                final Alert alertDialog = new Alert(Alert.AlertType.INFORMATION);
                alertDialog.setTitle(alertTitle);
                alertDialog.setHeaderText(contextTitle);
                alertDialog.setContentText(infoMessage);
                alertDialog.show();
            }
        });
    }
    
    public static ArrayList<String> readFileLines(final String pathToFile, int offsetPage, int szPerPage) {
        try {
        	ArrayList<String> lines = new ArrayList<String>();
            final FileInputStream fis = new FileInputStream(pathToFile);
            final BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
            String readLine;
            int curLine = 0;
            int readedLine = 0;
            while ((readLine = reader.readLine()) != null)   {
                if (curLine++ <= offsetPage * szPerPage) {
                    continue;
                }
            	if (readedLine++ > szPerPage) {
                	break;
                }
            	readLine = readLine.trim();
    			if (!readLine.startsWith("+")) {
    				readLine = "+" + readLine;
                }
                lines.add(readLine);
            }
            reader.close();
            return lines;
        }
        catch (Exception e) {
            return null;
        }
    }
    
    public static String readFileToString(final String pathToFile) {
        try {
            final FileInputStream fileInputStream = new FileInputStream(pathToFile);
            final int sizeFile = fileInputStream.available();
            final byte[] arrayFile = new byte[sizeFile];
            final int realReaded = fileInputStream.read(arrayFile);
            fileInputStream.close();
            if (sizeFile != realReaded) {
                return null;
            }
            return new String(arrayFile);
        }
        catch (Exception e) {
            return null;
        }
    }
    
    public static byte[] readFileToBytes(final String pathToFile) {
        try {
            final FileInputStream fileInputStream = new FileInputStream(pathToFile);
            final int sizeFile = fileInputStream.available();
            final byte[] arrayFile = new byte[sizeFile];
            final int realReaded = fileInputStream.read(arrayFile);
            fileInputStream.close();
            if (sizeFile != realReaded) {
                return null;
            }
            return arrayFile;
        }
        catch (Exception e) {
            return null;
        }
    }
}
