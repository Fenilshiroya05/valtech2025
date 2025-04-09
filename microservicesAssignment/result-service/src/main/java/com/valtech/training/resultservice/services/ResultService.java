package com.valtech.training.resultservice.services;

import java.util.List;

import com.valtech.training.resultservice.vos.ResultVO;

public interface ResultService {

	ResultVO saveResult(ResultVO rvo);

	List<ResultVO> getResultByUserName(String userName);

	List<ResultVO> getResultsByQuiz(Long quizId);

}