package com.valtech.training.quiz.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class QuizMaster {

	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "qmseq")
	@SequenceGenerator(name = "qmseq",sequenceName = "qm_seq",allocationSize = 1)
	private long id;
	
	private long quizId;
	private long questionId;
	
	
	public QuizMaster() {}
	public QuizMaster(long id, long quizId, long questionId) {
		this.id = id;
		this.quizId = quizId;
		this.questionId = questionId;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getQuizId() {
		return quizId;
	}
	public void setQuizId(long quizId) {
		this.quizId = quizId;
	}
	public long getQuestionId() {
		return questionId;
	}
	public void setQuestionId(long questionId) {
		this.questionId = questionId;
	}
	
}
