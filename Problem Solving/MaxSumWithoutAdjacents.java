/*
Given an array Arr of size N containing positive integers. Find the maximum sum of a subsequence such that no two numbers in the sequence should be adjacent in the array.

Example 1:

Input:
N = 6
Arr[] = {5, 5, 10, 100, 10, 5}
Output: 110
Explanation: If you take indices 0, 3
and 5, then Arr[0]+Arr[3]+Arr[5] =
5+100+5 = 110.
Example 2:

Input:
N = 4
Arr[] = {3, 2, 7, 10}
Output: 13
Explanation: 3 and 10 forms a non
continuous  subsequence with maximum
sum.
Your Task:
You don't need to read input or print anything. Your task is to complete the function findMaxSum() which takes the array of integers arr and n as parameters and returns an integer denoting the answer.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ N ≤ 106
1 ≤ Arri ≤ 107
*/

//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().findMaxSum(arr, n);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int findMaxSum(int arr[], int n) {
        // code here
        //same as stickler
        int dp[]=new int[n];
        
        Arrays.fill(dp, -1);
        return max(0, arr, dp);
    }
    
     private int max(int i, int arr[], int dp[]){
            if(i>=arr.length)
                return 0;
                
            if(dp[i]!=-1)
                return dp[i];
            
           
            int a=arr[i]+max(i+2, arr, dp);
             int b=max(i+1, arr, dp); //this case considers adding value after not considering current index element
            
            return dp[i]=Math.max(a, b); //this max considers that at every point both possibility of skipping and not skipping elements is calculated and max is inserted in dp at the calculated index for max optimum solution in terms of money in this case
        }
}
