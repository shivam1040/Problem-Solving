/*
We already know Basic Euclidean Algorithm. Now using the Extended Euclidean Algorithm, given a and b calculate the GCD and integer coefficients x, y. Using the same. x and y must satisfy the equation ax + by = gcd(a, b) .
 

Example 1:

Input:
a = 35
b = 15
Output:
5 1 -2
Explanation:
gcd(a,b) = 5
35*1 + 15*(-2) = 5
Example 2:

Input:
a = 30
b = 20
Output:
10 1 -1
Explanation:
gcd(30,20) = 10
30*(1) + 20*(-1) = 10

Your Task:
You don't need to read input or print anything. Your task is to complete the function gcd() which takes an integer N as input parameters and returns array of three numbers containing gcd, x, y in the same order.
 

Expected Time Complexity: O(log max(a,b))
Expected Space Complexity: O(1)
 

Constraints:
1 <= a,b <= 106
*/

/*
The extended Euclidean algorithm updates the results of gcd(a, b) using the results calculated by recursive call gcd(b%a, a). Let values of x and y calculated by the recursive call be x1 and y1. x and y are updated using the below expressions. 

ax + by = gcd(a,b)
gcd(a,b) = gcd(b%a, a)
gcd(b%a, a) = (b%a)x1 + ay1
ax + by = (b%a)x1 + ay1
ax + by = (b - [b/a] * a)x1 + ay1
ax + by = a(y1 - [b/a] * x1) + bx1
Comparing LHS and RHS,

    x = y1 - ⌊b/a⌋ * x1
    y = x1
*/

//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while(t-- > 0)
        {
            int a = s.nextInt();
            int b = s.nextInt();
            Solution ob = new Solution();
            int v[] = ob.gcd(a,b);
            System.out.println(v[0] + " " + v[1] + " " + v[2]);
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution{
    static int[] res=new int[3];
    static int x=0;
    static int y=0;
    
    static int[] gcd(int a,int b){
        // code here
        int gcd=GCD(a,b);
        
        extendedGcd(a,b);
        
        res[0]=gcd;
        res[1]=x;
        res[2]=y;
        
        return res;
    }
    
    static int GCD(int a,int b)
    {
        if (a == 0)
            return b;
        
        return GCD(b%a, a);
    }
    
    static void extendedGcd(int a, int b){
        if(b==0){
            x=1;
            y=0;
            return;
        }
        extendedGcd(b, a%b);
        
        int cx=y;
        int cy=x-(a/b)*y;
        x=cx;
        y=cy;
    }
}
