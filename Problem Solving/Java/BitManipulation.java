/*
Given a 32 bit unsigned integer num and an integer i. Perform following operations on the number - 

1. Get ith bit

2. Set ith bit

3. Clear ith bit

Note : For better understanding, we are starting bits from 1 instead 0. (1-based)

Example 1:

Input: 70 3
Output: 1 70 66
Explanation: Bit at the 3rd position from LSB is 1. (1 0 0 0 1 1 0)
The value of the given number after setting the 3rd bit is 70. 
The value of the given number after clearing 3rd bit is 66. (1 0 0 0 0 1 0)
Example 2:

Input: 8 1
Output: 0 9 8
Explanation: Bit at the first position from LSB is 0. (1 0 0 0)
The value of the given number after setting the 1st bit is 9. (1 0 0 1)
The value of the given number after clearing 1st bit is 8. (1 0 0 0)
 

Your Task:

Complete the function bitManipulation() which takes two integers num and i as input and prints the results after each operation separted by a space in the same line. You don't have to print any new lines after printing the output, that will be handled by driver code.

 

Constraints:

0<=num<=109

1<=i<=32
*/

//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int i = sc.nextInt();

            Solution obj = new Solution();
            obj.bitManipulation(n, i);
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static void bitManipulation(int num, int i) {
        // code here
         int getBit = (num & (1<<(i-1)))>> (i-1);

        int setBit = num | (1<< (i-1));

        int clearBit = num & ~(1<<(i-1));
        
        System.out.print(getBit+" "+setBit+" "+clearBit);
    }
}

