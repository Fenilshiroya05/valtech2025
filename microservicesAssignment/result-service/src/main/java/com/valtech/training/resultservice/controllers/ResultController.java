package com.valtech.training.resultservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.valtech.training.resultservice.services.ResultService;
import com.valtech.training.resultservice.vos.ResultVO;

@RestController
@RequestMapping("/api/v1/result")
public class ResultController {
	@Autowired
	private ResultService resultService;
	
	@PostMapping("/save")
    public ResultVO saveResult(ResultVO resultVO) {
        return resultService.saveResult(resultVO);
    }

    @GetMapping("/username/{userName}")
    public List<ResultVO> getResultsByUser(@PathVariable String userName) {
        return resultService.getResultByUserName(userName);
    }

    @GetMapping("/quiz/{quizId}")
    public List<ResultVO> getResultsByQuiz(@PathVariable Long quizId) {
        return resultService.getResultsByQuiz(quizId);
    }
	

}

