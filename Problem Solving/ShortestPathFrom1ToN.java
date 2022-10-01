/*
Consider a directed graph whose vertices are numbered from 1 to n. There is an edge from a vertex i to a vertex j iff either j = i + 1 or j = 3 * i. The task is to find the minimum number of edges in a path in G from vertex 1 to vertex n.


Example 1:

Input:
N = 9
Output:
2
Explanation:
9 -> 3 -> 1, so
number of steps are 2. 
â€‹Example 2:

Input:
N = 4
Output:
2
Explanation:
4 -> 3 -> 1, so
number of steps are 2.

Your Task:  
You don't need to read input or print anything. Your task is to complete the function minimumStep() which takes the N as inputs and returns the answer.


Expected Time Complexity: O(logN)
Expected Auxiliary Space: O(1)


Constraints:
1 ≤ N ≤ 105
*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int n = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.minStep(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int minStep(int n){
        //complete the function here
        int i=1, count=0;
        
        //backtracking from n to 1, What if we begin from end, and we reduce by 1 if the value is not multiple of 3, else we divide by 3.
        while(n>0){
           if(n%3==0){
            n/=3;
            count++;
           }
           else{
               n-=1;
               count++;
           }
        }
        //-1 to account for last number which also gets accounted for
        return count-1;
    }
}

