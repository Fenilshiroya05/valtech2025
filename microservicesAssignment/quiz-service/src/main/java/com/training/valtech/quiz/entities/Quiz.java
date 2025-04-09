package com.training.valtech.quiz.entities;

import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.SequenceGenerator;
@Entity
public class Quiz {
	@Id@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "quiz_seq")
	@SequenceGenerator(name = "quiz_seq",sequenceName = "quiz_seq")
	private long id;
	private long noOfQuestions;
	private String topic;
	
	@ElementCollection
	@CollectionTable(name="quiz_answer",joinColumns = @JoinColumn(name ="quiz_id"))
	@Column(name="answers")
	private List<String> answer;
	
	@ElementCollection
	@CollectionTable(name="quiz_question",joinColumns = @JoinColumn(name ="quiz_id"))
	@Column(name="question_id")
	private List<Integer> questionsId;
	
	public Quiz() {}

	public Quiz(long noOfQuestions, String topic, List<String> answer, List<Integer> questionsId) {
		
		this.noOfQuestions = noOfQuestions;
		this.topic = topic;
		this.answer = answer;
		this.questionsId = questionsId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getNoOfQuestions() {
		return noOfQuestions;
	}

	public void setNoOfQuestions(long noOfQuestions) {
		this.noOfQuestions = noOfQuestions;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public List<String> getAnswer() {
		return answer;
	}

	public void setAnswer(List<String> answer) {
		this.answer = answer;
	}

	public List<Integer> getQuestionsId() {
		return questionsId;
	}

	public void setQuestionsId(List<Integer> questionsId) {
		this.questionsId = questionsId;
	}
	
	
}