/*
Given N objects of K different kinds and the values of each of the K different kinds of objects in an array A. Assuming that each of the N objects can be of any of the K kinds(having equal probability), find the expected value of the N objects.

Example 1:

Input:
N=1
K=2
A=[10,8]
Output:
9
Explanation:
The object can be either of the first
kind with value 10 or the second kind
with value 8.Therefore, the expected value is 9.
Example 2:

Input:
N=2
K=5
A=[1,2,3,4,5]
Output:
6
Explanation:
The first object can be any one of the 
five kinds and the second object can be
any one of the five kinds.Thus, the expected
value of 2 objects is 6.

Your Task:
You don't need to read input or print anything. Your task is to complete the function expectedValue()  which takes two numbers N and K as well as an array of K numbers as input parameters and returns the expected value of the N objects.


Expected Time Complexity:O(N)
Expected Auxillary Space:O(1)
 

Constraints:
1<=K<=105
1<=N,A[i]<=106, for i=[1,K]
*/

/*
The intuition here is that, when you randomly select N objects from K different kinds, you can think of each selection as a random experiment. In each experiment, you have a certain probability of selecting each kind of object, and the value associated with the selected object is added to a running total (temp). By repeating this experiment N times, you effectively calculate the sum of values for N objects, and then the expected value is calculated by dividing this sum by K.

In this context, the expected value provides an average or expected outcome based on these random selections. It's a way of quantifying the average value you would expect to obtain when choosing N objects randomly from K kinds, considering the values associated with each kind.
*/

//{ Driver Code Starts
// Initial Template for Java

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
            String S1[] = read.readLine().split(" ");
            int A[] = new int[K];
            for (int i = 0; i < K; i++) A[i] = Integer.parseInt(S1[i]);
            Solution ob = new Solution();
            System.out.println(ob.expectedValue(N, K, A));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    long expectedValue(int N, int K, int A[]) {
        // code here
        long temp=0;
        
        for(int i:A)
            temp+=i;
        return (int)((N*temp)/K);
    }
}
