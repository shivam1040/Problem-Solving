/*
Given an array of 0 and 1. In how many iterations it is possible that the whole array can be filled with 1's, if in a single iteration immediate neighbours of 1's can be filled.

 

Example 1:

Input:
n = 4
a[] = {1, 0, 1, 0}
Output:
1
Explanation:
Both the 0s has 1 as their immediate neighbour.
So, only one iteration is required to fill the
array with 1.
 

Example 2:

Input:
n = 5
a[] = {0, 0, 1, 0, 0}
Output:
2
 

Your Task:  
You don't need to read input or print anything. Your task is to complete the function minMoves() which takes the array A[] and its size N as inputs and returns the minimum number of iterations to fill the whole array with 1's (if possible). If it is not possible to fill the array with 1s, return -1 .

 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

 

Constraints:
1 <= N <= 107
0 <= Ai <= 1


*/
Case 1 : A block of 0s has 1s on both sides

Let count_zero be the count of zeros in the block.

Number of iterations are always equal to : 
              count_zero/2   if (count_zero is even)
              count_zero+1)/2    if(count_zero is odd).

Case 2 : Either single 1 at the end or in 
         the starting. For example 0 0 0 0 1 and 
         1 0 0 0 0
In this case the number of iterations required will 
always be equal to number of zeros.

Case 3 : There are no 1s (Array has only 0s)
In this case array can't be filled with all 1's. 
So print -1.


1-Start traversing the array.
  (a) Traverse until a 0 is found.
     while (i < n && a[i] == 1)
     {
        i++;
        flag=true;
     }
   Flag is set to true just to check at 
   the last if array contains any 1 or not.

  (b) Traverse until a 1 is found and Count 
     contiguous 0 .
     while (i < n && a[i] == 0)
     {
         count_zero++;
         i++;
     }

  (c) Now check which case is satisfied by 
     current subarray. And update iterations 
     using count and update max iterations.  `
/*

*/
//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            long n = Long.parseLong(br.readLine().trim());
            long a[] = new long[(int)(n)];
            // long getAnswer[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            
            Compute obj = new Compute();
            System.out.println(obj.minMoves(a, n));
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java


class Compute {
    
    public long minMoves(long arr[], long n)
    {
        boolean oneFound=false;
        int res=0;
        
        for(int i=0; i<n;){
            
            if(arr[i]==1){
                oneFound=true;
            }
            
            while(i<n && arr[i]==1){
                i++;
            }
            
            int zero=0;
            
            while(i<n && arr[i]==0){
                zero++;
                i++;
            }
            
            if(oneFound==false && i==n)
                return -1;
            
            int curr_zero;
            
            if(i<n && oneFound==true){
                if(zero%2==0)
                    curr_zero=zero/2;
                else
                    curr_zero=(zero+1)/2;
                zero=0;
            }
            else{
                curr_zero=zero;
                zero=0;
            }
            
            res=Math.max(res, curr_zero);
        }
        
        return res;
    }
}
