/*
Given an integer N, you need to print the following pattern.

Example 1:

Input:
N = 3
Output:
33333
32223
32123
32223
33333

Explanation:
When N = 3 then there will be three boundaries.
Outer boundary contains only 3.
Middle boundary contains only 2.
And the inner boundary contains only 1.
Example 2:

Input:
N = 4
Output:
4444444
4333334
4322234
4321234
4322234
4333334
4444444
Your Task:  
You don't need to read input. Your task is to complete the function printPattern() which takes an integer N as an input parameter and print the pattern for it.

Expected Time Complexity: O(N2)
Expected Auxiliary Space: O(1)

Constraints:
1 <= N <= 9
*/

//{ Driver Code Starts
//Initial Template for Java//Initial Template for Java
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
            int N =sc.nextInt();
		
            Solution ob = new Solution();
         
            ob.printPattern(N);
        }  
    }
}

// } Driver Code Ends


//User function Template for Java//User function Template for Java
class Solution{
    void printPattern(int n){
        // code here
        int x = 2*n - 2;

          for(int i=0;i<=x;i++)

          {

                for(int j=0;j<=x;j++)

                {

                      int n1 = Math.min(i,j);

                      int n2 = Math.min(x-i,x-j);

                      n2 = Math.min(n1,n2);

                      System.out.print(n-n2);

                }

                System.out.println();

          }
    }
}
