/*
Given an array of n integers and a positive number k. We are allowed to take any k integers from the given array. The task is to find the minimum possible value of the difference between maximum and minimum of k numbers.

 

Example 1:

Input:
N=7
K=3
arr[] = {10, 100, 300, 200, 1000, 20, 30}
Output:
20
Explanation:
20 is the minimum possible difference 
between any maximum and minimum of any 
k numbers.Given k = 3, we get the result 
20 by selecting integers {10, 20, 30}.
max(10, 20, 30) - min(10, 20, 30) = 30 - 10 
= 20.
Example 2:

Input:
N=2
K=2
arr[] = { 1,1 }
Output:
0
Explanation:
max({1,1}) - min({1,1}) = 1 - 1 = 0

Your Task:
Since, this is a function problem. You don't need to take any input, as it is already accomplished by the driver code. You just need to complete the function minDiff() that takes array arr, integer N and integer K as parameters and return the value of friendliness for the given array.

 

Expected Time Complexity: O(NLogN).
Expected Auxiliary Space: O(1).

 

Constraints:
2 ≤ N ≤ 105
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
    long minDiff(long a[] ,int N,int K)
    {
        Arrays.sort(a);
        
        int i=0, j=K-1;
        long res=Long.MAX_VALUE;
        
        while(j<N){
            if(a[j]-a[i]<res)
                res=a[j]-a[i];
            i++;
            j++;
        }
        
        return res;
    }
}


//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main (String[] args) throws IOException{
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while(testcases-- > 0){
//            int n=Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] a2 = line.trim().split("\\s+");
            int n =Integer.parseInt(a2[0]);
            int k =Integer.parseInt(a2[1]);
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            long a[]=new long[n];
            for(int  i=0;i<n;i++)
            {
                a[i]=Long.parseLong(a1[i]);
            }
            Solution ob=new Solution();
            //ArrayList<Long> ans=ob.smallestDifferenceTriplet(a,b,c,n);
            long ans=ob.minDiff(a,n,k);
            System.out.println(ans);
        }
    }
}






// } Driver Code Ends
