/*
Given two arrays a[] and b[] of same size.Your task is to find minimum sum of two elements such that they belong to different arrays and are not at same index in their arrays.


Example 1:

Input : 
a[] = {5, 4, 13, 2, 1}
b[] = {2, 3, 4, 6, 5}
Output : 
3
Explanation :
We take 1 from a[] and 2 from b[]
Sum is 1 + 2 = 3.
 
Example 2:
Input : 
a[] = {5, 4, 13, 1}
b[] = {3, 2, 6, 1}
Output : 
3
Explanation :
We take 1 from a[] and 2 from b[].
Note that we can't take 1 from b[]
as the elements can not be at same
index. 
 

Your Task:  
You don't need to read input or print anything. Your task is to complete the function minSum() which takes the array A[], B[] and its size N as inputs and returns the minimum sum.

 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)


Constraints:
1<=N<=105
1<=a[i]<=105
1<=b[i]<=105

*/

//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[(int)(n)];
            int b[] = new int[(int)(n)];
            
            
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            String inputLine1[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                b[i] = Integer.parseInt(inputLine1[i]);
            }
            
            
            Solution obj = new Solution();
            System.out.println(obj.minSum(a, b, n));
        }
	}
}

// } Driver Code Ends


//User function Template for Java



class Solution {

    public int minSum(int a[], int b[], int n) {
        int aMin=Integer.MAX_VALUE, bMin=Integer.MAX_VALUE, aI=-1, bI=-1;
        
        for(int i=0; i<n; i++){
            if(a[i]<aMin){
                aMin=a[i];
                aI=i;
            }
            if(b[i]<bMin){
                bMin=b[i];
                bI=i;
            }
        }
        
        if(aI==bI){
            int aS=Integer.MAX_VALUE, bS=Integer.MAX_VALUE;
            
            for(int i=0; i<n; i++){
                if(i!=aI && a[i]<aS && a[i]>=aMin)
                    aS=Math.min(aS, a[i]);
                if(i!=bI && b[i]<bS && b[i]>=bMin)
                    bS=Math.min(bS, b[i]);
            }
            return Math.min(aMin+bS, bMin+aS);
        }
        return aMin+bMin;
    }
}
