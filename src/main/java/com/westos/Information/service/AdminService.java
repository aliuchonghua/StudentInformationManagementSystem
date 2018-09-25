package com.westos.Information.service;

import com.westos.Information.bean.Banji;
import com.westos.Information.bean.Xueyuan;
import com.westos.Information.bean.Zhuanye;

import java.util.List;

public interface AdminService {
    //返回所有的学院
    List<Xueyuan> listxueyuan();

    //通过学院找专业
    List<Zhuanye> xueyuanidfindtozhuanye(Xueyuan xueyuan);

    //通过专业找班级
    List<Banji> zhuanyefintobanji(Zhuanye zhuanye);

}
