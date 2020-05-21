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
     * key 指定要清除的数据
     * allEntries=true 指定清除这个缓存中的所有数据
     * beforeInvocation=false：缓存的清除是否在方法之前执行
     * 默认代表缓存清除操作是方法执行之后，如果出现异常就不会清除
     * beforeInvocation=true 代表清除缓存操作是在方法之前执行，无论是否出现异常，缓存都清除
     */
    @CacheEvict(value="emp",key = "#id")
    public void delete(Integer id) {
        testMybatisMapper.delete(id);
    }

    @Cacheable(cacheNames ={"emp"})
    public Department getOne(Integer id) {
        System.out.println("查询了"+id+"员工");
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
