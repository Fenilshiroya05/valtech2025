package com.valtech.training.resultservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
@Entity
public class Result {
	@Id@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "result_seq")
	@SequenceGenerator(name = "result_seq",sequenceName = "result_seq")
	private long id;
	
	private long quizId;
	private String userName;
	private int score;
	public Result() {}
	public Result(long id, long quizId, String userName, int score) {
		super();
		this.id = id;
		this.quizId = quizId;
		this.userName = userName;
		this.score = score;
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
}
