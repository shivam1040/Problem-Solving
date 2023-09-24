/*
Charul has been given a task by Ishaan. He challenges him to fill a large container of capacity K liters. Charul has N vessels with him with different capacities.
The capacities of the vessels are given by an array A. The condition is that the container should be filled up to the brim but no water should be wasted in overflowing. Also, the vessels can't be filled partially.
Determine if Charul can fill up the container with the given conditions or not.
Assume that Charul has an unlimited supply of water.

 

Example 1:

Input: 
arr[ ] = {6, 3, 4, 2, 1} and K = 20
Output: 
1
Explanation:
The container can be filled in the following manner : 
Add water using the 6 litre vessel 3 times :
Container filled upto 18 litres
Add water using the 2 litre vessel 1 time : 
Container filled upto 20 litres

Example 2:

Input: 
arr[] = {2, 4, 3} and K = 15 
Output:  
1
 

Your Task:
This is a function problem. The input is already taken care of by the driver code. You only need to complete the function vessel() that takes an array (arr), sizeOfArray (n), an integer K, and return the array return true if it is possible else return false. The driver code takes care of the printing.

Expected Time Complexity: O(N*K).
Expected Auxiliary Space: O(X). where X is the maximum element in an array.


Constraints : 
1 ≤ N ≤ 100
1 ≤ K ≤ 103
1 ≤ A[i] ≤ 100
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
		    
		    Complete obj = new Complete();
		    boolean ans = obj.vessel(arr, sizeOfArray, K);
		    if(ans == true)
		        System.out.println(1);
		    else
		        System.out.println(0);
		    
		}
	}
}



// } Driver Code Ends


//User function Template for Java

class Complete{
    
   
    // Function for finding maximum and value pair
    public static boolean vessel (int arr[], int n, int k) {
        //Complete the function
        int dp[]=new int[k+1];
        
        for(int i=1; i<k+1; i++){
            for(int j=0; j<n; j++){
                if(arr[j]<=i){
                    //this means find the max between current value of i index and the previous one, also the capacities are addexd to ensure it is accounted for every new iteration
                    dp[i]=Math.max(dp[i], dp[i-arr[j]]+arr[j]);
                }
            }
            if(dp[i]==k)
                return true;
        }
        return false;
    }
    
    
}






