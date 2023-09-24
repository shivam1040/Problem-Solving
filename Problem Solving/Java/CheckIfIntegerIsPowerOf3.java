/*
Given a positive integer N, write a function to find if it is a power of three or not.

 

Example 1:

Input:
N = 3
Output:
Yes
Explanation:
31 is a power of 3.
 

Example 2:

Input:
N = 5
Output:
No
Explanation:
5 is not a power of 3.
 

Your Task:

You don't need to read input or print anything. Your task is to complete the function isPowerof3() which takes an integer N and returns "Yes" if N is a power of 3, else "No" if N is not a power of 3.

 

Expected Time Complexity: O(1)
Expected Auxiliary Space: O(1)

 

Constraints:
1<=N<=(32-bit largest integer)
*/

/*
The logic is very simple. Any integer number other than power of 3 which divides highest power of 3 value that integer can hold 3^19 = 1162261467 (Assuming that integers are stored using 32 bits) will give reminder non-zero. 
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
            System.out.println(ob.isPowerof3(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution{
    static String isPowerof3(int N){
        // code here
        int maxPowOf3=(int)Math.pow(3, 19);
        
        return maxPowOf3%N==0 ? "Yes" : "No";
    }
}
