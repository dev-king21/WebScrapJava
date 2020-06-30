// 
// Decompiled by Procyon v0.5.36
// 

package sample;

import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;

import com.google.gson.Gson;

import bot.ScrapePhonesAction;
import bot.model.Bot;
import bot.model.Friends;
import bot.model.ResultScrapePhones;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Effect;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import utils.TextUtils;

public class Main extends Application
{
    private Stage primaryStage;
    private TabPane tabPane;
    public static int TabHeigth;
    public static int TabWidth;
    public static int WidthTextFields;
    public static int HeigthTextFields;
    private static String CreateNewUsers;
    private static String SearchUsers;
    private static String SendMessages;
    private static String ReadIncomingMessages;
    private static String Settings;
    private static String AppName;
    private static String AutoScrapePhones;
    private static String ManualScrapePhones;
    private static String SearchUsersByPhone;
    private static String SearchUsersByUserID;
    private static String SearchUsersByName;
    private static String AutoSendMessages;
    private static String ManualSendMessages;
    private static String ReadMessages;
    private static String ProxySettins;
    private static String SmsServiceSet;
    private static String CheckBlock;
    private static String UpdateCurrencies;
    private String CheckFlaggedAsCheater;
    private static String RunCommand;
    private VBox vBox;
    private MenuBar menuBar;
    private VBox mainVBox;
    private String NextUser;
    private Button buttonNextUser;
    private String Choose;
    private String Set;
    private String Cancel;
    private HBox mainHBox;
    private String LoggingArea;
    private List<HolderGUIField> listWithCurrentFields;
    private State currentState;
    
    public Main() {
        this.CheckFlaggedAsCheater = "Cheater Checking";
        this.NextUser = "Next User";
        this.Choose = "Choose";
        this.Set = "Set";
        this.Cancel = "Cancel";
        this.LoggingArea = "Logging Area";
    }
    
    public static void main(final String[] args) {
        launch(args);
    }
    
