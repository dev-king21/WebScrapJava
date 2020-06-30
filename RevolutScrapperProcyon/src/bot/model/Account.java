// 
// Decompiled by Procyon v0.5.36
// 

package bot.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "userPhone", "userID", "statusMessage", "userEmail", "userPassword" })
public class Account
{
    @JsonProperty("userPhone")
    private String userPhone;
    @JsonProperty("userID")
    private String userID;
    @JsonProperty("statusMessage")
    private String statusMessage;
    @JsonProperty("userEmail")
    private String userEmail;
    @JsonProperty("userPassword")
    private String userPassword;
    
    @JsonProperty("userPhone")
    public String getUserPhone() {
        return this.userPhone;
    }
    
    @JsonProperty("userPhone")
    public void setUserPhone(final String userPhone) {
        this.userPhone = userPhone;
    }
    
    @JsonProperty("userID")
    public String getUserID() {
        return this.userID;
    }
    
    @JsonProperty("userID")
    public void setUserID(final String userID) {
        this.userID = userID;
    }
    
    @JsonProperty("statusMessage")
    public String getStatusMessage() {
        return this.statusMessage;
    }
    
    @JsonProperty("statusMessage")
    public void setStatusMessage(final String statusMessage) {
        this.statusMessage = statusMessage;
    }
    
    @JsonProperty("userEmail")
    public String getUserEmail() {
        return this.userEmail;
    }
    
    @JsonProperty("userEmail")
    public void setUserEmail(final String userEmail) {
        this.userEmail = userEmail;
    }
    
    @JsonProperty("userPassword")
    public String getUserPassword() {
        return this.userPassword;
    }
    
    @JsonProperty("userPassword")
    public void setUserPassword(final String userPassword) {
        this.userPassword = userPassword;
    }
}
