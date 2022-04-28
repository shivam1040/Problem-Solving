/*
Given three integers  'A' denoting the first term of an arithmetic sequence , 'C' denoting the common difference of an arithmetic sequence and an integer 'B'. you need to tell whether 'B' exists in the arithmetic sequence or not.

Example 1:

Input: A = 1, B = 3, C = 2
Output: 1
Explaination: 3 is the second term of the 
sequence starting with 1 and having a common 
difference 2.
Example 2:

Input: A = 1, B = 2, C = 3
Output: 0
Explaination: 2 is not present in the sequence.
Your Task:
You do not need to read input or print anything. Your task is to complete the function inSequence() which takes A, B and C and returns 1 if B is present in the sequence. Otherwise, returns 0.

Expected Time Complexity: O(1)
Expected Auxiliary Space: O(1)

Constraints:
-109 ≤ A, B, C ≤ 109  
*/

// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String arr[] = in.readLine().trim().split("\\s+");
            int A = Integer.parseInt(arr[0]);
            int B = Integer.parseInt(arr[1]);
            int C = Integer.parseInt(arr[2]);
            
            Solution ob = new Solution();
            System.out.println(ob.inSequence(A, B, C));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static int inSequence(int A, int B, int C){
         if(C==0) // if common diff is 0 , then A and B must be same , therefore return 1;
           return A==B?1:0; // But if Common diff = 0 , and A , B are not same , then it is not Arithmetic progression in that case will return 0
           
           if(B<A && C>0) return 0; //if common difference is positive , then B should be positive
           
           if(B>A && C<0) return 0; //if common difference is negative , then B should be negative 
           
           int n = ((B-A)/C)+1; // nth number
           
           return (A+(n-1)*C==B?1:0);// using  Formula an = a + (n-1)d , here a = first term , n = nth number , d = common diff  , an = nth term
          // if B is part of arithmetic  then it must be the nth term therefore return 1 else 0 
    }
}