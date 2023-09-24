/*
For a given number N, find whether it is a factorial number or not. A Factorial number is a number which is equal to the factorial value of other numbers.
 

Example 1:

Input:
N = 6
Output:
1
Explanation:
6 is factorial of 3
Example 2:

Input:
N = 5
Output:
0
Explanation:
no number's factorial is 5.

Your Task:
You don't need to read input or print anything. Your task is to complete the function isFactorial() which takes an integer N as input parameters and returns 1 if N is a factorial number, or 0 otherwise.
 

Expected Time Complexity: O(log N)
Expected Space Complexity: O(1)
 

Constraints:
1 <= N <= 100000
*/

/*For a number to be a factorial of any number it must be divisible by all the numbers from 1 to that number. So in this approach

We keep on dividing the number if it is completely divisible till it is no longer divisible.

Then we check the final number of n, if it is 1 we return true else we return false.
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
            System.out.println(ob.isFactorial(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int isFactorial(int n) {
        //code here
        for(int i=1;; i++){
            if(n%i==0)
                n/=i;
            else
                break;
        }
        return n==1 ? 1 : 0;
    }
}
