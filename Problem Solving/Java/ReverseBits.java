/*
Given a non-negative integer n. Reverse the bits of n and print the number obtained after reversing the bits.
Note:  The actual binary representation of the number is being considered for reversing the bits, no leading 0’s are being considered.
 
Example 1:
Input : 
N = 11
Output:
13
Explanation:
(11)10 = (1011)2.
After reversing the bits we get:
(1101)2 = (13)10.
Example 2:

Input : 
N = 10
Output:
5
Explanation:
(10)10 = (1010)2.
After reversing the bits we get:
(0101)2 = (101)2
        = (5)10.
Your task:
You don't need to read input or print anything. Your task is to complete the function reverseBits() which takes an integer N as input and returns the number obtained after reversing bits.
 
Expected Time Complexity : O(number of bits in the binary representation of N)
Expected Auxiliary Space :  O(1)
 
Constraints :
1 ≤ N ≤ 109
*/

//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

class GFG
{
	static int n;
	static int k;
	
	// Driver Code
	public static void main(String[] args) throws NumberFormatException, IOException 
	{
		BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine()); //Inputting the testcases
		
		while(t>0) //While testcases exist
		{
			
			n = Integer.parseInt(br.readLine()); //Input N
			
			Solution obj = new Solution();
			
			System.out.println(obj.reverseBits(n));
            
            t--;
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int reverseBits(int n)
    {
        //code here
        int ans=0;
        
        while(n>0){
            //this tells us if current bit is set or not and appends to ans created
            ans|=(n&1);
            //this shifts the bit to left so that new digit can fit in
            ans<<=1;
            //shifts input to right so that next bit can be evaluated
            n>>=1;
        }
        //this is done to get rid of extra zero we get by left shifting the ans 'cause zero from last iteration isn't needed
        return ans>>1;
    }
}
