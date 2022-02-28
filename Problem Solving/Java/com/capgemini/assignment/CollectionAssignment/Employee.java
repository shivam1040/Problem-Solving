package com.capgemini.assignment.CollectionAssignment;

import java.util.List;

public class Employee {
	private String employeeId, firstName, lastName, dateOfjoining;
	private Integer salary;
	private Department department;
	private List<Address> address;
	
	public Employee(String employeeId, String firstName, String lastName, Integer salary, String dateOfjoining, Department department, List<Address> address) {
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary=salary;
		this.dateOfjoining = dateOfjoining;
		this.department = department;
		this.address = address;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getDateOfjoining() {
		return dateOfjoining;
	}

	public Integer getSalary() {
		return salary;
	}

	public Department getDepartment() {
		return department;
	}

	public List<Address> getAddress() {
		return address;
	}
}
