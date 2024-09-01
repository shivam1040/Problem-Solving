/*
Given two numbers a and b. Find the last digit of a raised to the power b.

Example 1:

Input:
a = 3
b = 4

Output:
1

Explanation:
34 = 81 so the last digit is 1.
Example 2:

Input:
a = 2
b = 8

Output:
6

Explanation:
28 = 256 so the last digit is 6.
Your Task:  
You don't need to read input or print anything. Your task is to complete the function quickExponents() which take two integers a and b and returns the last digit of a raise to the power b.

Expected Time Complexity: O(Log(b))
Expected Auxiliary Space: O(1)

Constraints:
1 <= a, b <= 1018


*/

/*
Initialization: The function starts by initializing two variables, a1 and b1. a1 is set to the last digit of a (i.e., 
�
m
o
d
 
 
10
amod10), and b1 is set to (b - 1) % 4. The reason for this is that the last digit of 
�
�
a 
b
  depends on the last digit of 
�
a and the value of 
�
b modulo 4.

Exponentiation Loop: The function then enters a loop that iterates b1 times. In each iteration, it calculates a1 raised to the power of a (i.e., a1 * a) and takes the result modulo 10 to keep only the last digit. This is done because the last digit of the result of raising a number to a power depends only on the last digit of the base number and the last two digits of the exponent (when considering modulo 10).

Final Result: After the loop completes, the function returns the value of a1, which is the last digit of 
�
�
a 
b
 .
*/

//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            long a=sc.nextLong();
            long b=sc.nextLong();
			
            Solution ob = new Solution();
            int ans  = ob.quickExponents(a,b);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    static int quickExponents(long a, long b){
        // Write your code here
        long a1=a%10, b1=(b-1)%4;
        
        while(b1>0){
            a1=(a1*a)%10;
            b1--;
        }
        return (int)a1;
    }
}
