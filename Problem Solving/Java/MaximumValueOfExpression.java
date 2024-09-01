/*
Given an array of N positive integers. The task is to find maximum value of |A[i] – A[j]| + |i – j|, where 0 <= i, j <= N – 1 and A[i], A[j] belong to the array.

 

Example 1:

Input : 
N = 4
A[] = { 1, 2, 3, 1 }
Output :
4
Explanation:
Choose i = 0 and j = 4
 

Example 2:

Input :
N = 3 
A[] = { 1, 1, 1 }
Output : 
2
 

Your Task:  
You don't need to read input or print anything. Your task is to complete the function maxValueOfExpression() which takes the array A[] and its size N as inputs and returns the maximum value of expression in array A[].

 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

 

Constraints:
1 <= N <= 105
1 <= A[i] <= 105
*/

/*
First of all lets make four equations by removing the absolute value signs (“|”). Following 4 equations will be formed, and we need to find the maximum value of these equation and that will be our answer.

arr[i] – arr[j] + i – j = (arr[i] + i) – (arr[j] + j)
arr[i] – arr[j] – i + j = (arr[i] – i) – (arr[j] – j)
-arr[i] + arr[j] + i – j = -(arr[i] – i) + (arr[j] – j)
-arr[i] + arr[j] – i + j = -(arr[i] + i) + (arr[j] + j)
Observe equation (1) and (4) are identical, similarly equation (2) and (3) are identical.

Now the task is to find the maximum value of these equation. So the approach is to form two arrays, first_array[], it will store arr[i] + i, 0 <= i < n, second_array[], it will store arr[i] – i, 0 <= i < n.
Now our task is easy we just need to find the maximum difference between two values these two arrays.

For that, we find maximum value and minimum value in first_array and store their difference:
ans1 = (maximum value in first_array – minimum value in first_array)
Similarly, we need to find maximum value and minimum value in second_array and store their difference:
ans2 = (maximum value in second_array – minimum value in second_array)
Our answer will be maximum of ans1 and ans2.
*/

//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            long n = Long.parseLong(br.readLine().trim());
            long a[] = new long[(int)(n)];
            
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.maxValueOfExpression(a, n));
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution {
    
    public long maxValueOfExpression(long a[], long n)
    {
        long max1=Integer.MIN_VALUE, max2=Integer.MIN_VALUE, min1=Integer.MAX_VALUE, min2=Integer.MAX_VALUE;
        
        for(int i=0; i<n; i++){
            max1=Math.max(max1, i+a[i]);
            min1=Math.min(min1, i+a[i]);
            max2=Math.max(max2, i-a[i]);
            min2=Math.min(min2, i-a[i]);
        }
        return Math.max(max1-min1, max2-min2);
    }
}
