package com.westos.Information.service;


import com.westos.Information.bean.Banji;
import com.westos.Information.bean.Student;
import com.westos.Information.bean.Xueyuan;
import com.westos.Information.bean.Zhuanye;
import com.westos.Information.dao.BanjiDao;
import com.westos.Information.dao.StudentDao;
import com.westos.Information.dao.XueyuanDao;
import com.westos.Information.dao.ZhuanyeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceimpl implements StudentService {

    @Autowired
    private StudentDao studentDao;
    @Autowired
    private XueyuanDao xueyuanDao;
    @Autowired
    private ZhuanyeDao zhuanyeDao;
    @Autowired
    private BanjiDao banjiDao;

    //    返回所有学生的列表
    @Override
    public List<Student> listAllStudent() {
        List<Student> students = studentDao.listAllStudent();
        List<Student> lists = new ArrayList<>();
        for (Student s : students) {
            lists.add(settingInformation(s));
        }
        return lists;
    }

    //    查询当前学生
    @Override
    public Student currentStudent(Student student) {
        return studentDao.currentStudent(student);
    }

    //查找当前学生所在的学院名字
    @Override
    public String findxueyuan(Student student) {
//        用xueid打包一个学院
        Xueyuan xueyuan = new Xueyuan();
        xueyuan.setXueid(student.getXueid());
//        查找完整的学院信息
        Xueyuan findxueyuan = xueyuanDao.findxueyuan(xueyuan);
        return findxueyuan.getXuename();
    }

    //查找当前学生的专业
    @Override
    public String findzhuanye(Student student) {
        Zhuanye zhuanye = new Zhuanye();
        zhuanye.setZhuanid(student.getZhuanid());
//        查找完整的专业对象
        Zhuanye findzhuanye = zhuanyeDao.findzhuanye(zhuanye);
        return findzhuanye.getZhuanname();

    }

    //    查找当前学生的班级
    @Override
    public String findbanji(Student student) {
        Banji banji = new Banji();
        banji.setBanid(student.getBanid());
//        查找完整的班级对象
        Banji findbanji = banjiDao.findbanji(banji);
        return findbanji.getBanname();
    }

    //    修改学生的密码
    @Override
    public void changePass(Student student) {
        studentDao.changePass(student);
    }

    @Override
    public Student settingInformation(Student student) {
//        设置学生的学院名
        String xuename = findxueyuan(student);
        student.setXuename(xuename);
//        设置专业名
        String zhuanname = findzhuanye(student);
        student.setZhuanname(zhuanname);
//        设置班级名
        String banname = findbanji(student);
        student.setBanname(banname);
        return student;
    }

    //判断是否存在相同的学号的学生
    @Override
    public String checkStudentConflict(Student student) {
        if (student.getStuid() == null) {
            return "学号不能为空";
        }
        if (student.getStuid().toString().length() != 6) {
            return "学号必须为6位";
        }
        //获取所有的学生
        List<Student> list = listAllStudent();
        for (Student s : list) {
            if (student.getStuid().equals(s.getStuid())) {
                return "存在相同学号的学生";
            }
        }
        return "可以添加";
    }

    //添加学生的方法
    @Override
    public String addStudent(Student student) {
        studentDao.addstudent(student);
        return "添加成功";
    }

    @Override
    public String deleteStudent(Student student) {
        studentDao.deleteStudent(student);
        return "删除成功";
    }

    @Override
    public String modifyStudent(Student student) {
        studentDao.modifyStudent(student);
        return "修改成功";
    }
}
