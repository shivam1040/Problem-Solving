/*
You are given an array arr[] of size n. Find the total count of sub-arrays having their sum equal to 0.


Examples:

Input: n = 6, arr[] = {0,0,5,5,0,0}
Output: 6
Explanation: The 6 subarrays are [0], [0], [0], [0], [0,0], and [0,0].
Input: n = 10, arr[] = {6,-1,-3,4,-2,2,4,6,-12,-7}
Output: 4
Explanation: The 4 subarrays are [-1 -3 4], [-2 2], [2 4 6 -12], and [-1 -3 4 -2 2]
Expected Time Complexity: O(n*log(n))
Expected Auxilliary Space: O(n)

Constraints:    
1 <= n <= 10^6
-10^9 <= arr[ i ] <= 10^9
*/

/*
Intuition
The idea is to store frequency of prefix sum of array elements in a map (hashmap) while traversing it. If the same sum occurs again then increase the count by frequency of that sum.

Implementation
Initialize 2 variables sum and counter as 0, and map mp to store frequency of sum.
Run a loop from 0th to (n - 1)th index,
Update the sum by adding arr[i] into it.
Increase the counter by 1 if sum becomes 0. If sum is zero then Sub-array from index 0 to i is having sum 0.
Increase the counter by frequency of sum if it already present in mp, If it is already present then it means that same sum already occurred in previous indexes so sum of elements from those indexes+1 to index i will be having sum 0.
Increase the frequency of sum by 1 in mp.
Return counter as answer. 
Example:

*/

//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		sc.nextLine();
		while(t-->0)
		{
		    int n;
		    n=sc.nextInt();
		    
		    long arr[]=new long[n];
	
		    
		    for(int i=0;i<n;i++)
		    {
		        arr[i]=sc.nextLong();
		    }
            Solution ob = new Solution();
		    System.out.println(ob.findSubarray(arr,n));
		}
		
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    //Function to count subarrays with sum equal to 0.
    public static long findSubarray(long[] arr ,int n) 
    {
        //Your code here
        long ans=0;
        Map<Long, Long> freq=new HashMap<>();
        long[] p=new long[n];
        p[0]=arr[0];
        
        for(int i=1; i<n; i++)
            p[i]=p[i-1]+arr[i];
        for(long i:p){
            if(freq.containsKey(i))
                ans+=freq.getOrDefault(i, 0L);
            freq.put(i, freq.getOrDefault(i, 0L)+1);
            if(i==0)
                ans++;
        }
        return ans;
    }
}
