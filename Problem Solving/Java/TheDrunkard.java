/*
A drunkard is walking down the lanes of FooLand city at midnight and his steps are such that he moves A units forward in one step and B units backward in next step and this goes on. His house is at (N, 0) and his current position is (0, 0). Can you help him in finding out how many steps he would need to take to reach his house?
Return -1 if it is not possible for him to reach his house. Don’t take into account any movement in the y-direction. Note that distance between (i, 0) and (i+1, 0) is 1 unit and NOT 1 step.

Example 1:

Input: N = 11, A = 5, B = 2
Output: 5
Explanation: He will be at (5, 0) after step 1, 
at (3, 0) after step 2, at (8, 0) after step 3, 
at (6, 0) after step 4 and at (11, 0) after 
completing step 5. Hence, he would need 5 steps 
to reach his house.

Example 2:

Input: N = 10, A = 3, B = 3
Output: -1
Explanation: He will be at (3, 0) after step 1, 
at (0, 0) after step 2, at (3, 3) again after 
step 3 and this would go on. So, he would 
never reach his house. 

Your Task:  
You dont need to read input or print anything. Complete the function numOfSteps() which takes N, A and B as input parameter and returns the number of steps he would need to take to reach his house.

Expected Time Complexity: O(1)
Expected Auxiliary Space: O(1)

Constraints:
1 <= N <= 106
1 <= A,B <= 105
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
            int A = Integer.parseInt(input[1]); 
            int B = Integer.parseInt(input[2]); 
            Solution ob = new Solution();
            System.out.println(ob.numOfSteps(N, A, B));
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution
{
    public int numOfSteps(int N, int A, int B)
    {
        // code here
        if(N<=A)
            return 1;
        if((N!=A && A<B) || A==B)
            return -1;
            
        int pos=0, ans=0;
        boolean up=true;
        
        while(pos<N){
            ++ans;
            
            if(up)
                pos+=A;
            else
                pos-=B;
            up=!up;
        }
        return ans;
    }
}
