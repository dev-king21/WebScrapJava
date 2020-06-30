// 
// Decompiled by Procyon v0.5.36
// 

package bot.network.json.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "phone", "password" })
public class SignupRequestBody
{
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("password")
    private String password;
    
    @JsonProperty("phone")
    public String getPhone() {
        return this.phone;
    }
    
    @JsonProperty("phone")
    public void setPhone(final String phone) {
        this.phone = phone;
    }
    
    @JsonProperty("password")
    public String getPassword() {
        return this.password;
    }
    
    @JsonProperty("password")
    public void setPassword(final String password) {
        this.password = password;
    }
}
