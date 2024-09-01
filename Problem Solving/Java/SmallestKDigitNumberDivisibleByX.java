/*
Given two integers X and K. The task is to find smallest K-digit number divisible by X.
Note: It is given that number of digits in X is always smaller or equal to K.

 

Example 1:

Input:
X = 6, K = 1
Output:
6
Explanation:
6 is the smallest 1 digit number
which is divisible by 6.
Example 2:

Input:
X = 5, K = 2
Output:
10
Explanation:
10 is the smallest 2 digit number
which is divisible by 5.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function smallestKDigitNum() which takes 2 Integers X and K as input and returns the answer.

 

Expected Time Complexity: O(1)
Expected Auxiliary Space: O(1)

 

Constraints:
1 <= X <= 105
1 <= K <= 18
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
            
            Long X = Long.parseLong(S[0]);
            Long K = Long.parseLong(S[1]);

            Solution ob = new Solution();
            System.out.println(ob.smallestKDigitNum(X,K));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static Long smallestKDigitNum(Long X, Long K) {
        // code here
        //gets smallest k digit number
        long temp=(long)Math.pow(10, K-1);
        long temp1=temp%X;
        
        //if not divisible then get what's needed to make it divisble and add the smallest k digit number so that we get smallest k digit number that's divisible by X
        return temp1==0 ? temp : temp+(X-temp1);
    }
};
