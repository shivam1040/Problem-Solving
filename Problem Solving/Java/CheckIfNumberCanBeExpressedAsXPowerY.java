/*
Given a positive integer N, find if it can be expressed as xy where y > 1 and x > 0 and x and y both are both integers.

 

Example 1:

Input:
N = 8
Output:
1
Explanation:
8 can be expressed
as 23.
 

 

Example 2:

Input:
N = 7
Output:
0
Explanation:
7 can't be expressed
int the form xy.
 

 

Your Task:

You don't need to read input or print anything. Your task is to complete the function checkPower() which takes an integer N and returns 1 if possible else, 0.

 

Expected Time Complexity: O(sqrt(N))
Expected Auxiliary Space: O(1)

 


Constraints:
1<= N <=10000
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
            System.out.println(ob.checkPower(N));
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    static int checkPower(int N){
        // code here
        if(N==1){
            return 1;
        }
        for(int i=2; i<=Math.sqrt(N); i++){
            int j=i;
            while(j<=N){
                j*=i;
                if(j==N)
                    return 1;
            }
        }
        return 0;
    }
}
