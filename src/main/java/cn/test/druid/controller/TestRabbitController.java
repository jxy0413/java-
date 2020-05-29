package cn.test.druid.controller;

import cn.test.druid.service.RabbitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther jxy
 * @Date 2020-05-22
 */
@RestController
@RequestMapping("rabbit")
public class TestRabbitController {
    @Autowired
    private RabbitService rabbitService;

    @GetMapping("/test")
    public void testRabbit(){
        rabbitService.contextLoads();
    }

    @GetMapping
    public void testSendRabbit(){
        rabbitService.sendBook();
    }
}
