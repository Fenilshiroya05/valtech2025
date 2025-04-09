package com.training.valtech.quiz.services;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.training.valtech.quiz.vos.QuestionVO;
@Component
public class QuestionClient {
	
	String url = "http://localhost:9010/api/v1/questions/";
	public List<QuestionVO> getQuestionsByTopic(String topic) {
		RestTemplate temp = new RestTemplate();
		String urlForTopic = url+"topic/"+topic;
		List<QuestionVO> ques = temp.getForObject(url, List.class);
		return ques;
	}
	 public List<QuestionVO> getQuestionsForQuiz(String topic, Integer numOfQuestions) {
	        RestTemplate temp = new RestTemplate();
	        String url ="http://localhost:9010/api/v1/questions/topic/"+topic+"/numOfQuestions/"+numOfQuestions;
	        List<QuestionVO> quizQuestions = temp.getForObject(url, List.class);
	        
	        return quizQuestions;
	    }
	    public int getScore(List<QuestionVO> submittedAnswers) {
	        RestTemplate temp = new RestTemplate();
	        
	        String url = "http://localhost:9010/api/v1/questions/getScore";
	        
	        int score = temp.postForObject(url, submittedAnswers, Integer.class);
	        
	        return score;
	    }
}
