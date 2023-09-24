/*
Given a array a[] of non-negative integers. Count the number of pairs (i, j) in the array such that a[i] + a[j] < a[i]*a[j]. (the pair (i, j) and (j, i) are considered same and i should not be equal to j)


Example 1:

Input:
N=3
arr[] = {3, 4, 5} 
Output: 3
Explanation: Pairs are (3, 4) , (4, 5) and (3,5).  
 

Example 2:

Input:
N=3
arr[] = {1, 1, 1 } 
Output: 0

Your Task:
Since, this is a function problem. You don't need to take any input, as it is already accomplished by the driver code. You just need to complete the function CountPairs() that takes array arr and integer n as parameters and return the total number of pairs possible.

 

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

 

Constraints:
1 ≤ N ≤ 105
*/

/*
When a[i] = 0 : a[i]*a[j] = 0 and a[i] + a[j] >= 0 so if a[i] = 0 no pairs can be found. 
When a[i] = 1 : a[i]*a[j] = a[j] and a[i] + a[j] = 1 + a[j], so no pairs can be found when a[i] = 1 
When a[i] = 2 and a[j] = 2 : a[i]*a[j] = a[i] + a[j] = 4 
When a[i] = 2 and a[j] > 2 or a[i] > 2 and a[j] >= 2 : All such pairs are valid.
To solve this problem, count the number of 2s in the array say twoCount. Count the numbers greater than 2 in the array say twoGreaterCount. Answer will be twoCount * twoGreaterCount + twoGreaterCount * (twoGreaterCount-1)/2 
*/

//{ Driver Code Starts
//Initial Template for Java


//Initial Template for Java


import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java


public class Solution
{ 
    static int CountPairs (int arr[], int n) 
    {
        int two=0, twoG=0;
        
        for(int i:arr)
            if(i==2)
                two++;
            else if(i>2)
                twoG++;
        
        return two*twoG+(twoG*(twoG-1))/2;
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
		    int n=Integer.parseInt(br.readLine());
		    String line1 = br.readLine();
		    String[] a1 = line1.trim().split("\\s+");
		    int a[]=new int[n];
		    for(int i=0;i<n;i++)
		    {
		        a[i]=Integer.parseInt(a1[i]);
		    }
		    Solution ob=new Solution();
		    int ans=ob.CountPairs(a,n);
		    System.out.println(ans);
		    
		}
	}
}

// } Driver Code Ends
