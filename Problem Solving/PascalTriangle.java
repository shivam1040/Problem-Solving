/*
Given a positive integer N, return the Nth row of pascal's triangle.
Pascal's triangle is a triangular array of the binomial coefficients formed by summing up the elements of previous row.

Example :
1
1 1
1 2 1
1 3 3 1
For N = 3, return 3rd row i.e 1 2 1

Example 1:

Input:
N = 4
Output: 1 3 3 1
Explanation: 4th row of pascal's triangle
is 1 3 3 1.
Example 2:

Input:
N = 5
Output: 1 4 6 4 1
Explanation: 5th row of pascal's triangle
is 1 4 6 4 1.
 

Your Task:
Complete the function nthRowOfPascalTriangle() which takes n, as input parameters and returns an array representing the answer. The elements can be large so return it modulo 109 + 7. You don't to print answer or take inputs.

Expected Time Complexity: O(N2)
Expected Auxiliary Space: O(N2)

Constraints:
1 ≤ N ≤ 1000
*/

//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());

            ArrayList<Long> ans = new Solution().nthRowOfPascalTriangle(n);
            printAns(ans);
        }
    }
    public static void printAns(ArrayList<Long> ans) {
        for (Long x : ans) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    ArrayList<Long> nthRowOfPascalTriangle(int n) {
        // code here
        ArrayList<ArrayList<Long>> res=new ArrayList<>();
        ArrayList<Long> currRow, prevRow=null;
        
        //pascal triangle is basically , for a given row and column in triangle the element is sum of previous row element which is adjacent to left and right of aforementioned element
        
        for(int i=0; i<n; i++){
            currRow=new ArrayList<Long>();
            for(int j=0; j<=i; j++)
                if(j==0 || j==i)
                    currRow.add(1L); //as per pascal, first and last element of row are always 1
                else
                    currRow.add((prevRow.get(j-1)%1000000007+prevRow.get(j)%1000000007)%1000000007); //applying the same logic as above comment
            prevRow=currRow; //saving state for next calculation
            res.add(currRow);
        }
        return res.get(n-1);
    }
}
