/*
Given two numbers A and B, the task is to find f(AB). f(n) which takes a positive integer n as input and does the following:

f(n):

if n < 10

    return n

else return f( sum_of_digits(n) )

 

Example 1:

Input: A = 6, B = 6
Output: 9
Explanation: 
f(66) = f(46656) = f(27) = f(9) = 9
Example 2:

Input: A = 7, B = 3
Output: 1
Explanation: 
f(73) = f(343) = f(10) = f(1) = 1
 

Your Task:
You don't need to read or print anything. Your task is to complete the function SumofDigits() which takes A and B as input parameters and returns f(AB).
 

Expected Time Complexity: O(Log(B))
Expected Space Complexity: O(1)
 

Constraints:
1 <= A, B <= 109 
*/

/*
Initialization:

result is initialized to 1, which will hold the final result of the power operation.
base is reduced modulo modulus. This ensures that base is within the range [0, modulus-1], which is crucial for modular arithmetic.
Main Loop:

The code enters a while loop while exponent is greater than 0. The loop processes the bits of exponent one by one, moving from the least significant bit (LSB) to the most significant bit (MSB).
In each iteration:
It checks if the current bit of exponent (the LSB) is 1 using exponent % 2 == 1. If it's 1, it means that the corresponding power of base should be included in the result.
If the current bit is 1, it multiplies result by base and takes the result modulo modulus. This is equivalent to multiplying the power of base into the result and reducing it modulo modulus.
exponent is then right-shifted by one position (exponent //= 2), effectively dividing it by 2. This moves to the next bit of the exponent.
Termination:

The loop continues until exponent becomes 0, processing all bits of the exponent.
Once the loop terminates, the result contains the final result of base^exponent % modulus.
Result:

The final result, computed using modular exponentiation, is returned.
*/

//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String s = br.readLine().trim();
            String[] s1 = s.split(" ");
            int A = Integer.parseInt(s1[0]);
            int B = Integer.parseInt(s1[1]);
            Solution ob = new Solution();
            int ans = ob.SumofDigits(A, B);
            System.out.println(ans);           
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int SumofDigits(int a, int b)
    {
        // Code here
        long res = 1;

//finding large powers by modula exponatitions
//and mod 9 is used to find single digiit sum
        while (b > 0) {
            //this is done to ensure power for odd numbers of exponents are included as well
            if ((b & 1) == 1) {
                res = (res * (a % 9)) % 9;
            }
            //adding the remaining exponent in power
            a = ((a % 9) * (a % 9)) % 9;
            b >>= 1;
            //in this method, the power is added in order of 2 like binary represnatation
        }

        if (res == 0) {
            return 9;
        }

        return (int) res; // Cast the result to int if needed
    }
    
}
