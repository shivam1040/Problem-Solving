/*
Given an array arr[], count number of pairs arr[i], arr[j] such that arr[i] + arr[j] is maximum and i < j.

Example 1:

Input : Arr[] = {1, 1, 1, 2, 2, 2}
Output : 3
Explanation:
We have an array [1, 1, 1, 2, 2, 2]
The maximum possible pair
sum where i is less than j is  4, which 
is given by 3 pairs, so the answer is 3
the pairs are (2, 2), (2, 2) and (2, 2).

Example 2:

Input : Arr[] = {1, 4, 3, 3, 5, 1}
Output : 1
 

Your Task:
This is a function problem. The input is already taken care of by the driver code. You only need to complete the function MaximumSum() that takes an array (arr), sizeOfArray (n), and return the number of pairs whose sum is maximum. The driver code takes care of the printing.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).


CONSTRAINTS:
1 ≤ a[i], n ≤ 105
*/

/*
If we take a closer look, we can notice following facts. 

Maximum element is always part of solution
If maximum element appears more than once, then result is maxCount * (maxCount – 1)/2. We basically need to choose 2 elements from maxCount (maxCountC2).
If maximum element appears once, then result is equal to count of second maximum element. We can form a pair with every second max and max
*/

//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class GFG {
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		while(testcases-- > 0){
		    
		    String line1 = br.readLine();
		    String []element = line1.trim().split(" ");
		    int n = Integer.parseInt(element[0]);
		    int arr[] = new int[n];
		    
		    String line = br.readLine();
		    String[] elements = line.trim().split(" ");
		    
		    for(int index = 0;index < n; index++){
		        arr[index] = Integer.parseInt(elements[index]);
		    }
		    
		    Solution obj = new Solution();
		    
		    System.out.println(obj.MaximumSum(arr, n));
		        
		}
		
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution{
    
    static int MaximumSum(int a[], int n) 
    { 
        // Complete the function
        int max1=-1, max2=-1, count1=0, count2=0;
        
        for(int i: a)
            if(i>max1)
                max1=i;
        for(int i: a)
            if(i>max2 && i<max1)
                max2=i;
        for(int i: a)
            if(i==max1)
                count1++;
            else if(i==max2)
                count2++;
//just in case max1 count is 1 then every occurence of max2 can form a pair with max1 which is count2 in that case        
        return count1>1 ? (count1 * (count1-1))/2 : count2;
    }
    
}


