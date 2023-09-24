/*
Every number whose unit’s digit is 3 has a repunit as its multiple. A repunit is a number which has only ones. It is of the form (10n – 1)/9. Example: 3 divides 111, 13 divides 111111.
A positive integer N will be given whose unit’s digit is 3. The task is to find the number of 1s in the smallest repunit which is divisible by the given number N.

Example 1:

Input: N = 3
Output: 3
Explaination: The number 111 is the first 
repunit which is divisible by 3.
Example 2:

Input: N = 13
Output: 6
Explaination: The first repunit is 111111 
which divisible by 13.
Your Task:
You do not need to read input or print anything. Your task is to complete the function repUnit() which takes N as input parameter and returns the number of 1 in the smallest repunit which is divisible by N.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ N ≤ 106  


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
            System.out.println(ob.repUnit(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int repUnit(int N){
        // code here
    int repunit = 1;
    int length = 1;
//create the sequence by appending 1    
    while (repunit != 0){
        repunit = (repunit * 10 + 1) % N;
        length += 1;
    }
    
    return length;
    }
}

