/*
Given an array of N integers, using ‘+’ and ‘-‘ between the elements check if there is a way to form a sequence of numbers that evaluates a number divisible by M.
 

Example 1:

â€‹Input : arr[ ] = {1, 2, 3, 4, 6} and M = 4
Output : 1
Explanation:
There is a valid sequence i. e., 
(1 - 2 + 3 + 4 + 6), which evaluates to 12 
that is divisible by 4.


Example 2:

Input : arr[ ] = {1, 3, 9} 
Output :  0 
 

Your Task:
This is a function problem. The input is already taken care of by the driver code. You only need to complete the function validSequence() that takes an array (arr), sizeOfArray (n), an integer M and return the true if there is a way to form a sequence of numbers which evaluate to a number divisible by M else return false. The driver code takes care of the printing.

Expected Time Complexity: O(N*M).
Expected Auxiliary Space: O(N*M).
 

Constraints:
1 ≤ N < 1000
1 ≤ M <1000
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
		    int N = Integer.parseInt(element[0]);
		    int arr [] = new int[N];
		    line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    for(int i = 0;i<N;i++){
	            arr[i] = Integer.parseInt(elements[i]);    
	        }
		    
		    int M = Integer.parseInt(br.readLine());
		    
		    Complete obj = new Complete();
		    boolean ans = obj.validSequence(arr, N, M);
		    if(ans == true)
		        System.out.println(1);
		    else
		        System.out.println(0);
		    
		}
	}
}


// } Driver Code Ends


//User function Template for Java


class Complete{
   
    // Function for finding maximum and value pair
    public static boolean validSequence (int arr[], int n, int m) {
        //Complete the function
        int dp[][] = new int[n + 1][m];
        for(int i = 0; i < n + 1; i++)
            Arrays.fill(dp[i], -1);
        
         return isPossible(n, 0, 0, m, arr, dp);
    }
    
        static boolean isPossible(int n, int index, int sum,
                            int M, int arr[], int dp[][])
    {
        //doing this to avoid negatives
     sum = ((sum % M) + M) % M;
        // Base case
        if (index == n)
        {
     
            // check if sum is divisible by M
            if ((sum % M) == 0)
                return true;
            return false;
        }
        else if(sum < 0)
            return false;
     
        // check if the current state
        // is already computed
        if (dp[index][sum] != -1)
        {
            if(dp[index][sum] == 0)
                return false;
            return true;
        }
         
        // 1.Try placing '+'
        boolean placeAdd = isPossible(n, index + 1,
                (sum + arr[index]), M, arr, dp);
     
        // 2. Try placing '-'
        boolean placeMinus = isPossible(n, index + 1,
                    (sum - arr[index]), M, arr, dp);
     
        // calculate value of res for recursive case
        boolean res = (placeAdd || placeMinus);
     
        // store the value for res for current
        // states and return for parent call
        dp[index][sum] = (res) ? 1 : 0;
        return res;
    }
}

