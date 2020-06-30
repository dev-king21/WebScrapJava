// 
// Decompiled by Procyon v0.5.36
// 

package bot.utils;

public class Log
{
    private static boolean isLog;
    
    public static void log(final Object message) {
        if (Log.isLog) {
            System.out.println(message);
        }
    }
    
    public static void log() {
        if (Log.isLog) {
            System.out.println();
        }
    }
    
    public static void setLog(final boolean log) {
        Log.isLog = log;
    }
}
