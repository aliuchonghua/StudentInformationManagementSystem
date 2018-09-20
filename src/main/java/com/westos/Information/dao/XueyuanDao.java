package com.westos.Information.dao;
import com.westos.Information.bean.Xueyuan;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface XueyuanDao {
    //    查找当前学生所在的学院
    Xueyuan findxueyuan(Xueyuan xueyuan);
}
