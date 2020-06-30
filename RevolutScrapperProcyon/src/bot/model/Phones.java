// 
// Decompiled by Procyon v0.5.36
// 

package bot.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "phones" })
public class Phones
{
    @JsonProperty("phones")
    private List<Phone> phones;
    
    public Phones() {
        this.phones = null;
    }
    
    @JsonProperty("phones")
    public List<Phone> getPhones() {
        return this.phones;
    }
    
    @JsonProperty("phones")
    public void setPhones(final List<Phone> phones) {
        this.phones = phones;
    }
    
    public String[] getPhonesString() {
        final String[] phonesString = new String[this.phones.size()];
        for (int i = 0; i < phonesString.length; ++i) {
            phonesString[i] = this.phones.get(i).getPhone();
        }
        return phonesString;
    }
}
