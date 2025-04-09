package com.valtech.training.quiz.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.quiz.entities.Quiz;
import com.valtech.training.quiz.entities.QuizMaster;
import com.valtech.training.quiz.repos.QuizMasterRepo;
import com.valtech.training.quiz.repos.QuizRepo;
import com.valtech.training.quiz.vos.QuestionVO;
import com.valtech.training.quiz.vos.QuizMasterVO;
import com.valtech.training.quiz.vos.QuizVO;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class QuizServiceImpl implements QuizService {

	@Autowired
	private QuizRepo quizRepo;
	
	@Autowired
	private QuizMasterRepo quizMasterRepo;
	
	@Autowired
	private QuestionClient questionClient;
	
	@Override
	public QuizVO generateQuiz(int count,String topic,String difficultyLevel) {
		List<QuestionVO> questions = questionClient.getRandomQuestionsByTopicAndDifficultyLevel(topic, difficultyLevel, count);
		
		Quiz quiz= new Quiz(count,0,difficultyLevel);
		quizRepo.save(quiz);
		
		List<QuizMaster> quizMasters =  questions.stream().map(qm -> new QuizMaster(0, quiz.getId(), qm.id())).collect(Collectors.toList());
		quizMasterRepo.saveAll(quizMasters);
		
		return QuizVO.from(quiz);
	}
	
	@Override
	public long calculateResult(long quizId,List<String> answers) {
		List<QuizMaster> qm= (List<QuizMaster>) quizMasterRepo.findByQuizId(quizId);
		
		long score=0;
		for (int i = 0; i < qm.size(); i++) {
			QuestionVO vo= questionClient.getQuestionById(qm.get(i).getQuestionId());
			if(vo !=null && vo.answer().equals(answers.get(i))) {
				score++;
			}
		}
		Quiz q=quizRepo.findById(quizId).get();
		
		if(q !=null) {
			q.setScore(score);
			quizRepo.save(q);
		}
		return score;
	}
	
	@Override
	public List<QuizVO> getAllQuizes(){
		return quizRepo.findAll().stream().map(q->QuizVO.from(q)).collect(Collectors.toList());
	}
	
	@Override
	public List<QuestionVO> getSelectedQuestions(long quizId) {
		List<QuizMaster> qm= (List<QuizMaster>) quizMasterRepo.findByQuizId(quizId);
		
		return qm.stream().map(q-> questionClient.getQuestionById(q.getQuestionId())).collect(Collectors.toList());
		
	}
	
	@Override
	public QuizMasterVO getQuizMaster(long quizId){
		QuizMaster qm= (QuizMaster) quizMasterRepo.findByQuizId(quizId);
		return QuizMasterVO.from(qm);			
	}
	
	@Override
	public List<QuizMasterVO> getAllQuizMasters(){
		return quizMasterRepo.findAll().stream().map(qm-> QuizMasterVO.from(qm)).collect(Collectors.toList());
	}
	
	@Override
	public QuizMasterVO createQuizMaster(QuizMasterVO vo) {
		QuizMaster qm= vo.to();
		qm= quizMasterRepo.save(qm);
		return QuizMasterVO.from(qm);
	}
	
}

