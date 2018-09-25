package com.westos.Information.controller;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import com.westos.Information.config.WeixinConfig;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;


@RestController
@RequestMapping("/weixin")
public class WeixinController {
    //
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private WeixinConfig weixinConfig;

    @RequestMapping(value = "/auth", method = RequestMethod.GET)
    public String auth(String signature, String timestamp, String nonce, String echostr) {
        logger.info("signature:{}" + signature);
        logger.info("timestamp:{}" + timestamp);
        logger.info("nonce:{}" + nonce);
        logger.info("echostr:{}" + echostr);
        //将token、timestamp、nonce三个参数进行字典序排序
        String[] arr = new String[3];
        arr[0] = weixinConfig.getToken();
        arr[1] = timestamp;
        arr[2] = nonce;
        //排序
        Arrays.sort(arr);
        //拼接
        String join = StringUtils.join(arr);
        //加密
        String s = DigestUtils.sha1Hex(join);

        if (StringUtils.equals(s, signature)) {
            return echostr;
        } else {
            return "error";
        }
    }

    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    public String message(HttpServletRequest request) throws IOException, DocumentException {
        //已流的方式接收
        ServletInputStream is = request.getInputStream();
        String msg = IOUtils.toString(is, "utf-8");
        logger.info("msg{}", msg);
        Document document = DocumentHelper.parseText(msg);
        //分别读取数据
        String toUserName = document.getRootElement().elementText("ToUserName");
        String fromUserName = document.getRootElement().elementText("FromUserName");
        String content = document.getRootElement().elementText("Content");
        String msgType = document.getRootElement().elementText("MsgType");

        String result = "success";
        String txtmsg = "<xml><ToUserName><![CDATA[" + fromUserName + "]]></ToUserName>\n" +
                "<FromUserName><![CDATA[" + toUserName + "]]></FromUserName>\n" +
                "<CreateTime>" + (new Date()).getTime() + "</CreateTime>\n" +
                "<MsgType><![CDATA[text]]></MsgType>\n" +
                "<Content><![CDATA[大家好hello]]></Content>\n" +
                "</xml>";
        logger.info("result:{}", txtmsg);
        return txtmsg;
    }

}
