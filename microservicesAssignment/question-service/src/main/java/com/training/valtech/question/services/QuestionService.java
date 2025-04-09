package com.training.valtech.question.services;

import java.util.List;

import com.training.valtech.question.vos.QuestionVO;

public interface QuestionService {

	QuestionVO saveQuestion(QuestionVO qvo);

	QuestionVO getQuestion(long id);

	List<QuestionVO> getAllQuestions();

	QuestionVO updateQuestion(long id, QuestionVO qvo);
	
	List<QuestionVO> getQuestionByTopic(String topic);

	List<QuestionVO> getQuestionsForQuiz(String topic, Integer numOfQuestions);

	int getScore(List<QuestionVO> submittedAnswers);

}