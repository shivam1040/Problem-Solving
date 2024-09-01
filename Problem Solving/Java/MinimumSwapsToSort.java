/*
Given an array of n distinct elements. Find the minimum number of swaps required to sort the array in strictly increasing order.


Example 1:

Input:
nums = {2, 8, 5, 4}
Output:
1
Explanation:
swap 8 with 4.
Example 2:

Input:
nums = {10, 19, 6, 3, 5}
Output:
2
Explanation:
swap 10 with 3 and swap 19 with 5.

Your Task:
You do not need to read input or print anything. Your task is to complete the function minSwaps() which takes the nums as input parameter and returns an integer denoting the minimum number of swaps required to sort the array.
If the array is already sorted, return 0. 


Expected Time Complexity: O(nlogn)
Expected Auxiliary Space: O(n)


Constraints:
1 ≤ n ≤ 105
1 ≤ numsi ≤ 106


*/

/*
Intuition
This can be easily done by visualizing the problem as a graph. We will have N nodes and an edge directed from node i to node j if the element at the i’th index must be present at the j’th index in the sorted array.


 
The graph will now contain many non-intersecting cycles. Now a cycle with 2 nodes will only require 1 swap to reach the correct ordering, similarly, a cycle with 3 nodes will only require 2 swaps to do so. 


Hence, ans = Σi = 1k(cycle_size – 1), where k is the number of cycles

Implementation
Create a vector of pairs curr to store the input array elements along with their index
Sort curr and run a loop for i [0, N]
If the current element is already visited or it is at its correct position then continue
Else calculate the cycle size from the current element using a while loop
Declare an integer j equal to i and in the while loop set j equal to the index of curr[j] and increase cycle size while the element at jth position is not visited
Increase the answer by the size of the current cycle – 1 if the cycle size is more than 1.
Return answer

*/

//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[] nums = new int[n];
            String[] S = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(S[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minSwaps(nums);
            System.out.println(ans);
       }
    }
}
// } Driver Code Ends




class Solution
{
    //Function to find the minimum number of swaps required to sort the array.
    public int minSwaps(int nums[])
    {
        // Code here
        int ans=0;
        ArrayList<Pair> b=new ArrayList<>();
        Comparator<Pair> comparator = new Comparator<Pair>() {
            @Override
            public int compare(Pair p1, Pair p2) {
                return Integer.compare(p1.first, p2.first);
            }
        };
        boolean[] vis=new boolean[nums.length];
        
        for(int i=0; i<nums.length; i++)
            b.add(new Pair(nums[i], i));
        b.sort(comparator);
        for(int i=0; i<nums.length; i++)
            if(!vis[i]){
                int c=0;
                int j=i;
                
                while(!vis[j]){
                    vis[j]=true;
                    j=b.get(j).second;
                    c++;
                }
                ans+=(c-1);
            }
        return ans;
    }
    
    private static class Pair{
        int first;
        int second;
        
        Pair(int first, int second){
            this.first=first;
            this.second=second;
        }
    }
}
