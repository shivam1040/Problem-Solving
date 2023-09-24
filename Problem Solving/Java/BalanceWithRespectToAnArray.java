/*
As a programmer, it is very necessary to maintain balance in the life.
Here is task for you to maintain a balance. Your task is to find whether a given number x is balanced with respect to a given array a[ ] which is sorted in non-decreasing order.
Given a sorted array a[ ], the ceiling of x is the smallest element in the array greater than or equal to x, and the floor of x is the greatest element smaller than or equal to x. The number 'x' is said to be balanced if the absolute difference between floor of x and x is equal to the absolute difference between ceil of x and x i.e. if absolute(x - floor(x, a[])) = absolute(ceil(x, a[]) - x).
If one of floor or ceil does not exist assume 'x' to be balanced.

Example 1:

Input:
N = 7  
x = 5
a[] = {1, 2, 8, 10, 10, 12, 19} 
Output: 
Balanced
Explanation: Here 2 is the floor value and 
8 is the ceil value and (5 - 2) = (8 - 5).  
Example 2:

Input:
N = 8  
x = 9 
a[] = {1, 2, 5, 7, 8, 11, 12, 15} 
Output: 
Not Balanced
Your Task:
This is a function problem. You don't need to take any input, as it is already accomplished by the driver code. You just need to complete the function FindElement() that takes array a[ ], its size N and integer x as input parameters and returns the string "Balanced" if the absolute difference between floor of x and x is equal to the absolute difference between ceil of x and x or else returns string "Not Balanced".

Expected Time Complexity: O(LogN)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ N ≤ 106


*/

//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java


class Solution
{
    public static String isBalanced(int arr[],int n,int x)
    {
        int floor=findFloor(arr, x, n), ceil=findCeil(arr, x, n);
        
        if(floor==-1 || ceil==-1)
            return "Balanced";
        
        return x-arr[floor]==arr[ceil]-x ? "Balanced": "Not Balanced";
        }
    
       public static int findFloor(int[] arr,int x,int n){
        int floor=-1;
        int low=0;
        int high=n-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]==x){
                floor=mid;
                break;
            }
            else if(arr[mid]<x){
                floor=mid;
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return floor;
    }
    public static int findCeil(int[] arr,int x,int n){
        int ceil=-1;
        int low=0;
        int high=n-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]==x){
                ceil=mid;
                break;
            }
            else if(arr[mid]>x){
                ceil=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ceil;
    }
}

//{ Driver Code Starts.

// Driver class
class GFG {
    
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
		    int x=Integer.parseInt(br.readLine());
		    Solution ob=new Solution();
		    String ans=ob.isBalanced(a,n,x);
		    System.out.println(ans);
		    
		}
	}
}
// } Driver Code Ends
