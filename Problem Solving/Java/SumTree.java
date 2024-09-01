/*
Given a Binary Tree. Return true if, for every node X in the tree other than the leaves, its value is equal to the sum of its left subtree's value and its right subtree's value. Else return false.

An empty tree is also a Sum Tree as the sum of an empty tree can be considered to be 0. A leaf node is also considered a Sum Tree.


Example 1:

Input:
    3
  /   \    
 1     2

Output: 1
Explanation:
The sum of left subtree and right subtree is
1 + 2 = 3, which is the value of the root node.
Therefore,the given binary tree is a sum tree.
Example 2:

Input:

          10
        /    \
      20      30
    /   \ 
   10    10

Output: 0
Explanation:
The given tree is not a sum tree.
For the root node, sum of elements
in left subtree is 40 and sum of elements
in right subtree is 30. Root element = 10
which is not equal to 30+40.

Your Task: 
You don't need to read input or print anything. Complete the function isSumTree() which takes root node as input parameter and returns true if the tree is a SumTree else it returns false.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(Height of the Tree)


Constraints:
1 ≤ number of nodes ≤ 104
*/

/*
Intuition
A sum tree is defined such that for every node other than leaves, its value is equal to the sum of its left subtree's value and its right subtree's value. The given problem involves checking whether a given binary tree is a sum tree or not. This can be achieved by recursively checking each node's value against the sum of its left and right subtrees.

Implementation
Check Leaf Node:
Define a helper function isLeaf to check if a given node is a leaf node. This is important since leaf nodes are considered valid sum trees by definition.
Recursive Approach:
Define the main function isSumTree that takes the root node as input.
Base cases:
If the root is None or a leaf node, return 1 (indicating a valid sum tree).
Recursively call isSumTree for both the left and right subtrees.
Calculate the sum of the left and right subtrees' values.
Check if the root node's value equals the sum of its left and right subtrees' values.
If the equality holds and both recursive calls return 1, return 1. Otherwise, return 0.
*/

//{ Driver Code Starts
//Initial Template for Java

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GfG {
    
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
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
        	    Solution g = new Solution();
			
			    if(g.isSumTree(root) == true)
    			    System.out.println(1);
    			else 
    			    System.out.println(0);
                t--;
            
        }
    }
  
}


// } Driver Code Ends


/* A Binary Tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/
class Solution
{
	boolean isSumTree(Node node)
	{
             // Your code here
             int l=0, r=0;
             
             if(node==null || isLeaf(node))
                return true;
             if(isSumTree(node.left) && isSumTree(node.right)){
                if(node.left == null)
                    l=0;
                else if(isLeaf(node.left))
                    l=node.left.data;
                else
                    l=2*node.left.data;
                if(node.right==null)
                    r=0;
                else if(isLeaf(node.right))
                    r=node.right.data;
                else
                    r=2*node.right.data;
             }
                         if(node.data==l+r)
                return true;
            else
             return false;
	}
	
	private boolean isLeaf(Node node){
	    return node.left==null && node.right==null;
	}
}

