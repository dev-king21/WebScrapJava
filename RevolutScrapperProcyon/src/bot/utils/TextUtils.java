// 
// Decompiled by Procyon v0.5.36
// 

package bot.utils;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.Base64;

import org.jetbrains.annotations.Nullable;

public class TextUtils
{
    private static SecureRandom random;
    
    public static boolean isEmpty(@Nullable final CharSequence str) {
        return str == null || str.length() == 0;
    }
    
    public static char getRandomBigChar() {
        final char[] bigChars = "QWERTYUIOPASDFGHJKLZXCVBNM".toCharArray();
        return bigChars[TextUtils.random.nextInt(bigChars.length)];
    }
    
    public static int getRandomNumber() {
        final int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        return numbers[TextUtils.random.nextInt(numbers.length)];
    }
    
    public static long getRandomNumberWithNeedLength(final int lengthNumber) {
        final int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        long number = 0L;
        for (int i = 0; i < lengthNumber; ++i) {
            number += (long)Math.pow(10.0, i) * numbers[TextUtils.random.nextInt(numbers.length)];
        }
        return number;
    }
    
    public static String getRandomStringLowCase(final int length) {
        final char[] cArr = new char[length];
        final String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        for (int i2 = 0; i2 < length; ++i2) {
            cArr[i2] = base.charAt(TextUtils.random.nextInt((i2 == 0) ? "abcdefghijklmnopqrstuvwxyz".length() : base.length()));
        }
        return new String(cArr);
    }
    
    public static String getRandomStringUpperCase(final int length) {
        final char[] cArr = new char[length];
        final String base = "QAZWSXEDCRFVTGBYHNUJMIKOLP0123456789";
        for (int i2 = 0; i2 < length; ++i2) {
            cArr[i2] = base.charAt(TextUtils.random.nextInt(base.length()));
        }
        return new String(cArr);
    }
    
    public static String getRandomStringAnyCase(final int length) {
        final char[] cArr = new char[length];
        final String base = "qazwsxedcrfvtgbyhnujmikolpQAZWSXEDCRFVTGBYHNUJMIKOLP0123456789";
        for (int i2 = 0; i2 < length; ++i2) {
            cArr[i2] = base.charAt(TextUtils.random.nextInt(base.length()));
        }
        return new String(cArr);
    }
    
    public static String getRandomPassword(final int length) {
        final char[] cArr = new char[length];
        final String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        for (int i2 = 0; i2 < length; ++i2) {
            cArr[i2] = base.charAt(TextUtils.random.nextInt(base.length()));
        }
        return new String(cArr) + getRandomNumber();
    }
    
    public static int getRandomNumberWithLimitInclusive(final int lower, final int upper) {
        final int[] numbers = new int[upper - lower + 1];
        for (int i = lower; i <= upper; ++i) {
            numbers[i - lower] = i;
        }
        return numbers[TextUtils.random.nextInt(numbers.length)];
    }
    
    public static String arrayIntsToString(final int[] array) {
        final StringBuilder builder = new StringBuilder();
        for (int i = 0; i < array.length; ++i) {
            builder.append(String.format("%02x", array[i])).append(" ");
        }
        return builder.toString();
    }
    
    public static String arrayBytesToString(final byte[] array) {
        final StringBuilder builder = new StringBuilder();
        for (int i = 0; i < array.length; ++i) {
            builder.append(String.format("%02x", array[i])).append(" ");
        }
        return builder.toString();
    }
    
    public static String arrayIntsToFormatedString(final int[] array) {
        final StringBuilder builder = new StringBuilder();
        for (int i = 0; i < array.length; ++i) {
            if (i % 16 == 0) {
                builder.append("\n");
            }
            builder.append(String.format("%02x", array[i])).append(" ");
        }
        return builder.toString();
    }
    
    public static String arrayBytesToFormatedString(final byte[] array) {
        final StringBuilder builder = new StringBuilder();
        for (int i = 0; i < array.length; ++i) {
            if (i % 16 == 0 && i != 0) {
                builder.append("\n");
            }
            builder.append(String.format("%02x", array[i])).append(" ");
        }
        return builder.toString();
    }
    
    public static void main(final String[] args) throws IOException {
        String channel = new String(Base64.getDecoder().decode("eyJJRCI6Ijc5MDY3NjAwMzMxIiwiUGFzc3dvcmQiOiJxMHcxMWd6bGdiIiwiQ2VydGlmaWNhdGUiOiJmNWE4NTBiMTU0MDM2NTI4OWZmNWI3YWM2N2ZhMjk4Nzg0N2FjZGI1ZTU4ZmQ0MWNkYjhmMWQzMzlkMDljM2EzIiwiQXV0aFRva2VuIjoiRWtyVWF0ZkZJR3BhN0piV1p4NDUueDhnS0Y3TUtrZ0tveFAwWkFRM0oxcS5vUHlncm13QW5mT3JIN3hTaFZSVVBZc0RBV2Q1anRkd2M4SmxnZ2EvMndvPSJ9"));
        Log.log(channel);
        channel = new String(Base64.getDecoder().decode("EkrUatfFIGpa7JbWZx45"));
        Log.log(channel);
        Log.log("ODYxNzA5MTA2MDI1MiMjhW1+lMHCnFY+f56+yDQQpS0kNQ==\n");
        final String rcKey = "ODYxNzA5MTA2MDI1MiMjhW1+lMHCnFY+f56+yDQQpS0kNQ==\n";
        final byte[] bytes = bot.utils.Base64.decode(rcKey.getBytes(), 0);
        Log.log(bot.utils.Base64.encodeToString(bytes, 0));
        final String gcmTokenReal = "APA91bHO4OIMgJEuLHoN-KSNuIrbuHnzTmvp2PpqFSQ5FVtrY3ukGkH3WtEfMc74DMtGDynu0U9LOHiHIwMNAv8T_CdE_Wer-sfGnqyrOPBr9xCkOxsW6sceze8WreFIRr_GGxHeLN6I";
        final String fakeToken = gcmTokenReal.substring(0, "APA91bHO4OIMgJEuLHoN-KSNuIrbuHnzTmvp2PpqFSQ5FVtrY3ukGkH3WtEfMc74DMtGDynu0U9LOHiHIwMNAv8T_CdE_Wer-".length()) + getRandomStringAnyCase("sfGnqyrOPBr9xCkOxsW6sceze8WreFIRr".length()) + "_" + getRandomStringAnyCase("GGxHeLN6I".length());
        Log.log(gcmTokenReal);
        Log.log(fakeToken);
        Log.log(getRandomNumberWithNeedLength(4));
    }
    
    static {
        TextUtils.random = new SecureRandom();
    }
}
