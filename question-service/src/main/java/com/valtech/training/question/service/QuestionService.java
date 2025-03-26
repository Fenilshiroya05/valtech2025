package com.valtech.training.question.service;

import java.util.List;

import com.valtech.training.question.vos.QuestionVO;

public interface QuestionService {

	QuestionVO saveOrUpdateQuestion(QuestionVO vo);

	QuestionVO getQuestion(long id);

	List<QuestionVO> getAllQuestions();

	QuestionVO update(QuestionVO vo, long id);

	//List<QuestionVO> getRandomQuestionsByTopic(String topic, int count);

	List<QuestionVO> getRandomQuestionsByTopicAndDifficultyLevel(String topic, String difficultyLevel, int count);

}