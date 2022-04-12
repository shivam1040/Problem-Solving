/*
Given an array of distinct integers. The task is to count all the triplets such that sum of two elements equals the third element.
 
Example 1:

Input:
N = 4
arr[] = {1, 5, 3, 2}
Output: 2
Explanation: There are 2 triplets: 
1 + 2 = 3 and 3 +2 = 5 
â€‹Example 2:

Input: 
N = 3
arr[] = {2, 3, 4}
Output: 0
Explanation: No such triplet exits
Your Task:  
You don't need to read input or print anything. Your task is to complete the function countTriplet() which takes the array arr[] and N as inputs and returns the triplet count

Expected Time Complexity: O(N2)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ N ≤ 103
1 ≤ arr[i] ≤ 105
*/

/*
Sort the given array first.
Start fixing the greatest element of three from the back and traverse the array to find the other two numbers which sum up to the third element.
Take two pointers j(from front) and k(initially i-1) to find the smallest of the two number and from i-1 to find the largest of the two remaining numbers
If the addition of both the numbers is still less than A[i], then we need to increase the value of the summation of two numbers, thereby increasing the j pointer, so as to increase the value of A[j] + A[k].
If the addition of both the numbers is more than A[i], then we need to decrease the value of the summation of two numbers, thereby decrease the k pointer so as to decrease the overall value of A[j] + A[k].
*/


// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            int n = Integer.parseInt(read.readLine());
            String input[] = read.readLine().split(" ");
            
            int arr[] = new int[n];
            for(int i = 0;i<n;i++){
                arr[i] = Integer.parseInt(input[i]);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.countTriplet(arr, n));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    int countTriplet(int arr[], int n) {
        Arrays.sort(arr);
        int count=0;
        for(int i=n-1; i>=0; i--){
            int j=0;
            int k=i-1;
            while(j<k){
                if((arr[j]+arr[k])==arr[i]){
                    count++;
                    j+=1;
                    k-=1;
                    //break;
                }
                else if((arr[j]+arr[k])<arr[i])
                    j+=1;
                else
                    k-=1;
            }
        }
        return count;
    }
}