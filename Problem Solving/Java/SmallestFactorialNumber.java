/*
Given a number n. The task is to find the smallest number whose factorial contains at least n trailing zeroes.

Example 1:

Input:
n = 1
Output: 5
Explanation : 5! = 120 which has at
least 1 trailing 0.
Example 2:

Input:
n = 6
Output: 25
Explanation : 25! has at least
6 trailing 0.

User Task:
Complete the function findNum() which takes an integer N as input parameters, and returns the answer.

Expected Time Complexity: O(log2 N * log5 N).
Expected Auxiliary Space: O(1).

Constraints:
1 <= n <= 104
*/

// { Driver Code Starts
//Initial Template for Java

import java.util.*;

public class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        
        while (t-- > 0)
        {
            int n = sc.nextInt();
            
            System.out.println(new Solution().findNum(n));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    int findNum(int n)
    {
        if(n==1)
            return 5;
            
        int low=0, high=5*n;
        
        while(low<high){ //here we do a binary search to get the lowest number having required number of zeroes, as we know If factorial of ‘X’ contains ‘L’ number of trailing zeroes, then number of trailing zeroes in factorial of  ‘X+1’ will be greater equal to ‘L’. 
            int mid=(low+high)>>1; 
            if(check(mid, n)){
                high=mid;
            }
            else
                low=mid+1;
        }
        return low;
    }
    
    private boolean check(int p, int n)
    {
        int count = 0, f = 5;
        while (f <= p)
        {
            count += p / f; //the intuition here is to check number of multiple of 5's present in a number, that gives guarantee that at lest these many zeroes would be preswnt in factorial result
            f = f * 5;
        }
        return (count >= n);
    }
}
