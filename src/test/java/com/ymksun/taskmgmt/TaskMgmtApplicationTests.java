package com.ymksun.taskmgmt;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TaskMgmtApplicationTests {

	@Autowired
	private MockMvc mvc;

	@Test
	public void contextLoads() throws Exception {
		this.mvc.perform(get("/welcome")).andExpect(status().isOk()).andExpect(content().string("welcome"));
	}
	
	@Test
	public void mvcCheck() throws Exception {
		this.mvc.perform(get("/api/board/list")).andExpect(status().isOk()).andExpect(content().json("[]"));
		this.mvc.perform(get("/api/task/list")).andExpect(status().isOk()).andExpect(content().json("[]"));
		this.mvc.perform(get("/api/schedule/list")).andExpect(status().isOk()).andExpect(content().json("[]"));
	}

}
