/*
Given 2 integers N and K. Convert N(given in Decimal) to base K.

 

Example 1:

Input:
N = 10, K = 2
Output:
1010
Explanation:
(10)10 = (1010)2
Example 2:

Input:
N = 4, K = 8
Output:
4
Explanation:
(4)10 = (4)8
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function changeBase() which takes Integers N and K as input and returns an integer as the answer.

 

Expected Time Complexity: O(logKN)
Expected Auxiliary Space: O(logKN)

 

Constraints:
1 <= N <= 105
2 <= K <= 10
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
            System.out.println(ob.changeBase(N,K));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static Long changeBase(int N , int K) {
        // code here
        long res=0, p=1;
        
        do{
            res+=(N%K)*p;
            p*=10;
            N/=K;
        }
        while(N!=0);
        return res;
    }
};
