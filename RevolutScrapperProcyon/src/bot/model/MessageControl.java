// 
// Decompiled by Procyon v0.5.36
// 

package bot.model;

import java.util.TreeSet;
import java.util.Set;

public class MessageControl
{
    private int allQuantityOutComingMessages;
    private int quantityReadedOutComingMessages;
    private int quantityDontReadingOutComingMessages;
    private int quantityReceivedIncomingMessages;
    private Set<String> listWithAllIDOutComingMessages;
    private Set<String> listWithAllIDIncomingMessages;
    
    public MessageControl() {
        this.listWithAllIDOutComingMessages = new TreeSet<String>();
        this.listWithAllIDIncomingMessages = new TreeSet<String>();
    }
    
    @Override
    public String toString() {
        return "total send outcoming messages : " + this.allQuantityOutComingMessages + ", total readed outcoming messages : " + this.quantityReadedOutComingMessages + ", total dont readed outcoming messages : " + this.quantityDontReadingOutComingMessages + ", total received incoming messages from this user : " + this.quantityReceivedIncomingMessages;
    }
    
    public void addOutComingMessage() {
        ++this.allQuantityOutComingMessages;
        this.setQuantityDontReadingOutComingMessages();
    }
    
    public void addReadedOutComingMessage() {
        ++this.quantityReadedOutComingMessages;
        this.setQuantityDontReadingOutComingMessages();
    }
    
    public void addReceivedIncomingMessage() {
        ++this.quantityReceivedIncomingMessages;
    }
    
    public int getAllQuantityOutComingMessages() {
        return this.allQuantityOutComingMessages;
    }
    
    public void setAllQuantityOutComingMessages(final int allQuantityOutComingMessages) {
        this.allQuantityOutComingMessages = allQuantityOutComingMessages;
    }
    
    public int getQuantityReadedOutComingMessages() {
        return this.quantityReadedOutComingMessages;
    }
    
    public void setQuantityReadedOutComingMessages(final int quantityReadedOutComingMessages) {
        this.quantityReadedOutComingMessages = quantityReadedOutComingMessages;
        this.setQuantityDontReadingOutComingMessages();
    }
    
    public int getQuantityDontReadingOutComingMessages() {
        return this.quantityDontReadingOutComingMessages;
    }
    
    public void setQuantityDontReadingOutComingMessages(final int quantityDontReadingOutComingMessages) {
        this.quantityDontReadingOutComingMessages = quantityDontReadingOutComingMessages;
    }
    
    public void setQuantityDontReadingOutComingMessages() {
        this.quantityDontReadingOutComingMessages = this.allQuantityOutComingMessages - this.quantityReadedOutComingMessages;
        if (this.quantityDontReadingOutComingMessages < 0) {
            this.quantityDontReadingOutComingMessages = 0;
        }
    }
    
    public int getQuantityReceivedIncomingMessages() {
        return this.quantityReceivedIncomingMessages;
    }
    
    public void setQuantityReceivedIncomingMessages(final int quantityReceivedIncomingMessages) {
        this.quantityReceivedIncomingMessages = quantityReceivedIncomingMessages;
    }
    
    public Set<String> getListWithAllIDOutComingMessages() {
        return this.listWithAllIDOutComingMessages;
    }
    
    public void setListWithAllIDOutComingMessages(final Set<String> tableWithAllOutComingMessages) {
        this.listWithAllIDOutComingMessages = tableWithAllOutComingMessages;
    }
    
    public Set<String> getListWithAllIDIncomingMessages() {
        return this.listWithAllIDIncomingMessages;
    }
    
    public void setListWithAllIDIncomingMessages(final Set<String> listWithAllIDIncomingMessages) {
        this.listWithAllIDIncomingMessages = listWithAllIDIncomingMessages;
    }
}
