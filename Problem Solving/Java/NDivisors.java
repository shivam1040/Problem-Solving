/*
Given three integers A, B, N. Your task is to print the number of numbers between A and B including them, which have N-divisors. A number is called N-divisor if it has total N divisors including 1 and itself.
 

Example 1:

Input:
A = 1
B = 7
N = 2
Output:
4
Explanation:
2,3,5,7 have 2-divisors
Example 2:

Input:
A = 1
B = 25
N = 3
Output:
3
Explanation:
4,9,25 are the numbers
having 3-divisors

Your Task:
You don't need to read input or print anything. Your task is to complete the function count() which takes integer A, B and N as input parameters and returns an integer, the number of N-divisor number in between A and B inclusive.
 

Expected Time Complexity: O((B-A) sqrt (B))
Expected Space Complexity: O(1)
 

Constraints:
1<=A<=B<=104
1 <= N <= 16


*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S[] = read.readLine().split(" ");
            int A = Integer.parseInt(S[0]);
            int B = Integer.parseInt(S[1]);
            int N = Integer.parseInt(S[2]);
            Solution ob = new Solution();
            System.out.println(ob.count(A,B,N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution{
    static int count(int A,int B,int N){  
        // code here
        int res=0;
        
        for(int i=A; i<=B; i++){
            if(factors(i)==N)
                res++;
        }
        return res;
    }
    
        public static int factors(int n)
    {
        int res=0;
        
        for(int i=1; i<=Math.sqrt(n); i++){
            if(n%i==0){
                res++;
                if(i!=n/i)
                    res++;
            }
        }
        return res;
    }
}
