package com.training.valtech.quiz.services;

import java.util.List;

import com.training.valtech.quiz.vos.QuizMasterVO;
import com.training.valtech.quiz.vos.QuizVO;

public interface QuizService {

	QuizVO saveQuiz(QuizVO qvo);

	QuizVO updateQuiz(long id, QuizVO qvo);

	QuizVO getQuiz(long id);

	List<QuizVO> getAllQuiz();
	
	QuizMasterVO saveQuizMaster(QuizMasterVO vo);
	
	QuizMasterVO updateQuizMaster(long id,QuizMasterVO vo);
	
	QuizMasterVO getQuizMaster(long id);
	
	List<QuizMasterVO> getAllQuizMasters();
	

	
	

}