/*
Given an array of length N, starting from 1 to N. At each iteration, you remove all elements at odd positions, until only one element is left. Find the last remaining element.

 

Example 1:

Input:
N = 5
Output:
4
Explanation:
Initial Array- {1,2,3,4,5}.
After 1st Iteration- {2,4}.
After 2nd Interation- {4}
Threfore, the answer is 4.
Example 2:

Input:
N = 3
Output:
2
Explanation:
Initial Array- {1,2,3}.
After 1st Iteration- {2}.
Threfore, the answer is 2.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function oddGame() which takes an Integer N as input and returns the last remaining element.

 

Expected Time Complexity: O(log(N))
Expected Auxiliary Space: O(1)

 

Constraints:
1 <= N <= 109
*/

//{ Driver Code Starts


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
            System.out.println(ob.oddGame(N));
        }
    }
}
// } Driver Code Ends




class Solution {
    static Long oddGame(Long N) {
        // code here
        if(N==1)
            return N;
        
        long res=2;
  //idea is to find power of 2 highest and lesser than N, do the iteration by removing eles one by one you'd find the pattern      
        while(res<N)
            res*=2;
        if(res>N)
            return res/2;
        return res;
    }
};
