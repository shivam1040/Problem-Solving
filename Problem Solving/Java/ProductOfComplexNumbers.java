/*
Given two arrays A[] and B[] of real and imaginary part of 5 complex numbers, find the product of these five Complex numbers The array A[] contains the real part and B[] contains the imaginary part. So, if A[0] is 5 and B[0] is 4, the complex numbers is (5 + 4i).

 

Example 1:

Input:
A[] = {1, 2, 3, 4, 5}
B[] = {0, 0, 0, 0, 0}
Output:
120 0
Explanation:
We are to multiply the 5 complex numbers
and so (1+0i)*(2+0i)*(3+0i)*(4+0i)*(5+0i).
We can see that answer is 120 + 0i.
Example 2:

Input:
A[] = {1, 2, 3, 4, 5}
B[] = {1, 2, 3, 4, 5}
Output:
-480 -480
Explanation:
(1+1i)*(2+2i)*(3+3i)*(4+4i)*(5+5i)= -480-480i 
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function complexProduct() which takes 2 arrays A[] and B[], both of length 5 as input and returns a vector of two integers, the first one being the real part and the second being the imaginary part of the product of these 5 complex Numbers.

 

Expected Time Complexity: O(1)
Expected Auxiliary Space: O(1)

 

Constraints:
1 <= A[i], B[i] <= 50
*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {

            String S[] = read.readLine().split(" ");
            String S1[] = read.readLine().split(" ");
            
            int[] A = new int[5];
            int[] B = new int[5];
            
            for(int i=0 ; i<5 ; i++)
                A[i] = Integer.parseInt(S[i]);
            for(int i=0 ; i<5 ; i++)
                B[i] = Integer.parseInt(S1[i]);

            Solution ob = new Solution();
            int[] ptr = ob.complexProduct(A,B);
        
            System.out.println(ptr[0] + " " + ptr[1]);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    static int[] complexProduct(int[] A , int[] B) {
        // code here
        int r=A[0], ip=B[0];
        
        for(int i=1; i<5; i++){
            int temp=r;
            r=r*A[i]-ip*B[i];
            ip=ip*A[i]+temp*B[i];
        }
        return new int[]{r, ip};
    }
};
