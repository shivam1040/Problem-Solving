/*
Consider you have an infinitely long binary tree having the pattern as below
               1

            /     \
           2      3  

         /  \     /   \
        4  5    6  7
    .  .  .  .   .  .  .  . 
Given two nodes with values x and y, the task is to find the length of the shortest path between the two nodes.

Example 1:

Input:
X = 1
Y = 3
Output:
1
Explanation:
3 is the child of 1 so, 
distance between them is 1.
Example 2:

Input:
X = 2
Y = 2
Output:
0
Explanation:
There is no node between 2 and 2.
Your Task:
You don't need to read input or print anything. Your task is to complete the function distance() which take integers X and Y as input parameters and returns the distance between X and Y in the infinitely long tree.
 

Expected Time Complexity: O(log (y - x))
Expected Auxiliary Space: O(1)


Constraints:
1<=X,Y<=107
*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

// } Driver Code Ends
//User function Template for Java

class Solution{
    static int distance(int x,int y){
        
        // code here
        if(x==y)
            return 0;
        
        int d=0;
        // if both nodes are not equal then move to the parent of the greater one.
        // parent of the node will always be given by node/2.
        // keep moving up until both arrive at a common parent.
        // with every move increase the distance by one.
        
        //An efficient approach is to use the property of 2*x and 2*x+1 given. Keep dividing the larger of the two nodes by 2. If the larger becomes the smaller one, then divide the other one. At a stage, both the values will be the same, keep a count on the number of divisions done which will be the answer. 
        
        while(x!=y){
            if(x>y){
                x/=2;
            }
            else
                y/=2;
            d+=1;
        }
        return d;
        
    }
    
}

//{ Driver Code Starts.
class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S[] = read.readLine().split(" ");
            int X = Integer.parseInt(S[0]);
            int Y = Integer.parseInt(S[1]);
            
            Solution ob = new Solution();
            System.out.println(ob.distance(X,Y));
        }
    }
}
// } Driver Code Ends
