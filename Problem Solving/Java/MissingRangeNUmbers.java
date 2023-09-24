/*
Given an array Arr of N positive integers, find the missing elements (if any) in the range 0 to max of Arri.

Example 1:

Input:
N = 5
Arr[] = {62, 8, 34, 5, 332}
Output: 0-4 6-7 9-33 35-61 63-331
Explanation: Elements in the range 0-4, 6-7, 
9-33, 35-61 and 63-331 are not present.

Example 2:

Input:
N = 4
Arr[] = {13, 0, 32, 500}
Output: 1-12 14-31 33-499
Explanation: Elements in the range 1-12, 
14-31 and 33-499 are not present.

Your Task:
You don't need to read input or print anything. Your task is to complete the function findMissing() which takes the array of integers arr and its size n as input parameters and returns a string denoting the missing elements. If
there are more than one missing, collate them using hyphen (-) and separate each different range with a space. If there are no missing element then return "-1".


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)


Constraints
1 <= N <= 107
0 <= Arri <= 107
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

            String ans = new Solution().findMissing(arr, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java



class Solution {
    String findMissing(int[] arr, int n) {
        // code here
        Arrays.sort(arr);
        
        StringBuilder res=new StringBuilder();
        
        if(arr[0]>1)
            res.append("0"+ "-" + (arr[0]-1) +" ");
        else if(arr[0]==1)
            res.append("0 ");
        
        for(int i=0; i<n-1; i++){
            if(arr[i+1]-arr[i]<=1)
                continue;
            else if(arr[i+1]-arr[i]==2)
                 res.append(arr[i]+1+" ");
            else
                res.append((arr[i]+1) + "-" + (arr[i+1]-1) + " ");
        }
        
        return res.toString().isEmpty() ? "-1" : res.toString();
    }
}

