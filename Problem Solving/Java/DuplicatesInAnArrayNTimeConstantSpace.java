/*
1- Traverse the given array from i= 0 to n-1 elements
     Go to index arr[i]%n and increment its value by n.
2- Now traverse the array again and print all those 
   indexes i for which arr[i]/n is greater than 1.

This approach works because all elements are in range
from 0 to n-1 and arr[i]/n would be greater than 1
only if a value "i" has appeared more than once.
*/

/*
Given an array a[] of size N which contains elements from 0 to N-1, you need to find all the elements occurring more than once in the given array.

Example 1:

Input:
N = 4
a[] = {0,3,1,2}
Output: -1
Explanation: N=4 and all elements from 0
to (N-1 = 3) are present in the given
array. Therefore output is -1.
Example 2:

Input:
N = 5
a[] = {2,3,1,2,3}
Output: 2 3 
Explanation: 2 and 3 occur more than once
in the given array.
Your Task:
Complete the function duplicates() which takes array a[] and n as input as parameters and returns a list of elements that occur more than once in the given array in sorted manner. If no such element is found, return list containing [-1]. 

Expected Time Complexity: O(n).
Expected Auxiliary Space: O(n).
Note : The extra space is only for the array to be returned.
Try and perform all operation withing the provided array. 

Constraints:
1 <= N <= 105
0 <= A[i] <= N-1, for each valid i
*/

// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            Solution g = new Solution();
            ArrayList<Integer> ans = g.duplicates(a, n);
            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution {
    public static ArrayList<Integer> duplicates(int arr[], int n) {
        ArrayList<Integer> res=new ArrayList<Integer>();
        for (int i = 0; i < n; i++) 
        {
            int index = arr[i] % n;
            arr[index] += n;
        }

        for (int i = 0; i < n; i++) 
        {
            if ((arr[i] / n) > 1)
                res.add(i);
        }
        if(res.isEmpty()){
            res.add(-1);
            return res;
        }
        return res;
    }
}
