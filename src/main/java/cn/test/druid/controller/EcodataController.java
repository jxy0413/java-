package cn.test.druid.controller;

//import cn.test.druid.common.ResultModel;
//import cn.test.druid.model.Department;
//import cn.test.druid.model.Ecodata;
//import cn.test.druid.service.EcodataService;
//import io.swagger.annotations.ApiOperation;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * @Auther jxy
// * @Date 2020-04-30
// */
//@RestController
//@RequestMapping("/ecodata")
//public class EcodataController {
//    @Autowired
//    private EcodataService ecodataService;
//    @ApiOperation("查询某一接口")
//    @GetMapping("/get/{datanumId}")
//    public ResultModel get(@PathVariable("datanumId") Long datanumId){
//        Ecodata ecodata =ecodataService.get(datanumId);
//        return ResultModel.ok(ecodata);
//    }
//}
