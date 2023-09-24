/*
Given two arrays A[] and B[] consisting of N and M elements respectively. The task is to find minimum number of elements to remove from each array such that no common element exist in both the arrays.
 

Example 1:

Input :
A[] = { 2, 3, 4, 5, 8 }
B[] = { 1, 2, 3, 4}
Output :
3
Explanation:
We need to remove 2, 3 and 4 from any 
array.
 

Example 2:

Input :
A[] = { 4, 2, 4, 4}
B[] = { 4, 3 }
Output :
1
Explanation:
We need to remove 4 from B[]
 

Example 3:

Input:
A[] = { 1, 2, 3, 4 }
B[] = { 5, 6, 7 }
Output:
0
Explanation:
There is no common element in both.
 

Your Task:  
You don't need to read input or print anything. Your task is to complete the function minRemove() which takes the array A[], B[] and its size N, M as inputs and returns the minimum number of elements to be deleted.

 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

 

Constraints:
1<=N,M<=105
1<=A[i],B[i]<=105
*/

//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


class GFG {
	public static void main(String[] args) throws IOException
	{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            StringTokenizer stt = new StringTokenizer(br.readLine());
            
            long n = Long.parseLong(stt.nextToken());
            long m = Long.parseLong(stt.nextToken());
            
            long a[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            
            long b[] = new long[(int)(m)];
            String inputLine1[] = br.readLine().trim().split(" ");
            for (int i = 0; i < m; i++) {
                b[i] = Long.parseLong(inputLine1[i]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.minRemove(a, b, n, m));
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java


class Solution {
    
    public long minRemove( long a[], long b[], long n, long m)
    {
        Map<Long, Integer> aux=new HashMap<>();
        Map<Long, Integer> aux1=new HashMap<>();
        long res=0;
        
        for(long i:a)
            aux.put(i, aux.getOrDefault(i, 0)+1);
        for(long i:b)
            aux1.put(i, aux1.getOrDefault(i, 0)+1);
        for(Map.Entry<Long, Integer> i:aux.entrySet())
            if(aux1.containsKey(i.getKey()))
                res+=Math.min(aux.get(i.getKey()), aux1.get(i.getKey()));
        return res;
    }
}
