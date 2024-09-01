/*
Connell Sequence is the sequence formed with the first odd number, i.e 1 as its first term. The subsequent terms of the sequence are made up of the first two even numbers, i.e 2 and 4, followed by the next three odd numbers, i.e 5, 7 and 9, followed by the next four even numbers, i.e 10, 12, 14 and 16 and so on …. 
Given an integer n, generate the first n terms of the Connell Sequence.


Example 1:

Input: n = 6
Output: 1 2 4 5 7 9
Explaination: First one odd number. Then 
two even numbers. Then three odd numbers.
 

Example 2:

Input: n = 2
Output: 1 2
Explaination: The sequence consists of first 
odd number then one even number.
 

Your Task:
You do not need to read input or print anything. Your task is to complete the function connellSequence() which takes n as input parmeters and returns a list of integers containing the first n numbers of the Connell sequence.

 

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(n)

 

Constraints:
1 ≤ n ≤ 105  


*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            StringBuilder out = new StringBuilder();
            ans = ob.connellSequence(n);
            for(int i = 0;i < ans.size();i++)
                out.append(ans.get(i) + " ");
            System.out.println(out);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static List<Integer> connellSequence(int n){
        // code here
        List<Integer> res=new ArrayList<>();
        
        for(int i=1; i<=n; i++)
            res.add(2*i-(int)Math.floor((1+Math.sqrt(8*i-7))/2));
        return res;
    }
}
