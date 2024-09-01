/*
Given a number N. Find the values of a and b such that a/b is the largest proper fraction and a + b = N. Following are constraints for fraction.
1. a/b is a proper fraction if a is less than b and a and b are co-primes i.e no common factor of a and b.
2. There can be multiple proper fractions with the sum of numerator and denominator equal to a given number. The main task is to find values of a and b for which the fraction is having the maximum floating point value.

Example 1:

Input: N = 3
Output: a = 1, b = 2
Explaination: Here a and b are coprime and it
satisfies the condition of question.
Example 2:

Input: N = 12
Output: 5 7
Explaination: Here the a, b pair is 5 and 7.
Your Task:
You do not need to read input or print anything. Your task is to complete the function largestFraction() which takes N as input parameter and returns a, b which satisfies the given condition of the question.

Expected Time Complexity: O(1)
Expected Auxiliary Space: O(1)

Constraints:
3 ≤ N ≤ 106


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
            int N = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            ans = ob.largestFraction(N);
            System.out.println(ans.get(0) + " " + ans.get(1));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static List<Integer> largestFraction(int n)
    {
        // code here
        List<Integer> res=new ArrayList<>();
        
        if(n%2!=0){
            res.add(n/2);
            res.add(n/2+1);
        }
        else{
            if((n/2)%2==0){
                res.add(n/2-1);
                res.add(n/2+1);
            }
            else{
                res.add(n/2-2);
                res.add(n/2+2);
            }
        }
        return res;
    }
}
