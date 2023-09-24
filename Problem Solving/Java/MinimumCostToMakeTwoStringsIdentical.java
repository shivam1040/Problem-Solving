/*
Given two strings X and Y, and two values costX and costY, the task is to find the minimum cost required to make the given two strings identical. You can delete characters from both the strings. The cost of deleting a character from string X is costX and from Y is costY. The cost of removing all characters from a string is the same.

Example 1:

Input: X = "abcd", Y = "acdb", costX = 10 
       costY = 20.
Output: 30
Explanation: For Making both strings 
identical we have to delete character 
'b' from both the string, hence cost 
will be = 10 + 20 = 30.
Example 2:

Input : X = "ef", Y = "gh", costX = 10
        costY = 20.
Output: 60
Explanation: For making both strings 
identical, we have to delete 2-2 
characters from both the strings, hence 
cost will be = 10 + 10 + 20 + 20 = 60.
Your Task:
You don't need to read or print anything. Your task is to complete the function findMinCost() which takes both strings and the costs as input parameters and returns the minimum cost.

Expected Time Complexity: O(|X|*|Y|)
Expected Space Complexity: O(|X|*|Y|)

Constraints:
1 ≤ |X|, |Y| ≤ 1000


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
                    String X = sc.next();
                    String Y = sc.next();
                    int costX = sc.nextInt();
                    int costY = sc.nextInt();
                    
                   
                    Solution ob = new Solution();
                    System.out.println(ob.findMinCost(X,Y,costX,costY));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
	public int findMinCost(String X, String Y, int costX, int costY)
	{
		// Your code goes here
		int aux[][]=new int[X.length()+1][Y.length()+1];
		
		//find longest common subsequence and then delete reamaining, find the cost
		for(int i=0; i<=X.length(); i++){
		    for(int j=0; j<=Y.length(); j++){
		        if(i==0 || j==0)
		            aux[i][j]=0;
		        else if(X.charAt(i-1)==Y.charAt(j-1))
		            aux[i][j]=aux[i-1][j-1]+1;
		        else
		            aux[i][j]=Math.max(aux[i-1][j], aux[i][j-1]);
		    }
		}
		
		return costX*(X.length()-aux[X.length()][Y.length()]) + costY*(Y.length()-aux[X.length()][Y.length()]);
	}
}

