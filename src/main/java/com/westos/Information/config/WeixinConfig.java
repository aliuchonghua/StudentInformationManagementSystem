package com.westos.Information.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "weixin")
public class WeixinConfig {

    private String token;

    private String appid;

    private String appsecret;

    private String redirect_url;

    @Override
    public String toString() {
        return "WeixinConfig{" +
                "token='" + token + '\'' +
                ", appid='" + appid + '\'' +
                ", appsecret='" + appsecret + '\'' +
                ", redirect_url='" + redirect_url + '\'' +
                '}';
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getAppsecret() {
        return appsecret;
    }

    public void setAppsecret(String appsecret) {
        this.appsecret = appsecret;
    }

    public String getRedirect_url() {
        return redirect_url;
    }

    public void setRedirect_url(String redirect_url) {
        this.redirect_url = redirect_url;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
