// 
// Decompiled by Procyon v0.5.36
// 

package utils;

import java.security.SecureRandom;
import java.util.Base64;

import org.jetbrains.annotations.Nullable;



public class TextUtils
{
    private static SecureRandom random;
    private static String[] russianSimOperatorCodes;
    
    public static boolean isEmpty(@Nullable final CharSequence str) {
        return str == null || str.length() == 0;
    }
    
    public static String getRandomBuildModel() {
        return getRandomBigChar() + "-" + getRandomBigChar() + getRandomNumber() + getRandomNumber() + getRandomNumber();
    }
    
    public static String getRandomAndroidOS() {
        return getRandomNumberWithLimitInclusive(4, 7) + "." + getRandomNumberWithLimitInclusive(0, 3) + "." + getRandomNumberWithLimitInclusive(0, 2);
    }
    
    public static char getRandomBigChar() {
        final char[] bigChars = "QWERTYUIOPASDFGHJKLZXCVBNM".toCharArray();
        return bigChars[TextUtils.random.nextInt(bigChars.length)];
    }
    
    public static int getRandomNumber() {
        final int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        return numbers[TextUtils.random.nextInt(numbers.length)];
    }
    
    public static String getRandomString(final int length) {
        final char[] cArr = new char[length];
        final String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        for (int i2 = 0; i2 < length; ++i2) {
            cArr[i2] = base.charAt(TextUtils.random.nextInt(base.length()));
        }
        return new String(cArr);
    }
    
    private static int getRandomNumberWithLimitInclusive(final int lower, final int upper) {
        final int[] numbers = new int[upper - lower + 1];
        for (int i = lower; i <= upper; ++i) {
            numbers[i - lower] = i;
        }
        return numbers[TextUtils.random.nextInt(numbers.length)];
    }
    
    public static String getRandomSimOperatorCode() {
        return TextUtils.russianSimOperatorCodes[TextUtils.random.nextInt(TextUtils.russianSimOperatorCodes.length)];
    }
    
    public static void main(final String[] args) {
        String channel = new String(Base64.getDecoder().decode("eyJJRCI6Ijc5MDY3NjAwMzMxIiwiUGFzc3dvcmQiOiJxMHcxMWd6bGdiIiwiQ2VydGlmaWNhdGUiOiJmNWE4NTBiMTU0MDM2NTI4OWZmNWI3YWM2N2ZhMjk4Nzg0N2FjZGI1ZTU4ZmQ0MWNkYjhmMWQzMzlkMDljM2EzIiwiQXV0aFRva2VuIjoiRWtyVWF0ZkZJR3BhN0piV1p4NDUueDhnS0Y3TUtrZ0tveFAwWkFRM0oxcS5vUHlncm13QW5mT3JIN3hTaFZSVVBZc0RBV2Q1anRkd2M4SmxnZ2EvMndvPSJ9"));
        System.out.println(channel);
        channel = new String(Base64.getDecoder().decode("EkrUatfFIGpa7JbWZx45"));
        System.out.println(channel);
    }
    
    static {
        TextUtils.random = new SecureRandom();
        TextUtils.russianSimOperatorCodes = "25028 25099 25010 25005 25019 25013 25002 25023 25035 25001 25003 25016 25011 25092 25004 25006 25009 25007 25014 25015 25044 25038 25020 25093 25017 25039".split(" ");
    }
}
