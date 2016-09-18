package com.nxy.test.aop;

import com.nxy.web.aop.BeforeAdvice;
import com.nxy.web.vo.Nxy;
import org.aopalliance.aop.Advice;
import org.junit.Before;
import org.junit.Test;
import org.springframework.aop.framework.ProxyFactory;

/**
 * Created by snailnan on 2016/9/7.
 */
public class ProxyAopTest {
    private Nxy nxy;
    private  ProxyFactory pf;
    private Advice advice;
    @Before
    public void init()
    {
        nxy = new Nxy();
        nxy.setName("orage");
        nxy.setAge(18);
        pf = new ProxyFactory();
        pf.setTarget(nxy);
    }
    @Test
    public void testBefore(){
        advice = new BeforeAdvice();
        pf.addAdvice(advice);
        Nxy nxy2 = (Nxy)pf.getProxy();
        System.out.println(nxy.toString());
        System.out.println(nxy2.toString());

    }
}
