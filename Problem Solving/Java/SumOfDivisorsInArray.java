/*
Given an array of natural numbers count the sum of its proper divisors for every element in the array.

Note: For simplicity, 0 is assumed to be a proper divisor of itself.


Example 1:

Input:
N = 3
arr = {2, 4, 3}
Output: {1, 3, 1}
Explaination: 
divisor of 2 is 1.
divisors of 4 is 1, 2.
divisor of 3 is 1.

Example 2:

Input:
N = 3
Arr = {2, 4, 1}
Output: {1, 3, 0}
Explaination: 
Proper divisor of 2 is 1.
Proper divisors of 4 is 1, 2.

Your Task:
You don't need to read input or print anything. Your task is to complete the function sumOfProperDivisors() which takes the array arr[] and its size N as input parameters and returns the sum of its proper divisors for every element in the array.


Expected Time Complexity: O(NlogN)
Expected Auxiliary Space: O(N)


Constraints:
1 ≤ N ≤ 100
0 ≤ arr[i] ≤ 100
*/

//{ Driver Code Starts
// Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(read.readLine().trim());
        while (T-- > 0) {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for (int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            Solution ob = new Solution();
            int[] ans = ob.sumOfProperDivisors(arr, N);
            for (int i = 0; i < ans.length; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    public int[] sumOfProperDivisors(int arr[], int N) {
        // code here
        int res[]=new int[N];
        int k=0;
        
        for(int i:arr){
            int sum=0;
            int j;
            
            for(j=2; j*j<i; j++)
                if(i%j==0)
                    sum+=j+i/j;
            if(j*j==i)
                sum+=j;
            if(i!=1)
                sum++;
            res[k++]=sum;
        }
        return res;
    }
}
