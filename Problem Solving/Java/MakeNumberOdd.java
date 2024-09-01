/*
Given a number N. Print the minimum positive integer by which it should be divided so that the result is an odd number.

Example 1:

Input:
N = 36
Output:
4
Explanation:
36 must be divided by 4 or 12 to make it
odd. We take minimum of 4 and 12 i.e. 4.
Example 2:

Input:
N = 5
Output:
1
Explanation:
5 is already odd.
Your Task:  
You don't need to read input or print anything. Your task is to complete the function makeNumberOdd() which takes an integer N as an input parameter and return the minimum positive integer by which it should be divided so that the result is an odd number.

Expected Time Complexity: O(LogN)
Expected Auxiliary Space: O(1)

Constraints:
1 <= N <= 100000
 


*/

/*
As there is only one case to make a number odd i.e.
It is an even number i.e. divisible by 2.
So, the point is to find the smallest multiple of 2 
that can make the given number odd.
*/

//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int N=sc.nextInt();
			
            
            Solution ob = new Solution();
            int ans  = ob.makeNumberOdd(N);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    static int makeNumberOdd(int N){
        // code here
        if(N%2!=0)
            return 1;
            
        int res=1;
        
        while(N%2==0){
            N/=2;
            res*=2;
        }
        return res;
    }
}
