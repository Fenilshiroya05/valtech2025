package com.valtech.training.quiz.service;

import java.util.List;

import com.valtech.training.quiz.vos.QuestionVO;
import com.valtech.training.quiz.vos.QuizMasterVO;
import com.valtech.training.quiz.vos.QuizVO;

public interface QuizService {

	QuizVO generateQuiz(int count, String topic, String difficultyLevel);

	long calculateResult(long quizId, List<String> answers);

	QuizMasterVO createQuizMaster(QuizMasterVO vo);

	List<QuizMasterVO> getAllQuizMasters();

	QuizMasterVO getQuizMaster(long quizId);

	List<QuestionVO> getSelectedQuestions(long quizId);

	List<QuizVO> getAllQuizes();

}