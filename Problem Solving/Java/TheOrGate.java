/*
Given N bits to an OR - Gate find the output that will be produced. 
OR - Gate Table:
1 | 1 = 1
1 | 0 = 1
0 | 1 = 1
0 | 0 = 0
 

Example 1:

Input:
N = 4
arr: 1 1 1 0
Output:
1
Explanation:
1 | 1 = 1
1 | 1 = 1
1 | 0 = 1
hence output is 1
Example 2:

Input:
N = 4
arr: 0 0 1 0
Output:
1
Explanation:
0 | 0 = 0
0 | 1 = 1
1 | 0 = 1
hence output is 1

Your Task:
You don't need to read input or print anything. Your task is to complete the function orGate() which takes the array arr[], its size N as input parameters and returns the output after processing OR operations on N bits.
 

Expected Time Complexity: O(N)
Expected Space Complexity: O(1)
 

Constraints:
1<=N<=1000


*/

//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

// } Driver Code Ends
//User function Template for Java
class Solution{
    static int orGate(int arr[] , int N){
       //code here
       if(N<=1)
        return arr[0];
       int a = arr[0] | arr[1];
       
       if(N<3)
        return a;
       for(int i=2; i<N; i++)
        a|=arr[i];
        
        return a;
    }
}

//{ Driver Code Starts.
class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String S[] = read.readLine().trim().split(" ");
            int arr[] = new int[N];
            for(int i =0;i<N;i++)
            {
                arr[i] = Integer.parseInt(S[i]);
            }
            Solution ob = new Solution();
            System.out.println(ob.orGate(arr,N));
        }
    }
}
// } Driver Code Ends
