/*
Akshay loves to play with numbers and arrays. He took an array of size " 2n " where n is any positive integer chose by him. He tries to divide the array into n pairs, such that the pair sum minimizes the maximum sum of a pair.
For example, say we have an array with the given numbers [9, 6, 1, and 5]. The possible pairs are
( 1, 6 ) , ( 5 , 9 ) or ( 1 , 5 )  , ( 6 , 9 ) or  ( 1 , 9 ) , ( 5 , 6 ). The pair sums for these partitions are ( 7, 14 ) and ( 6, 15 ) and ( 10, 11 )  respectively.  The ideal or the selected pairs are (1, 9), (5, 6 )  because out of all the three cases or possibilities we only have (1, 9), (5, 6 )  where the sum of both pairs is a minimum of all the maximum sum of all three possibilities. 

 

Example 1:

â€‹Input : arr[ ] = {5, 8, 3, 9} and N = 2
Output : 13
Explanation:
Possible pairs: 
(8,9)(3,5) -->Case 1
Sum : (17)(8) --> maximum sum 17
(5,9)(3,8) -->Case 2
Sum : (14)(11) ----> maximum sum 14
(3,9)(5,8) -->Case 3
Sum : (12)(13)--> maximum sum 13
In case 3 , the maximum sum is minimum of 
all the other cases. Hence, the answer is 13.

Example 2:

Input : arr[ ] = {1, 6, 5, 9} and N = 2
Output : 11


Your Task:
This is a function problem. The input is already taken care of by the driver code. You only need to complete the function Pair_minimum() that takes an array (arr), sizeOfArray (n), and return the minimum of all the maximum sum of all possibilities. The driver code takes care of the printing.

Expected Time Complexity: O(N*Log(N)).
Expected Auxiliary Space: O(1).

 

Constraints:
1 ≤ N ≤ 105
1 ≤ A[2*N] ≤ 105
*/

//{ Driver Code Starts
//Initial Template for Java

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
		    
		    
		    Solution obj = new Solution();
		    int res = obj.Pair_minimum(arr, sizeOfArray);
		    System.out.println(res);
		}
	}
}



// } Driver Code Ends


//User function Template for Java


class Solution{
    
   
    // Function for finding maximum and value pair
    public static int Pair_minimum (int arr[], int n) {
        //Complete the function
        Arrays.sort(arr);
        int res=0, low=0, high=arr.length-1;
        
        
        while(low<high){
            res=Math.max(arr[low]+arr[high], res);
            low++;
            high--;
        }
        return res;
    }
    
    
}



