package com.nxy.web.aop;

import com.nxy.web.vo.Nxy;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by snailnan on 2016/9/7.
 */
public class BeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        Nxy nxy = new Nxy();
        nxy.setAge(11);
        nxy.setName("invoker");
        Class clazz = method.getReturnType();
        String str =(String) method.invoke(nxy);
        System.out.println(str);
        Nxy nxy2 = (Nxy)o;
        nxy2.setName("before");
        System.out.println("前置增强");
    }
}