package com.westos.Information.service;

import com.westos.Information.bean.Student;

import java.util.List;

public interface StudentService {
    //    返回所有学生
    List<Student> listAllStudent();
//    返回单个学生
    Student currentStudent(Student student);
//    查找当前学生所在的学院
    String findxueyuan(Student student);
//    查找当前学生的专业名
    String findzhuanye(Student student);
//    查找当前学生的班级名
    String findbanji(Student student);
//  修改学生的密码
    void changePass(Student student);
}
