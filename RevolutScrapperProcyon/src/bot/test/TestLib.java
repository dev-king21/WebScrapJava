// 
// Decompiled by Procyon v0.5.36
// 

package bot.test;

import bot.main.RevolutUser;
import bot.utils.Log;

public class TestLib
{
    public static void main(final String[] args) {
        Log.setLog(true);
        final RevolutUser user = new RevolutUser();
        user.setPhoneNumber("+34622212343");
        try {
            user.userExistRequest();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            user.closeAllResources();
        }
    }
}
