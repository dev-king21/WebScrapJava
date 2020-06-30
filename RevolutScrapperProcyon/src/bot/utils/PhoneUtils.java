// 
// Decompiled by Procyon v0.5.36
// 

package bot.utils;

import java.util.Collection;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.UUID;
import utils.TextUtils;
import java.security.SecureRandom;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.List;

public class PhoneUtils
{
    public static final List<Integer> usaAreaCodes;
    private static final String[] models;
    private static final Map<String, String> androidVersion;
    static char[] decimalNumber;
    static String[] phoneModels;
    static String[] tacModels;
    static LinkedHashMap<String, String> mapWithTACmodels;
    private static SecureRandom secureRandom;
    private static String[] russianSimOperatorCodes;
    
    public static String getUSAPhoneNumberWithoutCountryCode() {
        return String.valueOf(PhoneUtils.usaAreaCodes.get(PhoneUtils.secureRandom.nextInt(PhoneUtils.usaAreaCodes.size()))) + String.valueOf(TextUtils.getRandomNumber()) + String.valueOf(TextUtils.getRandomNumber()) + String.valueOf(TextUtils.getRandomNumber()) + String.valueOf(TextUtils.getRandomNumber()) + String.valueOf(TextUtils.getRandomNumber()) + String.valueOf(TextUtils.getRandomNumber()) + String.valueOf(TextUtils.getRandomNumber());
    }
    
    public static String getRandomBootloaderVersion() {
        return "" + TextUtils.getRandomBigChar() + TextUtils.getRandomNumber() + TextUtils.getRandomNumber() + TextUtils.getRandomNumber() + TextUtils.getRandomBigChar() + TextUtils.getRandomBigChar() + TextUtils.getRandomBigChar() + TextUtils.getRandomNumber() + TextUtils.getRandomBigChar() + TextUtils.getRandomBigChar() + TextUtils.getRandomBigChar() + TextUtils.getRandomNumber();
    }
    
    public static String getRandomProducName() {
        return "" + TextUtils.getRandomBigChar() + TextUtils.getRandomBigChar() + TextUtils.getRandomNumber() + TextUtils.getRandomNumber() + TextUtils.getRandomNumber() + TextUtils.getRandomBigChar() + TextUtils.getRandomBigChar();
    }
    
    public static String getRandomHardwareName() {
        return "" + bot.utils.TextUtils.getRandomStringLowCase(5);
    }
    
    public static String getRandomSimSerialNumber() {
        final int lengthSimSerial = 19;
        final int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        final StringBuilder builderSimSerial = new StringBuilder();
        for (int i = 0; i < lengthSimSerial; ++i) {
            builderSimSerial.append(numbers[PhoneUtils.secureRandom.nextInt(numbers.length)]);
        }
        return builderSimSerial.toString();
    }
    
    public static String getRandomSimOperatorCode() {
        return PhoneUtils.russianSimOperatorCodes[PhoneUtils.secureRandom.nextInt(PhoneUtils.russianSimOperatorCodes.length)];
    }
    
    public static String getRandomBuildModel() {
        return TextUtils.getRandomBigChar() + "-" + TextUtils.getRandomBigChar() + TextUtils.getRandomNumber() + TextUtils.getRandomNumber() + TextUtils.getRandomNumber();
    }
    
    public static String getRandomAndroidOS() {
        return PhoneUtils.androidVersion.keySet().toArray(new String[0])[PhoneUtils.secureRandom.nextInt(PhoneUtils.androidVersion.size())];
    }
    
    public static String getAndroidAPIbyOs(final String androidOS) {
        return PhoneUtils.androidVersion.getOrDefault(androidOS, "23");
    }
    
    public static String getRandomBoardName() {
        return "" + TextUtils.getRandomBigChar() + TextUtils.getRandomBigChar() + TextUtils.getRandomBigChar() + TextUtils.getRandomNumber() + TextUtils.getRandomNumber() + TextUtils.getRandomNumber() + TextUtils.getRandomNumber();
    }
    
    public static String getRandomBuildDisplay() {
        return TextUtils.getRandomBigChar() + TextUtils.getRandomBigChar() + TextUtils.getRandomBigChar() + TextUtils.getRandomNumber() + TextUtils.getRandomNumber() + TextUtils.getRandomBigChar() + "." + TextUtils.getRandomBigChar() + TextUtils.getRandomNumber() + TextUtils.getRandomNumber() + TextUtils.getRandomNumber() + TextUtils.getRandomBigChar() + TextUtils.getRandomBigChar() + TextUtils.getRandomBigChar() + TextUtils.getRandomBigChar() + TextUtils.getRandomBigChar() + TextUtils.getRandomBigChar() + TextUtils.getRandomBigChar() + TextUtils.getRandomBigChar() + TextUtils.getRandomBigChar() + TextUtils.getRandomBigChar();
    }
    
