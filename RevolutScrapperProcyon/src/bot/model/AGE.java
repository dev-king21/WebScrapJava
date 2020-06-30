// 
// Decompiled by Procyon v0.5.36
// 

package bot.model;

import java.text.SimpleDateFormat;
import bot.utils.Log;
import java.util.Date;
import java.security.SecureRandom;

public enum AGE
{
    Age18(18), 
    Age19(19), 
    Age20(20), 
    Age21(21), 
    Age22(22), 
    Age23(23), 
    Age24(24), 
    Age25(25), 
    Age26(26), 
    Age27(27), 
    Age28(28), 
    Age29(29), 
    Age30(30), 
    Age31(31), 
    Age32(32), 
    Age33(33), 
    Age34(34), 
    Age35(35), 
    Age36(36), 
    Age37(37), 
    Age38(38), 
    Age39(39), 
    Age40(40), 
    Age41(41), 
    Age42(42), 
    Age43(43), 
    Age44(44), 
    Age45(45), 
    Age46(46), 
    Age47(47), 
    Age48(48), 
    Age49(49), 
    Age50(50), 
    Age51(51), 
    Age52(52), 
    Age53(53), 
    Age54(54);
    
    static SecureRandom secureRandom;
    int age;
    
    private AGE(final int age) {
        this.age = age;
    }
    
    @Override
    public String toString() {
        return String.valueOf(this.age);
    }
    
    public int getAge() {
        return this.age;
    }
    
    public static String getRandomBirthday(final int age) {
        final Date dateBirthday = new Date();
        dateBirthday.setYear(dateBirthday.getYear() - age);
        final long dateBirthdayInMillisecond = dateBirthday.getTime();
        final int fullYearMillisecond = 315360000;
        final long randomInt = AGE.secureRandom.nextInt(fullYearMillisecond);
        Log.log(randomInt * 100L);
        final long randomBirthday = dateBirthdayInMillisecond - randomInt * 100L;
        return new SimpleDateFormat("yyyy-MM-dd").format(randomBirthday);
    }
    
    public static void main(final String[] args) {
        Log.log(getRandomBirthday(30));
    }
    
    static {
        AGE.secureRandom = new SecureRandom();
    }
}
