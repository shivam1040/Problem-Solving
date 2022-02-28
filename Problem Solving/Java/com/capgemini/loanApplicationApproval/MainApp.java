package com.capgemini.loanApplicationApproval;

public class MainApp {
	public static void main(String args[]) {
	Loan obj=new Loan(1, "HL", 30_00_000);
	Customer objC=new Customer(1, "SJ", "PUN", 1, 20_00_000, "NA");
	try {
	int rowsInserted=new LoanTransaction().insertLoan(obj);
	rowsInserted=new CustomerTransaction().insertCustomer(objC);
	}
	catch(Exception e) {
		System.out.println(e);
	}
	}
}
