package cn.test.druid.mapper;

import cn.test.druid.model.Department;
import cn.test.druid.model.Ecodata;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Auther jxy
 * @Date 2020-04-30
 */
@Mapper
public interface EcodataMapper {
    @Select("select * from ecodata where datanum_id=#{datanumId}")
    public Ecodata get(Long datanumId);
}
