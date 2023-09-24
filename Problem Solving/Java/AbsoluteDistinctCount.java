/*
Given a sorted array of N integers, find the number of distinct absolute values among the elements of the array. 

Example 1:

Input:
N = 6
arr[] = {-3, -2, 0, 3, 4, 5}
Output: 5
Explanation: There are 5 distinct absolute 
values among the elements of this array, 
i.e. 0, 2, 3, 4 and 5.

Example 2:

Input:
N = 9
arr[] = {-1, -1, -1, -1, 0, 1, 1, 1, 1}
Output: 2
Explanation: There are 2 distinct absolute values 
among the elements of this array, i.e. 0 and 1.

Your Task:
You don't need to read input or print anything. Complete the function distinctCount() which takes the array of integers arr[] and its size n as input parameters and returns the number of distinct absolute values.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)


Constraints:
1 ≤ N ≤ 105
0 ≤ |Arr[i]| ≤ 106
*/

/*
The idea is to take advantage of the fact that the array is already Sorted. We initialize the count of distinct elements to number of elements in the array. We start with two index variables from two corners of the array and check for pair in the input array with sum as 0. If pair with 0 sum is found or duplicates are encountered, we decrement the count of distinct elements.Finally we return the updated count.
*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            int ans = new Solution().distinctCount(arr, n);
            System.out.println(ans);
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution {
    int distinctCount(int[] arr, int n) {
        // code here
        int l=0, r=n-1, count=n;
        
        while(l<r){
            //finding consecutive duplicates in left side until duplicate is none is found
            while(l!=r && arr[l]==arr[l+1]){
                count--;
                l++;
            }
            //finding consecutive duplicates in right side until duplicate is none is found
            while(l!=r && arr[r]==arr[r-1]){
                count--;
                r--;
            }
            if(l==r)
                break;
            int sum=arr[l]+arr[r];
            //start finding zeroes because -3+3=0
            if(sum==0){
                count--;
                l++;
                r--;
            }
            //means we are not near ele which would give zero on addition
            else if(sum<0)
                l++;
                //we are too far from zero to yield zero on add
            else
                r--;
        }
        return count;
    }
}

