package com.valtech.training.question.vos;

import com.valtech.training.question.entities.Question;

public record QuestionVO( long id,
	String question,
	String option1,
	String option2,
	String option3,
	String option4,
	String answer,
	String topic,
	String difficultyLevel) {

	public Question to() {
		return new Question(id,question,option1,option2,option3,option4,answer,topic,difficultyLevel);
	}
	public static QuestionVO from(Question q) {
		return new QuestionVO(q.getId(),q.getQuestion(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4(),
				q.getAnswer(),q.getTopic(),q.getDifficultyLevel());
	}
	public void updateTo(Question q) {
		q.setQuestion(question);
		q.setOption1(option1);
		q.setOption2(option2);
		q.setOption3(option3);
		q.setOption4(option4);
		q.setAnswer(answer);
		q.setTopic(topic);
		q.setDifficultyLevel(difficultyLevel);
	}
	
}
