// 
// Decompiled by Procyon v0.5.36
// 

package bot.network.json.user.transactions;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "legId", "type", "state", "startedDate", "updatedDate", "completedDate", "currency", "amount", "fee", "balance", "description", "suggestions", "rate", "merchant", "posTime", "counterpart", "card" })
public class Transaction
{
    @JsonProperty("id")
    private String id;
    @JsonProperty("legId")
    private String legId;
    @JsonProperty("type")
    private String type;
    @JsonProperty("state")
    private String state;
    @JsonProperty("startedDate")
    private Long startedDate;
    @JsonProperty("updatedDate")
    private Long updatedDate;
    @JsonProperty("completedDate")
    private Long completedDate;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("amount")
    private Long amount;
    @JsonProperty("fee")
    private Long fee;
    @JsonProperty("balance")
    private Long balance;
    @JsonProperty("description")
    private String description;
    @JsonProperty("suggestions")
    private List<Object> suggestions;
    @JsonProperty("rate")
    private Long rate;
    @JsonProperty("merchant")
    private Merchant merchant;
    @JsonProperty("posTime")
    private Long posTime;
    @JsonProperty("counterpart")
    private Counterpart counterpart;
    @JsonProperty("card")
    private Card card;
    
    public Transaction() {
        this.suggestions = null;
    }
    
    @JsonProperty("id")
    public String getId() {
        return this.id;
    }
    
    @JsonProperty("id")
    public void setId(final String id) {
        this.id = id;
    }
    
    @JsonProperty("legId")
    public String getLegId() {
        return this.legId;
    }
    
    @JsonProperty("legId")
    public void setLegId(final String legId) {
        this.legId = legId;
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
    
    @JsonProperty("startedDate")
    public Long getStartedDate() {
        return this.startedDate;
    }
    
    @JsonProperty("startedDate")
    public void setStartedDate(final Long startedDate) {
        this.startedDate = startedDate;
    }
    
    @JsonProperty("updatedDate")
    public Long getUpdatedDate() {
        return this.updatedDate;
    }
    
    @JsonProperty("updatedDate")
    public void setUpdatedDate(final Long updatedDate) {
        this.updatedDate = updatedDate;
    }
    
    @JsonProperty("completedDate")
    public Long getCompletedDate() {
        return this.completedDate;
    }
    
    @JsonProperty("completedDate")
    public void setCompletedDate(final Long completedDate) {
        this.completedDate = completedDate;
    }
    
    @JsonProperty("currency")
    public String getCurrency() {
        return this.currency;
    }
    
    @JsonProperty("currency")
    public void setCurrency(final String currency) {
        this.currency = currency;
    }
    
    @JsonProperty("amount")
    public Long getAmount() {
        return this.amount;
    }
    
    @JsonProperty("amount")
    public void setAmount(final Long amount) {
        this.amount = amount;
    }
    
    @JsonProperty("fee")
    public Long getFee() {
        return this.fee;
    }
    
    @JsonProperty("fee")
    public void setFee(final Long fee) {
        this.fee = fee;
    }
    
    @JsonProperty("balance")
    public Long getBalance() {
        return this.balance;
    }
    
    @JsonProperty("balance")
    public void setBalance(final Long balance) {
        this.balance = balance;
    }
    
    @JsonProperty("description")
    public String getDescription() {
        return this.description;
    }
    
    @JsonProperty("description")
    public void setDescription(final String description) {
        this.description = description;
    }
    
    @JsonProperty("suggestions")
    public List<Object> getSuggestions() {
        return this.suggestions;
    }
    
    @JsonProperty("suggestions")
    public void setSuggestions(final List<Object> suggestions) {
        this.suggestions = suggestions;
    }
    
    @JsonProperty("rate")
    public Long getRate() {
        return this.rate;
    }
    
    @JsonProperty("rate")
    public void setRate(final Long rate) {
        this.rate = rate;
    }
    
    @JsonProperty("merchant")
    public Merchant getMerchant() {
        return this.merchant;
    }
    
    @JsonProperty("merchant")
    public void setMerchant(final Merchant merchant) {
        this.merchant = merchant;
    }
    
    @JsonProperty("posTime")
    public Long getPosTime() {
        return this.posTime;
    }
    
    @JsonProperty("posTime")
    public void setPosTime(final Long posTime) {
        this.posTime = posTime;
    }
    
    @JsonProperty("counterpart")
    public Counterpart getCounterpart() {
        return this.counterpart;
    }
    
    @JsonProperty("counterpart")
    public void setCounterpart(final Counterpart counterpart) {
        this.counterpart = counterpart;
    }
    
    @JsonProperty("card")
    public Card getCard() {
        return this.card;
    }
    
    @JsonProperty("card")
    public void setCard(final Card card) {
        this.card = card;
    }
}
