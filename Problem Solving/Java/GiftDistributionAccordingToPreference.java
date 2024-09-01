/*
Geek wants to distribute gifts to N students. He buys N gifts and asks his students to make a list of gifts arranged in order of their preference. Each student has a unique rank based on their performance in Geek's class. The gifts are distributed based on a student's rank and gift preference. The list submitted by a student with a better rank is given more importance. Find what gift each student gets. 


Example 1:

Input:
N = 3
Arr[][] = { {Preference list of student 1},
            {Preference list of student 2},
            {Preference list of student 3},}
        = {{1, 3, 2}, {2, 1, 3}, {3, 1, 2}}
Output: 1 2 3
Explanation: According to the gift preference 
of child with rank 1, he gets gift 1. Rank 2 
prefers gift 2 and gets that. Rank 3 prefers 
gift 3 and gets that.

Example 2:

Input:
N = 3
Arr[][] = { {Preference list of student 1},
            {Preference list of student 2},
            {Preference list of student 3},}
        = {{1, 2, 3}, {3, 2, 1}, {1, 2, 3}}
Output: 1 3 2
Explanation: According to the gift preference 
of child with rank 1, he gets gift 1. Rank 2 
prefers gift 3 and gets that. Rank 3 prefers 
gift 1 but that was given to student with rank 1. 
Second on his list is gift 2 so he gets that.

Your Task:
You don't need to read input or print anything. Your task is to complete the function distributeGift() which takes the 2D array of integers arr and n as input parameters and returns an array of integers of size N denoting the gift that each student got in order of their ranks.


Expected Time Complexity: O(N2)
Expected Auxiliary Space: O(1)


Constraints:
1 <= N <= 103
Preference of each child is a permutation [1, N]


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
            int[][] arr = new int[n][n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(inputLine[i * n + j]);
                }
            }

            int[] ans = new Solution().distributeGift(arr, n);
            for (int xx : ans) {
                System.out.print(xx + " ");
            }
            System.out.println();
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution {
    int[] distributeGift(int[][] arr, int n) {
        // code here
        int temp[]=new int[n];
        int res[]=new int[n];
        
        for(int i=0; i<arr.length; i++)
            for(int j=0; j<arr[i].length; j++)
                if(temp[arr[i][j]-1]==0){
                    res[i]=arr[i][j];
                    temp[arr[i][j]-1]=1;
                    
                    break;
                }
        return res;
    }
}

