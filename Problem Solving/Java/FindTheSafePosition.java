/*
There was a group of Jewish soldiers who were surrounded by Roman Army in a circular fence. They decided not to get captured by the brutal Roman Army. So, they made a plan.
They planned to kill each other. The soldier would kill the fellow soldier next to him on left. They would do so till only one soldier is left and in the last the remained soldier would kill themselves. But there was a problem, soldier A didn’t want to die he want to stay alive so he wanted to stand a position where he could stand till last. After all his fellow soldiers died he would simple surrender himself rather then killing himself. So, given N i,e number of Jewish soldiers, find the safe_position of soldier A.
 

Example 1:

Input: N = 10
Output: 5
Explanation: 1 kills 2 : 3 kills 4 : 
5 kills 6 : 7 kills 8 : 9 kills 10
Now 1 kills 3 : 5 kills 7 : 9 kills 1 
Now 5 kills 9 
Example 2:

Input: N = 3
Output: 3
Explanation: 1 kills 2 : 3 kills 1
Safe_Position  : 3
 

Your Task:
You don't need to read or print anything. Your task is to complete the function find_pos() which takes N as input parameter and returns the safe position for soldier A.
 

Expected Time Complexity: O(log(N))
Expected Space Complexity: O(1)
 

Constraints:
1 <= N <= 100000
*/

/*
In this code, we first find the highest power of 2 that is less than or equal to the number of soldiers n. This is done to find the number of soldiers who will be eliminated before the remaining soldiers form a new circle. The safe position for soldier A is then calculated based on the number of soldiers who are eliminated before him.
*/

//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int N = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.find_pos(N);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int find_pos(int N)
    {
        // Code here
        int p=1;
        
        while(p<=N)
            p*=2;
        return (2*N)-p+1;
    }
}
