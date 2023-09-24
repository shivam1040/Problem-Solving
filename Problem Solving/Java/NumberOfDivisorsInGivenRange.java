/*
Given a range [m..n]. You task is to find the number of integers divisible by either a or b in the given range.

 

Example 1:

Input:
m = 5, n = 11, a = 4, b = 6
Output:
2
Explanation:
6 and 8 lie in the range and are also
either divisible by 4 or 6.
Example 2:

Input:
m = 1, n = 3, a = 2, b = 3
Output:
2
Explanation:
2 and 3 lie in the range and are also
either divisible by 2 or 3.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function numOfDiv() which takes 4 Integers m, n, a, b as input and returns the count of integers in the range m..n which are divisible by either a or b.

 

Expected Time Complexity: O(log(max(a,b))
Expected Auxiliary Space: O(1)

 

Constraints:
1 <= m <= n <= 105
1 <= a,b <= 500


*/

/*
Divide n by a to obtain total count of all numbers(1 to n) divisible by 'a'. 
 
Divide m-1 by a to obtain total count of all numbers(1 to m-1) divisible by 'a'. 
 
Subtract the count of step 1 and 2 to obtain total divisors in range m to n. 
 

Now we have a total number of divisors of 'a' in given range. Repeat the above to count total divisors of 'b'. 
Add these to obtain total count of divisors 'a' and 'b'. 
But the number divisible by both a and b counted twice. Therefore, to remove this ambiguity we can use LCM of a and b to count total number divisible by both 'a' and 'b'. 
 

Find LCM of 'a' and 'b'. 
 
Divide n by LCM to obtain the count of numbers(1 to n) divisible by both 'a' and 'b'. 
 
Divide m-1 by LCM to obtain the count of numbers(1 to m-1) divisible by both 'a' and 'b'. 
 
Subtract the count of steps 2 and 3 to obtain total divisors of both 'a' and 'b'. 
 

Now subtract this result from the previous calculated result to find total count of all unique divisors of 'a' or 'b'.
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
            
            int m = Integer.parseInt(S[0]);
            int n = Integer.parseInt(S[1]);
            int a = Integer.parseInt(S[2]);
            int b = Integer.parseInt(S[3]);

            Solution ob = new Solution();
            System.out.println(ob.numOfDiv(m,n,a,b));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int numOfDiv(int m, int n, int a, int b) {
        // code here
        int lcm=lcm(a, b), a_divisor=n/a-(m-1)/a, b_divisor=n/b-(m-1)/b, common_divisor=n/lcm-(m-1)/lcm, ans=a_divisor+b_divisor-common_divisor;
        
        return ans;
    }
    
    private static int lcm(int a, int b){
        int greater = Math.max(a, b);
        int smallest = Math.min(a, b);
        for (int i = greater;; i += greater) {
            if (i % smallest == 0)
                return i;
        }
    }
};
