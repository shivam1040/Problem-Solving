/*
Given an array A[] of size N. The value of an array is denoted by the bit-wise XOR of all elements it contains. Find the bit-wise XOR of the values of all subarrays of A[].

Example 1:

Input: N = 3, A[] = {1,2,3} 
Output: 2
Explanation:
xor[1] = 1, 
xor[1, 2] = 3
xor[2, 3] = 1
xor[1, 2, 3] = 0
xor[2] = 2
xor[3] = 3
Result : 1 ^ 3 ^ 1 ^ 0 ^ 2 ^ 3 = 2

Example 2:

Input: N = 2, A[] = {1,2} 
Output: 0
Explanation:
xor[1] = 1, 
xor[1, 2] = 3
xor[2] = 2
Result : 1 ^ 3 ^ 2 = 0
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function gameOfXor() which takes an integer N and array A[] as input parameters and returns the answer.

 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

 

Constraints:
1 <= N <= 105
1 <= A[i ]<= 105
*/

/*
An efficient solution is based on the idea to enumerate all subarrays, we can count the frequency of each element that occurred totally in all subarrays, if the frequency of an element is odd then it will be included in the final result otherwise not. 

As in above example, 
3 occurred 5 times,
5 occurred 8 times,
2 occurred 9 times,
4 occurred 8 times,
6 occurred 5 times
So our final result will be xor of all elements which occurred odd number of times
i.e. 3^2^6 = 7

From above occurrence pattern we can observe that number at i-th index will have 
(i + 1) * (N - i) frequency. 
So we can iterate over all elements once and calculate their frequencies and if it is odd then we can include that in our final result by XORing it with the result. 
Total time complexity of the solution will be O(N) 
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
            
            String S[] = read.readLine().split(" ");
            int[] A = new int[N];
            
            for(int i=0 ; i<N ; i++)
                A[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.gameOfXor(N,A));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int gameOfXor(int N , int[] A) {
        // code here
        
        //since a^0=a
        int res=0;
        
        for(int i=0; i<N; i++){
            int f=(i+1)*(N-i);
            
            if(f%2==1)
                res^=A[i];
        }
        
        return res;
    }
};
