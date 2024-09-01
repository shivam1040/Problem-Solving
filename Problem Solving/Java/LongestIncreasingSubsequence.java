/*
Given an array a[ ] of n integers, find the Length of the Longest Strictly Increasing Subsequence.

A sequence of numbers is called "strictly increasing" when each term in the sequence is smaller than the term that comes after it.

Example 1:

Input: n = 6, a[ ] = {5,8,3,7,9,1}
Output: 3
Explanation: There are more than one LIS in this array.  
One such Longest increasing subsequence is {5,7,9}.
Example 2:

Input: n = 16, a[ ] = {0,8,4,12,2,10,6,14,1,9,5,13,3,11,7,15}
Output: 6
Explanation: There are more than one LIS in this array. 
One such Longest increasing subsequence is {0,2,6,9,13,15}.
Your Task:
You do not need to read input or print anything. Complete the function longestSubsequence() which takes the given array and its size as input parameters and returns the length of the longest increasing subsequence.

Expected Time Complexity : O( n*log(n) )
Expected Auxiliary Space: O(n)

Constraints:
1 ≤ n ≤ 104
0 ≤ a[i] ≤ 106


*/

/*
Intuition
The idea is to use binary search but firstly lets see the intuition of using it.

We need to maintain lists of increasing sequences. In general, we have set of active lists of varying length. We are adding an element A[i] to these lists. Our strategy determined by the following conditions:

 If A[i] is smallest among all end candidates of active lists, we will start new active list of length 1.
 If A[i] is largest among all end candidates of active lists, we will clone the largest active  list, and extend it by a[i].
 If A[i] is in between, we will find a list with largest end element that is smaller than a[i]. Clone and extend this list by a[i]. We will discard all other lists of same length as that of this modified list.

The idea is that we want the length of LIS and need not to maintain all the lists. We can store the end elements in an array. Discarding operation can be simulated with replacement, and extending a list is analogous to adding more elements to array.
We will use an auxiliary array to keep end elements. The maximum length of this array is that of input.
To discard an element, we will trace ceil value of [a] in auxiliary array (again observe the end elements in your rough work), and replace ceil value with a[i]. We extend a list by adding element to auxiliary array.
Lets see how we can do it in example for array= [1, 7, 8, 4, 5, 6 , -1, 9]



 

The array we will be getting will not be the LIS but its length will the length of LIS.

Implementation
Declare an array tail of size n, it will act as an auxiliary array giving length of LIS.
tail[0] will be same as a[0] initially.
Initialize a variable lastIndex with 0, to keep track of last index till which tail array is filled.
Run a loop for i from 1 to n-1:
Find index of element in tail array, which is just greater than or equal to arr[i] using binary search.
If no such element exist, then index will be lastIndex+1. 
 tail[index] will be made equal to arr[i].
Update lastIndex as max of lastIndex and index.
Return (lastIndex+1) as answer because it will be the length of auxiliary array tail till which it is filled.
*/

//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {

        // taking input using Scanner class
        Scanner sc = new Scanner(System.in);

        // taking total testcases
        int t = sc.nextInt();
        while (t > 0) {

            // taking size of array
            int n = sc.nextInt();
            int array[] = new int[n];

            // inserting elements in the array
            for (int i = 0; i < n; ++i) {
                array[i] = sc.nextInt();
            }

            // creating an object of class Solution
            Solution ob = new Solution();

            // calling longestSubsequence() method of class
            // Solution
            System.out.println(ob.longestSubsequence(n, array));
            t--;
        }
    }
}
// } Driver Code Ends




class Solution {
    // Function to find length of longest increasing subsequence.
    static int longestSubsequence(int n, int a[]) {
        // code here
        int tail[]=new int[n];
        tail[0]=a[0];
        int lastIndex=0;
        
        for(int i=1; i<n; i++){
            //this gives the index where i should be present in the tail
            int index=binary(tail, 0, lastIndex, a[i]);
            tail[index]=a[i];
            lastIndex=Math.max(lastIndex, index);
        }
        return lastIndex+1;
    }
    
       private static int binary(int arr[], int l, int h, int value){
        if(value>arr[h])
            return h+1;
        while(h>l){
            int mid=(h+l)/2;
            
            if(arr[mid]==value)
                return mid;
            if(arr[mid]>value)
                h=mid;
            else
                l=mid+1;
        }
        return h;
    }
}
