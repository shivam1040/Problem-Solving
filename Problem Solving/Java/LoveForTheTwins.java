/*
Given an Array of Integers Arr of length N, you have to count number of elements of the array that can be counted as pair of equal elements.

 

Example 1:

Input : 
N = 7
Arr[] = {10, 10, 10, 20, 20, 10, 20}
Output:
6
Explanation:
The pairs formed are: (10,10),
(10,10), (20,20). The leftover 10
can't be paired with any other 10.
So, the Output is 6.
Example 2:

Input : 
N = 4
Arr = {10, 20, 30, 40}
Output:
0
Explanation:
No pairs can be formed.
So, the Output is 0.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function getTwinCount() which takes an Integer N and an Array Arr as input and returns the answer.

 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

 

Constraints:
1 <= N <= 105
1 ≤ Arr[i] ≤ 105
*/

//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            String S[] = read.readLine().split(" ");
            int[] Arr = new int[N];
            for(int i=0 ; i<N ; i++)
                Arr[i]=Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.getTwinCount(N,Arr));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int getTwinCount(int N , int[] Arr) {
        // code here
        Map<Integer, Integer> aux=new HashMap<>();
        int res=0;
        
        for(int i:Arr)
            aux.put(i, aux.getOrDefault(i, 0)+1);
        
        for(Map.Entry<Integer, Integer> entry: aux.entrySet())
            res+=entry.getValue()/2;
        
        return res*2;
    }
};
