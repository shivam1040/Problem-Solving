/*
Given a number X find the total numbers A such that A OR X > X,  and 1<=A<=X.

Example 1:

Input: X = 10
Output: 7 
Explanation: In the range [1,10] if the 
OR is taken of 10 and any number in the 
set {1,3,4,5,6,7,9} the resulting value 
will be greater than 10.
Example 2:

Input: X = 5
Output: 2
Explanation: In the range [1,5] if the
OR is taken of 5 and any number in the
set {2,3} the resulting value
will be greater than 5.

Your Task:  
You dont need to read input or print anything. Complete the function getCount() which takes X as input parameter and returns the the total count of the different value of A possible.

Expected Time Complexity: O(logn)
Expected Auxiliary Space: O(1)

Constraints:
1<= X <=108
*/

//{ Driver Code Starts
// Initial template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int X = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.getCount(X));
        }
    }
}
// } Driver Code Ends


// User function template for Java
class Solution {
    static int getCount(int X) {
        // code here
        int count=0, n=X;
        
        while(n!=0){
            if((n&1)==1)
                count++;
            n>>=1;
        }
        return (X-(int)Math.pow(2, count)+1);
    }
}
