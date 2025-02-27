package com.valtech.training.first;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.valtech.training.first.entities.Question;
import com.valtech.training.first.services.QuestionService;

@SpringBootTest
class FirstApplicationTests {


	
	@Autowired
	private Arithmetic arithmetic;// its come from beanFactory
	
	@Autowired
	private SimpleInterest simpleInterest;
	
	@Autowired
	private QuestionService questionService;
	
	@Test
	void testArithmetic() {
		assertEquals(10, arithmetic.add(4, 6));
		assertEquals(200, simpleInterest.compute(200, 5, 20));
	}
	
	@Test
	void questionService() {
		assertEquals(6, questionService.findAllByTopic("GK").size());
		assertEquals(6, questionService.findAllByTopic("JAVA").size());
		
		assertEquals(6, questionService.countByTopic("GK"));
		assertEquals(6, questionService.countByTopic("JAVA"));
		
		assertEquals(2, questionService.countByTopicAndQuestionTextContaining("JAVA","Exception"));
		assertEquals(3, questionService.countByTopicAndQuestionTextContaining("JAVA","Interface")); //case sensative
		
		assertEquals(3, questionService.countByTopicAndQuestionTextContainingIgnoreCase("JAVA","interface"));
		
		assertEquals(5, questionService.findAllByTopic("GK",0,5).size());
		assertEquals(1, questionService.findAllByTopic("GK",1,5).size());

	}
	
	@BeforeEach
	void initData() {
		//System.out.println("Question Service class name = "+ questionService.getClass().getName());
		long count=questionService.count();
		if(count!=0) return;
		Question q= questionService.saveQuestion(new Question("What is the color of sky?","Red","Blue","Green","White","Blue","GK"));
		questionService.saveQuestion(new Question("What is the color of mars?","Red","Blue","Green","White","Red","GK"));
		questionService.saveQuestion(new Question("What is the color of Moon?","Red","Blue","Green","White","White","GK"));
		questionService.saveQuestion(new Question("What is the color of Jupiter?","Red","Blue","Yellow","White","Yellow","GK"));
		questionService.saveQuestion(new Question("What is the color of venus?","Red","Blue","Green","White","White","GK"));
		questionService.saveQuestion(new Question("What is the color of saturn?","Red","Blue","Green","White","Blue","GK"));
		
		questionService.saveQuestion(new Question("What is the super class of Exception?","Object","Exception","Throwable","Error","Throwable","JAVA"));
		questionService.saveQuestion(new Question("Which class is used to create Dynamic Strings?","String","DynamicString","StringBuilder","Builder","StringBuilder","JAVA"));
		questionService.saveQuestion(new Question("How many methods in Marker Interface?","NONE","ONE","TWO","MANY","NONE","JAVA"));
		questionService.saveQuestion(new Question("How many methods in Functional Interface?","NONE","ONE","TWO","MANY","ONE","JAVA"));
		questionService.saveQuestion(new Question("Can an Interface have Private Methods?","YES","NO","MAY BE","No Method can be there in an interface","YES","JAVA"));
		questionService.saveQuestion(new Question("Which subclass of Exception is not checked by the Complier?","Exception","Error","RuntimeException","None","RuntimeException","JAVA"));

	}
	

}
