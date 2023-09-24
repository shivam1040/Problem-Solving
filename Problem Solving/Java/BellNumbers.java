/*
Given a set of n elements, find number of ways of partitioning it.

 

Example 1:

Input:
N = 2
Output: 2
Explanation:
Let the set be 
{1, 2}:
{ {1}, {2} } { {1, 2} }
 

Example 2:

Input:
N = 3
Output: 5

Your Task:  
You don't need to read input or print anything. Your task is to complete the function bellNumber() which takes the integer N as input parameters and returns the number of ways of partitioning n elements. Since the value can be quite large print the value modulo 109+7.

Expected Time Complexity: O(N^2)
Expected Auxiliary Space: O(N^2)

 

Constraints:

1 ≤ N ≤ 1000
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
            String input_line[] = read.readLine().trim().split("\\s+");
            int  N = Integer.parseInt(input_line[0]);
            
            Solution obj = new Solution();
            int ans = obj.bellNumber(N);
            System.out.println(ans);
        }
    }
}


// } Driver Code Ends


//User function Template for Java


class Solution{
    //finding bell numbers using bell triangle method
    int bellNumber(int n){
        // Code Here
        int mod =1000000007;
        
        int bell[][]=new int[n][n];
        bell[0][0]=1;
        
        for(int i=1; i<n; i++){
            bell[i][0]=bell[i-1][i-1];
            for(int j=1; j<=i; j++){
                bell[i][j] = bell[i-1][j-1]%mod + bell[i][j-1]%mod;
            }
        }
        return bell[n-1][n-1]%mod;
    }
    
}
