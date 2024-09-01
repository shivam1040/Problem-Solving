/*
Ishaan has bought a new gun. He is practicing his shooting, but he has to reload his gun again and again.
You are given his shooting a bullet and reloading activity in the form of a string s.
String s consists of 2 type of distinct characters: 'S' stands for shooting one bullet whereas 'R' stands for reloading the gun.
You are also given an integer n, which is the bullet capacity of the gun. Each time Ishaan reloads the gun, it is filled up to n bullets.
Given the string s and integer n, find out whether the activities are valid or not.
Assume that the gun is loaded upto its full capacity in the beginning of each test case.

Example 1:

Input:
s = "SSSRSRSS", n = 3
Output: 1
Explanation: He has 3 bullets at the start,
fires 3, reloades 3 bullets again, fires 1,
reloades 3 and then fires 2.
â€‹Example 2:

Input: 
s = "SSSSR", n = 3
Output: 0
Explanation: He has 3 bullets at the start
and tries to fire 4 without reloading. 
Hence, not a valid activity.

Your Task:
You don't need to read input or print anything. Your task is to complete the function isValid() which takes the string s and the integer n as inputs and returns true if the string denotes a valid activity. Else, it returns false.


Expected Time Complexity: O(|s|).
Expected Auxiliary Space: O(1).


Constraints:
1<=|s|<=105
1<=n<=105
*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0)
        {
            String s = in.readLine();
            int n = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            
            System.out.println(ob.isValid (s, n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    int isValid (String s, int n)
    {
        // your code here
        int temp=0;
        
        for(int i=0; i<s.length(); i++)
            if(s.charAt(i)=='S')
                temp++;
            else if(temp>n)
                return 0;
            else if(s.charAt(i)=='R')
                temp=0;
        return temp>n ? 0 : 1;
    }
}


