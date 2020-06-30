// 
// Decompiled by Procyon v0.5.36
// 

package bot.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "proxyHost", "proxyPort", "proxyUser", "proxyPassword", "proxyType" })
public class Proxy
{
    @JsonProperty("proxyHost")
    private String proxyHost;
    @JsonProperty("proxyPort")
    private Integer proxyPort;
    @JsonProperty("proxyUser")
    private String proxyUser;
    @JsonProperty("proxyPassword")
    private String proxyPassword;
    @JsonProperty("proxyType")
    private java.net.Proxy.Type proxyType;
    
    public Proxy(final String proxyHost, final Integer proxyPort, final String proxyUser, final String proxyPassword, final java.net.Proxy.Type proxyType) {
        this.proxyHost = proxyHost;
        this.proxyPort = proxyPort;
        this.proxyUser = proxyUser;
        this.proxyPassword = proxyPassword;
        this.proxyType = proxyType;
    }
    
    public Proxy() {
    }
    
    @JsonProperty("proxyHost")
    public String getProxyHost() {
        return this.proxyHost;
    }
    
    @JsonProperty("proxyHost")
    public void setProxyHost(final String proxyHost) {
        this.proxyHost = proxyHost;
    }
    
    @JsonProperty("proxyPort")
    public Integer getProxyPort() {
        return this.proxyPort;
    }
    
    @JsonProperty("proxyPort")
    public void setProxyPort(final Integer proxyPort) {
        this.proxyPort = proxyPort;
    }
    
    @JsonProperty("proxyUser")
    public String getProxyUser() {
        return this.proxyUser;
    }
    
    @JsonProperty("proxyUser")
    public void setProxyUser(final String proxyUser) {
        this.proxyUser = proxyUser;
    }
    
    @JsonProperty("proxyPassword")
    public String getProxyPassword() {
        return this.proxyPassword;
    }
    
    @JsonProperty("proxyPassword")
    public void setProxyPassword(final String proxyPassword) {
        this.proxyPassword = proxyPassword;
    }
    
    @JsonProperty("proxyType")
    public java.net.Proxy.Type getProxyType() {
        return this.proxyType;
    }
    
    @JsonProperty("proxyType")
    public void setProxyType(final java.net.Proxy.Type proxyType) {
        this.proxyType = proxyType;
    }
    
    @Override
    public String toString() {
        return "Proxy " + this.proxyHost + ":" + this.proxyPort;
    }
    
    public static void main(final String[] args) {
    }
}
