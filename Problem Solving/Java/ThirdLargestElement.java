/*
Given an array of distinct elements. Find the third largest element in it.

Suppose you have A[] = {1, 2, 3, 4, 5, 6, 7}, its output will be 5 because it is the 3 largest element in the array A.

Example 1:

Input:
N = 5
A[] = {2,4,1,3,5}
Output: 3
Example 2:

Input:
N = 2
A[] = {10,2}
Output: -1
Your Task:
Complete the function thirdLargest() which takes the array a[] and the size of the array, n, as input parameters and returns the third largest element in the array. It return -1 if there are less than 3 elements in the given array.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ N ≤ 105
1 ≤ A[i] ≤ 105
*/

// { Driver Code Starts
    import java.util.Scanner;
    import java.util.*;
    import java.io.*;
    
    class ThirdLargestElement
    {
        public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t>0)
            {
                int n =sc.nextInt();
                int arr[] = new int[n];
                for(int i=0;i<n;i++)
                    arr[i] = sc.nextInt();
                Solution g = new Solution();
                System.out.println(g.thirdLargest(arr,n));
            t--;
            }
        }
    }// } Driver Code Ends
    
    
    class Solution
    {
        int thirdLargest(int aa[], int n)
        {
           int res=Integer.MIN_VALUE;
            int res2=Integer.MIN_VALUE;
            int res3=Integer.MIN_VALUE;
            boolean firstRun=true;
            if(aa.length<3)
                return -1;
            res=aa[0];
            for(int i=1; i<n; i++){
                if(aa[i]>res){
                    res3=res2;
                    res2=res;
                    res=aa[i];
                }
                else if(aa[i]>res2){
                    res3=res2;
                    res2=aa[i];
                }
                else if(aa[i]>res3)
                    res3=aa[i];
            }
            return res3;
        }
    }
    