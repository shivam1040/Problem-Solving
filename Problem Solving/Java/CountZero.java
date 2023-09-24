/*
Given a number d, representing the number of digits of a number. Find the total count of positive integers which have at-least one zero in them and consist d or less digits.

Example 1:

Input: d = 2
Output: 9 
Explanation: There are total 9 
positive integers which have 
at-least one zero in them 
and consist 2 or less digits.
Example 2:

Input: d = 3
Output: 180
Explanation: There are total 180
positive integers which have
at-least one zero in them
and consist 3 or less digits.

Your Task:  
You dont need to read input or print anything. Complete the function findCountUpto() which takes d as input parameter and returns the total count of positive integers which have at-least one zero in them and consist d or less digits.

Expected Time Complexity: O(logn)
Expected Auxiliary Space: O(1)

Constraints:
1<= d <=15


*/

/*
For d = 3;

v1 = 9X10X10 = 900

v2 = 9X9X9 = 729

v3 = 900 - 729 = 171

v4 = findCount(2) = 9

result = 171+9 = 180

 

For d = 4;

v1 = 9x10x10x10 = 9000

v2 = 9x9x9x9 = 6561

v3 = 9000 - 6561 = 2439

v4 = findCount(3) = 180

result = 2439 + 180 = 2619
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
            long d = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.findCountUpto(d));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    static long findCountUpto(long d){
        // code here
        long sum=0;
        //based on formula
        for(long i=2; i<=d; i++)
            sum+=(9 * ((long)Math.pow(10, i - 1)- (long)Math.pow(9, i - 1)));
        return sum;
    }
}
