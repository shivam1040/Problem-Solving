/*
Find the number of leaf nodes in a full k-ary tree of height m.
Note: You have to return the answer module 109+7.

 

Example 1:

Input:
k = 2, m = 2
Output:
4
Explanation:
A full Binary tree of height 2 has 4 leaf nodes. 
Example 2:

Input:
k = 2, m = 1
Output:
2
Explanation:
A full Binary tree of height 1 has 2 leaf nodes.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function karyTree() which takes 2 Integers k, and m as input and returns the number of leaf nodes in a full k-ary Tree.

 

Expected Time Complexity: O(log(m))
Expected Auxiliary Space: O(1)

 

Constraints:
1 <= k,m <= 108
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
            String S[] = read.readLine().split(" ");
            
            int k = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);

            Solution ob = new Solution();
            System.out.println(ob.karyTree(k,m));
        }
    }
}
// } Driver Code Ends



class Solution {
    static Long karyTree(int k, int m) {
        // code here
        return pow(k,m);
    }
    
    static Long pow(long k,long m){
       long mod=1000000007L;
       long ans=1L;
       
       while(m>0){
           if(m%2!=0){
               //this is done to ensure if k pow m where m is odd so we multiply k one more time to cosider it because basically we are refactoring i.e. k pow 8 to k pow 4*k pow 4
               ans=(ans%mod)*(k%mod);
           }
           m/=2;
           k=(k%mod)*(k%mod);
       }
       return ans%mod;
    }
};
