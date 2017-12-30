package com.yalunwang;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-context.xml"})
public class UserRedisTest {
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisConnectionFactory cf;

    @Test
    public void tes1() {

//        RedisConnection conn = cf.getConnection();
//        conn.set("user".getBytes(), "xiaoming".getBytes());
//
//        String ss = new String(conn.get("user".getBytes()));
//        System.out.println(ss);

        redisTemplate.opsForValue().set("ni", "xiachengxi");

        System.out.println(redisTemplate.opsForValue().get("ni"));


        //stringRedisTemplate.opsForValue().set("hh", "小穗穗");
        System.out.println(stringRedisTemplate.opsForValue().get("ni"));
    }
    @Test
    public void test() {

        User user=new User();
        user.setAge(23);
        user.setUserName("张三");
        user.setEmail("6666@qq.com");
        redisTemplate.opsForValue().set("user", user); stringRedisTemplate.opsForValue().set("ni", user);
//        User userRedis=(User)redisTemplate.opsForValue().get("user");
//        System.out.println(userRedis);
        ValueOperations<String,User> valueOperations=redisTemplate.opsForValue();
        User user1=valueOperations.get("user");
        System.out.println(user1);




    }
}
