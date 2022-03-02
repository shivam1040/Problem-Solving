/*
Given an array of size N-1 such that it only contains distinct integers in the range of 1 to N. Find the missing element.

Example 1:

Input:
N = 5
A[] = {1,2,3,5}
Output: 4
Example 2:

Input:
N = 10
A[] = {6,1,2,8,3,4,7,10,5}
Output: 9

Your Task :
You don't need to read input or print anything. Complete the function MissingNumber() that takes array and N as input  parameters and returns the value of the missing number.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)


Constraints:
1 ≤ N ≤ 106
1 ≤ A[i] ≤ 106
*/
/*
Method 2: This method uses the technique of XOR to solve the problem.  


Approach: 
XOR has certain properties 
Assume a1 ^ a2 ^ a3 ^ ...^ an = a and a1 ^ a2 ^ a3 ^ ...^ an-1 = b
Then a ^ b = an
Algorithm: 
Create two variables a = 0 and b = 0
Run a loop from 1 to n with i as counter.
For every index update a as a = a ^ i
Now traverse the array from start to end.
For every index update b as b = b ^ array[i]
Print the missing number as a ^ b.
*/
// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            int[] array = new int[n - 1];
            for (int i = 0; i < n - 1; i++) {
                array[i] = Integer.parseInt(str[i]);
            }
            Solution sln = new Solution();
            System.out.println(sln.MissingNumber(array, n));
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution {
    int MissingNumber(int a[], int n) {
        int x1 = a[0];
        int x2 = 1;

        /* For xor of all the elements 
           in array */
        for (int i = 1; i < a.length; i++)
            x1 = x1 ^ a[i];

        /* For xor of all the elements 
           from 1 to n+1 */
        for (int i = 2; i <= a.length + 1; i++)
            x2 = x2 ^ i;

        return (x1 ^ x2);
    }
}