/*
Given a string S, consisting only of ‘0’ and ‘1’, and also you are given an integer k. You are asked to find the sum of all unique substrings (in decimal notation) of length k in the string, such that string S is the repetition of these substrings.
 

Example 1:

Input:
010100010010 3
Output:
 6
Exaplanation:
Unique substrings are “010” and “100”.
The required sum is 2+4=6.
Example 2:

Input:
00100110 4
Output:
8
 

Your Task:
You don't need to read or print anything. Your task is to complete the function unique_substring_sum() which takes the binary string S as first parameter and k as the second parameter and returns the sum of unique substring (In decimal notation).If the string S can’t be split into substrings of length k without leaving any characters in the string return -1.
 

Expected Time Complexity:  O(n)
Expected Space Complexity: O(n)
 

Constraints:
1 <= length of string <= 1000
k will not exceed 20


*/

//{ Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        while(T-->0)
        {
            String S = sc.nextLine();
            String[] S1 = S.split(" ");
            String s = S1[0];
            int k = Integer.parseInt(S1[1]);
            Solution ob = new Solution();
            long  res  = ob.unique_substring_sum(s, k);
            System.out.println(res);
        }
    }
}


// } Driver Code Ends


//User function Template for Java


class Solution
{
    public long  unique_substring_sum(String s, int k)
    {
        // Code here
        Set<String> aux=new HashSet<>();
        int n=s.length();
        
        if(n%k!=0)
            return -1;
        for(int i=0; i<=n-k; i=i+k)
            aux.add(s.substring(i, i+k));
        long ans = 0;
        for (String it : aux) {
            long temp = Long.parseLong(it, 2);
            ans += temp;
        }
        return ans;
    }
}

