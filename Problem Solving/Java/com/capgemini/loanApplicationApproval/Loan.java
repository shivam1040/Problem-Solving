package com.capgemini.loanApplicationApproval;

public class Loan {
	private int loanId;
	private String type;
	private int maxLimit;
	
	public Loan(int loanId, String type, int maxLimit) {
		this.loanId = loanId;
		this.type = type;
		this.maxLimit = maxLimit;
	}

	public int getLoanId() {
		return loanId;
	}

	public String getType() {
		return type;
	}

	public int getMaxLimit() {
		return maxLimit;
	}
}
