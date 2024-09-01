/*
Given a matrix of size NxM and a list of queries containing (a,b) pairs. Find the maximum sum among all (a x b) sub-matrices of the matrix. 
Note: The rows and columns of the submatrix must be contiguous. For example:


Example 1:

Input:
N = 3, M = 4
mat[][] = {{1, 2, 3, 9}, 
           {4, 5, 6, 2}, 
           {8, 3, 2, 6}}
Q = 1
Queries[] = {(3,2)}

Output: 28

Explanation:
Here a = 3 and b = 2.

The first 3x2 submatrix is:
1 2
4 5
8 3
The sum of elements in this is 23.

The second 3x2 submatrix is:
2 3
5 6
3 2
The sum of elements in this is 21.

The third 3x2 submatrix is:
3 9
6 2
2 6
The sum of elements in this is 28.

The maximum among these is 28.

Example 2:

Input:
N = 3, M = 4
mat[][] = {{1, 2, 3, 9}, 
           {4, 5, 6, 2}, 
           {8, 3, 2, 6}}
Q = 3
Queries[] = {(1, 1), (2, 2), (3, 3)}

Output: 9 20 38

Example 3:

Input:
N = 2, M = 7
mat[][] = {{49, 44, 46, 22, 24, 11, 2}, 
           {5, 25, 24, 28, 20, 47, 47}}
Q = 1
Queries = {(2, 1)}

Output: 70

Your Task:
You don't need to read input or print anything. Your task is to complete the function maxSubMatrixSumQueries() which takes the 2D array of integers mat, n, m, queries and q as input parameters and returns an array of integers denoting the maximum sum for each query.

 

Expected Time Complexity: O(Q*N*M)
Expected Auxiliary Space: O(N*M)

 

Constraints:
1 ≤ N ≤ 103
1 ≤ M ≤ 103
1 ≤ Q ≤ 100
1 ≤ a ≤ N
1 ≤ b ≤ M
1 ≤ mat[i][j] ≤ 103


*/

/*
The code finds the maximum sum among all (a x b) submatrices of a given matrix by using a technique called dynamic programming. Here's the intuition behind how it works:

Cumulative Sum Matrix (Prefix Sum):

The code starts by creating a cumulative sum matrix (cumSum) that stores the cumulative sums of elements in the original matrix. This matrix helps in calculating the sum of any submatrix in constant time.
Iterating Through Submatrices:

It then iterates through all possible submatrices of dimensions (a x b) within the original matrix. It does this by considering different starting positions (i, j) for the submatrix.
Calculating Submatrix Sum:

For each submatrix, it calculates the sum of its elements using the cumulative sum matrix. This is done efficiently by using the cumulative sums of the four corners of the submatrix.
Updating Maximum Sum:

The code maintains a variable, maxSum, to keep track of the maximum sum found so far among all submatrices. If the sum of the current submatrix (currentSum) is greater than the current maxSum, it updates maxSum with this new maximum.
Return Maximum Sum:

After processing all possible submatrices, the code returns the maxSum, which represents the maximum sum among all (a x b) submatrices in the matrix.
In summary, the code efficiently calculates the maximum sum by precomputing cumulative sums and then, for each submatrix, using these cumulative sums to quickly compute the sum. By iterating through all submatrices, it identifies the one with the maximum sum, providing an optimized solution for this problem.

cum sum for 3,2 means if we take the bottom left right and top right then we have sum of the entire 3x2 subarray withput need to traverse the subarray1
*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int m = Integer.parseInt(inputLine[1]);
            int[][] mat = new int[n][m];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    mat[i][j] = Integer.parseInt(inputLine[i * m + j]);
                }
            }
            int q = Integer.parseInt(br.readLine().trim());
            int[][] queries = new int[q][2];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < q; i++) {
                for (int j = 0; j < 2; j++) {
                    queries[i][j] = Integer.parseInt(inputLine[i * 2 + j]);
                }
            }
            int[] ans = new Solution().maxSubMatrixSumQueries(mat, n, m, queries, q);
            for (int xx : ans) {
                System.out.print(xx + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    int[] maxSubMatrixSumQueries(int[][] mat, int n, int m, int[][] queries, int q) {
        // code here
        int cuSum[][]=new int[n+1][m+1];
        int res[]=new int[q];
        
        for(int i=1; i<=n; i++)
            for(int j=1; j<=m; j++)
                cuSum[i][j]=cuSum[i-1][j]+cuSum[i][j-1]-cuSum[i-1][j-1]+mat[i-1][j-1];
        for(int i=0; i<q; i++){
            int max=Integer.MIN_VALUE, a=queries[i][0], b=queries[i][1];
            
            for(int j=a; j<=n; j++)
                for(int k=b; k<=m; k++){
                    int temp=cuSum[j][k]-cuSum[j-a][k]-cuSum[j][k-b]+cuSum[j-a][k-b];
                    
                    max=Math.max(max, temp);
                }
            res[i]=max;
        }
        return res;
    }
}
