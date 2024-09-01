/*
You are given an array arr[] of N integers. The task is to find the smallest positive number missing from the array.

Note: Positive number starts from 1.

Example 1:

Input:
N = 5
arr[] = {1,2,3,4,5}
Output: 6
Explanation: Smallest positive missing 
number is 6.
Example 2:

Input:
N = 5
arr[] = {0,-10,1,3,-20}
Output: 2
Explanation: Smallest positive missing 
number is 2.
Your Task:
The task is to complete the function missingNumber() which returns the smallest positive missing number in the array.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Constraints:
1 <= N <= 106
-106 <= arr[i] <= 106
*/

/*
Intuition:
The idea is to use array elements as an index. To mark the presence of an element x, change the value at the index x to negative. But this approach doesn’t work if there are non-positive (-ve and 0) numbers. So segregate positive from negative numbers as the first step and then apply the approach.

Example:
Input array: [2,-1,-3,4,4,7]

Array after segregation: [2,4,4,7]. We ignore the negative integers.
To mark the presence of integer 2 we do arr[2-1]=-arr[2-1]. We do this only if arr[in] is positive initially. 
For 4 we do arr[4-1]=-arr[4-1].
Array after all operations = [2, -4, 4, -7]
So, the value at index 0 is positive. So 1 is the minimum positive number not present in the array. 

Implementation:
Segregate positive numbers from others i.e., move all non-positive numbers to the left side
Now ignore non-positive elements and consider only the part of the array which contains all positive elements.
Traverse the array containing all positive numbers and to mark the presence of an element x, change the sign of value at index x to negative.
Traverse the array again and print the first index which has a positive value. 

*/

//{ Driver Code Starts
import java.util.*;
import java.io.*;


// } Driver Code Ends

class Solution
{
    //Function to find the smallest positive number missing from the array.
    static int missingNumber(int arr[], int n)
    {
        // Your code here
        int j=0;
        
        for(int i=0; i<n; i++)
            if(arr[i]<=0){
                int temp=arr[j];
                arr[j++]=arr[i];
                arr[i]=temp;
            }
        for(int i=j; i<n; i++)
            if(Math.abs(arr[i])+j-1 < n && arr[Math.abs(arr[i])+j-1]>0)
                arr[Math.abs(arr[i])+j-1]=-1*arr[Math.abs(arr[i])+j-1];
        for(int i=j; i<n; i++)
        //this means that element supposed to be present at this index wasn't found in the array hence this index ele never became negative
            if(arr[i]>0) 
                return i-j+1;
        return n-j+1;
    }
}


//{ Driver Code Starts.

class Main
{   
    public static void main (String[] args) throws IOException
    {

		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		
        //taking testcases
		int t=Integer.parseInt(in.readLine().trim());
		while(t-->0){
		    
		    //input number n
			int n=Integer.parseInt(in.readLine().trim());
			int[] arr=new int[n];
			String s[]=in.readLine().trim().split(" ");
			
			//adding elements to the array
			for(int i=0;i<n;i++)
				arr[i]=Integer.parseInt(s[i]);
				
			Solution obj = new Solution();
			
			//calling missingNumber()
			int missing = obj.missingNumber(arr,n);
			out.println(missing);
		}
		out.close();
    }
}


// } Driver Code Ends
