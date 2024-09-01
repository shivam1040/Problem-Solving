/*
Given an array of n integers. We need to count all values of ‘k’ such that

arr[0] % k = arr[1] % k = ....... = arr[n-1] % k 
 

Example 1:

Input:
N=3
arr[] = {38, 6, 34} 
Output: 3
Explanation:
We can have values of k as 
1, 2 and 4.  

Example 2:

Input:
N=2
arr[] = {3, 2} 
Output: 1

Your Task:
Since, this is a function problem. You don't need to take any input, as it is already accomplished by the driver code. You just need to complete the function printEqualModNumbers() that takes array arr and integer n as parameters and returns the desired output.
Note- If values of k are infinite return -1.

 

Expected Time Complexity: O(N3/2).
Expected Auxiliary Space: O(N).

 

Constraints:
1 ≤ N ≤ 105
*/

//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java



class Solution
{ 
    static int printEqualModNumbers (int arr[], int n) 
    { 
        int max=Arrays.stream(arr).max().getAsInt(), count=1, num=0, k;
        
        if(n==1)
            return -1;
        while(max>0){
            //start with max k possible
            k=arr[0]%max;
            //iterate down to max>0
            for(int i=1; i<n; i++)
                if(k==arr[i]%max)
                    count++;
            //add to num only of given max mods all to 0
            if(count==n)
                num++;
            count=1;
            max--;
        }
        return num;
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
		    int ans=ob.printEqualModNumbers(a,n);
		    System.out.println(ans);
		    
		}
	}
}

// } Driver Code Ends
