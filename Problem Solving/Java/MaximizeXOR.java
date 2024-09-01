/*
Given a number X find the total numbers A such that A XOR X >= X,  and 1<=A<=X.
 

Example 1:

Input: 10
Output: 5
Explanation: Calculating XOR of 10 with
{1, 4, 5, 6, 7} give values greater than 
equal to 10.
Example 2:

Input: 5
Output: 2
Explanation: Calculating XOR of 5 with 
{2, 3} give values greater than 5.

 

Your Task:
You don't need to read or print anything. Your task is to complete the function maximize_xor_count() which takes X as input parameter and returns total numbers A.
 

Expected Time Complexity: O(log(n))
Expected Space Complexity: O(1)
 

Constraints:
1 <= X <= 108


*/

/*
      // Step 1:- Just find out the position of unset bit in number.
        // Step 2:- Suppose, if unset bit at i'th  position then add pow(2,i)/2 in result variable
        // Step 3:- Right shift number n one time
        // Step 4:- continue till num become zero(0)
*/

//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            Solution ob =new Solution();
            int ans = ob.maximize_xor_count(n);
            System.out.println(ans);
        }
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int maximize_xor_count(int n)
    {
        // Code here
        int res=0, count=0;
        
        while(n!=0){
            count++;
            if((n&1)==0)
                res+=(1<<count)/2;
            n>>=1;
        }
        return res;
    }
}

