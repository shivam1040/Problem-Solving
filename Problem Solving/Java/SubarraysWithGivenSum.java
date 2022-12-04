/*
Given an unsorted array of integers and a sum. The task is to count the number of subarray which adds to the given sum.

Example 1:

Input:
n = 5
arr[] = {10,2,-2,-20,10}
sum = -10
Output: 3
Explanation: Subarrays with sum -10 are: 
[10, 2, -2, -20], [2, -2, -20, 10] and 
[-20, 10].
Example 2:

Input:
n = 6
arr[] = {1,4,20,3,10,5}
sum = 33
Output: 1
Explanation: Subarray with sum 33 is: 
[20,3,10].
Your Task:
This is a function problem. You only need to complete the function subArraySum() that takes arr, n, sum as parameters and returns the count of subarrays which adds up to the given sum. 

Expected Time Comlexity: O(n)
Expected Auxilary Space: O(n)

Constraints:
1 <= n <= 105
-105 <= arr[i] <= 105
-105 <= sum <= 105
*/

/*
The idea is to store the sum of elements of every prefix of the array in a hashmap, i.e, every index stores the sum of elements up to that index hashmap. So to check if there is a subarray with a sum equal to s, check for every index i, and sum up to that index as x. If there is a prefix with a sum equal to x – s, then the subarray with the given sum is found. 

Algorithm:  

Create a Hashmap (hm) to store a key-value pair, i.e, key = prefix sum and value = its index, and a variable to store the current sum (sum = 0) and the sum of the subarray as s
Traverse through the array from start to end.
For every element update the sum, i.e sum = sum + array[i]
If the sum is equal to s then print that the subarray with the given sum is from 0 to i
If there is any key in the HashMap which is equal to sum – s then print that the subarray with the given sum is from hm[sum – s] to i
Put the sum and index in the hashmap as a key-value pair.
*/

//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.lang.*;
import java.io.*;

class Driverclass
{
	public static void main (String[] args)
	 {
    	 Scanner sc=new Scanner(System.in);
    	 int t=sc.nextInt();
    	 while(t-->0)
    	 {
    	        int n = sc.nextInt();
    		    int arr[] = new int[n];
    		    for(int i=0;i<n;i++)
    		    {
    		        arr[i] = sc.nextInt();
    		    }
    		    int sum = sc.nextInt();
    		    System.out.println(new Solution().subArraySum(arr, n, sum));
    		    
    		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to count the number of subarrays which adds to the given sum.
    static int subArraySum(int arr[], int n, int s)
    {
        // add your code here
        Map<Integer, Integer> aux=new HashMap<Integer, Integer>();
        //this accounts for situations when subarray is starting from 0
        aux.put(0, 1);
        int res=0, currsum=0;
        
        for(int i:arr){
            currsum+=i;
            //here the idea of maintaining map is that it helps use in the cases where we currsum-s is not zero, so lets say cursum-sum is x then if we find and element/sum entry in the map which is equal to x then we can simply eliminate that index , basically one step forward that index and now we will have currsum-sum=0
            res+=aux.getOrDefault(currsum-s, 0);
            aux.put(currsum, aux.getOrDefault(currsum, 0)+1);
        }
        return res;
    }
}
