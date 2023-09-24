/*
You are given N ropes. A cut operation is performed on ropes such that all of them are reduced by the length of the smallest rope. Display the number of ropes left after every cut operation until the length of each rope is zero.

Example 1:

Input : arr[ ] = {5, 1, 1, 2, 3, 5} 
Output : 4 3 2 
Explanation: In the first operation, the 
minimum ropes are 1 So, we reduce length 1 
from all of them after reducing we left with 
4 ropes and we do the same for rest. 
 

Example 2:

Input : arr[ ] = {5, 1, 6, 9, 8, 11, 2, 
                               2, 6, 5} 
Output :  9 7 5 3 2 1


Your Task:
This is a function problem. The input is already taken care of by the driver code. You only need to complete the function RopeCutting() that takes an array (arr), sizeOfArray (n), and return the number of ropes that are left after each operation with space if no ropes left after one operation, in this case, return 0. The driver code takes care of the printing.

Expected Time Complexity: O(N*LOG(N)).
Expected Auxiliary Space: O(1).

 

Constraints:

1 ≤ N ≤ 105
*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class Solution{
    
    // Function for finding maximum and value pair
    public static ArrayList<Integer> RopeCutting (int arr[], int n) {
        // Complete the Function
        Arrays.sort(arr);
        
        int cut=arr[0];
        ArrayList<Integer> res=new ArrayList<>();
        
        for(int i=1; i<arr.length; i++){
            if(arr[i]-cut>0){
                res.add(n-i);
                cut=arr[i];
            }
        }
        return res;
    }
}



//{ Driver Code Starts.
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
		        arr[i] =  Integer.parseInt(elements[i]);
		    }
		    
		    
		    Solution obj = new Solution();
		    ArrayList<Integer> res;
		    res = obj.RopeCutting(arr, sizeOfArray);
		    for(int i: res)
		        System.out.print(i + " ");
		    System.out.println();
		}
	}
}


            


// } Driver Code Ends
