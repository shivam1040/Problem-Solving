/*
Given an array arr[] of integers of size N and a number X, the task is to find the sum of subarray having maximum sum less than or equal to the given value of X.

Example 1:

Input: N = 5, X = 11
arr[] = {1, 2, 3, 4, 5} 
Output:  10
Explanation: Subarray having maximum 
sum is {1, 2, 3, 4}.
 
Example 2:

Input: N = 5, X = 7
arr[] = {2, 4, 6, 8, 10} 
Output:  6
Explanation: Subarray having maximum 
sum is {2, 4} or {6}.
 

Your Task:
This is a function problem. You don't need to take any input, as it is already accomplished by the driver code. You just need to complete the function calculateMaxSumLength() that takes array arr, integer N, and integer X as parameters and returns maximum sum of any subarray that is less than or equal to x.

 

Expected Time Complexity: O(N). 
Expected Auxiliary Space: O(1).

 

Constraints:
1 ≤ N ≤ 106
1 ≤ arr[i] ≤ 104
*/

/*
 The subarray having maximum sum can be found by using a sliding window. If curr_sum is less than sum include array elements to it. If it becomes greater than sum removes elements from start in curr_sum.  (This will work only in the case of non-negative elements.)
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
    long findMaxSubarraySum(long arr[], int N,int X)
    {
        // Your code goes here  int sum=arr[0];
            int start=0;
            int end=0;
            long res=0;
            long sum=arr[0];
            
            for(int i=1; i<arr.length; i++){
                
                if(sum<=X){
                    //end=i-1;
                    if(sum>res)
                        res=sum;
                }
                
                while(sum+arr[i]>X && start<i){
                    sum-=arr[start]; //subtracting elements from starting if sum is higher
                    start++;
                }
                
                    sum+=arr[i];
            }
            
             if(sum<=X){
                    //end=i-1;
                    if(sum>res)
                        res=sum;
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

        int testcases = Integer.parseInt(br.readLine().trim());
        // looping through all testcases
        while (testcases-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
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
            int k = Integer.parseInt(br.readLine().trim());
//            String line2 = br.readLine();
//            String[] a2 = line2.trim().split("\\s+");
//            long b[] = new long[n];
//            for (int i = 0; i < n; i++) {
//                b[i] = Long.parseLong(a2[i]);
//            }
            Solution ob = new Solution();
            long ans=ob.findMaxSubarraySum(a,n,k);
            System.out.println(ans);
        }
    }
}




// } Driver Code Ends
