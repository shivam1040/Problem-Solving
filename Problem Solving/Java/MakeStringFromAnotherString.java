/*
Given two strings A and B, find if the first string can be made from second by deleting some characters from second and rearranging the remaining characters.

Example 1:

Input:
A = "GeeksforGeeks" 
B = "rteksfoGrdsskGeggehes"
Output: 1
Explanation: Keeping the bold characters and
discarding others: "rteksfoGrdsskGeggehes".
â€‹Example 2:

Input: 
A = "Hello" 
B = "Geek"
Output: 0
Explanation: We can't make A from B after
any deletions.
Your Task:
You don't need to read input or print anything. Your task is to complete the function isPoss() which takes the string A and string B as input parameters and returns true if A can be made from B after some deletions and rearranging the remaining characters. Else, returns false.

Expected Time Complexity: O(|A| + |B|).
Expected Auxiliary Space: O(1).

Constraints:
1 ≤ |A|, |B| ≤ 105


*/

//{ Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args)throws IOException{
		
		//taking input using BufferedReader class
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//taking total count of testcases
		int t = Integer.parseInt(br.readLine());
		while(t-->0)
		{
		    //Reading the two Strings
		    String A = br.readLine();
		    String B = br.readLine();
		    
		    //Creating an object of class Rotate
		    Solution obj = new Solution();
		    
		    //calling areRotations method 
		    //of class Rotate and printing
		    //"1" if it returns true
		    //else "0"
		    if(obj.isPass(A,B))
		    {
		        System.out.println("1");
		    }
		    else
		    {
		        System.out.println("0");
		    }
		}
	}
}
// } Driver Code Ends


//User function Template for Java


class Solution{
    public static boolean isPass(String A, String B )
    {
        // Your code here
        while(true){
            if(A.isEmpty())
                return true;
            if(B.contains(A.charAt(0)+"")){
                B=B.replaceFirst(A.charAt(0)+"", "");
                A=A.replaceFirst(A.charAt(0)+"", "");
            }
            else
                return false;
        }
    }
    
}
