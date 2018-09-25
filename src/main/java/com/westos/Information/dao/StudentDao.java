package com.westos.Information.dao;

import com.westos.Information.bean.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

//Mapper标记dao
@Mapper
public interface StudentDao {
//    查找所有学生
    List<Student> listAllStudent();
//    查找当前学生
    Student currentStudent(Student student);
//  修改当前学生的密码
    Integer changePass(Student student);

    //添加学生
    void addstudent(Student student);

    //删除学生
    Integer deleteStudent(Student student);

    //修改学生
    Integer modifyStudent(Student student);

}
