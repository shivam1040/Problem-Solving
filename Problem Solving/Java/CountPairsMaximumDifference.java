/*
Given an array a[ ] of N elements, the task is to find the number of ways to choose pairs {a[i], a[j]} such that their absolute difference is maximum.

Example:

Input:
N = 5
a[] = {3, 2, 1, 1, 3}
Output:
4
Explanation:
The maximum difference you can find is 2
which is from 3 - 1 = 2.
Number of ways of choosing it:
1) Choosing the first and third element
2) Choosing the first and fourth element
3) Choosing the third and fifth element
4) Choosing the fourth and fifth element
Hence, the answer is 4.
Your Task:
This is a function problem. The input is already taken care of by the driver code. You only need to complete the function countPairs() that take array(a) and sizeOfArray(N) as input parameters, and returns the count of pairs which has the maximum difference. The driver code takes care of the printing.

Expected Time Complexity: O(n).
Expected Auxiliary Space: O(1).

Constraints:
1 ≤ N ≤ 105
1 ≤ A[i] ≤ 105
*/

/*
Case I (if all the elements are equal): The ans is no. of ways of choosing 2 elements from a set of n elements nC2     which is n(n-1)/2.
Case II (If all the elements are not equal) : The answer is product of count of no. of minimum elements(c1) and count of no. of maximum elements(c2), i.e., c1*c2
*/

//{ Driver Code Starts
//Initial Template for Java



import java.io.*;
import java.util.*;


class GFG {
	public static void main (String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int a[] = new int[n+1];
            
            for(int i=0;i<n;i++){
                a[i] = sc.nextInt();
            }
            
            Count obj = new Count();
            System.out.println( obj.countPairs(a,n) );
            
        }
        
	}
}

// } Driver Code Ends


//User function Template for Java


class Count{
    
    public long countPairs(int a[],int n){
        // Complete The Function and return the answer
        
              int mn = Integer.MAX_VALUE;
        int mx = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            mn = Math.min(mn, a[i]);
            mx = Math.max(mx, a[i]);
        }
 
        // to find the count of minimum and
        // maximum elements
        int c1 = 0;
        int c2 = 0; // Count variables
        for (int i = 0; i < n; i++) {
            if (a[i] == mn)
                ++c1;
            if (a[i] == mx)
                ++c2;
        }
 
        // condition for all elements equal
        if (mn == mx)
            return n * (n - 1) / 2;
        else
            return c1 * c2;
    }    
    
}


