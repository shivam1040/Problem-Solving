/*
Given an integer N, write a program to find the one’s complement of the integer.
 

Example 1:

Input:
N = 5
Output:
2
Explanation:
binary of 5 is 101
1's complement of 101 is 010
010 is 2 in its decimal form. 
Example 2:

Input:
N = 255
Output:
0
Explanation:
binary of 255 is 1111 1111
1's complement of 1111 1111 is
0000 0000 which is 0 in its decimal form.

Your Task:
You don't need to read input or print anything. Your task is to complete the function onesComplement() which takes an integer N as input parameter and returns an integer value, the one's complement of N.
 

Expected Time Complexity: O(1)
Expected Space Complexity: O(1)
 

Constraints:
1 <= N <= 106
*/

//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.onesComplement(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution{
    static int onesComplement(int n){
        //code here
        int bits = (int)Math.floor(Math.log(n)/Math.log(2))+1;
        return (1<<bits)-1^n;
    }
}
