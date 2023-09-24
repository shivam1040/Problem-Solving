/*
Given a positive integer N, check if it is a perfect square or not.
Note: Try to solve the question using only addition and subtraction operation.

 

Example 1:

Input:
N = 35
Output:
0
Explanation:
35 is not a perfect 
square.
 

Example 2:

Input:
N = 49
Output:
1
Explanation:
49 is a perfect
square.
 

 

Your Task:

You don't need to read input or print anything. Your task is to complete the function checkPerfectSquare() which takes an integer N and returns 1 if it is a perfect square, else 0.

 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

 

Constraints:
1<= N <=105


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
            System.out.println(ob.checkPerfectSquare(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution{
    static int checkPerfectSquare(int N){
        // code here
        if(N==1)
            return 1;
        
        int start=1, end=N, mid=start+(end-start)/2;
        
        while(start<=end){
            int res=mid*mid;
            
            if(res==N)
                return 1;
            else if(res>N)
                end=mid-1;
            else
                start=mid+1;
            
            mid=start+(end-start)/2;
        }
        
        return 0;
        }
    }
