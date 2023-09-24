/*
Given an integer N, recursively sum digits of N until we get a single digit.  The process can be described below

If N < 10    
    digSum(N) = N
Else         
    digSum(N) = Sum(digSum(N))

 

Example 1:

Input:
N = 1234
Output:
1
Explanation:
The sum of 1+2+3+4 = 10, 
digSum(x) == 10 Hence 
ans will be 1+0 = 1
 

 

Example 2:

Input:
N = 9999
Output:
9
Explanation:
Check it yourself.
 

Your Task:

You don't need to read input or print anything. Your task is to complete the function repeatedSumOfDigits() which takes an integer N and returns the repeated sum of digits of N.

 

Expected Time Complexity: O(1)
Expected Auxiliary Space: O(1)

 

 

Constraints:

1 ≤ N ≤ 1000000
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
            System.out.println(ob.repeatedSumOfDigits(N));
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    static int sum;
    static int repeatedSumOfDigits(int n){
        // code here
    //     sum=0;
    //   return sums(n);
    return n%9==0 ? 9: n%9;
        
    }
    
    private static int sums(int n){
        //while loop here
        sum+=n%10;
        n/=10;
        if(n!=0)
            return sums(n);
        else if(n==0 && sum/10!=0){
            sum=0;
            return sums(sum);
        }
        else
            return sum;
    }
}

