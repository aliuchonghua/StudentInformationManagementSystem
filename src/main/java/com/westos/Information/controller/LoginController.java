package com.westos.Information.controller;

import com.westos.Information.bean.Student;
import com.westos.Information.service.LoginService;
import com.westos.Information.service.StudentService;
import org.apache.commons.lang3.StringUtils;
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
    private LoginService loginService;
    @Autowired
    private StudentService studentService;
    //登陆
    @RequestMapping(value = "/stulogin", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String login(@RequestBody Student student, HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (student.getStuid().equals(0000)) {
            if (StringUtils.equals(student.getPass(), "admin")) {
                //将管理员账户写入session
                session.setAttribute("currentStudent", student);
                return "/login/manager.html";
            }
        }
        if (loginService.loginmsg(student)) {
            //通过只有账户信息的学生获取完整的学生信息
            student = studentService.currentStudent(student);
            //存入session

            session.setAttribute("currentStudent", student);
            //给前端传递页面跳转的地址
            return "/student_page.html";
        } else {
            return "账户或密码错误";
        }
    }

    //注销
    @RequestMapping("/stulogout")
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        session.removeAttribute("currentStudent");
        try {
            response.sendRedirect("/index.html");
        } catch (IOException e) {
            System.out.println("index重定向失败");
        }

    }

    //跳转到学生端改密码界面
    @RequestMapping("/changePasswordinterface")
    public void changePasswordinterface(HttpServletResponse response) {
        try {
            response.sendRedirect("/Student_changepass.html");
        } catch (IOException e) {
            System.out.println("Student_changepass重定向失败");

        }
    }

    //验证并跳转到管理员界面
    @RequestMapping("/manager.html")
    public void jumpToAdministrator(HttpServletResponse response, HttpServletRequest request) throws IOException {
        HttpSession session = request.getSession();
        Student admin = (Student) session.getAttribute("currentStudent");
        if (StringUtils.equals(admin.getPass(), "admin")) {
            response.sendRedirect("/manager_page.html");
        } else {
            response.sendRedirect("/index.html");
        }
    }

}
