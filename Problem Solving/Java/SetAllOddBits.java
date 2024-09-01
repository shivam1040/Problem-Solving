/*
Given a number, the task is to set all odd bits of a number.
NOTE: Position of Least Significant Bit is considered as 1.

Example 1:

Input: n = 20
Output: 21 
Explanation: Binary representation of 20 
is 10100. Setting all odd bits make the 
number 10101 which is binary
representation of 21.
Example 2:

Input: n = 10
Output: 15
Explanation: Binary representation of 10
is 1010. Setting all odd bits make the
number 1111 which is binary representation
of 15.

Your Task:  
You dont need to read input or print anything. Complete the function setAllOddBitsâ€‹() which takes n as input parameter and returns the modified number.

Expected Time Complexity: O(1)
Expected Auxiliary Space: O(1)

Constraints:
1<= n <=109
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
            long n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.setAllOddBits(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    static long setAllOddBits(long n){
        // code here
        long res=0, count=0;
        
        //generating a binary sequence with set odd bits
        for(long i=n; i>0; i>>=1){
            if(count%2==0)
                res|=1<<count;
            count++;
        }
        return res|n;
    }
}
