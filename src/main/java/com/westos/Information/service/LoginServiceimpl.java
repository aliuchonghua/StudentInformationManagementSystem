package com.westos.Information.service;

import com.westos.Information.bean.Student;
import com.westos.Information.dao.LoginDao;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceimpl implements LoginService {

    @Autowired
    private LoginDao loginDao;

    @Override
    public boolean loginmsg(Student student) {
        //返回登陆的结果
        Student stu = loginDao.inquiryStudent(student);
        if (stu==null){
            return false;
        }else {
            return true;
        }

    }
}
