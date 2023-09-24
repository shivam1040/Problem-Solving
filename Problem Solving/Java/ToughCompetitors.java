/*
There are n competitors in an exam. Each competitor has his own skill value which is given by the array arr where arr1 is the skill of the first competitor, arr2 is the skill of second competitor and so on. Two competitors are said to be tough competitors if their skill difference is least i.e. they are very close in their skill values. Given n and an array arr as input, find the tough competitors among the n competitors and print the absolute of the difference of their skill values.

Example 1:

Input:
n = 4
arr[] = {9, 4, 12, 6}
Output: 2
Explanation: As |9-4|=5, |9-12|=3, |9-6|=3,
|4-12|=8, |4-6|=2, |12-6|=6 so, the tough
competitors are competitors having skill
values 4, 6 having their skill difference
as 2.
Example 2:

Input:
n = 5
arr[] = {4, 9, 1, 32, 12}
Output: 3
Explanation: Tough competitors are
competitors having skill values (4,1)
and (9,12) having their skill difference
as 3.
Your Task:
You don't need to read input or print anything. Your task is to complete the function toughCompetitor() which takes the array of integers arr and n as parameters and returns an integer denoting the answer.

Expected Time Complexity: O(n*logn)
Expected Auxiliary Space: O(1)

Constraints:
2 <= n <= 105
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
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().toughCompetitor(arr, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends





class Solution {
    int toughCompetitor(int[] arr, int n) {
        // code here
        int res=Integer.MAX_VALUE;
        
        Arrays.sort(arr);
        
        for(int i=1; i<n; i++){
            if(arr[i]-arr[i-1]<res)
                res=arr[i]-arr[i-1];
        }
        return res;
    }
}

