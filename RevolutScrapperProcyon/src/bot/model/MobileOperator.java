// 
// Decompiled by Procyon v0.5.36
// 

package bot.model;

public enum MobileOperator
{
    MTS, 
    BEELINE, 
    MEGAFON, 
    ANY;
    
    public String getOperatorForSmsActivateService() {
        switch (this) {
            case MTS: {
                return "mts";
            }
            case ANY: {
                return "any";
            }
            case BEELINE: {
                return "beeline";
            }
            case MEGAFON: {
                return "megafon";
            }
            default: {
                return null;
            }
        }
    }
    
    public String getOperatorForSmsPvaService() {
        switch (this) {
            case MTS: {
                return "MTS_RU";
            }
            case ANY: {
                return null;
            }
            case BEELINE: {
                return "Beeline_RU";
            }
            case MEGAFON: {
                return "Megafon_RU";
            }
            default: {
                return null;
            }
        }
    }
}
