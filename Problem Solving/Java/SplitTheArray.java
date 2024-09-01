/*
Given an array A of n integers, the task is to count the number of ways to split given array elements into two disjoint groups such that XOR of elements of each group is equal.
Note: The answer could be very large so print it by doing modulos with 109 + 7. 

Example 1:

Input : a[] = {1, 2, 3}
Output : 3
Explanation:
{(1),(2, 3)},{(2),(1, 3)},{(3),(1, 2)}
are three ways with equal XOR
value of two groups.

Example 2:

Input : a[] = {5, 2, 3, 2}
Output : 0

Your Task:
The input is already taken care of by the driver code. You only need to complete the function countgroup() that takes an array (a), sizeOfArray (n), and return the number of ways to split an array. The driver code takes care of the printing.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Constraints:

1<=N<=105
1<=a<=108
*/

/*
Let’s denote XOR between all elements in the first group as G1 and XOR between all elements in the second group as G2. Now, the following relation is always correct: G1 ⊕ G2 = A1 ⊕ A2 ⊕ …. ⊕ An. 
So for G1 = G2, xor between all elements of array A is equal to 0. So, in that case, answer will be (2n – 2)/2 = (2n-1 – 1). In second case, when XOR between all elements isn’t 0, we can not split array. Answer will be 0.
*/

//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class Solution{
    
    
    public static int countgroup(int a[], int n) 
    { 
        // Complete the function
        int temp=0;
        
        for(int i:a)
            temp^=i;
        return temp==0 ? (1<<(n-1))-1 : 0;
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
		    
		    int arr [] = new int[sizeOfArray];
		    
		    String line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    
		    Solution obj = new Solution();
		    int res = obj.countgroup(arr, sizeOfArray);
		    System.out.println(res);
		}
	}
}


            


// } Driver Code Ends
