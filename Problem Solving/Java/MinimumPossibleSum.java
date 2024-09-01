/*
Given two arrays A and B of size N, the task is to find the maximum sum possible of a window in array B such that elements of the same window in array A are unique.

Example 1:

Input: N = 7
A = [0, 1, 2, 3, 0, 1, 4] 
B = [9, 8, 1, 2, 3, 4, 5] 
Output: 20
Explanation: The maximum sum possible 
in B[] such that all corresponding 
elements in A[] are unique is 
(9+8+1+2) = 20.
 

Example 2:

Input: N = 5
A = [0, 1, 2, 0, 2]
B = [5, 6, 7, 8, 2]
Output:  21

â€‹Your Task:
This is a function problem. You don't need to take any input, as it is already accomplished by the driver code. You just need to complete the function returnMaxSum() that takes array A, array B, and integer N as parameters and returns the maximum possible sum.

 

Expected Time Complexity: O(N). 
Expected Auxiliary Space: O(N).

 

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
    long returnMaxSum(long A[], long B[],int N)
    {
        // Your code geos here
        long temp=0, res=Long.MIN_VALUE;
        Map<Long, Integer> aux=new HashMap<>();
        
        for(int i=0; i<N; i++){
            temp+=B[i];
            
            if(aux.containsKey(A[i])){
                i=aux.get(A[i]);
                temp=0;
                
                aux.remove(A[i]);
                aux=new HashMap<>();
                continue;
            }
            aux.put(A[i], i);
            if(temp>res)
                res=temp;
        }
        return res;
    }
}

// 0 1 5 1 0 2
// 5 6 7 5 8 2

// 5 6 

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
            int n = Integer.parseInt(br.readLine());
//            String line = br.readLine();
//            String[] q = line.trim().split("\\s+");
//            int n =Integer.parseInt(q[0]);
//            int m =Integer.parseInt(q[1]);
//            //int y =Integer.parseInt(q[2]);
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            long a[] = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(a1[i]);
            }
    //        int k = Integer.parseInt(br.readLine());
            String line2 = br.readLine();
            String[] a2 = line2.trim().split("\\s+");
            long b[] = new long[n];
            for (int i = 0; i < n; i++) {
                b[i] = Long.parseLong(a2[i]);
            }
            Solution ob = new Solution();
            long ans=ob.returnMaxSum(a,b,n);
            System.out.println(ans);
        }
    }
}




// } Driver Code Ends
