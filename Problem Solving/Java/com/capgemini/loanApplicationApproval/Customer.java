package com.capgemini.loanApplicationApproval;

public class Customer {
	private int custId;
	private String custName;
	private String location;
	private int fkLoanId;
	private int requestedAmount;
	private String status;
	
	public Customer(int custId, String custName, String location, int fkLoanId, int requestedAmount, String status) {
		this.custId = custId;
		this.custName = custName;
		this.location = location;
		this.fkLoanId = fkLoanId;
		this.requestedAmount = requestedAmount;
		this.status = status;
	}

	public int getCustId() {
		return custId;
	}

	public String getCustName() {
		return custName;
	}

	public String getLocation() {
		return location;
	}

	public int getFkLoanId() {
		return fkLoanId;
	}

	public int getRequestedAmount() {
		return requestedAmount;
	}

	public String getStatus() {
		return status;
	}
}
