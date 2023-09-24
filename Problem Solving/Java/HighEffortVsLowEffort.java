/*
You are given n days and for each day (di) you can select one of the following options:

perform no task 
perform a high effort task (hi) only if its the first day or if you chose no-task on the previous day
perform a low effort task (li)
Write a program to find the maximum amount of tasks you can perform within these n days. 


Example 1:

Input:
n = 3
hi[] = {2,8,1}
li[] = {1,2,1}
Output: 9
Explanation:
Options on 1st day: hi[0]=2, li[0]=1 or no-task
Select no-task.
Options on 2nd day: hi[1]=8, li[2]=1 or no-task
Select high-effort task as no-task was selected 
the previous day.  
Options on 3rd day: hi[2]=1, li[2]=1 or no-task
Select low-effort task as selecting high-effort 
task is only possible if you chose no-task on 
previous day.

Example 2:

Input:
n = 5
hi[] = {3,6,8,7,6}
li[] = {1,5,4,5,3}
Output: 20
Explanation: Perform high-effort task on first 
day and low-effort task on all remaining days.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function maxAmt() which accepts an integer n and two arrays li[] and hi[] as input parameter and returns the maximum amount of tasks you can perform within these n days.


Expected Time Complexity: O(n)
Expected Auxiliary Space: O(n)


Constraints:
1 <= n <= 106
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
                    int hi[] = new int[n];
                    int li[] = new int[n];
                    for(int i = 0;i<n;i++)
                        hi[i] = sc.nextInt();
                    for(int i = 0;i<n;i++)
                        li[i] = sc.nextInt();    
                    Solution ob = new Solution();
                    System.out.println(ob.maxAmt(n,hi,li));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int maxAmt(int n , int hi[] , int li[]) 
    { 
        //code here.
        int dp[]=new int[n+1];
        dp[0]=0;
        //starting with high effor on day 1
        dp[1]=hi[0];
        
        for(int i=2; i<=n; i++){
            //now in this the idea is find max b/w low effort current+previous combined task value and similar for high effort, we are doing i-2 for high effort beacause we cannot do high effort task if previous day also has effort task or can be done only if previous day has no task, so that is why skipping previous day ensure we don't pick any task of the previous day
            dp[i]=Math.max(hi[i-1]+dp[i-2], li[i-1]+dp[i-1]);
        }
        return dp[n];
        
    } 
}
