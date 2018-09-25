package com.westos.Information.dao;

import com.westos.Information.bean.Zhuanye;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ZhuanyeDao {
    //    通过zhuanid找专业
    Zhuanye findzhuanye(Zhuanye zhuanye);

    //    List<Xueyuan> listxueyuan();
    //通过xueid找专业
    List<Zhuanye> listzhuanye(Zhuanye zhuanye);
}
