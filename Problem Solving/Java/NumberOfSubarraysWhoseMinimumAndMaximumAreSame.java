/*
Given an array A[] of n integers, the task is to find the number of subarrays whose minimal and maximum elements are same.

Example 1:

Input : Arr[] = {1, 1, 3}
Output : 4
Explanation:
The subarrays are
(1), (1), (3) and (1, 1) 

Example 2:

Input : Arr[] = {1, 2, 3, 4}
Output : 4
 

Your Task:
This is a function problem. The input is already taken care of by the driver code. You only need to complete the function numberOfways() that takes an array (arr), sizeOfArray (n) and return the number of subarrays which follow above condition. The driver code takes care of the printing.

Expected Time Complexity: O(n).
Expected Auxiliary Space: O(1).

Constraints:
1 ≤ N ≤ 105
1 ≤ A[i] ≤ 105
*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


class GFG {
	public static void main (String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int a[] = new int[n + 1];
            
            for(int i=0;i<n;i++){
                a[i] = sc.nextInt();
            }
            
            Solution obj = new Solution();
            
            System.out.println(obj.numberOfways(a,n));
        }
        
	}
}

// } Driver Code Ends


//User function Template for Java



class Solution{
    
    long numberOfways(int a[], int n)
    {
        // Complete the function
        //basic logic is find the subarrays where every ele is same
        //starting from 1 since every number is subarray in itself
        long res=0, temp=1;
        
        for(int i=1; i<n; i++)
            if(a[i]==a[i-1])
                temp++;
            else{
                //this furmula finds the number of subarrays that can be created by temp eles
                res+=(temp*(temp+1))/2;
                temp=1;
            }
        
        res+=(temp*(temp+1))/2;
        
        return res;
    }   
}


