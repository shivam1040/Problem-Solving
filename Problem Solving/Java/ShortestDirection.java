/*
A person wants to go from origin to a particular location, he can move in only 4 directions(i.e East, West, North, South) but his friend gave him a long route, help a person to find minimum Moves so that he can reach to the destination.

Note: You need to print the lexicographically sorted string. Assume the string will have only ‘E’ ‘N’ ‘S’ ‘W’ characters.

Example 1:

Input:
S = "SSSNEEEW"
Output: EESS
Explanation: Following the path SSSNEEEW
and EESS gets you at the same final point.
There's no shorter path possible.
â€‹Example 2:

Input: 
S = "NESNWES"
Output: E
Explanation: Following the path NESNWES
and E gets you at the same final point.
There's no shorter path possible.

Your Task:
You don't need to read input or print anything. Your task is to complete the function shortestPath() which takes the string S as input and returns the resultant string denoting the shortest path in lexicographic order.


Expected Time Complexity: O(|S|).
Expected Auxiliary Space: O(|S|) for output.


Constraints:
1<=|S|<=105


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
            
            Solution ob = new Solution();
            
            System.out.println(ob.shortestPath(s));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    String shortestPath (String S)
    {
        // your code here
        int x=0, y=0;
        //finding shortes magnitude of x and y by removing extra steps
        for(char c: S.toCharArray()){
            if(c=='S'){
                y--;
            }
            else if(c=='N')
                y++;
            else if(c=='E')
                x++;
            else
                x--;
        }
        
        String res="";
        
        //traversing accroding to maginituredes and add the direction
        while(x!=0 || y!=0){
            if(x>0){
                res+="E";
                x--;
            }
            else if(y>0){
                res+="N";
                y--;
            }
            else if(y<0){
                res+="S";
                y++;
            }
            else if(x<0){
                res+="W";
                x++;
            }
        }
        
        return res;
    }
}
