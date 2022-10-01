/*
Given a string s of lowercase alphabets and a number k, the task is to print the minimum value of the string after removal of k characters. The value of a string is defined as the sum of squares of the count of each distinct character.
 

Example 1:

Input: s = abccc, k = 1
Output: 6
Explaination:
We remove c to get the value as 12 + 12 + 22
 

Example 2:

Input: s = aabcbcbcabcc, k = 3
Output: 27
Explaination: We remove two 'c' and one 'b'. 
Now we get the value as 32 + 32 + 32.

Your Task:
You do not need to read input or print anything. Your task is to complete the function minValue() which takes s and k as input parameters and returns the minimum possible required value.

 

Expected Time Complexity: O(N+Klog(P))  where N is the length of string and P is number of distinct alphabets and K number of alphabets to be removed 
Expected Auxiliary Space: O(N)

 

Constraints:
1 ≤ k ≤ |string length| ≤ 100
*/

//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String s = in.readLine();
            int k = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.minValue(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static int minValue(String s, int k){
        // code here
        Map<Character, Integer> aux=new HashMap<>();
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        int res=0;
        
        for(int i=0; i<s.length(); i++)
            aux.put(s.charAt(i), aux.getOrDefault(s.charAt(i), 0)+1);
        for(int i: aux.values())
            q.add(i);
        //deleting max values one by one until k is zero, just to ensure we are removing high frequency character
        while(k!=0){
            q.add(q.poll()-1);
            k--;
        }
        //finding the square for res according to question
        while(!q.isEmpty())
            res+=q.peek()*q.poll();
        return res;
    }
}
