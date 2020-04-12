package com.bloodfinger.project.springboot.web;

import com.bloodfinger.project.springboot.web.dto.HelloResponseDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void returnToHello() throws Exception{
        String hello =   "hello";

        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(hello));
    }

    @Test
    public void returnToHelloDto() throws Exception{
        String name = "양재우";
        int amount = 100;

        mvc.perform(
                get("/hello/dto")
                        .param("name" , name)
                        .param("amount" , String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name" , is(name)))
                .andExpect(jsonPath("$.amount" , is(amount)));


    }


}
