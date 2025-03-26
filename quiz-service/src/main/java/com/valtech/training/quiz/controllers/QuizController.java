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
import com.valtech.training.quiz.vos.QuestionVO;
import com.valtech.training.quiz.vos.QuizVO;

@RestController
@RequestMapping("/api/v1/quizes")
public class QuizController {

	@Autowired
	private QuizService quizService;
	
	@PostMapping("/generate/topic/{topic}/difficulty/{difficultyLevel}/{count}")
	public QuizVO generateQuiz(@PathVariable("topic") String topic, @PathVariable("difficultyLevel") String difficultyLevel, 
			@PathVariable("count") int count) {
		return quizService.generateQuiz(count, topic, difficultyLevel);
	}
	
	@PostMapping("/{quizId}/result")
	public long calculateResult(@PathVariable("quizId") long quizId, @RequestBody List<String> answers) {
		return quizService.calculateResult(quizId, answers);
	}
	
	@GetMapping("/{quizId}/questions")
	public List<QuestionVO> getSelectedQuestions(@PathVariable("quizId") long quizId) {
		return quizService.getSelectedQuestions(quizId);
	}
	
	@GetMapping("/")
	public List<QuizVO> getAllQuizes(){
		return quizService.getAllQuizes();
	}
	
	
}
