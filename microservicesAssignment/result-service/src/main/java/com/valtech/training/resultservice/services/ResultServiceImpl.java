package com.valtech.training.resultservice.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.resultservice.entities.Result;
import com.valtech.training.resultservice.repos.ResultRepo;
import com.valtech.training.resultservice.vos.ResultVO;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ResultServiceImpl implements ResultService {
	
	@Autowired
	private ResultRepo resultRepo;
	
	 
	    @Override
		public ResultVO saveResult(ResultVO rvo) {
	        Result result = resultRepo.save(rvo.to());
	        return ResultVO.from(result);
	    }
	  
	    @Override
		public List<ResultVO> getResultByUserName(String userName) {
	        return resultRepo.findByUserName(userName).stream().map(ResultVO::from).collect(Collectors.toList());
	    }
	  
	    @Override
		public List<ResultVO> getResultsByQuiz(Long quizId) {
	        return resultRepo.findByQuizId(quizId)
	                .stream()
	                .map(ResultVO::from)
	                .collect(Collectors.toList());
	    }
}
