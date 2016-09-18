package com.nxy.web.redis;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.nxy.web.App;

/**
 * Created by snailnan on 2016/9/5.
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class AutoRedisTest {

	@Autowired
	private RedisTemplate redisTemplate;

	@Test
	public void test() {
		// redisTemplate.opsForList().leftPush("test_list",1);
		List<Integer> list = redisTemplate.opsForList().range("test_list", 0, -1);
		list.stream().forEach(i -> System.out.println(i));
		// redisTemplate.opsForZSet().add("test_zset",1,11);
		// redisTemplate.opsForZSet().add("test_zset",3,9);
	}

	@Test
	public void testSset() {
//		Set<Integer> sset = redisTemplate.opsForZSet().reverseRange("test_zset", 0, -1);
        redisTemplate.opsForZSet().add("test_zset",8,20);
//		sset.stream().filter(i -> (i > 1)).forEach(i -> System.out.println(i));
	}
}
