package com.westos.Information.dao;

import com.westos.Information.bean.Student;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginDao {
//    查询数据库中有没有这个学生
    Student inquiryStudent(Student student);
}
