/*
Given an unsorted array of size N. Find the first element in array such that all of its left elements are smaller and all right elements to it are greater than it.

Note: Left and right side elements can be equal to required element. And extreme elements cannot be required element.

 

Example 1:

Input:
N = 4
A[] = {4, 2, 5, 7}
Output:
5
Explanation:
Elements on left of 5 are smaller than 5
and on right of it are greater than 5.
 

Example 2:

Input:
N = 3
A[] = {11, 9, 12}
Output:
-1
 

Your Task:  
You don't need to read input or print anything. Your task is to complete the function findElement() which takes the array A[] and its size N as inputs and returns the required element. If no such element present in array then return -1.

 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

 

Constraints:
3 <= N <= 106
1 <= A[i] <= 106
*/

/*
Create two arrays leftMax[] and rightMin[].
Traverse input array from left to right and fill leftMax[] such that leftMax[i] contains a maximum element from 0 to i-1 in the input array.
Traverse input array from right to left and fill rightMin[] such that rightMin[i] contains a minimum element from to n-1 to i+1 in the input array.
Traverse input array. For every element arr[i], check if leftMax[i]== rightMin[i]. If yes, return ele.

The required numbers are those which are largest when we traverse from left to right and Smallest when we traverse from right to left.

Since if a number is largest than all its left elements then all the left side elements are Smaller than it, similarly if it is Smallest than all its right side elements then its right side elements are greater than it, Hence it is the required number.
*/

// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-- > 0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[] a = new int[n];
            String[] inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Compute obj = new Compute();
            System.out.println(obj.findElement(a, n));
            
        }
	}
}// } Driver Code Ends


//User function Template for Java

class Compute {
    public int findElement(int arr[], int n){
        int res=-1;
        int left[]=new int[n];
        int right[]=new int[n];
        left[0]=arr[0];
        right[0]=arr[n-1];
        int min=arr[0];
        int max=arr[n-1];
        
        for(int i=0; i<n; i++){
            if(min<arr[i])
                min=arr[i];
            left[i]=min;
        }
        
        for(int i=n-1; i>0; i--){
            if(max>arr[i])
                max=arr[i];
            right[i]=max;
        }
        
        for(int i=0; i<n; i++){
            if(i!=0 && i!=n-1 && left[i]==right[i]){ //according to question the element shouldn't be at extremes
                res=left[i];
                break;
            }
        }
        return res;
    }
}
