/*
Given an increasing sequence a[], we need to find the K-th missing contiguous element in the increasing sequence which is not present in the sequence. If no k-th missing element is there output -1.

Example 1:

Input : arr[ ] = {1, 3, 4, 5, 7} and K = 2
Output : 6
Explanation:
K = 2, We need to find the 2nd missing 
number in the array. Missing numbers are 
2 and 6. So 2nd missing number is 6.
 

Example 2:

Input : arr[ ] = {1, 2, 3, 4, 5, 6} 
Output :  -1 
 

Your Task:
This is a function problem. The input is already taken care of by the driver code. You only need to complete the function KthMissingElement() that takes an array (arr), sizeOfArray (n), an integer K and return the Kth missing number if present otherwise returns -1. The driver code takes care of the printing.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

 

Constraints:
1 ≤ N, K, A[i] ≤ 105
*/

//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

//User function Template for Java

            

class Complete{
    
    int KthMissingElement(int arr[], int n, int k)
    {
        // Complete the function
        int j=0;
        int res=0;
        
           for(int i=1; i<n; i++){
            int diff=arr[i]-arr[i-1];
            if(diff!=1){
                while(diff>1 && k>0){
                    j++;
                    res=arr[i-1]+j;
                    k--;
                    diff--;
                }
                if(k>0){
                    res=0;
                    j=0;
                }
                else
                    break;
        }
        }
        return j>0 ? res : -1;
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
		    int K = Integer.parseInt(element[1]);
		    
		    int arr [] = new int[sizeOfArray];
		    
		    String line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    
		    Complete obj = new Complete();
		   
		    int res = obj.KthMissingElement(arr, sizeOfArray, K);
		    
		    System.out.println(res);
		    
		    
		}
	}
}



// } Driver Code Ends
