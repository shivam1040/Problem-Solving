/*
Given a sorted array arr[] of size N without duplicates, and given a value x. Floor of x is defined as the largest element K in arr[] such that K is smaller than or equal to x. Find the index of K(0-based indexing).

Example 1:

Input:
N = 7, x = 0 
arr[] = {1,2,8,10,11,12,19}
Output: -1
Explanation: No element less 
than 0 is found. So output 
is "-1".
Example 2:

Input:
N = 7, x = 5 
arr[] = {1,2,8,10,11,12,19}
Output: 1
Explanation: Largest Number less than 5 is
2 (i.e K = 2), whose index is 1(0-based 
indexing).
Your Task:
The task is to complete the function findFloor() which returns an integer denoting the index value of K or return -1 if there isn't any such number.

Expected Time Complexity: O(log N).
Expected Auxiliary Space: O(1).

Constraints:
1 ≤ N ≤ 107
1 ≤ arr[i] ≤ 1018
0 ≤ X ≤ arr[n-1]
*/
// { Driver Code Starts
    import java.util.*;
    import java.lang.*;
    import java.io.*;
    
    class Searching
    {
        public static void main (String[] args)throws IOException {
    
            BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(read.readLine());
            
            while(t-- > 0)
            {
               String a[] = read.readLine().trim().split("\\s+");
               int n = Integer.parseInt(a[0]);
               long x = Long.parseLong(a[(int)1]);
               String st[] = read.readLine().trim().split("\\s+");
            
               long arr[] = new long[n];
               for(int i = 0; i < n; i++)
               {
                   arr[i] = Long.parseLong(st[i]);
               }
               
               System.out.println(new Solution().findFloor(arr, n, x));
              
            }
        }
        
    }// } Driver Code Ends
    
    
    class Solution{
        
        // Function to find floor of x
        // arr: input array
        // n is the size of array
        static int findFloor(long arr[], int n, long x)
        {
            long res=Integer.MAX_VALUE;
            int pos=-1;
            int index=n/2;
            if(arr[index]==x)
                return index;
            else if(arr[index]<x){
                long temp=0;
                for(int i=index; i<n; i++){
                    temp=(x-arr[i]);
                    if(temp>=0 && temp<res){
                        res=temp;
                        pos=i;
                    }
                }
            }
            else if(arr[index]>x){
                long temp=0;
                for(int i=0; i<=index; i++){
                    temp=(x-arr[i]);
                    //System.out.println(temp);
                    if(temp>=0 && temp<res){
                        res=temp;
                        pos=i;
                    }
                }
            }
            if(res==Integer.MAX_VALUE)
                return -1;
            return pos;
        }
        
    }
    