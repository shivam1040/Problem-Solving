/*
Given an array A[] of size N, find the longest subsequence such that difference between adjacent elements is one.


Example 1:

Input: N = 7
A[] = {10, 9, 4, 5, 4, 8, 6}
Output: 3
Explaination: The three possible subsequences 
{10, 9, 8} , {4, 5, 4} and {4, 5, 6}.

Example 2:

Input: N = 5
A[] = {1, 2, 3, 4, 5}
Output: 5
Explaination: All the elements can be 
included in the subsequence.

Your Task:
You do not need to read input. Your task is to complete the function longestSubseq() which takes N and A[] as input parameters and returns the length of the longest such subsequence.


Expected Time Complexity: O(N2)
Expected Auxiliary Space: O(N)


Constraints:
1 ≤ N ≤ 103
1 ≤ A[i] ≤ 103
*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine().trim());
            String input_line[] = read.readLine().trim().split("\\s+");
            int A[]= new int[N];
            for(int i = 0; i < N; i++)
                A[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.longestSubsequence(N, A));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int longestSubsequence(int N, int A[])
    {
        // code here
        Map<Integer, Integer> aux=new HashMap<Integer, Integer>();
        int res=Integer.MIN_VALUE;
        
        for(int i: A){ //in this we use a map to check if any previous stored value exists in map which is +1 or -1 of it, this way we avoid iterating through all theinputs of array 
            int length=0;
            if(aux.containsKey(i+1))
                length=aux.get(i+1);
            if(aux.containsKey(i-1) && aux.get(i-1)>length) //in this we put a condition to update length only when greater than previous one to ensure only longest length is taken into consideration
                length=aux.get(i-1);
            aux.put(i, length+1); //an extra one is added to ensure the input for which we are running the loop also gets considered
            res=Math.max(res, aux.get(i));
        }
        return res;
    }
}
