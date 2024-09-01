/*
Geek is very fond of chocolates. But he can't reach the kitchen shelf which has 'N' chocolates. His family has K members and he can call any number of family members to help him out. After acquiring the chocolates, the family members that Geek called will first divide the chocolates amongst themsleves equally. They do this in such a way that they all get maximum number of chocolates. The remaining chocolates are given to Geek. 
Find the maximum number of chocolates that Geek can get.


Example 1:

Input: 
N = 15, K = 4
Output: 3
Explaination: 
Calling 1 member. Geek will get nothing. 
Calling 2 members. Geek will get 1 chocolate. 
Calling 3 members. Geek will get nothing. 
Calling 4 members. Geek will get 3 chocolates. 

Example 2:

Input: 
N = 19, K = 5
Output: 4
Explaination: 5 memebers will be called who will 
divide 15 chocolates among them. And 4 chocolates 
will be left for Geek. 

Your Task:
You do not need to read input or print anything. Your task is to complete the function maxChocolate() which takes N and K as input parameters and returns the maximum number of chocolates Geek can have.


Expected Time Complexity: O(min(N,K))
Expected Auxiliary Space: O(1)


Constraints:
1 ≤ N, K ≤ 105  
*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(a[0]);
            int K = Integer.parseInt(a[1]);
            
            Solution ob = new Solution();
            System.out.println(ob.maxChocolate(N, K));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int maxChocolate(int N, int K){
        // code here
        int res=0;
        
        for(int i=1; i<=K; i++)
            res=Math.max(res, N%i);
        return res;
    }
}
