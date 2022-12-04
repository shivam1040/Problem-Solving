/*
Given a sorted array Arr[](0-index based) consisting of N distinct integers and an integer k, the task is to find the index of k, if its present in the array Arr[]. Otherwise, find the index where k must be inserted to keep the array sorted.


Example 1:

Input:
N = 4
Arr = {1, 3, 5, 6}
k = 5
Output: 2
Explaination: Since 5 is found at index 2 
as Arr[2] = 5, the output is 2.

Example 2:

Input:
N = 4
Arr = {1, 3, 5, 6}
k = 2
Output: 1
Explaination: Since 2 is not present in 
the array but can be inserted at index 1 
to make the array sorted.

Your Task:
You don't need to read input or print anything. Your task is to complete the function searchInsertK() which takes the array Arr[] and its size N and k as input parameters and returns the index.


Expected Time Complexity: O(logN)
Expected Auxiliary Space: O(1)


Constraints:
1 ≤ N ≤ 104
-103 ≤ Arr[i] ≤ 103
-103 ≤ k ≤ 103
*/

// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int Arr[]= new int[N];
            for(int i = 0; i < N; i++)
                Arr[i] = Integer.parseInt(input_line[i]);
            int k = Integer.parseInt(read.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.searchInsertK(Arr, N, k));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int searchInsertK(int Arr[], int N, int k)
    {
        // code here
        if(Arr[N/2]==k)
            return (N/2);
        else if(Arr[N/2]>k)
            return insert(Arr, 0, (N/2), k);
        else
            return insert(Arr, N/2, N-1, k);
    }
    
    static int insert(int Arr[], int low, int high, int k){
        for(int i=low; i<=high; i++)
            if(Arr[i]>=k)
                return i;
        return high+1;
    }
}
