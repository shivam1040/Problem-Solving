/*
Given an array and two integers say, x and y, find the number of sub-arrays in which the number of occurrences of x is equal to number of occurrences of y.

Example 1:

Input:
n = 3, x = 1, y = 2
arr[] = {1, 2, 1}
Output: 2
Explanation:
The possible sub-arrays have same equal 
number of occurrences of x and y are:
1) {1, 2}, x and y have same occurrence(1).
2) {2, 1}, x and y have same occurrence(1).
Example 2:

Input:
n = 3, x = 4, y = 6
arr[] = {1, 2, 1}
Output: 6
Explanation:
The possible sub-arrays have same equal 
number of occurrences of x and y are:
1) {1}, x and y have same occurrence(0).
2) {2}, x and y have same occurrence(0).
3) {1}, x and y have same occurrence(0).
4) {1, 2}, x and y have same occurrence(0).
5) {2, 1}, x and y have same occurrence(0).
6) {1, 2, 1}, x and y have same occurrence(0).
Your Task:
You don't need to read input or print anything. Your task is to complete the function sameOccurrence() which takes the array of integers arr, n, x and y as parameters and returns an integer denoting the answer.

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(n)

Constraints: 
1 <= n <= 105
1 <= arr[i], x, y<=106
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
            int x = Integer.parseInt(inputLine[1]);
            int y = Integer.parseInt(inputLine[2]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            long ans = new Solution().sameOccurrence(arr, n, x, y);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java




class Solution {
    long sameOccurrence(int[] arr, int n, int x, int y) {
        // code here
        Map<Long, Long> aux=new HashMap<>();
        long res=0, sum=0;
        
        if(x==y)
            return (n*(n+1))/2;
        aux.put(0L, 1L);
        for(int i:arr){
            if(i==x)
                sum+=x;
            else if(i==y)
                sum-=x;
            if(aux.containsKey(sum))
                res+=aux.get(sum);
            aux.put(sum, aux.getOrDefault(sum, 0L)+1L);
        }
        return res;
    }
}

