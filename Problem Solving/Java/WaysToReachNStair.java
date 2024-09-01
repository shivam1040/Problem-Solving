/*
There are n stairs, a person standing at the bottom wants to reach the top. The person can climb either 1 stair or 2 stairs at a time. Count the number of ways, the person can reach the top (order does matter).

Example 1:

Input:
n = 4
Output: 5
Explanation:
You can reach 4th stair in 5 ways. 
Way 1: Climb 2 stairs at a time. 
Way 2: Climb 1 stair at a time.
Way 3: Climb 2 stairs, then 1 stair
and then 1 stair.
Way 4: Climb 1 stair, then 2 stairs
then 1 stair.
Way 5: Climb 1 stair, then 1 stair and
then 2 stairs.
Example 2:

Input:
n = 10
Output: 89 
Explanation: 
There are 89 ways to reach the 10th stair.
Your Task:
Complete the function countWays() which takes the top stair number m as input parameters and returns the answer % 10^9+7.

Expected Time Complexity : O(n)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ n ≤ 104
*/

/*
Intuition
The idea is to use only 2 variables in recursion we use values of (n-1)th stair and (n-2)th stair, so we can use 2 variables prev1 and prev2, and then use these 2 variables and update these values after every iteration accordingly.

Implementation
Initialize two variables prev and curr with 1 as if we want to go to the bottom stair or 1st stair then there is one possible way.
Now run a loop from 2 to n.
Add these 2 variables curr and prev, and store them into another temp variable.
Now update the prev with curr one.
Update the curr variable with the modulo of temp.
When come out of the loop return the curr value.
*/

//{ Driver Code Starts
import java.io.*;
import java.util.*;


class GFG {
	public static void main (String[] args) {
		
		//taking input using Scanner class
		Scanner sc = new Scanner(System.in);
		
		//taking total testcases
		int t = sc.nextInt();
		
		while(t-- > 0){
		    
		    //taking count of stairs
		    int m = sc.nextInt();
		    
		    //creating an object of class DynamicProgramming
		    Solution obj = new Solution();
		    
		    //calling method countWays() of class
		    //DynamicProgramming
		    System.out.println(obj.countWays(m));
		    
		}
		
	}
}
// } Driver Code Ends


class Solution
{
    //Function to count number of ways to reach the nth stair.
    int countWays(int n)
    {
        
        // your code here
        int mod = 1000000007;
        
        if(n<=1)
            return 1;
        int a=1, b=1, temp;
        
        for(int i=2; i<=n; i++){
            temp=(a+b)%mod;
            a=b;
            b=temp;
        }
        return b;
    }
}


