package com.westos.Information.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@RestController
@RequestMapping("/hello")
public class Helloconteroller {

    @RequestMapping("java")
    public String hello(){
        return "hello,java";
    }

    @RequestMapping("/test")
    public void test(HttpServletResponse response) throws IOException {
        response.sendRedirect("/test.html");
    }

}
