/*
Given four numbers X, Y, Z and N. Find smallest N digit Number that is divisible by all the three numbers X, Y and Z.


Example 1:

Input: 
N = 2
X = 2, Y = 3, Z = 5
Output: 30
Explaination: 30 is the lcm of 2, 3 and 5 
and it is a 2 digit number.

Example 2:

Input: 
N = 2
X = 3, Y = 5, Z = 7
Output: -1
Explaination: There is no 2 digit number 
divisible by 3, 5 and 7.

Your Task:
You do not need to read input or print anything. Your task is to complete the function minNumber() which takes the four number X, Y, Z and N as input parameters and returns the smallest N digit number divisible by X, Y and Z. If ther is no such number, return -1.


Expected Time Complexity: O(Log X)
Expected Auxiliary Space: O(1)


Constraints:
1 ≤ X, Y, Z, ≤ 1000
1 ≤ N ≤ 18
*/

/*
1) Find smallest n digit number is pow(10, n-1). 
2) Find LCM of given 3 numbers x, y and z. 
3) Find remainder of the LCM when divided by pow(10, n-1). 
4) Add the “LCM – remainder” to pow(10, n-1). If this addition is still a n digit number, we return the result. Else we return Not possible.
*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input_line[] = read.readLine().trim().split("\\s+");
            int X = Integer.parseInt(input_line[0]);
            int Y = Integer.parseInt(input_line[1]);
            int Z = Integer.parseInt(input_line[2]);
            int N = Integer.parseInt(input_line[3]);

            Solution ob = new Solution();
            System.out.println(ob.minNumber(X, Y, Z, N));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static long minNumber(int X, int Y, int Z, int N)
    {
        // code here
        long smallestN=(long)Math.pow(10, N-1), lcm=LCM(X, Y, Z), rem=smallestN%lcm;
        
        if(rem==0)
            return smallestN;
        
        smallestN+=lcm-rem;
        
        if(smallestN<Math.pow(10, N))
            return smallestN;
        return -1;
    }
    
    private static long __gcd(long a, long b)
    {
 
        if (b == 0) {
            return a;
        }
        else {
            return __gcd(b, a % b);
        }
    }
 
    // LCM for x, y, z
    private static long LCM(long x, long y, long z)
    {
        long ans = ((x * y) / (__gcd(x, y)));
        return ((z * ans) / (__gcd(ans, z)));
    }
}
