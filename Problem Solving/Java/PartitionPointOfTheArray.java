/*
Given an unsorted array of integers. Find an element such that all the elements to its left are smaller and to its right are greater. Print -1 if no such element exists. Note that there can be more than one such element. In that case print the first such number occurring in the array.

Example 1:

Input: N = 7, arr[] = {4, 3, 2, 5, 8, 6, 7} 
Output: 5
Explanation: To the left of element 5 
every element is smaller to it and to 
the right of element 5 every element 
is greater to it.  
Example 2:

Input: N = 7, arr[] = {5, 6, 2, 8, 10, 9, 8} 
Output: -1
Explanation: No such desired element is 
present in the array.
Your Task:
This is a function problem. You don't need to take any input, as it is already accomplished by the driver code. You just need to complete the function FindElement() that takes array arr and integer N as parameters and returns the desired output.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

Constraints:
1 ≤ N ≤ 106


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
            //            int m =Integer.parseInt(a2[1]);
            // int y =Integer.parseInt(a2[2]);
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            long a[] = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(a1[i]);
            }
            Solution ob = new Solution();
            // ArrayList<Long> ans=ob.smallestDifferenceTriplet(a,b,c,n);
            long ans = ob.FindElement(a, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    long FindElement(long arr[], int N) {
        // Your code goes here
        long res=arr[0], maxUntilLast=-1, greatUntilNow=arr[0];
          //basic idea is to keep track of greatest ele until i-1
        //update the res if current aux ans is smaller than i
        for(int i=1; i<N; i++){
            maxUntilLast=Math.max(maxUntilLast, arr[i-1]);
            
            if(greatUntilNow>=arr[i])
                res=-1;
            if(res==-1 && greatUntilNow<arr[i] && maxUntilLast<arr[i]){
                res=arr[i];
                greatUntilNow=arr[i];
            }
        }
        return res;
    }
}

