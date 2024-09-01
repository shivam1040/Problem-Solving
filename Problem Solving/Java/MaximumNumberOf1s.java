/*
Given binary string s consisting of 0s and 1s only. You are allowed to do exactly one move that is you have to choose two indices i and j (1 ≤ i ≤ j ≤ |str| where |str| is string length) and toggle all the characters at position k where i ≤ k ≤ j. Toggling means changing 0 to 1 and 1 to 0. The task is to count the maximum possible number of 1's after exactly one move.

Example 1:

Input: s = "1010"
Output: 3
Explanation: You can make move on [2, 2]
or [2, 4]
Example 2:

Input: s = "0000"
Output: 4
Explanation: Make move on [1, 4]

Your Task:  
You don't need to read input or print anything. Complete the function maxOnes() which takes s as an input parameter and returns the maximum number of 1's count.

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
                    System.out.println(ob.maxOnes(s));
                }
        }
}    
// } Driver Code Ends



class Solution
{
	public int maxOnes(String s)
	{
		// Your code goes here
		//basically we have to run kadane's algo to find starting and ending index of max subarray sum
		char aux[]=s.toCharArray();
		int count1=0, max=Integer.MIN_VALUE, temp=0;
		//flipping 1,0 a/q to get ideal state
		for(int i=0; i<aux.length; i++)
		    if(aux[i]=='1'){
		        aux[i]='0';
		        
		        count1++;
		    }
		    else
		        aux[i]='1';
	    for(int i=0; i<aux.length; i++){
	        if(aux[i]=='1')
	            temp++;
	        else
	            temp--;
	            
	        max=Math.max(max, temp);
	        
	        if(temp<0)
	            temp=0;
	    }
	    return count1+max;
	}
}
