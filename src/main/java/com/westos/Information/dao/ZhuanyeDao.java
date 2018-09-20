package com.westos.Information.dao;

import com.westos.Information.bean.Zhuanye;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ZhuanyeDao {
//    查找当前学生所在的专业
    Zhuanye findzhuanye(Zhuanye zhuanye);
}
