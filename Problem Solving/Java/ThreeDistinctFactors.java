/*
Given a positive integer N. The task is to check whether a number has exactly three distinct factors or not.

 

Example 1:

Input:
N = 10
Output:
0
Explanation:
10 has 4 factors- 1,2,5 and 10.
So, the Ouput is 0.
Example 2:

Input:
N = 9
Output:
1
Explanation:
9 has 3 factors- 1,3 and 9.
So, the Ouput is 1.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function hasThreePrimeFac() which takes an Integer N as input and returns 1 if it has exactly 3 factors else returns 0.

 

Expected Time Complexity: O(sqrt(N))
Expected Auxiliary Space: O(1)

 

Constraints:
1 <= N <= 1012
*/

/*
Better approach is to use Number theory. According to property of perfect square, “Every perfect square(x2) always have only odd numbers of factors“

If the square root of given number(say x2) is prime(after conforming that number is perfect square) then it must have exactly three distinct factors i.e., 

A number 1 of course.
Square root of a number i.e., x(prime number).
Number itself i.e., x2.

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
            Long N = Long.parseLong(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.hasThreePrimeFac(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int hasThreePrimeFac(Long n) {
        // code here
        long sq = (int)Math.sqrt(n);
 
    // Check whether number is perfect
    // square or not
    if (1L * sq * sq != n)
        return 0;
 
    // If number is perfect square, check
    // whether square root is prime or
    // not
    return isPrime(sq) ? 1 : 0;
    }
    
    static boolean isPrime(long n)
{
    // Corner cases
    if (n <= 1)
        return false;
    if (n <= 3)
        return true;
 
    // This is checked so that we can skip
    // middle five numbers in below loop
    if (n % 2 == 0 || n % 3 == 0)
        return false;
 
    for (int i = 5; i * i <= n; i = i + 6)
        if (n % i == 0 || n % (i + 2) == 0)
            return false;
 
    return true;
}
};
