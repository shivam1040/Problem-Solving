/*
There are N office cubicles placed in a straight line, each with a bright bulb. Each light bulb can brighten K rooms on either side of it (also the one in which the light bulb itself is), but all the cubicles don't have a bulb. You are given an array A which gives the information about the location of the bulbs. If A[i] is equal to 1, then the cubicle has a light bulb, else if A[i] is 0, then the cubicle doesn't have a bulb. You need to find out whether all the cubicles are bright or not.

Example 1:

Input: N = 4, K = 3
A = {0, 1, 0, 1}
Output: 1
Explaination: The first cubicle can be 
brightened by 2nd cubicle. The third 
cubicle can be brightened by 4th cubicle.
Example 2:

Input: N = 7, K = 2
A = {1, 0, 0, 0, 0, 0, 1}
Output: 0
Explaination: The fourth cubicle cannot be 
brightened in any way.
Your Task:
You do not need to read input or print anything. Your task is to complete the function isBrightened() which takes N, K and A as input parameters and returns 1 if all the cubicles can be brightened. Otherwise, returns 0.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ N ≤ 104
1 ≤ K ≤ 20
0 ≤ A[i] ≤ 1 
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
        while(t-- > 0){
            String arr[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(arr[0]);
            int K = Integer.parseInt(arr[1]);
            String arr1[] = in.readLine().trim().split("\\s+");
            int A[] = new int[N];
            for(int i = 0;i < N;i++)
                A[i] = Integer.parseInt(arr1[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.isBrightened(N, K, A));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int isBrightened(int N, int K, int arr[]){
        // code here
        int i=0, j=0;
        
        while(i<N){
            if(arr[i]==1){
                //if current idx - K illuminated is greater than prev(j) illuminated then it means until now no illuminated cubicle has been found to cover the K+prev range
                if(i-K>j)
                    return 0;
                //this takes care of moving the prev to +K range
                j=i+K+1;
            }
            i++;
        }
        //at the end J can perhaps be out of range if 1 is encountered in N-k range
        return j>=N ? 1 : 0;
    }
}
