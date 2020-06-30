// 
// Decompiled by Procyon v0.5.36
// 

package bot.network.json.user.confirm;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "ref", "state", "baseCurrency", "totalTopup", "topupResetDate", "pockets" })
public class Wallet
{
    @JsonProperty("id")
    private String id;
    @JsonProperty("ref")
    private String ref;
    @JsonProperty("state")
    private String state;
    @JsonProperty("baseCurrency")
    private String baseCurrency;
    @JsonProperty("totalTopup")
    private Long totalTopup;
    @JsonProperty("topupResetDate")
    private Long topupResetDate;
    @JsonProperty("pockets")
    private List<Pocket> pockets;
    
    public Wallet() {
        this.pockets = null;
    }
    
    @JsonProperty("id")
    public String getId() {
        return this.id;
    }
    
    @JsonProperty("id")
    public void setId(final String id) {
        this.id = id;
    }
    
    @JsonProperty("ref")
    public String getRef() {
        return this.ref;
    }
    
    @JsonProperty("ref")
    public void setRef(final String ref) {
        this.ref = ref;
    }
    
    @JsonProperty("state")
    public String getState() {
        return this.state;
    }
    
    @JsonProperty("state")
    public void setState(final String state) {
        this.state = state;
    }
    
    @JsonProperty("baseCurrency")
    public String getBaseCurrency() {
        return this.baseCurrency;
    }
    
    @JsonProperty("baseCurrency")
    public void setBaseCurrency(final String baseCurrency) {
        this.baseCurrency = baseCurrency;
    }
    
    @JsonProperty("totalTopup")
    public Long getTotalTopup() {
        return this.totalTopup;
    }
    
    @JsonProperty("totalTopup")
    public void setTotalTopup(final Long totalTopup) {
        this.totalTopup = totalTopup;
    }
    
    @JsonProperty("topupResetDate")
    public Long getTopupResetDate() {
        return this.topupResetDate;
    }
    
    @JsonProperty("topupResetDate")
    public void setTopupResetDate(final Long topupResetDate) {
        this.topupResetDate = topupResetDate;
    }
    
    @JsonProperty("pockets")
    public List<Pocket> getPockets() {
        return this.pockets;
    }
    
    @JsonProperty("pockets")
    public void setPockets(final List<Pocket> pockets) {
        this.pockets = pockets;
    }
}
