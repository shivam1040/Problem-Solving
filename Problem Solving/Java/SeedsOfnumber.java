/*
A Seed of a number n is a number x such that multiplication of x with its digits is equal to n. The task is to find all seeds of a given number n. x should not be equal to n. If no seed exists, then print -1.

Example 1:

Input: n = 138
Output: 23
Explaination: 23 is a seed of 138 because 
23*2*3 = 138.
Example 2:

Input: n = 3
Output: -1
Explaination: There is no seed of 3.
Your Task:
You do not need to read input or print anything. Your task is to complete the function seeds() which takes n as input parameter and returns the seeds of the number.

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ n ≤ 1000
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
            List<Integer> ans = new ArrayList<Integer>();
            ans = ob.seeds(n);
            StringBuilder out = new StringBuilder();
            for(int i = 0;i < ans.size();i++)
                out.append(ans.get(i) + " ");
            System.out.println(out);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static List<Integer> seeds(int n){
        // code here
        List<Integer> res=new ArrayList<>();
        
        for(int i=1; i<n; i++){
            int m=i, c=i;
            
            while(c>0){
                int digit=c%10;
                c/=10;
                m*=digit;
            }
            if(m==n)
                res.add(i);
        }
        if(res.size()==0)
            res.add(-1);
        return res;
    }
}
