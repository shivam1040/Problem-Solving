/*
Given a sequence of moves for a robot. Check if the sequence is circular or not.

A sequence of moves is circular if the first and last positions of the robot are the same. A move can be one of the following :
    G - Go one unit
    L - Turn left
    R - Turn right

Example 1:

Input: path = "GLGLGLG"
Output: "Circular"
Explanation: If we start form 
(0,0) in a plane then we will 
back to (0,0) by the end of the 
sequence.
â€‹Example 2:

Input: path = "GGGGL"
Output: "Not Circular"
Explanation: We can't return to 
same place at the end of the path.
Your Task:  
You don't need to read input or print anything. Your task is to complete the function isCircular() which takes the string path as input and returns "Circular" if the path is circular else returns "Not Circular".

Expected Time Complexity: O(|S|)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ |S| ≤ 105
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
                    Solution obj = new Solution();
                    System.out.println(obj.isCircular(s));
                }
                
        }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String isCircular(String s)
    {
        //code here
        char curDir='N';
        int x=0, y=0;
        
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='G'){
                y+=curDir=='N' ? 1 : 0;
                y+=curDir=='S' ? -1 : 0;
                x+=curDir=='E' ? 1 : 0;
                x+=curDir=='W' ? -1 : 0;
            }
            else{
                char temp=s.charAt(i);
                
                if(curDir=='N'){
                    curDir=temp=='L' ? 'W' : 'E';
                }
                else if(curDir=='W'){
                    curDir=temp=='L' ? 'S' : 'N';
                }
                else if(curDir=='S'){
                    curDir=temp=='L' ? 'E' : 'W';
                }
                else{
                    curDir=temp=='L' ? 'N' : 'S';
                }
                }
            }
            
             if(x==0 && y==0)
            return "Circular";
        
        return "Not Circular";
        }
    }
