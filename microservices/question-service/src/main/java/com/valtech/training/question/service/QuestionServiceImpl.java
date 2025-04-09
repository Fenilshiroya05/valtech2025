package com.valtech.training.question.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.question.entities.Question;
import com.valtech.training.question.repos.QuestionRepo;
import com.valtech.training.question.vos.QuestionVO;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionRepo questionRepo;
	
	@Override
	public QuestionVO saveOrUpdateQuestion(QuestionVO vo) {
		Question q= vo.to();
		q=questionRepo.save(q);
		return QuestionVO.from(q);
	}
	
//	@Override
//	public List<QuestionVO> getRandomQuestionsByTopic(String topic,int count){
//		List<Question> q=questionRepo.findRandomQuestionsByTopic(topic,count);
//		return q.stream().map(qs->QuestionVO.from(qs)).collect(Collectors.toList());
//	}
	
	@Override
	public QuestionVO getQuestion(long id) {
		return QuestionVO.from(questionRepo.getReferenceById(id));
	}
	
	@Override
	public List<QuestionVO> getAllQuestions(){
		return questionRepo.findAll().stream().map(l->QuestionVO.from(l)).collect(Collectors.toList());
	}
	
	@Override
	public QuestionVO update(QuestionVO vo, long id) {
		Question question= questionRepo.getReferenceById(id);
		vo.updateTo(question);
		question=questionRepo.save(question);
		return QuestionVO.from(question);
	}
	@Override
	public List<QuestionVO> getRandomQuestionsByTopicAndDifficultyLevel(String topic,String difficultyLevel,int count){
		List<Question> q=questionRepo.findRandomQuestionsByTopicAndDifficultyLevel(topic,difficultyLevel,count);
		return q.stream().map(qs->QuestionVO.from(qs)).collect(Collectors.toList());
	}
	
	
}
