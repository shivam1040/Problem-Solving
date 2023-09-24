/*
Given a sorted integer array. We need to make array elements distinct by increasing values and keeping the array sum minimum possible. We need to print the minimum possible sum as output.

Note :- After increasing the values of the array , the sorted order should be maintained.

 

Example 1:

Input : arr[ ] = {2, 2, 3, 5, 6}
Output : 20
Explanation:
We make the array as {2, 3, 4, 5, 6}. 
Sum becomes 2 + 3 + 4 + 5 + 6 = 20

Example 2:

Input : arr[ ] = {20, 20} 
Output :  41


Your Task:
This is a function problem. The input is already taken care of by the driver code. You only need to complete the function minSum() that takes an array (arr), sizeOfArray (n), and return the minimum possible sum. The driver code takes care of the printing.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

 

Constraints:
2 ≤ N ≤ 105
1 ≤ A[i] ≤ 105
*/

//{ Driver Code Starts
//Initial Template for Java

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
		    long res = obj.minSum(arr, sizeOfArray);
		    System.out.println(res);
		}
	}
}





// } Driver Code Ends


//User function Template for Java


class Complete{
    
   
    // Function for finding maximum and value pair
    public static long minSum (int arr[], int n) {
        //Complete the function
        int sum=arr[0];
        
        for(int i=1; i<n; i++){
            if(arr[i]==arr[i-1])
                arr[i]+=1;
            if(arr[i]<arr[i-1])
                arr[i]=arr[i-1]+1;
            sum+=arr[i];
            
        }
        
        return sum;
    }
    
    
}



