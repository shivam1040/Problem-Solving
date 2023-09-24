/*
Given an array Arr of N integers.Calculate the sum of Bitwise ANDs(&) all the pairs formed by the given array.

Example 1:

Input:
N=3
Arr={5,10,15}
Output:
15
Explanation:
The bitwise Ands of all pairs are (5&10)=0
(5&15)=5 and (10&15)=10.Therefore,
total Sum=0+5+10=15.
Example 2:

Input:
N=4
Arr={10,20,30,40}
Output:
46
Explanation:
The sum of bitwise Ands 
of all pairs=0+10+8+20+0+8=46.

Your Task:
You don't need to read input or print anything.Your Task is to complete the function pairAndSum() which takes an Integer N and an array Arr as input parameters and returns the sum of bitwise Ands of all pairs.

Expected Time Complexity:O(N)
Expected Auxillary Space:O(1)

Constraints:
1<=N<=105
1<=Arri<=108
*/

//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            long Arr[] = new long[N];
            String[] S = read.readLine().split(" ");
            for (int i = 0; i < N; i++) Arr[i] = Long.parseLong(S[i]);
            Solution ob = new Solution();
            System.out.println(ob.pairAndSum(N, Arr));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static long pairAndSum(int n, long arr[]) {
        // code here
        long sum=0;
        
        //32 beacause we assume 32 bit integers
        for(int i=0; i<32; i++){
            long k=0;
            for(int j=0; j<n; j++)
            //we check if the bit at position i is set in arr
                if((arr[j] & (1<<i)) !=0)
                    k++;
            //this k maths is same as nC2 so basically finding number of pair combinations for such count of setbits
            //we calculate the number of bitwise ANDs for k
            //The expression (1 << i) calculates the bit value for the specific bit position i. Shifting 1 to the left by i positions creates a value with only the ith bit set, and all other bits are 0.
            
            sum+=(1<<i)*(k*(k-1)/2);
        }
        
        return sum;
    }
}
