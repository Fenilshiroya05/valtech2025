package com.valtech.training.quiz.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.valtech.training.quiz.vos.QuestionVO;

@Component
public class QuestionClient {
	
	private RestTemplate temp= new RestTemplate();
	
	public QuestionVO getQuestionById(long questionId) {
		String url = "http://localhost:9030/api/v1/questions/"+questionId;
		QuestionVO q= temp.getForObject(url, QuestionVO.class);
		return q;
	}
	
	public List<QuestionVO> getRandomQuestionsByTopicAndDifficultyLevel(String topic, String difficultyLevel,int count){
		String url = "http://localhost:9030/api/v1/questions/random/topic/"+topic+"/difficulty/"+difficultyLevel+"/"+count;
		QuestionVO[] q= temp.getForObject(url, QuestionVO[].class); // JSON in array format deserialize 
		
		if(q !=null)return List.of(q); // array to list
		return List.of(new QuestionVO[0]);
	}
}
