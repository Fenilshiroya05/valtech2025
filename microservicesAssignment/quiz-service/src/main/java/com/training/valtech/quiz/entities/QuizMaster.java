package com.training.valtech.quiz.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
@Entity
public class QuizMaster {
	@Id@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "qm_seq")
	@SequenceGenerator(name = "qm_seq",sequenceName = "qm_seq",allocationSize = 1)
	private long id;
	private long quesId;
	private long quizId;
	public QuizMaster() {}
	public QuizMaster(long id, long quesId, long quizId) {
		this.id = id;
		this.quesId = quesId;
		this.quizId = quizId;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getQuesId() {
		return quesId;
	}
	public void setQuesId(long quesId) {
		this.quesId = quesId;
	}
	public long getQuizId() {
		return quizId;
	}
	public void setQuizId(long quizId) {
		this.quizId = quizId;
	}
	
	
	
	
	
}
