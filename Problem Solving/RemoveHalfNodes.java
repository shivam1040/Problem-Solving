/*
Given A binary Tree. Your task is to remove all the half nodes (which has only one child).

Example 1:

Input:
         7
       /   \
      7     8
     / 
    2
Output: 2 7 8 
Example 2:

Input:
         2
       /   \
      7     5
       \      \
        9      1
       /  \
      11   4
Output: 11 9 4 2 1 
Your Task:
You don't need to read input or print anything. Your task is to complete the function RemoveHalfNodes() which takes the root node of the tree as input and returns the root node of the modified tree after removing all the half nodes, ie the ones having just a single child node. (The inorder traversal of the returned tree is printed by the driver's code.)
For example consider the below tree.


Nodes 7, 5 and 9 are half nodes as one of their child is Null. We need to remove all such half nodes and return the root pointer of following new tree.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Height of the Binary Tree).

Constraints:
1<=Number of nodes<=104
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
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
        	    Tree g = new Tree();
			    Node fresh = g.RemoveHalfNodes(root);
			    printInorder(fresh);
			    System.out.println();
                t--;
            
        }
    }
  
}


// } Driver Code Ends


//User function Template for Java


/*

class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}

*/

class Tree
{
    // Return the root of the modified tree after removing all the half nodes.
    public static Node RemoveHalfNodes(Node root)
    {
        // Code Here
        if(root==null)
            return root;
        if(root.left==null && root.right==null)
            return root;
            //here the idea is to check if a given node has both the left and right nodes or not. if not then return back the existing node so it can be further checked and traveresd down, leaf nodes are considered to be having both the child by default
        if(root.left==null)
            return RemoveHalfNodes(root.right);
        if(root.right==null)
            return RemoveHalfNodes(root.left);
        
        //this line takes care of arranging the tree and making it a full tree
        root.left= RemoveHalfNodes(root.left);
        root.right=RemoveHalfNodes(root.right);
        
        return root;
    }
}

