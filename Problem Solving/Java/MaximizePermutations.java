/*
Given two numbers N and M. Construct maximal number by permuting (changing order) the digits of N, not exceeding M.
It is allowed to leave N as it is. If there's no Permutation of digits of N which doesn't exceed M, then print -1.
Note : Answer shouldn't have any leading zeroes.

Example 1:

Input:
N = 123
M = 222
Output:
213
Explanation: There are total 3! permutations 
possible for N = 123, but the only permutation 
that satisfies the given condition is 213.
Example 2:

Input:
N =  3921
M = 10000
Output:
9321
Explanation: Among all the Possible Permutations,
9321 is Maximum.
Your Task:
You don't need to read input or print anything. Your task is to complete the function maxPerm() which takes two Integers N and M as input parameters and returns the answer.

Expected Time Complexity: O(|N|2)
Expected Auxiliary Space: O(|N|)

Constraints:
1 ≤ A, B ≤ 107
*/

/*
Let’s construct the answer digit by digit starting from the leftmost. We are asked to build a lexicographically maximal answer. So in this order, we should choose the greatest digit on each step. The approach is to iterate over all possible digits starting from the greatest. For each digit check if it’s possible to put it in this position and compare the resulting number with the number M. If it comes less than or equal to the value of M, then proceed to the next digit.
*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(S[0]);
            int M = Integer.parseInt(S[1]);

            Solution ob = new Solution();
            System.out.println(ob.maxPerm(N,M));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    static int maxPerm(int NN , int M) {
        // code here
       String N = String.valueOf(NN);
       N=sortString(N, 0, N.length());
 
        for (int i = 0; i < N.length(); i++) {
            for (int j = i + 1; j < N.length(); j++) {
 
                // Copying the string into another
                // temp string.
                String t = N;
 
                // Swapping the j-th char(digit)
                // with i-th char(digit)
                t = swap(t, j, i);
 
                // Sorting the temp string
                // from i-th pos to end.
                t = sortString(t, j, t.length());
 
                // Checking if the string t is
                // greater than string N and less
                // than or equal to the number M.
                if (Long.parseLong(t) > Long.parseLong(N)
                    && Long.parseLong(t) <= M)
 
                    // If yes then, we will permanently
                    // swap the i-th char(or digit)
                    // with j-th char(digit).
                    N = swap(N, i, j);
            }
        }
 
        // Returns the maximized number.
        return Integer.parseInt(N) > M ? -1 : Integer.parseInt(N);
    }
    
     private static String swap(String str, int i, int j)
    {
        char ch[] = str.toCharArray();
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
        return new String(ch);
    }
 
    private static String sortString(String string, int s_index, int e_index)
    {
        char tempArray[] = string.toCharArray();
        // Sorting temp array using
        Arrays.sort(tempArray, s_index, e_index);
        // returning the new sorted string
        return new String(tempArray);
    }
};
