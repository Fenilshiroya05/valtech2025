package com.valtech.training.quiz.vos;

public record QuestionVO( long id,
		String question,
		String option1,
		String option2,
		String option3,
		String option4,
		String answer,
		String topic,
		String difficultyLevel) {

}
