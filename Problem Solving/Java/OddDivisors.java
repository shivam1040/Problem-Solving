/*
Given a natural number N, find the count of numbers from 1 to N that have an odd number of divisors. 

 

Example 1:

Input:
N = 1
Output:
1
Explanation:
1 has only one 
divisor {1}.
 

Example 2:

Input:
N = 4
Output:
2
Explanation:
4 has an odd number 
of divisors {1, 2, 4}.
 

Your Task:

You don't need to read input or print anything. Your task is to complete the function oddNumberOfDivisor() which takes an integer N and returns the count of numbers from 1 to n that have an odd number of divisors. 

 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

 

Constraints:
1 <= N <= 106


*/


/*
A number has an odd number of divisors if and only if it is a perfect square.
To count the perfect squares between 1 and N, you can calculate the square root of each number from 1 to N and check if it is an integer. If it is an integer, then it's a perfect square.
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
            int N = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.oddNumberOfDivisor(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution{
    static int oddNumberOfDivisor(int N){
        // code 
        return (int)Math.floor(Math.sqrt(N));
    }
}
