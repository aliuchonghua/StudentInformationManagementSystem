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

    //    设置学生的班级专业学院的名字
    Student settingInformation(Student student);

    //判断是否存在相同的学号的学生
    String checkStudentConflict(Student student);

    //添加学生的方法
    String addStudent(Student student);

    //删除学生
    String deleteStudent(Student student);

    //修改学生
    String modifyStudent(Student student);


}
