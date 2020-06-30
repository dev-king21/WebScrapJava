// 
// Decompiled by Procyon v0.5.36
// 

package bot.network.json.user.confirm;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "city", "country", "postcode", "region", "streetLine1" })
public class Address
{
    @JsonProperty("city")
    private String city;
    @JsonProperty("country")
    private String country;
    @JsonProperty("postcode")
    private String postcode;
    @JsonProperty("region")
    private String region;
    @JsonProperty("streetLine1")
    private String streetLine1;
    
    @JsonProperty("city")
    public String getCity() {
        return this.city;
    }
    
    @JsonProperty("city")
    public void setCity(final String city) {
        this.city = city;
    }
    
    @JsonProperty("country")
    public String getCountry() {
        return this.country;
    }
    
    @JsonProperty("country")
    public void setCountry(final String country) {
        this.country = country;
    }
    
    @JsonProperty("postcode")
    public String getPostcode() {
        return this.postcode;
    }
    
    @JsonProperty("postcode")
    public void setPostcode(final String postcode) {
        this.postcode = postcode;
    }
    
    @JsonProperty("region")
    public String getRegion() {
        return this.region;
    }
    
    @JsonProperty("region")
    public void setRegion(final String region) {
        this.region = region;
    }
    
    @JsonProperty("streetLine1")
    public String getStreetLine1() {
        return this.streetLine1;
    }
    
    @JsonProperty("streetLine1")
    public void setStreetLine1(final String streetLine1) {
        this.streetLine1 = streetLine1;
    }
}
