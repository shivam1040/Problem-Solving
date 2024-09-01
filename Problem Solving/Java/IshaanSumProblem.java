/*
Ishaan is curious about numbers. He takes any 2 random numbers A and B. He wants to find out that whether A can be written as a sum of B distinct positive integers.Help him find out whether it is possible or not.

Example 1:

Input: A = 5, B = 2
Output: 1 
Explanation: 5 can be written as a 
sum of 2 numbers : 1+4 or 2+3.

Example 2:

Input: A = 6, B = 2
Output: 1
Explanation: 6 can be written as a 
sum of 2 numbers : 1+5 or 2+4.

Your Task:  
You dont need to read input or print anything. Complete the function kthDistinct() which takes n as input parameter and returns 1 if it is possible else return 0.

Expected Time Complexity: O(1)
Expected Auxiliary Space: O(1)

Constraints:
1<= A, B <=106
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
            String[] S = new String[2];
            S = read.readLine().split(" ");
            long A = Integer.parseInt(S[0]);
            long B = Integer.parseInt(S[1]);
            Solution ob = new Solution();

            System.out.println(ob.kthDistinct(A, B));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    static long kthDistinct(long A, long B){
        // code here
        //basic idea is to find the sum first b numbers and check if A is greater-equal to them. THis ensures there are enough digits to form A w/o repeating any digit
        // sum of digits is more than A then it means it's not possible to use all digits to make A
        return A>=(B * (B + 1)) / 2 ? 1 : 0;
    }
}
