/*
Given an array arr[ ] of size N having elements, the task is to find the next greater element for each element of the array in order of their appearance in the array.
Next greater element of an element in the array is the nearest element on the right which is greater than the current element.
If there does not exist next greater of current element, then next greater element for current element is -1. For example, next greater of the last element is always -1.

Example 1:

Input: 
N = 4, arr[] = [1 3 2 4]
Output:
3 4 4 -1
Explanation:
In the array, the next larger element 
to 1 is 3 , 3 is 4 , 2 is 4 and for 4 ? 
since it doesn't exist, it is -1.
Example 2:

Input: 
N = 5, arr[] [6 8 0 1 3]
Output:
8 -1 1 3 -1
Explanation:
In the array, the next larger element to 
6 is 8, for 8 there is no larger elements 
hence it is -1, for 0 it is 1 , for 1 it 
is 3 and then for 3 there is no larger 
element on right and hence -1.
Your Task:
This is a function problem. You only need to complete the function nextLargerElement() that takes list of integers arr[ ] and N as input parameters and returns list of integers of length N denoting the next greater elements for all the corresponding elements in the input array.

Expected Time Complexity : O(N)
Expected Auxiliary Space : O(N)

Constraints:
1 ≤ N ≤ 106
0 ≤ Ai ≤ 1018
*/

/*
Intuition
The idea is to traverse the array from right to left and use stack to keep track of next greater element in right.

Implementation
Initialize a empty stack s and vector res of size n.
Run a loop from end to start i.e. n-1 to 0 (Right to Left and i-based).
In each iteration of loop:
While element at top of stack is less than or equal to current array element, we pop elements from the stack. 
This operation will ensure that :
Either the stack will be empty(no element greater than current element exists in right side of current element).
The element at top of stack will be greater than current element and closest to the current element in right.
If s is empty then res[i] will be -1 Else it will be top of stack s.
Push current element in stack s.
Return res vector as answer.
*/

//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    int n = Integer.parseInt(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    long[] res = new Solution().nextLargerElement(arr, n);
		    for (int i = 0; i < n; i++) 
		        System.out.print(res[i] + " ");
		    System.out.println();
		}
	}
}




// } Driver Code Ends


class Solution
{
    //Function to find the next greater element for each element of the array.
    public static long[] nextLargerElement(long[] arr, int n)
    { 
        // Your code here
        Stack<Long> aux=new Stack<>();
        long res[]=new long[n];
        res[n-1]=-1;
        
        aux.push(arr[n-1]);
        
        for(int i=n-2; i>=0; i--){
            while(!aux.isEmpty() && aux.peek()<=arr[i])
                aux.pop();
            res[i]=aux.empty() ? -1 : aux.peek();
            
            aux.push(arr[i]);
        }
        return res;
    } 
}
