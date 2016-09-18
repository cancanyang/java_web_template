package com.nxy.web.config;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * Created by snailnan on 2016/9/6.
 */
public class ScheduledSwitchCondition implements Condition {

    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        Environment en = conditionContext.getEnvironment();
        String condition = en.getProperty("spring.condition.sechedule");
        return condition.equals("true");
    }
}
