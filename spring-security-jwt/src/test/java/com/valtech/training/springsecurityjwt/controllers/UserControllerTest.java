package com.valtech.training.springsecurityjwt.controllers;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {
//
//	@Autowired
//	private MockMvc mockMvc;
//	
//	@Test
//	void test() {
//		mockMvc.perform(get("/api/v1/users/1")).andDo(print()).andExpect(content().json("{}")).andExpect(status().isOk());
//	}
}
