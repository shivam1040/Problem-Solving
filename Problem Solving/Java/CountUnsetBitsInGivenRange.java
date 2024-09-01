/*
Given a non-negative number n and two values l and r. The problem is to count the number of unset bits in the range l to r in the binary representation of n, i.e. to count unset bits from the rightmost lth bit to the rightmost rth bit.

 

Example 1:

Input:
n = 42, l = 2, r = 5
Output:
2
Explanation:
(42)10 = (101010)2
There are '2' unset bits in the range 2 to 5.
Example 2:

Input:
n = 80, l = 1, r = 4
Output:
4
Explanation:
(80)10 = (1010000)2
There are '4' unset bits in the range 1 to 4.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function countUnsetBits() which takes 3 Integers n, a, and b as input and returns the count of unset bits in the given range of [l, r].

 

Expected Time Complexity: O(log(n))
Expected Auxiliary Space: O(1)

 

Constraints:
1 <= n <= 105
1 <= l <= r <= 17


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
            
            int n = Integer.parseInt(S[0]);
            int l = Integer.parseInt(S[1]);
            int r = Integer.parseInt(S[2]);

            Solution ob = new Solution();
            System.out.println(ob.countUnsetBits(n,l,r));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int countUnsetBits(int n, int l, int r) {
        // code here
        int temp=0, res=0;
        
        while(n>0){
            temp++;
            if(temp>=l && temp<=r){
                if((n&1)==0)
                    res++;
            }
            n>>=1;
        }
        return res;
    }
};
