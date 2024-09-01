/*
You are provided an unlimited collection of red, green and blue balls. Now your task is to arrange N balls taken from this collection in a line in such a way that red balls appear first, followed by green balls and then blue balls. Given a value of N you have to find the number of ways to do that.

Note:  In a particular arrangement a certain color of balls may be missing but the order must be strictly maintained with the available balls.
 

 

Example 1:

Input:
N = 1
Output:
3
Explanation:
You are allowed to take 1 
ball only. So that one ball 
can be red, green, or blue. 
So the number of ways, in 
this case is 3.
 

Example 2:

Input:
N = 2
Output:
6
Explanation:
You are allowed to take 2 
balls. So you have six 
alternative arrangements ie. 
RG,GB,RB,RR,GG,BB.
 

 

Your Task:

You don't need to read input or print anything. Your task is to complete the function numberOfWays() which takes an integer N and returns the number of ways to do that.

 

Expected Time Complexity: O(1)
Expected Auxiliary Space: O(1)

 

Constraints 
1<=N<=10^9


*/

/*
Let, we assume that the number of red balls is x1, the number of green balls is x2 and the number of blue balls is x3. Now according to the given condition x1+x2+x3=N, where xi>=0. The answer is the number of solutions of this equation which is given by (N+k-1)C(k-1) where k is 3. Simplifying we just get the simple expression ((n+2)*(n+1))/2.
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
            Long N = Long.parseLong(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.numberOfWays(N));
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    static Long numberOfWays(Long N){
        // code here
        return (N+2)*(N+1)/2;
    }
}
