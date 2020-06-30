// 
// Decompiled by Procyon v0.5.36
// 

package bot.model;

public class CancelExecution
{
    public volatile Boolean isStopped;
    
    public CancelExecution() {
        this.isStopped = false;
    }
    
    public Boolean getStopped() {
        return this.isStopped;
    }
    
    public void setStopped(final Boolean stopped) {
        this.isStopped = stopped;
    }
}
