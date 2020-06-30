// 
// Decompiled by Procyon v0.5.36
// 

package bot.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "accounts" })
public class Accounts
{
    @JsonProperty("accounts")
    private List<Account> accounts;
    
    public Accounts() {
        this.accounts = null;
    }
    
    @JsonProperty("accounts")
    public List<Account> getAccounts() {
        return this.accounts;
    }
    
    @JsonProperty("accounts")
    public void setAccounts(final List<Account> accounts) {
        this.accounts = accounts;
    }
}
