/*
Ishaan is trapped in a city full of walls. To escape from there, it needs to climb N walls, one after the other. He can climb a wall if its height is atmost K.
Ishaan also has a superpower. He can reduce the height of a wall H by K by using his superpower. Since he can't use this power many times, calculate the minimum number of times he has to use this power to go over all the walls.

Example 1:

â€‹Input : arr[ ] = {5, 3, 2, 6, 8} and K = 5
Output : 2
Explanation:
Heights : 5 3 2 6 8 Ishaan can climb a 
wall with height atmost 5. So he climbs 
the first 3 walls easily. Now he has to 
use his power to reduce the height of the 
4th wall. After using his power, heights 
: 5 3 2 1 8, Now to climb the last wall, 
he again uses his power. Final heights 
: 5 3 2 1 3

â€‹Example 2:

Input : arr[ ] = {2, 6, 4, 8, 1, 6} and K = 4 
Output :  3 
 

Your Task:
This is a function problem. The input is already taken care of by the driver code. You only need to complete the function ReducingWalls() that takes an array (arr), sizeOfArray (n), an integer K and return the minimum number of times he has to use this power to go over all the walls The driver code takes care of the printing.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

 

Constraints :
1 ≤ N ≤ 105
1 ≤ K ≤ 105
1 ≤ Arr[i] ≤ 109
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
		    int K = Integer.parseInt(element[1]);
		    int arr [] = new int[N];
		    line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    for(int i = 0;i<N;i++){
	            arr[i] = Integer.parseInt(elements[i]);    
	        }
		    
		    Complete obj = new Complete();
		    int ans = obj.ReducingWalls(arr, N, K);
        	System.out.println(ans);
		}
	}
}



// } Driver Code Ends


//User function Template for Java

class Complete{
    
   
    // Function for finding maximum and value pair
    public static int ReducingWalls (int arr[], int n, int k) {
        //Complete the function
        int count=0;
        
        for(int i:arr)
            if(i>k)
                count+=(i-1)/k;
        
        return count;
    }
    
}

