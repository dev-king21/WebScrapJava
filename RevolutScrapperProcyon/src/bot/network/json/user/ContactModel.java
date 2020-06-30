// 
// Decompiled by Procyon v0.5.36
// 

package bot.network.json.user;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ContactModel
{
    @JsonProperty("premium")
    private boolean premium;
    @JsonProperty("registeredAs")
    private String registeredAs;
    @JsonProperty("id")
    private String revolutId;
    
    public ContactModel(@JsonProperty("registeredAs") final String str, @JsonProperty("id") final String str2, @JsonProperty("premium") final boolean z) {
        this.registeredAs = str;
        this.premium = z;
        this.revolutId = str2;
    }
    
    @JsonProperty("premium")
    public boolean isPremium() {
        return this.premium;
    }
    
    @JsonProperty("premium")
    public void setPremium(final boolean premium) {
        this.premium = premium;
    }
    
    @JsonProperty("registeredAs")
    public String getRegisteredAs() {
        return this.registeredAs;
    }
    
    @JsonProperty("registeredAs")
    public void setRegisteredAs(final String registeredAs) {
        this.registeredAs = registeredAs;
    }
    
    @JsonProperty("id")
    public String getRevolutId() {
        return this.revolutId;
    }
    
    @JsonProperty("id")
    public void setRevolutId(final String revolutId) {
        this.revolutId = revolutId;
    }
}
