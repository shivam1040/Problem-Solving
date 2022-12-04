/*
Given an array of n distinct elements. Check whether the given array is a k sorted array or not. A k sorted array is an array where each element is at most k distance away from its target position in the sorted array.


Example 1:

Input:
N=6
arr[] = {3, 2, 1, 5, 6, 4} 
K = 2
Output: Yes
Explanation:
Every element is at most 2 distance 
away from its target position in the
sorted array.  
Example 2:

Input:
N=7
arr[] = {13, 8, 10, 7, 15, 14, 12}
K = 1
Output: No

Your Task:
Since, this is a function problem. You don't need to take any input, as it is already accomplished by the driver code. You just need to complete the function isKSortedArray() that takes array arr, integer n and integer k as parameters and return "Yes" if the array is a k sorted array else return "No".


Expected Time Complexity: O(NlogN).
Expected Auxiliary Space: O(N).


Constraints:
1 ≤ N ≤ 105
0 ≤ K ≤ N
*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java


class Solution
{ 
    static String isKSortedArray(int arr[], int n, int k) 
    { 
        // code 
        //idea is to copy the  array then sort the original array, using binary search find the index and check if abs is at most k
        int aux[]=Arrays.copyOf(arr, n);
        String res="No";
        
        Arrays.sort(arr);
        
        for(int i=0; i<n; i++){
            int low=0, high=n-1;
            
            while (high - low > 1) {
                int mid = (high + low) / 2;
                if (arr[mid] < aux[i]) {
                    low = mid + 1;
                }
                else {
                    high = mid;
                }
            }
            
            if(arr[low]==aux[i] && Math.abs(low-i)<=k)
                res="Yes";
            else if(arr[high]==aux[i] && Math.abs(high-i)<=k)
                res="Yes";
            else{
                res="No";
                break;
            }
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
		    int n=Integer.parseInt(br.readLine());
		    String line1 = br.readLine();
		    String[] a1 = line1.trim().split("\\s+");
		    int a[]=new int[n];
		    for(int i=0;i<n;i++)
		    {
		        a[i]=Integer.parseInt(a1[i]);
		    }
		    int k=Integer.parseInt(br.readLine());
		    Solution ob=new Solution();
		    String ans=ob.isKSortedArray(a,n,k);
		    System.out.println(ans);
		    
		}
	}
}
// } Driver Code Ends
