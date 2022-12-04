/*
Given a sorted array. Convert it into a Height balanced Binary Search Tree (BST). Find the preorder traversal of height balanced BST. If there exist many such balanced BST consider the tree whose preorder is lexicographically smallest.
Height balanced BST means a binary tree in which the depth of the left subtree and the right subtree of every node never differ by more than 1.

Example 1:

Input: nums = {1, 2, 3, 4}
Output: {2, 1, 3, 4}
Explanation: 
The preorder traversal of the following 
BST formed is {2, 1, 3, 4}:
           2
         /   \
           1     3
               \
                4
 

Example 2:

Input: nums = {1,2,3,4,5,6,7}
Ouput: {4,2,1,3,6,5,7}
Explanation: 
The preorder traversal of the following
BST formed is {4,2,1,3,6,5,7} :
        4
       / \
      2   6
     / \  / \
    1   3 5  7
 

Your Task:
You don't need to read or print anything. Your task is to complete the function sortedArrayToBST() which takes the sorted array nums as input paramater and returns the preorder traversal of height balanced BST. If there exist many such balanced BST consider the tree whose preorder is lexicographically smallest.

Expected Time Complexity: O(n)
Expected Space Complexity: O(n)

Constraints:
1 ≤ |nums| ≤ 104
-104 ≤ nums[i] ≤ 104
*/

//{ Driver Code Starts
//Initial Template for Java

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
            int[] ans = obj.sortedArrayToBST(nums);
            for(int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Node{
    int data;
    Node left, right;
    
    Node(int data){
        this.data=data;
        left=right=null;
    }
}

class Solution
{
    Node root;
    int i;
    
    public int[] sortedArrayToBST(int[] nums)
    {
        // Code here
        root=arrayToBST(nums, 0, nums.length-1);
        preOrder(root, nums);
        return nums;
    }
    
    private Node arrayToBST(int [] nums, int start, int end){
        if(start>end)
            return null;
        
        int mid=(start+end)/2;
        Node node=new Node(nums[mid]);
        
        node.left=arrayToBST(nums, start, mid-1);
        node.right=arrayToBST(nums, mid+1, end);
        return node;
    }
    
    private void preOrder(Node node, int nums[]) {
        if (node == null) {
            return;
        }
        nums[i++]=node.data;
        preOrder(node.left, nums);
        preOrder(node.right, nums);
    }
}
