/*
Given an integer array of which both first half and second half are sorted. The task is to merge two sorted halves of the array into a single sorted array.
Note: The two halves can be of arbitrary sizes.

Example 1:

Input:
N = 6
arr[] = {2 3 8 -1 7 10}
Output: -1 2 3 7 8 10 
Explanation: {2 3 8} and {-1 7 10} are sorted 
in the original array. The overall sorted 
version is {-1 2 3 7 8 10}
Example 2:

Input:
N = 5
arr[] = {-4 6 9 -1 3}
Output: -4 -1 3 6 9 
Explanation: {-4 -1} and {3 6 9} are sorted 
in the original array. The overall sorted 
version is {-4 -1 3 6 9}

Your Task:
You don't need to read input or print anything. Your task is to complete the function sortHalves () which takes the array arr[] and its size n as inputs and modifies the array such that it gets sorted completely.


Expected Time Complexity: O(n).
Expected Auxiliary Space: O(n).


Constraints:
1 <= N <= 105

*/


//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int[] arr = new int[n];
            
            for (int i = 0; i < n; ++i)
                arr[i] = sc.nextInt ();

    		new Solution().sortHalves (arr, n);
    	    for (int i = 0; i < n; ++i)
    	        System.out.print (arr[i] + " ");
    	    System.out.println ();
        }
        
    }
}

// Contributed By: Pranay Bansal
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public static void sortHalves (int A[], int n)
    {
        // your code here
        int half_i = 0; // starting index of second half
        int i;
 
        // Temp Array store sorted resultant array
        int[] temp = new int[n];
 
        // First Find the point where array is divide
        // into two half
        for (i = 0; i < n - 1; i++) {
            if (A[i] > A[i + 1]) {
                half_i = i + 1;
                break;
            }
        }
 
        // If Given array is all-ready sorted
        if (half_i == 0)
            return;
 
        // Merge two sorted arrays in single sorted array
        i = 0;
        int j = half_i;
        int k = 0;
        while (i < half_i && j < n) {
            if (A[i] < A[j])
                temp[k++] = A[i++];
            else
                temp[k++] = A[j++];
        }
 
        // Copy the remaining elements of A[i to half_! ]
        while (i < half_i)
            temp[k++] = A[i++];
 
        // Copy the remaining elements of A[ half_! to n ]
        while (j < n)
            temp[k++] = A[j++];
 
        for (i = 0; i < n; i++)
            A[i] = temp[i];
}
}
