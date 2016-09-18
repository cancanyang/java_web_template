package com.nxy.web.Scheduled;

import java.lang.annotation.*;

/**
 * Created by snailnan on 2016/9/8.
 */
@Documented
@Target(value={ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ScheduledLock {
}
