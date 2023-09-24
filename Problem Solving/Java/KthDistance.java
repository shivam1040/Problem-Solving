/*
Given an unsorted array Arr of size N that may contain duplicates. Also given a number K which is smaller than size of array. Find if array contains duplicates within K distance.

Example 1:

Input: 
K = 3, N = 8
Arr[] = {1, 2, 3, 4, 1, 2, 3, 4}
Output: False
Explanation: 
All duplicates are more than k distance
away.
Example 2:

Input: 
K = 3, N = 6
Arr[] = {1, 2, 3, 1, 4, 5}
Output: True
Explanation: 1 is repeated at distance 3.
Your Task:  
You don't need to read input or print anything. Your task is to complete the function checkDuplicatesWithinKâ€‹() which takes the array of integers arr[], n and k as parameters and returns boolean denoting the answer.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

Constraints:
1 ≤ N ≤ 106
1 ≤ K ≤ N
1 ≤ Arr[i] ≤ 107
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
            inputLine = br.readLine().trim().split(" ");
            int k = Integer.parseInt(inputLine[0]);
            int n = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            boolean ans = new Solution().checkDuplicatesWithinK(arr, n, k);
            if (ans) {
                System.out.println("True");
            } else {
                System.out.println("False");
            }
        }
    }
}

// } Driver Code Ends


//User function Template for Java



class Solution {
    boolean checkDuplicatesWithinK(int[] arr, int n, int k) {
        // code 
        Set<Integer> aux=new HashSet<>();
        
        for(int i=0; i<arr.length; i++){
            if(aux.contains(arr[i]))
                return true;
            aux.add(arr[i]);
            if(i>=k)
                aux.remove(arr[i-k]); //deleting the out of k range element
        }
        return false;
    }
}
