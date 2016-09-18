package com.nxy.web.Scheduled;

import com.nxy.web.config.ScheduledSwitchCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Conditional;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by snailnan on 2016/9/6.
 */
@Component
@Conditional(ScheduledSwitchCondition.class)
public class TestScheduled {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    private static final Logger logger = LoggerFactory.getLogger(TestScheduled.class);

    @ScheduledLock()
    @Scheduled(cron = "0/5 * * * * ?")
    public void reportCurrentTime() throws InterruptedException {
        Thread.sleep(3000);
        logger.info("The time is now " + dateFormat.format(new Date()));
    }
    @ScheduledLock()
    @Scheduled(cron = "0/5 * * * * ?")
    public void reportCurrentTime2() throws InterruptedException {
        Thread.sleep(2000);
        logger.info("The time2 is now " + dateFormat.format(new Date()));
    }
}
