package com.training.valtech.question.vos;

import org.springframework.beans.factory.annotation.Autowired;

import com.training.valtech.question.entities.Question;
import com.training.valtech.question.repos.QuestionRepo;

public record QuestionVO(long id,String ques, String option1,String option2,String option3,String option4,String ans,String topic) {
	
	
	public static QuestionVO from(Question q) {
		return new QuestionVO(q.getId(),q.getQues(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4(),q.getAns(),q.getTopic());
	}
	
	public Question to() {
		return new Question(id,ques,option1,option2,option3,option4,ans,topic);
	}
	public void updateTo(long id,Question q) {
		q.setQues(ques);
		q.setOption1(option1);
		q.setOption2(option2);
		q.setOption3(option3);
		q.setOption4(option4);
		q.setAns(ans);
		q.setTopic(topic);
	}
	public boolean isCorrectAnswer(Question question) {
        return this.ans.equals(question.getAns());
    }
}
