/*
Given an array of N elements and a number K. The task is to arrange array elements according to the absolute difference with K, i. e., element having minimum difference comes first and so on.
Note : If two or more elements are at equal distance arrange them in same sequence as in the given array.
 

Example 1:

Input: N = 5, K = 7
arr[] = {10, 5, 3, 9, 2}
Output: 5 9 10 3 2
Explanation: Sorting the numbers accoding to 
the absolute difference with 7, we have 
array elements as 5, 9, 10, 3, 2.
Example 2:

Input: N = 5, K = 6
arr[] = {1, 2, 3, 4, 5}
Output: 5 4 3 2 1
Explanation: Sorting the numbers according to 
the absolute difference with 6, we have array 
elements as 5 4 3 2 1.

Your Task:
This is a functional problem. You only need to complete the function sortABS(). The printing is done automatically by the driver code.

Expected Time Complexity: O(N log(N) ).
Expected Auxiliary Space: O(N).

Constraints:
1 <= N <= 105
1 <= K <= 105
*/

//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG
{
    public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    String inputLine[] = br.readLine().trim().split(" ");
		    int n = Integer.parseInt(inputLine[0]);
		    int x = Integer.parseInt(inputLine[1]);
		    
		    int arr[] =  new int[n];
		    inputLine = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]);
		    }
		    new Solution().sortABS(arr,n, x);
		    StringBuilder sb = new StringBuilder();
		    for(int y : arr)
		        sb.append(y+ " ");
		    System.out.println(sb.toString());
		    
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to sort the array according to difference with given number.
    static void sortABS(int arr[], int n,int k)
    {
        // add your code here
        List<Integer> aux=new ArrayList<>();
        Sort obj=new Sort();
        obj.k=k;
        int j=0;
        
        for(int i:arr)
            aux.add(i);
        Collections.sort(aux, obj);
        for(int i:aux)
            arr[j++]=i;
    }
}

class Sort implements Comparator<Integer> {
 
    // Method
    // Sorting in ascending order of roll number
    Integer k;
    public int compare(Integer a, Integer b)
    {
 
        return Math.abs(a-k) - Math.abs(b-k);
    }
}

