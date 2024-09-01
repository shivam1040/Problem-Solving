/*
Given an array a of n positive integers. The task is to find the maximum of j - i subjected to the constraint of a[i] < a[j] and i < j.

Example 1:

Input:
n = 2
a[] = {1, 10}
Output:
1
Explanation:
a[0] < a[1] so (j-i) is 1-0 = 1.
Example 2:

Input:
n = 9
a[] = {34, 8, 10, 3, 2, 80, 30, 33, 1}
Output:
6
Explanation:
In the given array a[1] < a[7] satisfying the required condition(a[i] < a[j]) thus giving the maximum difference of j - i which is 6(7-1).
Your Task:
The task is to complete the function maxIndexDiff() which takes array a[] and integer n as input and returns the maximum index difference.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

Constraints:
1 ≤ n ≤ 106
0 ≤ a[i] ≤ 109


*/

/*
Intuition:
The main logic is that maintain the minimum value and maximum value we get till every index, i.e prefixMin and SuffixMax and by using these values we can easily find at every index is there any value greater than the ith value or not if we once know that there is some greater value is present then by using two pointers we can keep track of at which index this value is present.

If for ith element I have found the farthest jth element such that arr[i] <= arr[j] so for ith element, the max value of (j-i) is computed and now to calculate for (i+1)th element we don't need to reset j because if we decrease the j value then the value of (j-i) will always be less than the max value of (j-i) computed till now so just increase the value of j and continue the process by this approach time reduces to linear i.e, O(N).

Implementation:
Create a suffix max array from right to left of the array i.e, Rmax[i] = max(Rmax[i+1],arr[i]) and Rmax[n-1] = arr[n-1].
Create a prefix min array from left to right of the array i.e, Lmin[i] = min(Lmin[i-1],arr[i]) and Lmin[0] = arr[0].
Then use two-pointer approach where loop the ith pointer from (i = 0 to i < N).
For every iteration check if this condition holds (Lmin[i] <= Rmax[j]) then just take this index as the farthest point for that ith element and keep a global max value and update it with (j-i) and increase the right index(j).
Else increase the left index(i).
Return the global max value.
Example:
Lets consider any example [7 3 1 8 9 10 4 5 6]
Rmax: [10 10 10 10 10 10 6 6 6] 
Lmin: [7 3 1 1 1 1 1 1 1 ] 
keep answer = -1. and left pointer = 0, right pointer = 0.
Now run loop by using 2 pointer approach.
Lmin[left]<=Rmax[right] => answer = right(0) - left(0) = 0, right = rigth+1 = 1, left = 0
Lmin[left]<=Rmax[right] => answer = right(1) - left(0) = 1, right = rigth+1 = 2, left = 0
Lmin[left]<=Rmax[right] => answer = right(2) - left(0) = 2, right = rigth+1 = 3, left = 0
Lmin[left]<=Rmax[right] => answer = right(3) - left(0) = 3, right = rigth+1 = 4, left = 0
Lmin[left]<=Rmax[right] => answer = right(4) - left(0) = 4, right = rigth+1 = 5, left = 0
Lmin[left]<=Rmax[right] => answer = right(5) - left(0) = 5, right = rigth+1 = 6, left = 0
Now, Rmax[right] = Rmax[6] = 6 and Lmin[left] = Lmin[0] = 7
Lmin[left] > Rmax[right] => here condition not satisfied so update left pointer, left++, left=1
Now, Rmax[right] = Rmax[6] = 6 and Lmin[left] = Lmin[1] = 3
Lmin[left]<=Rmax[right] => answer = right(6) - left(1) = 5, right = rigth(6)+1 = 7, left = 1
Lmin[left]<=Rmax[right] => answer = right(7) - left(1) = 6, right = rigth(7)+1 = 8, left = 1
Lmin[left]<=Rmax[right] => answer = right(8) - left(1) = 7, right = rigth(8)+1 = 9, left = 1,
Now right index goes out of loop,
Hence final answer: 7
*/

//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    int n = Integer.parseInt(br.readLine().trim()); // size of array
		    int arr[] = new int[n];
		    String inputLine[] = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]); // input elements of array
		    }
		    
		    Solution ob = new Solution();
		    
		    System.out.println(ob.maxIndexDiff(arr, n)); // print the result
		}
	}
}
// } Driver Code Ends


class Solution{
    
    // A[]: input array
    // N: size of array
    // Function to find the maximum index difference.
    static int maxIndexDiff(int a[], int n) { 
        
        // Your code here
        int leftMin[]=new int[n];
        int rightMax[]=new int[n];
        leftMin[0]=a[0];
        rightMax[n-1]=a[n-1];
        
        for(int i=1; i<n; i++)
            leftMin[i]=Math.min(leftMin[i-1], a[i]);
        for(int i=n-2; i>=0; i--)
            rightMax[i]=Math.max(rightMax[i+1], a[i]);
        int i=0, j=0, res=-1;
        
        while(i<n && j<n)
            if(leftMin[i]>rightMax[j])
                i++;
            else{
                res=Math.max(res, j-i);
                j++;
            }
        return res;
    }
}

