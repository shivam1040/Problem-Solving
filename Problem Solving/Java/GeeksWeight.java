/*
Geek is getting really fat. He wants to lose his weight but can't get the motivation to workout. Seeing this, his friend  Heisenberg offers him a deal.
For every K pushups Geek does, Heisenberg will give him money equal to the number of pushups Geek has done till then (Refer Example for Explanation).
Find out the amount of money he made if he does N pushups.

Example 1:

Input: N = 5, K = 2
Output: 6
Explanation: Pushup 1: No Money, Pushup 2: 
+2 Pushup 3: No Money, Pushup 4: +4 and 
Pushup 5: No Money.
Example 2:

Input: N = 5, K = 3
Output: 3
Explanation: Pushup 1: No Money, Pushup 2: 
No Money, Pushup 3: +3, Pushup 4: No Money 
and Pushup 5: No Money.
 

Your Task: 
You don't need to read or print anything. Your task is to complete the function total_Money() which takes N and K as input parameter and returns the amount that Ishan can make.

Expected Time  Complexity: O(1)
Expected Space Complexity: O(1)
 

Constraints:
1 <= N <= 109
1 <= K <= 105
*/

//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String s = br.readLine().trim();
            String[] S = s.split(" ");
            int n = Integer.parseInt(S[0]);
            int k = Integer.parseInt(S[1]);
            Solution ob = new Solution();
            long ans = ob.total_Money(n, k);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public long total_Money(int n, int k)
    {
        // code here
        // int res=0;
        
        // for(long i=k; i<=n; i+=k){
        //         //System.out.println(i);
        //         res+=i;
        // }
        // return res;
        
        long parts=n/k;
        
        return parts*(2*k+(parts-1)*k)/2;
    }
}
