package com.nxy.web.aop;

import com.nxy.web.App;
import com.nxy.web.vo.Nxy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by snailnan on 2016/9/7.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class NxyAopTest {
    @Autowired
    private Nxy nxy;

    @Test
    public void test(){
        System.out.println(nxy.toString());
    }
}
