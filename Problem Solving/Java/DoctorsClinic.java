/*
Given two positive integers N and X, where N is the number of total patients and X is the time duration(in minutes) after which a new patient arrives. Also, doctor will give only 10 minutes to each patient. The task is to calculate the time (in minutes) the last patient needs to wait.

Example 1:

Input: N = 4, X = 5
Output: 15
Explaination: The arrival time of the 
patients are 0, 5, 10 and 15 respectively. 
The times when the first three patients 
are checked are respectively 10, 20, 30. 
So the Waiting time is 30 - 15 = 15.
Example 2:

Input: N = 3, X = 10
Output: 0
Explaination: The incoming time of the 
patients are 0, 10 and 20 and the firts 
two patients are finished checking at 10, 
20. So the last patient does not need to 
wait.
Your Task:
You do not need to read input or print anything. Your task is to complete the function waitingTime() which takes N and X as input parameters and returns the waiting time of the last patient.

Expected Time Complexity: O(1)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ N ≤ 100
1 ≤ X ≤ 30
*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0){
            String arr[] = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(arr[0]);
            int X = Integer.parseInt(arr[1]);

            Solution ob = new Solution();
            System.out.println(ob.waitingTime(N, X));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int waitingTime(int N, int X){
        // code here
        //no waiting time when X is more than doctor time given to each patient
        if(X>=10)
            return 0;
        //else waiti time would be duration reduced from doctor time * last person
        return (N-1)*(10-X);
    }
}
