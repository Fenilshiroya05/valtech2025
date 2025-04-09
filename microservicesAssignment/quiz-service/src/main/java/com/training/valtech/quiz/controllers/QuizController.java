package com.training.valtech.quiz.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.valtech.quiz.repos.QuizRepo;
import com.training.valtech.quiz.services.QuizService;
import com.training.valtech.quiz.vos.QuizVO;

@RestController
@RequestMapping("/api/v1/quizes")
public class QuizController {
	
	@Autowired
	private QuizService quizService;
	@PostMapping("/")
	public QuizVO saveQuiz(@RequestBody QuizVO quizVO) {
		return quizService.saveQuiz(quizVO);
	}
	@PutMapping("/{id}")
	public QuizVO updateQuiz(@PathVariable long id,@RequestBody QuizVO quizVO) {
		return quizService.updateQuiz(id, quizVO);
	}
	@GetMapping("/{id}")
	public QuizVO getQuiz(@PathVariable long id) {
		return quizService.getQuiz(id);
	}
	@GetMapping("/")
	public List<QuizVO> getAllQuiz(){
		return quizService.getAllQuiz();
	}
}
