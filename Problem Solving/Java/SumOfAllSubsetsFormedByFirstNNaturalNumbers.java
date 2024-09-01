/*
Given a number N, the task is to find the sum of all the elements from all possible subsets of a set formed by first N natural numbers.

Example 1:

Input:
N = 2
Output:
6
Explanation:
Possible subsets are {{1}, {2}, {1, 2}}.
Sum of elements in the subsets is 
1 + 2 + 1 + 2 = 6.
Example 2:

Input:
N = 3
Output:
24
Explanation:
Possible subsets are 
{{1},{2},{3},{1,2},{2,3},{1,3},{1,2,3}}.
Sum of elements in the subsets is 
1+2+3+1+2+2+3+1+3+1+2+3 = 24
Your Task:  
You don't need to read input or print anything. Your task is to complete the function sumOfSubsets() which takes an integer N as an input parameter and return the sum of all the elements from all possible subsets of a set formed by first N natural numbers.

Expected Time Complexity: O(logN)
Expected Auxiliary Space: O(1)

Constraints:
1 <= N <= 50


*/

//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int N=sc.nextInt();
			
            Solution ob = new Solution();
            long ans  = ob.sumOfSubsets(N);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    static long sumOfSubsets(int N){
        // code here
        return N*(N+1)/2*(long)Math.pow(2, N-1);
    }
}
