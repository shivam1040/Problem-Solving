/*
Given a month with arbitrary number of days, N, and an integer K representing the day with which it starts. ie- 1 for Monday, 2 for Tuesday and so on.  Find the number of times each day (Monday, Tuesday, ..., Sunday) appears in the month. 

 

Example 1:

Input:
N = 31 , K = 1
Output:
5 5 5 4 4 4 4 
Explanation: The month starts from Monday.
There will be 4 days of each day
(Sunday , Monday , etc) upto 28th of the
Month. Then, The successive 3 days will
have a extra day each. So, Monday, Tuesday
and Wednesday will have 5 days while the
others will have 4 days each.

Example 2:

Input:
N = 28, K = 5
Output:
5 5 5 4 4 4 4 
Explanation: Each day of the month will
have 4 days each and thus the Output.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function daysOfWeeks() which takes Integers N  and K as input and return a list of 7 integers indicating number of days in each day of the week.

 

Expected Time Complexity: O(1)
Expected Auxiliary Space: O(1)
 

Constraints:
1 <= N <= 105
1 <= K <= 7
*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            int N = Integer.parseInt(S[0]);
            int K = Integer.parseInt(S[1]);

            Solution ob = new Solution();
            int[] ans = ob.daysOfWeeks(N,K);
        
            for(int i=0 ; i<7 ; i++)
            {
                System.out.print(ans[i]);
                if(i<6)
                    System.out.print(' ');
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    static int[] daysOfWeeks(int N , int K) {
        // code here
        int res[]=new int[]{N/7, N/7, N/7, N/7, N/7, N/7, N/7};
        
        for(int i=0; i<N%7; i++)
            res[(i+K-1)%7]++;
        
        return res;
    }
};
