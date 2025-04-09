package com.training.valtech.question.controllers;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import com.training.valtech.question.vos.QuestionVO;
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class QuestionControllerTests {

		@LocalServerPort
		private Integer port;
		@Autowired
		private TestRestTemplate restTemplate;
		@Test
		void addQuestion() {
			String url = "http://localhost:"+port+"/api/v1/questions/";
			List ques = restTemplate.getForObject( url,List.class);
			if(ques.size() == 0) {
				QuestionVO ques1 = restTemplate.postForObject(url,
						new QuestionVO(0, "What is java ?", "Programming language ", "not a Object Oriented Language", "it is easy", "it is hard", "Programming language", "JAVA"),QuestionVO.class);
				QuestionVO ques2 = restTemplate.postForObject(url,
						new QuestionVO(0, "Which is Object oriented language ?", "Java", "C++", "Both", "None", "Both", "JAVA"),QuestionVO.class);
			
				QuestionVO ques3 = restTemplate.postForObject(url,
						new QuestionVO(0, "When does finally block executes ?", "when exception thrown ", "when exception not thrown", "always even exception thrown or not", "none", "always even exception thrown or not", "JAVA"),QuestionVO.class);
			
				QuestionVO ques4 = restTemplate.postForObject(url,
						new QuestionVO(0, "Java supports method overloading ?", "Yes ", "no", "not necessary", "can't be determined", "Yes", "JAVA"),QuestionVO.class);
			
				QuestionVO ques5 = restTemplate.postForObject(url,
						new QuestionVO(0, "What is the first line of constructor ?", "super ", "variables", "declaration of function", "none", "super", "JAVA"),QuestionVO.class);
			
				QuestionVO ques6 = restTemplate.postForObject(url,
						new QuestionVO(0, "Java supports method overriding ?", "Yes ", "no", "not necessary", "can't be determined", "Yes", "JAVA"),QuestionVO.class);
			
				QuestionVO ques7 = restTemplate.postForObject(url,
						new QuestionVO(0, "How many parameters can we pass in parameterised constructor?", "One ", "Two", "Three", "Many", "Many", "JAVA"),QuestionVO.class);
			
				QuestionVO ques8 = restTemplate.postForObject(url,
						new QuestionVO(0, "How many types of constructor are there ?", "one ", "two", "three", "four", "four", "JAVA"),QuestionVO.class);
			
				QuestionVO ques9 = restTemplate.postForObject(url,
						new QuestionVO(0, "Java is robust ?", "yes ", "no", "can,t determined", "not necessary", "yes", "JAVA"),QuestionVO.class);
				QuestionVO ques10 = restTemplate.postForObject(url,
						new QuestionVO(0, "Java is robust ?", "yes ", "no", "can,t determined", "not necessary", "yes", "python"),QuestionVO.class);
			
			}
		}

	}


