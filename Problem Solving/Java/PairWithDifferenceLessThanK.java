/*
Given an array of N integers, the task is to find all pairs with a difference less than K.

Example 1:

Input : Arr[] = {1, 10, 4, 2}, K = 3
Output : 2
Explanation:
we have an array a[] = {1, 10, 4, 2} and 
K = 3 We can make only two pairs with a 
difference of less than 3.
(1, 2) and (4, 2). So, the answer is 2.

Example 2:

Input : Arr[] = {2, 3, 4}, K = 5
Output : 3

Your Task:
This is a function problem. The input is already taken care of by the driver code. You only need to complete the function countPairs() that takes an array (arr), sizeOfArray (n), the integer K, and return the number of pairs whose difference is less than K. The driver code takes care of the printing.

Expected Time Complexity: O(NLog(n)).
Expected Auxiliary Space: O(1).
 

Constraints:
2 ≤ N ≤ 105
0 ≤ K ≤ 104
1 ≤ A[i] ≤ 105
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
    
    

    public static int countPairs(int a[], int n, int k) 
    { 
        // Complete the function
        int res=0, i=1, j=0;
        
        Arrays.sort(a);
        
        while(i<n){
            while(a[i]-a[j]>=k)
                j++;
            if(a[i]-a[j]<k)
            //this takes care of all the elements b/w i-j range which can form pair
                res+=i-j;
            i++;
        }
        
        return res;
    } 
    
}



//{ Driver Code Starts.

// Driver class
class GFG {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    String l = br.readLine();
		    String[] v = l.trim().split("\\s+");
		    
		    int sizeOfArray = Integer.parseInt(v[0]);
		    int K = Integer.parseInt(v[1]);
		    
		    int arr [] = new int[sizeOfArray];
		    
		    String line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    
		    Solution obj = new Solution();
		    int res = obj.countPairs(arr, sizeOfArray, K);
		    System.out.println(res);
		}
	}
}


            


// } Driver Code Ends
