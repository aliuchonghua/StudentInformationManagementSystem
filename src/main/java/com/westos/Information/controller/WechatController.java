package com.westos.Information.controller;

import com.westos.Information.config.WeixinConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("/wei")
public class WechatController {
    @Autowired
    private WeixinConfig weixinConfig;

    @RequestMapping("/auth")
    public String auth(HttpServletResponse response) throws IOException {
        String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=%s&redirect_uri=%s&response_type=code&scope=snsapi_userinfo&state=123#wechat_redirect";
        String redirecturl = weixinConfig.getRedirect_url();
        redirecturl = URLEncoder.encode(redirecturl, StandardCharsets.UTF_8);
        url = String.format(url, weixinConfig.getAppid(), redirecturl);
        //页面重定向
        response.sendRedirect(url);
        return null;
    }
}
