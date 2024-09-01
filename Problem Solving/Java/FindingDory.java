/*
My friend generated a series 1 4 8 9 12 17 25 28 .... . Each element of this series is known as "Dory". Your task is to find out whether a number n is Dory or not.
NOTE: If n is "Dory", then return 1 else return 0.

Example 1:

Input: n = 4
Output: 1 
Explanation: 4 is Dory because 
its present in the series.
Example 2:

Input: n = 7
Output: 0
Explanation: 7 is not Dory because
its not present in the series.

Your Task:  
You dont need to read input or print anything. Complete the function nisDoryOrNot() which takes n as input parameter and returns 1 If n is "Dory" else return 0.

Expected Time Complexity: O(1)
Expected Auxiliary Space: O(1)

Constraints:
1<= n <=109
*/

//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            long n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.nisDoryOrNot(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    static long nisDoryOrNot(long n){
        // code here
        long x=5*n-4, y=5*n+4, x1=(long)Math.sqrt(x), y1=(long)Math.sqrt(y);
        
        return x1*x1==x || y1*y1==y ? 1 : 0;
    }
}
