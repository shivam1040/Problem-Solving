package com.capgemini.assignment.CollectionAssignment;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
		static boolean employeeIdCheck(String employeeId) {
			int digits = 0;
	        for (int i = 0; i < employeeId.length()-2; i++) {
	            if (employeeId.charAt(i) >= 48 && employeeId.charAt(i) <= 57) {
	                digits++;
	            }
	            else {
	            	digits++;
	            }  
	        }
	        if(digits==5 && (employeeId.charAt(employeeId.length()-1)>='A' && employeeId.charAt(employeeId.length()-1)<='Z') && (employeeId.charAt(employeeId.length()-2)>='A' && employeeId.charAt(employeeId.length()-2)<='Z'))
	        	return true;
	        return false;  	
		}
			
		static boolean uniqueCheck(List<Employee> obj, String id) {
			for(Employee i: obj)
				if(i.getEmployeeId().equals(id))
					return false;
			return true;
		}
		
		static boolean nameAlphabetCheck(String name) {
			for(int i=0; i<name.length(); i++) {
				if((name.charAt(i)>='A' && name.charAt(i)<='Z') || (name.charAt(i)>='a' && name.charAt(i)<='z'))
					continue;
				else
					return false;
			}
			return true;
		}
		
		static Employee employeeAdd(List<Employee> obj, Scanner userInput) {
			//Scanner userInput=new Scanner(System.in);
			String id="", fName="", lName="", dJoin="";
			Department department=null;
			List<Address> addresses=new ArrayList<Address>();
			Integer salary=0;
			while(true) {
			System.out.println("Enter employee's id:");
			id=userInput.nextLine();
			if(!employeeIdCheck(id)) {
				System.out.println("Invalid ID, please enter the id equivalent to 12345FS");
				continue;
			}
			if(!uniqueCheck(obj, id)) {
				System.out.println("Entered ID is already present. Please enter a different ID.");
				continue;
			}
			else {
				break;
			}
			}
			while(true) {
			System.out.println("Enter employee's First Name:");
			fName=userInput.nextLine();
			System.out.println("Enter employee's Last Name:");
			lName=userInput.nextLine();
			if(!nameAlphabetCheck(lName) && !nameAlphabetCheck(fName)) {
				System.out.println("Invalid Name, enter only alphabets for names");
				continue;
			}
			else {
				break;
			}
			}
			while(true) {
				System.out.println("Enter employee's DOJ as dd-mm-yyyy:");
				dJoin=userInput.nextLine();
				DateFormat sdformat = new SimpleDateFormat("dd-MM-yyyy");
				try {
				Date join = sdformat.parse(dJoin);
				Date today = new Date();  
			    String strDate=sdformat.format(today);
			    today=sdformat.parse(strDate);
			    if(join.compareTo(today) < 0) {
			         System.out.println("Invalid date, enter a date equal to today's date or more than it");
			         continue;
			    }
			    else {
			    	break;
			    }
				}
				catch(Exception e) {
					System.out.println(e);
				}
			}
			while(true) {
				System.out.println("Enter salary:");
				salary=userInput.nextInt();
				if(salary<20000 || salary>500000) {
					System.out.println("Salary out of range, enter salary in the range of 20000 to 500000");
					continue;
				}
				else {
					break;
				}
			}
				String dId="", dName="", location="";
				System.out.println("Enter employee's dept ID:");
				userInput.skip("\\R?");
				dId=userInput.nextLine();
				System.out.println("Enter employee's dept name:");
				dName=userInput.nextLine();
				System.out.println("Enter employee's dept location:");
				location=userInput.nextLine();
				department=new Department(dId, dName, location);
				while(true) {
					boolean check=true;
					String aId="", aLine1="", city="", state="";
					System.out.println("Enter employee's address ID:");
					aId=userInput.nextLine();
					System.out.println("Enter employee's address line 1:");
					aLine1=userInput.nextLine();
					System.out.println("Enter employee's city:");
					city=userInput.nextLine();
					System.out.println("Enter employee's state:");
					state=userInput.nextLine();
					for(Address i:addresses) {
						if(i.getAddressId().equals(aId)) {
							System.out.println("Address ID is already present for the current employee. Enter another ID.");
							check=false;
						}
					}
					if(check) {
					addresses.add(new Address(aId, aLine1, city, state));
					System.out.println("Do you want to enter another address? Enter Y or N:");
					String wish=userInput.nextLine();
					if(wish.equals("Y"))
						continue;
					else
						break;
				}
					else {
						continue;
					}
				}
				Collections.sort(addresses, new Comparator<Address>() {

					@Override
					public int compare(Address o1, Address o2) {
						// TODO Auto-generated method stub
						return o1.getAddressId().compareTo(o2.getAddressId());
					}
					
				});
				return new Employee(id, fName, lName, salary, dJoin, department, addresses);
		}
		
		static List<Employee> sort(List<Employee> obj, String type){
			if(type.equals("a")) {
				Collections.sort(obj, new Comparator<Employee>() {
					public int compare(Employee o1, Employee o2) {
						// TODO Auto-generated method stub
						return o1.getEmployeeId().compareTo(o2.getEmployeeId());
					}
				});
				return obj;
			}
			else if(type.equals("b")) {
				Collections.sort(obj, new Comparator<Employee>() {
					public int compare(Employee o1, Employee o2) {
						// TODO Auto-generated method stub
						return o1.getFirstName().compareTo(o2.getFirstName());
					}
				});
				return obj;
			}
			else if(type.equals("c")) {
				Collections.sort(obj, new Comparator<Employee>() {
					public int compare(Employee o1, Employee o2) {
						// TODO Auto-generated method stub
						return o1.getLastName().compareTo(o2.getLastName());
					}
				});
				return obj;
			}
			else if(type.equals("d")) {
				Collections.sort(obj, new Comparator<Employee>() {
					public int compare(Employee o1, Employee o2) {
						// TODO Auto-generated method stub
						if(o1.getSalary()<o2.getSalary()) return -1;
						if(o1.getSalary()>o2.getSalary()) return 1;
						return 0;
					}
				});
				return obj;
			}
			else if(type.equals("e")) {
				Collections.sort(obj, new Comparator<Employee>() {
					public int compare(Employee o1, Employee o2) {
						// TODO Auto-generated method stub
						return o1.getAddress().get(0).getAddressId().compareTo(o2.getAddress().get(0).getAddressId());
					}
				});
				return obj;
			}
			else if(type.equals("f")) {
				Collections.sort(obj, new Comparator<Employee>() {
					public int compare(Employee o1, Employee o2) {
						// TODO Auto-generated method stub
						return o1.getDepartment().getDepartmentId().compareTo(o2.getDepartment().getDepartmentId());
					}
				});
				return obj;
			}
			return obj;
		}
		
	public static void main(String args[]) {
		List<Employee> employeeObj=new ArrayList<Employee>();
		Scanner userInput=new Scanner(System.in);
		while(true) {
			System.out.println("1. Save Unique Employee\n2. Sort Employee\n    a. ByEmployeeId\n    b. ByFirstName\n    c. ByLastName\n    d. BySalary\n    e. ByAddress\n    f. ByDeprtment\n3. Exit");
			String choice=userInput.nextLine();
			if(choice.equals("1")) {
				employeeObj.add(employeeAdd(employeeObj, userInput));
				}
			else if(choice.equals("2")) {
				System.out.println("Enter the type of sorting:");
				String type=userInput.nextLine();
				employeeObj=sort(employeeObj, type);
			}
			else {	
				break;
			}
			System.out.println();
			}
		userInput.close();
		}
	}
