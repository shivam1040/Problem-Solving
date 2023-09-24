/*
Given an array of size N that has elements ranging from 0 to N-1. All elements may not be present in the array. If the element is not present then there will be -1 present in the array. Rearrange the array such that A[i] = i, and if i is not present, display -1 at that place.

Example 1:

â€‹Input : arr[ ] = {-1, -1, 6, 1, 9, 3, 2, 
                              -1, 4, -1}
Output : -1 1 2 3 4 -1 6 -1 -1 9
Explanation:
In range 0 to 9, all except 0, 5, 7 and 8 
are present. Hence, we print -1 instead of 
them.

Example 2:

Input : arr[ ] = {0, 1, 2, 3, 4, 5} 
Output : 0 1 2 3 4 5
Your Task:

This is a function problem. The input is already taken care of by the driver code. You only need to complete the function modifyArray() that takes an array (arr), sizeOfArray (n), and return the modified array. The driver code takes care of the printing.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

 

Constraints:
1 ≤ N ≤ 105
0 ≤ A[i] ≤ N-1


*/

//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;


class GFG {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    int sizeOfArray = Integer.parseInt(br.readLine());
		    int arr [] = new int[sizeOfArray];
		    
		    String line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    
		    Solution obj = new Solution();
		    arr = obj.modifyArray(arr, sizeOfArray);
		    for(int i=0; i< sizeOfArray;i++){
		        System.out.print(arr[i] + " ");
		    }
		    System.out.println();
		}
	}
}



// } Driver Code Ends


//User function Template for Java

class Solution{
    // Function for finding maximum and value pair
    public static int[] modifyArray (int arr[], int n) {
        // Complete the function
    
        Set<Integer> aux=new HashSet<>();
        
        for(int i:arr)
            aux.add(i);
        
        for(int i=0; i<n; i++)
            if(aux.contains(i))
                arr[i]=i;
            else
                arr[i]=-1;
        
        return arr;
        
    }
}



