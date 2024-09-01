/*
In Geekland, there lives a very rich girl Siri. For her undergraduation studies she joins an engineering college GIT, Geekland Institute of Technology. The college has a semester wise system, a semester being of K days. Before her first day for the college Siri and her mom went to market for shopping and bought N dresses. Her mom told her that every Mth day she will bring her a new dress, but since the shops in the Geekland are open only in the evening, so Siri could only wear her new dress the next day. If on a particular day Siri didn't had a new dress to wear, she bunks that day off the college. Help Siri to know for how many days she will bunk her classes in a semester of K days. 

Example 1:

Input: N = 9, M = 3, K = 15
Output: 
2
Explanation: For first 9 days Siri has new  
dresses and she will wear them for 9 days, 
during these 9 days she will get 3 more dresses
so she will wear them on 10th, 11th and 12th day.
On 12th day she will get one more new dress to 
wear on 13th day. On 15th day she will get one 
more new dress but she can't wear it before 16th
day. For 14th and 15th day she does not have any
new dress, so she will bunk two days.
Example 2:

Input: N = 2, M = 2, K = 10
Output: 
4
Your Task:  
You dont need to read input or print anything. Complete the function bunkDays() which takes integers N, M and K as input parameters and returns the number of days Siri will bunk her classes.

Expected Time Complexity: O(1)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ N, M, K ≤ 1000
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
            String[] input = new String[3]; 
            input = br.readLine().split(" "); 
            int N = Integer.parseInt(input[0]); 
            int M = Integer.parseInt(input[1]); 
            int K = Integer.parseInt(input[2]); 
            Solution ob = new Solution();
            System.out.println(ob.bunkDays(N,M,K));
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution
{
    public int bunkDays(int N, int M, int K)
    {
        // code here
        int res=K-(K-1)/M-N;
        
        return res<=0 ? 0 : res;
    }
}
