/*
Given two stacks of pizzas such that each contains 10 pizzas of varying radii. Geek can only eat a pizza from a stack if it is also present in the other stack, in the same order. The pizzas that he selects need not be continuous. Find the number of pizzas Geek can eat.

 

Example 1:

Input:
Stack1 = {891 424 945 741 897 514 692 221 678 168}
Stack2 = {702 952 221 614 69 753 821 971 318 364}
Output: 1
Explanation: There is only one common element.
 

Example 2:

Input:
Stack1 = {476 241 866 571 827 599 949 948 579 726}
Stack2 = {371 359 610 216 885 876 92 10 171 724}
Output: 0
Explanation: There is no common element.


Your Task:  
You don't need to read input or print anything. Your task is to complete the function getCommon() which takes two arrays stack1[] and stack2[], each of fixed size 10 as input parameters and returns the number of pizzas Geek can eat.

 

Expected Time Complexity : O(N2)
Expected Auxiliary Space : O(N2) Where N is the stack length = 10.

 

Constraints:
Stack1 = Stack2 = 10
1 <= radii <= 103


*/

//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int stack1[] = new int[10];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < 10; i++) {
                stack1[i] = Integer.parseInt(inputLine[i]);
            }
            
            int stack2[] = new int[10];
            String inputLine2[] = br.readLine().trim().split(" ");
            for (int i = 0; i < 10; i++) {
                stack2[i] = Integer.parseInt(inputLine2[i]);
            }
            
            Solution obj = new Solution();

            System.out.println(obj.getCommon(stack1, stack2));
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java



class Solution {

    public static int getCommon(int stack1[], int stack2[]) {
        // Write your code here
        int dp[][]=new int[11][11];
        
        //finding LCS
        for(int i=1; i<11; i++){
            for(int j=1; j<11; j++){
                if(stack1[i-1]==stack2[j-1]){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else
                    dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        
        return dp[10][10];
    }
}

