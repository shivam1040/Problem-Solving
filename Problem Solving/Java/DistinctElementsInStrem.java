/*
Given an input stream of N integers (alongwith the operation on these integers), the task is to print the number of the distinct elements in the stream after each operation.
The array is will be having positive and negative values. Positive value meaning you have to append it into your database and Negative value means you have to remove it from your database if present and at every step you have to count the number of distinct character in your database.

Example 1:
Input: A[] = {5, 5, 7, -5, -7, 1, 2, -2}
Output: 1 1 2 2 1 2 3 2
Explanation:
Here you can see we have an array of integer as 
stated that positive number means we will adding 
it to our database and negative means we will be 
deleting one occurence of that number from our database.
So, [5, 5, 7, -5, -7, 1, 2, -2] 
Add 5, Unique Value in Data Base is 1 -> [5]
Add 5, Unique Value in Data Base is 1 -> [5, 5]
Add 7, Unique Value in Data Base is 2 -> [5, 5, 7]
Removing 5, Unique Value in Data Base is 2 -> [5, 7]
Removing 7, Unique Value in Data Base is 1 -> [5]
Add 1, Unique Value in Data Base is 2 -> [5, 1]
Add 2, Unique Value in Data Base is 3 -> [5, 1, 2]
Removing 2, Unique Value in Data Base is 2 -> [5, 1]
Your Task:
This is a function problem. The input is already taken care of by the driver code. You only need to complete the function maxDistinctNum() that takes an array (arr), sizeOfArray (n), and return the number of unique value at every instance. The driver code takes care of the printing.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).
 

Input:
First line of the input contains an integer T denoting the number of test cases. Then T test case follows. First line of each test case contains an integer N denoting the number of operations to be performed on a stream. Next N lines two space separated elements, the operation to be performed and the key element.

Constraints:
1 ≤ N ≤ 106
-106 ≤ A[] ≤ 106


*/

//{ Driver Code Start
//Initial Template for Java

//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java


//Back-end complete function Template for Java

class Solution{
    
  
    ArrayList<Integer> maxDistinctNum(int arr[], int n)
    {
        // Complete the function
        Map<Integer, Integer> aux=new HashMap<>();
        ArrayList<Integer> res=new ArrayList<>();
        
        for(int i:arr){
            if(i>0)
                aux.put(i, aux.getOrDefault(i, 0)+1);
            else if(i<0){
                int temp=Math.abs(i);
                
                if(aux.containsKey(temp)){
                    if(aux.get(temp)==1)
                        aux.remove(temp);
                    else
                        aux.put(temp, aux.get(temp)-1);
                }
            }
            res.add(aux.size());
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
		    int sizeOfArray = Integer.parseInt(br.readLine());
		    int arr [] = new int[sizeOfArray];
		    
		    String line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    
		    Solution obj = new Solution();
		    ArrayList<Integer> res = new ArrayList<Integer>();
		    res = obj.maxDistinctNum(arr, sizeOfArray);
		    for(int i:res)
		        System.out.print(i + " ");
		    System.out.println();
		}
	}
}


            

// } Driver Code Ends
