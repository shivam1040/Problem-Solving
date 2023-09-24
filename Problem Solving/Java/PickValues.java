/*
Given an array arr[] of N positive integers. Select values from the array such that their sum is minimum. You must pick at least 1 value from each group of 4 consecutive elements. 


Example 1:

Input:
N = 5
Arr[] = {1, 2, 3, 1, 2}
Output: 1
Explanation: There are 2 groups of 4
in the given array. The 1st group is
[1 2 3 1] and 2nd is [2 3 1 2].
Selecting the 4th element in the 
array will give the least sum as 
it belongs to both groups.


Example 2:

Input:
N = 6
Arr[] = {8, 6, 9, 10, 6, 7}
Output: 9
Explanation: There are 3 groups of 4
consecutive elements. 9 at index 2 
is the smallest element that is 
present in all 3 groups. 


Your Task:
You don't need to read input or print anything. Your task is to complete the function pickValues() which takes the array of integers arr[] and its size n as input parameters and returns an integer denoting the minimum sum.



Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)



Constraints:
1 ≤ N ≤ 105
1 ≤ Arr[i] ≤ 103


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

            int ans = new Solution().pickValues(arr, n);
            System.out.println(ans);
        }
    }
}


// } Driver Code Ends


//User function Template for Java




class Solution {
    int pickValues(int[] arr, int n) {
        // code here
        if(n<=4){
            return Arrays.stream(arr).min().orElse(Integer.MAX_VALUE);
        }
        int []dp=new int[n];
        
        dp[0]=arr[0];
        dp[1]=arr[1];
        dp[2]=arr[2];
        dp[3]=arr[3];
        
        //in this dp, we are always finding min over a range of 4
        //current arr ele is taken into consideration so sum is always curr+min of last range of 4
        for(int i=4; i<n; i++)
            dp[i]=arr[i]+Math.min(Math.min(dp[i-1], dp[i-2]), Math.min(dp[i-3], dp[i-4]));
        return Math.min(Math.min(dp[n-1], dp[n-2]), Math.min(dp[n-3], dp[n-4]));
    }
}

