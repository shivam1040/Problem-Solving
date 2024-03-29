/*
Amicable numbers are two different numbers so related that the sum of the proper divisors of each is equal to the other number. (A proper divisor of a number is a positive factor of that number other than the number itself. Given two Numbers A and B, find whether they are Amicable Numbers or not. Print 1 if they are Amicable else 0.

 

Example 1:

Input:
A = 220 , B = 284
Output:
1
Explanation:
Proper divisors of 220 are 1, 2,
4, 5, 10, 11, 20, 22, 44, 55 and 110.
Sum of these is 284. Proper divisors
of 284 are 1, 2, 4, 71 and 142
with sum 220.
Example 2:

Input:
A = 4 , B = 8
Output:
0
Explanation:
Proper divisors of 4 are 1 and 2.
Sum of these is 3!=8. Proper divisors
of 8 are 1, 2 and 4 with sum 7!=4 and
thus the Otput 0.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function isAmicable() which takes 2 Integes A and B as input and returns the answer.

 

Expected Time Complexity: O(sqrt(A,B))
Expected Auxiliary Space: O(1)

 

Constraints:
1 <= A,B <= 105
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
            String S[] = read.readLine().split(" ");
            
            int A = Integer.parseInt(S[0]);
            int B = Integer.parseInt(S[1]);

            Solution ob = new Solution();
            System.out.println(ob.isAmicable(A,B));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int isAmicable(int A , int B) {
        // code here
        if (A==1 && B==1)
        return 0;
        
        int aF=divSum(A);
        int bF=divSum(B);
        
        return aF==B && bF==A ? 1 : 0;
    }
    
    static int divSum(int n)
    {
        // Sum of divisors
        int result = 0;
    
        // find all divisors which divides 'num'
        for (int i = 2; i <= Math.sqrt(n); i++)
        {
            // if 'i' is divisor of 'n'
            if (n % i == 0)
            {
                // if both divisors are same
                // then add it once else add
                // both
                if (i == (n / i))
                    result += i;
                else
                    result += (i + n / i);
            }
        }
    
        // Add 1 and n to result as above loop
        // considers proper divisors greater 
        // than 1.
        return (result + 1);
    }
};
