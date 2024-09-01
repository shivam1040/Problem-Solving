/*
Given an array of integers arr[] and a query integer q. Find the number X from the array such that it can be converted from q to X such that F(q, X) is minimum.

F(A, B) = Number of bits flipped to change the number A to B.

If there are more than one values in arr[] such that F(q, X) is minimum print the smallest value of X for which F(q, X) is minimum.

Example 1:

Input:
n = 9, q = 1
arr[] = {5, 32, 1, 7, 10, 50, 19, 21, 2}
Output: 1
Explanation: F(1, 1) = 0, so this is the 
minimum X.
Example 2:

Input:
n = 6, q = 8
arr[] = {5, 32, 10, 7, 10, 50, 19, 21, 2}
Output: 10
Your Task:
You don't need to read input or print anything. Your task is to complete the function findX() which takes the array of integers arr, n and q as parameters and returns an integer denoting the answer.

Expected Time Complexity: O(n*logn)
Expected Auxiliary Space: O(1)
Constraints:
1 <= n <= 105
1 <= q <= 106
1 <= arr[i] <= 106
*/

//{ Driver Code Starts

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
            int q = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().findX(arr, n, q);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends




class Solution {
    int findX(int[] arr, int n, int q) {
        // code here
        int cnt=Integer.MAX_VALUE, x=Integer.MAX_VALUE;
        
        for(int i:arr){
            int temp=Integer.bitCount(i^q);
            
            if(temp<=cnt){
                if(temp==cnt && i<x)
                    x=i;
                if(temp<cnt)
                    x=i;
                cnt=temp;
            }
        }
        return x;
    }
}

