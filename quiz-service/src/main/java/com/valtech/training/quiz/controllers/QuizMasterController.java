package com.valtech.training.quiz.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valtech.training.quiz.service.QuizService;
import com.valtech.training.quiz.vos.QuizMasterVO;


@RestController
@RequestMapping("/api/v1/quizMasters")
public class QuizMasterController {

	@Autowired
	private QuizService quizService;
	
	@GetMapping("/{quizId}")
	public QuizMasterVO getQuizMaster(@PathVariable("quizId") long quizId) {
		return quizService.getQuizMaster(quizId);
	}
	
	@GetMapping("/")
	public List<QuizMasterVO> getQuizMasters(){
		return quizService.getAllQuizMasters();
	}
	
	@PostMapping("/")
	public QuizMasterVO createQuizMaster(@RequestBody QuizMasterVO vo) {
		return quizService.createQuizMaster(vo);
	}
}
