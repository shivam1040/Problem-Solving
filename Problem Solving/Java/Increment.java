/*
Given a base B and a number N in that base, increment the number by one and print the resulting number in that base only.
 

Example 1:

Input:
B = 2
N = 0010
Output:
11
Explanation:
(0010)2 = (2)10
2 + 1 = 3
(3)10 = (11)2
Example 2:

Input:
B = 13
N = 2139
Output:
231A
Explanation:
(2319)13 = (81)10
81 + 1 = 82
(82)10 = (231A)13

Your Task:
You don't need to read input or print anything. Your task is to complete the function inc() which takes an integer B, a string N as input parameter and returns the string by incrementing the number by one in the same base.
 


Expected Time Complexity: O(log N)
Expected Space Complexity: O(1)
 

Constraints:
2 <= B <= 16
0000 <= N <= Max value in that base (e.g. 1111 for base 2, FFFF for base 16, etc.)
*/

//{ Driver Code Starts
import java.io.*;
import java.util.*;

// } Driver Code Ends
class Solution{
    static String inc(int B,String N){
        // code here
        int temp=Integer.parseInt(N, B)+1;
        
        StringBuilder res=new StringBuilder();
        
        while(temp>0){
         int temp1=temp%B;
         //taking care of hexa
         if(temp1>=0 && temp1<=9)
            res.append((char)(temp1+48));
         else
            res.append((char)(temp1-10+65));
         temp/=B;
        }
        return res.reverse().toString();
    }
}

//{ Driver Code Starts.
class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int B = Integer.parseInt(read.readLine());
            String N = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.inc(B,N));
        }
    }
}
// } Driver Code Ends
