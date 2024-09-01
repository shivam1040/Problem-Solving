/*
 Given a string S which contains only small letters. The task is to make a square matrix from string S. Then perform the following operations.
1. In each column delete the characters which occur more than one.
2. Let the characters in order be abcd....wxyz then print them in order azbycxdw....  
For example, after operation 1 if the remaining characters in a column are cedjki then after sorting they become cdeijk , now when printed in the given order the output will be ckdjei. If there's no character remaining Print 0.

Note: Length of the Input String is always a Perfect Square.

 

Example 1:

Input:
S = "adgkbdhlceilcfjm"
Output:
abefgjhikm
Explanation:
Matrix will be
a d g k
b d h l
c e i  l
c f  j m
In 1st column 'c', in 2nd column 'd' and in
4th column 'l' has occurred more than once.
So after deleting them and sorting the
remaining characters the matrix become 

   a - g  k
   b - h  -
   - e i   -
   - f  j  m 

So after operation 2 we get 'ab' from 1st
column, 'ef' from 2nd column, 'gjhi' from
3rd column and 'km' from 4th column. Appending
all of them we get the output as  "abefgjhikm".
Example 2:

Input:
S = "abcabcabc"
Output:
0
Explanation:
Matrix will be
a b c
a b c
a b c
So, There will be no letters remaining
and the output will be 0. 
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function matrixGame() which takes a String S and returns the answer.

 

Expected Time Complexity: O(|S|)
Expected Auxiliary Space: O(|S|)

 

Constraints
1 <= |S| <= 105


*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String S = read.readLine();

            Solution ob = new Solution();

            System.out.println(ob.matrixGame(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static String matrixGame(String S){
        // code here
        int size=(int)Math.sqrt(S.length()), k=0;
        char aux[][]=new char[size][size];
        Set<Character> aux1=new HashSet<>();
        StringBuilder sb = new StringBuilder();
        //create aaray
        for (int i = 0; i < S.length(); i++)
            aux[i / size][i % size] = S.charAt(i);
        for (int col = 0; col < size; col++) {
            //create freq count for a column
            int[] h = new int[26];
            for (int row = 0; row < size; row++) 
                h[aux[row][col] - 'a']++;
            StringBuilder t = new StringBuilder();
            //create temp string of char in column having freq 1
            for (int row = 0; row < size; row++) 
                if (h[aux[row][col] - 'a'] == 1) 
                    t.append(aux[row][col]);
            int l = 0, r = t.length() - 1;
            //alternativel store res of a column in final res
            while (l <= r) {
                sb.append(t.charAt(l++));
                if (l <= r) sb.append(t.charAt(r--));
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
};
