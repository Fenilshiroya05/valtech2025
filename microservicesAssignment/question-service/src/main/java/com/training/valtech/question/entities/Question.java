package com.training.valtech.question.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Question {
	
	@Id@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "ques_seq")
	@SequenceGenerator(name = "ques_seq",sequenceName = "ques_seq")
	private long id;
	private String ques;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	private String ans;
	private String topic;
	public Question() {}
	public Question(long id,String ques, String option1, String option2, String option3, String option4, String ans,
			String topic) {
		this.id = id;
		this.ques = ques;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
		this.ans = ans;
		this.topic = topic;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getQues() {
		return ques;
	}
	public void setQues(String ques) {
		this.ques = ques;
	}
	public String getOption1() {
		return option1;
	}
	public void setOption1(String option1) {
		this.option1 = option1;
	}
	public String getOption2() {
		return option2;
	}
	public void setOption2(String option2) {
		this.option2 = option2;
	}
	public String getOption3() {
		return option3;
	}
	public void setOption3(String option3) {
		this.option3 = option3;
	}
	public String getOption4() {
		return option4;
	}
	public void setOption4(String option4) {
		this.option4 = option4;
	}
	public String getAns() {
		return ans;
	}
	public void setAns(String ans) {
		this.ans = ans;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	
	
}
