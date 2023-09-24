/*
GIven two different arrays A and B of size N and M, the task is to merge the two arrays which are unsorted into another array which is sorted.

 

Example 1:

Input: N = 3, M = 3
A[] = {10, 5, 15}
B[] = {20, 3, 2}
Output: 2 3 5 10 15 20
Explanation: After merging both the 
array's and sorting it with get the 
desired output.  

Example 2:

Input: N = 4, M = 3
A[] = {1, 10, 5, 15}
B[] = {20, 0, 2}
Output: 0 1 2 5 10 15 20

Your Task:
This is a function problem. You don't need to take any input, as it is already accomplished by the driver code. You just need to complete the function sortedMerge() that takes array A, array B, array res, integer N, and integer M as parameters and stores merged and sorted array in array res.

 

Expected Time Complexity: O (NlogN + MlogM + (N + M))
Expected Auxiliary Space: O(N+M).

 

Constraints:
1 ≤ N, M ≤ 105
*/

//{ Driver Code Starts
//Initial Template for Java


//Initial Template for Java



import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java


class Solution
{
    void sortedMerge(long A[], long B[], long res[], int N,int M)
    {
        // Your code goes here
        int i=0, j=0, k=0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        while(i<N && j<M){
            if(A[i]<B[j])
                res[k++]=A[i++];
            else
                res[k++]=B[j++];
        }
        
        while(i<N){
            res[k++]=A[i++];
        }
        
        while(j<M){
            res[k++]=B[j++];
        }
    }
}


//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {
//            int n = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] q = line.trim().split("\\s+");
            int n =Integer.parseInt(q[0]);
            int m =Integer.parseInt(q[1]);
//            //int y =Integer.parseInt(q[2]);
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            long a[] = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(a1[i]);
            }
            String line2 = br.readLine();
            String[] a2 = line2.trim().split("\\s+");
            long b[] = new long[m];
            for (int i = 0; i < m; i++) {
                b[i] = Long.parseLong(a2[i]);
            }
            long res[] = new long[500001];
            Solution ob = new Solution();
            ob.sortedMerge(a,b,res,n,m);
            for (int i = 0; i < n+m; i++)
                System.out.print(res[i]+" ");
            System.out.println();
        }
    }
}




// } Driver Code Ends
