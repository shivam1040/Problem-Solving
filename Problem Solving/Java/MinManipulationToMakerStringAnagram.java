/*
Given two strings in lowercase, your task is to find minimum number of manipulations required to make two strings anagram without deleting any character. If two strings contains same data set in any order then strings are called Anagrams.

Example 1:

Input:
S1 = "aba", S2 = "baa", N = 3
Output: 0
Explanation: Both the strings are already
anagrams.
â€‹Example 2:

Input: 
S1 = "ddcf", S2 = "cedk", N = 4
Output: 2
Explanation: We can change 'e' and 'k' in
S2 to 'd' and 'f' to make both the strings
anagram. 

Your Task:
You don't need to read input or print anything. Your task is to complete the function minManipulation() which takes the strings S1 and S2 and their length N as inputs and returns the minimum number of manipulations required to make both the strings anagram.


Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).


Constraints:
1<=N<=105

|S1| = |S2| = N

|S| represents the length of the string S.
*/

//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            int N = Integer.parseInt(read.readLine().trim());
            String []input_line = read.readLine().trim().split("\\s+");
            String S1 = input_line[0];
            String S2 = input_line[1];
            Solution obj = new Solution();
            int ans = obj.minManipulation(N, S1, S2); 
            System.out.println(ans);
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    int minManipulation(int N, String S1, String s2) 
    {
        // code here
     int count = 0;
 
        // store the count of character
        int char_count[] = new int[26];
 
        // iterate though the first String and update
        // count
        for (char c:S1.toCharArray())
            char_count[c - 'a']++;       
 
        // iterate through the second string
        // update char_count.
        // if character is not found in char_count
        // then increase count
        for (char c:s2.toCharArray())
        {
            char_count[c - 'a']--;
        }
       
        for(int c: char_count)
        {
        
            count+= Math.abs(c);

        }
         
         //this division is there cause we get the manipulation required for both strings so that becomes /2 for finding manipulation required only in one string
        return count / 2;
    }
} 
