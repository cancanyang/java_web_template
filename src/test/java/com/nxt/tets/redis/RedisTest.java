package com.nxt.tets.redis;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * Created by snailnan on 2016/9/1.
 */
public class RedisTest {

    private StringRedisTemplate stringRedisTemplate;

    @Before
    public  void setUp(){
        JedisConnectionFactory redisConnectionFactory = new JedisConnectionFactory();
        redisConnectionFactory.setHostName("10.16.6.90");
        this.stringRedisTemplate = new StringRedisTemplate(redisConnectionFactory);
    }
    // 保存字符串
    @Test
    public void test() throws Exception {
        // 保存字符串
        stringRedisTemplate.opsForValue().set("aaa", "111");
        Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));

    }
}
