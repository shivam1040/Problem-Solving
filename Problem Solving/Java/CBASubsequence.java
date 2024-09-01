/*
Given a string, rearrange it in such a way that it has no subsequence as cba. If there are multiple answers return the lexicographically smallest one.

Example 1:

Input:
N=6
S="aaaaab"

Output:
aaaaab

Explanation: "aaaaab" has no subsequence as cba and is 
lexicographically the smallest one.
Example 2:

Input: 
N=3 
S="cba"

Output: 
abc.

Explanation: "abc" has no subsequence as cba and is
lexicographically the smallest one.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function cbaSubsequence() which takes the string S, its size N as input parameters and returns the rearranged string.

 

Expected Time Complexity: O(NLogN)
Expected Auxiliary Space: O(1)

 

Constraints:
1<=N<=105
S contains only lowercase English alphabets.
*/

//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG{
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			int N = Integer.parseInt(br.readLine());
			String S = br.readLine();
			Solution obj = new Solution();
			System.out.println(obj.cbaSubsequence(S, N));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution{
	String cbaSubsequence(String S, int N) {
		//Write your code here
// 		if(!S.contains("cba"))
// 		    return S;
		char ch[]=S.toCharArray();
		
		Arrays.sort(ch);
		return new String(ch);
	}
}

