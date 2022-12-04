/*
You will be given an array A of N non-negative integers. Your task is to find the rightmost non-zero digit in the product of array elements.


Example 1:

Input:
N = 4, A = {3, 23, 30, 45}
Output:
5
Explanation:
Product of these numbers 
are 93150.Rightmost 
non-zero digit is 5.
Example 2:

Input:
N = 5, A = {1, 2, 3, 4, 5}
Output:
2
Explanation:
Product of these numbers 
are 120. Rightmost 
non-zero digit is 2.

Your Task:

You don't need to read input or print anything. Your task is to complete the function rightmostNonZeroDigit() which takes an array A and returns the rightmost non-zero digit in the product of array elements, if there is no right most non zero digit, then return -1.


Expected Time Complexity: O(N*logN)
Expected Auxiliary Space: O(N)


Constraints:
1 ≤ N ≤ 105
0 ≤ A[i] ≤ 105 
*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int n = Integer.parseInt(read.readLine());
            int[] A = new int[n];
            String S[] = read.readLine().split(" ");
            for(int i=0; i<n; i++)
                A[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.rightmostNonZeroDigit(n, A));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int rightmostNonZeroDigit(int N, int[] A){
        // code here
        /*
        int pr=1;
        for(int i:A)
            pr*=i;
        while(pr>0){
            int a=pr%10;
            if(a!=0)
                return a;
            pr/=10;
        }
        return -1;
        */
        int c5=0, ans=1;
        //as we know last digit can be gotten by mod 10, to find that out a digit should be either divisible by 2 or 5
        //this loop takes care of finding number of times each digit in array can be divided
        for(int i=0; i<N; i++){
            while(A[i]>0 && A[i]%5==0){
                A[i]/=5;
                c5++;
            }
        }
        //Now divide each array element into its shortest divisible form by 2 and decrease the count of such occurrences. This way we are not considering the multiplication of 2 and a 5 in our multiplication, trailing zweoes avoided.
        for(int i=0; i<N; i++){
            while(c5>0 && A[i]>0 && A[i]%2==0){
                A[i]/=2;
                c5--;
            }
        }
        //this loop finds final product and mod 10 takes care of getting only last digit so that we do not store all the digits of product
        for(int i=0; i<N; i++){
           ans=(ans*A[i]%10)%10;
        }
        //it there is any count of 5 left then we need to consider it
        while(c5>0){
            ans=(ans*5)%10;
            c5--;
        }
        if(ans>0)
            return ans;
        return -1;
    }
}
