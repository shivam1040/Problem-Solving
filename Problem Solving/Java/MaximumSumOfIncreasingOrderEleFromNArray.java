/*
Given n arrays of size m each. Find maximum sum obtained by selecting a number from each array such that the element selected from the i-th array is more than the element selected from (i-1)-th array. If maximum sum cannot be obtained then return 0.

Example 1:

â€‹Input : arr[ ] = {{1,7,4,3}, {4,2,5,1}, {9,5,1,8}}
Output : 18
Explanation:
We can select 4 from the first array,
5 from second array and 9 from the third array.

â€‹Example 2:

Input : arr[ ] = {{9,8,7}, {6,5,4}, {3,2,1}} 
Output :  0

Your Task:
This is a function problem. The input is already taken care of by the driver code. You only need to complete the function maximumSum() that takes number of row N, a number of Column M, 2-d array (arr), and return the maximum sum if cannot be obtained then return 0. The driver code takes care of the printing.

Expected Time Complexity: O(N*M).
Expected Auxiliary Space: O(1).

 

Constraints:
1 ≤ N, M ≤ 500
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
		    int M = Integer.parseInt(element[1]);
		    int arr [][] = new int[N][M];
		    
		    for(int i = 0;i<N;i++){
		        line = br.readLine();
		        String[] elements = line.trim().split("\\s+");
		        for(int j = 0; j< M; j++){
		            arr[i][j] = Integer.parseInt(elements[j]);    
		        }
		    }
		    
		    Complete obj = new Complete();
		    int ans = obj.maximumSum(N, M, arr);
		    System.out.println(ans);
		}
	}
}


// } Driver Code Ends


//User function Template for Java


class Complete{
    
   
    // Function for finding maximum and value pair
    public static int maximumSum (int n, int m, int arr[][]) {
        //Complete the function
         //m=4;
        int prevMax=Integer.MIN_VALUE;
        for(int i=n-1; i<n; i++){
            for(int j=0; j<m; j++){
                if(arr[i][j]>prevMax)
                    prevMax=arr[i][j];
            }
        }
        int maxSum=prevMax;
        
        for(int i=n-2; i>=0; i--){
            int max=Integer.MIN_VALUE;
            for(int j=m-1; j>=0; j--){
                if(arr[i][j]<prevMax && arr[i][j]>max){
                   max=arr[i][j];
                }
            }
            if(max==Integer.MIN_VALUE)
                return 0;
            prevMax=max;
            maxSum+=max;
        }
        return maxSum;
    }
    
    
}






