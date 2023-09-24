/*
Given an array of integers, check whether there is a subsequence with odd sum and if yes, then finding the maximum odd sum. If no subsequence contains odd sum, print -1.


Example 1:

Input:
N=4
arr[] = {4, -3, 3, -5}
Output: 7
Explanation:
The subsequence with maximum odd
sum is 4 + 3 = 7

Example 2:

Input:
N=5
arr[] = {2, 5, -4, 3, -1}
Output: 9
Explanation:
The subsequence with maximum odd 
sum is 2 + 5 + 3 + -1 = 9

Your Task:
Since, this is a function problem. You don't need to take any input, as it is already accomplished by the driver code. You just need to complete the function findMaxOddSubarraySum() that takes array arr and integer N as parameters and returns the desired value.
 

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).


Constraints:
2 ≤ N ≤ 107
-103 <= arr[i] <= 103
*/

//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java


class Solution
{
    long findMaxOddSubarraySum(long arr[] ,int n)
    {
        //basic idea is to find the sum of positive numbers and then if the end result is even then subtract the smallest odd number to make the whole sum max odd
        long minOdd=Integer.MAX_VALUE, sum=0;
        boolean isOdd=false;
        
        for(long i:arr){
            if(i>0)
                sum+=i;
            if(i%2!=0){
                isOdd=true;
                
                if(minOdd>Math.abs(i))
                    minOdd=Math.abs(i);
            }
        }
        //we need one odd ele to make the sum odd
        if(!isOdd)
            return -1;
        if(sum%2==0)
            sum-=minOdd;
        return sum;
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
            //ArrayList<Long> ans=ob.smallestDifferenceTriplet(a,b,c,n);
            long ans=ob.findMaxOddSubarraySum(a,n);
            System.out.println(ans);
        }
    }
}





// } Driver Code Ends
