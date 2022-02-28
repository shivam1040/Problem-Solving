package com.capgemini.assignment.CollectionAssignment;

public class Department {
	private String departmentId, departmentName, location;

	public Department(String departmentId, String departmentName, String location) {
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.location = location;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public String getLocation() {
		return location;
	}	
}
