/*
Given an array of N numbers. the task is to find minimum positive integer which can be assigned to every array element such that product of all elements of this new array is strictly greater than product of all elements of the initial array.

Example 1:

Input : Arr[] = {4, 2, 1, 10, 6}
Output : 4

Example 2:

Input : Arr[] = {3, 2, 1, 4}
Output : 3
Explanation:
Here we have an array [3, 2, 1, 4]
Product of elements of initial
array 3*2*1*4 = 24.
If x = 3 then 3*3*3*3 = 81, if x = 2 
then 2*2*2*2 =16. So minimal element = 3.
 

 

 

Your Task:
This is a function problem. The input is already taken care of by the driver code. You only need to complete the function findMin() that takes an array (arr), sizeOfArray (n), and return the minimum required element. The driver code takes care of the printing.

Expected Time Complexity: O(n * log(logn))
Expected Auxiliary Space: O(1).

Constraints:
2 ≤ N ≤ 106
1 ≤ A[i] ≤ 106
*/

/*
Let, x^n = a1 * a2 * a3 * a4 *....* an
we have been given n and value of a1, a2, a3, ..., an.
Now take log on both sides with base e

 n*logex > loge(a1) + loge(a2) +......+ loge(an)
Lets sum = loge(a1) + loge(a2) + ...... + loge(an)
 n*loge x > sum
 loge x > sum/n
Then take antilog on both side
 x > e^(sum/n) 
*/

//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class GFG {
	public static void main (String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		
		int testcases = sc.nextInt();
		
		while(testcases-- > 0){
		    
		    int n = sc.nextInt();
		    int arr[] = new int[n];
		    
		    
		    
		    for(int index = 0;index < n; index++){
		        arr[index] = sc.nextInt();
		    }
		    
		    Solution obj = new Solution();
		    
		    int v = obj.findMin(arr,n);
            System.out.println(v);
		}
		
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution{
    
    public int findMin(int a[], int n) 
    { 
        // Complete the function
        double temp=0;
        
        for(int i:a)
            temp+=Math.log(i);
        return (int)Math.exp(temp/n)+1;
    } 
     
}


