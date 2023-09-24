/*
Given an array arr of size N, the task is to sort this array in a minimum number of steps where in one step you can remove any array element from its position and insert it in any other position.

Example 1:

Input:
N = 7
arr[] = {2, 3, 5, 1, 4, 7, 6}
Output: 3
Explanation: 
We can sort above array in 3 insertion 
steps as shown below,
1 before array value 2
4 before array value 5
6 before array value 7
Example 2:

Input:
N = 4
arr[] = {4, 6, 5, 1}
Output: 2
Explanation: 
We can sort above array in 2 insertion 
steps as shown below, 
1 before array value 4
6 after array value 5 
Your Task:  
You don't need to read input or print anything. Complete the function minInsertions() which takes N and array arr as input parameters and returns the integer value

Expected Time Complexity: O(N2)
Expected Auxiliary Space: O(N)

Constraints:
1 ≤ N ≤ 103
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
                    int n = sc.nextInt();
                    int Arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                        Arr[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minInsertions(Arr,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int minInsertions(int arr[], int N) 
	{ 
        //code here.
        int dp[]=new int[N];
        
        int max=-1;
        
        for(int i=0; i<N; i++){
            // this is being set to 1 'cause an elelement in itself is LIS'
            dp[i]=1;
            for(int j=0; j<i; j++){
                // here we find LCS
                if(arr[j]<=arr[i])
                    dp[i]=Math.max(dp[i], dp[j]+1);
            }
            max=Math.max(max, dp[i]);
        }
        // subtract max LIS by N, this gives us minimum insertion, since LIS will give us longest sequence which does not need to be moved
        return N-max;
        
	} 
}

