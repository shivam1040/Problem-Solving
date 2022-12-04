/*
Given two arrays of integers A[] and B[] of size N and M, the task is to check if a pair of values (one value from each array) exists such that swapping the elements of the pair will make the sum of two arrays equal.

 

Example 1:

Input: N = 6, M = 4
A[] = {4, 1, 2, 1, 1, 2}
B[] = (3, 6, 3, 3)
Output: 1
Explanation: Sum of elements in A[] = 11
Sum of elements in B[] = 15, To get same 
sum from both arrays, we can swap following 
values: 1 from A[] and 3 from B[]
Example 2:

Input: N = 4, M = 4
A[] = {5, 7, 4, 6}
B[] = {1, 2, 3, 8}
Output: 1
Explanation: We can swap 6 from array 
A[] and 2 from array B[]
Your Task:
This is a function problem. You don't need to take any input, as it is already accomplished by the driver code. You just need to complete the function findSwapValues() that takes array A, array B, integer N, and integer M as parameters and returns 1 if there exists any such pair otherwise returns -1.

 

Expected Time Complexity: O(MlogM+NlogN).
Expected Auxiliary Space: O(1).

 

Constraints:
1 ≤ N, M ≤ 106
*/

// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


 // } Driver Code Ends
//User function Template for Java


class Solution
{
    long findSwapValues(long A[], int n, long  B[], int m)
    {
        // Your code goe
        //following an equation, s1-p+q=s2-q+p, 2q=s2-s1+2p
        long s1=0, s2=0;
        Set<Long> aux=new HashSet<Long>();
        for(int i=0; i<m; i++)
            aux.add(B[i]);
        for(int i=0; i<n; i++)
            s1+=A[i];
        for(int i=0; i<m; i++)
            s2+=B[i];
        for(int i=0; i<n; i++)
            if((s2-s1+2*A[i])%2==0 && aux.contains((s2-s1+2*A[i])/2))
                return 1;
        return -1;
    }
}



// { Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {
            String line = br.readLine();
            String[] q = line.trim().split("\\s+");
            int n =Integer.parseInt(q[0]);
            int m =Integer.parseInt(q[1]);
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            long a[] = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(a1[i]);
            }
            String line2 = br.readLine();
            String[] a2 = line2.trim().split("\\s+");
            long b[] = new long[m];
            for (int i = 0; i < m; i++) {
                b[i] = Long.parseLong(a2[i]);
            }
            Solution ob = new Solution();
            long ans = ob.findSwapValues(a,n,b,m);
            System.out.println(ans);
        }
    }
}




  // } Driver Code Ends
