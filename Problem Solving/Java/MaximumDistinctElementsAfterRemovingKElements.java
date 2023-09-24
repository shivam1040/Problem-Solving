/*
Given an array containing N elements. The task is to find the maximum number of distinct elements after removing K elements from the array.

Example 1:

Input : Arr[] = {5, 7, 5, 5, 1, 2, 2}, K = 3
Output : 4
Explanation:
Remove 2 occurrences of element 5 and 
1 occurrence of element 2.

Example 2:

Input : Arr[] = {1, 2, 3, 4, 5, 6, 7}, K = 5
Output : 2

Your Task:
This is a function problem. The input is already taken care of by the driver code. You only need to complete the function maxDistinctNum() that takes an array (arr), sizeOfArray (n), integer value K, and return the maximum distinct elements after removing K elements. The driver code takes care of the printing.

Expected Time Complexity: O(K*logD)  where D is the number of distinct elements in the given array.
Expected Auxiliary Space: O(N).
 

Constraints:
1 ≤ K ≤ N ≤ 106
1 ≤ A[i] ≤ 105
*/

/*
Approach: Following are the steps: 

Make a multi set from the given array.
During making this multiset check if the current element is present or not in multiset, if it is already present then simply reduce the k value and do not insert in the multiset.
If k becomes 0 then simply just put values in multiset.
After traversing the whole given array, 
If k is not equal to zero then it means the multiset is consist of only unique elements and we have to remove any of the k elements from the multiset to make k=0, so in this case the answer will be size of multiset minus k value at that time.
If k is equal to zero then it means there may be duplicate values present in the multiset so put all the values in a set and the size of this set will be the number of distinct elements after removing k elements
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
    
  
    int maxDistinctNum(int a[], int n, int k)
    {
        // Complete the function
        Set<Integer> aux=new HashSet<>();
        
        //Arrays.sort(a);
        
        for(int i:a)
            if(aux.contains(i) && k>0)
                k--;
            else
                aux.add(i);
        
        if(k>0)
            return aux.size()-k;
        return aux.size();
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
		    int res = obj.maxDistinctNum(arr, sizeOfArray, K);
		    System.out.println(res);
		}
	}
}


            

// } Driver Code Ends
