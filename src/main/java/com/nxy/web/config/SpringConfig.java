package com.nxy.web.config;

import com.nxy.web.Scheduled.RedisThreadPoolScheduler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

/**
 * Created by snailnan on 2016/9/1.
 */
@Configuration
@ImportResource(locations = "classpath:spring-mvc.xml")
public class SpringConfig {
    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
    @Bean
    public ThreadPoolTaskScheduler threadPoolScheduler(){
        return new RedisThreadPoolScheduler();
    }

}
