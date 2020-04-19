package cn.test.druid.controller;

import cn.test.druid.common.ResultModel;
import cn.test.druid.model.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Auther jxy
 * @Date 2020-04-19
 */
@RestController
@RequestMapping("/user")
public class TestJpaController {
    @Autowired
    private JpaRepository jpaRepository;
    @ApiOperation("查询所有接口")
    @GetMapping("/get")
    public ResultModel get(){
        List list = jpaRepository.findAll();
        return ResultModel.ok(list);
    }

    @ApiOperation("创建接口")
    @PostMapping("/create")
    public ResultModel create(@RequestBody User user){
        jpaRepository.save(user);
        return ResultModel.ok(null);
    }

    @DeleteMapping("/delete/{id}")
    public ResultModel delete(@PathVariable Integer id){
        jpaRepository.deleteById(id);
        return ResultModel.ok(null);
    }
}
