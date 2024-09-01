/*
Given an array of N integer elements, the task is to find sum of average of all subsets of this array.
 

Example 1:

Input: nums = {1, 2, 3}
Output: 14.000000
Explanation: {1}, {2}, {3},
{1, 2}, {2, 3}, {1, 3}, {1, 2, 3}
So average will be 1, 2, 3, 1.5, 
2.5, 2 and 2. Hence summation will be
1 + 2 + 3 + 1.5 + 2.5 + 2 + 2 = 14.0
Example 2:

Input: nums = {2, 5}
Output: 10.500000
Explanation: {2}, {5}, {2, 5}. So average
will be 2, 5 and 3.5. Sum = 2 + 5 + 3.5 = 10.5
 

Your Task:
You don't need to read or print anyhting. Your task is to complete the function AverageOfAllSubsets() which takes the array as input parameter and returns the sum of average of all subsets of the array.
 

Expected Time Complexity: O(n3)
Expected Space Compelxity: O(n2)
 

Constraints:
1 ≤ n ≤ 20
1 ≤ elements of array ≤ 100
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
            int n = Integer.parseInt(br.readLine().trim());
            String[] S = br.readLine().trim().split(" ");
            int[] nums = new int[n];
            for(int i = 0; i < n; i++)
                nums[i] = Integer.parseInt(S[i]);
            Solution ob = new Solution();
            float ans = ob.AverageOfAllSubsets(nums);
            System.out.println(String.format("%.6f",ans));
        }
    }
}

/*
To optimize the space complexity of the above approach, we can use a more efficient approach that avoids the need for the entire matrix C[][] to store binomial coefficients. Instead, we can use a combination formula to calculate the binomial coefficient directly when needed.

Implementation steps:

Iterate over the elements of the array and calculate the sum of all elements.
Iterate over each subset size from 1 to N.
Inside the loop, calculate the average of the sum of elements multiplied by the binomial coefficient for the subset size. Add the calculated average to the result.
Return the final result.
*/

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public float  AverageOfAllSubsets(int[] nums)
    {
        //code here
        int sum=0;
        float res=0;
        
        for(int i:nums)
            sum+=i;
        for(int i=1; i<=nums.length; i++)
            res+=(sum*binomialCoe(nums.length-1, i-1))/i;
        return res;
    }
    
    private double binomialCoe(int n, int k){
        double res=1.0;
        
        if(k>n-k)
            k=n-k;
        for(int i=0; i<k; i++){
            res*=(n-i);
            res/=(i+1);
        }
        return res;
    }
}
