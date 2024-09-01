/*
Given an array arr[] of size N, check if it can be partitioned into two parts such that the sum of elements in both parts is the same.

Example 1:

Input: N = 4
arr = {1, 5, 11, 5}
Output: YES
Explanation: 
The two parts are {1, 5, 5} and {11}.
Example 2:

Input: N = 3
arr = {1, 3, 5}
Output: NO
Explanation: This array can never be 
partitioned into two such parts.
Your Task:
You do not need to read input or print anything. Your task is to complete the function equalPartition() which takes the value N and the array as input parameters and returns 1 if the partition is possible. Otherwise, returns 0.

Expected Time Complexity: O(N*sum of elements)
Expected Auxiliary Space: O(sum of elements)

Constraints:
1 ≤ N ≤ 100
1 ≤ arr[i] ≤ 1000
N*sum of elements ≤ 5*106


*/

/*
Intuition:
The tabulation approach builds the solution in a bottom-up manner by filling a table iteratively. Instead of relying on recursive calls and memoization to store intermediate results, we directly compute and store the results in a 2D table. This way, we ensure that we compute each subproblem only once and avoid the overhead of function calls and memoization table management.

Implementation
Calculate the total sum of the array and check if it is even. If not, the array cannot be partitioned into two subsets with equal sums, so return false.
Initialize a 2D table dp with dimensions (N+1) x (totalSum/2 + 1), where N is the size of the array.
Set the first column of dp to true, as there is always an empty subset with a sum of 0.
Fill the dp table iteratively using a bottom-up approach:
The cell dp[i][j] will be true if any of the following conditions are met:
dp[i - 1][j] is true, which means we can form a subset with sum j using the first i-1 elements.
dp[i - 1][j - arr[i - 1]] is true, which means we can form a subset with sum j - arr[i - 1] using the first i-1 elements, and we can include the current element arr[i - 1] in the subset to form a sum of j.
The condition j < arr[i - 1] ensures that we cannot use the current element arr[i - 1] if it exceeds the target sum j.
The final answer is stored in dp[N][targetSum]
Array: [2, 4, 6, 8]

Step 1: Calculate the total sum of the array.
Total sum = 2 + 4 + 6 + 8 = 20

Step 2: Check if the total sum is even. If not, return false, as it cannot be partitioned into two subsets with equal sums.
Total sum = 20 (even) -> Continue.

Step 3: Initialize a 2D table dp with dimensions (N+1) x (totalSum/2 + 1).
Here, N is the size of the array, so N = 4.
totalSum/2 = 20/2 = 10
Thus, dp will be a 5x11 table (N+1 x totalSum/2 + 1).

Row i = 0 (representing an empty subset with a sum of 0) is already initialized to true, as shown in the table above.

Starting from i = 1 (representing the first element of the array), and j = 0 (representing the target sum 0), all cells in the first column (j = 0) are set to true because we can always form an empty subset with a sum of 0.

Now, let's fill the rest of the dp table according to the conditions mentioned in the implementation

i/j	0	1	2	3	4	5	6	7	8	9	10
0	T	F	F	F	F	F	F	F	F	F	F
1	T	F	T	F	F	F	F	F	F	F	F
2	T	F	T	F	T	F	T	F	F	F	F
3	T	F	T	F	T	F	T	F	T	F	T
4	T	F	T	F	T	F	T	F	T	F	T
dp[4][10] = true is the answer


*/

//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int x = ob.equalPartition(N, arr);
            if(x == 1)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static int equalPartition(int N, int arr[])
    {
        // code here
        int sum=0, target;
        
        for(int i:arr)
            sum+=i;
        target=sum/2;
        //no partitioning if odd
        if(sum%2==1)
            return 0;
        int dp[][]=new int[N+1][target+1];
        //using i ele ways to reach sum 0 is 1; don't consider any ele
        for(int i=0; i<=N; i++)
            dp[i][0]=1;
        for(int i=1; i<=N; i++)
            for(int j=1; j<=target; j++)
                if(j>=arr[i-1])
                //considering i elements to get the sum j-arr[i-1] or not
                    dp[i][j]=dp[i-1][j] | dp[i-1][j-arr[i-1]];
                else
                    dp[i][j]=dp[i-1][j];
        return dp[N][target];
    }
}
