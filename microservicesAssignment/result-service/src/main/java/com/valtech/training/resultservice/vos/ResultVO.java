package com.valtech.training.resultservice.vos;

import com.valtech.training.resultservice.entities.Result;

public record ResultVO(long id,long quizId,String userName,int score) {
	public static ResultVO from(Result r) {
		return new ResultVO(r.getId(), r.getQuizId(), r.getUserName(), r.getScore());
	}
	public Result to() {
		return new Result(id,quizId,userName,score);
	}
}
