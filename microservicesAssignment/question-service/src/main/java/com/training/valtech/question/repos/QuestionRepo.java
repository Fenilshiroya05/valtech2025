package com.training.valtech.question.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.training.valtech.question.entities.Question;

public interface QuestionRepo extends JpaRepository<Question, Long>{

	List<Question> findByTopic(String topic);
	
    @Query("SELECT q FROM Question q WHERE q.topic = :topic ORDER BY RANDOM()")
	List<Question> findRandomQuestionsByTopic(String topic, Integer numOfQuestions);

}
