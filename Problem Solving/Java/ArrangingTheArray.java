/*
You are given an array of size N. Rearrange the given array in-place such that all the negative numbers occur before positive numbers.(Maintain the order of all -ve and +ve numbers as given in the original array).
 

Example 1:

Input:
N = 4
Arr[] = {-3, 3, -2, 2}
Output:
-3 -2 3 2
Explanation:
In the given array, negative numbers
are -3, -2 and positive numbers are 3, 2. 
 

Example 2:

Input:
N = 5
Arr[] = {2, -4, 7, -3, 4}
Output:
-4 -3 2 7 4
 

Your Task:  
You don't need to read input or print anything. Your task is to complete the function Rearrange() which takes the array Arr[] and its size N as inputs and returns the array after rearranging with spaces between the elements of the array.

Expected Time Complexity: O(N. Log(N))
Expected Auxiliary Space: O(Log(N))

 

Constraints:
1 ≤ N ≤ 107
-1018 ≤ Elements of array ≤ 1018
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
            obj.Rearrange(a, n);
            
            StringBuilder output = new StringBuilder();
            for(int i=0;i<n;i++)
                output.append(a[i]+" ");
            System.out.println(output);
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java

class Compute {
    
    public void Rearrange(long arr[], long n)
    {
       int i=0, j=0;
       
       while(j<n){
           if(arr[j]>=0)
            j++;
           else{
               //swapping every element one by one with the first occurence of negative ele, here the first occurence is swapped from found position to begining
               for(int k=j; k>i; k--){
                   long temp=arr[k-1];
                   arr[k-1]=arr[k];
                   arr[k]=temp;
               }
               i++;
               j++;
           }
       }
    }
}