    public void start(final Stage primaryStage) throws Exception {
        (this.primaryStage = primaryStage).setTitle(Main.AppName);
        (this.vBox = new VBox()).setAlignment(Pos.CENTER);
        this.vBox.setSpacing(10.0);
        this.vBox.setPadding(new Insets(0.0, 10.0, 0.0, 10.0));
        (this.mainVBox = new VBox()).setAlignment(Pos.TOP_CENTER);
        this.mainVBox.setSpacing(10.0);
        final Scene scene = new Scene((Parent)this.mainVBox, (double)Main.TabWidth, (double)Main.TabHeigth);
        scene.setFill((Paint)Color.OLDLACE);
        this.menuBar = new MenuBar();
        final Menu menuScrapePhones = new Menu(Main.CreateNewUsers);
        final Menu menuSearchUsers = new Menu(Main.SearchUsers);
        final Menu menuSendMessages = new Menu(Main.SendMessages);
        final Menu menuReadIncomingMessages = new Menu(Main.ReadIncomingMessages);
        final Menu menuSettings = new Menu(Main.Settings);
        final Menu menuCheckBlock = new Menu(Main.CheckBlock);
        this.menuBar.getMenus().addAll(new Menu[] { menuScrapePhones });
        ((VBox)scene.getRoot()).getChildren().addAll(new Node[] { (Node)this.menuBar, (Node)this.vBox });
        for (final State state : State.values()) {
            final MenuItem menuItem = new MenuItem(state.getName());
            menuItem.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(final ActionEvent event) {
                    if (Main.this.currentState == state) {
                        return;
                    }
                    Main.this.currentState = state;
                    switch (state) {
                        case AutoScrapePhonesState: {
                            Main.this.updateGUI();
                            break;
                        }
                        case ManualScrapePhones: {
                            Main.this.updateGUI();
                            break;
                        }
                    }
                }
            });
            Menu menu = null;
            switch (state) {
                case AutoScrapePhonesState:
                case ManualScrapePhones: {
                    menu = menuScrapePhones;
                    break;
                }
            }
            if (menu != null) {
                menu.getItems().addAll(new MenuItem[] { menuItem });
            }
        }
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private void checkBlockChannels() {
        this.updateGUI();
    }
    
    private void showReadIncomingMessagesAndReply() {
        this.updateGUI();
    }
    
    private void showSmsServiceSetting() {
    }
    
    private void showProxySetting() {
    }
    
    private void showManualSendMessages() {
    }
    
    private void showAutoSendMessages() {
        this.updateGUI();
    }
    
    private void showSearchUsersByUserName() {
    }
    
    private void showSearchUsersByUserId() {
    }
    
    private void showSearchUsersByPhoneState() {
        this.updateGUI();
    }
    
    private void showManualCreateNewUser() {
    }
    
    private void updateGUI() {
        try {
            Bot.storeCurrentState();
            this.listWithCurrentFields = new LinkedList<HolderGUIField>();
            final Bot bot = new Bot(true);
            final List<GUIView> listWithCurrentGUIViews = bot.getGUIMapFields().get(this.currentState);
            this.mainVBox.getChildren().remove((Object)this.vBox);
            (this.vBox = new VBox()).setAlignment(Pos.CENTER);
            this.vBox.setSpacing(10.0);
            this.vBox.setPadding(new Insets(0.0, 10.0, 0.0, 10.0));
            this.mainVBox.getChildren().addAll(new Node[] { (Node)this.vBox });
            final Label title = new Label(this.currentState.getDescribtion());
            this.vBox.getChildren().addAll(new Node[] { (Node)title });
            final ScrollPane scrollPane = new ScrollPane();
            scrollPane.setFitToWidth(true);
            final GridPane grid = new GridPane();
            grid.setPadding(new Insets(10.0, 10.0, 10.0, 10.0));
            grid.setVgap(5.0);
            grid.setHgap(5.0);
            int row = 1;
            Label labelShowAmountAccounts = null;
            Label labelShowQuantityLineUsers = null;
            TextField toPhoneNumberEditField = null;
            for (final GUIView guiView : listWithCurrentGUIViews) {
                final Label labelField = new Label(guiView.getNameField());
                GridPane.setConstraints((Node)labelField, 0, row);
                grid.getChildren().add(labelField);
                final Tooltip tooltip = new Tooltip();
                tooltip.setText(guiView.getToolTip());
                tooltip.activatedProperty();
                labelField.setTooltip(tooltip);
                switch (guiView.getTypeField()) {
                    case SimpleInput: {
                        final TextField editField = new TextField();
                        final Tooltip tooltip2 = new Tooltip();
                        tooltip2.setText(guiView.getToolTip());
                        tooltip2.activatedProperty();
                        editField.setTooltip(tooltip2);
                        editField.setPrefColumnCount(Main.WidthTextFields);
                        final Field field = Bot.class.getDeclaredField(guiView.getNameField().replaceAll("-", "").replaceAll(" ", ""));
                        if (field.getName().equalsIgnoreCase("ToPhoneNumber")) {
                            toPhoneNumberEditField = editField;
                        }
                        field.setAccessible(true);
                        final Object valueField = field.get(bot);
                        editField.setText((valueField == null) ? "" : valueField.toString());
                        GridPane.setConstraints((Node)editField, 1, row++);
                        grid.getChildren().add(editField);
                        this.listWithCurrentFields.add(new HolderGUIField((Control)editField, field, guiView.getTypeField()));
                        continue;
                    }
                    case ConfirmSimple: {
                        final TextField editField = new TextField();
                        final Tooltip tooltip2 = new Tooltip();
                        tooltip2.setText(guiView.getToolTip());
                        tooltip2.activatedProperty();
                        editField.setTooltip(tooltip2);
                        editField.setPrefColumnCount(Main.WidthTextFields);
                        final Field field = Bot.class.getDeclaredField(guiView.getNameField().replaceAll("-", "").replaceAll(" ", ""));
                        field.setAccessible(true);
                        final Object valueField = field.get(bot);
                        editField.setText((valueField == null) ? "" : valueField.toString());
                        GridPane.setConstraints((Node)editField, 1, row);
                        grid.getChildren().add(editField);
                        final Button buttonConfirm = new Button(this.Set);
                        final DropShadow shadow = new DropShadow();
                        buttonConfirm.addEventHandler(MouseEvent.MOUSE_ENTERED, (EventHandler)new EventHandler<MouseEvent>() {
                            public void handle(final MouseEvent e) {
                                buttonConfirm.setEffect((Effect)shadow);
                            }
                        });
                        buttonConfirm.addEventHandler(MouseEvent.MOUSE_EXITED, (EventHandler)new EventHandler<MouseEvent>() {
                            public void handle(final MouseEvent e) {
                                buttonConfirm.setEffect((Effect)null);
                            }
                        });
                        buttonConfirm.setOnAction((EventHandler)new EventHandler<ActionEvent>() {
                            public void handle(final ActionEvent event) {
                                final String value = editField.getText().trim();
                                try {
                                    field.set(bot, value);
                                }
                                catch (IllegalAccessException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                        GridPane.setConstraints((Node)buttonConfirm, 2, row++);
                        grid.getChildren().add(buttonConfirm);
                        this.listWithCurrentFields.add(new HolderGUIField((Control)editField, field, guiView.getTypeField()));
                        continue;
                    }
                    case MessageText: {
                        final TextArea textArea = new TextArea();
                        final Tooltip tooltip2 = new Tooltip();
                        tooltip2.setText(guiView.getToolTip());
                        tooltip2.activatedProperty();
                        textArea.setTooltip(tooltip2);
                        textArea.setPrefColumnCount(Main.WidthTextFields);
                        textArea.setWrapText(true);
                        textArea.setPrefRowCount(Main.HeigthTextFields);
                        final Field field = Bot.class.getDeclaredField(guiView.getNameField().replaceAll("-", "").replaceAll(" ", ""));
                        field.setAccessible(true);
                        final Object valueField = field.get(bot);
                        textArea.setText((valueField == null) ? "" : valueField.toString());
                        GridPane.setConstraints((Node)textArea, 1, row++);
                        grid.getChildren().add(textArea);
                        this.listWithCurrentFields.add(new HolderGUIField((Control)textArea, field, guiView.getTypeField()));
                        continue;
                    }
                    case FolderChooserWithShowing:
                    case FolderChooserWithShowingFoundedLineUsers:
                    case FolderChooser:
                    case FileChooser: {
                        final TextField editField = new TextField();
                        final Tooltip tooltip2 = new Tooltip();
                        tooltip2.setText(guiView.getToolTip());
                        tooltip.activatedProperty();
                        editField.setTooltip(tooltip2);
                        editField.setPrefColumnCount(Main.WidthTextFields);
                        final Field field = Bot.class.getDeclaredField(guiView.getNameField().replaceAll("-", "").replaceAll(" ", ""));
                        field.setAccessible(true);
                        final Object valueField = field.get(bot);
                        editField.setText((valueField == null) ? "" : valueField.toString());
                        GridPane.setConstraints((Node)editField, 1, row);
                        grid.getChildren().add(editField);
                        final Button buttonChooseFile = new Button(this.Choose);
                        final DropShadow shadow = new DropShadow();
                        buttonChooseFile.addEventHandler(MouseEvent.MOUSE_ENTERED, (EventHandler)new EventHandler<MouseEvent>() {
                            public void handle(final MouseEvent e) {
                                buttonChooseFile.setEffect((Effect)shadow);
                            }
                        });
                        buttonChooseFile.addEventHandler(MouseEvent.MOUSE_EXITED, (EventHandler)new EventHandler<MouseEvent>() {
                            public void handle(final MouseEvent e) {
                                buttonChooseFile.setEffect((Effect)null);
                            }
                        });
                        if (guiView.getTypeField() == TYPEFIELD.FolderChooserWithShowing) {
                            labelShowAmountAccounts = new Label();
                            labelShowAmountAccounts.setTooltip(new Tooltip("How many accounts in this folder"));
                            if (!TextUtils.isEmpty(editField.getText())) {
                                final File file = new File(editField.getText().trim());
                                if (file.exists() && file.isDirectory()) {
                                    final File[] listFiles = file.listFiles(new FilenameFilter() {
                                        @Override
                                        public boolean accept(final File dir, final String name) {
                                            return name.contains(".line");
                                        }
                                    });
                                    labelShowAmountAccounts.setText(String.valueOf((listFiles == null) ? 0 : listFiles.length));
                                }
                            }
                        }
                        if (guiView.getTypeField() == TYPEFIELD.FolderChooserWithShowingFoundedLineUsers) {
                            labelShowQuantityLineUsers = new Label();
                            labelShowQuantityLineUsers.setTooltip(new Tooltip("How many Line users in this folder"));
                            if (!TextUtils.isEmpty(editField.getText())) {
                                final File file = new File(editField.getText().trim());
                                if (file.exists() && file.isDirectory()) {
                                    final File[] listFiles = file.listFiles(new FilenameFilter() {
                                        @Override
                                        public boolean accept(final File dir, final String name) {
                                            return name.contains(".usersline");
                                        }
                                    });
                                    final Gson gson = new Gson();
                                    int quantityLineUsers = 0;
                                    for (final File fileName : listFiles) {
                                        try {
                                            final FileInputStream inputStream = new FileInputStream(fileName);
                                            final byte[] jsonBytes = new byte[inputStream.available()];
                                            inputStream.read(jsonBytes);
                                            inputStream.close();
                                            final Friends friends = (Friends)gson.fromJson(new String(jsonBytes), (Class)Friends.class);
                                            if (friends != null) {
                                                quantityLineUsers += friends.getListFriends().size();
                                            }
                                        }
                                        catch (Exception e) {
                                            final Alert alertDialog = new Alert(Alert.AlertType.ERROR);
                                            alertDialog.setTitle("ERROR!");
                                            alertDialog.setHeaderText("Error Message");
                                            alertDialog.setContentText("Something wrong! " + e.toString());
                                        }
                                    }
                                    labelShowQuantityLineUsers.setText(String.valueOf(quantityLineUsers));
                                }
                            }
                        }
                        final Label finalLabelShowAmountAccounts = labelShowAmountAccounts;
                        final Label finalLabelShowQuantityLineUsers1 = labelShowQuantityLineUsers;
                        buttonChooseFile.setOnAction((EventHandler)new EventHandler<ActionEvent>() {
                            public void handle(final ActionEvent event) {
                                File file = null;
                                switch (guiView.getTypeField()) {
                                    case FolderChooserWithShowing:
                                    case FolderChooserWithShowingFoundedLineUsers:
                                    case FolderChooser: {
                                        final DirectoryChooser directoryChooser = new DirectoryChooser();
                                        final String currentFolder = editField.getText().trim();
                                        if (!TextUtils.isEmpty(currentFolder)) {
                                            final File currentFolderFile = new File(currentFolder);
                                            if (currentFolderFile.exists() && currentFolderFile.isDirectory()) {
                                                directoryChooser.setInitialDirectory(new File(currentFolder));
                                            }
                                        }
                                        file = directoryChooser.showDialog((Window)Main.this.primaryStage);
                                        if (file != null) {
                                            switch (guiView.getTypeField()) {
                                                case FolderChooserWithShowing: {
                                                    final File[] listFiles = file.listFiles(new FilenameFilter() {
                                                        @Override
                                                        public boolean accept(final File dir, final String name) {
                                                            return name.contains(".line");
                                                        }
                                                    });
                                                    finalLabelShowAmountAccounts.setText((listFiles == null) ? "0" : String.valueOf(listFiles.length));
                                                    break;
                                                }
                                                case FolderChooserWithShowingFoundedLineUsers: {
                                                    final File[] listFiles = file.listFiles(new FilenameFilter() {
                                                        @Override
                                                        public boolean accept(final File dir, final String name) {
                                                            return name.contains(".usersline");
                                                        }
                                                    });
                                                    final Gson gson = new Gson();
                                                    int quantityLineUsers = 0;
                                                    for (final File fileName : listFiles) {
                                                        try {
                                                            final FileInputStream inputStream = new FileInputStream(fileName);
                                                            final byte[] jsonBytes = new byte[inputStream.available()];
                                                            inputStream.read(jsonBytes);
                                                            inputStream.close();
                                                            final Friends friends = (Friends)gson.fromJson(new String(jsonBytes), (Class)Friends.class);
                                                            if (friends != null) {
                                                                quantityLineUsers += friends.getListFriends().size();
                                                            }
                                                        }
                                                        catch (Exception e) {
                                                            final Alert alertDialog = new Alert(Alert.AlertType.ERROR);
                                                            alertDialog.setTitle("ERROR!");
                                                            alertDialog.setHeaderText("Error Message");
                                                            alertDialog.setContentText("Something wrong! " + e.toString());
                                                            alertDialog.show();
                                                        }
                                                    }
                                                    finalLabelShowQuantityLineUsers1.setText(String.valueOf(quantityLineUsers));
                                                    break;
                                                }
                                            }
                                            break;
                                        }
                                        break;
                                    }
                                    case FileChooser: {
                                        final FileChooser fileChooser = new FileChooser();
                                        final String currentFile = editField.getText().trim();
                                        if (!TextUtils.isEmpty(currentFile)) {
                                            final File currentFolderFile2 = new File(currentFile);
                                            if (currentFolderFile2.exists() && currentFolderFile2.isFile()) {
                                                final File dirFolder = currentFolderFile2.getAbsoluteFile().getParentFile();
                                                if (dirFolder != null && dirFolder.exists() && dirFolder.isDirectory()) {
                                                    fileChooser.setInitialDirectory(dirFolder);
                                                }
                                            }
                                        }
                                        file = fileChooser.showOpenDialog((Window)Main.this.primaryStage);
                                        break;
                                    }
                                }
                                if (file != null) {
                                    editField.setText(file.getAbsolutePath());
                                }
                            }
                        });
                        GridPane.setConstraints((Node)buttonChooseFile, 2, row++);
                        grid.getChildren().add(buttonChooseFile);
                        if (guiView.getTypeField() == TYPEFIELD.FolderChooserWithShowing || guiView.getTypeField() == TYPEFIELD.FolderChooserWithShowingFoundedLineUsers) {
                            --row;
                            Label label = null;
                            switch (guiView.getTypeField()) {
                                case FolderChooserWithShowing: {
                                    label = labelShowAmountAccounts;
                                    break;
                                }
                                case FolderChooserWithShowingFoundedLineUsers: {
                                    label = labelShowQuantityLineUsers;
                                    break;
                                }
                            }
                            GridPane.setConstraints((Node)label, 3, row++);
                            grid.getChildren().add(label);
                        }
                        this.listWithCurrentFields.add(new HolderGUIField((Control)editField, field, guiView.getTypeField()));
                        continue;
                    }
                    case ChoiseBox: {
                        final Field field2 = Bot.class.getDeclaredField(guiView.getNameField().replaceAll("-", "").replaceAll(" ", ""));
                        field2.setAccessible(true);
                        final Object valueField2 = field2.get(bot);
                        final Class classField = field2.getType();
                        final Object[] enumValues = classField.getEnumConstants();
                        final ChoiceBox choiceBox = new ChoiceBox();
                        choiceBox.setItems(FXCollections.observableArrayList(enumValues));
                        choiceBox.setValue(valueField2);
                        final Tooltip tooltip3 = new Tooltip();
                        tooltip3.setText(guiView.getToolTip());
                        tooltip.activatedProperty();
                        choiceBox.setTooltip(tooltip3);
                        GridPane.setConstraints((Node)choiceBox, 1, row++);
                        grid.getChildren().add(choiceBox);
                        this.listWithCurrentFields.add(new HolderGUIField((Control)choiceBox, field2, guiView.getTypeField()));
                        continue;
                    }
                }
            }
            scrollPane.setContent((Node)grid);
            final ScrollPane scrollPaneLog = new ScrollPane();
            final TextArea textAreaLog = new TextArea();
            textAreaLog.setEditable(false);
            textAreaLog.setPrefWidth((double)(Main.TabWidth / 2));
            textAreaLog.setPrefHeight((double)Main.TabHeigth);
            textAreaLog.setWrapText(true);
            scrollPaneLog.setContent((Node)textAreaLog);
            final DropShadow shadow2 = new DropShadow();
            final Button buttonCancel = new Button();
            buttonCancel.setText(this.Cancel);
            buttonCancel.addEventHandler(MouseEvent.MOUSE_ENTERED, (EventHandler)new EventHandler<MouseEvent>() {
                public void handle(final MouseEvent e) {
                    buttonCancel.setEffect((Effect)shadow2);
                }
            });
            buttonCancel.addEventHandler(MouseEvent.MOUSE_EXITED, (EventHandler)new EventHandler<MouseEvent>() {
                public void handle(final MouseEvent e) {
                    buttonCancel.setEffect((Effect)null);
                }
            });
            buttonCancel.setVisible(false);
            final Button buttonStartAutoCreate = new Button();
            buttonStartAutoCreate.setText(Main.RunCommand);
            buttonStartAutoCreate.addEventHandler(MouseEvent.MOUSE_ENTERED, (EventHandler)new EventHandler<MouseEvent>() {
                public void handle(final MouseEvent e) {
                    buttonStartAutoCreate.setEffect((Effect)shadow2);
                }
            });
            buttonStartAutoCreate.addEventHandler(MouseEvent.MOUSE_EXITED, (EventHandler)new EventHandler<MouseEvent>() {
                public void handle(final MouseEvent e) {
                    buttonStartAutoCreate.setEffect((Effect)null);
                }
            });
            final Label finalLabelShowAmountAccounts2 = labelShowAmountAccounts;
            final Label finalLabelShowQuantityLineUsers2 = labelShowQuantityLineUsers;
            final TextField finalToPhoneNumberEditField = toPhoneNumberEditField;
            buttonStartAutoCreate.setOnAction((EventHandler)new EventHandler<ActionEvent>() {
                public void handle(final ActionEvent event) {
                    Bot.storeCurrentState();
                    buttonStartAutoCreate.setVisible(false);
                    textAreaLog.clear();
                    for (final HolderGUIField holderGUIField : Main.this.listWithCurrentFields) {
                        switch (holderGUIField.getTypefield()) {
                            case FolderChooserWithShowing:
                            case FolderChooserWithShowingFoundedLineUsers:
                            case FolderChooser:
                            case FileChooser:
                            case SimpleInput: {
                                final TextField textField = (TextField)holderGUIField.getControl();
                                final Field field = holderGUIField.getField();
                                field.setAccessible(true);
                                final String value = textField.getText();
                                final Class<?> type = field.getType();
                                try {
                                    if (type.isAssignableFrom(String.class)) {
                                        field.set(bot, value);
                                        field.set(Bot.botStore, value);
                                    }
                                    if (type.isAssignableFrom(Integer.TYPE)) {
                                        field.set(bot, Integer.valueOf(TextUtils.isEmpty(value) ? "0" : value));
                                        field.set(Bot.botStore, Integer.valueOf(TextUtils.isEmpty(value) ? "0" : value));
                                    }
                                    if (type.isAssignableFrom(Boolean.TYPE)) {
                                        field.set(bot, Boolean.valueOf(TextUtils.isEmpty(value) ? "false" : value));
                                        field.set(Bot.botStore, Boolean.valueOf(TextUtils.isEmpty(value) ? "false" : value));
                                    }
                                    System.out.println("Set value " + value + "  for field " + field.getName());
                                    continue;
                                }
                                catch (Exception e) {
                                    final Alert alertDialog = new Alert(Alert.AlertType.ERROR);
                                    alertDialog.setTitle("ERROR!");
                                    alertDialog.setHeaderText("Error Message");
                                    alertDialog.setContentText("Something wrong! " + e.toString());
                                    alertDialog.show();
                                    buttonStartAutoCreate.setVisible(true);
                                    return;
                                }
                            }
                            case ChoiseBox: {
                                final ChoiceBox choiceBox = (ChoiceBox)holderGUIField.getControl();
                                final Object value2 = choiceBox.getValue();
                                final Field field2 = holderGUIField.getField();
                                field2.setAccessible(true);
                                try {
                                    field2.set(bot, value2);
                                    field2.set(Bot.botStore, value2);
                                    continue;
                                }
                                catch (Exception e2) {
                                    final Alert alertDialog2 = new Alert(Alert.AlertType.ERROR);
                                    alertDialog2.setTitle("ERROR!");
                                    alertDialog2.setHeaderText("Error Message");
                                    alertDialog2.setContentText("Something wrong! " + e2.toString());
                                    alertDialog2.show();
                                    buttonStartAutoCreate.setVisible(true);
                                    return;
                                }
                            }
                            case MessageText: {
                                final TextArea textArea = (TextArea)holderGUIField.getControl();
                                final String value3 = textArea.getText();
                                final Field field2 = holderGUIField.getField();
                                field2.setAccessible(true);
                                try {
                                    field2.set(bot, value3);
                                    field2.set(Bot.botStore, value3);
                                }
                                catch (Exception e2) {
                                    final Alert alertDialog2 = new Alert(Alert.AlertType.ERROR);
                                    alertDialog2.setTitle("ERROR!");
                                    alertDialog2.setHeaderText("Error Message");
                                    alertDialog2.setContentText("Something wrong! " + e2.toString());
                                    alertDialog2.show();
                                    buttonStartAutoCreate.setVisible(true);
                                    return;
                                }
                                continue;
                            }
                        }
                    }
                    final Alert alertWaiting = new Alert(Alert.AlertType.INFORMATION);
                    alertWaiting.setTitle(Main.RunCommand);
                    alertWaiting.setHeaderText("Processing");
                    switch (Main.this.currentState) {
                        case AutoScrapePhonesState: {
                            alertWaiting.setContentText("Wait...");
                            break;
                        }
                        case ManualScrapePhones: {
                            alertWaiting.setContentText("Wait...");
                            break;
                        }
                    }
                    alertWaiting.show();
                    final Thread thread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                switch (Main.this.currentState) {
                                    case AutoScrapePhonesState: {
                                        final ScrapePhonesAction scrapeAction = new ScrapePhonesAction();
                                        buttonCancel.setVisible(true);
                                        final ResultScrapePhones resultScrapePhones = scrapeAction.startAutoCreate(alertWaiting, buttonCancel, textAreaLog, finalLabelShowAmountAccounts2, bot);
                                        buttonCancel.setVisible(false);
                                        buttonStartAutoCreate.setVisible(true);
                                        break;
                                    }
                                    case ManualScrapePhones: {
                                        final ScrapePhonesAction registerAction = new ScrapePhonesAction();
                                        buttonCancel.setVisible(true);
                                        final ResultScrapePhones resultScrapePhones = registerAction.startManualCreate(alertWaiting, buttonCancel, textAreaLog, finalLabelShowAmountAccounts2, bot);
                                        buttonCancel.setVisible(false);
                                        buttonStartAutoCreate.setVisible(true);
                                        break;
                                    }
                                }
                            }
                            catch (Throwable e) {
                                Platform.runLater((Runnable)new Runnable() {
                                    @Override
                                    public void run() {
                                        alertWaiting.close();
                                        final Alert alertDialog = new Alert(Alert.AlertType.ERROR);
                                        alertDialog.setTitle("ERROR!");
                                        alertDialog.setHeaderText("Error Message");
                                        alertDialog.setContentText("Something wrong here ! " + e.toString());
                                        alertDialog.show();
                                        buttonStartAutoCreate.setVisible(true);
                                        buttonCancel.setVisible(false);
                                    }
                                });
                            }
                        }
                    });
                    thread.start();
                }
            });
            (this.mainHBox = new HBox()).setFillHeight(true);
            this.mainHBox.setAlignment(Pos.CENTER);
            this.mainHBox.setStyle("-fx-font: 12 arial;");
            final VBox vBoxSettings = new VBox();
            vBoxSettings.setAlignment(Pos.TOP_CENTER);
            vBoxSettings.setSpacing(5.0);
            vBoxSettings.setPadding(new Insets(5.0, 5.0, 5.0, 5.0));
            final Label labelTitleSettings = new Label(Main.Settings);
            vBoxSettings.getChildren().addAll(new Node[] { (Node)labelTitleSettings, (Node)scrollPane, (Node)buttonStartAutoCreate, (Node)buttonCancel });
            final VBox vBoxLogging = new VBox();
            vBoxLogging.setAlignment(Pos.CENTER);
            vBoxLogging.setSpacing(5.0);
            vBoxLogging.setPadding(new Insets(5.0, 5.0, 5.0, 5.0));
            final Label labelTitleLog = new Label(this.LoggingArea);
            vBoxLogging.getChildren().addAll(new Node[] { (Node)labelTitleLog, (Node)scrollPaneLog });
            this.mainHBox.getChildren().addAll(new Node[] { (Node)vBoxSettings, (Node)vBoxLogging });
            this.vBox.getChildren().addAll(new Node[] { (Node)this.mainHBox });
        }
        catch (Exception e2) {
            e2.printStackTrace();
            final Alert alertDialog2 = new Alert(Alert.AlertType.ERROR);
            alertDialog2.setTitle("ERROR!");
            alertDialog2.setHeaderText("Error Message");
            alertDialog2.setContentText("Something wrong! " + e2.toString());
            alertDialog2.show();
        }
    }
    
    public void stop() {
        Bot.storeCurrentState();
    }
    
    static {
        Main.TabHeigth = 700;
        Main.TabWidth = 1250;
        Main.WidthTextFields = 20;
        Main.HeigthTextFields = 2;
        Main.CreateNewUsers = "Scrape Phones";
        Main.SearchUsers = "Search Users";
        Main.SendMessages = "Send Messages";
        Main.ReadIncomingMessages = "Read Messages";
        Main.Settings = "Settings";
        Main.AppName = "REVOLUT BOT";
        Main.AutoScrapePhones = "Auto Scrape";
        Main.ManualScrapePhones = "Manual Scrape";
        Main.SearchUsersByPhone = "Search by Phone";
        Main.SearchUsersByUserID = "Search by userID";
        Main.SearchUsersByName = "Search by Name";
        Main.AutoSendMessages = "Auto Send Messages";
        Main.ManualSendMessages = "Manual Send Messages";
        Main.ReadMessages = "Read Messages and Auto Reply";
        Main.ProxySettins = "Proxy Set";
        Main.SmsServiceSet = "SMS Service Set";
        Main.CheckBlock = "Check Block";
        Main.UpdateCurrencies = "Update Currencies";
        Main.RunCommand = "Run";
    }
    
    public enum State
    {
        AutoScrapePhonesState(Main.AutoScrapePhones, "Auto scrape user phones", Main.RunCommand), 
        ManualScrapePhones(Main.ManualScrapePhones, "Manual scrape user phones", Main.RunCommand), 
        SearchUsersByPhoneState(Main.SearchUsersByPhone, "Search users by phones", Main.RunCommand), 
        SearchUsersByUserIdState(Main.SearchUsersByUserID, "Search users by userIDs", Main.RunCommand), 
        SearchUsersByUserNameState(Main.SearchUsersByName, "Search users by user names", Main.RunCommand), 
        AutoSendMessagesState(Main.AutoSendMessages, "Auto send messages", Main.RunCommand), 
        ManualSendMessagesState(Main.ManualSendMessages, "Manual send message", Main.RunCommand), 
        ReadIncomingMessagesAndReply(Main.ReadMessages, "Read Incoming Messages and Auto Reply", Main.RunCommand), 
        ProxySettingState(Main.ProxySettins, "Set proxy for work Line BOT", Main.RunCommand), 
        SMSServiceSettingState(Main.SmsServiceSet, "Set sms service for creating new users", Main.RunCommand), 
        CheckBlockChannel(Main.CheckBlock, "Check ABUSE_BLOCK for existing channels", Main.RunCommand);
        
        private final String name;
        private String describtion;
        private String commandName;
        
        private State(final String name, final String describtion, final String commandName) {
            this.describtion = describtion;
            this.name = name;
            this.commandName = commandName;
        }
        
        public String getName() {
            return this.name;
        }
        
        public String getDescribtion() {
            return this.describtion;
        }
        
        public String getCommandName() {
            return this.commandName;
        }
    }
    
    public enum TYPEFIELD
    {
        FileChooser, 
        FolderChooser, 
        FolderChooserWithShowing, 
        FolderChooserWithShowingFoundedLineUsers, 
        SimpleInput, 
        ChoiseBox, 
        ConfirmSimple, 
        MessageText;
    }
    
    public static class GUIView
    {
        private String nameField;
        private String toolTip;
        private TYPEFIELD typeField;
        
        public GUIView(final String nameField, final String toolTip, final TYPEFIELD typeField) {
            this.nameField = nameField;
            this.toolTip = toolTip;
            this.typeField = typeField;
        }
        
        public String getNameField() {
            return this.nameField;
        }
        
        public void setNameField(final String nameField) {
            this.nameField = nameField;
        }
        
        public String getToolTip() {
            return this.toolTip;
        }
        
        public void setToolTip(final String toolTip) {
            this.toolTip = toolTip;
        }
        
        public TYPEFIELD getTypeField() {
            return this.typeField;
        }
        
        public void setTypeField(final TYPEFIELD typeField) {
            this.typeField = typeField;
        }
    }
    
    private static class HolderGUIField
    {
        private Control control;
        private Field field;
        private TYPEFIELD typefield;
        
        public HolderGUIField(final Control control, final Field field, final TYPEFIELD typefield) {
            this.control = control;
            this.field = field;
            this.typefield = typefield;
        }
        
        public Control getControl() {
            return this.control;
        }
        
        public void setControl(final Control control) {
            this.control = control;
        }
        
        public Field getField() {
            return this.field;
        }
        
        public void setField(final Field field) {
            this.field = field;
        }
        
        public TYPEFIELD getTypefield() {
            return this.typefield;
        }
        
        public void setTypefield(final TYPEFIELD typefield) {
            this.typefield = typefield;
        }
    }
}
