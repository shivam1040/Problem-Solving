/*
Given an array arr[] of N integers, the task is to find a subsequence of size K whose product is maximum among all possible K sized subsequences of a given array.

Example 1:

Input: N = 4, K = 2
arr[] = {1, 2, 0, 3} 
Output: 6
Explanation: Subsequence containing 
elements {2, 3} gives maximum product: 
2*3 = 6
Example 2:

Input: N = 6, K = 4
arr[] = {1, 2, -1, -3, -6, 4}
Output: 144
Explanation: Subsequence containing 
{2, -3, -6, 4} gives maximum product: 
2*(-3)*(-6)*4 = 144
Your Task:
This is a function problem. You don't need to take any input, as it is already accomplished by the driver code. You just need to complete the function maxProductSubarrayOfSizeK() that takes array arr[], integer N and integer K as parameters and returns the desired product.

 

Expected Time Complexity: O(NlogN).
Expected Auxiliary Space: O(1).

 

Constraints:
1 ≤ N ≤ 105


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
    long maxProductSubarrayOfSizeK(long A[], int n,int k)
    {
        Arrays.sort(A);
        
                List<Long> aux = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            aux.add(A[i]); // Populate the ArrayList with sorted elements
        }

        for (int i = 0; i < n; i++) {
            aux.add(A[i]); // Add the sorted elements again to create a circular array so that it does not overflow when finding product over range
        }
        
        int l=0, r=k-1;
        long res=Long.MIN_VALUE;
        
        while(l<n){
            long temp=1;
            //finding product over range and its max
            for(int i=l; i<=r; i++)
                temp*=aux.get(i);
            res=Math.max(res, temp);
            l++;
            r++;
        }
        return res;
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
            int k =Integer.parseInt(q[1]);
//            //int y =Integer.parseInt(a2[2]);
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            long a[] = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(a1[i]);
            }
            Solution ob = new Solution();
            //ArrayList<Long> ans=ob.smallestDifferenceTriplet(a,b,c,n);
            long ans = ob.maxProductSubarrayOfSizeK(a,n,k);
            System.out.println(ans);
        }
    }
}




// } Driver Code Ends
