/*
Given an array of integers of size N and a number K., Your must modify array arr[] exactly K number of times. Here modify array means in each operation you can replace any array element either arr[i] by -arr[i] or -arr[i] by arr[i]. You need to perform this operation in such a way that after K operations, the sum of the array must be maximum.


Example 1:

Input:
N = 5, K = 1
arr[] = {1, 2, -3, 4, 5}
Output:
15
Explanation:
We have k=1 so we can change -3 to 3 and
sum all the elements to produce 15 as output.
Example 2:

Input:
N = 10, K = 5
arr[] = {5, -2, 5, -4, 5, -12, 5, 5, 5, 20}
Output:
68
Explanation:
Here  we have k=5 so we turn -2, -4, -12 to
2, 4, and 12 respectively. Since we have
performed 3 operations so k is now 2. To get
maximum sum of array we can turn positive
turned 2 into negative and then positive
again so k is 0. Now sum is
5+5+4+5+12+5+5+5+20+2 = 68

Your Task:
You don't have to print anything, print ting is done by the driver code itself. You have to complete the function maximizeSum() which takes the array A[], its size N, and an integer K as inputs and returns the maximum possible sum.


Expected Time Complexity: O(N*logN)
Expected Auxiliary Space: O(1)


Constraints:
1 ≤ N,K ≤ 105
-109 ≤ Ai ≤ 109
*/

// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            StringTokenizer stt = new StringTokenizer(br.readLine());
            
            int n = Integer.parseInt(stt.nextToken());
            int k = Integer.parseInt(stt.nextToken());
            long a[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.maximizeSum(a, n, k));
            
        }
	}
}
// } Driver Code Ends


//User function Template for Java


class Solution {

    public static long maximizeSum(long arr[], int n, int k)
    {
       Arrays.sort(arr);
       long sum=0;
       int i=0;
       while(i<n && k>0 && arr[i]<0){ //greedly changing elements from negative to positive
           arr[i]=arr[i]*-1;
           k--;
           i++;
       }
       
       if(i==0){ //if no negative elements then keep repeating k negations on first element
           int temp=-1;
           while(k>0){
               arr[i]=arr[i]*temp;
               k--;
           }
       }
       
       if(k>0){ //if k negations are still present, then keep repaeting k negation on smallest element
          Arrays.sort(arr);
          int temp=-1;
           while(k>0){
               arr[0]=arr[0]*temp;
               k--;
           }
       }
       
       for(int j=0; j<n; j++)
           sum+=arr[j];
       return sum;
    }
}