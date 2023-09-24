/*
Given an array of positive integers of size N. Count the number of good pairs (i,j) such that:

1≤ i ≤ N,
1≤ j ≤ N
and arri < arrj.
Example 1

Input:
N = 2
arr[] = {2, 1}  
Output: 1
Explanation : The only good pair is (2,1). 
Example 2

Input:
N = 3
arr[] = {2 ,3, 2}
Output: 2
Explanation: The two good pairs are (2,3) 
and (3,2).
Your Task:
You don't need to read input or print anything. Your task is to complete the function solve() which takes the array arr[] and its size N as inputs and returns the count of good pairs as described in the problem description.

Expected Time Complexity: O(N log N)
Expected Auxiliary Space: O(1)

Constraints:
1 <= N <= 10^5
1 <= a[i] <= 10^3
*/

/*
sort the array
find the inverse array
*/

//{ Driver Code Starts
//Initial Template for Java

import java.util.*;

public class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        
        while (t-- > 0)
        {
            int n = sc.nextInt();
            
            int arr[] = new int[n];
            for (int i = 0;i < n;i++)
            {
                arr[i] = sc.nextInt();
            }
            
            Solution sol = new Solution();
            System.out.println(sol.solve(arr, n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution 
{
    long solve(int arr[], int n)
    {
        // Complete this function
        Arrays.sort(arr);
        
        long count=0;
        
        for(int i:arr){
            int x=solvex(arr,i);
            count+= x==-1 ? 0 : x;
        }
        
        return count;
    }
    
    //we basically find how far is a bigger element from its previous smallest in terms of index
    private int solvex(int arr[], int key){
        int start=0;
        int end=arr.length-1;
        int ans=-1;
        
        while(start<=end){
            int mid=(start+end)/2;
            
            if(arr[mid]==key){
                ans=mid;
                end=mid-1;
            }
            else if(arr[mid]>key)
                end=mid-1;
            else
                start=mid+1;
        }
        
        return ans;
    }
}
