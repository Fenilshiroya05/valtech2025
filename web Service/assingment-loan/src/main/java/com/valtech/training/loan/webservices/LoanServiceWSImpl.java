package com.valtech.training.loan.webservices;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import com.valtech.training.loan.entities.Loan;
import com.valtech.training.loan.repos.LoanRepo;
import com.valtech.training.loan.services.LoanService;

@WebService(endpointInterface = "com.valtech.training.loan.webservices.LoanServiceWS", 
name = "LoanService", portName = "LoanServicePort")
public class LoanServiceWSImpl implements LoanServiceWS {

	private LoanService loanService;

	public LoanServiceWSImpl(LoanService loanservice) {
		this.loanService = loanservice;
	}

	@Override
	public String applyLoan(String name, String panCard, String address, int cibilScore, double income,
			double assetValue) {
		return loanService.applyLoan(name, panCard, address, cibilScore, income, assetValue);
	}

	@Override
	public String processLoan(Long id) {
		return loanService.processLoan(id);
	}

}
