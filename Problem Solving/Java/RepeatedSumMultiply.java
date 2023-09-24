/*
You are given a natural number. Repeatedly sum its digits until the smallest possible two-digit number remains. Then multiply the digits of the remaining two-digit number and return it.

Example 1:

Input: n = 19
Output: 0 
Explanation: 1+9 = 1+0 = 1 and 1 came from 10 
thus 1*0 = 0.
Example 2:

Input: n = 129
Output: 2
Explanation: 1+2+9 = 1+2 = 3 and 3 came from 12
thus 1*2 = 2.

Your Task:  
You don't need to read input or print anything. Complete the function repeatedSumMul() which takes n as the input parameter and returns the product of the digits of the value before the single digit.

Expected Time Complexity: O(logn)
Expected Auxiliary Space: O(1)

Constraints:
1<= N <=232
*/

//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.repeatedSumMul(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    static int repeatedSumMul(int n) {
        // code here
        n=sumOfDigits(n);
        while(sumOfDigits(n)>9){
            n=sumOfDigits(n);
        }
        int a = n%10;
            n/=10;
            int mult = a*(n%10);
            return mult;
    }
    
    static int sumOfDigits(int n)
    {
        int sum=0;
        while(n>0)
        {
            int temp = n%10;
            sum = sum + temp;
            n = n/10;
        }
        return sum;
    }
}
