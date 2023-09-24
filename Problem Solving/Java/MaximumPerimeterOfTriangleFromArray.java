/*
Given an Array of non-negative integers. Find out the maximum perimeter of the triangle from the array.

Example 1:

â€‹Input : arr[ ] = {6, 1, 6, 5, 8, 4}
Output : 20
Explanation:
Triangle formed by  8,6 & 6. Thus 
perimeter 20.

â€‹Example 2:

Input : arr[ ] = {7, 55, 20, 1, 4, 33, 12} 
Output :  -1
Explanation:
As the triangle is not possible because 
the condition: the sum of two sides should 
be greater than third is not fulfilled here.
 
Your Task:
This is a function problem. The input is already taken care of by the driver code. You only need to complete the function maxPerimeter() that takes an array (arr), sizeOfArray (n), and return an integer displaying the maximum perimeter of the triangle is possible else print -1. The driver code takes care of the printing.

Expected Time Complexity: O(N*LOG(N)).
Expected Auxiliary Space: O(1).



Constraints:
3 ≤ N ≤ 105
1 ≤ Arr[i] ≤105
*/

//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    String line = br.readLine();
		    String[] element = line.trim().split("\\s+");
		    int sizeOfArray = Integer.parseInt(element[0]);
		    
		    int arr [] = new int[sizeOfArray];
		    
		    line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    
		    
		    Complete obj = new Complete();
		    int res = obj.maxPerimeter(arr, sizeOfArray);
		    
		    System.out.println(res);
		}
	}
}


            

// } Driver Code Ends


//User function Template for Java



class Complete{
    
   
    // Function for finding maximum and value pair
    public static int maxPerimeter (int arr[], int n) {
        //Complete the function
        Arrays.sort(arr);
        int a=-1;
        int b=-1;
        int c=-1;
        
        for(int i=n-3; i>=0; i--){
            a=arr[i+2];
            b=arr[i+1];
            c=arr[i];
            
            if(a<c+b){
                return a+b+c;
            }
        }
        
        return -1;
    }
    
    
}



