package com.example.demo;

import com.example.demo.controllers.PageController;
import com.example.demo.controllers.TextController;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class DemoApplicationTests {

    @Test
    public void page() throws Exception {
        PageController controller = new PageController();
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(get("/page")).andExpect(view().name("html/page"));
    }

    @Test
    public void text() throws Exception {
        TextController controller = new TextController();
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(get("/text")).andExpect(content().string("Hello world"));
    }
}
