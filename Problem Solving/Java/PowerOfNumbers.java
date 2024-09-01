/*
Given a number and its reverse. Find that number raised to the power of its own reverse.
Note: As answers can be very large, print the result modulo 109 + 7.

Example 1:

Input:
N = 2, R = 2
Output: 4
Explanation: The reverse of 2 is 2 and after raising power of 2 by 2 we get 4 which gives remainder as 4 when divided by 1000000007.
Example 2:

Input:
N = 12, R = 21
Output: 864354781
Explanation: The reverse of 12 is 21and 1221 when divided by 1000000007 gives remainder as 864354781.
Your Task:
You don't need to read input or print anything. You just need to complete the function pow() that takes two parameters N and R denoting the input number and its reverse and returns power of (N to R)mod(109 + 7).

Expected Time Complexity: O(LogN).
Expected Auxiliary Space: O(LogN).

Constraints:
1 <= N <= 109
*/

/*
Intuition
In this approach we can use divide and conquer approach. We will leverage upon a recurrence relation for odd and even powers separately as defined below.
      power(N,R)=power(N,R/2)*power(N,R/2) if R is even
      power(N,R)=N*power(N,R/2)*power(N,R/2) if R is odd.(remember we are taking floor value of R/2)

Here we are using the concept the modular arithmetic (a * b) % M = ((a % M) * (b % M)) % M, we can take advantage of this property by breaking down the exponent R into smaller subproblems using the divide-and-conquer approach. It recursively computes power(N, R/2) to calculate the power of N raised to R/2.

The temp variable stores the result of power(N, R/2), and then it squares temp ((temp * temp)) to obtain the result of power(N, R)
 

Implementation
If R==0 then return 1.
Recursively call power(N,R/2) and store the value in ans.
If R is even then return ans*ans.
Else return ans*ans*N.
Note:- Use modulo 109+7 to avoid overflow error.
*/

//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class Main {
    
    // compute reverse of a number
    public static long rev(long n)
    {
        long rev_num = 0;
         while(n > 0) 
          { 
            rev_num = rev_num*10 + n%10; 
            n = n/10; 
          } 
          return rev_num;
    }
    
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
        //testcases
		int T=sc.nextInt();
		while(T-->0)
		{
		    Solution obj=new Solution();
		    
		    int N;
		    
		    
            //input N
		    N=sc.nextInt();
		    int R=0;
		    
		    	    
            // reverse the given number n
		    R=(int)rev(N);
	
            //power of the number to it's reverse
		    long ans=(long)obj.power(N,R);
		    System.out.println(ans);
		    
		    
		}
		
	}
}


// } Driver Code Ends


//User function Template for Java

class Solution
{
        
    long power(int n,int r)
    {
        //Your code here
        if(n==0)
            return 0;
            //power of 0 is 1
        if(r==0)
            return 1;
        long temp;
        
        if(r%2==0){
            temp=power(n, r/2);
             // finding r/2 power as power is even then storing answer in y and if power is even like 2^4 we can simply do (2^2)*(2^2)
            temp=(temp*temp)%1000000007;
        }
        else{
            temp=n%1000000007;
             // reduce the power by 1 to make it even. The reducing power by one can be done if we take one n out. Like 2^3 can be written as 2*(2^2)
            temp=(temp*power(n, r-1)%1000000007)%1000000007;
        }
        return (temp%1000000007)%1000000007;
    }

}

