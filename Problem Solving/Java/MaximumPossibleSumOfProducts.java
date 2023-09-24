/*
You will be given two arrays A and B of positive integers. The number of values in both the arrays will be the same say N. Your task is to find the maximum sum of products of their elements. Each element in A has to be multiplied with exactly one element in B and vice versa such that each element of both the arrays appears exactly once and the sum of product produced is maximum.

if A = {5,1,3,4,2} and B = {8,10,9,7,6} then a possible sum of product is 5*6 + 1*7 + 3*9 + 4*10 + 2*8.

Example 1:

Input:
N = 3
A[] = {1, 2, 3}
B[] = {4, 5, 1}
Output: 24
Explanation: 5*3 + 4*2 + 1*1 = 24
Example 2:

Input:
N = 2
A[] = {1, 2}
B[] = {4, 4}
Output: 12
Explanation: 4*2 + 4*1 = 12
Your Task:  
You don't need to read input or print anything. Your task is to complete the function MaxSum() which takes the array A[], B[], and N as inputs and returns the answer.

Expected Time Complexity: O(N * log N)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ N ≤ 105
1 ≤ A[i], B[i] ≤ 105
*/

//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            int N = Integer.parseInt(read.readLine().trim());
            long []A = new long[N];
            long []B = new long[N];
            String input_line[] = read.readLine().trim().split("\\s+");
            for(int i=0;i<N;i++)
                A[i]=Integer.parseInt(input_line[i]);
            input_line = read.readLine().trim().split("\\s+");
            for(int i=0;i<N;i++)
                B[i]=Integer.parseInt(input_line[i]);
            
            Solution obj = new Solution();
            System.out.println(obj.MaxSum(A, B, N));
            
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    long MaxSum(long []A, long []B, int N) 
    { 
        // code here
        Arrays.sort(A);
        Arrays.sort(B);
        
        long res=0;
        
        for(int i=0; i<N; i++)
            res+=A[i]*B[i];
        
        return res;
    }
} 
