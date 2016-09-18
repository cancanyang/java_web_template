package com.nxy.web.aop;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.support.CronSequenceGenerator;
import org.springframework.stereotype.Component;

import com.nxy.web.Scheduled.ScheduledLock;

/**
 * Created by snailnan on 2016/9/9.
 */
@Aspect
@Component
public class ScheduledLockAop {
    private static final Logger logger = LoggerFactory.getLogger(ScheduledLockAop.class);
    private static final int MAX_INTERVAL = 900; //最大15分钟
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private ApplicationContext context;

    @Around("@annotation(scheduledLock) && @annotation(scheduled)")
    public void aroundJob(ProceedingJoinPoint pjp, ScheduledLock scheduledLock, Scheduled scheduled) throws Throwable{

        String key = generatorKey(pjp);
        logger.info(key);
        String cron = scheduled.cron();
        long currentTimeMillis = System.currentTimeMillis();
        int nextScheduledInterval = getNextScheduledInterval(cron);
        boolean lock = redisTemplate.opsForValue().setIfAbsent(key,currentTimeMillis);
        if (lock) { // 获取锁
            redisTemplate.expire(key,nextScheduledInterval, TimeUnit.SECONDS);
            pjp.proceed();
        } else {

        }
    }

    /**
     * 获取下次执行任务的时间间隔
     *
     * @param cron
     * @return
     */
    private final int getNextScheduledInterval(String cron) {
        CronSequenceGenerator gronSequenceGenerator = new CronSequenceGenerator(cron);
        Date d1 = gronSequenceGenerator.next(new Date());
        Date d2 = gronSequenceGenerator.next(d1);
        long time = d2.getTime() - d1.getTime();
        int interval = (int) Math.floor(time / 1000);
        /**
         减去redis的和方法执行性的耗时，由于redisClient的失效时间设置是秒级，
         只能减去1秒，可能会导致1s的定时任务执行周期为2秒 应减去100ms比较好
         */
        interval = interval -1;
        if (interval < 1 ){
            return 1; // 不足1秒为1秒 不要为0
        }else if (interval > MAX_INTERVAL){
            return MAX_INTERVAL;
        }
        return interval;
    }

    /**
     * 生成key
     *
     * @param pip
     * @return
     */
    private final String generatorKey(ProceedingJoinPoint pip) throws NoSuchMethodException {
        MethodSignature sign = (MethodSignature) pip.getSignature();
        Object target = pip.getTarget();
        Object[] args = pip.getArgs();

        Method method = target.getClass().getMethod(sign.getName(), sign.getParameterTypes());
        StringBuilder sb = new StringBuilder();
        sb.append(target.getClass().getName());
//        sb.append(method.getName());
//        for (Object obj : args) {
//            sb.append(obj.toString());
//        }
        return sb.toString();

    }
}
