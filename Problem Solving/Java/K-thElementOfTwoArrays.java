/*
Given two sorted arrays arr1 and arr2 of size N and M respectively and an element K. The task is to find the element that would be at the kth position of the final sorted array.
 

Example 1:

Input:
arr1[] = {2, 3, 6, 7, 9}
arr2[] = {1, 4, 8, 10}
k = 5
Output:
6
Explanation:
The final sorted array would be -
1, 2, 3, 4, 6, 7, 8, 9, 10
The 5th element of this array is 6.
Example 2:
Input:
arr1[] = {100, 112, 256, 349, 770}
arr2[] = {72, 86, 113, 119, 265, 445, 892}
k = 7
Output:
256
Explanation:
Final sorted array is - 72, 86, 100, 112,
113, 119, 256, 265, 349, 445, 770, 892
7th element of this array is 256.

Your Task:  
You don't need to read input or print anything. Your task is to complete the function kthElement() which takes the arrays arr1[], arr2[], its size N and M respectively and an integer K as inputs and returns the element at the Kth position.


Expected Time Complexity: O(Log(N) + Log(M))
Expected Auxiliary Space: O(Log (N))


Constraints:
1 <= N, M <= 106
0 <= arr1i, arr2i < INT_MAX
1 <= K <= N+M
*/

/*
Intuition
The key idea in solving this problem is to use the divide and conquer approach i.e binary search on both the arrays to find the ‘kth’ element.

Implementation
Since the two arrays are sorted, we can safely assume that the ‘k-th’ element in the merged array is either in the first ‘k’ elements first array or in the first ‘k’ elements in the second array.
Now we take the middle element of both the arrays say ‘mid1’ and ‘mid2’.
Now 2 cases arise:
if mid1+mid2 is less than k, that means the ‘kth’ element is in either the first half of array 1 or 2.  This can be easily determined by comparing 'arr1[mid1]' and 'arr2[mid2]'
If ‘mid1+mid2’ is not less than ‘k’, then the 'kth' element is in the right half of the array1 or array 2.This can be easily determined by comparing ‘arr1[mid1]’ and ‘arr2[mid2]’
*/

//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            StringTokenizer stt = new StringTokenizer(br.readLine());
            
            int n = Integer.parseInt(stt.nextToken());
            int m = Integer.parseInt(stt.nextToken());
            int k = Integer.parseInt(stt.nextToken());
            int a[] = new int[(int)(n)];
            int b[] = new int[(int)(m)];
            
            
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            String inputLine1[] = br.readLine().trim().split(" ");
            for (int i = 0; i < m; i++) {
                b[i] = Integer.parseInt(inputLine1[i]);
            }
            
            
            Solution obj = new Solution();
            System.out.println(obj.kthElement( a, b, n, m, k));
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution {
    public long kthElement( int arr1[], int arr2[], int n, int m, int k) {
        // int i=0, j=0, count=0;
        // long res=0;

        // while(i<n && j<m && count<k){
        //     if(arr1[i]<arr2[j]){
        //         res=arr1[i++];
        //         count++;
        //     }
        //     else{
        //         res=arr2[j++];
        //         count++;
        //     }
        // }
        // while(count<k){
        //     if(i<n){
        //                      res=arr1[i++];
        //         count++;
        //     }
        //     else if(j<m){
        //                         res=arr2[j++];
        //         count++;
        //     }
        // }
        // return res;
        return kth(arr1, arr2, 0, n, 0, m, k-1);
    }
    
    private long kth(int arr1[], int arr2[], int s1, int e1, int s2, int e2, int k){
        // Base case: If one array is empty, return kth element from the other array
        if (s1 == e1)
            return arr2[s2 + k];
        if (s2 == e2)
            return arr1[s1 + k];
        
        // Calculate the middle indices of the two arrays
        int m1 = (e1 - s1) / 2;
        int m2 = (e2 - s2) / 2;
        
        // If the sum of middle indices is less than k
        if (m1 + m2 < k)
        {
            // Compare the middle elements of the two arrays
            if (arr1[s1 + m1] > arr2[s2 + m2])
                // Recursively search in the second half of the second array
                return kth(arr1, arr2, s1, e1, s2 + m2 + 1, e2, k - m2 - 1);
            else
                // Recursively search in the second half of the first array
                return kth(arr1, arr2, s1 + m1 + 1, e1, s2, e2, k - m1 - 1);
        }
        else
        {
            // If the sum of middle indices is greater than or equal to k
            if (arr1[s1 + m1] > arr2[s2 + m2])
                // Recursively search in the first half of the first array
                return kth(arr1, arr2, s1, s1 + m1, s2, e2, k);
            else
                // Recursively search in the first half of the second array
                return kth(arr1, arr2, s1, e1, s2, s2 + m2, k);
        }
    }
}
