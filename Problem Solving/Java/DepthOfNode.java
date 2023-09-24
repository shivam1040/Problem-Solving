/*
Given a binary tree, find the depth of the deepest odd level leaf node in a binary tree. If there is no leaf at odd level then return 0.
Consider that level starts with 1. Depth of a leaf node is number of nodes on the path from root to leaf (including both leaf and root).

Example 1:

Input: 
          1
        /    \
       2      3
      / \    / \
     4   5  6   7
Output: 3
Explanation: In the above tree 4,5,6 and 7 are
odd level leaf nodes at depth 3.So the answer is 3.
Example 2:

Input: 
     1
    / \
    2   4
Output: 0
Your task:

You don't need to read input or print anything. Your task is to complete the function depthOfOddLeaf() which takes root node of the tree as input parameter and returns an integer denoting the maximum depth of a odd level leaf node of the tree. If there is no such leaf node return 0.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

Constraints:
1<=T<=1000
1<=n<=1000
1<=data of node<=1000
*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*; 


class Node {
    int data;
    Node left, right;
    
    public Node(int data){
        this.data = data;
    }
}

class GFG {
    
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    public static void inorder(Node root){
        if(root == null)
            return;
        
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
		while(t-- > 0){
		    String s = br.readLine();
	    	Node root = buildTree(s);
		    Solution obj = new Solution();
		    int res = obj.depthOfOddLeaf(root);
		    System.out.println(res);
		}
	}
}
// } Driver Code Ends


//User function Template for Java

/*
class Node {
    int data;
    Node left, right;
    
    public Node(int data){
        this.data = data;
    }
}
*/
class Solution{
    static int count;
    
    public static int depthOfOddLeaf(Node root)
    {
        //code here
        count=0;
        depth(root, 1);
        return count;
    }
    
    private static void depth(Node root, int level){
        if(root==null)
            return;
        depth(root.left, level+1);
        if(level%2!=0 && root.left==null && root.right==null)
            count=Math.max(level, count);
        depth(root.right, level+1);
    }
}
