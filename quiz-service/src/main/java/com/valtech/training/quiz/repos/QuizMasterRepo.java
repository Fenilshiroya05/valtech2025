package com.valtech.training.quiz.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.training.quiz.entities.QuizMaster;

@Repository
public interface QuizMasterRepo extends JpaRepository<QuizMaster, Long>{

	List<QuizMaster> findByQuizId(long quizId);

}
