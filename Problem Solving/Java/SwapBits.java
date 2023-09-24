/*
Given a number X and two positions (from right side) in binary representation of X, write a program that swaps N bits at given two positions and returns the result.

 

Example 1:

Input:
X = 47
P1 = 1
P2 = 5
N = 3
Output: 227
Explanation:
The 3 bits starting from the second bit 
(from the right side) are swapped with 3 bits
starting from 6th position (from the right side) 
X = 47 (00101111)
[001]0[111]1
ANS = [111]0[001]1
ANS = 227 (11100011)
Hence, the result is 227.  
 

Example 2:

Input:
X = 28
P1 = 0
P2 = 3
N = 2
Output: 7

Your Task:  
You don't need to read input or print anything. Your task is to complete the function swapBits() which takes the integer X, integer P1, integer P2, and integer N as input parameters and returns the new integer after swapping. 

Expected Time Complexity: O(1)
Expected Auxiliary Space: O(1)
 


Constraints:
1 ≤ X ≤ 200
0 ≤ P1 < P2 ≤ 11
1 ≤ N ≤ 5
*/

//{ Driver Code Starts
//Initial Template for Java

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
            String input_line[] = read.readLine().trim().split("\\s+");
            int X = Integer.parseInt(input_line[0]);
            int P1 = Integer.parseInt(input_line[1]);
            int P2 = Integer.parseInt(input_line[2]);
            int N = Integer.parseInt(input_line[3]);
            
            Solution ob = new Solution();
            System.out.println(ob.swapBits(X, P1, P2, N));
        }
    }
}



// } Driver Code Ends


//User function Template for Java

class Solution{
    
    int swapBits(int x, int p1, int p2, int n)
    {
        //this will shift x by p1 and unset all unrequired bits
         
        int a = (x>>p1) & (1<<n)-1;
        // Move all bits of second set
        // to rightmost side
        int b = (x>>p2) & (1<<n)-1;
        //this will swap the bits
        int c= a^b;
        // Put the xor bits back to
        // their original positions
        //basically the bits we unset above
        int d =(c<<p1)|(c<<p2);
        // XOR the 'xor' with the original number
        // so that the  two sets are swapped
      return d^x;
    }
}
