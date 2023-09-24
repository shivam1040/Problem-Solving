/*
Find the count of all possible strings of size n.Each character of the string is either ‘R’, ‘B’ or ‘G’. In the final string there needs to be at least r number of ‘R’, at least b number of ‘B’ and at least g number of ‘G’ (such that r + g + b <= n). 

Example 1:

Input: n = 4, r = 1, g = 1, b = 1
Output: 36 
Explanation: No. of 'R' >= 1, 
No. of ‘G’ >= 1, No. of ‘B’ >= 1 
and (No. of ‘R’) + (No. of ‘B’) 
+ (No. of ‘G’) = n then 
following cases are possible: 
1. RBGR and its 12 permutation 
2. RBGB and its 12 permutation 
3. RBGG and its 12 permutation 
Hence answer is 36.
Example 2:

Input: n = 4, r = 2, g = 0, b = 1
Output: 22
Explanation: No. of 'R' >= 2,
No. of ‘G’ >= 0, No. of ‘B’ >= 1
and (No. of ‘R’) + (No. of ‘B’)
+ (No. of ‘G’) <= n then 
following cases are possible:
1. RRBR and its 4 permutation
2. RRBG and its 12 permutation
3. RRBB and its 6 permutation
Hence answer is 22.

Your Task:  
You dont need to read input or print anything. Complete the function possibleStrings() which takes n, r, g, b as input parameter and returns the count of number of all possible strings..

Expected Time Complexity: O(n2)
Expected Auxiliary Space: O(n)

Constraints:
1<= n <=20
1<= r+b+g <=n
*/

//{ Driver Code Starts
// Initial Template for Java
import java.util.*;
import java.io.*;

// } Driver Code Ends
// User function Template for Java
class Solution {
    static long possibleStrings(int n, int r, int b, int g) {
        // code here
        //computing fact beforehand
        long fact[]=new long[n+1];
        fact[0]=1;
        
        for(int i=1; i<=n; i++)
            fact[i]=fact[i-1]*i;
            //remaining values to be added
        int rem=n-(r+g+b);
        
        long ans=0;
        
        for(int i=0; i<=rem; i++){
            for(int j=0; j<=rem-i; j++){
                int k=rem-(i+j);
                //finfing perm and combination here
                ans+=fact[n]/(fact[r+i]*fact[g+j]*fact[b+k]);
            }
        }
        return ans;
    }
}


//{ Driver Code Starts.
class GFG {
    public static void main(String args[]) throws IOException {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int r = in.nextInt();
            int g = in.nextInt();
            int b = in.nextInt();
            Solution ob = new Solution();

            System.out.println(ob.possibleStrings(n, r, b, g));
        }
    }
}
// } Driver Code Ends
