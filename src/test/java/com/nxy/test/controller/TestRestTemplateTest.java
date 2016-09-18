package com.nxy.test.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;

/**
 * Created by snailnan on 2016/8/31.
 */
public class TestRestTemplateTest {

        private TestRestTemplate restTemplate;
        @Before
        public  void setUp(){
            this.restTemplate = new TestRestTemplate();
        }
        @Test
        public void exampleTest() {
            String body = this.restTemplate.getForObject("http://127.0.0.1:8080/hello", String.class);
            assertThat(body).isEqualTo("Hello World");
        }

}
