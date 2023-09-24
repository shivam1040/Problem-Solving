/*
Given a number n the task is to find the minimum number which is divisible by all numbers from 1 to n. Print the answer modulo (109+7).

 

Example 1:

Input:
n = 3
Output:
6 
Explanation:
When n = 3 then the minimum number
that is divisible by all the number
till 3 is 6.
Example 2:

Input:
n = 4
Output:
12
Explanation:
When n = 4 then the minimum number
that is divisible by all the number
till 4 is 12.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function numGame() which takes an Integer n as input and returns the answer.

 

Expected Time Complexity: O(n*log(n))
Expected Auxiliary Space: O(1)

 

Constraints:
1 <= n <= 105
*/

/*
The problem is actually to find lcm of numbers from 1 to N.
The good old formula is to multiply all numbers and divide by gcd of all numbers.

While coding, the numerator can be a huge number. To avoid that we can also do like this

Calculate LCM iteratively.

We can simple iterate using the recursion.
 

So we can simply iterate from 1, N storing LCM at each step.
*/


//{ Driver Code Starts

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            Long n = Long.parseLong(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.numGame(n));
        }
    }
}
// } Driver Code Ends



class Solution {
    static Long numGame(Long n) {
        // code here
        long m=1000000007L, res=1;
        
        for(long i=1; i<=n; i++){
            res=lcm(res, i)%m;
        }
        return res%m;
    }
    
    static long lcm(long a, long b){
     long lcm=(a*b)/gcd(a,b);
     return lcm;
    }
    
    static long gcd(long a, long b){
        if(b==0)
            return a;
        return gcd(b, a%b);
    }
};
