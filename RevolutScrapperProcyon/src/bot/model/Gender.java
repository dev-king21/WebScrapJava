// 
// Decompiled by Procyon v0.5.36
// 

package bot.model;

public enum Gender
{
    NONE(1), 
    MALE(2), 
    FEMALE(3), 
    BOTH(4);
    
    private final int alias;
    
    private Gender(final int alias) {
        this.alias = alias;
    }
    
    public String getGenderString() {
        switch (this) {
            case NONE: {
                return "NONE";
            }
            case MALE: {
                return "MALE";
            }
            case FEMALE: {
                return "FEMALE";
            }
            case BOTH: {
                return "BOTH";
            }
            default: {
                return null;
            }
        }
    }
    
    public int getGenderID() {
        switch (this) {
            case NONE: {
                return 1;
            }
            case MALE: {
                return 2;
            }
            case FEMALE: {
                return 3;
            }
            case BOTH: {
                return 4;
            }
            default: {
                return 0;
            }
        }
    }
}
