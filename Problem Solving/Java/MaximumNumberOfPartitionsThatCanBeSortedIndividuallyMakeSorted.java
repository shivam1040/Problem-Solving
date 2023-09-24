/*
Given an array arr[ ] of size n such that elements of arr[ ] in range [0, 1, ..n-1]. Our task is to divide the array into the maximum number of partitions that can be sorted individually, then concatenated to make the whole array sorted.


Example 1:

â€‹Input : arr[ ] = {2, 1, 0, 3}
Output : 2
Explanation:
If divide arr[] into two partitions 
{2, 1, 0} and {3}, sort then and concatenate 
then, we get the whole array sorted.

â€‹Example 2:

Input : arr[ ] = {2, 1, 0, 3, 4, 5} 
Output :  4 
 

Your Task:
This is a function problem. The input is already taken care of by the driver code. You only need to complete the function maxPartitions() that takes an array (arr), sizeOfArray (n), and return the maximum number of partitions. The driver code takes care of the printing.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).


Constraints:
1 ≤ T ≤ 100
1 ≤ N ≤ 105
*/

//{ Driver Code Starts
//Initial Template for Java

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
		     
		    int arr [] = new int[sizeOfArray];
		    
		    line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    Complete obj = new Complete();
		    int ans = obj.maxPartitions(arr, sizeOfArray);
		    System.out.println(ans);
		}
	}
}




// } Driver Code Ends


//User function Template for Java



class Complete{
    
   
    // Function for finding maximum and value pair
    public static int maxPartitions (int arr[], int n) {
        //Complete the function
        //basic idea is to find max and if index matches then new partition can be created
                int ans = 0, max_so_far = 0;
        for (int i = 0; i < n; ++i) {
 
            // Find maximum in prefix arr[0..i]
            max_so_far = Math.max(max_so_far, arr[i]);
 
            // If maximum so far is equal to index, we can
            // make a new partition ending at index i.
            if (max_so_far == i)
                ans++;
        }
        return ans;
    }
    
    
}



