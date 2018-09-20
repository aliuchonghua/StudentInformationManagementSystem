package com.westos.Information.controller;

import com.westos.Information.bean.Student;
import com.westos.Information.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService ;
    //登陆

    @RequestMapping(value = "/stulogin",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String login(@RequestBody Student student ,HttpServletRequest request) throws IOException {
        if (loginService.loginmsg(student)){
            HttpSession session = request.getSession();
            session.setAttribute("currentStudent",student);
            return "/Student_manager.html";
        }else {
            return "登陆失败";
        }
    }
    //注销
    @RequestMapping("/stulogout")
    public void logout(HttpServletRequest request,HttpServletResponse response){
        HttpSession session = request.getSession();
        session.removeAttribute("currentStudent");
        try {
            response.sendRedirect("/index.html");
        } catch (IOException e) {
            System.out.println("index重定向失败");
        }

    }
    //跳转到改密码界面
    @RequestMapping("/changePasswordinterface")
    public void changePasswordinterface(HttpServletResponse response){
        try {
            response.sendRedirect("/Student_changepass.html");
        } catch (IOException e) {
            System.out.println("Student_changepass重定向失败");

        }
    }

}
