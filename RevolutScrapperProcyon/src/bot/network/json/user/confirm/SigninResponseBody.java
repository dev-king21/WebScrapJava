// 
// Decompiled by Procyon v0.5.36
// 

package bot.network.json.user.confirm;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonInclude;
import bot.network.json.base.JsonReadable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "user", "wallet", "accessToken" })
public class SigninResponseBody implements JsonReadable
{
    @JsonProperty("user")
    private User user;
    @JsonProperty("wallet")
    private Wallet wallet;
    @JsonProperty("accessToken")
    private String accessToken;
    private String jsonFullString;
    
    @JsonProperty("user")
    public User getUser() {
        return this.user;
    }
    
    @JsonProperty("user")
    public void setUser(final User user) {
        this.user = user;
    }
    
    @JsonProperty("wallet")
    public Wallet getWallet() {
        return this.wallet;
    }
    
    @JsonProperty("wallet")
    public void setWallet(final Wallet wallet) {
        this.wallet = wallet;
    }
    
    @JsonProperty("accessToken")
    public String getAccessToken() {
        return this.accessToken;
    }
    
    @JsonProperty("accessToken")
    public void setAccessToken(final String accessToken) {
        this.accessToken = accessToken;
    }
    
    @Override
    public String getJsonFullString() {
        return this.jsonFullString;
    }
    
    @Override
    public void setJsonFullString(final String jsonFullString) {
        this.jsonFullString = jsonFullString;
    }
}
