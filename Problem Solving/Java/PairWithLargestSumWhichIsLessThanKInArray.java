/*
Given an array arr of size N and an integer K. The task is to find the pair of integers in the array such that their sum is maximum but less than K.

Note:Out of every possible pair, find pair with a maximum absolute difference.

Input:
The first line of input contains an integer T denoting the number of test cases. T testcases follow.
The first line of each test case contains N and K, where N is the number of elements in the array and K is the bound. The second line of each test case contains the array elements.

Output:
Print the pair with the maximum sum less than K.

Your task:
You don't have to take input. Complete the function Max_Sum(), which takes the array, N and K as parameters and returns the pair of integer in sorted manner first element of pair is minimum  if exist else return pair of zeros (0,0). The printing is done by the driver code. 

Constraints:
1 ≤ T ≤ 10
0 ≤ N ≤ 105
0 ≤ K ≤ 106
0 ≤ arr[i] ≤ 105

Example:
Input:
2
6 10
2 3 4 6 8 10
6 0
2 3 4 6 8 10
Output:
3 6
0 0

Explanation:
Testcase 1: Pair (3,6) has a maximum sum equals 9 which is less than 10.
Testcase 2: There doesn't exist any pair in the array with a sum less than 0.
*/

/*
After sorting, we can place two pointers at the left and right extremes of the array. The desired pair can be found by the following steps:

Find the current sum of the values at both the pointers.
If the sum is lesser than k:
update the answer with the maximum of the previous answer and the current sum.
increase the left pointer.
Else Decrease the right pointer.
*/

//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            int[] a = new int[n];
            for (int j = 0; j < n; j++) {
                a[j] = sc.nextInt();
            }

            Solution obj = new Solution();
            ArrayList<Integer> res = obj.Max_Sum(a, n, k);
            for (int ii = 0; ii < res.size(); ii++)
                System.out.print(res.get(ii) + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static ArrayList<Integer> Max_Sum(int[] arr, int n, int k) {
        
        // Instead of a pair, return an array of two integers.
        Arrays.sort(arr);
        
        int left=0, right=n-1, temp1=Integer.MIN_VALUE;
        ArrayList<Integer> res1=new ArrayList<>();
        
        while(left<right){
            int temp=arr[right]+arr[left];
            
            if(temp<k){
                if(temp>temp1){
                    temp1=temp;
                    res1=new ArrayList<>();
                    
                    res1.add(arr[left]);
                    res1.add(arr[right]);
                }
                 left++;
            }
            else
                right--;
        }
        if(res1.isEmpty()){
            res1.add(0);
            res1.add(0);
        }
        return res1;
    }
}
