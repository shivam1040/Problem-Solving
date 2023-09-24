/*
There are N integers given in an array arr. You have to determine if it is possible to divide them in at most K groups, such that any group does not have a single integer more than twice.

Example 1:

Input: N = 5, K = 2
arr = {1, 1, 2, 5, 1}
Output: 1
Explaination: We can divide them in two groups in 
following way (1, 1, 2, 5) and (1).
Example 2:

Input: N = 3, K = 1
arr = {1, 1, 1}
Output: 0
Explaination: There can be only one group and 
three 1's. So it is not possible.
Your Task:
You do not need to read input or print anything. Your Task is to complete the function isPossible() which takes the value N, K and arr as input parameters and returns 1 if grouping is posible. Otherwise returns 0.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

Constraints:
1 ≤ N ≤ 1000
1 ≤ K ≤ 256
1 ≤ arr[i] ≤ 32
*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException{
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            int K = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.isPossible(N, arr, K));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int isPossible(int N, int arr[], int K)
    {
        // code here
        Map<Integer, Integer> aux=new HashMap<>();
        
        for(int i:arr)
            aux.put(i, aux.getOrDefault(i, 0)+1);
        for(int i:aux.values())
        //the key is to find if there's any int whose count is more than twice and also consider the number of groups allowed
            if(i>2*K)
                return 0;
        return 1;
    }
}
