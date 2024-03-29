/*
A guy has to reach his home and does not want to be late. He takes train to reach home. He has a mental illness, so he always switches train at every station.
For eg: If he starts with train A then at station 2 he will switch his train to train B and so on. Similarly, if he starts with train B then he will switch to train A at station 2 and so on. Please help him to find the minimum total time he would take to reach his home.

 

Example 1:

Input:
N = 3
A[] = {2, 1, 2}
B[] = {3, 2, 1}
Output:
5
Explanation:
If he chose train A initially, then time to
reach home will be : 2 + 2 + 2 = 6 
If he Chose train B initially, then time to
reach home will be : 3 + 1 + 1 = 5
5 is minimum hence the answer.
 

Your Task:  
You don't need to read input or print anything. Your task is to complete the function minTime() which takes the array A[], B[] and its size N as inputs and returns the minimum total time in seconds to reach home.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

 

Constraints:
1 ≤ N ≤ 106
1 ≤ Ai, Bi ≤ 106
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
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            long a[] = new long[(int)(n)];
            long b[] = new long[(int)(n)];
            
            
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            String inputLine1[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                b[i] = Long.parseLong(inputLine1[i]);
            }
            
            
            Solution obj = new Solution();
            System.out.println(obj.minTime(a, b, n));
        }
	}
}


// } Driver Code Ends


//User function Template for Java

class Solution {

    public long minTime(long a[], long b[], long n) {
        // Your code goes here 
        long A=0, B=0;
        for(int i=0; i<n; i+=2){
            if(i+1>=n){
                A+=a[i];
                B+=b[i];
                break;
            }
            A+=a[i]+b[i+1];
            B+=b[i]+a[i+1];
        }
        
        return A>B ? B : A;
        
        
    }
}
