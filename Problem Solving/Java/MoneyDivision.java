/*
Given an array where each element is the money a person have and there is only Rs. 3 note. We need to check whether it is possible to divide the money equally among all the persons or not. If it is possible then find Minimum number of transactions needed.
 

Example 1:

Input: nums = [5, 8, 11]
Output: 1
Explanation: 3rd person can give Rs. 3
then all person would have Rs. 8
Example 2:

Input: nums = [1, 2, 3, 4]
Output: -1
Explanation: 1 + 2 + 3 + 4 = 10. Rs. 10 
can not be distributed among 4 persons.
 

Your Task:
You don't need to read or print anything. Your task is to complete the function MinimumTransaction() which takes the array as input parameter and returns the minimum number of transactions needed to distribute the money equally. If not possible returns -1.
 

Expected Time Complexity: O(n) where n is length of array
Expected Space Complexity: O(1)
 

Constraints:
1 <= n <= 105
1 <= elements of array <= 106
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
            String s = br.readLine().trim();
            String[] S = s.split(" ");
            int[] nums = new int[n];
            for(int i = 0; i < n; i++)
                nums[i] = Integer.parseInt(S[i]);
            Solution ob = new Solution();
            int ans = ob.MinimumTransaction(nums);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int MinimumTransaction(int[] nums)
    {
        // code here
        int temp=0, temp1=0;
        
        for(int i:nums)
            temp+=i;
        if(temp%nums.length==0){
            temp/=nums.length;
            
            for(int i:nums)
            //finding if the remaining after taking equal unit away is divisible by 3 to ensure it can give to others to maked every ele equal to equal unit
                if(Math.abs(i-temp)%3!=0)
                    return -1;
                else
                //number of 3 rs note an index needs to transfer to ensure equilibrium
                    temp1+=Math.abs(i-temp)/3;
            //since transaction is b/w two folks so final number of transaction is divided by 2
            return temp1/2;
        }
        return -1;
    }
}
