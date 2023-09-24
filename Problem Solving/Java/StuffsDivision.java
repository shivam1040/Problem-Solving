/*
Your are given N students with some goodies to be distrubuted among them such that student at ith index gets exactly i amount of goodies (considering no wastage). The goodies has already been distributed by some other. Your task is to check if it can be redistributed such that student at ith index gets i amount of goodies.
 

Example 1:

Input:
N = 5
Arr = {7, 4, 1, 1, 2}
Output:
YES
Explanation:
Since, all the goods can be
redistributed as 1 2 3 4 5 
(ith students get i number of 
goodies).So, output is YES.
 

Example 2:

Input:
N = 5
Arr = {1, 1, 1, 1, 1}
Output:
NO
 

Your Task:  
You don't need to read input or print anything. Your task is to complete the function leftIndex() which takes the array Arr[] and its size N as inputs and returns  true if we can redistribute in the requried way, otherwise false .


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)


Constraints:
1 <= N <= 107
0 <= Ai <= 1018
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
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            
            Compute obj = new Compute();
            System.out.println(obj.possible(a, n) ? "YES" : "NO");
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java


class Compute {
    
    public boolean possible(long arr[], long n)
    {
        long sum=n*(n+1)/2;
        
        for(long i:arr)
            sum-=i;
        
        return sum==0;
    }
}
