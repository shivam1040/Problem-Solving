/*
Your are given N pairs of alphabets and a string S of size M. Find the number of occurence of the alphabet pairs in S.

Example 1:

Input :
N = 3
Arr[] = {('A','G'),('d','i'),('P','o')}
M = 5
S = "APiod"
Output : 2
Explanation:
There are 3 pairs (A G), (d i) & (P o)
and a string APiod of length 5. Of the
3 pairs, only 2 of them (d i) & (P o)
appear in the string, so the answer is
2.

Example 2:

Input :
N = 1
Arr[] = {('r','e')}
M = 3
S= "ghe"
Output : 0

Your Task:
The input is already taken care of by the driver code. You only need to complete the function count_pairs() that takes an array of character arr denoting the N pairs of charater, string (S),  N, M, and return the number of pairs. The driver code takes care of the printing.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(M).

Constraints:
1<=N<=105
2<=M<=50
*/

//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
	public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0)
        { 
            int N=sc.nextInt();
    	    int M=sc.nextInt();
    	    char c[]=new char[2*N];
    	    for(int i=0;i<c.length;i++)
    	       c[i]=sc.next().charAt(0);
    	    String s=sc.next();
            
            Solution obj = new Solution();
            int res = obj.count_pairs(c, s, 2*N, M);
            System.out.println(res);
        }

	}
	
}

// } Driver Code Ends


//User function Template for Java



class Solution{
    
    public static int count_pairs(char arr[], String s, int n, int m) 
    { 
        // Complete the function
        int res=0;
        
        for(int i=0; i<n; i=i+2)
            if(s.contains(arr[i]+"") && s.contains(arr[i+1]+""))
                res++;
        return res;
    }
    
}

