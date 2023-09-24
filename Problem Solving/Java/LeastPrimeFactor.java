/*
Given a number N, find least prime factors for all numbers from 1 to N.  The least prime factor of an integer N is the smallest prime number that divides it.
Note : The least prime factor of all even numbers is 2. A prime number is its own least prime factor (as well as its own greatest prime factor).1 needs to be printed for 1.
Note : If you are using vector then just push back a 0 at the begining as such we are following 1 based indexing in this problem.

Example 1:

Input: N = 6
Output: [1, 2, 3, 2, 5, 2] 
Explanation: least prime factor of 1 = 1,
least prime factor of 2 = 2,
least prime factor of 3 = 3,
least prime factor of 4 = 2,
least prime factor of 5 = 5,
least prime factor of 6 = 2.
So answer is[1, 2, 3, 2, 5, 2]. 

Example 2:

Input: N = 4
Output: [1, 2, 3, 2]
Explanation: least prime factor of 1 = 1,
least prime factor of 2 = 2,
least prime factor of 3 = 3,
least prime factor of 4 = 2.
So answer is[1, 2, 3, 2]. 

Your Task:  
You dont need to read input or print anything. Complete the function leastPrimeFactor() which takes N as input parameter and returns a list of integers containing all the least prime factor of each numbers from 1 to N.

Expected Time Complexity: O(NlogN)
Expected Auxiliary Space: O(N)

Constraints:
2<= n <=103
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
            int[] ans = ob.leastPrimeFactor(n);
            for(int i = 1; i <=n; i++)
            {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution
{
    public int[] leastPrimeFactor(int n)
    {
        // code here
        int a[]=new int[n+1];
        a[1]=1;
        
        for(int i=2; i<=n; i++){
            for(int j=2; j<=i; j++){
                if(i%j==0){
                    a[i]=j;
                    break;
                }
            }
        }
        
        return a;
    }
}
