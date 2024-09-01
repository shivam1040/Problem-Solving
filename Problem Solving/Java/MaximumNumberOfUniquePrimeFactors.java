/*
Given a number N, find the maximum number of unique prime factors any number can have in range [1, N].

Example 1:

Input:
N = 3
Output:
1
Explanation:
No number in the range 1 to 3
can have more than 1 unique
Prime factor. So, the Output is 1.
Example 2:

Input:
N = 500
Output:
4
Explanation:
No number in the range 1 to 500
can have more than 4 unique
Prime factors. So, the Output is 4.
An example of a number with 4
unique Prime Factors is 210.
Your Task:
You don't need to read input or print anything. Your task is to complete the function maxUniquePrimeFactors() which takes an Integer N as input and returns the answer.

Expected Time Complexity: O(Largest Prime Factor of N)
Expected Auxiliary Space: O(1)

Constraints:
1 <= N <= 1018
*/

/*

The maxUniquePrimeFactors function aims to find the maximum number of unique prime factors that any number in the range [1, number] can have. Here's the intuition behind the function:

List of Primes: The function uses a pre-defined list of prime numbers (2, 3, 5, 7, ..., 47) as potential factors. These primes are chosen because they are the first 15 prime numbers and form the basis for finding numbers with the maximum number of unique prime factors.

Multiplying Primes: The function iterates over the list of primes, multiplying them together (product *= prime) until the product exceeds the given number. This is done to find the maximum product of distinct primes that is still less than or equal to number.

Counting Unique Prime Factors: For each prime multiplied, the function increments the count variable, which represents the number of unique prime factors found so far. The count is incremented as long as the product is less than or equal to number.

Breaking Condition: If the product exceeds number, the loop breaks, as further multiplication would result in a product greater than number.

Returning Count: Finally, the function returns the count, which represents the maximum number of unique prime factors that any number in the range [1, number] can have.
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
            System.out.println(ob.maxUniquePrimeFactors(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int maxUniquePrimeFactors(Long N) {
        // code here
        //considering only until 47 'cause multiplying every prime until 47 would give int overflow so pointless give the constraint
        List<Integer> primes = List.of(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47);
        int count = 0;
        long product = 1;
        for (int prime : primes) {
            if ((product *= prime) > N) {
                break;
            } else {
                ++count;
            }
        }
        return count;
    }
};
