/*
Metro roams in a city of 20 stations, Starting from Station number 0 to last station 19. It Stops at each station for 1 sec (neglect the time of station switching). A Guy daily waits at station number 11 for the train. Given n i,e current station no. at which metro is and its direction c, find the time he has to wait to catch up the train.

Example 1:

Input:  n = 0, c = U
Output: 11
Explanation: Since train is at station number 
0, so the guy has to wait 11 sec.
Example 2:

Input: n = 12, c = D
Output: 1
Explanation: Since train is at station number
12 and its direction is down it means the guy
has to wait for only 1 sec.
 

Your Task:
You don't need to read or print anything. Your task is to complete the function waiting_time() which takes n and c as input parameter and returns the time for which the guy has to wait.
 

Expected Time Complexity: O(1)
Expected Space Compelxity: O(1)

Constraints:
0 <= n <= 19
c € ['D', 'U']
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
            String  lines = br.readLine();
            String[] strs = lines.trim().split("\\s+");
            
            int n = Integer.parseInt(strs[0]);
            char c = strs[1].charAt(0);
            Solution ob = new Solution();
            int ans = ob.waiting_time(n, c);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution
{
    public int waiting_time(int n, int c)
    {
        // code here
        if(c=='U')
        //basically to last station then back to 11
            return n<=11 ? 11-n : 20-n+11;
        else
            return n>=11 ? n-11 : n+11;
    }
}

