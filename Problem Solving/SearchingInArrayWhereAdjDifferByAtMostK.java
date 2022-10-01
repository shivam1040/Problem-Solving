/*
A step array is an array of integer where each element has a difference of at most k with its neighbor. Given a key x, we need to find the index value of x if multiple elements exist, return the first occurrence of the key.


Example 1:

â€‹Input : arr[ ] = {4, 5, 6, 7, 6}, K = 1 
        and X = 6
Output : 2
Explanation:
In an array arr 6 is present at index 2.
So, return 2.

â€‹Example 2:

Input : arr[ ] = {20 40 50}, K = 20 
        and X = 70
Output :  -1 
 

Your Task:
This is a function problem. The input is already taken care of by the driver code. You only need to complete the function search() that takes an array (arr), sizeOfArray (n), an integer value X, another integer value K, and return an integer displaying the index of the element X in the array arr. If the element is not present in the array return -1. The driver code takes care of the printing.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

 

Constraints:
1 ≤ N ≤ 105
1 ≤ K ≤ 102
1 ≤ arr[i], X ≤ 105
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
		    int sizeOfArray = Integer.parseInt(element[0]);
		    int K = Integer.parseInt(element[1]);
		    int arr [] = new int[sizeOfArray];
		    
		    line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    int X = Integer.parseInt(br.readLine());
		    
		    Complete obj = new Complete();
		    int ans = obj.search(arr, sizeOfArray, X, K);
		    System.out.println(ans);
		}
	}
}

// } Driver Code Ends


//User function Template for Java



class Complete{
    
   
    // Function for finding maximum and value pair
    public static int search (int arr[], int n, int x, int k) {
        //Complete the function
        int i=0;
        
        while(i<n){
            if(arr[i]==x)
                return i;
            //as we know that adjacent ele diff is k, so to get index of x what we can do is find number of steps we need to move forward from i in increments of k, so that means arr[i]-x/k will give number of steps we need to move forward for that
            i+=Math.max(1, Math.abs(arr[i]-x)/k);
        }
        return -1;
    }
    
    
}






