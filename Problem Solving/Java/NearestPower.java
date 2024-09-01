/*
Given two integers N and M  you have to find out an integer which is a power of M and is nearest to N.
Note: If there are multiple answers possible to, print the greatest number possible.

 

Example 1:

Input:
N = 6, M = 3
Output:
9
Explanation:
Both 3 (31) and 9 (32) are equally
near to 6. But 9 is greater,
so the Output is 9.
Example 2:

Input:
N = 3, M = 2
Output:
4
Explanation:
Both 2 (21) and 4 (22) are equally
near to 3. But 4 is greater,
so the Output is 4.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function nearestPower() which takes 2 Integers N and M as input and returns the answer.

 

Expected Time Complexity: O(max(log(N),log(M)))
Expected Auxiliary Space: O(1)

 

Constraints:
1 <= N,M <= 109
*/

/*
We need to first compute the lower and upper powers of M nearest to N.
This can be achieved by taking up log(N) base M, Them proceed further.

pseudo code:
lowestpower = log(N) / log(M)
A = pow(M, floor(lowestpower))
B = A * M
//Now we need to compare, which is nearest to N
if (A is nearest to N)
 print A
else
 print B
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
            
            Long N = Long.parseLong(S[0])
            Long M = Long.parseLong(S[1])

            Solution ob = new Solution();
            System.out.println(ob.nearestPower(N,M));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static Long nearestPower(Long N , Long M) {
        // code here
        long power=Math.log(N)/Math.log(M), power=Math.pow(M, power), B=power*M;
        
        return Math.abs(N-power) >= Math.abs(N-B) ? power>B ? power : B : B;
    }
};
