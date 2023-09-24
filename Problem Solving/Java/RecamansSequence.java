/*
Given an integer n. Print first n elements of Recaman’s sequence.
It is basically a function with domain and co-domain as natural numbers and 0. It is recursively defined as below:
Specifically, let a(n) denote the (n+1)-th term. (0 being already there).
The rule says:

a(0) = 0
a(n) = a(n-1) - n      if a(n-1) - n > 0 and is not already present in the sequence
       =  a(n-1) + n    otherwise.

Example 1:

Input: n = 6
Output: 0 1 3 6 2 7
Explaination: Follow the rule and this 
will be the output.
Example 2:

Input: n = 3
Output: 0 1 3
Explaination: If the rule is followed, 
it will produce this output.
Your Task:
You do not need to read input or print anything. Your task is to complete the function recamanSequence() which takes n as the input parameter and returns the sequence.

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(n)

Constraints:
1 ≤ n ≤ 100
*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.recamanSequence(n);
            for(int i = 0;i < n;i++)
                System.out.print(ans.get(i)+" ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static ArrayList<Integer> recamanSequence(int n){
        // code here
        ArrayList<Integer> res=new ArrayList<>();
        
        res.add(0);
        res.add(1);
        
        for(int i=2; i<n; i++){
            if(res.get(i-1)-i>0 && !res.contains(res.get(i-1)-i))
                res.add(res.get(i-1)-i);
            else
                res.add(res.get(i-1)+i);
        }
        return res;
    }
}
