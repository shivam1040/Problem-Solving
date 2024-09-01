/*
Given four integers a, b, m, n . Find whether  pow(a,b) is greater than pow(m,n) or not. Where pow(x,y) denotes x raised to the power y. Output 1 if pow(a,b) is greater, output 0 if pow(m,n) is greater otherwise output -1 if both are equal.

 

Example 1:

Input:
a = 2 , b = 2 , m = 3 , n = 2
Output:
0
Explanation:
22 = 4, and 32 = 9. 9>4. So,
the Output 0.
Example 2:

Input:
a = 1 , b = 23 , m = 1 , n = 989
Output:
-1
Explanation:
Both 123 and 1989 = 1. So,
the Output is -1. 
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function greaterPower() which takes 4 Integers a,b,m and n as input and returns the answer.

 

Expected Time Complexity: O(max(log(a),log(m))
Expected Auxiliary Space: O(1)

 

Constraints:
0 <= b,n <= 1018
1 <= a,m <= 1018
*/

/*
Consider two powers 

a^b or m^n

we cannot caculate simply by muliplying or using pow function or either by using exponential power function.
for proving greaterness of any of them we need to take the log of both the powers

Taking log10 of both the powers.

log10(a^b) or log10(m^n)
= b*log10(a) or n*log10(m)

consider following corner cases
now if a=0 or m=0 then that power result will always be zero  
    if b=0 or n=0 then that power result will always be one.
    if b=1 or n=1 then that power result will always be a or m.

Complexity of solution is max(log(a),log(m))
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
            
            Long a = Long.parseLong(S[0]);
            Long b = Long.parseLong(S[1]);
            Long m = Long.parseLong(S[2]);
            Long n = Long.parseLong(S[3]);

            Solution ob = new Solution();
            System.out.println(ob.greaterPower(a,b,m,n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int greaterPower(Long a , Long b , Long m , Long n) {
        // code here
        double x, y=0;
        
        if(b!=0)
            x=b*Math.log(a);
        else
            x=1;
        if(n!=0)
            y=n*Math.log(m);
        else
            y=1;
        if(x==y)
            return -1;
        else if(x>y)
            return 1;
        return 0;
    }
};
