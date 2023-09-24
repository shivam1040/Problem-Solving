/*
N light bulbs are connected by a wire. Each bulb has a switch associated with it, however due to faulty wiring, a switch also changes the state of all the bulbs to the right of current bulb. Given an initial state of all bulbs, find the minimum number of switches you have to press to turn on all the bulbs. "0 represents the bulb is off and 1 represents the bulb is on."
 

Example 1:

Input:
N=4
arr[] = { 0, 0, 0, 0 }
Output:  1
Explanation: 
From the given set of bulbs change
the state of the first bulb from off
to on ,which eventually turn the rest
three bulbs on the right of it.

Example 2:

Input:
N=4
arr[] = { 1, 0, 0, 1 }
Output:  2

Your Task:
Since, this is a function problem. You don't need to take any input, as it is already accomplished by the driver code. You just need to complete the function countFlips() that takes array A and integer N as parameters and returns the minimum number of press required to turn on all the bulbs.


Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).
 

Constraints:
1 ≤ N ≤ 106


*/

//{ Driver Code Starts
//Initial Template for Java



import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class Solution
{
    public static int countFlips(int a[], int n)
    {
        //code here.
        //the basic idea is to count 0 only for odd positions and count even only for even positions to balance out the on off steps
        int count=0;
        boolean flag=false;
        
        for(int i:a)
            if(!flag && i==0){
                count++;
                flag=true;
            }
            else if(i==1 & flag){
                count++;
                flag=false;
            }
        return count;
    }
}

//{ Driver Code Starts.

// Driver class
class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine().trim());
		
		// looping through all testcases
		while(testcases-- > 0){
		    int sizeOfArray = Integer.parseInt(br.readLine().trim());
		    
		    int arr[] = new int[sizeOfArray];
		    
		    String line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    
		    for(int index = 0;index < sizeOfArray; index++){
		        arr[index] = Integer.parseInt(elements[index]);
		    }
		    
		    Solution ob = new Solution();
		    System.out.println(ob.countFlips(arr,sizeOfArray));
		}
	}
}


// } Driver Code Ends