    public static String getRandomBuildPhone() {
        return TextUtils.getRandomBigChar() + TextUtils.getRandomBigChar() + TextUtils.getRandomBigChar() + "/" + TextUtils.getRandomBigChar() + TextUtils.getRandomNumber() + TextUtils.getRandomBigChar() + TextUtils.getRandomBigChar();
    }
    
    private static void init() {
        for (int i = 0; i < PhoneUtils.phoneModels.length; ++i) {
            PhoneUtils.mapWithTACmodels.put(PhoneUtils.phoneModels[i], PhoneUtils.tacModels[i]);
        }
    }
    
    public static String getRandomPhoneModel() {
        return PhoneUtils.phoneModels[PhoneUtils.secureRandom.nextInt(PhoneUtils.phoneModels.length)];
    }
    
    public static String getRandomIMEIForModel(final String phoneModel) {
        final String tacModel = PhoneUtils.mapWithTACmodels.get(phoneModel);
        final String serialNumber = generateRandomSerialNumber();
        final String imeiBegin = tacModel + serialNumber;
        for (int i = 0; i < PhoneUtils.decimalNumber.length; ++i) {
            final String imei = imeiBegin + PhoneUtils.decimalNumber[i];
            if (check(imei)) {
                return imei;
            }
        }
        return null;
    }
    
