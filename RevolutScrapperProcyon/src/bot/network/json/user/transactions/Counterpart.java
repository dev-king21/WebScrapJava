// 
// Decompiled by Procyon v0.5.36
// 

package bot.network.json.user.transactions;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "amount", "currency" })
public class Counterpart
{
    @JsonProperty("amount")
    private Long amount;
    @JsonProperty("currency")
    private String currency;
    
    @JsonProperty("amount")
    public Long getAmount() {
        return this.amount;
    }
    
    @JsonProperty("amount")
    public void setAmount(final Long amount) {
        this.amount = amount;
    }
    
    @JsonProperty("currency")
    public String getCurrency() {
        return this.currency;
    }
    
    @JsonProperty("currency")
    public void setCurrency(final String currency) {
        this.currency = currency;
    }
}
