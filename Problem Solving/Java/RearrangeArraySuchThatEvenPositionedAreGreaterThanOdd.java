/*
Given an array A of n elements, rearrange the array according to the following relations :
 A[i] >= A[i-1]  , if i is even.
 A[i] <= A[i-1]  , if i is odd.[Considering 1-indexed array]
Return the resultant array.

Example:

Input 1:
A[] = {1, 2, 2, 1}
Output:
1 2 1 2
Explanation:
Both 2 are at even positions and 1 at odd satisfying 
given condition 

Input 2:
A[] = {1, 3, 2}
Output:
1 3 2
Explanation:
Here, the array is already sorted as per the conditions.
 

Your Task:
This is a function problem. The input is already taken care of by the driver code. You only need to complete the function assign() that takes an array (arr), sizeOfArray (n), and return the resultant array.
Note: Generated output will depict whether your returned answer is correct or wrong

Expected Time Complexity: O(NLOG(N)).
Expected Auxiliary Space: O(1).


Constraints:

1 ≤ N ≤ 105
1 ≤ arr[i] ≤ 106
*/

/*
One other approach is to traverse the array from the second element and swap the element with the previous one if the condition is not satisfied. This is implemented as follows: 
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
    
    ArrayList<Integer> assign(int arr[], int n)
    {
        // Complete the function
        ArrayList<Integer> res=new ArrayList<>();
        
          for (int i = 1; i < n; i++) {
 
            // if index is even
            if (i % 2 == 0) {
                if (arr[i] > arr[i - 1]) {
 
                    // swap two elements
                    int temp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = temp;
                }
            }
 
            // if index is odd
            else {
                if (arr[i] < arr[i - 1]) {
 
                    // swap two elements
                    int temp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = temp;
                }
            }
        }
        
        for(int i:arr)
            res.add(i);
        
        return res;
    }
  
    
}


//{ Driver Code Starts.

// Driver class
class GFG {
    //method to check for the correct answer
    public static boolean checkOrder(ArrayList<Integer> res){
	    for(int i = 1; i < res.size(); i++){
	        if(i%2 != 0){
	            if(res.get(i) < res.get(i-1))
	            {
	                return false;
	            }
	        }
	        else{
	            if(res.get(i) > res.get(i-1)){
	                return false;
	            }
	        }
	    }
	    return true;
	}
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
		    ArrayList<Integer> res = new ArrayList<Integer>();
		    res = obj.assign(arr, sizeOfArray);
		    
		    boolean check_ans = checkOrder(res);
		    if(check_ans)
	            System.out.println("Correct");
	        else 
	            System.out.println("Wrong Answer");
		}
	}
}


            

// } Driver Code Ends
