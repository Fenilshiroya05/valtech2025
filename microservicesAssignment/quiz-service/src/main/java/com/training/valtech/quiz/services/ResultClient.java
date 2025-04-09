package com.training.valtech.quiz.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.training.valtech.quiz.vos.QuizVO;

@Service
public class ResultClient {
	


	    RestTemplate restTemplate = new RestTemplate();
	    private String RESULT_SERVICE_URL = "http://localhost:9060/api/v1/results";
	    
	    public QuizVO saveResult(Long quizId, String userName, int score) {
	        String url = RESULT_SERVICE_URL + "/save?quizId=" + quizId + "&userName=" + userName + "&score=" + score;
	        return restTemplate.postForObject(url, null, QuizVO.class);
	    }
	}

