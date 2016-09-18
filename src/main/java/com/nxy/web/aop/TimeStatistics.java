package com.nxy.web.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Created by snailnan on 2016/9/7.
 */
@Aspect
@Component
public class TimeStatistics {
    @Pointcut("execution(public * com.nxy.web.vo.Nxy.*(..))")
    public void MyMethod(){
        System.out.println("MyMethod ----");
    }

    @Before("MyMethod())")
    public void BeforeMethod(){
        System.out.println("method start!");
    }

    @AfterReturning("MyMethod()")
    public void AfterMethod(){
        System.out.println("After returnning");
    }

    @Around("MyMethod()")
    public void aroundProcced(ProceedingJoinPoint pjp) throws Throwable{
        System.out.println("around start");
        pjp.proceed();
        System.out.println("around end");
    }
}
