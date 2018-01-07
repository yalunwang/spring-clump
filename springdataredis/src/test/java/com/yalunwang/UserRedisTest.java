package com.yalunwang;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.BoundValueOperations;
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

    /**
     * 测试string
     */
    @Test
    public void teststring() {
        redisTemplate.opsForValue().set("nickname", "小穗穗");
        System.out.println(redisTemplate.opsForValue().get("nickname"));

    }

    /**
     * 测试list
     */
    @Test
    public void testlist() {
        //往头部添加
        redisTemplate.opsForList().leftPush("list", "one");
        redisTemplate.opsForList().leftPush("list", "two");
        redisTemplate.opsForList().leftPush("list","tree");
        // 索引 0 tree 1 two 2 one

        // 从头部弹出 0 tree
        String list=   redisTemplate.opsForList().leftPop("list").toString();
        // 返回key list 的长度
        redisTemplate.opsForList().size("list");
        //修改 key list 索引 0 的value
        redisTemplate.opsForList().set("list", 0, "修改过的");
        //返回 key list start 0 end 1  的value
        redisTemplate.opsForList().range("list",0,1);

    }

    /**
     * 测试bound key
     */
    @Test
    public void testbound() {
        BoundValueOperations<String,String>  nicknameOper= redisTemplate.boundValueOps("nickname");
        nicknameOper.set("小麦穗");
        String nickname= nicknameOper.get();
        System.out.println(nickname);
    }
    @Test
    public void test() {

        User user=new User();
        //user.setAge(23);
        user.setUserName("张三");
        user.setEmail("6666@qq.com");
        redisTemplate.opsForValue().set("user", user); //stringRedisTemplate.opsForValue().set("ni", user);
//        User userRedis=(User)redisTemplate.opsForValue().get("user");
//        System.out.println(userRedis);
        ValueOperations<String,User> valueOperations=redisTemplate.opsForValue();
        User user1=valueOperations.get("user");
        System.out.println(user1);
    }
}
