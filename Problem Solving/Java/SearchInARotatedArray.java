/*
Given a sorted and rotated array A of N distinct elements which is rotated at some point, and given an element key. The task is to find the index of the given element key in the array A.

Example 1:

Input:
N = 9
A[] = {5, 6, 7, 8, 9, 10, 1, 2, 3}
key = 10
Output:
5
Explanation: 10 is found at index 5.
Example 2:

Input:
N = 4
A[] = {3, 5, 1, 2}
key = 6
Output:
-1
Explanation: There is no element that has value 6.
Your Task:
Complete the function search() which takes an array arr[] and start, end index of the array and the K as input parameters, and returns the answer.

Can you solve it in expected time complexity?

Expected Time Complexity: O(log N).
Expected Auxiliary Space: O(1).

Constraints:
1 ≤ N ≤ 107
0 ≤ A[i] ≤ 108
1 ≤ key ≤ 108
*/


// { Driver Code Starts
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
            int A[] = new int[n];
            
            for (int i = 0;i < n;i++)
            {
                A[i] = sc.nextInt();
            }
            int key = sc.nextInt();
            
            System.out.println(new Solution().search(A, 0, n - 1, key));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    int search(int A[], int l, int h, int key)
    {   
        
        int pivot=0;
        for(int i=1; i<A.length; i++){
            if(A[i]<A[i-1]){
                pivot=i-1;
                break;
            }
        }
        //System.out.println(A[pivot]);
        if(A[pivot]==key)
            return pivot;
        int ll=search1(A, 0, pivot, key);
        if(ll!=-1)
            return ll;
        int rr=search1(A, pivot, A.length-1, key);
        return Math.max(ll,rr);
        
    }
    
    int search1(int arr[], int l, int h, int key){
        //System.out.println(l+" "+h);
        while(l<=h){
            int mid=l+(h-l)/2;
            if(arr[mid]==key)
                return mid;
            if(arr[mid]<key)
                l=mid+1;
            else
                h=mid-1;
        }
        return -1;
    }
}