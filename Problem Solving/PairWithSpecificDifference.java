/*
Given an array of integers, arr[] and a number, K.You can pair two numbers of the array if the difference between them is strictly less than K. The task is to find the maximum possible sum of such disjoint pairs (i.e., each element of the array can be used at most once). The Sum of P pairs is the sum of all 2P elements of pairs.

 

Example 1:

Input  : 
arr[] = {3, 5, 10, 15, 17, 12, 9}
K = 4
Output : 
62
Explanation :
Then disjoint pairs with difference less
than K are, (3, 5), (10, 12), (15, 17)
max sum which we can get is 
3 + 5 + 10 + 12 + 15 + 17 = 62
Note that an alternate way to form 
disjoint pairs is,(3, 5), (9, 12), (15, 17)
but this pairing produces less sum.
 

Example 2:

Input  : 
arr[] = {5, 15, 10, 300}
K = 12
Output : 
25
 

Your Task:  
You don't need to read, input, or print anything. Your task is to complete the function maxSumPairWithDifferenceLessThanK() which takes the array arr[], its size N, and an integer K as inputs and returns the maximum possible sum of disjoint pairs.

 

Expected Time Complexity: O(N. log(N))
Expected Auxiliary Space: O(N)

 

Constraints:
1 ≤ N ≤ 105
0 ≤ K ≤ 105
1 ≤ arr[i] ≤ 104
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
            int N = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[N];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            int K = Integer.parseInt(br.readLine().trim());
            
            Solution obj = new Solution();
            System.out.println(obj.maxSumPairWithDifferenceLessThanK(arr, N, K));
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution { 
    public static int maxSumPairWithDifferenceLessThanK(int arr[], int N, int K) 
    {
        // Your code goes here
        int res=0;
        //sorting so that every pair is closest one so that the difference is betwween both of them is minimum and also their addition is max
        Arrays.sort(arr);
        
        //going from increasing to decreaing so that sum is max
        for(int i=N-1; i>0; i--){
            if((arr[i]-arr[i-1])<K){
                res+=arr[i];
                res+=arr[i-1];
                //skipping pair if found
                i--;
            }
        }
        return res;
    }
    
}

