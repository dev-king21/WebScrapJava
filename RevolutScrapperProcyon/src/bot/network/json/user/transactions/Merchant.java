// 
// Decompiled by Procyon v0.5.36
// 

package bot.network.json.user.transactions;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "scheme", "name", "country", "city", "address", "postcode", "state", "mcc", "category" })
public class Merchant
{
    @JsonProperty("id")
    private String id;
    @JsonProperty("scheme")
    private String scheme;
    @JsonProperty("name")
    private String name;
    @JsonProperty("country")
    private String country;
    @JsonProperty("city")
    private String city;
    @JsonProperty("address")
    private String address;
    @JsonProperty("postcode")
    private String postcode;
    @JsonProperty("state")
    private String state;
    @JsonProperty("mcc")
    private String mcc;
    @JsonProperty("category")
    private String category;
    
    @JsonProperty("id")
    public String getId() {
        return this.id;
    }
    
    @JsonProperty("id")
    public void setId(final String id) {
        this.id = id;
    }
    
    @JsonProperty("scheme")
    public String getScheme() {
        return this.scheme;
    }
    
    @JsonProperty("scheme")
    public void setScheme(final String scheme) {
        this.scheme = scheme;
    }
    
    @JsonProperty("name")
    public String getName() {
        return this.name;
    }
    
    @JsonProperty("name")
    public void setName(final String name) {
        this.name = name;
    }
    
    @JsonProperty("country")
    public String getCountry() {
        return this.country;
    }
    
    @JsonProperty("country")
    public void setCountry(final String country) {
        this.country = country;
    }
    
    @JsonProperty("city")
    public String getCity() {
        return this.city;
    }
    
    @JsonProperty("city")
    public void setCity(final String city) {
        this.city = city;
    }
    
    @JsonProperty("address")
    public String getAddress() {
        return this.address;
    }
    
    @JsonProperty("address")
    public void setAddress(final String address) {
        this.address = address;
    }
    
    @JsonProperty("postcode")
    public String getPostcode() {
        return this.postcode;
    }
    
    @JsonProperty("postcode")
    public void setPostcode(final String postcode) {
        this.postcode = postcode;
    }
    
    @JsonProperty("state")
    public String getState() {
        return this.state;
    }
    
    @JsonProperty("state")
    public void setState(final String state) {
        this.state = state;
    }
    
    @JsonProperty("mcc")
    public String getMcc() {
        return this.mcc;
    }
    
    @JsonProperty("mcc")
    public void setMcc(final String mcc) {
        this.mcc = mcc;
    }
    
    @JsonProperty("category")
    public String getCategory() {
        return this.category;
    }
    
    @JsonProperty("category")
    public void setCategory(final String category) {
        this.category = category;
    }
}
