package com.capgemini.assignment1;
import java.util.Arrays;
import java.util.Scanner;

public class Permutation {
	private static int count=0;
	
	void printPermutations(int array[], int n)  
	{  count++;
		System.out.print("(");
	for (int i = 0; i < n-1; i++)  
	System.out.print(array[i] + ",");
	System.out.print(array[n-1]);
	System.out.print(")");
	System.out.println();  
	}  
 
	void findPermutation(int array[], int size, int n)  
	{  
	if (size == 1)  
	printPermutations(array, n);  
	for (int i = 0; i < size; i++)   
	{  
	findPermutation(array, size - 1, n);  
	if (size % 2 == 1)   
	{       
	int temp = array[0];  
	array[0] = array[size - 1];  
	array[size - 1] = temp;  
	}  
	else   
	{      
	int temp;    
	temp = array[i];  
	array[i] = array[size - 1];  
	array[size - 1] = temp;  
	}  
	}  
	}  
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner userInput=new Scanner(System.in);
		System.out.print("Total number N = ");
		int inputCount=userInput.nextInt();
		int inputArray[]=new int[inputCount];
		for(int i=0; i<inputCount; i++) {		
			System.out.print("Number #"+(i+1)+": ");
			inputArray[i]=userInput.nextInt();			
		}
		Permutation obj1=new Permutation();
		obj1.findPermutation(inputArray, inputCount, inputCount);
		System.out.println("The permutations of "+Arrays.toString(inputArray)+" are: "+count);
		userInput.close();
	}

}


