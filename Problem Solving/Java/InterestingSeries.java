/*
Given a series of numbers  6, 14, 36, 98, 276... Identify the pattern in the series and help to identify the integer at Nth index. Indices are starting from 1.
Note: Calculate the answer modulo (109+7).

 

Example 1:

Input:
N = 2
Output:
14
Explanation:
14 is the 2nd integer of the Series.
Example 2:

Input:
N = 8
Output:
6818
Explanation:
6818 is the 8th integer of the Series.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function findNthNum() which takes an Integer N as input and returns the Nth number of the given Series.

 

Expected Time Complexity: O(log(N))
Expected Auxiliary Space: O(1)

 

Constraints:
1 <= N <= 105
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
            int N = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.findNthNum(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static Long findNthNum(int N) {
        // code here
        long p1=1, p2=1, p3=1;
        
        for(int i=0; i<N; i++){
            p2=(p2*2)%1000000007;
            p3=(p3*3)%1000000007;
        }
        return ((p1+p2)%1000000007+p3)%1000000007;
    }
};
