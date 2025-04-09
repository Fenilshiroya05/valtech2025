package com.training.valtech.quiz.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.training.valtech.quiz.entities.Quiz;
import com.training.valtech.quiz.entities.QuizMaster;
import com.training.valtech.quiz.repos.QuizMasterRepo;
import com.training.valtech.quiz.repos.QuizRepo;
import com.training.valtech.quiz.vos.QuestionVO;
import com.training.valtech.quiz.vos.QuizMasterVO;
import com.training.valtech.quiz.vos.QuizVO;


@Service
@Transactional(propagation = Propagation.REQUIRED)
public class QuizServiceImpl implements QuizService {
	
	@Autowired
	private QuizRepo quizRepo;
	@Autowired
	private QuizMasterRepo quizMasterRepo;
	
	@Autowired
	private QuestionClient questionClient;
	
	
	public QuizVO generateQuiz(String topic , int numOfQuestions) {
		List<QuestionVO> questions = questionClient.getQuestionsForQuiz(topic,numOfQuestions);
		Quiz quiz = new Quiz();
		quiz.setTopic(topic);
		quiz.setNoOfQuestions(numOfQuestions);
	    quizRepo.save(quiz);
	    List<QuizMaster> quizMasters = questions.stream().map(qm -> new QuizMaster(0,qm.id(),quiz.getId())).collect(Collectors.toList());
	    return QuizVO.from(quiz);

		
	}
	@Override
	public QuizVO saveQuiz(QuizVO qvo) {
		Quiz quiz = quizRepo.save(qvo.to());
		return QuizVO.from(quiz);
	}
	@Override
	public QuizVO updateQuiz(long id,QuizVO qvo) {
		Quiz quiz = quizRepo.getReferenceById(id);
		qvo.updateTo(id, quiz);
		return QuizVO.from(quiz);
	}
	
	@Override
	public QuizVO getQuiz(long id) {
		Quiz q = quizRepo.getReferenceById(id);
		return QuizVO.from(q);
	}
	@Override
	public List<QuizVO> getAllQuiz(){
		return quizRepo.findAll().stream().map(q -> QuizVO.from(q)).collect(Collectors.toList());
	}
	
	public QuizMasterVO saveQuizMaster(QuizMasterVO vo) {
		QuizMaster quizMaster = quizMasterRepo.save(vo.to());
		return QuizMasterVO.from(quizMaster);
	}
	@Override
	public QuizMasterVO updateQuizMaster(long id, QuizMasterVO vo) {
		QuizMaster qm = quizMasterRepo.getReferenceById(id);
		vo.updateTo(id, qm);
		return QuizMasterVO.from(qm);
	}
	@Override
	public QuizMasterVO getQuizMaster(long id) {
		QuizMaster qm = quizMasterRepo.getReferenceById(id);
		return QuizMasterVO.from(qm);
	}
	@Override
	public List<QuizMasterVO> getAllQuizMasters() {
		return quizMasterRepo.findAll().stream().map(qm -> QuizMasterVO.from(qm)).collect(Collectors.toList());
	}
	
}
