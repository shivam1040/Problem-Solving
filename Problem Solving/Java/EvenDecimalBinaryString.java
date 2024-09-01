/*Given a binary string of size N, you have to return the number of substrings that have even value in its decimal form.
Note: Most significant bit is on the right end side. For example - binary representation of 6 is 011. 

Example 1:

Input:
N = 3
S = "101"
Output: 2
Explanation : 
Substrings in S: 
1, 10, 101, 0, 01, 1
Corresponding decimal values:
1, 1, 5, 0, 2, 1
There are only 2 even decimal valued 
substrings.
Example 2:

Input:
N = 5
S = "10010"
Output: 
8
Explanation:
Substrings in S:
1, 0, 0, 1, 0, 10, 00, 01, 10, 100, 
001, 010, 1001, 0010 and 10010
Corresponding decimal Values are:
1, 0, 0, 1, 0, 1, 0, 2, 1, 1, 4, 2,
9, 4 ans 9
There are 8 decimal values which are even.
Your Task:  
You don't need to read input or print anything. Your task is to complete the function evenDecimalSubStr() which takes the string S, its size N as input parameters and returns the number of substrings that has even value in its decimal form.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ T ≤ 1000
1 ≤ N ≤ 105
*/

/*
 substring whose starting value is '0' always produce even decimal value. so we simply traverse a loop from left to right and count all substring whose starting value is zero.
*/

//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

// } Driver Code Ends
//User function Template for Java
class Solution{
    static long evenDecimalSubStr(int N, String S){
        // code here
        long res=0;
        
        for(int i=0; i<N; i++)
            if(S.charAt(i)=='0')
                         // increment result by (n-i)
                // because all substring which 
                // are generate by this character 
                // produce even decimal value.
                res+=(N-i);
        return res;
    }
}

//{ Driver Code Starts.
class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String s = read.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.evenDecimalSubStr(N, s));
        }
    }
}
// } Driver Code Ends
