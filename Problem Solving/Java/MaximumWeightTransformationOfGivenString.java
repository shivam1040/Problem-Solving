/*
Given string s consisting of only A’s and B’s. You can transform the given string to another string by toggling any character. Thus many transformations of the given string are possible. The task is to find the Weight of the maximum weight transformation.

The weight of a string is calculated using the below formula.

Weight of string = Weight of total pairs + weight of single characters - Total number of toggles.
 
Note:
1. Two consecutive characters are considered a pair only if they are different.
2. Weight of a single pair (both characters are different) = 4
3. Weight of a single character = 1
 
Example 1:

Input: s = "AA"
Output: 3
Explanation: Transformations of given 
string are "AA", "AB", "BA" and "BB". 
Maximum weight transformation is "AB" 
or "BA".  And weight is "One Pair - 
One Toggle" = 4-1 = 3.
Example 2:

Input: s = "ABB"
Output: 5
Explanation: Transformations are "ABB", 
"ABA", "AAB", "AAA", "BBB", "BBA", "BAB" 
and "BAA" Maximum weight is of original 
string 4 + 1 (One Pair + 1 character)

Your Task:  
You don't need to read input or print anything. Complete the function getMaxWeight() which takes string s as input and return an integer

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

Constraints:
1 ≤ N ≤ 105
*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Solution ob = new Solution();
                    System.out.println(ob.getMaxWeight(s));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
	public int getMaxWeight(String s)  
	{  
	    //code here.
	    int n=s.length();
	    
	    if(n==1)
	        return 1;
	   int dp[]=new int[n];
	   dp[0]=1;
	   
	   if(s.charAt(0)!=s.charAt(1))
	    dp[1]=4;
	   else
	    dp[1]=3;
	   if(n==2)
	    return dp[1];
	   for(int i=2; i<n; i++){
	       dp[i]=1+dp[i-1];
	       
	       if(s.charAt(i)!=s.charAt(i-1))
	        dp[i]=Math.max(dp[i], dp[i-2]+4);
	       else
	       // if elements are similar so for 
            // making a pair we toggle any of 
            // them. Since toggle cost is
            // 1 so overall weight gain becomes 3
	        dp[i]=Math.max(dp[i], dp[i-2]+3);
	   }
	   return dp[n-1];
	}  
}
