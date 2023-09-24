/*
Given an array A of positive integers, sort the array in ascending order such that element at index K in unsorted array stays unmoved and all other elements are sorted.

 

Example 1:

â€‹Input : arr[ ] = {10, 4, 11, 7, 6, 20} 
        and K = 2
Output : 4 6 11 7 10 20
Explanation:
Sort an array except an index 2 So, 
4 6 11 7 10 20 

â€‹Example 2:

Input : arr[ ] = {30, 20, 10} and K = 0
Output :  30 10 20 
 

Your Task:
This is a function problem. The input is already taken care of by the driver code. You only need to complete the function sortExceptK() that takes an array (arr), sizeOfArray (n), an integer K and return he sorted array except for the element at index K. The driver code takes care of the printing.

Expected Time Complexity: O(N*LOG(N)).
Expected Auxiliary Space: O(1).


Constraints:
1 ≤ N ≤ 105
*/

//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java


/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    String line = br.readLine();
		    String[] element = line.trim().split("\\s+");
		    int N = Integer.parseInt(element[0]);
		    int arr [] = new int[N];
		    line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    for(int i = 0;i<N;i++){
	            arr[i] = Integer.parseInt(elements[i]);    
	        }
		    
		    int M = Integer.parseInt(br.readLine());
		    
		    Complete obj = new Complete();
		    arr = obj.sortExceptK(arr, N, M);
        	for (int i = 0; i < N; i++)
        	{
        	    System.out.print(arr[i] + " ");
        	}
        	System.out.println();
		}
	}
}



// } Driver Code Ends


//User function Template for Java

class Complete{
    
   
    // Function for finding maximum and value pair
    public static int[] sortExceptK (int arr[], int n, int k) {
        //Complete the function
        int temp=arr[n-1];
        int k1=arr[k];
        arr[n-1]=arr[k];
        arr[k]=temp;
        
        Arrays.sort(arr, 0, n-1);
        
        for(int i=n-2; i>=k; i--)
            arr[i+1]=arr[i];
            
        arr[k]=k1;
        return arr;
        
    }
    
    
}

