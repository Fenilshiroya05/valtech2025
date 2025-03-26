package com.valtech.training.question.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.valtech.training.question.entities.Question;

@Repository
public interface QuestionRepo extends JpaRepository<Question, Long>{

	//List<Question> findRandomQuestionsByTopic(String topic, int count);
	@Query(value = "SELECT * FROM question WHERE topic = :topic AND difficulty_level = :difficultyLevel ORDER BY RANDOM() LIMIT :count",nativeQuery = true)
	List<Question> findRandomQuestionsByTopicAndDifficultyLevel(@Param("topic") String topic, 
		@Param("difficultyLevel")	String difficultyLevel,@Param("count") int count);

}
