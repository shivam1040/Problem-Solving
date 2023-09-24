/*
Given an array of N integers and Q queries, each query having a range from index L to R. Find the maximum prefix-sum for the range L to R.
Note: Assume 0 based indexing.

Example 1:

Input: 
a[ ] = {-1, 2, 3, -5} 
Q = 2
L1 = 0, R1 = 3
L2 = 1, R2 = 3
Output:
4 5
Explanation:
The range (0, 3) in the 1st query is {-1, 2, 3, -5}, hence, 
the max prefix-sum will be -1 + 2 + 3 = 4. The range (1, 3) 
in the 2nd query is {2, 3, -5}, hence, the max prefix-sum 
will be 2 + 3 = 5.
Your Task:  
You don't need to read input or print anything. Your task is to complete the function maxPrefixes() which takes the array A[], its size N, array L[] and R[] and their size Q as input parameters and returns a vector storing the required answer for every query.

Expected Time Complexity: O(N*Q)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ N ≤ 104

-104 ≤ A[i]≤ 104
1 ≤ Q ≤ 104
0 ≤ L[i] ≤ R[i] < N
*/

//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


class pair  {  
    long first, second;  
    public pair(long first, long second)  
    {  
        this.first = first;  
        this.second = second;  
    }  
}

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            StringTokenizer stt = new StringTokenizer(br.readLine());
            
            long n = Long.parseLong(stt.nextToken());
            long q = Long.parseLong(stt.nextToken());
            
            long a[] = new long[(int)(n)];
            long l[] = new long[(int)(q)];
            long r[] = new long[(int)(q)];
            
            String inputLine1[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine1[i]);
            }
            
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < 2*q; i+=2) {
                l[(i/2)] = Long.parseLong(inputLine[i]);
                r[(i/2)] = Long.parseLong(inputLine[i+1]);
            }
            
            
            Solution obj = new Solution();
            long ans[] = obj.maxPrefixes(a, l, r, n, q);
            
            StringBuilder output = new StringBuilder();
            for(int i=0;i<q;i++)
            output.append(ans[i]+" ");
            System.out.println(output);
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java


class Solution {
    long[] maxPrefixes(long a[], long L[], long R[], long N, long Q) 
    {
        long[] res=new long[(int)Q];
        
        for(int i=0; i<Q; i++){
            long l=L[i], r=R[i], temp=0, max=Long.MIN_VALUE;
            
            while(l<=r){
                temp+=a[(int)l++];
                max=Math.max(max, temp);
            }
            
            res[i]=max;
        }
        return res;
    }
}
