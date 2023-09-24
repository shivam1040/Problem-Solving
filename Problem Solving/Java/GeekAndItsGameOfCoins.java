/*
Given three numbers N, X, and Y. Geek and his friend playing a coin game. In the beginning, there are N coins. In each move, a player can pick X, Y, or 1 coin. Geek always starts the game. The player who picks the last coin wins the game. The task is to check whether Geek will win the game or not if both are playing optimally.

Example 1:

Input: N = 5, X = 3, Y = 4
Output: 1
Explanation: There are 5 coins, every 
player can pick 1 or 3 or 4 coins on 
his/her turn. Geek can win by picking 
3 coins in first chance. Now 2 coins 
will be left so his friend will pick 
one coin and now Geek can win by 
picking the last coin.
Example 2:
Input: N = 2, X = 3, Y = 4
Output: 0
Explanation: Geek picks 1 and then 
his friend picks 1.

Your Task:  
You don't need to read input or print anything. Complete the function findWinner() which takes N, X, and Y as input parameters and returns 1 if Geek can win otherwise 0.

Expected Time Complexity: O(|N|)
Expected Auxiliary Space: O(|N|)

Constraints:
1 ≤ |N| ≤ 106

*/

//{ Driver Code Starts
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
            String input[] = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int X = Integer.parseInt(input[1]);
            int Y = Integer.parseInt(input[2]);
            Solution ob = new Solution();
            int ans = ob.findWinner(N,X,Y);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution
{
    public int findWinner(int N,int x,int y)
    {
        // Code here
        int dp[]=new int[N+1];
        dp[0]=0; //base case where A has no chance to pick anything so B wins
        dp[1]=1; //base case where A has to win by picking 1 coin;
        
        for(int i=2; i<=N; i++){
            //checking if it is possible to check i-1 in dp and also ensuring last chance was of B so that if condition matches we can mark the curr index in dp as 1 which is basically for geek
            if(i-1>=0 && dp[i-1]==0)
                dp[i]=1;
            else if(i-x>=0 && dp[i-x]==0)
                dp[i]=1;
            else if(i-y>=0 && dp[i-y]==0)
                dp[i]=1;
            //this means all the above chances were used by Geek so now it has to be their friends
            else
                dp[i]=0;
        }
        
        return dp[N];
    }
}
