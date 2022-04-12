/*
Given an array of 0s and 1s. Find the length of the largest subarray with equal number of 0s and 1s.

Example 1:

Input:
N = 4
A[] = {0,1,0,1}
Output: 4
Explanation: The array from index [0...3]
contains equal number of 0's and 1's.
Thus maximum length of subarray having
equal number of 0's and 1's is 4.
Example 2:

Input:
N = 5
A[] = {0,0,1,0,0}
Output: 2
Your Task:
You don't need to read input or print anything. Your task is to complete the function maxLen() which takes the array arr[] and the size of the array as inputs and returns the length of the largest subarray with equal number of 0s and 1s.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
1 <= N <= 105
0 <= A[] <= 1
*/

/*
The concept of taking cumulative sum, taking 0's as -1 will help us in optimizing the approach. While taking the cumulative sum, there are two cases when there can be a sub-array with equal number of 0's and 1's. 


When cumulative sum=0, which signifies that sub-array from index (0) till present index has equal number of 0's and 1's.
When we encounter a cumulative sum value which we have already encountered before, which means that sub-array from the previous index+1 till the present index has equal number of 0's and 1's as they give a cumulative sum of 0 .

In a nutshell this problem is equivalent to finding two indexes i & j in array[] such that array[i] = array[j] and (j-i) is maximum. To store the first occurrence of each unique cumulative sum value we use a hash_map wherein if we get that value again we can find the sub-array size and compare it with the maximum size found till now.
*/
// { Driver Code Starts
    import java.util.Scanner;
    import java.util.*;
    import java.lang.*;
    import java.util.HashMap;
    
    class Largest_Subarray
    {
        public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int T = sc.nextInt();
            while (T > 0)
            {
                int N = sc.nextInt();
                int a[] = new int[N];
                for (int i = 0; i < N; i++) 
                    a[i] = sc.nextInt();
                
    
                Solution g = new Solution();
                int n = g.maxLen(a, a.length);
    
                System.out.println(n);
    
                T--;
            }
        }
    }
    // } Driver Code Ends
    
    
    
    
    class Solution {
    
        // arr[] : the input array containing 0s and 1s
        // N : size of the input array
        
        // return the maximum length of the subarray
        // with equal 0s and 1s
        int maxLen(int[] arr, int n)
        {
            HashMap<Integer, Integer> hM
                = new HashMap<Integer, Integer>();
    
            // Initialize sum of elements
            int sum = 0;
    
            // Initialize result
            int max_len = 0;
            int ending_index = -1;
            int start_index = 0;
    
            for (int i = 0; i < n; i++) {
                arr[i] = (arr[i] == 0) ? -1 : 1;
            }
    
            // Traverse through the given array
    
            for (int i = 0; i < n; i++) {
                // Add current element to sum
    
                sum += arr[i];
    
                // To handle sum=0 at last index
    
                if (sum == 0) {
                    max_len = i + 1;
                    ending_index = i;
                }
    
                // If this sum is seen before,
                // then update max_len if required
                //we do i-hm.getSum to ensure that max len is always updated when it's smaller the value received from map so that max len always has largest length value;
                if (hM.containsKey(sum)) {
                    if (max_len < i - hM.get(sum)) {
                        max_len = i - hM.get(sum);
                        ending_index = i;
                    }
                }
                else // Else put this sum in hash table
                    hM.put(sum, i);
            }
    
            for (int i = 0; i < n; i++) {
                arr[i] = (arr[i] == -1) ? 0 : 1;
            }
    
            int end = ending_index - (max_len + 1);
            //System.out.println(end + " to " + ending_index);
    
            return max_len;
        }
    }
    