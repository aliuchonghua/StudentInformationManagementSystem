package com.westos.Information.dao;
import com.westos.Information.bean.Xueyuan;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface XueyuanDao {
    //    查找当前学生所在的学院
    Xueyuan findxueyuan(Xueyuan xueyuan);

    //返回所有的学院
    List<Xueyuan> listxueyuan();
}
