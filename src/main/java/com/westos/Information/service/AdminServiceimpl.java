package com.westos.Information.service;

import com.westos.Information.bean.Banji;
import com.westos.Information.bean.Xueyuan;
import com.westos.Information.bean.Zhuanye;
import com.westos.Information.dao.BanjiDao;
import com.westos.Information.dao.XueyuanDao;
import com.westos.Information.dao.ZhuanyeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceimpl implements AdminService {
    @Autowired
    private XueyuanDao xueyuanDao;
    @Autowired
    private ZhuanyeDao zhuanyeDao;
    @Autowired
    private BanjiDao banjiDao;

    //    返回所有的学院
    @Override
    public List<Xueyuan> listxueyuan() {
        return xueyuanDao.listxueyuan();
    }

    //通过学院找专业
    @Override
    public List<Zhuanye> xueyuanidfindtozhuanye(Xueyuan xueyuan) {
        Zhuanye zhuanye = new Zhuanye();
        zhuanye.setXueid(xueyuan.getXueid());
        List<Zhuanye> listzhuanye = zhuanyeDao.listzhuanye(zhuanye);
        return listzhuanye;
    }

    @Override
    public List<Banji> zhuanyefintobanji(Zhuanye zhuanye) {
        Banji banji = new Banji();
        banji.setZhuanid(zhuanye.getZhuanid());
        return banjiDao.listbanji(banji);
    }


}
