/*
Given an array of numbers form 0 to 9 of size N. Your task is to rearrange elements of the array such that after combining all the elements of the array number formed is maximum.

 

Example 1:

Input:
N = 5
A[] = {9, 0, 1, 3, 0}
Output:
93100
Explanation:
Largest number is 93100 which
can be formed from array digits.
 

Example 2:

Input:
N = 3
A[] = {1, 2, 3}
Output:
321
 

Your Task:  
You don't need to read input or print anything. Your task is to complete the function MaxNumber() which takes the array A[] and its size N as inputs and returns a single line a string denoting the largest number that can be achieved by rearranging the elements of the array.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)


Constraints:
1 <= N <= 107
0 <= Ai <= 9
*/

//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            long n = Long.parseLong(br.readLine().trim());
            long a[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.MaxNumber(a, n));
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    
    public String MaxNumber(long arr[], long n)
    {
        //code here.
        StringBuilder res = new StringBuilder();
        int hash[]=new int[10];
        
        for(int i=0; i<n; i++)
            hash[(int)arr[i]]++;
        
        for(int i=9; i>=0; i--)
            for(int j=0; j<hash[i]; j++)
                res.append(i);
        return res.toString();
    }
}
