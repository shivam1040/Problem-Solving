/*
You have a jumpy ball. You throw it up from the ground up to a height of H. The ball is jumpy, so when it comes back to the ground, it rebounds and goes up again to a distance of floor(H/2). This keeps on repeating until it can't rebound anymore. You need to find the total distance traveled by the ball.

Example 1:

Input:
H = 10

Output:
36

Explanation:
H is 10. From ground to H it travels d=10.
From H to ground it travels d=10+10. Now H
becomes floor(10/2). So ball rebounds to d=10+10+5.
It goes down to the ground. d=10+10+5+5. Now H
becomes floor(5/2). So ball rebounds to d=10+10+5+5+2.
The ball goes down. d=10+10+5+5+2+2. H becomes
floor(2/2). So ball rebounds to d=10+10+5+5+2+2+1.
It goes down to the ground. d=10+10+5+5+2+2+1+1.
H becomes floor(1/2). H is zero so no rebound.
Total d=36.
Example 2:

Input:
H = 20

Output:
76
Your Task:  
You don't need to read input or print anything. Your task is to complete the function jumpyBall() which takes an integer H as an input parameter and returns the total distance traveled by the ball.

Expected Time Complexity: O(log H)
Expected Auxiliary Space: O(1)

Constraints:
0 <= H <= 1015
*/

//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            long N=sc.nextLong();
			
            
            Solution ob = new Solution();
            long ans  = ob.jumpyBall(N);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    static long jumpyBall(long N){
        // code here
        long ans=0;
        
        while(N!=0){
            ans+=N+N;
            N/=2;
        }
        return ans;
    }
}
