/*
Given a non-empty array of integers, find the top k elements which have the highest frequency in the array. If two numbers have the same frequency then the larger number should be given preference. 

Note: Print the elements according to the frequency count (from highest to lowest) and if the frequency is equal then larger number will be given preference.

Example 1:

Input:
N = 6
nums = {1,1,1,2,2,3}
k = 2
Output: {1, 2}
Example 2:

Input:
N = 8
nums = {1,1,2,2,3,3,3,4}
k = 2
Output: {3, 2}
Explanation: Elements 1 and 2 have the
same frequency ie. 2. Therefore, in this
case, the answer includes the element 2
as 2 > 1.
User Task:
The task is to complete the function topK() that takes the array and integer k as input and returns a list of top k frequent elements.

Expected Time Complexity : O(NlogN)
Expected Auxilliary Space : O(N)

Constraints:
1 <= N <= 105
1<=A[i]<=105
*/

//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(s[i + 1]);
            }
            int k = Integer.parseInt(br.readLine().trim());
            Solution obj = new Solution();
            int[] ans = obj.topK(nums, k);
            for (int i = 0; i < ans.length; i++) System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    public int[] topK(int[] nums, int k) {
        // Code here
        Map<Integer, Integer> aux=new HashMap<Integer, Integer>();
        for(int i:nums){
            aux.put(i, aux.getOrDefault(i, 0)+1);
        }
        
        PriorityQueue<Map.Entry<Integer, 
                                Integer>> queue
            = new PriorityQueue<>((a, b)
                -> a.getValue().equals(b.getValue())
                   ? Integer.compare(b.getKey(),
                                     a.getKey())
                   : Integer.compare(b.getValue(),
                                     a.getValue()));
        for (Map.Entry<Integer, Integer> entry :
             aux.entrySet())
            queue.offer(entry);
        
        int res[]=new int[k];
        
        for (int i = 0; i < k; i++) 
            res[i]=queue.poll().getKey();
        return res;
    }
}
