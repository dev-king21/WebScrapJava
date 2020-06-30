// 
// Decompiled by Procyon v0.5.36
// 

package bot.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "phone" })
public class Phone
{
    @JsonProperty("phone")
    private String phone;
    
    @JsonProperty("phone")
    public String getPhone() {
        return this.phone;
    }
    
    @JsonProperty("phone")
    public void setPhone(final String phone) {
        this.phone = phone;
    }
}
