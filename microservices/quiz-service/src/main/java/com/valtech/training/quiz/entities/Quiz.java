package com.valtech.training.quiz.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Quiz{

	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "quizseq")
	@SequenceGenerator(name = "quizseq", sequenceName = "quiz_seq", allocationSize = 1)
	private long id;
	private long questionNumbers;
	private long score;
	private String difficultyLevel;
	
	
	public Quiz() {}

	public Quiz(long questionNumbers, long score, String difficultyLevel) {
		this.questionNumbers = questionNumbers;
		this.score = score;
		this.difficultyLevel = difficultyLevel;
	}


	public Quiz(long id, long questionNumbers, long score, String difficultyLevel) {
		this.id = id;
		this.questionNumbers = questionNumbers;
		this.score = score;
		this.difficultyLevel = difficultyLevel;
	}

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public long getQuestionNumbers() {
		return questionNumbers;
	}


	public void setQuestionNumbers(long questionNumbers) {
		this.questionNumbers = questionNumbers;
	}


	public long getScore() {
		return score;
	}


	public void setScore(long score) {
		this.score = score;
	}


	public String getDifficultyLevel() {
		return difficultyLevel;
	}


	public void setDifficultyLevel(String difficultyLevel) {
		this.difficultyLevel = difficultyLevel;
	}
	
	
	
}
