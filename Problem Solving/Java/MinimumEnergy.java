/*
Given an array containing positive and negative numbers. The array represents checkpoints from one end to other end of street. Positive and negative values represent amount of energy at that checkpoint. Positive numbers increase the energy and negative numbers decrease. Find the minimum initial energy required to cross the street such that Energy level never becomes 0 or less than 0.

Note :  The value of minimum initial energy required will be 1 even if we cross street successfully without loosing energy to less than and equal to 0 at any checkpoint. The 1 is required for initial check point.

 

Example 1:

Input
N = 5
A[] = {4, -10, 4, 4, 4}
Output
7
Explanation
By having an initial energy of 7 we can
make sure that all the checkpoints are
visited and the fuel never reaches 0
or less value.
 

Example 2:

Input
N = 5
A[] = {3, 5, 2, 6, 1}
Output
1
Explanation
We need at least 1 initial energy
to reach first checkpoint.


Your Task:
You don't need to print anything, printing is done by the driver code itself. You need to complete the function minEnergy() which takes the array A[] and its size N as inputs and returns the minimum initial energy required to cross the street.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)


Constraints:
1 ≤ N ≤ 105
-103 ≤ A[i] ≤ 103
*/


/*
We take initial minimum energy 0 i.e; initMinEnergy = 0 and energy at any checkpoint as currEnergy = 0. Now traverse each checkpoint linearly and add energy level at each i’th checkpoint i.e; currEnergy = currEnergy + arr[i]. If currEnergy becomes non-positive, then we need at least “abs(currEnergy) + 1” extra initial energy to cross this point. Therefore we update initMinEnergy = (initMinEnergy + abs(currEnergy) + 1). We also update currEnergy = 1 as we now have the required extra minimum initial energy for next point
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
            int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.minEnergy(a, n));
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java


class Solution {

    public static int minEnergy(int a[], int n)
    {
         // Your code goes here
         
         // currEnergy is variable to store
    // current value of energy at
    // i'th checkpoint on street
    
    // initMinEnergy is variable to store
    // minimum initial energy required.
         int cur=0, min=0;
         
         // flag to check if we have successfully
    // crossed the street without any energy
    // loss <= o at any checkpoint
         boolean flag=false;
         
         for(int i:a){
             cur+=i;
             if(cur<=0){
                 min+=Math.abs(cur)+1;
                 cur=1;
                 flag=true;
             }
         }
         
         return flag ? min : 1;
    }
}

