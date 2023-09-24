/*
Given an array of distinct positive numbers, the task is to calculate the minimum number of subsets (or subsequences) from the array such that each subset contains consecutive numbers.
 

Example 1:

Input:
N = 10
Arr[] = {100, 56, 5, 6, 102, 58, 101, 57, 7, 103} 
Output:
3
Explanation:
{5, 6, 7}, { 56, 57, 58}, {100, 101, 102, 103} are
3 subset in which numbers are consecutive.
 

Example 2:

Input:
N = 3
Arr[] = {10, 100, 105}
Output:
3
Explanation:
{10}, {100} and {105} are 3 subset
in which numbers are consecutive.
 


Your Task:  
You don't need to read input or print anything. Your task is to complete the function numofsubset() which takes the array Arr[] and its size N as inputs and returns the count of number of such subset's that contains consecutive numbers.

 

Expected Time Complexity: O(N. log(N))
Expected Auxiliary Space: O(1)


Constraints:
1 ≤ N≤ 105
1 ≤ A[] ≤ 105
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
            int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.numofsubset(a, n));
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java


class Solution {
    
    public static int numofsubset(int arr[], int n)
    {
         // Your code goes here
         int count=1;
         
         Arrays.sort(arr);
         
         for(int i=0; i<n-1; i++){
             if(arr[i+1]-arr[i]!=1)
                count++;
         }
         return count;
    }
}
