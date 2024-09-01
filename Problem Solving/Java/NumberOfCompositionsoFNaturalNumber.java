/*
Given a natural number N, find the number of ways in which N can be expressed as a sum of natural numbers when order is taken into consideration. Two sequences that differ in the order of their terms define different compositions of their sum.
 

Example 1:

Input: N = 2
Output: 2
Explanation: All 2 compositions are 
{1 + 1} and {2}.
Example 2:

Input: N = 4
Output: 8
Explanation: All 8 compositions are:
{1 + 1 + 1 + 1}, {1 + 1 + 2}, {1 + 2 + 1},
{2 + 1 + 1}, {2 + 2}, {1 + 3}, {3 + 1}, {4}.
 

Your Task:
You don't need to read or print anything. Your task is to complete the function no_of_ways() which takes n as the input parameter and returns the total no. of ways modulo 109 + 7.
 

Expected Time Complexity: O(log(N))
Expected Space Complexity: O(1)

Constraints:
1 <= N <= 109


*/

/*
One way to see why the answer is 2^(n-1) directly is to write n as a sum of 1s: 
n = 1 + 1 + 1 +…+ 1 (n times).
There are (n-1) plus signs between all 1s. For every plus sign we can choose to split ( by putting a bracket) at the point or not split. Therefore answer is 2^(n-1).
For example, n = 4 
No Split 
4 = 1 + 1 + 1 + 1 [We write as single 4]
Different ways to split once 
4 = (1) + (1 + 1 + 1) [We write as 1 + 3] 
4 = (1 + 1) + (1 + 1) [We write as 2 + 2] 
4 = (1 + 1 + 1) + (1) [We write as 3 + 1]
Different ways to split twice 
4 = (1) + (1 + 1) + (1) [We write as 1 + 2 + 1] 
4 = (1 + 1) + (1) + (1) [We write as 2 + 1 + 1] 
4 = (1) + (1) + (1 + 1) [We write as 1 + 1 + 2]
Different ways to split three times 
4 = (1) + (1) + (1) + (1) [We write as 1 + 1 + 1 + 1]
Since there are (n-1) plus signs between the n 1s, there are 2^(n-1) ways of choosing where to split the sum, and hence 2^(n-1) possible sums .
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
            int n = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.no_of_ways(n);
            System.out.println(ans);
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int no_of_ways(int n)
    {
        // code here
                n--;
        long x = 1, p = 2, m = 1000000007;
        while (n > 0) {
            if ((n & 1) == 1) {
                x = (x * p) % m;
            }
            p = (p * p) % m;
            n /= 2;
        }
        return (int) x;
    }
}
