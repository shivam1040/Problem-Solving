/*
Given an array arr[] of N elements containing first N positive integers. You have to sort the integers in ascending order by the following operation. Operation is to pick an integer and place it at end or at start. Every such operation increases cost by one. The task is to sort the array in the minimum cost

Example 1:

Input: N = 3
arr = {2, 1, 3}
Output: 1
Explaination: Place 1 at start.
Example 2:

Input: N = 4
arr = {4, 3, 1, 2}
Output: 2
Explaination: First place 3 at end then 
4 at end.
Your Task:
You do not need to read input or print anything. Your task is to complete the function sortingCost() which takes the value N and arr as input parameters and returns the minimum cost of sorting.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

Constraints:
1 ≤ N ≤ 105
1 ≤ arr[i] ≤ 105


*/

//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String a[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(a[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.sortingCost(N, arr));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static int sortingCost(int N, int arr[]){
        // code here
        //https://www.youtube.com/watch?v=5WT9o2IzmZU
        Map<Integer, Integer> aux=new HashMap<>();
        //longest consecutive
        int lcs=0;
        
        for(int i:arr){
            int countOfConsecutiveUntilLast=aux.getOrDefault(i-1, 0);
            aux.put(i, countOfConsecutiveUntilLast+1);
            lcs=Math.max(lcs, countOfConsecutiveUntilLast+1);
        }
        //maximum lcs - length should give number of swaps required
        return N-lcs;
    }
}