    private static String generateRandomSerialNumber() {
        final StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 6; ++i) {
            builder.append(PhoneUtils.decimalNumber[PhoneUtils.secureRandom.nextInt(PhoneUtils.decimalNumber.length)]);
        }
        return builder.toString();
    }
    
    public static boolean check(final String ccNumber) {
        int sum = 0;
        boolean alternate = false;
        for (int i = ccNumber.length() - 1; i >= 0; --i) {
            int n = Integer.parseInt(ccNumber.substring(i, i + 1));
            if (alternate) {
                n *= 2;
                if (n > 9) {
                    n = n % 10 + 1;
                }
            }
            sum += n;
            alternate = !alternate;
        }
        return sum % 10 == 0;
    }
    
    public static String getRandomUUIDTokenWithoutDefisLenght32Chars() {
        final String randomID = UUID.randomUUID().toString().replaceAll("-", "");
        return randomID;
    }
    
    public static String getRandomPhoneManufacture() {
        return "samsung";
    }
    
    public static String getRandomAndroidID() {
        final String randomID = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 16);
        return randomID;
    }
    
    public static String getRandomAdvertID() {
        return UUID.randomUUID().toString();
    }
    
    public static String getRandomMacPhone() {
        final StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 6; ++i) {
            int randomNumber;
            do {
                randomNumber = PhoneUtils.secureRandom.nextInt(100);
            } while (randomNumber < 16 || randomNumber > 255);
            builder.append(Integer.toHexString(randomNumber)).append(":");
        }
        builder.setLength(builder.length() - 1);
        return builder.toString();
    }
    
    public static String getRandomEmail() {
        return bot.utils.TextUtils.getRandomStringLowCase(6) + "@gmail.com";
    }
    
    public static int getRandomContactsListSize() {
        return 7 + PhoneUtils.secureRandom.nextInt(30);
    }
    
    public static String getRandomGCMToken() {
        final String gcmTokenReal = "APA91bHO4OIMgJEuLHoN-KSNuIrbuHnzTmvp2PpqFSQ5FVtrY3ukGkH3WtEfMc74DMtGDynu0U9LOHiHIwMNAv8T_CdE_Wer-sfGnqyrOPBr9xCkOxsW6sceze8WreFIRr_GGxHeLN6I";
        final String fakeToken = bot.utils.TextUtils.getRandomStringAnyCase("fBAIQE00QuI".length()) + ":" + gcmTokenReal.substring(0, "APA91bHO4OIMgJEuLHoN-KSNuIrbuHnzTmvp2PpqFSQ5FVtrY3ukGkH3WtEfMc74DMtGDynu0U9LOHiHIwMNAv8T_CdE_Wer-".length()) + bot.utils.TextUtils.getRandomStringAnyCase("sfGnqyrOPBr9xCkOxsW6sceze8WreFIRr".length()) + "_" + bot.utils.TextUtils.getRandomStringAnyCase("GGxHeLN6I".length());
        Log.log(gcmTokenReal);
        Log.log(fakeToken);
        return fakeToken;
    }
    
    public static void main(final String[] args) throws NotSupportedModelException {
        final String imei = getRandomIMEIForModel("SGH-S300");
        Log.log(imei);
    }
    
    static {
        usaAreaCodes = new ArrayList<Integer>();
        models = new String[] { "samsung", "sony", "phillips", "hyandai", "lg", "hyawei", "nokia", "erricson", "fly" };
        (androidVersion = new LinkedHashMap<String, String>()).put("5.0", "21");
        PhoneUtils.androidVersion.put("5.0.1", "21");
        PhoneUtils.androidVersion.put("5.0.2", "21");
        PhoneUtils.androidVersion.put("5.1", "22");
        PhoneUtils.androidVersion.put("5.1.1", "22");
        PhoneUtils.androidVersion.put("6.0", "23");
        PhoneUtils.androidVersion.put("6.0.1", "23");
        PhoneUtils.androidVersion.put("7.0", "24");
        PhoneUtils.androidVersion.put("7.1", "25");
        PhoneUtils.androidVersion.put("7.1.1", "25");
        PhoneUtils.androidVersion.put("7.1.2", "25");
        PhoneUtils.androidVersion.put("8.0", "26");
        PhoneUtils.androidVersion.put("8.1", "27");
        final Integer[] arraysArreaCodesUsa = { 201, 202, 203, 204, 205, 206, 207, 208, 209, 210, 212, 213, 214, 215, 216, 217, 218, 219, 224, 225, 228, 229, 231, 234, 239, 240, 242, 246, 248, 250, 251, 252, 253, 254, 256, 260, 262, 264, 267, 268, 269, 270, 276, 281, 284, 289, 301, 302, 303, 304, 305, 306, 307, 308, 309, 310, 312, 313, 314, 315, 316, 317, 318, 319, 320, 321, 323, 325, 330, 334, 336, 337, 339, 340, 345, 347, 351, 352, 360, 361, 386, 401, 402, 403, 404, 405, 406, 407, 408, 409, 410, 412, 413, 414, 415, 416, 417, 418, 419, 423, 425, 430, 432, 434, 435, 440, 441, 443, 450, 456, 469, 473, 478, 479, 480, 484, 501, 502, 503, 504, 505, 506, 507, 508, 509, 510, 512, 513, 514, 515, 516, 517, 518, 519, 520, 530, 540, 541, 551, 559, 561, 562, 563, 567, 570, 571, 573, 574, 580, 585, 586, 601, 602, 603, 604, 605, 606, 607, 608, 609, 610, 612, 613, 614, 615, 616, 617, 618, 619, 620, 623, 626, 630, 631, 636, 641, 646, 647, 649, 650, 651, 660, 661, 662, 664, 670, 671, 678, 682, 701, 702, 703, 704, 705, 706, 707, 708, 709, 710, 712, 713, 714, 715, 716, 717, 718, 719, 720, 724, 727, 731, 732, 734, 740, 754, 757, 758, 760, 763, 765, 767, 770, 772, 773, 774, 775, 778, 780, 781, 784, 785, 786, 787, 801, 802, 803, 804, 805, 806, 807, 808, 809, 810, 812, 813, 814, 815, 816, 817, 818, 819, 828, 830, 831, 832, 843, 845, 847, 848, 850, 856, 857, 858, 859, 860, 862, 863, 864, 865, 867, 868, 869, 870, 876, 878, 880, 881, 882, 901, 902, 903, 904, 905, 906, 907, 908, 909, 910, 912, 913, 914, 915, 916, 917, 918, 919, 920, 925, 928, 931, 936, 937, 939, 940, 941, 947, 949, 952, 954, 956, 970, 971, 972, 973, 978, 979, 980, 985, 989 };
        PhoneUtils.usaAreaCodes.addAll(Arrays.asList(arraysArreaCodesUsa));
        PhoneUtils.decimalNumber = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
        PhoneUtils.phoneModels = new String[] { "SM-T355", "SM-J100H", "U900 Soul", "SGH-N100", "SGH-X510", "GT-I9060", "GT-I8262", "SGH-Z170", "SGH-T408", "SGH-S300", "SM-G925F" };
        PhoneUtils.tacModels = new String[] { "35853706", "35301007", "35599002", "35009791", "35463301", "35559106", "35283806", "35488901", "35106500", "35046790", "35952006" };
        PhoneUtils.mapWithTACmodels = new LinkedHashMap<String, String>();
        PhoneUtils.secureRandom = new SecureRandom();
        init();
        PhoneUtils.russianSimOperatorCodes = "25028 25099 25010 25005 25019 25013 25002 25023 25035 25001 25003 25016 25011 25092 25004 25006 25009 25007 25014 25015 25044 25038 25020 25093 25017 25039".split(" ");
    }
    
    public static class NotSupportedModelException extends Exception
    {
        NotSupportedModelException(final String message) {
            super(message);
        }
    }
}
