package cn.test.druid.controller;

import cn.test.druid.common.ResultModel;
import cn.test.druid.model.Department;
import cn.test.druid.service.TestMybatisService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Auther jxy
 * @Date 2020-04-19
 */
@RestController
@RequestMapping("/dept")
@Api(value = "testMybatisController", description = "用户信息测试controller")
public class TestMybatisController {
    @Autowired
    private TestMybatisService testMybatisService;

    @ApiOperation("查询所有接口")
    @GetMapping("/getList")
    public ResultModel getList(){
        System.out.println("查询所有员工");
        List<Department> list = testMybatisService.get();
        return ResultModel.ok(list);
    }

    @ApiOperation("查询某一个员工接口")
    @GetMapping("/get/{id}")
    public ResultModel get(@PathVariable("id") Integer id){
        System.out.println("===");
        Department department = testMybatisService.getOne(id);
        return ResultModel.ok(department);
    }

    @ApiOperation("创建接口")
    @PostMapping("/create")
    public ResultModel create(@RequestBody Department department){
        testMybatisService.create(department);
        return ResultModel.ok(null);
    }

    @GetMapping("/update")
    public ResultModel update(Department department){
        testMybatisService.update(department);
        return ResultModel.ok(null);
    }

    @DeleteMapping("/delete/{id}")
    public ResultModel delete(@PathVariable Integer id){
        testMybatisService.delete(id);
        return ResultModel.ok(null);
    }

    @ApiOperation("查询某一个员工接口")
    @GetMapping("/get/{departmentName}")
    public ResultModel get(@PathVariable("departmentName") String departmentName){
        Department department = testMybatisService.getDepartmentByName(departmentName);
        return ResultModel.ok(department);
    }
}
