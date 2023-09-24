/*
There are N coins placed on the road where arr[i] is the denomination of ith coin. A Fox is looking to collect some of these coins. The fox is very greedy and follows a weird pattern of collecting coins: the fox collects coins in only increasing order of their denomination since it always craves for more money and all the coins it collects are contiguous. The fox wants to maximize the amount of money it collects.
Unfortunately, the Fox is greedy but not intelligent enough to find the solution and asks you for help. Find the maximum amount of money the fox can collect. 

 

Example 1:

Input:
N=6
arr[] = {2, 1, 4, 7, 3, 6} 
Output: 12
Explanation: Contiguous Increasing subarray 
             {1, 4, 7} = 12.
 

Example 2:

Input:
N=5
arr[] = {38, 7, 8, 10, 12} 
Output: 38

Your Task:
Since, this is a function problem. You don't need to take any input, as it is already accomplished by the driver code. You just need to complete the function largestSum() that takes array arr and integer N as parameters and returns the desired output.

 

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

 

Constraints:
1 ≤ N ≤ 105


*/

//{ Driver Code Starts
//Initial Template for Java


//Initial Template for Java


import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java


class GFG 
{ 
    // Returns sum of longest 
    // increasing subarray. 
    static int largestSum(int arr[], int n) 
    {
         int max=1, sum=arr[0], res=arr[0];
        
        for(int i=1; i<n; i++){
            if(arr[i]>arr[i-1])
                sum+=arr[i];
            else if(res<sum){
                res=sum;
                sum=arr[i];
            }
            else
                sum=arr[i];
        }
        if(res<sum)
            return sum;
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
		    int N=Integer.parseInt(br.readLine());
		    String line1 = br.readLine();
		    String[] a1 = line1.trim().split("\\s+");
		    int arr[]=new int[N];
		    for(int i=0;i<N;i++)
		    {
		        arr[i]=Integer.parseInt(a1[i]);
		    }
		    GFG ob=new GFG();
		    int ans=ob.largestSum(arr,N);
		    System.out.println(ans);
		    
		}
	}
}

// } Driver Code Ends
