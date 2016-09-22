package com.nxy.test;

import org.junit.Test;

import java.util.stream.Stream;

/**
 * Created by snailnan on 2016/9/22.
 */
public class TryCloseTest{
    class Close implements AutoCloseable{

        @Override
        public void close() throws Exception {
            System.out.println("close is close");
        }
    }
    @Test
    public void testClose(){
        try {
            try(Close c = new Close()) {
                System.out.println("hello world");
                throw new Exception("e");
            }
        } catch (Exception e) {
            System.out.println("Exception");
        }finally {
            System.out.println("finally");
        }
    }
}
