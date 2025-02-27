package com.valtech.training.first.services;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;

import com.valtech.training.first.entities.Question;

public interface QuestionService {
	
	long count();

	Question saveQuestion(Question question);

	Question updateQuestion(Question question);

	void deleteQuestion(Question question);

	Question getQuestion(long id);

	List<Question> getAllQuestion();
	
	List<Question> findAllByTopic(String topic);

	long countByTopic(String topic);

	long countByTopicAndQuestionTextContaining(String topic, String keyword);

	long countByTopicAndQuestionTextContainingIgnoreCase(String topic, String keyword);
	
	List<Question> findAllByTopic(String topic,int page,int size);
}