/*
You will be given a positive integer N. Your task is to find the number of positive integers K ≤ N such that K is not divisible by any number among the set {2,3,4,5,6,7,8,9,10}.

 

Example 1:

Input:
N = 11
Output:
2
Explanation:
1 and 11 are the only possible solutions.
Example 2:

Input:
N = 2
Output:
1
Explanation:
1 is the only possible solution.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function noOfNumbers() which takes an Integer N as input and returns the answer.

 

Expected Time Complexity: O(1)
Expected Auxiliary Space: O(1)

 

Constraints:
1 <= N <= 1018
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
            Long N = Long.parseLong(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.noOfNumbers(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static Long noOfNumbers(Long n) {
        // code here
//Important to note that only 2,3,5,7 are the key no here and rest are multiple of them.
         //Here a is total no which divisible by 7 but not by 2,3,5
        long a=n/7-n/14-n/21-n/35+n/42-n/210+n/70+n/105;
         //Here b is total no which divisible by 5 but not by 2,3
        long b=n/5-n/10-n/15+n/30;
           //Here c is total no which divisible by 3 but not by 2
        long c=n/3-n/6;
        //Here d is total no which is divisible by 2
        long d=n/2;
        
        return n-(a+b+c+d);
    }
};
