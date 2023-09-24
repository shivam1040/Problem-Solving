/*
Like people, numbers are also friends with each other. Friendliness between any two numbers a and b is defined as the absolute difference between the two. Lower is this number more friendly the numbers are. Now you are given an array of numbers and you are required to find the friendliness of this array. This can be calculated as the sum of the friendliness of each element in the array with its closest friend in the same array.

Example 1:

Input:
N=3
arr[] = { 4,1,5 }
Output: 5
Explanation: Sum of absolute differences is
            |4-5| + |1-4| + |5-4| = 5
Example 2:

Input:
N=3
arr[] = { 1,1,1 }
Output: 0
Explanation: Sum of absolute differences is 
             |1-1| + |1-1| + |1-1| = 0

Your Task:
Since, this is a function problem. You don't need to take any input, as it is already accomplished by the driver code. You just need to complete the function sumOfMinAbsDifferences() that takes array arr and integer N as parameters and return the value of friendliness for the given array.

Expected Time Complexity: O(NLogN).
Expected Auxiliary Space: O(1).

Constraints:
2 ≤ N ≤ 105
*/

/*
The following steps are:

Sort the array of size n.
For the 1st element of array its min absolute difference is calculated using the 2nd array element.
For the last array element its min absolute difference is calculated using the 2nd last array element.
For the rest of the array elements, 1 <= i <= n-2, minimum absolute difference for an element at index i is calculated as: minAbsDiff = min( abs(arr[i] – arr[i-1]), abs(ar[i] – arr[i+1]) ).
*/

//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java



class Solution
{
    long sumOfMinAbsDifferences(long arr[] ,int N)
    {
        long res=0;
        
        Arrays.sort(arr);
        
        res+=Math.abs(arr[0]-arr[1]);
        res+=Math.abs(arr[N-1]-arr[N-2]);
        
        for(int i=1; i<N-1; i++)
            res+=Math.min(Math.abs(arr[i]-arr[i-1]), Math.abs(arr[i]-arr[i+1]));
        
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
            int n=Integer.parseInt(br.readLine());
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            long a[]=new long[n];
            for(int  i=0;i<n;i++)
            {
                a[i]=Long.parseLong(a1[i]);
            }
            Solution ob=new Solution();
            long ans=ob.sumOfMinAbsDifferences(a,n);
            System.out.println(ans);
        }
    }
}




// } Driver Code Ends
