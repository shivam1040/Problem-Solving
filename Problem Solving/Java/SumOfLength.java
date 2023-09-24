/*
Given an array. Calculate the sum of lengths of contiguous subarrays having all distinct elements.
 

Example 1:

Input:
N=3
arr[] = { 1,2,3 }
Output: 10
Explanation: 
{1, 2, 3} is a subarray of length 3 with 
distinct elements. Total length of length
three = 3. {1, 2}, {2, 3} are 2 subarray 
of length 2 with distinct elements. Total 
length of lengths two = 2 + 2 = 4
{1}, {2}, {3} are 3 subarrays of length 1
with distinct element. Total lengths of 
length one = 1 + 1 + 1 = 3
Sum of lengths = 3 + 4 + 3 = 10
Example 2:

Input:
N=1
arr[] = { 1 }
Output: 1
Explanation: 
{1} is the only subarray with distinct 
elements of length 1.  

Your Task:
You don't need to read input or print anything. Your task is to complete the function sumoflength() that takes array arr and integer N as input parameters and returns the sum of lengths of contiguous subarrays having all distinct elements.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

 

Constraints:
1 ≤ N ≤ 106
*/

/*
An efficient solution is based on the fact that if we know all elements in a subarray arr[i..j] are distinct, sum of all lengths of distinct element subarrays in this subarray is ((j-i+1)*(j-i+2))/2. How? the possible lengths of subarrays are 1, 2, 3,……, j – i +1. So, the sum will be ((j – i +1)*(j – i +2))/2.


We first find the largest subarray (with distinct elements) starting from first element. We count sum of lengths in this subarray using above formula. For finding next subarray of the distinct element, we increment starting point, i and ending point, j unless (i+1, j) are distinct. If not possible, then we increment i again and move forward the same way.
*/

//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.io.*;
import java.util.*;

// Position this line where user code will be pasted.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {
            int n = Integer.parseInt(br.readLine());
            //            String line = br.readLine();
            //            String[] a2 = line.trim().split("\\s+");
            //            int n =Integer.parseInt(a2[0]);
            //            int k =Integer.parseInt(a2[1]);
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            long a[] = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(a1[i]);
            }
            Solution ob = new Solution();
            // ArrayList<Long> ans=ob.smallestDifferenceTriplet(a,b,c,n);
            long ans = ob.sumoflength(a, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    long sumoflength(long arr[], int n) {
        int j=0;
        long ans=0;
        Set<Long> aux=new HashSet<>();
        
        for(int i=0; i<n; i++){
            while(j<n && !aux.contains(arr[j])){
                aux.add(arr[j]);
                j++;
            }
            //formula to find count of sets if if a given range has disticnt ele
            ans+=((j-i)*(j-i+1))/2;
            //this is done to move to next element so that a new subarray is taken into consideration
            aux.remove(arr[i]);
        }
        return ans;
    }
}

