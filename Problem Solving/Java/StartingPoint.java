/*
You are a traveler, lost in a jungle. Backtrack your steps and find the starting point.

Currently, you are at coordinates (x,y). You are also given an array pathCoordinates [ ] where each element is a (a,b) pair.

The ith pair (a,b), in the array, denotes that in the ith move you moved your X co-ordinate by a and Y co-ordinate by b. 
if X,Y coordinates in an instant are (c,d) then your next move will be to ( c+a, d+b). 

Example 1:

Input: x = 2, y = 2, 
pathCoordinates = {{1,0},{0,1},{1,1}}
Output: {0,0}
Explaination:
{0,0} was the starting point of the traveler.
At first he changed his X co-ordinate by 1 and
Y co-ordinate by 0.
{0,0} -> {1,0}
After that he changed his X co-ordinate by 0 and
Y co-ordinate by 1.
{0,0} -> {1,0} -> {1,1}
And finally, he changed his X co-ordinate by 1 and
Y co-ordinate by 1.
{0,0} -> {1,0} -> {1,1} -> {2,2}


Example 2:

Input: x = 1, y = 2,
pathCoordinates = {{1,1}}
Output: {0,1}
Explaination:
The route followed by the traveller is
{0,1} -> {1,2}.
 

Your Task:
You don't need to read or print anything. Your task is to complete the function findStartingPoint() which takes x, y, and pathCoordinates as input parameters and returns a list containing the starting point.
 

Expected Time Compelxity: O(n) where n = length of pathCoordinates.
Expected Space Complexity: O(1)
 

Constraints:
1 <= n <= 103


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
            String[] s = br.readLine().trim().split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);
            int n = Integer.parseInt(br.readLine().trim());
            int[][] pathCoordinates = new int[n][2];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < 2; j++)
                    pathCoordinates[i][j] = Integer.parseInt(S[j]);
            }
            Solution obj = new Solution();
            int[] ans = obj.findStartingPoint(x, y, pathCoordinates);
            for(int i = 0; i < ans.length; i++){
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution
{
    public int[] findStartingPoint(int x, int y, int[][] pathCoordinates)
    {
        // Code here 
        for(int i=pathCoordinates.length-1; i>=0; i--){
            //backtracking
            x=x-pathCoordinates[i][0];
            y=y-pathCoordinates[i][1];
        }
        return new int[]{x, y};
    }
}
