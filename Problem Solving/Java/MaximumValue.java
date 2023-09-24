/*
Given an array arr[] of size N. Find the maximum value of arr[j] – arr[i] + arr[l] – arr[k], such that i < j < k < l.

Example 1:

Input
N = 3
Arr[]  = {1, 2, 3}
Output:-1
Explanation: 
N<4 so no such i,j,k,l is possible.
 

Example 2:

Input:
N = 5
Arr[] = {4, 8, 9, 2, 20}
Output: 23
Explanation:
Here i = 0, j = 2, k = 3, l = 4 so
arr[j] – arr[i] + arr[l] – arr[k] 
= 9 – 4 + 20 – 2 = 23

Your Task:  
You don't need to read input or print anything. Your task is to complete the function findMaxValue() which takes the array arr[] and its size N as input parameters and returns the maximum value of arr[j] – arr[i] + arr[l] – arr[k].

 

Expected Time Complexity : O(N)
Expected Auxiliary Space : O(N)

 

Constraints:
1 ≤ N ≤ 105
1 ≤ A[i] ≤ 105
*/

/*
Let us say there are four DP tables as – table1[], table2[], table3[], table4[]

Then to find the maximum value of arr[j] – arr[i] + arr[l] – arr[k], such that i < j < k < l

table1[] will store the maximum value of arr[j]
table2[] will store the maximum value of arr[j] – arr[i]
table3[] will store the maximum value of arr[j] – arr[i] + arr[l]
table4[] will store the maximum value of arr[j] – arr[i] + arr[l] – arr[k]
So we iterate through table4[] the to get the maximum value which will be our required answer.
*/

//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            long arr[] = new long[n + 5];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Long.parseLong(inputLine[i]);
            }
            Solution obj = new Solution();
            System.out.println(obj.findMaxValue(arr, n));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static long findMaxValue(long arr[], int n) {
        // Write your code here
        // long min=Long.MAX_VALUE, max=Long.MIN_VALUE, tMin=Long.MAX_VALUE, tMax=Long.MIN_VALUE;

        // for(long i:arr){
        //     if(i>max)
        //         max=i;
        //     if(i<min)
        //         min=i;
        // }
        // for(long i:arr){
        //     if(i>tMax && i<max)
        //         tMax=i;
        //     if(i<tMin && i>min)
        //         tMin=i;
        // }
        // return tMax-tMin+max-min;
        
        if(n<4)
            return -1;
        
         long    t1 = -arr[0];
long t2 = arr[1] - arr[0];
      long   t3 = arr[1] - arr[0] - arr[2];
     long   t4 = arr[1] - arr[0] - arr[2] + arr[3];
        for (int i = 4;i < n;i++)
        {
            t1 = Math.max(t1, -arr[i - 3]);
            t2 = Math.max(t2, t1 + arr[i - 2]);
            t3 = Math.max(t3, t2 - arr[i - 1]);
            t4 = Math.max(t4, t3 + arr[i]);
        }
        return t4;
    }
}

