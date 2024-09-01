/*
You have n books, each with arr[i] a number of pages. m students need to be allocated contiguous books, with each student getting at least one book.
Out of all the permutations, the goal is to find the permutation where the sum of the maximum number of pages in a book allotted to a student should be the minimum, out of all possible permutations.

Note: Return -1 if a valid assignment is not possible, and allotment should be in contiguous order (see the explanation for better understanding).

Examples:

Input: n = 4, arr[] = [12, 34, 67, 90], m = 2
Output: 113
Explanation: Allocation can be done in following ways:
{12} and {34, 67, 90} Maximum Pages = 191
{12, 34} and {67, 90} Maximum Pages = 157
{12, 34, 67} and {90} Maximum Pages =113.
Therefore, the minimum of these cases is 113, which is selected as the output.
Input: n = 3, arr[] = [15, 17, 20], m = 5
Output: -1
Explanation: Allocation can not be done.
Expected Time Complexity: O(n logn)
Expected Auxilliary Space: O(1)

Constraints:
1 <=  n, m <= 105
1 <= arr[i] <= 106                                 
*/

//{ Driver Code Starts
// Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            int m = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.findPages(n, a, m));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to find minimum number of pages.
    public static long findPages(int n, int[] arr, int m) {
        // Your code here
        if(n<m)
            return -1;
        //max num of pages that can be read by a stud and total num of pages to be read
        int max=-1, sum=0;
        for(int i:arr){
            sum+=i;
            
            if(i>max)
                max=i;
        }
        if(P(max, arr, n, m))
            return max;
        //doing binary to find min pages
        while(max<sum-1){
            int mid=(max+sum)/2;
            
            if(P(mid, arr, n, m))
                sum=mid;
            else
                max=mid;
        }
        return sum;
    }
    
    //min stud required to finish in terms of x pages
    private static int G(int x, int[] arr, int n){
        int numStud=1, curLoad=0;
        
        for(int i:arr)
            if(curLoad+i<=x)
                curLoad+=i;
            else{
                curLoad=i;
                numStud++;
            }
            return numStud;
    }
    
    //given x pages each is sufficient to be finished with at most m students
    private static boolean P(int x, int[] arr, int n, int m){
        return G(x, arr, n)<=m;
    }
};
