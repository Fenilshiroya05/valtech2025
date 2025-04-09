package com.training.valtech.quiz.vos;

import java.util.List;

import com.training.valtech.quiz.entities.Quiz;

public record QuizVO(long id, long noOfQuestions,String topic,List<String> answer,List<Integer> questionId) {
	
	public static QuizVO from(Quiz q) {
		return new QuizVO(q.getId(),q.getNoOfQuestions(),q.getTopic(),q.getAnswer(),q.getQuestionsId());
	}
	public Quiz to() {
		return new Quiz(noOfQuestions,topic,answer,questionId);
	}
	public void updateTo(long id,Quiz q) {
		q.setNoOfQuestions(id);
		q.setTopic(topic);
		q.setAnswer(answer);
		q.setQuestionsId(questionId);
	}
}
