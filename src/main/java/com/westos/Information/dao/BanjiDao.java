package com.westos.Information.dao;

import com.westos.Information.bean.Banji;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BanjiDao {
    //查找学生所在的班级
    Banji findbanji(Banji banji);

    //通过zhuanid找班级
    List<Banji> listbanji(Banji banji);
}
