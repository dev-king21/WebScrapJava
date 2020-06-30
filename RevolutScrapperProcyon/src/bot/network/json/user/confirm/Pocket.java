// 
// Decompiled by Procyon v0.5.36
// 

package bot.network.json.user.confirm;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "type", "state", "currency", "balance", "blockedAmount", "closed", "creditLimit" })
public class Pocket
{
    @JsonProperty("id")
    private String id;
    @JsonProperty("type")
    private String type;
    @JsonProperty("state")
    private String state;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("balance")
    private Long balance;
    @JsonProperty("blockedAmount")
    private Long blockedAmount;
    @JsonProperty("closed")
    private Boolean closed;
    @JsonProperty("creditLimit")
    private Long creditLimit;
    
    @JsonProperty("id")
    public String getId() {
        return this.id;
    }
    
    @JsonProperty("id")
    public void setId(final String id) {
        this.id = id;
    }
    
    @JsonProperty("type")
    public String getType() {
        return this.type;
    }
    
    @JsonProperty("type")
    public void setType(final String type) {
        this.type = type;
    }
    
    @JsonProperty("state")
    public String getState() {
        return this.state;
    }
    
    @JsonProperty("state")
    public void setState(final String state) {
        this.state = state;
    }
    
    @JsonProperty("currency")
    public String getCurrency() {
        return this.currency;
    }
    
    @JsonProperty("currency")
    public void setCurrency(final String currency) {
        this.currency = currency;
    }
    
    @JsonProperty("balance")
    public Long getBalance() {
        return this.balance;
    }
    
    @JsonProperty("balance")
    public void setBalance(final Long balance) {
        this.balance = balance;
    }
    
    @JsonProperty("blockedAmount")
    public Long getBlockedAmount() {
        return this.blockedAmount;
    }
    
    @JsonProperty("blockedAmount")
    public void setBlockedAmount(final Long blockedAmount) {
        this.blockedAmount = blockedAmount;
    }
    
    @JsonProperty("closed")
    public Boolean getClosed() {
        return this.closed;
    }
    
    @JsonProperty("closed")
    public void setClosed(final Boolean closed) {
        this.closed = closed;
    }
    
    @JsonProperty("creditLimit")
    public Long getCreditLimit() {
        return this.creditLimit;
    }
    
    @JsonProperty("creditLimit")
    public void setCreditLimit(final Long creditLimit) {
        this.creditLimit = creditLimit;
    }
}
