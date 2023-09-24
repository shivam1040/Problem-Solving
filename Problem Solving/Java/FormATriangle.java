/*
Given an array of integers, we need to find out all possible ways construct non-degenerate triangle using array values as its sides. If no such triangle can be formed then return 0.

 

Example 1:

Input : [5, 4, 3, 1, 2]
Output : 3
Explanation:
Sides of possible triangle are
(2 3 4), (3 4 5) and (2 4 5)
 

Example 2:

Input : [4, 1, 2]
Output : 0 
No triangle is possible from given
array values

Your Task:  
You don't need to read input or print anything. Your task is to complete the function noOfTriangles() which takes the vector v[] and its size N as inputs and returns the count of all possible triangles that can be formed using the values from the array.

Expected Time Complexity: O(N2)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ N ≤ 103
1 ≤ A[i] ≤ 104


*/

/*
A + B > C    and     
B + C > A    and
C + A > B
where A, B and C are length of sides of the triangle.
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
            System.out.println(obj.noOfTriangles(a, n));
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    
    public static int noOfTriangles(int arr[], int n)
    {
        // Your code goes here
        int res=0;
        
        Arrays.sort(arr);
        
        for(int i=n-1; i>=2; i--){
            int low=0;
            int high=i-1;
            //the basic idea is to find triplets which satisfy this condition
            while(low<high){
                if(arr[low]+arr[high]>arr[i])
                //taking the diff ensures that all the possible pairs are accounted for
                    res+=(high-low);
                    high--;
                }
                else
                    low++;
            }
        }
        return res;
    }
}
