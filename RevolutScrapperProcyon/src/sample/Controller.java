// 
// Decompiled by Procyon v0.5.36
// 

package sample;

import java.util.LinkedList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Controller
{
    private static Map<Main.State, List<String>> mapWithAllFields;
    
    public static Map<Main.State, List<String>> getMapWithAllFields() {
        return Controller.mapWithAllFields;
    }
    
    static {
        Controller.mapWithAllFields = new HashMap<Main.State, List<String>>();
        final List<String> listForAutoCreateNewAccounts = new LinkedList<String>();
        listForAutoCreateNewAccounts.add("");
    }
}
