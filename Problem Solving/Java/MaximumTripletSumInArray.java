/*

Given an array, the task is to find the maximum triplet sum in the array.

Example 1:

Input : arr[ ] = {4, 2, 7, 9}
Output : 20
Explanation:
Here are total 4 combination: 
(0, 1, 2),(0, 1, 3),(0, 2, 3),(1, 2, 3).
So, the Sum of these combinations is 
13,15, 20,and 18.The maximum sum is 20.

 

Example 2:

Input : arr[ ] = {1, 0, 8, 6, 4, 2} 
Output : 18 


Your Task:
This is a function problem. The input is already taken care of by the driver code. You only need to complete the function maxTripletSum() that takes an array (arr), sizeOfArray (n), and return the maximum triplet sum in the array. The driver code takes care of the printing.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).
 

Constraints:
3 ≤ N ≤ 105
-105 ≤ A[i] ≤ 105
*/

//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class Solution{
    
  
    int maxTripletSum(int a[], int n)
    {
        // Complete the function
        int l1=Integer.MIN_VALUE, l2=Integer.MIN_VALUE, l3=Integer.MIN_VALUE;
        
        for(int i:a){
            if(i>l1){
                l3=l2;
                l2=l1;
                l1=i;
            }
            else if(i>l2){
                l3=l2;
                l2=i;
            }
            else if(i>l3)
                l3=i;
        }
        
        return l3+l2+l1;
    }
  
    
}


//{ Driver Code Starts.

// Driver class
class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    
		    String line1 = br.readLine();
		    String[] element = line1.trim().split("\\s+");
		    int sizeOfArray = Integer.parseInt(element[0]);
		    
		    int arr [] = new int[sizeOfArray];
		    
		    String line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    
		    Solution obj = new Solution();
		    int res = obj.maxTripletSum(arr, sizeOfArray);
		    System.out.println(res);
		}
	}
}


// } Driver Code Ends
