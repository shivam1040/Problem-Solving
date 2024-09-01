/*
Adam has N chocolates of unequal lengths. He wants that each chocolate should be of equal lengths. In order to do so,at each step, he picks two unequal length chocolates and takes their length difference 'd' and then he eats the bigger one and make it's length  'd' . He stops when all the chocolates are of equal length . Find the final length of all chocolates.

 

Example 1:

Input:
N = 2 
A[] = {10 , 12}
Output:
2
Explanation:
{10,12} -> {10,2} -> {8,2} -> {6,2}
-> {4,2} -> {2,2} 
So, the final length is 2.
Example 2:

Input:
N = 3
A[] = {6 , 10 , 15}
Output:
1
Explanation:
{6,10,15} -> {6,10,9} -> {6,4,9} ->
{6,4,3} -> {2,4,3} -> {2,4,1} ->
{2,2,1} -> {1,2,1} -> {1,1,1}
So, the final length is 1.
[Note:this is one way of eating chocolates,
there could be many..] 
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function chocolateLength() which takes an Integer N and an Array A[] as input and returns the answer.

 

Expected Time Complexity: O(N*log(N))
Expected Auxiliary Space: O(1)

 

Constraints:
1 <= N <= 105
1 <= A[i] <= 108
*/

/*
You are given a set of N positive numbers A[0], A[1], ..., A[N-1]. At each step you pick two unequal numbers and replace the larger one by the difference. You stop when all numbers are equal. Find at what number will you stop.

Key:

You stop at the GCD of the numbers. 
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
            
            int[] A = new int[N];
            
            for(int i=0 ; i<N ; i++)
                A[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.chocolateLength(N,A));
        }
    }
}
// } Driver Code Ends


class Solution {
    static int chocolateLength(int N , int[] A) {
        // code here
        int res=A[0];
        
        for(int i=1; i<N; i++)
            res=gcd(res, A[i]);
        return res==1 ? 1 : res;
    }
    
    private static int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }
};
