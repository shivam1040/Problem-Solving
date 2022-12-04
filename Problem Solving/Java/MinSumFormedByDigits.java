/*
Given an array of digits (values are from 0 to 9), find the minimum possible sum of two numbers formed from digits of the array. All digits of the given array must be used to form the two numbers.

Any combination of digits may be used to form the two numbers to be summed.  Leading zeroes are permitted.

If forming two numbers is impossible (i.e. when n==0) then the "sum" is the value of the only number that can be formed.


 

 

Example 1:

Input:
N = 6
arr[] = {6, 8, 4, 5, 2, 3}
Output:
604
Explanation:
The minimum sum is formed by numbers 
358 and 246
 

Example 2:

Input:
N = 5
arr[] = {5, 3, 0, 7, 4}
Output:
82
Explanation:
The minimum sum is formed by numbers 
35 and 047


Your Task:
You don't have to print anything, printing is done by the driver code itself. Your task is to complete the function minSum() which takes the array A[] and its size N as inputs and returns the required sum.

Expected Time Complexity: O(N. log(N))
Expected Auxiliary Space: O(1)


Constraints:
1 ≤ N ≤ 35
0 ≤ A[] ≤ 9
*/

/*
Since we want to minimise the sum of two numbers to be formed, we must divide all digits in two halves and assign half-half digits to them. We also need to make sure that the leading digits are smaller.
*/

//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.minSum(a, n));
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java


class Solution {
    
    public static long minSum(int arr[], int n)
    {
        // Your code goes here
        long a=0, b=0;
        int i=0;
        
        //here the idea is to sort the elements and store digits in each variable a and b equally, like for 1234 so a will have 13 and b will have 24
        Arrays.sort(arr);
        while(i<n){
            a*=10;
            a+=arr[i++];
            if(i<n){
            b*=10;
            b+=arr[i++];
            }
        }
        return a+b;
    }
}
