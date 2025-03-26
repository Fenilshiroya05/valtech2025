package com.valtech.training.quiz.vos;

import com.valtech.training.quiz.entities.Quiz;

public record QuizVO(long id,long questionNumbers,long score,String difficultyLevel) {

	public Quiz to() {
		return new Quiz(id,questionNumbers,score,difficultyLevel);
	}
	public static QuizVO from(Quiz q) {
		return new QuizVO(q.getId(),q.getQuestionNumbers(),q.getScore(),q.getDifficultyLevel());
	}
//	public void updateTo(Quiz q) {
//		q.setQuestionNumbers(questionNumbers);
//	}
}
