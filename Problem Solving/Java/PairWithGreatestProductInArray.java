/*
Given an array A of N elements. The task is to find the greatest number S such that it is product of two elements of given array (S cannot be included in pair. Also, pair must be from different indices).

Example 1:

Input :  arr[] = {10, 3, 5, 30, 35}
Output:  30
Explanation: 30 is the product of 10 and 3.

Example 2:
Input :  arr[] = {2, 5, 7, 8}
Output:  -1
Explanation: Since, no such element exists.

Example 3:
Input  :  arr[] = {10, 2, 4, 30, 35}
Output:  -1
 
Example 4:
Input :  arr[] = {10, 2, 2, 4, 30, 35}
Output:  4

Example 5:
Input  : arr[] = {17, 2, 1, 35, 30}
Output : 35

Your Task:  
You don't need to read input or print anything. Your task is to complete the function findGreatest() which takes the array arr[] and its size N as inputs and returns the answer. If the answer is not present in the array, return -1.

Expected Time Complexity: O(N. Log(N))
Expected Auxiliary Space: O(N)

Constraints:
1 ≤ N ≤ 106
1 ≤ Ai ≤ 107
*/

//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.findGreatest(a, n));
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java


class Solution {
    
    public static int findGreatest(int arr[], int n)
    {
        // Your code goes here   
        Arrays.sort(arr);
        
        Map<Integer, Integer> aux=new HashMap<>();
        
        for(int i:arr)
            aux.put(i, aux.getOrDefault(i, 0)+1);
        
        for(int i=n-1; i>1; i--){
            for(int j=0; j<i && arr[j]<=Math.sqrt(arr[i]); j++){
                if(arr[i]%arr[j]==0){
                    int re=arr[i]/arr[j];
                    if(re!=arr[j] && aux.containsKey(re)){
                        if (re == arr[i]) {
                            if (aux.get(arr[i]) > 1)
                                return arr[i];
                        }
                        else
                            return arr[i];
                    }
                    else if(re==arr[j] && aux.get(re)>1)
                    return arr[i];
                }
            }
        }
        
        return -1;
    }
}
