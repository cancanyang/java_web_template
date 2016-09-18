package com.nxy.web.web;

import com.nxy.web.Service.CacheService;
import com.nxy.web.vo.Nxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by snailnan on 2016/8/30.
 */
@RestController
@RequestMapping("/hello")
public class HelloController {
    @Autowired
    private Nxy nxy;
    @Autowired
    private CacheService cacheService;
    @Autowired
    private RedisTemplate redisTemplate;

	@RequestMapping("")
    public String world(){
        return "world";
    }

    @RequestMapping("/nxy")
    public Nxy getNxy(){
        return nxy;
    }

    @RequestMapping("/nxyofcache")
    public Nxy getNxyFromCache(){
        return cacheService.getNxy();
    }

    @RequestMapping("/redis")
    public String  redis(@RequestParam(name = "param")String param){
        redisTemplate.opsForValue().set("test_params",param);
        return param;
    }
}
