/*
Mike is a seventh-grade student and today is his birthday. He wishes to distribute a chocolate each among his friends. He already knows all of his friends have some chocolates with them.
All his friends stand in a straight line. Mike can take all the chocolates of any one of his friends. Find the minimum number of chocolate he should have from the starting so that he can end up in giving minimum of a chocolate each to all his friends. 
He will visit all his friends only once in the order 1,2, ... N.
 

Example 1:

Input: nums = {2, 3, 1, 2, 5, 2}
Output: 3
Explanation: If he takes the chocolates of 
his 2nd friend. Then before coming to the 
2nd friend he needs 1 chocolate. Now 
including his 2nd friend he needs minimum 
of 2 chocolates after taking the chocolates 
of his 2nd friend. 
Example 2:

Input: nums = {1, 2, 3}
Output: 1
Explanation: If he takes the chocolates of his 
2nd friend then he only needs 1 chocolate.
 

Your Task:
You don't need to read or print anything. Your task is to complete the function MinimumChocolate() which takes a list that contains the number of chocolates his friends have initially and returns the minimum number of chocolates needed to distribute minimum of a chocolate to every friend.
 

Expected Time Complexity:  O(N)
Expected Space Complexity: O(1)
 

Constraints:
1 <= N <= 100000
0 <= Every friend has chocolates <= 10000
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
            int n = Integer.parseInt(s);
            String s1 = br.readLine().trim();
            String[] S1 = s1.split(" ");
            int[] nums = new int[n];
            for(int i = 0; i < n; i++)
                nums[i] = Integer.parseInt(S1[i]);
            Solution ob = new Solution();
            int ans = ob.MinimumChocolate(nums);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int MinimumChocolate(int[] nums)
    {
        // code here
        int n=nums.length, taken=nums[0], takenIndex=0;
        
        for(int i=1; i<n; i++){
            int el=nums[i];
            
            if(el>taken && taken<n-i){
                taken=el;
                takenIndex=i;
            }
        }
        int ans=takenIndex;
        
        if(n-takenIndex-taken>0)
            ans+=n-takenIndex-taken;
        return ans;
    }
}
