/*
Vishesh, who doesn't like maths, has to certify v-shaped tracks. A track is valid if it satisfies the following conditions :

1. There must be a constant difference between the height of pillars (not zero) of a track. For eg., if the heights of first two pillars are 7 and 5, then height of 3rd pillar must be 3. As 7-5=2 & 5-3=2.

2. The height of middle pillar must be always 1.

3. Number of pillars on the left side must be equal to the number of pillars on the right side of middle pillar. And their heights must be also equal. for example: Track with pillar heights [3 2 1 2 3] is a valid track. 
Help him in finding the valid tracks.

 

Example 1:

Input:
N = 3
A[] = {2, 1, 2}
Output:
Yes

Example 2:

Input:
N = 5
A[] = {4, 3, 2, 3, 4}
Output:
No
 

Your Task:  
You don't need to read input or print anything. Your task is to complete the function answer() which takes the array A[] and its size N as inputs and returns "Yes" if it is a valid v-shaped track. Otherwise, return "No".

 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

 

Constraints:
3 <= N <= 106
1 <= H[i] <= 106
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
            System.out.println(obj.answer(a, n));
            
        }
	}
}



// } Driver Code Ends


//User function Template for Java

class Compute {
    
    public String answer(long arr[], long nn)
    {
           int n=arr.length;
           long temp=Math.abs(arr[1]-arr[0]);

        if(n%2==0)
            return "No";
        if(arr[n/2]!=1)
            return "No";
        if(temp==0)
            return "No";
        for(int i=2; i<n; i++){
            if(arr[i-1]!=arr[n-i])
                return "No";
            if(Math.abs(arr[i]-arr[i-1])!=temp)
                return "No";
        }
        return "Yes";
    }
}
