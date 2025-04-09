package com.valtech.training.quiz.vos;

import com.valtech.training.quiz.entities.QuizMaster;

public record QuizMasterVO(long id,long quizId,long questionId) {
	
	public QuizMaster to() {
		return new QuizMaster(id,quizId,questionId);
	}

	public static QuizMasterVO from(QuizMaster qm) {
		return new QuizMasterVO(qm.getId(),qm.getQuizId(),qm.getQuestionId());
	}
}
