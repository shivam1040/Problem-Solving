/*
Given an array of N elements, find the minimum number of insertions to convert the given array into a co-prime array adjacent pair-wise. 

Example 1:

Input: A[] = {2, 7, 28}
Output: 1
Explanation: Here, 1st pair = {2, 7}
are co-primes( gcd(2, 7) = 1). 2nd pair
= {7, 28} are not co-primes, insert 9
between them. gcd(7, 9) = 1 and
gcd(9, 28) = 1.
Example 2:

Input: A[] = {5, 10, 20}
Output : 2
Explanation: Here, there is no pair
which are co-primes. Insert 7 between
(5, 10) and 1 between (10, 20).
Your Task:
The input is already taken care of by the driver code. You only need to complete the function countCoPrime() that takes an array (arr), sizeOfArray (n), and return the minimum number of insertions. The driver code takes care of the printing.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Constraints:
1<=N<=105
1<=arr<=105
*/

/*
Observe that to make a pair to become co-primes we have to insert a number which makes the newly formed pairs co-primes. So, we have to check every adjacent pair for their co-primality and insert a number if required. Now, what is the number that should be inserted? Let us take two numbers a and b. If any of a or b is 1, then GCD(a, b) = 1. So, we can insert ONE(1) at every pair. 
*/

//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class Solution{
    int countCoPrime(int a[], int n)
    {
        // Complete the function
        int res=0;
        
        for(int i=1; i<n; i++)
            if(gcd(a[i], a[i-1])!=1)
                res++;
        return res;
    }
    
    private int gcd(int a, int b)
    {
        // Everything divides 0
        if (a == 0 || b == 0)
        return 0;
     
        // base case
        if (a == b)
            return a;
     
        // a is greater
        if (a > b)
            return gcd(a-b, b);
 
        return gcd(a, b-a);
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
		    int sizeOfArray = Integer.parseInt(br.readLine());
		    int arr [] = new int[sizeOfArray];
		    
		    String line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    
		    Solution obj = new Solution();
		    int res = obj.countCoPrime(arr, sizeOfArray);
		    System.out.println(res);
		}
	}
}


        

// } Driver Code Ends
