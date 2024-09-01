/*
Jon wants to go in birthday party of Arya. But he is busy in finding solution of crazy equations, so he wants your help to solve this problem. Jon has four integers a, b, c, d now he wants to calculate how many distinct set of x, y, z, w are present such that  a + b - x  == a + c - y == c + d - z == b + d - w
NOTE :  1<= x, y, z, w<=n   where n is a given integer.
Two set of x, y, z, w will be different if atleast one value will be different.

Example 1:

Input: n = 5, a = 1, b = 2, c = 2, d = 2
Output: 4
Explanation: Sets of x, y, z, w can be
             (1, 1, 2, 2)
             (2, 2, 3, 3)
             (3, 3, 4, 4)
             (4, 4, 5, 5).

Example 2:

Input: n = 5, a = 1, b = 2, c = 2, d = 1
Output: 5
Explanation: same explanation as previous one.

Your Task:  
You dont need to read input or print anything. Complete the function distinctValues() which takes n, a, b, c and d as input parameter and returns the total number of distinct set of x, y, z, w are present. 

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

Constraints:
1 <= n <= 106
1 <= a, b, c, d <= n
*/

/*
as for question a + b - x == a + c - y == c + d - z == b + d - w
the one point will always satisfies i.e a + b - x == a + c - y == c + d - z == b + d - w = 0
therefore ,
a+b = x
a+c = y
c+d = z
b+d = w

Now we got x,y,z,w it is the one point.Now we have to calculate different points so from the first point we increase 1 or decrease 1 then we will get points that satisfies the given condition. we increase 1 or decrease 1 upto the condition is meet the condition is 1 <= (x,y,z,w) <= n.

for that we find the max and min in (x,y,z,w). then we subtract (max-min) then we subtract from the n that will be number of points in the given equation.


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
            String[] input = new String[5]; 
            input = br.readLine().split(" "); 
            int n = Integer.parseInt(input[0]); 
            int a = Integer.parseInt(input[1]); 
            int b = Integer.parseInt(input[2]); 
            int c = Integer.parseInt(input[3]); 
            int d = Integer.parseInt(input[4]);
            Solution ob = new Solution();
            System.out.println(ob.distinctValues(n,a,b,c,d));
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution
{
    public int distinctValues(int n, int a, int b, int c, int d)
    {
        // code here
        int x=a+b, y=a+c, z=c+d, w=b+d, m1=Math.max(x, Math.max(y, Math.max(z, w))), m2=Math.min(x, Math.min(y, Math.min(z, w))), diff=Math.abs(m1-m2);
        
        return n-diff<0 ? 0 : n-diff;
    }
}
