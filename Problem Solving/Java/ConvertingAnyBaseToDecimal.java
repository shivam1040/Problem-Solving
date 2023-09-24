/*
Given a number N and its base b, convert it to decimal. The base of number can be anything such that all digits can be represented using 0 to 9 and A to Z. Value of A is 10, value of B is 11 and so on.

Example 1:

Input: b = 2, N = 1100
Output: 12
Explaination: It is a binary number whose 
decimal equivalent is 12.
Example 2:

Input: b = 16, N = A
Output: 10
Explaination: It's a hexadecimal number whose 
decimal equivalent is 10.
Your Task:
You do not need to read input or print anything. Your task is to complete the function decimalEquivalent() which takes N and b as input parameters and returns their decimal equivalent. Otherwise return -1 if N is not possible.

Expected Time Complexity: O(|N|)   [|N| means the length of the number N]
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ b ≤ 16
1 ≤ N < decimal equivalent 109


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
            int b = Integer.parseInt(in.readLine());
            String N = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.decimalEquivalent(N, b));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int decimalEquivalent(String N, int b)
    {
        // code here
        int dec=0, k=N.length()-1;
        
        for(char i:N.toCharArray()){
            //doing addition with 10 for number beyond base 10, basically converting them to decimal
            int digit=Character.isDigit(i) ? i-'0' : i-'A'+10;
            
            if(digit>=b)
                return -1;
                //convertiting to digit to decimal
            dec+=digit*Math.pow(b, k--);
        }
        return dec;
    }
}
