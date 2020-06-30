// 
// Decompiled by Procyon v0.5.36
// 

package bot.network.json.user.confirm;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "createdDate", "address", "birthDate", "firstName", "lastName", "phone", "email", "emailVerified", "state", "referralCode", "kyc", "termsVersion", "underReview", "riskAssessed", "locale", "sof" })
public class User
{
    @JsonProperty("id")
    private String id;
    @JsonProperty("createdDate")
    private Long createdDate;
    @JsonProperty("address")
    private Address address;
    @JsonProperty("birthDate")
    private List<Long> birthDate;
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("email")
    private String email;
    @JsonProperty("emailVerified")
    private Boolean emailVerified;
    @JsonProperty("state")
    private String state;
    @JsonProperty("referralCode")
    private String referralCode;
    @JsonProperty("kyc")
    private String kyc;
    @JsonProperty("termsVersion")
    private String termsVersion;
    @JsonProperty("underReview")
    private Boolean underReview;
    @JsonProperty("riskAssessed")
    private Boolean riskAssessed;
    @JsonProperty("locale")
    private String locale;
    @JsonProperty("sof")
    private Sof sof;
    
    public User() {
        this.birthDate = null;
    }
    
    @JsonProperty("id")
    public String getId() {
        return this.id;
    }
    
    @JsonProperty("id")
    public void setId(final String id) {
        this.id = id;
    }
    
    @JsonProperty("createdDate")
    public Long getCreatedDate() {
        return this.createdDate;
    }
    
    @JsonProperty("createdDate")
    public void setCreatedDate(final Long createdDate) {
        this.createdDate = createdDate;
    }
    
    @JsonProperty("address")
    public Address getAddress() {
        return this.address;
    }
    
    @JsonProperty("address")
    public void setAddress(final Address address) {
        this.address = address;
    }
    
    @JsonProperty("birthDate")
    public List<Long> getBirthDate() {
        return this.birthDate;
    }
    
    @JsonProperty("birthDate")
    public void setBirthDate(final List<Long> birthDate) {
        this.birthDate = birthDate;
    }
    
    @JsonProperty("firstName")
    public String getFirstName() {
        return this.firstName;
    }
    
    @JsonProperty("firstName")
    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }
    
    @JsonProperty("lastName")
    public String getLastName() {
        return this.lastName;
    }
    
    @JsonProperty("lastName")
    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }
    
    @JsonProperty("phone")
    public String getPhone() {
        return this.phone;
    }
    
    @JsonProperty("phone")
    public void setPhone(final String phone) {
        this.phone = phone;
    }
    
    @JsonProperty("email")
    public String getEmail() {
        return this.email;
    }
    
    @JsonProperty("email")
    public void setEmail(final String email) {
        this.email = email;
    }
    
    @JsonProperty("emailVerified")
    public Boolean getEmailVerified() {
        return this.emailVerified;
    }
    
    @JsonProperty("emailVerified")
    public void setEmailVerified(final Boolean emailVerified) {
        this.emailVerified = emailVerified;
    }
    
    @JsonProperty("state")
    public String getState() {
        return this.state;
    }
    
    @JsonProperty("state")
    public void setState(final String state) {
        this.state = state;
    }
    
    @JsonProperty("referralCode")
    public String getReferralCode() {
        return this.referralCode;
    }
    
    @JsonProperty("referralCode")
    public void setReferralCode(final String referralCode) {
        this.referralCode = referralCode;
    }
    
    @JsonProperty("kyc")
    public String getKyc() {
        return this.kyc;
    }
    
    @JsonProperty("kyc")
    public void setKyc(final String kyc) {
        this.kyc = kyc;
    }
    
    @JsonProperty("termsVersion")
    public String getTermsVersion() {
        return this.termsVersion;
    }
    
    @JsonProperty("termsVersion")
    public void setTermsVersion(final String termsVersion) {
        this.termsVersion = termsVersion;
    }
    
    @JsonProperty("underReview")
    public Boolean getUnderReview() {
        return this.underReview;
    }
    
    @JsonProperty("underReview")
    public void setUnderReview(final Boolean underReview) {
        this.underReview = underReview;
    }
    
    @JsonProperty("riskAssessed")
    public Boolean getRiskAssessed() {
        return this.riskAssessed;
    }
    
    @JsonProperty("riskAssessed")
    public void setRiskAssessed(final Boolean riskAssessed) {
        this.riskAssessed = riskAssessed;
    }
    
    @JsonProperty("locale")
    public String getLocale() {
        return this.locale;
    }
    
    @JsonProperty("locale")
    public void setLocale(final String locale) {
        this.locale = locale;
    }
    
    @JsonProperty("sof")
    public Sof getSof() {
        return this.sof;
    }
    
    @JsonProperty("sof")
    public void setSof(final Sof sof) {
        this.sof = sof;
    }
}
