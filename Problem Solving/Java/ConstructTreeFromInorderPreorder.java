/*
Given two arrays of inorder and preorder traversal of size n. Construct a tree using the inorder and preorder arrays and return the root node of the constructed tree.

Example 1:

Input:
n = 4
inorder[] = {1 6 8 7}
preorder[] = {1 6 7 8}
Output: 8 7 6 1
Example 2:

Input:
n = 6
inorder[] = {3 1 4 0 5 2}
preorder[] = {0 1 3 4 2 5}
Output: 3 4 1 5 2 0
Explanation: The tree will look like
       0
    /     \
   1       2
 /   \    /
3    4   5
Your Task:
Your task is to complete the function buildTree() which takes 3 arguments(inorder traversal array, preorder traversal array, and size of tree n) and returns the root node to the tree constructed. You are not required to print anything and a new line is added automatically (The post order of the returned tree is printed by the driver's code.)

Expected Time Complexity: O(n*n).
Expected Auxiliary Space: O(n).

Constraints:
1<= n <=1000
inorder and preorder arrays contain unique values
*/

/*
https://www.youtube.com/watch?v=aZNaLrVebKQ
*/

//{ Driver Code Starts
import java.util.*;
import java.io.*;
class Node
{
    int data; 
    Node left, right;
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}

class GFG
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node root = null;
            int inorder[] = new int[n];
            int preorder[] = new int[n];
            for(int i = 0; i < n; i++)
              inorder[i] = sc.nextInt();
              
            for(int i = 0; i < n; i++)
              preorder[i] = sc.nextInt();
              
            Solution ob = new Solution();
            root = ob.buildTree(inorder, preorder, n);
            postOrdrer(root);
            System.out.println();
        }
    }
    
    public static void postOrdrer(Node root)
    {
        if(root == null)
          return;
          
        postOrdrer(root.left);
        postOrdrer(root.right);
        System.out.print(root.data + " ");
    }
}
// } Driver Code Ends


class Solution
{
    public static Node buildTree(int inorder[], int preorder[], int n)
    {
        // code here 
        Map<Integer, Integer> inMap=new HashMap<>();
        
        for(int i=0; i<inorder.length; i++)
            inMap.put(inorder[i], i);
        return build(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, inMap);
    }
    
    public static Node build(int[] preorder, int preStart, int preEnd,
    int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inMap){
        if(preStart>preEnd || inStart>inEnd)
            return null;
        Node root=new Node(preorder[preStart]);
        int inRoot=inMap.get(root.data);
        int numsLeft=inRoot-inStart;
        root.left=build(preorder, preStart+1, preStart+numsLeft, inorder, inStart, inRoot-1, inMap);
        root.right=build(preorder, preStart+numsLeft+1, preEnd, inorder, inRoot+1, inEnd, inMap);
        
        return root;
    }
}

