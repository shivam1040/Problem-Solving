/*
Given an array, the task is to print K smallest elements from the array but they must be in the same order as they are in a given array.

Example 1:
 

Input : A[] = {1, 2, 2, 3, 1} and K = 2
Output : 1 1
Explanation:
In an array A[] = {1, 2, 2, 3, 1} the smallest
element is 1 and the second smallest element 
is also 1. So, we will return [1, 1] as an 
answer.
Example 2:

Input : A[] = {1, 4, 3, 3, 5, 5} and K = 2
Output : 1 3
 

Your Task:
This is a function problem. The input is already taken care of by the driver code. You only need to complete the function kSmallestElements() that takes an array (arr), sizeOfArray (n), element (K) and return the array of K smallest element. The driver code takes care of the printing.

Expected Time Complexity: O(N*LOG(N)).
Expected Auxiliary Space: O(N).

 

Constraints:
1 ≤ K ≤ N ≤ 106
1 ≤ A[i] ≤ 105
*/

//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java

//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


// } Driver Code Ends

//User function Template for Java


class Solution{
    
  
    ArrayList<Integer> kSmallestElements(int arr[], int n, int k)
    {
        // Complete the function
        int copy[]=Arrays.copyOf(arr, n);
        ArrayList<Integer> res=new ArrayList<>();
        Map<Integer, Integer> aux=new HashMap<>();
        
        Arrays.sort(copy);
        for(int i=0; i<k; i++)
            aux.put(copy[i], aux.getOrDefault(copy[i], 0)+1);
        for(int i=0; i<n; i++){
            if(aux.containsKey(arr[i])){
                res.add(arr[i]);
                if(aux.get(arr[i])==1)
                    aux.remove(arr[i]);
                else
                    aux.put(arr[i], aux.get(arr[i])-1);
            }
        }
        
        return res;
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
		    
		    String line1 = br.readLine();
		    String[] element = line1.trim().split("\\s+");
		    int sizeOfArray = Integer.parseInt(element[0]);
		    int K = Integer.parseInt(element[1]);
		    
		    int arr [] = new int[sizeOfArray];
		    
		    String line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    
		    Solution obj = new Solution();
		    ArrayList<Integer> res = new ArrayList<Integer>();
		    res = obj.kSmallestElements(arr, sizeOfArray, K);
		    for(int i:res)
		        System.out.print(i + " ");
		    System.out.println();
		    
		    
		}
	}
}


            

// } Driver Code Ends
