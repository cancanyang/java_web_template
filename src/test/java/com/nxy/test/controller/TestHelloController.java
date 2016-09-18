package com.nxy.test.controller;

import com.nxy.web.App;
import com.nxy.web.vo.Nxy;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.match.MockRestRequestMatchers;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= App.class )
public class TestHelloController {

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private Nxy nxy;

    private MockMvc mvc;

    @Before
    public void setUp(){
        this.mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
    }
    @Test
    public void testWorld() throws Exception {
        this.mvc.perform(get("/hello").accept(MediaType.ALL))
                .andExpect(content().string("world"));
    }
    @Test
    public void testNxy() throws Exception {
        ResultActions result = mvc.perform(get("/hello/nxy").
                accept(MediaType.APPLICATION_JSON_UTF8))
                .andDo(MockMvcResultHandlers.print());
    }
}
