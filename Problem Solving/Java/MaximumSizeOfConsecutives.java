/*
Given a sorted array arr of n distinct elements and an integer k. The array elements denote positions of points on 1-D number line, find the maximum size of subset of points that can have consecutive values of points which can be formed by placing another k points on the number line.

Example 1:

Input:
n = 8, k = 4
arr[] = {1, 2, 3, 4, 10, 11, 14, 15}
Output: 8
Explanation:
For maximum size subset, it is optimal to
choose the points on number line at 
coordinates 12, 13, 16 and 17, so that the
size of the consecutive valued subset will
become 8 which will be maximum.
Example 2:

Input:
n = 6, k = 5
arr[] = {7, 8, 12, 13, 15, 18}
Output: 10
Explanation:
For maximum size subset, it is optimal to choose
the points on number line at coordinates 9, 10, 
11, 14 and 16, so that the size of the consecutive 
valued subset will become 10 which will be maximum .
Your Task:
You don't need to read input or print anything. Your task is to complete the function maximiseSubset() which takes the array of integers arr, n and k as parameters and returns an integer denoting the answer.

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

Constraints:
1 <= n <= 106
1 <= k <= 105
1 <= arr[i] <= 106
*/

/*
The algorithm uses a sliding window approach to maximize the size of the subset. Here's the intuition behind it:

Initialization: Start with two pointers l and r at the beginning of the array. l represents the left boundary of the window, and r represents the right boundary.
Expand the window: Move r to the right until the number of points that can be placed between arr[l] and arr[r] (excluding arr[l] and arr[r]) is not greater than k. This ensures that the subset [arr[l], arr[r]] can have additional points placed between any two consecutive points.
Update the answer: Calculate the size of the current subset [arr[l], arr[r]] as r - l, and add k + 1 to account for the additional k points that can be placed between arr[l] and arr[r]. Update the answer with the maximum of the current subset size and the previous answer.
Slide the window: Increment l to shrink the window and repeat steps 2 and 3 until r reaches the end of the array.
Return the answer: The final answer represents the maximum size of the subset meeting the criteria.

*/

//{ Driver Code Starts
//Initial Template for Java




import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int k = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().maximiseSubset(arr, n, k);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java





class Solution {
    int maximiseSubset(int[] arr, int n, int k) {
        // code here
        int l=0, r=0, ans=k;
        
        while (r < n) {
 
            // increment l until the number of points 
            // that need to be placed between index l
            // and index r is not greater than k
            while ((arr[r] - arr[l]) - (r - l) > k) 
                l++;
         
            // update the solution as below
            ans = Math.max(ans, r - l + k + 1);
         
            r++;
        }
 
        return ans;
    }
}

