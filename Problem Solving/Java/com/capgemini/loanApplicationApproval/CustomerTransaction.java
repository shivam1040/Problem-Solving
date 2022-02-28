package com.capgemini.loanApplicationApproval;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CustomerTransaction {
	private Connection conn;
	
	public CustomerTransaction() throws ClassNotFoundException, SQLException{
		this.conn =	DbConfig.connectMySQL();
	}
	
	public int insertCustomer(Customer customer) throws SQLException {
		String query = String.format("INSERT INTO Customer(custId, custName, location, fkLoanId, requestedAmt, status) VALUES(%d, '%s', '%s', %d, %d, '%s')",
						customer.getCustId(), customer.getCustName(), customer.getLocation(), customer.getFkLoanId(), customer.getRequestedAmount(), customer.getStatus());
		Statement stmt = conn.createStatement();
		return stmt.executeUpdate(query);
	}
}
