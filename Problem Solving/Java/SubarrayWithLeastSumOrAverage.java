/*
Given an array of size n, Find the subarray with least average of size k.

 

Example 1:

Input: nums = [30, 20, 10], k = 1
Output: 3
Explanation: Subarrays of length 1 are
{30}, {20}, {10}. {10} has the least 
average.

Example 2:

Input: nums = [30, 20, 10], k = 2
Output: 2
Explanation: Subarrays of length 2 are
{30, 20}, {20, 10}. {20, 10} has the least 
average.
 

Your Task:
You don't need to read or print anything. Yous task is to complete the function least_average() which takes the array and k as input parameter and returns the index of the first element of the subarray(1-based indexing) of size k that has least average.
 

Expected Time Complexity: O(n)
Expected Space Compelxity: O(1)
 

Constraints:
1 <= k <= n <= 100000
1 <= elements of array <= 1000000
*/

//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String s = br.readLine().trim();
            String s1 = br.readLine().trim();
            String[] S1 = s.split(" ");
            String[] S2 = s1.split(" ");
            int n = Integer.parseInt(S1[0]);
            int k = Integer.parseInt(S1[1]);
            int[] nums = new int[n];
            for(int i = 0; i < S2.length; i++)
                nums[i] = Integer.parseInt(S2[i]);
            Solution ob = new Solution();
            int ans = ob.least_average(nums, k);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int least_average(int[] nums, int k)
    {
        // code here
        int sum=0;
        int l=0;
        
        while(l<k){
                sum+=nums[l];
                l++;
            }
            
        int res=1;
        //no need to get actual mean as we have to get the least average and that would come from least sum
        int temp=sum;
        
        for(int i=k; i<nums.length; i++){
            temp=temp-nums[i-k]+nums[i];
            
            if(temp<sum){
                sum=temp;
                //doing this to account for non zero based indexing
                res=i-k+2;
            }
        }
        return res;
    }
}
