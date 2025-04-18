package com.training.valtech.quiz.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.valtech.quiz.entities.Quiz;
@Repository
public interface QuizRepo extends JpaRepository<Quiz, Long>{

}
