/*
Find the number of factors for a given integer N.
 

Example 1:

Input:
N = 5
Output:
2
Explanation:
5 has 2 factors 1 and 5
Example 2:

Input:
N = 25
Output:
3
Explanation:
25 has 3 factors 1, 5, 25

Your Task:
You don't need to read input or print anything. Your task is to complete the function countFactors() which takes an integer N as input parameters and returns an integer, total number factor of N.
 

Expected Time Complexity: O(sqrt(N))
Expected Space Complexity: O(1)
 

Constraints:
1 <= N <= 100000
*/

/*
f we look carefully, all the divisors are present in pairs. For example if n = 100, then the various pairs of divisors are: (1,100), (2,50), (4,25), (5,20), (10,10)
Using this fact we could speed up our program significantly. 
We, however, have to be careful if there are two equal divisors as in the case of (10, 10). In such case, we'd print only one of them. 
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
            System.out.println(ob.countFactors(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution{
    static int countFactors(int N) {
        //code here
        int res=0;
        
        for(int i=1; i<=Math.sqrt(N); i++){
            if(N%i==0){
                res++;
                if(i!=N/i)
                    res++;
            }
        }
        
        return res;
    }
}
