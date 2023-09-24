/*
Given two integer numbers a and b, the task is to find count of all common divisors of given numbers.

Example 1:

Input: a = 12, b = 24
Output: 6 
Explanation: all common divisors 
are 1, 2, 3, 4, 6 and 12.

Example 2:

Input: a = 3, b = 17
Output: 1
Explanation: all common divisors are 1.

Your Task:  
You dont need to read input or print anything. Complete the function commDiv() which takes n as input parameter and returns the number of common divisors.

Expected Time Complexity: O(sqrt(n))
Expected Auxiliary Space: O(1)

Constraints:
1<= a,b <=1000
*/

//{ Driver Code Starts
//Initial Template for Java
//Initial Template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String[] S = new String[2];
            S = read.readLine().split(" "); 
            long a = Integer.parseInt(S[0]);
            long b = Integer.parseInt(S[1]);
            Solution ob = new Solution();

            System.out.println(ob.commDiv(a, b));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    static long commDiv(long a, long b){
        // code here
        //find gcd then find its divisor
        long gcd=gcd(a, b);
        long res=0;
        
        for(int i=1; i<=Math.sqrt(gcd); i++){
            if(gcd%i==0){
            if(gcd/i==i)
                res+=1;
            else
                res+=2;
        }
        }
        return res;
    }
    
    private static long gcd(long a, long b){
          if (a == 0)
            return b;
 
        return gcd(b % a, a);
    }
}
