/*
Given an array of integers a of length n and a value k. You have to find out the maximum possible numbers within 109whose sum does not exceed k but are not present in the array.

Example 1:

Input: n = 4, 
       k = 14,
       a = {4, 6, 12, 8}
Output: 4
Explaination: The integers 1, 2, 3 and 5.
Example 2:

Input: n = 4,
       k = 25, 
       a = {5, 6, 7, 8}
Output: 5
Explaination: The integers are 1, 2, 3, 4 and 9.
Your Task:
You do not need to read input or print anything. Your task is to complete the function maxNumbers() which takes n, k, and array as input parameters and returns the maximum number of integers that can be selected.

Expected Time Complexity: O(nlogn)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ n ≤ 105
1 ≤ a[i], k ≤ 109
*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String arr[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(arr[0]);
            int k = Integer.parseInt(arr[1]);
            String arr1[] = in.readLine().trim().split("\\s+");
            int a[] = new int[n];
            for(int i = 0; i < n; i++)
                a[i] = Integer.parseInt(arr1[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.maxNumbers(n, k, a));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int maxNumbers(int n, int k, int a[]){
        // code here
        int res=0, sum=0, begin=1;
        
        Arrays.sort(a);
        
        for(int i:a){
            while(begin<i){
                sum+=begin;
                
                if(sum<k)
                    res++;
                else
                    break;
                begin++;
            }
            if(sum>=k)
                break;
            begin++;
        }
           while(sum<k){
            sum+=begin;
            if(sum<k)
                res++;
            begin++;
        }
        return res;
    }
}
