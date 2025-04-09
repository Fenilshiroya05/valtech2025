package com.training.valtech.quiz.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.valtech.quiz.services.QuizService;
import com.training.valtech.quiz.vos.QuizMasterVO;

@RestController
@RequestMapping("/api/v1/quizMasters")
public class QuizMasterController {
	
	@Autowired
	private QuizService quizService;
	@PostMapping("/")
	public QuizMasterVO saveQuizMaster(@RequestBody QuizMasterVO quizMasterVO) {
		return quizService.saveQuizMaster(quizMasterVO);
		}
	@GetMapping("/{id}")
	public QuizMasterVO getQuizMaster(@PathVariable long id) {
		return quizService.getQuizMaster(id);
	}
	@GetMapping("/")
	public List<QuizMasterVO> getAllQuizMasters(){
		return quizService.getAllQuizMasters();
	}
	@PutMapping("/{id}")
	public QuizMasterVO updateQuizMaster(@PathVariable long id,@RequestBody QuizMasterVO quizMasterVO) {
		return quizService.updateQuizMaster(id, quizMasterVO);
	}
//	@GetMapping("/")
//	public QuizMasterVO<List<Integer>> getQuestionsForQuiz(@RequestParam String topic, @RequestParam String ){
//		
//	}
}
