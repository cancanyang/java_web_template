package com.nxy.web.Scheduled;

import java.util.Date;
import java.util.concurrent.ScheduledFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Component;

/**
 * Created by snailnan on 2016/10/11.
 */
@Component(value = "taskScheduler")
public class RedisThreadPoolScheduler extends ThreadPoolTaskScheduler {

    public static final Logger logger = LoggerFactory.getLogger(RedisThreadPoolScheduler.class);

    @Override
    public ScheduledFuture<?> schedule(Runnable task, Trigger trigger) {
        logger.info("schedule base");
        return super.schedule(task, trigger);
    }

    @Override
    public ScheduledFuture<?> schedule(Runnable task, Date startTime) {
        logger.info("schedule data");
        return super.schedule(task, startTime);
    }

    @Override
    public ScheduledFuture<?> scheduleAtFixedRate(Runnable task, Date startTime, long period) {
        logger.info("schedule data period");
        return super.scheduleAtFixedRate(task, startTime, period);
    }

    @Override
    public ScheduledFuture<?> scheduleAtFixedRate(Runnable task, long period) {
        logger.info("schedule  period");
        return super.scheduleAtFixedRate(task, period);
    }

    @Override
    public ScheduledFuture<?> scheduleWithFixedDelay(Runnable task, Date startTime, long delay) {
        return super.scheduleWithFixedDelay(task, startTime, delay);
    }

    @Override
    public ScheduledFuture<?> scheduleWithFixedDelay(Runnable task, long delay) {
        return super.scheduleWithFixedDelay(task, delay);
    }
}
