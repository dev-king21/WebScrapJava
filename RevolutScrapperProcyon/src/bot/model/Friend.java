// 
// Decompiled by Procyon v0.5.36
// 

package bot.model;

public class Friend
{
    private String phone;
    private String MID;
    private String contactName;
    private String numberID;
    private String contactType;
    private long createdTime;
    private String contactStatus;
    private String statusMessage;
    
    @Override
    public boolean equals(final Object anotherObject) {
        System.out.println("Input in equal");
        if (this == anotherObject) {
            return true;
        }
        if (anotherObject == null || this.getClass() != anotherObject.getClass()) {
            return false;
        }
        final Friend friend = (Friend)anotherObject;
        Label_0070: {
            if (this.phone != null) {
                if (this.phone.equals(friend.phone)) {
                    break Label_0070;
                }
            }
            else if (friend.phone == null) {
                break Label_0070;
            }
            return false;
        }
        Label_0103: {
            if (this.MID != null) {
                if (this.MID.equals(friend.MID)) {
                    break Label_0103;
                }
            }
            else if (friend.MID == null) {
                break Label_0103;
            }
            return false;
        }
        System.out.println("Equal true");
        return true;
    }
    
    @Override
    public int hashCode() {
        int result = (this.phone != null) ? this.phone.hashCode() : 0;
        result = 31 * result + ((this.MID != null) ? this.MID.hashCode() : 0);
        result = 31 * result + ((this.contactName != null) ? this.contactName.hashCode() : 0);
        result = 31 * result + ((this.numberID != null) ? this.numberID.hashCode() : 0);
        result = 31 * result + ((this.contactType != null) ? this.contactType.hashCode() : 0);
        result = 31 * result + (int)(this.createdTime ^ this.createdTime >>> 32);
        result = 31 * result + ((this.contactStatus != null) ? this.contactStatus.hashCode() : 0);
        result = 31 * result + ((this.statusMessage != null) ? this.statusMessage.hashCode() : 0);
        return result;
    }
    
    public String getPhone() {
        return this.phone;
    }
    
    public void setPhone(final String phone) {
        this.phone = phone;
    }
    
    public String getMID() {
        return this.MID;
    }
    
    public void setMID(final String MID) {
        this.MID = MID;
    }
    
    public String getContactName() {
        return this.contactName;
    }
    
    public void setContactName(final String contactName) {
        this.contactName = contactName;
    }
    
    public String getNumberID() {
        return this.numberID;
    }
    
    public void setNumberID(final String numberID) {
        this.numberID = numberID;
    }
    
    public String getContactType() {
        return this.contactType;
    }
    
    public void setContactType(final String contactType) {
        this.contactType = contactType;
    }
    
    public long getCreatedTime() {
        return this.createdTime;
    }
    
    public void setCreatedTime(final long createdTime) {
        this.createdTime = createdTime;
    }
    
    public String getContactStatus() {
        return this.contactStatus;
    }
    
    public void setContactStatus(final String contactStatus) {
        this.contactStatus = contactStatus;
    }
    
    public String getStatusMessage() {
        return this.statusMessage;
    }
    
    public void setStatusMessage(final String statusMessage) {
        this.statusMessage = statusMessage;
    }
    
    @Override
    public String toString() {
        return "Friend{phone='" + this.phone + '\'' + ", MID='" + this.MID + '\'' + ", contactName='" + this.contactName + '\'' + ", numberID='" + this.numberID + '\'' + ", contactType='" + this.contactType + '\'' + ", createdTime=" + this.createdTime + ", contactStatus='" + this.contactStatus + '\'' + ", statusMessage='" + this.statusMessage + '\'' + '}';
    }
}
