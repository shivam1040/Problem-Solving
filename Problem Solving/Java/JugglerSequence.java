/*
Juggler Sequence is a series of integers in which the first term starts with a positive integer number a and the remaining terms are generated from the immediate previous term using the below recurrence relation:

Juggler Formula

Given a number N, find the Juggler Sequence for this number as the first term of the sequence.


Example 1:

Input: N = 9
Output: 9 27 140 11 36 6 2 1
Explaination: We start with 9 and use 
above formula to get next terms.
 

Example 2:

Input: N = 6
Output: 6 2 1
Explaination: 
61/2 = 2. 
21/2 = 1.
 

Your Task:
You do not need to read input or print anything. Your Task is to complete the function jugglerSequence() which takes N as the input parameter and returns a list of integers denoting the generated sequence.

 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

 

Constraints:
1 ≤ N ≤ 100
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
            int N = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            StringBuilder out = new StringBuilder();
            ans = ob.jugglerSequence(N);
            for(int i = 0;i < ans.size();i++)
                out.append(ans.get(i) + " ");
            System.out.println(out);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static List<Integer> jugglerSequence(int N){
        // code here
        List<Integer> aux=new ArrayList<Integer>();
        aux.add(N);
        
        while(N>1){
            if(N%2==0){
                N=(int)Math.pow(N, .5);
                aux.add(N);
            }
            else{
                N=(int)Math.pow(N, 1.5);
                aux.add(N);
            }
        }
        
        return aux;
    }
}
