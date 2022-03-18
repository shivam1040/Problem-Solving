/*
Given an array having both positive and negative integers. The task is to compute the length of the largest subarray with sum 0.

Example 1:

Input:
N = 8
A[] = {15,-2,2,-8,1,7,10,23}
Output: 5
Explanation: The largest subarray with
sum 0 will be -2 2 -8 1 7.
Your Task:
You just have to complete the function maxLen() which takes two arguments an array A and n, where n is the size of the array A and returns the length of the largest subarray with 0 sum.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
1 <= N <= 105
-1000 <= A[i] <= 1000, for each valid i
*/

/*
based on the idea that if a an array has zero sum subarray then it means that a part of array is equal to the opposit value of the aforementioned array. This way we can find max length subarray by using math max everytime we get an similar sum
*/

// { Driver Code Starts
    import java.util.*;

    class MaxLenZeroSumSub
    {
    
        // Returns length of the maximum length subarray with 0 sum
    
        // Drive method
        public static void main(String arg[])
        {
            Scanner sc = new Scanner(System.in);
            int T = sc.nextInt();
            while (T > 0)
            {
                int n = sc.nextInt();
                int arr[] = new int[n];
                for (int i = 0; i < n; i++)
                    arr[i] = sc.nextInt();
    
                GfG g = new GfG();
                System.out.println(g.maxLen(arr, n));
                T--;
            }
        }
    }// } Driver Code Ends
    
    
    class GfG
    {
        int maxLen(int arr[], int n)
        {
            // Creates an empty hashMap hM
            HashMap<Integer, Integer> hM = new HashMap<Integer, Integer>();
    
            int sum = 0; // Initialize sum of elements
            int max_len = 0; // Initialize result
    
            // Traverse through the given array
            for (int i = 0; i < arr.length; i++) {
                // Add current element to sum
                sum += arr[i];
    
                if (arr[i] == 0 && max_len == 0)
                    max_len = 1;
        
                if (sum == 0) //this is neccessary for cases where entire array sum is zero
                    max_len = i + 1;
    
                // Look this sum in hash table
                Integer prev_i = hM.get(sum);
    
                // If this sum is seen before, then update max_len
                // if required
                if (prev_i != null)
                    max_len = Math.max(max_len, i - prev_i);
                else // Else put this sum in hash table
                    hM.put(sum, i);
            }
    
            return max_len;
        }
    }