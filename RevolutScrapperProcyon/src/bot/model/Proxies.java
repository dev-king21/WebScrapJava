// 
// Decompiled by Procyon v0.5.36
// 

package bot.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "proxies" })
public class Proxies
{
    @JsonProperty("proxies")
    private List<Proxy> proxies;
    
    public Proxies() {
        this.proxies = null;
    }
    
    @JsonProperty("proxies")
    public List<Proxy> getProxies() {
        return this.proxies;
    }
    
    @JsonProperty("proxies")
    public void setProxies(final List<Proxy> proxies) {
        this.proxies = proxies;
    }
}
