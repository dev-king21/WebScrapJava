// 
// Decompiled by Procyon v0.5.36
// 

package bot.network.json.user.transactions;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "lastFour", "label" })
public class Card
{
    @JsonProperty("id")
    private String id;
    @JsonProperty("lastFour")
    private String lastFour;
    @JsonProperty("label")
    private String label;
    
    @JsonProperty("id")
    public String getId() {
        return this.id;
    }
    
    @JsonProperty("id")
    public void setId(final String id) {
        this.id = id;
    }
    
    @JsonProperty("lastFour")
    public String getLastFour() {
        return this.lastFour;
    }
    
    @JsonProperty("lastFour")
    public void setLastFour(final String lastFour) {
        this.lastFour = lastFour;
    }
    
    @JsonProperty("label")
    public String getLabel() {
        return this.label;
    }
    
    @JsonProperty("label")
    public void setLabel(final String label) {
        this.label = label;
    }
}
