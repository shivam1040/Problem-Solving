/*
King is getting ready for a war. He know his strengths and weeknesses so he is taking required number of soldiers with him. King can only defeat enemies with strongest and weakest power, and one soldier can only kill one enemy. Your task is to calculate that how many soldiers are required by king to take with him for the war.
Note: The array may contain duplicates.
 

Example 1:

Input:
N = 2
A[] = {1, 5}
Output:
0
Explanatation:
The king will itself be able to defeat all the enemies.
 

Example 2:

Input:
N = 3
A[] = {1, 2, 5}
Output:
1
Explanatation:
The king will defeat enemies with power
1 and 5, and he will need 1 soldier to
defeat the enemy with power 2.
 

Your Task:  
You don't need to read input or print anything. Your task is to complete the function SoldierRequired() which takes the array A[] and its size N as inputs and returns the number of soldiers, king will need to take with him for the war.

Expected Time Complexity: O(NLogN)
Expected Auxiliary Space: O(1)
 

Constraints:
1 ≤ N ≤ 106
1 ≤ Ai ≤ 106
Array may contain duplicates


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
            
            Solution obj = new Solution();
            System.out.println(obj.SoldierRequired(a, n));
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java

class Solution {
    
    public static long SoldierRequired(long arr[], long n)
    {
         // Your code goes here 
         long max=Long.MIN_VALUE, min=Long.MAX_VALUE, res=0;
         
         for(long i:arr){
            if(i>max)
                max=i;
            if(i<min)
                min=i;
         }
         for(int i=0;i<n;i++)
         {
             if(arr[i]==min || arr[i]==max)
             {
                 continue;
             }
             else
             {
                 res++;
             }
         }
         return res;
    }
}
