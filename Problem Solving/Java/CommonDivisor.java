/*
Given two numbers, A and B. Find the number of common divisors of A and B. 
 

Example 1:

â€‹Input : A = 2 and B = 4
Output : 2
Explanation:
There are only two common divisor of 2 and 4.
That is 1 and 2.

â€‹Example 2:

Input : A = 3 and B = 5 
Output :  1
 

Your Task:
This is a function problem. The input is already taken care of by the driver code. You only need to complete the function common_divisor() that takes an integer A, another integer B, and return the number of the common divisor of A and B. The driver code takes care of the printing.

Expected Time Complexity: O(SQRT(min(A,B))).
Expected Auxiliary Space: O(1).
 

Constraints:

1 ≤ A, B ≤ 107
*/

//{ Driver Code Starts
//Initial Template for Java

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
		    int N = Integer.parseInt(element[0]);
		    int M = Integer.parseInt(element[1]);
		   
		    
		    Complete obj = new Complete();
		    int ans = obj.common_divisor(N, M);
		    System.out.println(ans);
		}
	}
}




// } Driver Code Ends


//User function Template for Java


class Complete{
    
    // Function for finding maximum and value pair
    public static int common_divisor (int n, int m) {
        //Complete the function
        int min=Math.min(n, m);
        int res=0;
        
        for(int i=1; i<=min; i++){
            if(n%i==0 && m%i==0){
                res++;
            }
        }
        return res;
    }
    
    
}
