/*
There are N ticket sellers where the ith ticket seller has A[i] tickets.

The price of a ticket is the number of tickets remaining with the ticket seller. They are allowed to sell at most K tickets. Find the maximum amount they can earn by selling K tickets.

The amount of tickets of each seller is provided in array A. Give the answer modulo 109 + 7.

Example 1:

Input: N = 5, K = 3
A = {4, 3, 6, 2, 4}
Output: 15
Explaination: Consider 0 based indexing. 
For first two turns the 2nd seller sells. 
For the third turn either 0th or 2nd 
seller can sell. So the total becomes 
6 + 5 + 4 = 15.
Example 2:

Input: N = 6, K = 2
A = {5, 3, 5, 2, 4, 4}
Output: 10
Explaination: The turns are taken by 
0th and 2nd seller. 5 + 5 = 10 is the 
maximum amount.
Your Task:
You do not need to take input or print anything. Your task is to complete the function maxAmount() which takes N, K, and the array A as input parameters and returns the maximum amount they can get by selling K tickets.

Expected Time Complexity: O(N*log(N))
Expected Auxiliary Space: O(N)

Constraints:
1 ≤ N ≤ 105
1 ≤ A[i], K ≤ 106
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
            String val[] = in.readLine().trim().split("\\s++");
            int N = Integer.parseInt(val[0]);
            int K = Integer.parseInt(val[1]);
            String arr[] = in.readLine().trim().split("\\s++");
            int[] A = new int[N];
            for(int i = 0;i < N; i++)
                A[i] = Integer.parseInt(arr[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.maxAmount(N, K, A));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int maxAmount(int N, int K, int A[])
    {
        // code here
        PriorityQueue<Integer> aux=new PriorityQueue<>(Collections.reverseOrder());
        int res=0;
        
        for(int i:A)
            aux.add(i);
        
        while(K>0){
            int highestCost=aux.poll();
            res+=highestCost;
            highestCost-=1;
            //ensures always the highest cost seller sells
            aux.add(highestCost);
            K--;
        }
        
        return res%1000000007;
    }
}
