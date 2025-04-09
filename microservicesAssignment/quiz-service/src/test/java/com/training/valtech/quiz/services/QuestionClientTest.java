package com.training.valtech.quiz.services;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.training.valtech.quiz.vos.QuestionVO;
@SpringBootTest
class QuestionClientTest {
	
	@Autowired
	QuestionClient client;
	@Test
	void test() {
		 
		 assertEquals(10, client.getQuestionsByTopic("JAVA").size());
//		 assertEquals(2, null);
	}

}
