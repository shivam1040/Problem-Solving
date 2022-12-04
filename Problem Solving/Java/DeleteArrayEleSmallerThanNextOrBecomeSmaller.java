/*
Given an array arr[] and a number k. The task is to delete k elements which are smaller than next element (i.e., we delete arr[i] if arr[i] < arr[i+1]) or become smaller than next because next element is deleted.

Example 1:

â€‹Input : arr[ ] = {20, 10, 25, 30, 40} 
        and K = 2
Output : 25 30 40
Explanation:
First we delete 10 because it follows 
arr[i] < arr[i+1]. Then we delete 20 
because 25 is moved next to it and it 
also starts following the condition.

â€‹Example 2:

Input : arr[ ] = {3, 100, 1} and K = 1
Output :  100 1 
 

Your Task:
This is a function problem. The input is already taken care of by the driver code. You only need to complete the function deleteElement() that takes an array (arr), sizeOfArray (n), an integer K and return the array arr[] after deleting the k elements from the array if possible, else print the left array as it is. The driver code takes care of the printing.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

 

Constraints:
2 ≤ N ≤ 105
1 ≤ K < N 
*/

/*
Stack is used to solving this problem. First we push arr[0] in stack S and then initialize count as 0, then after traverse a loop from 1 to n and then we check that s.top() < arr[i] if condition is true then we pop the element from stack and increase the count if count == k then we stop the loop and then store the value of stack in another array and then print that array
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
		    int arr [] = new int[N];
		    line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    for(int i = 0;i<N;i++){
	            arr[i] = Integer.parseInt(elements[i]);    
	        }
		    int K = Integer.parseInt(br.readLine());
		    
		    Complete obj = new Complete();
		    ArrayList<Integer> ans;
		    ans = obj.deleteElement(arr, N, K);
        	for(int i: ans)
        	    System.out.print(i + " ");
        	System.out.println();
		}
	}
}



// } Driver Code Ends


//User function Template for Java

class Complete{
    
   
    // Function for finding maximum and value pair
    public static ArrayList<Integer> deleteElement (int arr[], int n, int k) {
        //Complete the function
        Stack<Integer> aux=new Stack<>();
        ArrayList<Integer> res=new ArrayList<>();
        int count=0;
        
        aux.push(arr[0]);
        for(int i=1; i<n; i++){
            while(!aux.isEmpty() && aux.peek()<arr[i] && count<k){
                aux.pop();
                count++;
            }
            aux.push(arr[i]);
        }
        while(!aux.isEmpty()){
            res.add(0, aux.pop());
        }
        return res;
    }
    
    
}
