/*
Suppose you are a car driver and you have to drive a car on a track divided into "N" number of sub-tracks. You are also given the value of "K" i.e. the total kilometers the car can drive on each sub-track. If the car can't cover a sub-track, you can add any unit of Petrol to it. With each unit of petrol added, the total kilometers your car can travel will increase by one unit.You have to return the minimum unit of Petrol your car requires to cover all the sub-tracks. If no extra unit of petrol is required, return -1.

 

Example 1:

Input:
N = 5, K = 7
arr[] = {2, 5, 4, 5, 2}
Output:
-1
Explanation:
No extra petrol required, as K is greater
than all the elemnts in the array hence -1.
 

Example 2:

Input:
N = 5, K = 4
arr[] = {1, 6, 3, 5, 2}
Output:
2
Explanation:
You are given 5 sub-tracks with different
kilometers. Your car can travel 4 km on
each sub-track. So, when you come on
sub-track 2nd you have to cover 6 km of
distance, so you need to have 2 unit of
petrol more to cover the distance, for
3rd sub-track, now your car can travel
6 kilometers, so no problem and so on.
 

Your Task:  
You don't need to read input or print anything. Your task is to complete the function required() which takes the array arr[], its size n and an integer k as inputs and returns the minimum unit of Petrol your car requires to cover all the sub-tracks. If no extra unit of petrol is required, return -1.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ N ≤ 105
1 ≤ K ≤ 1018
1 ≤ A[] ≤ 1018
*/
`
//{ Driver Code Starts
//Initial Template for Java

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
            StringTokenizer stt = new StringTokenizer(br.readLine());
            
            long n = Long.parseLong(stt.nextToken());
            long m = Long.parseLong(stt.nextToken());
            // int n = Integer.parseInt(br.readLine().trim());
            long a[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.required(a, n, m));
        }
	}
}



// } Driver Code Ends


//User function Template for Java

class Solution {

    public static long required(long a[], long n, long k) {
        // Your code goes here
        long max=Long.MIN_VALUE;
        
        for(long i:a){
            if(i>max)
                max=i;
        }
        
        return max-k>0 ? max-k : -1;
    }
}
