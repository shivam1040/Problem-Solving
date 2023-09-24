/*
Given an array of N integers Arr1, Arr2, ….ArrN, count number of subarrays of Arr which are strictly increasing. 
A subarray Arr[i, j] is the array where 1 <= i < j <= N is a sequence of integers of Arri, Arri+1, ….Arrj. A subarray Arr[i, j] is strictly increasing if Arri < Arri+1 < Arri+2 < ……. < Arrj.

Example 1:

Input: 
N = 6
Arr[] = {1, 3, 3, 2, 3, 5}
Output: 4
Explanation:
(1,3), (2, 3), (3, 5) and (2, 3, 5)
are the only increasing subarrays.
Example 2:

Input: 
N = 2
Arr[] = {1 5} 
Output: 1
Explanation:(1, 5) is the only increasing
subarray.
Your Task:  
You don't need to read input or print anything. Your task is to complete the function countIncreasing() which takes the array of integers arr[] and n as parameters and returns a integer denoting the answer.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints:
1 <= N <= 107
1 <= Arri <= 107
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

            int ans = new Solution().countIncreasing(arr, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java



class Solution {
    int countIncreasing(int arr[], int n) {
        // code here
        int len=0, count=0;
        
        // 1, 3, 3, 2, 3, 5   ← Sample input
       // 0  1. 0  0. 1. 2.  ← count of increasing subarrays ending at i index.
       // Subarray are continuous array elements so Idea is to keep track of "number of increasing subarray" ending at ith index.
       // if current Element  is greater than previous index element, it can make increasing subarray. Get previous index's count and add 1 to it since current and previous will make another subarray too.
        
        for(int i=1; i<n; i++){
            if(arr[i]>arr[i-1]){
                len+=1; //arr[i-1] can create eligible currCount subarrays. so arr[i] will make one extra with arr[i-1]
                count+=len;
            }
            else{
                
                len=0;
            }
        }
        
        return count;
    }
}
