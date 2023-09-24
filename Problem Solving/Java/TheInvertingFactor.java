/*
Ishaan being curious as always was playing with numbers when he started to reverse the numbers. He invented something called the "inverting factor" of two numbers.
The inverting Factor of 2 integers is defined as the absolute difference between the reverse of the 2 integers.
Ishaan has an array A of N integers. He wants to find out the smallest possible Inverting Factor among all pairs of his integers. Help him find that.
Note : Trailing zeros in a number of ignored while reversing, i.e. 1200 becomes 21 when reversed.

 

Example 1:

â€‹Input : arr[ ] = {56, 20, 47, 93, 45}
Output : 9
Explanation:
The minimum inverting factor is 9, of the pair (56,47)
Reverse 56 -> 65 and 47 -> 74
difference between them is 9.

â€‹Example 2:

Input : arr[ ] = {48, 23, 100, 71, 56, 89} 
Output :  14 
 

Your Task:
This is a function problem. The input is already taken care of by the driver code. You only need to complete the function findMinimumInvertingFactor() that takes an array (arr), sizeOfArray (n), and return the smallest possible Inverting Factor among all pairs of his integers. The driver code takes care of the printing.

Expected Time Complexity: O(N*LOG(N)).
Expected Auxiliary Space: O(1).

 

Constraints : 
2 ≤ N ≤ 105
1 ≤ A[i] ≤ 107
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
		    int ans = obj.findMinimumInvertingFactor(arr, sizeOfArray);
		    System.out.println(ans);
		}
	}
}




// } Driver Code Ends


//User function Template for Java


class Complete{
    
   
    // Function for finding maximum and value pair
    public static int findMinimumInvertingFactor (int arr[], int n) {
        //Complete the function
        int min=Integer.MAX_VALUE;
        
        for(int i=0; i<n; i++)
            arr[i]=rev(arr[i]);
        
        Arrays.sort(arr);
        
        for(int i=1; i<n; i++)
            min=Math.min(min, arr[i]-arr[i-1]);
        
        return min;
    }
    
    private static int rev(int n){
        int rev=0;
        
        while(n!=0){
            int rem=n%10;
            rev=rev*10+rem;
            n/=10;
        }
        
        return rev;
    }
    
    
}



