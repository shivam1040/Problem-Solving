/*
Height of tree, h = 1 + max(left height, right height)
Since the difference between the heights of left and right subtree is not more than one, possible heights of left and right part can be one of the following: 
 

(h-1), (h-2)
(h-2), (h-1)
(h-1), (h-1)
count(h) = count(h-1) * count(h-2) + 
           count(h-2) * count(h-1) + 
           count(h-1) * count(h-1)
        = 2 * count(h-1) * count(h-2) +  
          count(h-1) * count(h-1)
       = count(h-1) * (2*count(h - 2) + 
                          count(h - 1))

*/

/*
Given a height h, count the maximum number of balanced binary trees possible with height h. Print the result modulo 109 + 7.
Note : A balanced binary tree is one in which for every node, the difference between heights of left and right subtree is not more than 1.

Example 1:

Input: h = 2
Output: 3 
Explanation: The maximum number of balanced 
binary trees possible with height 2 is 3. 

Example 2:

Input: h = 3
Output: 15
Explanation: The maximum number of balanced
binary trees possible with height 3 is 15. 

Your Task:  
You dont need to read input or print anything. Complete the function countBT() which takes h as input parameter and returns the maximum number of balanced binary trees possible with height h. 

Expected Time Complexity: O(h)
Expected Auxiliary Space: O(h)

Constraints:
1<= n <=103
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
            int h = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.countBT(h));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    static long countBT(int h){
        // code here
        long dp0=1, dp1=1, dp2=3;
        
        if(h<2)
            return 1;
        for(int i=2; i<=h; i++){
            dp2=(dp1*dp1 + 2*dp1*dp0)%1000000007;
            dp0=dp1;
            dp1=dp2;
        }
        return dp2;
    }
}
