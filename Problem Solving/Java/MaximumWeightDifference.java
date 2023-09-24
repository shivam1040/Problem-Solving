/*
Given an array arr of size n. The task is to choose k numbers from the array such that the absolute difference between the sum of chosen numbers and the sum of remaining numbers is maximum.

Example 1:

Input:
n = 5, k = 2
arr[] = {8, 4, 5, 2, 10}
Output: 17
Explanation: If we select 2 and 4,
then abs((2+4) - (8+5+10)) = 17.
Example 2:

Input:
n = 8, k = 3
arr[] = {1, 1, 1, 1, 1, 1, 1, 1}
Output: 2
Explanation:
We can select any 3 1's.
Your Task:
You don't need to read input or print anything. Your task is to complete the function solve() which takes the array of integers arr, n and k as parameters and returns an integer denoting the answer.

Expected Time Complexity: O(n*Logn)
Expected Auxiliary Space: O(1)

Constraints:
1 <= k <= n <=105
1 <= arr[i] <= 106
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

            long ans = new Solution().solve(arr, n, k);
            System.out.println(ans);
        }
    }
}


// } Driver Code Ends


//User function Template for Java




class Solution {
    long solve(int[] arr, int n, int k) {
        // code here
        long minL=0, minR=0, maxL=0, maxR=0;
        
        Arrays.sort(arr);
        for(int i=0; i<n; i++){
            if(i<k){
                minL+=arr[i];
                minR+=arr[n-i-1];
            }
            else{
                maxL+=arr[i];
                maxR+=arr[n-i-1];
            }
        }
        return Math.max(Math.abs(maxL-minL), Math.abs(maxR-minR));
    }
}

