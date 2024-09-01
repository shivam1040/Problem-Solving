/*
Given an array of n elements, update all elements of given array to some minimum value x i.e, arr[i] = x (0 <= i < n), such that product of all elements of this new array is strictly greater than the product of all elements of the initial array.

Example 1:

Input:
N=5
arr[] = {4, 2, 1, 10, 6} 
Output: 4
Explanation:
4 is the smallest value such that  
4 * 4 * 4 * 4 * 4 > 4 * 2 * 1 * 10 * 6.  

Example 2:

Input:
N=5
arr[] = {100, 150, 10000, 123458, 90980454} 
Output: 17592

Your Task:
Since, this is a function problem. You don't need to take any input, as it is already accomplished by the driver code. You just need to complete the function findMinValue() that takes array arr and n as parameters and return the desired minimum value.

 

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

 

Constraints:
1 ≤ N ≤ 105
 1 <= arr[i] <= 1010
*/

//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class Solution
{
    static long findMinValue(long arr[], int n)  
    {
        //code here.
        double EPS=1E-15, sum=0;
        
        for(long i:arr)
            sum+=Math.log10(i)+EPS;
        double x1=(double)(sum/n+EPS), res=Math.pow(10.0, x1)+EPS;
        
        return (long)Math.ceil(res+EPS);
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
		    for(int i=0;i<n;i++)
		    {
		        a[i]=Long.parseLong(a1[i]);
		    }
		    Solution ob=new Solution();
		    System.out.println(ob.findMinValue(a,n));
		}
	}
}

// } Driver Code Ends

/*
By knowing the fact that product of n elements is P, if we have to find n-th root of P. To find the n-th root of product, we can simply divide n from sum of log of n elements of array and then ceil of antilog will be our answer to the problem, i.e., 

ans = ceil(antilog(log(x)/n)) 
ans = ceil(power(10, log(x)/n)) 
*/
