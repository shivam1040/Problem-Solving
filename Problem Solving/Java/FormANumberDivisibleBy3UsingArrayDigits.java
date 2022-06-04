/*
Given an array arr of integers of length N, the task is to find whether it’s possible to construct an integer using all the digits of these numbers such that it would be divisible by 3. If it is possible then print “1” and if not print “0”.

Example 1:

Input: N = 3
arr = {40, 50, 90}
Output: 1
Explaination: One such number is 405900.
Example 2:

Input: N = 2
arr = {1, 4}
Output: 0
Explaination: The numbers we can form 
are 14 and 41. But neither of them are 
divisible by 3.
Your Task:
You do not need to read input or print anything. Your task is to complete the function isPossible() which takes N and arr as input parameters and returns 1 if we can form a number by the digits of the given number, otherwise returns 0.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ N, arr[i] ≤ 105
*/

// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(in.readLine());
            String a[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(a[i]);

            Solution ob = new Solution();
            System.out.println(ob.isPossible(N, arr));
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution {
    static int isPossible(int N, int arr[]) {
        int rem=0;
        for(int i=0; i<N; i++){
            rem=(rem+arr[i])%3; //as we know that a number is divisible by 3 if it's digit sum are also divisibleby 3, hence in this approach we are trying to find if there is a such number by modding every element with 3 and adding the remainer to element in next iteration of modding
        }
        return rem==0 ? 1 : 0;
    }
}