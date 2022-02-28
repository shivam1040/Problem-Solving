package com.capgemini.assignment1;
class Employee{
	String name, email, address, birthday;
	
	Employee(String name, String email, String address, String birthday){
		this.name=name;
		this.email=email;
		this.address=address;
		this.birthday=birthday;
	}
	
	void work() {
		
	}
}

class Programmer extends Employee{
	String programmingLanguages[];
	
	Programmer(String name, String email, String address, String birthday, String input[]){
		super(name, email, address, birthday);
		programmingLanguages=input;
	}
	
	void code() {
		
	}
	
	void fixBugs() {
		
	}
}

class Tester extends Employee{
	String testingMethodologies[];
	
	Tester(String name, String email, String address, String birthday, String input[]){
		super(name, email, address, birthday);
		testingMethodologies=input;
	}
	
	void test() {
		
	}
	
	void verify() {
		
	}
}

class Designer extends Employee{
	String testingMethodologies[];
	String designPhilosophy;
	
	Designer(String name, String email, String address, String birthday, String input[], String input1){
		super(name, email, address, birthday);
		this.testingMethodologies=input;
		this.designPhilosophy=input1;
	}
	
	void design() {
		
	}
	
}

class BusinessDeveloper extends Employee{
	String specializedDomains[];
	
	BusinessDeveloper(String name, String email, String address, String birthday, String input[]){
		super(name, email, address, birthday);
		specializedDomains=input;
	}
	
	void collect() {
		
	}
		
	void analyze() {
		
	}
	
	void write() {
		
	}
	
}

class TeamLeader extends Programmer{
	String teamCollaborationTools[],developmentMethods[];
	TeamLeader(String name, String email, String address, String birthday, String input0[], String input[], String input1[]){
		super(name, email, address, birthday, input0);
		this.teamCollaborationTools=input;
		this.developmentMethods=input1;
	}
	
	void schedule() {
		
	}
	
	void organize() {
		
	}
	
	void manageProgrammers() {
		
	}
	
	void manageTesters() {
		
	}
	
	void manageDesigners() {
		
	}
		
}
