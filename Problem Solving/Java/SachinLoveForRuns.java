/*
Sachin always wanted to score more and more runs for his team. Sometimes he succeeds in doing that and sometimes he fails. He also has a habit of noting down the runs he scored after every match in his diary. After N  matches he always looks for his scores. In i-th match, he scores A[i] runs. Now he wanted to know the length of the maximum non-decreasing sub-segment in sequence A. As he wants to go for another match, help him in doing this task.

Example 1:

Input:                  
N = 6                       
A[] = {2, 2, 1, 3, 4, 1}
Output:
3
Explanation:
The maximum non-decreasing sub-segment is
the segment with numbers from the third to
the fifth one.

Example 2:

Input:
N = 3
A[] = {2, 2, 9}
Output:
3
Explanation:
The maximum non-decreasing sub-segment
is the numbers from the first to the third one.
 

Your Task:  
You don't need to read input or print anything. Your task is to complete the function compute() which takes the array A[] and its size N as inputs and returns the length of the maximum non-decreasing sub-segment.

 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ N ≤105
1 ≤ A[i] ≤ 109
*/

//{ Driver Code Starts
/*package whatever //do not write package name here */

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
            long a[] = new long[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            
            Solution obj = new Solution();

            System.out.println(obj.compute(a, n));
            
        }
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution {

    public static int compute(long arr[], int n) {
        // write your code here
        int max=1, len=1;
        
        for(int i=1; i<n; i++){
            //non-decreasing so can be same as before
            if(arr[i]>=arr[i-1])
                len++;
            else if(len>max){
                max=len;
                len=1;
            }
            else
                len=1;
        }
           if(max<len)
            return len;
        return max;
    }
}
