/*
Given a sorted array arr[] of size N and a number X, find a pair in array whose sum is closest to X.

Example 1:

Input:
N = 6, X = 54
arr[] = {10, 22, 28, 29, 30, 40}
Output: 22 30
Explanation: As 22 + 30 = 52 is closest to 54.

Example 2:

Input:
N = 5, X = 10
arr[] = {1, 2, 3, 4, 5}
Output: 4 5
Explanation: As 4 + 5 = 9 is closest to 10.

Your Task:
You don't need to read input or print anything. Your task is to complete the function sumClosest() which takes arr[] of size n and x as input parameters and returns a list containing 2 integers denoting the required pair. If multiple pairs are possible return the largest sum pair.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)


Constraints:
2 <= N <= 105
0 <= X <= 106
0 <= arr[i] <= 106
*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            Solution ob = new Solution();
            int ans[] = ob.sumClosest(arr, x);
            System.out.print(ans[0]+" "+ans[1]);
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int[] sumClosest(int[] arr, int x) {
        // code here 
        int res[]=new int[2];
        int diff=Integer.MAX_VALUE, l=0, r=arr.length-1, resL=0, resR=0;
        
        while(l<r){
            //finding closest pair comparing to last found closest difference from x
            if(Math.abs(arr[l]+arr[r]-x) < diff){
                diff=Math.abs(arr[l]+arr[r]-x);
                resL=l;
                resR=r;
            }
            else if(arr[l]+arr[r] > x)
                r--;
            else
            l++;
        }
        
        res[0]=arr[resL];
        res[1]=arr[resR];
        
        return res;
    }
}
