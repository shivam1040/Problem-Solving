/*
Count distinct elements in every window 
Easy Accuracy: 44.16% Submissions: 77294 Points: 2
Given an array of integers and a number K. Find the count of distinct elements in every window of size K in the array.

Example 1:

Input:
N = 7, K = 4
A[] = {1,2,1,3,4,2,3}
Output: 3 4 4 3
Explanation: Window 1 of size k = 4 is
1 2 1 3. Number of distinct elements in
this window are 3. 
Window 2 of size k = 4 is 2 1 3 4. Number
of distinct elements in this window are 4.
Window 3 of size k = 4 is 1 3 4 2. Number
of distinct elements in this window are 4.
Window 4 of size k = 4 is 3 4 2 3. Number
of distinct elements in this window are 3.
Example 2:

Input:
N = 3, K = 2
A[] = {4,1,1}
Output: 2 1
Your Task:
Your task is to complete the function countDistinct() which takes the array A[], the size of the array(N) and the window size(K) as inputs and returns an array containing the count of distinct elements in every contiguous window of size K in the array A[].

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
1 <= K <= N <= 105
1 <= A[i] <= 105 , for each valid i
*/

/*
So, there is an efficient solution using hashing, though hashing requires extra O(n) space but the time complexity will improve. The trick is to use the count of the previous window while sliding the window. To do this a hash map can be used that stores elements of the current window. The hash-map is also operated on by simultaneous addition and removal of an element while keeping track of distinct elements. The problem deals with finding the count of distinct elements in a window of length k, at any step while shifting the window and discarding all the computation done in the previous step, even though k - 1 elements are same from the previous adjacent window. For example, assume that elements from index i to i + k - 1 are stored in a Hash Map as an element-frequency pair. So, while updating the Hash Map in range i + 1 to i + k, reduce the frequency of the i-th element by 1 and increase the frequency of (i + k)-th element by 1. 
Insertion and deletion from the HashMap takes constant time.


Algorithm: 
Create an empty hash map. Let the hash map be hM.
Initialize the count of distinct elements as dist_count to 0.
Traverse through the first window and insert elements of the first window to hM. The elements are used as key and their counts as the value in hM. Also, keep updating dist_count
Print distinct count for the first window.
Traverse through the remaining array (or other windows).
Remove the first element of the previous window. 
If the removed element appeared only once, remove it from hM and decrease the distinct count, i.e. do "dist_count--"
else (appeared multiple times in hM), then decrement its count in hM
Add the current element (last element of the new window) 
If the added element is not present in hM, add it to hM and increase the distinct count, i.e. do "dist_count++"
Else (the added element appeared multiple times), increment its count in hM

basically add elements to hash and keep track of their counts in every window as a value, as you traverse every k, check elemnts left of the staarting and ensure to remove them if count is 1 and for all other cases add the elements with 1 value or if they are already present and count greater than one than decrease value
*/
// { Driver Code Starts
    import java.util.*;
    import java.io.*;
    import java.util.HashMap;
    
    class GFG
    {
        public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while (t > 0)
            {
                int n = sc.nextInt();
                int k = sc.nextInt();
                int a[] = new int[n];
                for (int i = 0; i < n; i++) 
                    a[i] = sc.nextInt();
                Solution g = new Solution();
                
                ArrayList<Integer> ans = g.countDistinct(a, n, k);
    
                for (Integer val: ans) 
                    System.out.print(val+" "); 
                System.out.println();
                t--;
            }
        }
    }// } Driver Code Ends
    
    
    class Solution
    {
        ArrayList<Integer> countDistinct(int arr[], int n, int k)
        {
            
            ArrayList<Integer> res=new ArrayList<Integer>();
             // Creates an empty hashMap hM
            HashMap<Integer, Integer> hM = new HashMap<Integer, Integer>();
    
            // Traverse the first window and store count
            // of every element in hash map
            for (int i = 0; i < k; i++)
                hM.put(arr[i], hM.getOrDefault(arr[i], 0) + 1);
    
            // Print count of first window
            res.add(hM.size());
    
            // Traverse through the remaining array
            for (int i = k; i < arr.length; i++) {
    
                // Remove first element of previous window
                // If there was only one occurrence
                if (hM.get(arr[i - k]) == 1) {
                    hM.remove(arr[i - k]);
                }
    
                else // reduce count of the removed element
                    hM.put(arr[i - k],  hM.get(arr[i - k]) - 1);            
    
                // Add new element of current window
                // If this element appears first time,
                // set its count as 1,
                hM.put(arr[i], hM.getOrDefault(arr[i], 0) + 1);
    
                // Print count of current window
                res.add(hM.size());
            }
            return res;
        }
    }
    
    