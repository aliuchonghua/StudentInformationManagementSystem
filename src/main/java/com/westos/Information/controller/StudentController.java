package com.westos.Information.controller;

import com.westos.Information.bean.Student;
import com.westos.Information.service.StudentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

//  查找当前登陆的学生并封装学生的学院班级专业名
    @RequestMapping("/currentStudent")
    public Student currentStudent(HttpServletRequest request){

        HttpSession session = request.getSession();
//        获取当前登陆的学生
        Student student = (Student) session.getAttribute("currentStudent");
        //设置学生的班级专业学院的名字
        student = studentService.settingInformation(student);
//        替换session中的学生
        session.setAttribute("currentStudent",student);
        return student;
    }
//    判断输入的学生账户和密码是否为当前登陆的学生
    @RequestMapping(value = "/returnCurrentStudent",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String returnCurrentStudent(@RequestBody Student student,HttpServletRequest request){
        HttpSession session = request.getSession();
        Student currentStudent = (Student) session.getAttribute("currentStudent");
        if(!student.getStuid().equals(currentStudent.getStuid())){
            return "学号与当前账户不符";
        }else if (!StringUtils.equals(student.getPass(),currentStudent.getPass())){
            return "密码不正确";
        }else {
            return "账户正确";
        }


    }
    //修改当前学生的密码
    @RequestMapping(value = "/changepass",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void changePass(@RequestBody Student student,HttpServletRequest request){
//        获取当前学生
        HttpSession session = request.getSession();
        Student currentStudent = (Student) session.getAttribute("currentStudent");
//        修改对象的密码
        currentStudent.setPass(student.getPass());
//        传给service
        studentService.changePass(currentStudent);
//        清除session中的学生
        session.removeAttribute("currentStudent");
    }



}
