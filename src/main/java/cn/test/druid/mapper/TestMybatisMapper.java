package cn.test.druid.mapper;

import cn.test.druid.model.Department;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Auther jxy
 * @Date 2020-04-19
 */
@Mapper
public interface TestMybatisMapper {
    @Select("select * from department")
    public List<Department> get();

    @Insert("insert into department(department_name)values(#{departmentName})")
    void create(Department department);

    @Update("update department set department_name=#{departmentName} where id = #{id}")
    void update(Department department);

    @Delete("delete from department where id=#{id}")
    void delete(Integer id);

    @Select("select * from department where id = #{id}")
    Department getOne(Integer id);

    @Select("select * from department where department_name = #{departmentName}")
    Department getDepartmentByName(String departmentName);
}
