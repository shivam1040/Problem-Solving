/*
Given a string str of length N, you have to find number of palindromic subsequence (need not necessarily be distinct) present in the string str.
Note: You have to return the answer module 109+7;
 

Example 1:

Input: 
Str = "abcd"
Output: 
4
Explanation:
palindromic subsequence are : "a" ,"b", "c" ,"d"
 

Example 2:

Input: 
Str = "aab"
Output: 
4
Explanation:
palindromic subsequence are :"a", "a", "b", "aa"
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function countPs() which takes a string str as input parameter and returns the number of palindromic subsequence.
 

Expected Time Complexity: O(N*N)
Expected Auxiliary Space: O(N*N)


Constraints:
1<=length of string str <=1000


*/

//{ Driver Code Starts
import java.util.*;
class GFG
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String str = sc.nextLine();
			//System.out.println(str.length());
			Solution ob  = new Solution();
			System.out.println(ob.countPS(str));
		t--;
		}
	}
}
// } Driver Code Ends


/*You are required to complete below method */

class Solution
{
    long countPS(String str)
    {
        // Your code here
        long[][] dp=new long[str.length()+1][str.length()+1];
        
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        return rec(str, dp, 0, str.length()-1);
    }
    
    private long rec(String str, long[][] dp, int i, int j){
        long mod=1000000007;
        //the character itsel is palindromic
        if(i==j)
            return 1;
        if(i>j)
            return 0;
        if(dp[i][j]!=-1)
            return dp[i][j];
        //if char match then move forward backward and take 1 for the curent match
        if(str.charAt(i)==str.charAt(j))
            dp[i][j]=(1+rec(str, dp, i+1, j)+rec(str, dp, i, j-1)%mod);
        else
        //if no match then same as above but no addititon for 1 since no match and remove an overlapping char in cases like xyyz so xy yz y is common in both anc can cause dupes in result
            dp[i][j]=((rec(str, dp, i+1, j)+rec(str, dp, i, j-1)-rec(str, dp, i+1, j-1))%mod+mod)%mod;
        return dp[i][j];
    }
}
