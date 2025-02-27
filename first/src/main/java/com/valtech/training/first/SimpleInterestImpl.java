package com.valtech.training.first;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component //used to mark a class as a "bean"
public class SimpleInterestImpl implements SimpleInterest {

	@Autowired // when use autowired , not use constructor
	private Arithmetic arithmetic;
	
	public SimpleInterestImpl(Arithmetic arithmetic) {
		this.arithmetic=arithmetic;
	}

	public void setArithmetic(Arithmetic arithmetic) {
		this.arithmetic = arithmetic;
	}
	
	@Override
	public int compute(int prin,int rate,int time) {
		return arithmetic.div(arithmetic.mul(prin, arithmetic.mul(rate, time)),100);
	}
}
