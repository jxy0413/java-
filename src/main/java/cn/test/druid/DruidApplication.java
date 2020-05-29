package cn.test.druid;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * 自动配置
 * 1.RabbitAutoConfiguration
 * 2.有自动配置连接工厂ConnectionnFactory
 * 3.RabbitProperties封装了 RabbitMQ
 * 4.RabbitTemplate 给RabbitMQ发送和接收消息
 * 5.AmqpAdmin:RabbitMQ系统管理功组件
 *   AmqpAdmin:创建和删除 Queue,Exchange,Binging
 * 6 @EnableRabbit + @RabbiitListener 监听消息队列的内容
 */
@MapperScan("cn.test.druid.*")
@SpringBootApplication
@EnableCaching
@EnableRabbit //基于开启注解的RabbitMQ模式
public class DruidApplication {

    public static void main(String[] args) {
        SpringApplication.run(DruidApplication.class, args);
    }

}
