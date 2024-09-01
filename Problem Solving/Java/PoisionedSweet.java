/*
An enemy spy has poisoned one out of N sweets in a bakery. Even a bite of the poisoned sweet has potency to kill. However, the effects of the poison show only in 30 days. The managers asks the jailor to identify the poisoned sweet within 30 days. What is the least number of prisoners the jailor must employ to identify the poisoned sweet?
Note: A sweet can be eaten by any number of prisoners.

 

Example 1:

Input:
N = 3
Output:
2
Explanation:
The poison can be identified using
only 2 prisoners.
Example 2:

Input:
N = 2
Output:
1
Explanation:
The poison can be identified using
only 1 prisoner.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function numOfPrisoners() which takes an Integer N as input and returns the minimum number of prisoners required to identify the poisoned sweet.

 

Expected Time Complexity: O(log(N))
Expected Auxiliary Space: O(1)

 

Constraints:
1 <= N <= 109
*/

/*
Divide the sweets into batches, each containing an equal number of sweets.
Number the batches with consecutive integers starting from 1.
Let the number of batches be M, such that 2^(M-1) < N <= 2^M. This ensures that all sweets are included in the batches.
Number the prisoners from 1 to M.
On each day, each prisoner eats the sweet corresponding to their number and the batch number.
By tracking which prisoners die within 30 days, the jailor can determine the batch number containing the poisoned sweet.
The minimum number of prisoners required is the smallest M such that 2^(M-1) < N <= 2^M.
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
            System.out.println(ob.numOfPrisoners(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int numOfPrisoners(Long N) {
        // code here
        if(N==1)
            return 0;
        
        int c=(int)(Math.log(N)/Math.log(2));
        
        if(Math.pow(2, c)<N)
            c+=1;
        return c;
    }
};
