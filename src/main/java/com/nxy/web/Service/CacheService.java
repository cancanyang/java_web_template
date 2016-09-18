package com.nxy.web.Service;

import com.nxy.web.vo.Nxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * Created by snailnan on 2016/9/1.
 */
@Component
public class CacheService {
    @Autowired
    private Nxy nxy;

    @Cacheable("redisCache")
    public Nxy getNxy(){
        return nxy;
    }
}
