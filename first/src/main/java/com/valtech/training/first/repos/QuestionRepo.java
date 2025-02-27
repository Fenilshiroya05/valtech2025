package com.valtech.training.first.repos;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.training.first.entities.Question;

@Repository
public interface QuestionRepo extends JpaRepository<Question, Long>{ 
	//1st class  2nd primary key class
	List<Question> findAllByTopic(String topic);

	long countByTopic(String topic);

	long countByTopicAndQuestionTextContaining(String topic, String keyword);

	long countByTopicAndQuestionTextContainingIgnoreCase(String topic, String keyword);

	List<Question> findAllByTopic(String topic, Pageable withPage);
	

}
