/*
Given an array arr[] of N integers which may contain duplicate elements, the index of an element of this array is given to us, the task is to find the final position of this element ( for which the index is given) in the array after the stable sort is applied on the array. 

 

Example 1:

Input: N = 10, INDEX = 5
arr[]= {3, 4, 3, 5, 2, 3, 4, 3, 1, 5}
Output: 4
Explanation: Element initial index – 5 
(third 3) After sorting array by stable 
sorting algorithm,we get array as shown 
below [1(8), 2(4), 3(0), 3(2), 3(5), 3(7),
4(1), 4(6), 5(3), 5(9)] with their 
initial indices shown in parentheses next 
to them,Element's index after sorting = 4.
 

Your Task:
This is a function problem. You don't need to take any input, as it is already accomplished by the driver code. You just need to complete the function getIndexInSortedArray() that takes array arr, integer N, and integer index as parameters and returns the number of uneaten leaves.

 

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

 

Constraints:
1 ≤ N ≤ 106
*/

/*
As position of an element in a sorted array is decided by only those elements which are smaller than given element. We count all array elements smaller than given element and for those elements which are equal to given element, elements occurring before given elements’ index will be included in count of smaller elements this will insure the stability of the result’s index. 
*/

//{ Driver Code Starts
//Initial Template for Java



//Initial Template for Java



import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java


class Solution
{
    long getIndexInSortedArray(long arr[], int n,int index)
    {
        long res=0;
        
        for(int i=0; i<n; i++){
            if(arr[i]<arr[index])
                res++;
            if(arr[i]==arr[index] && i<index)
                res++;
        }
        return res;
    }
}


//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {
//            int n = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] q = line.trim().split("\\s+");
            int n =Integer.parseInt(q[0]);
            int k =Integer.parseInt(q[1]);
            //int y =Integer.parseInt(a2[2]);
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            long a[] = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(a1[i]);
            }
//            String line2 = br.readLine();
//            String[] a2 = line2.trim().split("\\s+");
//            long b[] = new long[n];
//            for (int i = 0; i < m; i++) {
//                b[i] = Long.parseLong(a2[i]);
//            }
            Solution ob = new Solution();
            //ArrayList<Long> ans=ob.smallestDifferenceTriplet(a,b,c,n);
            System.out.println(ob.getIndexInSortedArray(a,n,k));
//            for (int i = 0; i < n; i++)
//                System.out.print(a[i]+" ");
//            System.out.println();
        }
    }
}




// } Driver Code Ends
