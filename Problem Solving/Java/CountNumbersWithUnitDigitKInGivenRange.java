/*
Given a range from low to high and a number K. The task is to count the number which has the unit digit equal to K.

 

Example 1:

Input:
low = 4, high = 9, K = 4 
Output:
1
Explanation:
4 is the only number with 4 as the
unit digit in the range of (4,9).
Example 2:

Input:
low = 3, high = 35, K = 3 
Output:
4
Explanation:
3, 13, 23, and 33 are the only numbers
with 3 as the unit digit in the given range.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function countLastDigitK() which takes 3 Integers  low, high, and K as input and returns the answer.

 

Expected Time Complexity: O(1)
Expected Auxiliary Space: O(1)

 

Constraints:
1 <= low <= high <= 109
0 <= K <= 9
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
            
            Long low = Long.parseLong(S[0]);
            Long high = Long.parseLong(S[1]);
            Long K = Long.parseLong(S[2]);

            Solution ob = new Solution();
            System.out.println(ob.countLastDigitK(low,high,K));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int countLastDigitK(Long low, Long high, Long K) {
        // code here
        //An efficient solution is based on the fact that every digit appears once as the last digit in every 10 consecutive numbers. 
        long mL=(long)Math.ceil(low/10.0), mH=(long)Math.floor(high/10.0), count=(mH-mL);
        //this takes care if high last digit is greater than k then it means there is one more number as per the above logic whose last digit is k
        if(high%10>=K)
            count++;
        if(low%10<=K&&low%10>0)
            count++;
        return (int)count;
    }
};
