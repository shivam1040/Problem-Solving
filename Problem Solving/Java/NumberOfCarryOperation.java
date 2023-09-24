/*
Given two numbers A and B, the task is to find the number of carry operations required when two numbers are added

Note: Both numbers are always of the same length.

 

Example 1:

Input:
A = 1234
B = 5678
Output: 
2
Explanation:
1234
+
5678
--------
6912
--------
4+8 = 2 and carry 1
carry+3+7 = carry 1
carry+2+6 = 9, carry 0
carry+1+5 = 6

So, there are 2 Carry Operations.
Example 2:

Input:
A = 555
B = 555
Output: 
3
Explanation:
555
+
555
--------
1110
--------
5+5 = 0 and carry 1
carry+5+5 = 0 carry 1
carry+5+5 = 0, carry 1

So, there are 3 Carry Operations.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function countCarry() which takes two Integers A and B and returns the answer.

 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

 

Constraints:
1 <= A, B <= 1018
*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String S[] = read.readLine().split(" ");
            
            Long A = Long.parseLong(S[0]);
            Long B = Long.parseLong(S[1]);

            Solution ob = new Solution();

            System.out.println(ob.countCarry(A,B));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int countCarry(Long a , Long b){
        // code here
        int res=0, c=0;
        
        do{
            if(a%10+b%10+c>=10){
                res++;
                c=1;
            }
            else
                c=0;
            a/=10;
            b/=10;
        }
        while(a>0 && b>0);
        return res;
    }
};
