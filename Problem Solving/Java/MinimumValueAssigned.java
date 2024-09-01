/*
Given an array arr[] of N integers, Geek wants to assign a value to each of the array elements. The minimum value that can be assigned to an element is 1. For every pair of adjacent elements, the one with the higher integral value should be assigned a higher value. Help Geek assign the smallest possible value to each element and find the sum of the values.


Example 1:

Input: 
N = 4
arr[] = {1, 2, 3, 4}

Output: 10

Explaination: First element is assigned value 1. 
Second element is assigned value 2 because 
arr[1]>arr[0].Third element is assigned value 3 
because arr[2]>arr[1]. Fourth element is assigned 
value 4 because arr[3]>arr[2]. 1+2+3+4 =10.

Example 2:

Input: 
N = 3
arr[] = {2, 4, 4}

Output: 4

Explaination: First element is assigned value 1.
Second element is assigned value 2 because 
arr[1]>arr[0]. Third element is assigned value 1 
because arr[2] is equal to arr[1]. 1+2+1 = 4.

Your Task:
You do not need to read input or print anything. Your task is to complete the function minValue() which takes N and arr[] as input parameters and returns the minimum possible sum.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)


Constraints:
1 ≤ N ≤ 100
1 ≤ arr[i] ≤ 105  
*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String a[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(a[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.minValue(N, arr));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int minValue(int n, int arr[]){
        // code here
        int l[]=new int[n];
        int r[]=new int[n];
        l[0]=1;
        r[n-1]=1;
        int res=0;
        
        for(int i=1; i<n; i++)
            if(arr[i]>arr[i-1])
                l[i]=l[i-1]+1;
            else
                l[i]=1;
        for(int i=n-2; i>=0; i--)
            if(arr[i]>arr[i+1])
                r[i]=r[i+1]+1;
            else
                r[i]=1;
        for(int i=0; i<n; i++)
            res+=Math.max(l[i], r[i]);
        return res;
    }
}

