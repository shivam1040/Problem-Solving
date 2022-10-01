/*
Given a floor of dimensions 2 x W and tiles of dimensions 2 x 1, the task is to find the number of ways the floor can be tiled. A tile can either be placed horizontally i.e as a 1 x 2 tile or vertically i.e as 2 x 1 tile. Print the answer modulo 109+7.

 

Example 1:

Input:
W = 3
Output:
3
Explanation:
We need 3 tiles to tile the board
of size  2 x 3. 
We can tile in following ways:
1) Place all 3 tiles vertically. 
2) Place first tile vertically.
and remaining 2 tiles horizontally.
3) Place first 2 tiles horizontally
and remaining tiles vertically.
Example 2:

Input:
W = 4
Output:
5
Explanation:
For a 2 x 4 board, there are 5 ways
1) All 4 vertical
2) All 4 horizontal
3) First 2 vertical, remaining
2 horizontal.
4) First 2 horizontal, remaining
2 vertical.
5) Corner 2 vertical, middle
2 horizontal.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function numberOfWays() which takes an Integer N as input and returns the answer.

 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

 

Constraints:
1 <= N <= 105
*/

/*
Let “count(n)” be the count of ways to place tiles on a “2 x n” grid, we have following two ways to place first tile. 
1) If we place first tile vertically, the problem reduces to “count(n-1)” 
2) If we place first tile horizontally, we have to place second tile also horizontally. So the problem reduces to “count(n-2)” 
*/

//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.numberOfWays(N));
        }
    }
}
// } Driver Code Ends


class Solution {
    static Long numberOfWays(int N) {
        // code here
         long dp1=1, dp2=1;
         long res=0;
         
	//fibonnaci
         if(N<=2)
            return (long) N;
         for(int i=2; i<=N; i++){
             res=(dp1+dp2)%1000000007;
             dp1=dp2;
             dp2=res;
         }
         return res;
    }
}
