package cn.test.druid.service;

import cn.test.druid.mapper.TestMybatisMapper;
import cn.test.druid.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;


import java.util.List;

/**
 * @Auther jxy
 * @Date 2020-04-19
 */
@CacheConfig(cacheNames = "emp") //抽取缓存的公共被配
@Service
public class TestMybatisService {
    @Autowired
    private TestMybatisMapper testMybatisMapper;

    @Cacheable(cacheNames={"emp"})
    public List<Department> get() {
        System.out.println("====");
        return testMybatisMapper.get();
    }

    public void create(Department department) {
        testMybatisMapper.create(department);
    }

    /**
     * @CachePut 修改数据 并且更新缓存
     * @param department
     * 运行时机：
     * 1。先调用目标方法
     * 2。在目标方法的结果缓存进去
     */
    @CachePut(value = "emp",key="#department.id")
    public void update(Department department) {
        testMybatisMapper.update(department);
    }

    /**
     * @Cacheevict:缓存清楚
     */
    @CacheEvict(value="emp",key = "#id")
    public void delete(Integer id) {
        testMybatisMapper.delete(id);
    }

    @Cacheable(value = {"genOne"},key ="#id")
    public Department getOne(Integer id) {
        return testMybatisMapper.getOne(id);
    }

    @Caching(
            cacheable = {
                    @Cacheable(value="emp",key="#lastName")
            },
            put={
                    @CachePut(value="emp",key="#result.id")
            }
    )
    public Department getDepartmentByName(String departmentName){
        return testMybatisMapper.getDepartmentByName(departmentName);
    }
}
