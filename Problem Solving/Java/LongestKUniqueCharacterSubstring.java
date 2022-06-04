/*
Given a string you need to print the size of the longest possible substring that has exactly K unique characters. If there is no possible substring then print -1.


Example 1:

Input:
S = "aabacbebebe", K = 3
Output: 7
Explanation: "cbebebe" is the longest 
substring with K distinct characters.
Example 2:

Input: 
S = "aaaa", K = 2
Output: -1
Explanation: There's no substring with K
distinct characters.

Your Task:
You don't need to read input or print anything. Your task is to complete the function longestKSubstr() which takes the string S and an integer K as input and returns the length of the longest substring with exactly K distinct characters. If there is no substring with exactly K distinct characters then return -1.


Expected Time Complexity: O(|S|).
Expected Auxiliary Space: O(1).


Constraints:
1 ≤ |S| ≤ 105
1 ≤ K ≤ 105
*/

// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        Map<Character, Integer> aux=new HashMap<Character, Integer>();
        int j=0, l=0, res=-1;
        for(int i=0; i<s.length(); i++){
            aux.put(s.charAt(i), aux.getOrDefault(s.charAt(i), 0)+1);
            l++;
            while(aux.size()>k){
                if(aux.get(s.charAt(j))>0)
                    aux.put(s.charAt(j), aux.get(s.charAt(j))-1);
                if(aux.get(s.charAt(j))<=0){
                    aux.remove(s.charAt(j));
                }
                j++;
            }
            if(aux.size()==k && (l-j)>res)
                res=l-j;
        }
        return res;
    }
}