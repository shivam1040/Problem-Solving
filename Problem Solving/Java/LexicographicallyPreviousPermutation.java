/*
Given a string s, find lexicographically previous permutation of it.
For example: Lexicographically previous permutation of “4321” is “4312". If the string is sorted in ascending order, then the lexicographically previous permutation doesn’t exist.

Example 1:

Input: s = "4321"
Output: "4312" 
Explanation: lexicographically previous
permutation of “4321” is “4312”
Example 2:

Input: s = "1234"
Output: "None"
Explanation: "1234" is sorted in
ascending order, hence "None". 
Your Task:  
You dont need to read input or print anything. Complete the function prevPermutation() which takes string s as input parameter and returns lexicographically previous permutation of s and if there is no lexicographically previous permutation of s, it returns "None".

Expected Time Complexity: O(|s|)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ |s| ≤ 103


*/

/*
Find largest index i such that str[i – 1] > str[i].
Find largest index j such that j >= i and str[j] < str[i – 1].
Swap str[j] and str[i – 1].
Reverse the sub-array starting at str[i].
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
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String s = br.readLine();
            Solution ob = new Solution();
            System.out.println(ob.prevPermutation(s));
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution
{
    public String prevPermutation(String s)
    {
        // code here
        int i=s.length()-2;
        
        while(i>=0 && s.charAt(i)<=s.charAt(i+1))
            i--;
        if(i<0)
            return "None";
        
        int j=s.length()-1;
        
        while(j>i && s.charAt(j)>=s.charAt(i))
            j--;
            
         char ch[]=s.toCharArray();
            // Swap the pivot with the rightmost element that's smaller than the pivot
        swap(ch, i, j);
       
          // Reverse the suffix
        reverse(ch, i + 1, s.length() - 1);
        return new String(ch);
    }
     
      // function for swapping
    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
     
    // function for reversing
    private void reverse(char[] arr, int i, int j) {
        while (i < j) {
            swap(arr, i, j);
            i++;
            j--;
        }
    }
}
