/*
Given a positive integer X. The task is to find the smallest even number E such that
E > X and all digits in X and E are the same.

Note: All the digits in X should be same with digits in E.

 

Example 1:

Input:
X = 34722641
Output:
34724126
Explanation:
Next greater number with same 
digits as in input is 34724126.

Example 2:

Input:
X = 111
Output:
-1
Explanation:
You can't rearrange the digits to get an answer.
 

Your Task:  
You don't need to read input or print anything. Your task is to complete the function getNextEven() which takes a string X as input, which is representing the number and returns the required smallest even number. If no such even number exists return -1.

Expected Time Complexity: O(Log(N)! )
Expected Auxiliary Space: O(Log(N))

Constraints:
1 ≤ N ≤ 109
*/

//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            String str = br.readLine();
            
            Solution obj = new Solution();
            System.out.println(obj.getNextEven(str));
            
        }
	}
}



// } Driver Code Ends


//User function Template for Java

class Solution {
    
    public long getNextEven(String x)
    {
        // Your code goes here   
        int temp[]=new int[x.length()];
        
        for(int i=0; i<x.length(); i++)
            temp[i]=Integer.parseInt(x.charAt(i)+"");
        
        //find next permutation of this number and check if it is even
        while(findNextPermutation(temp)){
            if(temp[x.length()-1]%2==0){
                 long numberConverted = 0;
  for (int number : temp) {
   numberConverted = 10*numberConverted + number;
  }
                return numberConverted;
            }
        }
        return -1;
    }
    
       public static int[] swap(int data[], int left, int right)
    {
 
        // Swap the data
        int temp = data[left];
        data[left] = data[right];
        data[right] = temp;
 
        // Return the updated array
        return data;
    }
 
    // Function to reverse the sub-array
    // starting from left to the right
    // both inclusive
    public static int[] reverse(int data[], int left, int right)
    {
 
        // Reverse the sub-array
        while (left < right) {
            int temp = data[left];
            data[left++] = data[right];
            data[right--] = temp;
        }
 
        // Return the updated array
        return data;
    }
 
    // Function to find the next permutation
    // of the given integer array
    public static boolean findNextPermutation(int data[])
    {
 
        // If the given dataset is empty
        // or contains only one element
        // next_permutation is not possible
        if (data.length <= 1)
            return false;
 
        int last = data.length - 2;
 
        // find the longest non-increasing suffix
        // and find the pivot
        while (last >= 0) {
            if (data[last] < data[last + 1]) {
                break;
            }
            last--;
        }
 
        // If there is no increasing pair
        // there is no higher order permutation
        if (last < 0)
            return false;
 
        int nextGreater = data.length - 1;
 
        // Find the rightmost successor to the pivot
        for (int i = data.length - 1; i > last; i--) {
            if (data[i] > data[last]) {
                nextGreater = i;
                break;
            }
        }
 
        // Swap the successor and the pivot
        data = swap(data, nextGreater, last);
 
        // Reverse the suffix
        data = reverse(data, last + 1, data.length - 1);
 
        // Return true as the next_permutation is done
        return true;
    }
}
