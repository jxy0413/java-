package cn.test.druid.service;

import cn.test.druid.config.RedisConfig;
import cn.test.druid.model.User;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.DefaultTypedTuple;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Auther jxy
 * @Date 2020-05-15
 */
@Service
public class RedisService implements Serializable {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    public void testRedis(){
        Integer append = stringRedisTemplate.opsForValue().append("jia1", "shi");
        stringRedisTemplate.opsForList().leftPush("myList","k1");
    }

    public void testObjectRedis(){
        User user = new User();
        user.setEmail("15011006250@163.com");
        user.setId(1);
        user.setLastName("jiaxiangyu");
        //userRedisTemplate.opsForValue().set("user",user);
    }

    public void testRedisTemplate(){
        String str = "hash1";
        Map<String,String> map = new HashMap<>();
        User user = new User();
        user.setEmail("15011006250@163.com");
        user.setId(1);
        user.setLastName("jiaxiangyu");
        map.put("jia","jia");
        //操作字符串
        stringRedisTemplate.opsForValue().set("k2","v1");
        System.out.println(stringRedisTemplate.opsForValue().get("k1"));
        //操作hash
        //userRedisTemplate.opsForHash().putAll(str,map);
        //System.out.println(userRedisTemplate.opsForValue().get(str));
        //操作list
         stringRedisTemplate.opsForList().leftPush("k2","v1");
        //操作set
        stringRedisTemplate.opsForSet().add("k2","v5");
        //操作有序zset
        ZSetOperations.TypedTuple<Object> objectTypedTuple1 = new DefaultTypedTuple<Object>("zset-5",9.6);
        ZSetOperations.TypedTuple<Object> objectTypedTuple2 = new DefaultTypedTuple<Object>("zset-6",9.9);
        Set tuples = new HashSet<ZSetOperations.TypedTuple<String>>();
        tuples.add(objectTypedTuple1);
        tuples.add(objectTypedTuple2);
        stringRedisTemplate.opsForZSet().add("redisZSet1",tuples);
    }
}
