package cn.test.druid.service;

import cn.test.druid.mapper.TestMybatisMapper;
import cn.test.druid.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther jxy
 * @Date 2020-04-19
 */
@Service
public class TestMybatisService {
    @Autowired
    private TestMybatisMapper testMybatisMapper;

    public List<Department> get() {
        return testMybatisMapper.get();
    }

    public void create(Department department) {
        testMybatisMapper.create(department);
    }

    public void update(Department department) {
        testMybatisMapper.update(department);
    }

    public void delete(Integer id) {
        testMybatisMapper.delete(id);
    }
}
