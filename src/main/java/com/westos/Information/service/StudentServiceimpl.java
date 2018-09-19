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
        return studentDao.listAllStudent();
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

    @Override
    public String findzhuanye(Student student) {
        Zhuanye zhuanye=new Zhuanye();
        zhuanye.setZhuanid(student.getZhuanid());
//        查找完整的专业对象
        Zhuanye findzhuanye = zhuanyeDao.findzhuanye(zhuanye);
        return findzhuanye.getZhuanname();

    }

    @Override
    public String findbanji(Student student) {
        Banji banji=new Banji();
        banji.setBanid(student.getBanid());
//        查找完整的班级对象
        Banji findbanji = banjiDao.findbanji(banji);
        return findbanji.getBanname();
    }
}
