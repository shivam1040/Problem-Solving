/*
Given a sorted array arr[] of size N. Find the element that appears only once in the array. All other elements appear exactly twice. 

Example 1:

Input:
N = 11
arr[] = {1, 1, 2, 2, 3, 3, 4, 50, 50, 65, 65}
Output: 4
Explanation: 4 is the only element that 
appears exactly once.
 

Your Task:  
You don't need to read input or print anything. Complete the function findOnce() which takes sorted array and its size as its input parameter and returns the element that appears only once. 


Expected Time Complexity: O(log N)
Expected Auxiliary Space: O(1)

 

Constraints:
1 <= N <= 105
-105 <= arr[i] <= 105
*/

/*
An Efficient Solution can find the required element in O(Log n) time. The idea is to use Binary Search. Below is an observation on the input array. 
All elements before the required have the first occurrence at even index (0, 2, ..) and the next occurrence at odd index (1, 3, …). And all elements after the required elements have the first occurrence at an odd index and the next occurrence at an even index. 

Find the middle index, say ‘mid’.
If ‘mid’ is even, then compare arr[mid] and arr[mid + 1]. If both are the same, then the required element after ‘mid’ and else before mid.
If ‘mid’ is odd, then compare arr[mid] and arr[mid – 1]. If both are the same, then the required element after ‘mid’ and else before mid.
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
            System.out.println(sol.findOnce(arr, n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution 
{
    int res=0;
    int findOnce(int arr[], int n)
    {
        // Complete this function
        res=0;
        search(arr, 0, n-1);
        return res;
    }
    
    private void search(int arr[], int low, int high){
        if(low>high)
            return;
        else if(low==high){
            res=arr[low];
            return;
        }
        
        int mid=(low+high)/2;
        
        if(mid%2==0){
            if(arr[mid]==arr[mid+1])
                search(arr, mid+2, high);
            else
                search(arr, low, mid);
        }
        else if(mid%2==1){
            if(arr[mid]==arr[mid-1])
                search(arr, mid+1, high);
            else
                search(arr, low, mid-1);
        }
    }
}
