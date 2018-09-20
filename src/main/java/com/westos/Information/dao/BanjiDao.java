package com.westos.Information.dao;

import com.westos.Information.bean.Banji;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BanjiDao {
    //查找学生所在的班级
    Banji findbanji(Banji banji);
}
