/*
Given 6 numbers a,b,c,d,e,f. Find the last digit of (ab)*(cd)*(ef).

 

Example 1:

Input:
a = 3 
b = 66 
c = 6 
d = 41 
e = 7 
f = 53
Output:
8
Explanation:
The last digit of the 
value obtained after 
solving the above 
equation is 8.
 

 

Example 2:

Input:
a = 1 
b = 1 
c = 1 
d = 1 
e = 1 
f = 1
Output:
1
Explanation:
The last digit of the 
value obtained after 
solving the above 
equation is 1.
 

 

Your Task:

You don't need to read input or print anything. Your task is to complete the function theLastDigit() which takes 6 integers a, b, c, d, e, and f and returns the last digit of the value obtained from the equation.

 

Expected Time Complexity: O(sqrt(N))
Expected Auxiliary Space: O(1)

 

Constraints:
1 <= a,b,c,d,e,f <= 109
*/

//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String[] inp=read.readLine().split(" ");
            int a=Integer.parseInt(inp[0]);
            int b=Integer.parseInt(inp[1]);
            int c=Integer.parseInt(inp[2]);
            int d=Integer.parseInt(inp[3]);
            int e=Integer.parseInt(inp[4]);
            int f=Integer.parseInt(inp[5]);

            Solution ob = new Solution();
            System.out.println(ob.theLastDigit(a,b,c,d,e,f));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution{
    static int theLastDigit(int a, int b, int c, int d, int e, int f){
        // code here
        //by doing so we can get last digit for a^b
        int ab=(int)Math.pow(a%10, b%4+4)%10;
        int cd=(int)Math.pow(c%10, d%4+4)%10;
        int ef=(int)Math.pow(e%10, f%4+4)%10;
        //so idea is to multiply all last digits and the get its last digit to get res
        return (ab*cd*ef)%10;
    }
}
