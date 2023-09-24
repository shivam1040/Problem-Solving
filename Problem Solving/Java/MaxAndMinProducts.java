/*
Given a set, we need to find the maximum and minimum possible product among all subsets of the set.


Example 1:

Input : 
arr[] = {1, 2, 3};
Output : 
Maximum product = 6
Minimum product = 1
Explanation :
Maximum product is obtained by multiplying
2, 3
Minimum product is obtained by multiplying
1
 

Example 2:

Input :
arr[] = {4, -2, 5};
Output : 
Maximum product = 20
Minimum product = -40
Explanation :
Maximum product is obtained by multiplying
4 5
Minimum product is obtained by multiplying
4, -2, 5
 

Example 3:

Input :
arr[] = {-4, -2, 3, 7, 5, 0, 1};
Output : 
Maximum product = 840
Minimum product = -420
Explanation :
Maximum product is obtained by multiplying
-4, -2, 3, 7, 5
Minimum product is obtained by multiplying
-4, 3, 7, 5


Your Task:  
You don't need to read input or print anything. Your task is to complete the function getMaxandMinProduct() which takes the array arr[] and its size N as inputs and returns the maximum product and minimum subset product in an vector/array/list of size 2.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ N ≤ 20
-9 ≤ A[i] ≤ 9
*/

//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;




class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Solution obj = new Solution();
            long product[] = obj.getMaxandMinProduct(a, n);  
            System.out.println(product[1]+" "+product[0]);
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java



class Solution 
{
    long[] getMaxandMinProduct(int arr[], int n)  
    {
        // Your code goes here
        //https://www.youtube.com/watch?v=QLUg9v5NJc0
        /*
        If odd number of negatives: min = Product and max = Product / maxNegative

If even number of negatives: min = Product / maxNegative and max = Product

Border cases

1. When n == 1 return arr[0], arr[0]

2. When count of positives is 0 and count of zero >= 1, max = 0
        */
        long max=1, min=0;
        int zero=0, neg=0, maxNeg=Integer.MIN_VALUE, minPos=Integer.MAX_VALUE;
        
        for(int i:arr){
            if(i==0){
                ++zero;
                continue;
            }
            else if(i<0){
                ++neg;
                maxNeg=Math.max(maxNeg, i);
            }
            else if(i>0)
                minPos=Math.min(minPos, i);
            max*=i;
        }
        if(n==1)
            max=min=arr[0];
        else if(neg==1 && zero+neg==n){
            max=0;
            min=maxNeg;
        }
        //odd
        else if((neg&1)==1){
            min=max;
            max/=maxNeg;
        }
        else if((neg&1)!=1)
            min=max/maxNeg;
        if(neg==0 && zero==0)
            min=minPos;
        
        return new long[]{min, max};
    }
    
}
