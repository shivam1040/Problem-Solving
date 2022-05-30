/*
Given two sorted arrays A and B of size M and N respectively. Each array may have some elements in common with the other array. Find the maximum sum of a path from the beginning of any array to the end of any of the two arrays. We can switch from one array to another array only at the common elements.Both the arrays are sorted.
Note: Only one repeated value is considered in the valid path sum.


Example 1:

Input:
M = 5, N = 4
A[] = {2,3,7,10,12}
B[] = {1,5,7,8}
Output: 35
Explanation: The path will be 1+5+7+10+12
= 35.

Example 2:

Input:
M = 3, N = 3
A[] = {1,2,3}
B[] = {3,4,5}
Output: 15
Explanation: The path will be 1+2+3+4+5=15.

Your Task:
You don't need to read input or print anything. Complete the function max_path_sum() which takes the two arrays A and B along with their sizes M and N as input parameters. It returns the maximum path sum.


Expected Time Complexity: O(M + N)
Expected Auxiliary Space: O(1)


Constraints:
1 <= M,N <= 104
1 <= A[i], B[i] <= 104
*/

/*
The idea is to do something similar to merge process of merge sort. This involves calculating the sum of elements between all common points of both arrays. Whenever there is a common point, compare the two sums and add the maximum of two to the result.




Algorithm: 


Create some variables, result, sum1, sum2. Initialize result as 0. Also initialize two variables sum1 and sum2 as 0. Here sum1 and sum2 are used to store sum of element in ar1[] and ar2[] respectively. These sums are between two common points.
Now run a loop to traverse elements of both arrays. While traversing compare current elements of array 1 and array 2 in the following order.
If current element of array 1 is smaller than current element of array 2, then update sum1, else if current element of array 2 is smaller, then update sum2.
If the current element of array 1 and array 2are same, then take the maximum of sum1 and sum2 and add it to the result. Also add the common element to the result.
This step can be compared to the merging of two sorted arrays, If the smallest element of the two current array indices is processed then it is guaranteed that if there is any common element it will be processed together. So the sum of elements between two common elements can be processed.

*/

// { Driver Code Starts
import java.util.*;

class ArrPathSum1
{
	// Driver Code
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		while(T>0)
		{
			int m = sc.nextInt();
			int n = sc.nextInt();
			int ar1[] = new int[m];
			int ar2[] = new int[n];
			for(int i=0; i<m; i++)
				ar1[i] = sc.nextInt();
			for(int i=0; i<n; i++)
				ar2[i] = sc.nextInt();
		
		Solution g = new Solution();
		System.out.println(g.maxPathSum(ar1,ar2));
		T--;
		}
	}
}// } Driver Code Ends


class Solution
{
    /*You are required to complete this method
    * ar1 : 1st array
    * ar2 : 2nd array
    */
    int maxPathSum(int ar1[], int ar2[])
    {
        int i=0, j=0, res=0, sum1=0, sum2=0;
        while(i<ar1.length && j<ar2.length){
            if(ar1[i]<ar2[j]) //adding elements from a1 until common
                sum1+=ar1[i++];
            else if(ar1[i]>ar2[j]) //doing the above comment similarly here
                sum2+=ar2[j++];
            else{ //this means common point encountered
                res+=Math.max(sum1, sum2)+ar1[i];
                sum1=0;
                sum2=0;
                i++;
                j++;
            }
        }
        while(i<ar1.length) //just in case indexes havent reach their max
            sum1+=ar1[i++];
        while(j<ar2.length)
            sum2+=ar2[j++];
        res+=Math.max(sum1, sum2);
        return res;
    }
}