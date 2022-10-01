/*
There are n trees in a forest. The heights of the trees is stored in array tree[], where tree[i] denotes the height of the ith tree in the forest. If the ith tree is cut at a height H, then the wood collected is tree[i] - H, provided tree[i] > H. If the total woods that needs to be collected is exactly equal to k, find the height H at which every tree should be cut (all trees have to be cut at the same height). If it is not possible then return -1 else return H.

Example 1:

Input:
n = 5, k = 4
nums[] = {2, 3, 6, 2, 4}
Output: 3
Explanation: Wood collected by cutting trees
at height 3 = 0 + 0 + (6-3) + 0 + (4-3) = 4
hence 3 is to be subtracted from all numbers.
Since 2 is lesser than 3, nothing gets
subtracted from it.
Example 2:

Input:
n = 6, k = 8
nums[] = {1, 7, 6, 3, 4, 7}
Output: 4
Explanation: Wood collected by cutting trees
at height 4 = 0+(7-4)+(6-4)+0+0+(7-4) = 8
Your Task:
Your task is to complete the function find_height(). This function takes the array tree[ ], and the integers n and k as input parameters and returns the height at which trees have to be cut. If no positive integer value of height is possible, return -1.


Expected Time Complexity: O(n log h)
Expected Auxiliary Space: O(1)


Constraints: 
1 <= n <= 104
1 <= tree[i] <= 103
1 <= k <= 107
*/

/*
Sort the heights of the trees.
The lowest height to make the cut is 0 and the highest height is the maximum height among all the trees. So, set low = 0 and high = max(height[i]).
Repeat the steps below while low ≤ high: 
Set mid = low + ((high - low) / 2).
Count the amount of wood that can be collected if the cut is made at height mid and store it in a variable collected.
If collected = K then mid is the answer.
If collected > K then update low = mid + 1 as the cut needs to be made at a height higher than the current height.
Else update high = mid - 1 as cuts need to be made at a lower height.
Print -1 if no such value of mid is found.
*/
//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GfG
{
    public static void main (String[] args)
	{
        Scanner in = new Scanner(System.in);
        
        int t = in.nextInt();
        while(t-->0)
        {
            int n = in.nextInt();
            
            int tree[]= new int[n];
            for(int i=0; i<n; i++)
                tree[i] = in.nextInt();
            int k = in.nextInt();
            
            Solution x = new Solution();
            System.out.println( x.find_height(tree,n,k) );
        }
	}
}
// } Driver Code Ends


class Solution
{
    static int find_height(int tree[], int n, int k)
    {
        Arrays.sort(tree);
        //minimum and maximum cut that can be made
        int low=0, high=tree[n-1];
        
        while(low<=high){
            int mid=low+((high-low)/2);
            int collected=woodCollected(tree, mid);
            
            if(collected==k)
                return mid;
                // If it is more than the required amount 
            // then the cut needs to be made at a 
            // height higher than the current height 
            if(collected>k)
                low=mid+1;
                // Else made the cut at a lower height
            else
                high=mid-1;
        }
        return -1;
        
    }
    
    static int woodCollected(int tree[], int cut){
        int sum=0;
        for(int i: tree){
            if(i-cut>=0){
                sum+=i-cut;
            }
        }
        return sum;
    }
}
