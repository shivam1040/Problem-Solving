/*
Given an unsorted array Arr of N positive and negative numbers. Your task is to create an array of alternate positive and negative numbers without changing the relative order of positive and negative numbers.
Note: Array should start with positive number.
 

Example 1:

Input: 
N = 9
Arr[] = {9, 4, -2, -1, 5, 0, -5, -3, 2}
Output:
9 -2 4 -1 5 -5 0 -3 2
Example 2:

Input: 
N = 10
Arr[] = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8}
Output:
5 -5 2 -2 4 -8 7 1 8 0 


Your Task:  
You don't need to read input or print anything. Your task is to complete the function rearrange() which takes the array of integers arr[] and n as parameters. You need to modify the array itself.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)
 

Constraints:
1 ≤ N ≤ 107
-106 ≤ Arr[i] ≤ 107
*/

// { Driver Code Starts
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

            new Solution().rearrange(arr, n);
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java




class Solution {
    void rearrange(int arr[], int n) {
        List<Integer> pos = new ArrayList<Integer>();
        List<Integer> neg = new ArrayList<Integer>();
        for(int i=0;i<n;i++){
            if(arr[i]<0){
                neg.add(arr[i]);
            }else{
                pos.add(arr[i]);
            }
        }
        boolean positive=true;
        for(int i=0; i<n;){
            if(positive && pos.size() > 0){
                arr[i++] = pos.get(0);
                pos.remove(0);
            }else if(!positive && neg.size() > 0){
                arr[i++] = neg.get(0);
                neg.remove(0);
            }
            positive=!positive;
        }
        
    }
}