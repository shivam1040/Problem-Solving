/*
Given an array with n elements. Find length of the largest sub-array having GCD equal to 1. If no such  subarray exist with GCD 1, return -1.

Example 1:

Input: n = 3, arr = [1, 3, 5]
Output: 3 
Explanation: GCD of 1, 3 and 5
is equal to 1.So the length is 3. 
Example 2:

Input: n = 3, arr = [2, 4, 6]
Output: -1
Explanation: No such  subarray exist.

Your Task:  
You dont need to read input or print anything. Complete the function findLargestSubarray() which takes array arr of length n as input parameter and returns the length of the largest subarray and if no such subarray exist
returns -1. 

Expected Time Complexity: O(nlogn)
Expected Auxiliary Space: O(1)

Constraints:
1<= n <=1000
1<= arr[i] <=1000
*/

/*
An efficient solution is based on fact that if any two elements have GCD equals to one, then whole array has GCD one. So the output is either -1 or length of array. 
*/

//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int n = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[n];
            for(int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.findLargestSubarray(arr, n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution
{
    static int findLargestSubarray(int arr[], int n)
    {
        // code here
        int gcd=arr[0];
        
        for(int i=1; i<n; i++)
            gcd=gcd(gcd, arr[i]);
        return gcd==1 ? n : -1;
    }
    
    private static int gcd(int a, int b)
    {
         
        // Everything divides 0 
        if (a == 0 || b == 0)
            return 0;
     
        // base case
        if (a == b)
            return a;
     
        // a is greater
        if (a > b)
            return gcd(a - b, b);
             
        return gcd(a, b - a);
    }
}
