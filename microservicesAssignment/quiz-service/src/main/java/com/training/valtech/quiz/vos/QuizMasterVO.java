package com.training.valtech.quiz.vos;

import com.training.valtech.quiz.entities.QuizMaster;

public record QuizMasterVO(long id,long quesId,long quizId) {
	
	public static QuizMasterVO from(QuizMaster qm) {
		return new QuizMasterVO(qm.getId(),qm.getQuesId(),qm.getQuizId());
	}
	public QuizMaster to() {
		return new QuizMaster(id,quesId,quizId);
	}
	public void updateTo(long id,QuizMaster qm) {
		qm.setId(id);
		qm.setQuesId(id);
		qm.setQuizId(id);
	}
}
