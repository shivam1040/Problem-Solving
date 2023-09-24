/*
There is an array contains some non-negative integers. Check whether the array is perfect or not. An array is called perfect if it is first strictly increasing, then constant and finally strictly decreasing. Any of the three parts can be empty.

 

Example 1:

Input : Arr[] = {1, 8, 8, 8, 3, 2}
Output : Yes
Explanation:
We have an array [1, 8, 8, 8, 3, 2]. 
If we look in the range [0, 1] then 
we find that in this range the array is 
increasing, in the range [1, 3] the array 
is constant and in the range [3, 4] the 
array is decreasing.So, it satisfies the above 
condition then we return true.

Example 2:

Input : Arr[] = {1, 1, 2, 2, 1}
Output : No

Your Task:
This is a function problem. The input is already taken care of by the driver code. You only need to complete the function checkUnimodal() that takes an array (arr), sizeOfArray (n), and return bool value that is true if condition satisfied else false. The driver code takes care of the printing.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).
 

Constraints:
1 ≤ N ≤ 105
1 ≤ ai ≤ 108
*/

//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class GFG {
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		while(testcases-- > 0){
		    
		    int n = Integer.parseInt(br.readLine());
		    int arr[] = new int[n];
		    
		    
		    String line = br.readLine();
		    String[] elements = line.trim().split(" ");
		    
		    for(int index = 0;index < n; index++){
		        arr[index] = Integer.parseInt(elements[index]);
		    }
		    
		    Solution obj = new Solution();
		    
		    if(obj.checkUnimodal(arr,n))
		        System.out.println("Yes");
		    else
		        System.out.println("No");
		        
		}
		
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution{
    
    static boolean checkUnimodal(int arr[], int n) 
    { 
        // Complete the function
        int j=0;
        for(int i=1; i<n; i++){
            if(arr[i]>arr[i-1]){
                j=i;
            }
            else
                break;
        }
        for(int i=j+1; i<n; i++){
            if(arr[i]==arr[i-1])
                j=i;
            else
                break;
        }
        for(int i=j+1; i<n; i++){
            if(arr[i]>arr[i-1])
                return false;
            j=i;
        }
        return j==n-1 ? true : false;
    } 
}


