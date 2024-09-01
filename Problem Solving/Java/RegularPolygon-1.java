/*
Given an array of binary integers, suppose these values are kept on the circumference of a circle at an equal distance. The task is to tell whether is it possible to draw a regular polygon using only 1s as its vertices or not.
If yes then print 1 else -1.

 

Example 1:

Input:
N=6
arr[] = { 1, 1, 1, 0, 1, 0 }
Output:  1
Explanation: 
Using 1's at 1st, 3rd and 5th index
we can make a triangle.
 

Example 2:

Input:
N=10
arr[] = { 1, 0, 1, 0, 1, 0, 1, 0, 1, 1 }
Output:  1

Your Task:
Since, this is a function problem. You don't need to take any input, as it is already accomplished by the driver code. You just need to complete the function isPolygonPossible() that takes array arr and integer N as parameters and returns 1 if it is possible to make a regular polygon else -1.
 

Expected Time Complexity: O(N5/2).
Expected Auxiliary Space: O(1).

Constraints:
1 ≤ N ≤ 50
*/

//{ Driver Code Starts
//Initial Template for Java



import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class Solution
{ 
     static int isPolygonPossible(int arr[], int n) 
    { 
        if(n<3)
            return -1;
        for(int edge=1; edge<=n/3; edge++)
            for(int st=0; st<n; st++)
                if(arr[st]==1){
                    int i=st;
                    
                    while(i<st+n){
                        if(arr[i%n]!=1)
                            break;
                        i+=edge;
                    }
                    if(i==st+n)
                        return 1;
                }
        return -1;
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
		    int sizeOfArray = Integer.parseInt(br.readLine());
		    
		    int arr[] = new int[sizeOfArray];
		    
		    String line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    
		    for(int index = 0;index < sizeOfArray; index++){
		        arr[index] = Integer.parseInt(elements[index]);
		    }
		    
		    Solution ob = new Solution();
		    System.out.println(ob.isPolygonPossible(arr,sizeOfArray));
		}
	}
}
// } Driver Code Ends
