/*
Given an array Arr of N positive integers and a number K where K is used as a threshold value to divide each element of the array into sum of different numbers. Find the sum of count of the numbers in which array elements are divided.

Example 1:

Input:
N = 4, K = 3
Arr[] = {5, 8, 10, 13}
Output: 14
Explanation: Each number can be expressed as sum 
of different numbers less than or equal to K as
5 (3 + 2), 8 (3 + 3 + 2), 10 (3 + 3 + 3 + 1), 
13 (3 + 3 + 3 + 3 + 1). So, the sum of count 
of each element is (2+3+4+5)=14.

Example 2:

Input:
N = 5, K = 4
Arr[] = {10, 2, 3, 4, 7}
Output: 8
Explanation: Each number can be expressed as sum of
different numbers less than or equal to K as
10 (4 + 4 + 2), 2 (2), 3 (3), 4 (4) and 7 (4 + 3).
So, the sum of count of each element is 
(3 + 1 + 1 + 1 + 2) = 8.

Your Task:
You don't need to read input or print anything. Your task is to complete the function totalCount() which takes the array of integers arr and n as parameters and returns an integer denoting the answer.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)


Constraints:
1 ≤ N ≤ 107
0 ≤ Arri ≤ 107
1 ≤ K ≤ 107
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
            int k = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            int ans = new Solution().totalCount(arr, n, k);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    int totalCount(int[] arr, int n, int k) {
        // code here
        int res=0;
        
        for(int i:arr){
            int temp=i;
            while(temp>0){
                if(temp<k){
                    res++;
                    break;
                }
                temp-=k;
                res++;
            }
        }
        return res;
    }
}

