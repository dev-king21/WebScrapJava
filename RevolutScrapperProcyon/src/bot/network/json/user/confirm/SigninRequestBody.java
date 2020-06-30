// 
// Decompiled by Procyon v0.5.36
// 

package bot.network.json.user.confirm;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "phone", "code" })
public class SigninRequestBody
{
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("code")
    private String code;
    
    @JsonProperty("phone")
    public String getPhone() {
        return this.phone;
    }
    
    @JsonProperty("phone")
    public void setPhone(final String phone) {
        this.phone = phone;
    }
    
    @JsonProperty("code")
    public String getCode() {
        return this.code;
    }
    
    @JsonProperty("code")
    public void setCode(final String code) {
        this.code = code;
    }
}
