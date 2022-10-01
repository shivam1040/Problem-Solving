/*
Consider a game where a player can score 3 or 5 or 10 points in a move. Given a total score n, find number of distinct combinations to reach the given score.

Example:
Input
3
8
20
13
Output
1
4
2
Explanation
For 1st example when n = 8
{ 3, 5 } and {5, 3} are the 
two possible permutations but 
these represent the same 
cobmination. Hence output is 1.
Your Task:  
You don't need to read input or print anything. Your task is to complete the function count( ) which takes N as input parameter and returns the answer to the problem.

Constraints:
1 ≤ T ≤ 100
1 ≤ n ≤ 1000
*/

//{ Driver Code Starts
// Driver Code
import static java.lang.System.out;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        for (int T = in.nextInt(); T-->0;) {
            int n = in.nextInt();
            
            Geeks obj = new Geeks();
            out.println(obj.count(n));
        }
    }
}
// } Driver Code Ends


// Complete this function!

class Geeks {
    public long count(int n) {
        long[] dp = new long[(int)n+1];
        Arrays.fill(dp, 0);
        //base condition is to reach zero you need not to pick any number and that calls for combination 1
        dp[0] = 1;
        
        // Add your code here.
        //this loop takes care of number of ways to reach n only considering 3
        for(int i=3; i<=n; i++)
        //this means a given index i in table depends on previous pposition which is multiple of 3
            dp[i]+=dp[i-3];
        for(int i=5; i<=n; i++)
        //previous table is used to compute the same but for 5 and ultimately we reach to a solution
            dp[i]+=dp[i-5];
        for(int i=10; i<=n; i++)
            dp[i]+=dp[i-10]; 
        
        return dp[n];
    }
}
