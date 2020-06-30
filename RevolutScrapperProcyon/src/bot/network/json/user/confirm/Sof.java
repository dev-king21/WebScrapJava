// 
// Decompiled by Procyon v0.5.36
// 

package bot.network.json.user.confirm;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "state" })
public class Sof
{
    @JsonProperty("state")
    private String state;
    
    @JsonProperty("state")
    public String getState() {
        return this.state;
    }
    
    @JsonProperty("state")
    public void setState(final String state) {
        this.state = state;
    }
}
