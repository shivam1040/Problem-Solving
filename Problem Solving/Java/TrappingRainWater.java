/*
Given an array arr[] of N non-negative integers representing the height of blocks. If width of each block is 1, compute how much water can be trapped between the blocks during the rainy season. 
 

Example 1:

Input:
N = 6
arr[] = {3,0,0,2,0,4}
Output:
10
Explanation: 

Example 2:

Input:
N = 4
arr[] = {7,4,0,9}
Output:
10
Explanation:
Water trapped by above 
block of height 4 is 3 units and above 
block of height 0 is 7 units. So, the 
total unit of water trapped is 10 units.
Example 3:

Input:
N = 3
arr[] = {6,9,9}
Output:
0
Explanation:
No water will be trapped.

Your Task:
You don't need to read input or print anything. The task is to complete the function trappingWater() which takes arr[] and N as input parameters and returns the total amount of water that can be trapped.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)


Constraints:
3 < N < 106
0 < Ai < 108
*/

/*
Using Stack: The idea to solve the problem using stack is as follows:

We can use a stack to track the bars that are bounded by the higher left and right bars. This can be done using only one iteration.

For this, we will keep pushing elements in the stack until an element with a higher value than the stack top is found. This denotes that there is a chance of storing position on the left side of the current element with the current bar being an end.
So remove the smaller element on left and find the left bar (which is the current top of the stack) and the amount of water stored by the left end bar and the current bar being the right end. Continue this till the stack is not empty or a higher-value element is found.
Follow the below illustration for a better understanding.

Example:
Consider the array arr[] = {3, 0, 2, 0, 4} and an empty stack st.
For i = 0:
       => The stack is empty. So no elements with higher value on the left.
       => Push the index into the stack. st = {0} [to keep track of the distance in between]
For i = 1:
       => arr[1] is less than arr[stack top]. So arr[1] has a higher left bound.
       => Push the index into the stack. st = {0, 1}
For i = 2:
       => arr[2] is greater than arr[stack top]. So arr[2] is the higher right bound of the current stack top.
       => Calculate the water stored in between the left and right bound of the stack top. 
       => The stack top is the base height in between the left and right bound.
       => Pop the stack top. So st = {0}.
       => Water stored in between when arr[0] and arr[2] are the bound= {min(arr[0], arr[2]) - arr[1]} * (2 - 0 - 1) = 2.
       => arr[0] is greater than arr[2] Push the index into stack. st = {0, 2}.
       => Total water stored = 0 + 2 = 2.
For i = 3:
       => arr[3] is less than arr[2]. So arr[3] has a higher left bound.
       => Push the index into the stack. st = {0, 2, 3}.
For i = 4:
       => arr[4] is greater than arr[stack top]. So arr[4] is the higher right bound of the current stack top.
       => Calculate the water stored in same way as for i = 2. The base height is arr[3].
       => Pop the stack top. So st = {0, 2}.
       => Water stored in between when arr[4] and arr[2] are the bound= {min(arr[4], arr[2]) - arr[3]} * (4 - 2 - 1) = 2.
       => arr[4] is greater than arr[2].
       => Pop the stack. st = {0}.
       => Water stored in between arr[0] and arr[4] when arr[2] is the base height = {min(3, 4) - 2} * (4 - 0 - 1) = 3
       => arr[0] less than arr[4]. So pop stack. st = {}.
       => As no element left in the stack push the index. st = {4}.
       => Total water stored = 2 + 2 + 3 = 7.
So the total amount of water stored  = 7.
*/

//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;


class Array {

	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		  
		    //size of array
		    int n = Integer.parseInt(br.readLine().trim());
		    int arr[] = new int[n];
		    String inputLine[] = br.readLine().trim().split(" ");
		    
		    //adding elements to the array
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]);
		    }
		    
		    Solution obj = new Solution();
		    
		    //calling trappingWater() function
		    System.out.println(obj.trappingWater(arr, n));
		}
	}
}


// } Driver Code Ends


class Solution{
    
    // arr: input array
    // n: size of array
    // Function to find the trapped water between the blocks.
    static long trappingWater(int arr[], int n) { 
        // Your code here
        int left[]=new int[n];
        int right[]=new int[n];
        left[0]=arr[0];
        
        for(int i=1; i<n; i++)
            left[i]=Math.max(left[i-1], arr[i]);
        right[n-1]=arr[n-1];
        for(int i=n-2; i>=0; i--)
            right[i]=Math.max(right[i+1], arr[i]);
        long res=0;
        
        for(int i=1; i<n-1; i++)
            res+=Math.max(0, Math.min(left[i], right[i])-arr[i]);
        return res;
    } 
}

