/*
You are given an array A of size N. The task is to find count of elements before which all the elements are smaller. First element is always counted as there is no other element before it.

 

Example 1:

Input : 
arr[] =  {10, 40, 23, 35, 50, 7}
Output : 
3
Explanation :
The elements are 10, 40 and 50.
No of elements is 3
 

Example 2:

Input : 
arr[] = {5, 4, 1}
Output : 
1
Explanation :
There is only one element 5
No of element is 1

 

Your Task:  
You don't need to read input or print anything. Your task is to complete the function countElements() which takes the array arr[] and its size N as inputs and returns the Number of Elements before which no element is bigger.
 


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)



Constraints:
1 ≤ N ≤ 105
1 ≤ Ai ≤ 109
*/

//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            long n = Long.parseLong(br.readLine().trim());
            long a[] = new long[(int)n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            
            Solution obj = new Solution();  
            System.out.println(obj.countElements(a, n));
            
        }
	}
}
// } Driver Code Ends


//User function Template for Java


class Solution {
    static long countElements(long arr[], long n) 
    {
        // Your code goes here
        long res=1;
        long temp=arr[0];
        
        for(int i=1; i<n; i++){
            if(arr[i]>temp){
                temp=arr[i];
                ++res;
            }
        }
        return res;
    }
}

