/*
A frog jumps either 1, 2, or 3 steps to go to the top. In how many ways can it reach the top. As the answer will be large find the answer modulo 1000000007.

Example 1:

Input:
N = 1
Output: 1
Example 2:

Input:
N = 4
Output: 7
Explanation:Below are the 7 ways to reach
4
1 step + 1 step + 1 step + 1 step
1 step + 2 step + 1 step
2 step + 1 step + 1 step
1 step + 1 step + 2 step
2 step + 2 step
3 step + 1 step
1 step + 3 step
Your Task:
Your task is to complete the function countWays() which takes 1 argument(N) and returns the answer%(10^9 + 7).

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Constraints:
1 ≤ N ≤ 105
*/

/*
Instead of using array of size n+1 we can use array of size 3 because for calculating no of ways for a particular step we need only last     3 steps no of ways.




    Algorithm:


Create an array of size 3 and initialize the values for step 0,1,2 as 1,1,2 (Base cases).
Run a loop from 3 to n(dist).
For each index compute the value as ways[i%3] = ways[(i-1)%3] + ways[(i-2)%3] + ways[(i-3)%3] and store its value at i%3 index of array ways. If we are computing value for index 3 then the computed value will go at index 0 because for larger indices(4 ,5,6.....) we don't need the value of index 0.
Return the value of ways[n%3].
*/

// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG
{
    public static void main(String args[])
    {
        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);
        
        //taking number of testcases
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            //taking number of steps in stair
            int n = sc.nextInt();
            
            //calling method countWays() of class Hops
            System.out.println(new Solution().countWays(n));
            
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to count the number of ways in which frog can reach the top.
    static long countWays(int n)
    {
       long ways[]={1, 1, 2};
       for(int i=3; i<=n; i++)
        ways[i%3]=(ways[(i-1)%3]+ways[(i-2)%3]+ways[(i-3)%3])%1_000_000_007;
       return ways[n%3];
        
    }
    
    
}

