/*
Given a sorted array arr[ ] of N positive integers. Your task is to find an index i in the array from where the number of elements smaller than arr[i] in the left side of the index is equal to the number of elements greater than arr[i] in the right side of the index.
If no such index exists, print "-1".

Example 1:

Input:
N = 6
arr[] = {1, 2, 3, 3, 3, 3}
Output:
1
Explanation:
2 is the element before which we have one
element that is smaller than 2 and we have
one element to its right which is greater
than 2. Hence, print the index of 2.
Example 2:

Input:
N = 8
arr[] = {1, 2, 3, 3, 3, 3, 4, 4}
Output:
-1
Explanation:
There is no index as such, so print -1
Your Task:  
You don't need to read input or print anything. Your task is to complete the function findEqualPoint() which takes the array arr[] and its size N as input parameters and returns the required index. If there are multiple indices, return the smallest one. If such index doesn't exist then return "-1" (without quotes).

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

Constraints:
1 ≤ N ≤ 105
1 ≤ Ai ≤ 1012
*/

//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine()); 
        while(t-->0)
        {
            int n = Integer.parseInt(read.readLine()); 
            int a[] = new int[n];
            
            String line = read.readLine(); // to read multiple integers line
            String[] strs = line.trim().split("\\s+");
            
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(strs[i]);
            }
            
            Compute obj = new Compute();
            System.out.println( obj.findEqualPoint(a, n) );
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java

class Compute 
{
    static int findEqualPoint(int arr[], int n) 
	{
	    // Your code goes here
	    int[] aux=new int[n];
	    int i=0, distinct=0;
	    
	    while(i<n){
	        aux[distinct++]=i++;
	        
	        while(i<n && arr[i-1]==arr[i])
	            i++;
	    }
	    
	    //idea is store first index of all distinct elements
	    //find the size of distince array
	    //if it is even then return mid of disticnt size
	    //else -1
	    return (distinct&1)!=0 ? aux[distinct>>1] : -1;
	}
} 

