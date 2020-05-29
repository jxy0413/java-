package cn.test.druid.service;

import cn.test.druid.model.Book;
import org.junit.Test;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther jxy
 * @Date 2020-05-22
 */
@Service
public class RabbitService {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private AmqpAdmin amqpAdmin;

    public void createExchange(){
           //创造Exchange 交换器
           amqpAdmin.declareExchange(new DirectExchange("amqpadmin.exchange"));
           System.out.println("创建完成");
           //创造队列
           amqpAdmin.declareQueue(new Queue("adqpadmin.queue",true));
           //创造绑定规则
           amqpAdmin.declareBinding(new Binding("adqpadmin.queue",Binding.DestinationType.QUEUE,"amqpadmin.exchange","amqp.haha",null));
    }

    /**
     * 1 单播  （点对点）
     */
    public void contextLoads(){
        //message需要  convertAndSend object默认是自动消息体的
        Map<String,Object> map = new HashMap<>();
        map.put("msg","这是第一个消息");
        map.put("data", Arrays.asList("hello",123,true));
        //对象
        rabbitTemplate.convertAndSend("exchange.direct","atguigu.news",map);

    }

    /**
     * 接受数据
     */
     public void receiveMessage(){
         Object o = rabbitTemplate.receiveAndConvert("atguigu.news");
         System.out.println(o.getClass());
         System.out.println(o);
     }

    /**
     *  如何将数据自动转为JSon发送出去
     */
    public void sendBook(){
        rabbitTemplate.convertAndSend("exchange.direct","atguigu.news",new Book("西游记","吴承恩"));
    }

    /**
     * 广播
     */
    public void sendguangbo(){
        rabbitTemplate.convertAndSend("exchange.fanout",null,new Book("三国演义","罗贯中"));
    }
}

