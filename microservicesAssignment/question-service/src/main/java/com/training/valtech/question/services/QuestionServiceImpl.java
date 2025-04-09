package com.training.valtech.question.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.training.valtech.question.entities.Question;
import com.training.valtech.question.repos.QuestionRepo;
import com.training.valtech.question.vos.QuestionVO;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class QuestionServiceImpl implements QuestionService {
	
	@Autowired
	private QuestionRepo questionRepo;
	
	@Override
	public QuestionVO saveQuestion(QuestionVO qvo) {
		
		Question ques = questionRepo.save(qvo.to());
		return QuestionVO.from(ques);
	}
	@Override
	public QuestionVO getQuestion(long id) {
		Question q = questionRepo.getReferenceById(id);
		return QuestionVO.from(q);
		
	}
	@Override
	public List<QuestionVO> getAllQuestions(){
		return questionRepo.findAll().stream().map(q -> QuestionVO.from(q)).collect(Collectors.toList());
	}
	@Override
	public QuestionVO updateQuestion(long id,QuestionVO qvo) {
		Question q = questionRepo.getReferenceById(id);
		qvo.updateTo(id, q);
		return QuestionVO.from(q);
		
	}
	@Override
	public List<QuestionVO> getQuestionByTopic(String topic) {
		return  questionRepo.findByTopic(topic).stream().map(q -> QuestionVO.from(q)).collect(Collectors.toList());
		
	}
	@Override
	public List<QuestionVO> getQuestionsForQuiz(String topic, Integer numOfQuestions) {
	    List<Question> questions = questionRepo.findRandomQuestionsByTopic(topic, numOfQuestions);

	    return questions.stream().map(q -> QuestionVO.from(q)).collect(Collectors.toList());
	}
	@Override
	public int getScore(List<QuestionVO> submittedAnswers) {
	    int score = 0;

	  
	    for (QuestionVO submittedAnswer : submittedAnswers) {
	        Question question = questionRepo.findById(submittedAnswer.id()).orElse(null);

	        if (question != null && submittedAnswer.isCorrectAnswer(question)) {
	            score++;
	        }
	    }

	    return score;
	}
}
