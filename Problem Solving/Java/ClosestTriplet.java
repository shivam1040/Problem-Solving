/*
Given three sorted arrays A[] of size P, B[] of size Q and C[] of size R.Find a number X such that when  3 elements i, j and k are chosen from A, B and C respectively,then X=max(abs(A[i] – B[j]), abs(B[j] – C[k]), abs(C[k] – A[i])) is minimized. Here abs() indicates absolute value.

Example 1:

Input: 
P=3
A[] = {1, 4, 10}
Q=3
B[] = {2, 15, 20}
R=2
C[] = {10, 12}
Output:
5
Explanation:
We take 10 from A, 15 from B and
10 from C, so,
X=max(abs(10-15),abs(15-12),abs(10-10))
which gives X=18
Example 2:

Input: 
P=3
A[] = {20, 24, 100}
Q=5
B[] = {2, 19, 22, 79, 800}
R=5
C[] = {10, 12, 23, 24, 119}
Output:
2
Explanation:
We take 24 from A,22 from B and 24 from C.X
=max(abs(24-22),max(abs(24-22),abs(24-24)))
which is 2.

Your Task:
You don't need to read input or print anything.Your task is to complete the function findClosest() which takes P,Q,R,A[],B[],C[] as input parameters and returns the minimum X where X=max(abs(A[i]-B[j]),max(abs(A[i]-C[k]),abs(B[j]-C[k]))).


Expected Time Complexity:O(P+Q+R)
Expected Auxillary Space:O(1)


Constraints:
1<=P,Q,R<=104
1<=A[i],B[j],C[k]<=106 where 0<=i<P , 0<=j<Q , 0<=k<R
*/

/*
Try to have all three numbers as close as possible to one another to get the desired answer
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
            int P, Q, R, i;
            P = Integer.parseInt(read.readLine());
            int A[] = new int[P];
            String s1[] = read.readLine().split(" ");
            for (i = 0; i < P; i++) A[i] = Integer.parseInt(s1[i]);
            Q = Integer.parseInt(read.readLine());
            int B[] = new int[Q];
            String s2[] = read.readLine().split(" ");
            for (i = 0; i < Q; i++) B[i] = Integer.parseInt(s2[i]);
            R = Integer.parseInt(read.readLine());
            int C[] = new int[R];
            String s3[] = read.readLine().split(" ");
            for (i = 0; i < R; i++) C[i] = Integer.parseInt(s3[i]);
            Solution ob = new Solution();
            System.out.println(ob.findClosest(P, Q, R, A, B, C));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int findClosest(int P, int Q, int R, int A[], int B[], int C[]) {
        // code here
        int i=0, j=0, k=0, ans=Integer.MAX_VALUE;
        int a, b, c;
        
        while(i<P && j<Q && k<R){
            a=Math.abs(A[i]-B[j]);
            b=Math.abs(B[j]-C[k]);
            c=Math.abs(C[k]-A[i]);
            int temp=Math.max(a, Math.max(b, c));
            
            if(temp<ans)
                ans=temp;
            int min=Math.min(A[i], Math.min(B[j], C[k]));
            
            if(A[i]==min)
                i++;
            else if(B[j]==min)
                j++;
            else
                k++;
        }
        return ans;
    }
};
