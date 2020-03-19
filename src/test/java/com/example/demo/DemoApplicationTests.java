package com.example.demo;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class DemoApplicationTests {
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    void contextLoads() {
        //操作字符串
        redisTemplate.opsForValue().set("name","sunshangkun");
        System.out.println(redisTemplate.opsForValue().get("name"));
        Boolean name = redisTemplate.delete("name");
        if(name){
            System.out.println("删除成功");
        }
        //操作List
        List<String> list = new ArrayList<String>();
        list.add("张三");
        list.add("lisi");
        list.add("王五");
        Long namelist = redisTemplate.opsForList().leftPush("namelist", list);
        System.out.println(namelist+"---------");
        System.out.println(redisTemplate.opsForList().rightPop("namelist"));

    }

}
