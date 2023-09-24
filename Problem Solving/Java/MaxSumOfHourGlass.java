/*
Given two integers N, M and a 2D matrix Mat of dimensions NxM, the task is to find the maximum sum of
an hourglass.
An hourglass is made of 7 cells in the following form.
    A B C
      D
    E F G

Example 1:

Input:
N=3,M=3
Mat=[[1,2,3],[4,5,6],[7,8,9]]
Output:
35
Explanation:
There is only one hour glass which is
1 2 3
   5
7 8 9 and its sum is 35.
Example 2:

Input:
N=2,M=3
Mat=[[1,2,3],[4,5,6]]
Output:
-1
Explanation:
There are no hour glasses in this matrix.

Your Task:
You don't need to read input or print anything. Your task is to complete the function findMaxSum() which takes the two integers N, M, and the 2D matrix Mat as input parameters and returns the maximum sum of an hourglass in the matrix. If there are no hourglasses, it returns -1.


Expected Time Complexity:O(N*M)
Expected Auxillary Space:O(1)


Constraints:
1<=N,M,Mat[i][j]<=1000 
*/

/*
It is evident from the definition of the hourglass that the number of rows and number of columns must be equal to 3. If we count the total number of hourglasses in a matrix, we can say that the count is equal to the count of possible top left cells in an hourglass. The number of top-left cells in an hourglass is equal to (R-2)*(C-2). Therefore, in a matrix total number of an hourglass is (R-2)*(C-2).
*/

//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s[] = read.readLine().split(" ");
            int N = Integer.parseInt(s[0]);
            int M = Integer.parseInt(s[1]);
            int Mat[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String S[] = read.readLine().split(" ");
                for (int j = 0; j < M; j++) {
                    Mat[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution ob = new Solution();
            System.out.println(ob.findMaxSum(N, M, Mat));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int findMaxSum(int N, int M, int Mat[][]) {
        // code here
        if(N<3 || M<3)
            return -1;
        int res=Integer.MIN_VALUE;
        
        for(int i=0; i<N-2; i++){
            for(int j=0; j<M-2; j++){
                int sum=Mat[i][j] + Mat[i][j+1] + Mat[i][j+2] +
                Mat[i+1][j+1] +
                Mat[i+2][j] + Mat[i+2][j+1] + Mat[i+2][j+2];
                res=Math.max(res, sum);
            }
        }
        return res;
    }
};
