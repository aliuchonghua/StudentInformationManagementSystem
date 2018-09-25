package com.westos.Information.controller;

import com.westos.Information.bean.Banji;
import com.westos.Information.bean.Student;
import com.westos.Information.bean.Xueyuan;
import com.westos.Information.bean.Zhuanye;
import com.westos.Information.service.AdminService;
import com.westos.Information.service.StudentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private AdminService adminService;

    //跳转到学生管理页面
    @RequestMapping("/managingStudents")
    public void managingStudents(HttpServletResponse response) {
        try {
            response.sendRedirect("/manage_students.html");
        } catch (IOException e) {
            System.out.println("跳转到学生管理界面失败");
        }
    }

    //返回所有的学生
    @RequestMapping(value = "/listall", method = RequestMethod.GET)
    public List<Student> listStudent() {
        return studentService.listAllStudent();
    }

    //添加学生
    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String add(@RequestBody Student student) {
//        如果该学生学号与数据库不冲突则添加
        if (StringUtils.equals(studentService.checkStudentConflict(student), "可以添加")) {
//            添加并返回判断信息
            return studentService.addStudent(student);
        } else {
            //返回的是学号相关的判断信息
            return studentService.checkStudentConflict(student);
        }
    }

    //修改学生
    @RequestMapping(value = "/modifyStudent", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String modifyStudent(@RequestBody Student student) {
        return studentService.modifyStudent(student);
    }

    //返回所有的学院
    @RequestMapping(value = "/allColleges", method = RequestMethod.GET)
    public List<Xueyuan> listxueyuan() {
        return adminService.listxueyuan();
    }

    //返回通过学院id找到的所有的专业
    @RequestMapping(value = "/xuetozhuan", method = RequestMethod.POST)
    public List<Zhuanye> xueyuanidfindtozhuanye(@RequestBody Xueyuan xueyuan) {
        return adminService.xueyuanidfindtozhuanye(xueyuan);
    }

    //通过专业找班级列表
    @RequestMapping(value = "/zhuantoban", method = RequestMethod.POST)
    public List<Banji> zhuanyefintobanji(@RequestBody Zhuanye zhuanye) {
        return adminService.zhuanyefintobanji(zhuanye);
    }

    //删除
    //还需添加删除同时删除相关成绩表的功能
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deleteStudent(@RequestBody Student student) {
        return studentService.deleteStudent(student);
    }
}
