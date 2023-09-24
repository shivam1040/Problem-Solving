/*
You are given an array A of length N .You have to find the maximum sum subsequence of a given sequence such that all elements of the subsequence are sorted in strictly increasing order. If there are more than one such subsequences,then print the sequence which ends closest to the starting index of the string.

Example 1:

Input: N = 7
A = {1, 101, 2, 3, 100, 4, 5}
Output: {1, 2, 3, 100}
Explaination: This subsequence has the
highest sum of 106.
Example 2:

Input: N = 5
A = {4, 2, 5, 3, 4}
Output: {4, 5}
Explaination: Here the subsequence {2, 3,
4} also  provides the sum 9. But that
ends at index 4. So, answer here is the
sequence {4, 5} which ends at 2nd index.
Your Task:
You do not need to read input or print anything. Your task is to complete the function maxSumSequence() which takes the array and N and returns the sequence.

Expected Time Complexity: O(N*N)
Expected Auxiliary Space: O(N)

Constraints:
1 ≤ N ≤ 1000
1 ≤ A[ i ] ≤ 10000
*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String arr[] = in.readLine().trim().split("\\s+");
            int A[] = new int[N];
            for(int i = 0;i < N;i++)
                A[i] = Integer.parseInt(arr[i]);
            
            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            ans = ob.maxSumSequence(N, A);
            StringBuilder output = new StringBuilder();
            int size = ans.size();
            for(int i = 0;i < size;i++)
                output.append(ans.get(i)+" ");
            System.out.println(output);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static List<Integer> maxSumSequence(int n, int arr[])
    {
        // code here
        List<List<Integer>> aux=new ArrayList<>();
        int[] dp=new int[n];
        for (int i = 0; i < n; i++) {
            aux.add(new ArrayList<>());
        }
        for(int i=0; i<n; i++){
            int maxSum=0;
            for(int j=0; j<i; j++){
                if(arr[j]<arr[i] && maxSum<dp[j]){
                    //finding the max sum
                    maxSum=dp[j];
                    //putting the elements in form of subarray until this point
                    aux.set(i, new ArrayList<>(aux.get(j)));
                }
            }
            //considering adding i here
            aux.get(i).add(arr[i]);
            dp[i]=maxSum+arr[i];
        }

        List<Integer> res=new ArrayList<>();
        int max=Integer.MIN_VALUE;
//finding the first max even if duplicates of max are present
        for(int i=0; i<n; i++){
            if(max<dp[i]){
                max=dp[i];
                res=new ArrayList(aux.get(i));
            }
        }
        return res;
    }
}
