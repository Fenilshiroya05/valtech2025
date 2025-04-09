package com.training.valtech.question.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.training.valtech.question.repos.QuestionRepo;
import com.training.valtech.question.services.QuestionService;
import com.training.valtech.question.vos.QuestionVO;

@RestController
@RequestMapping("/api/v1/questions")
public class QuestionController {
	@Autowired
	private QuestionService questionService;
	@Autowired
	private QuestionRepo questionRepo;
	@PostMapping("/")
	public QuestionVO saveQuestion(@RequestBody QuestionVO questionVO) {
		return questionService.saveQuestion(questionVO);
	}
	@GetMapping("/{id}")
	public QuestionVO getQuestion(@PathVariable long id) {
		return questionService.getQuestion(id);
	}
	@GetMapping("/")
	public List<QuestionVO> getAllQuestions() {
		return questionService.getAllQuestions();
	}
	@PutMapping("/{id}")
	public QuestionVO updateQuestion(@PathVariable long id, @RequestBody QuestionVO questionVO) {
		return questionService.updateQuestion(id, questionVO);
	}
	@GetMapping("/topic/{topic}")
	public List<QuestionVO> getQuestionByTopic(@PathVariable String topic){
		return questionService.getQuestionByTopic(topic);
	}
	@GetMapping("/topic/{topic}/numOfQuestions/{numOfQuestions}")
	public List<QuestionVO> getQuestionsForQuiz(@PathVariable String topic,@PathVariable Integer numOfQuestions,@RequestBody QuestionVO questionVO){
		return questionService.getQuestionsForQuiz(topic,numOfQuestions);
	}
	@PostMapping("/getScore")
	public int getScore(@RequestBody List<QuestionVO> submittedAnswers) {
		return questionService.getScore(submittedAnswers);
	}
}