package com.capgemini.loanApplicationApproval;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class LoanTransaction {
	private Connection conn;

	public LoanTransaction() throws ClassNotFoundException, SQLException{
		this.conn =	DbConfig.connectMySQL();
	}
	
	public int insertLoan(Loan loan) throws SQLException {
		String query = String.format("INSERT INTO Loan(loanId, loanType, maxLimit) VALUES(%d, '%s', %d)",
						loan.getLoanId(), loan.getType(), loan.getMaxLimit());
		
		Statement stmt = conn.createStatement();
		return stmt.executeUpdate(query);
	}
}
