/*
Given three integers N, M, and K and a matrix Mat of dimensions NxM. Left rotate the matrix K times.

Example 1:

Input:
N=3,M=3,K=1
Mat=[[1,2,3],[4,5,6],[7,8,9]]
Output:
2 3 1
5 6 4
8 9 7
Explanation:
Left rotating the matrix once gives this result.
Example 2:

Input:
N=3,M=3,K=2
Mat=[[1,2,3],[4,5,6],[7,8,9]]
Output:
3 1 2
6 4 5
9 7 8
Explanation:
Left rotating the matrix twice gives this result

Your Task:
You don't need to read input or print anything. Your task is to complete the function rotateMatrix() which takes the three integers N, M, K, and the matrix Mat and returns the matrix Mat left rotated K times.


Expected Time Complexity:O(N*M)
Expected Auxillary Space:O(N*M)


Constraints:
1<=N,M,Mat[i][j]<=1000
1<=K<=10000
*/

//{ Driver Code Starts
// Initial Template for java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            int N = Integer.parseInt(S[0]);
            int M = Integer.parseInt(S[1]);
            int K = Integer.parseInt(S[2]);
            int Mat[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String S1[] = read.readLine().split(" ");
                for (int j = 0; j < M; j++) {
                    Mat[i][j] = Integer.parseInt(S1[j]);
                }
            }
            Solution ob = new Solution();
            int ans[][] = ob.rotateMatrix(N, M, K, Mat);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) System.out.print(ans[i][j] + " ");
                System.out.println();
            }
        }
    }
}

// } Driver Code Ends


// User function template for java

class Solution {
    int[][] rotateMatrix(int N, int M, int K, int Mat[][]) {
        // code here
        int ans[][]=new int[N][M];
        
        for(int i=0; i<M; i++){
            int j=(i+K)%M;
            for(int l=0; l<N; l++){
                ans[l][i]=Mat[l][j];
            }
        }
        
        return ans;
    }
};
