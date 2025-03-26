package com.valtech.training.question.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valtech.training.question.service.QuestionService;
import com.valtech.training.question.vos.QuestionVO;


@RestController
@RequestMapping("/api/v1/questions")
public class QuestionController {

	@Autowired
	private QuestionService questionService;
	
	@GetMapping("/")
	public List<QuestionVO> getAllQuestions() {
		return questionService.getAllQuestions();
	}
	
	@GetMapping("/{id}")
	public QuestionVO getQuestion(@PathVariable("id") long id) {
		return questionService.getQuestion(id);
	}
	
	@PostMapping("/")
	public QuestionVO createQuestion(@RequestBody QuestionVO vo) {
		return questionService.saveOrUpdateQuestion(vo);
	}
	@PutMapping("/{id}")
	public QuestionVO updateQuestion(@PathVariable("id") long id,@RequestBody QuestionVO vo) {
		return questionService.update(vo, id);
	}
	@GetMapping("/random/topic/{topic}/difficulty/{difficultyLevel}/{count}")
	public List<QuestionVO> getRandomQuestionsByTopicAndDifficultyLevel(@PathVariable("topic") String topic,
			@PathVariable("difficultyLevel") String difficultyLevel,@PathVariable("count") int count) {
		return questionService.getRandomQuestionsByTopicAndDifficultyLevel(topic, difficultyLevel, count);
	}
}
