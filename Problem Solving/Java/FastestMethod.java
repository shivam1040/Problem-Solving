/*
Geek lives in a multi-story building. Everyday he has to get from the Nth floor to the ground floor. He has three options to come down,

the lift,
the stairs or
the escalator.
He has different speeds for the lift, the stairs and the escalator which are V1 m/s, V2 m/s and V3 m/s respectively. Assuming each floor has a height of 1m and the stairs and the escalator are inclined at an angle of 45 degrees. Find out which is the fastest way for Geek to reach the ground floor. If any of the methods consume same time, give preference to lift, then stairs and then escalator.


Example 1:

Input: 
N = 5, V1 = 1, V2 = 2, V3 = 3
Output: 3
Explaination: Option 3, ie the escalator
will be the fastest.

Example 2:

Input: 
N = 5, V1 = 3, V2 = 2, V3 = 1
Output: 1
Explaination: Option 2, ie the lift
will be the fastest.

Your Task:
You do not need to read input or print anything. Your task is to complete the function fastest() which takes N, V1, V2 and V3 as input parameters and returns 1, 2 or 3 if lift, stair or escalator is the fastes way respectively.


Expected Time Complexity: O(1)
Expected Auxiliary Space: O(1)


Constraints:
1 ≤ N ≤ 1000
1 ≤ V1, V2, V3 ≤ 1000 


*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- >0){
            String a[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(a[0]);
            int V1 = Integer.parseInt(a[1]);
            int V2 = Integer.parseInt(a[2]);
            int V3 = Integer.parseInt(a[3]);
            
            Solution ob = new Solution();
            System.out.println(ob.fastest(N, V1, V2, V3));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int fastest(int N, int V1, int V2, int V3)
    {
        // code here
        //root 2 is done to ensure the fact on inclination of 45* horizontal distance covered at step
        double t1=(N*1.0)/V1, t2=(N*Math.sqrt(2))/V2, t3=(N*Math.sqrt(2))/V3;
        
        return t1<=t2 && t1<=t3 ? 1 : t2<=t3 ? 2 : 3;
    }
}
