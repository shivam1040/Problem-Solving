/*
Given a Binary Tree of size N, your task is to complete the function deletionBT(), that should delete a given node from the tree by making sure that tree shrinks from the bottom (the deleted node is replaced by bottommost and rightmost node).
Example:

Eample Deletion in Bt


Your Task:
You don't have to take input. Complete the function deletionBT() that takes root node of the tree and given node value (Key) as input parameter and return the root of the modified tree.

Example 1:
 

Input:
Key=1
         1
       /   \
      4     7
     / \
    5   6 
Output:
5 4 6 7 

Explanation:
Modified Tree after deletion the 
node with key = 1
     6 
    /  \
   4    7
  /   
 5     
The Inorder traversal of the modified 
tree is 5 4 6 7 


Constraints:
1<=N<=104
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
    
	        while(t > 0)
	        {
	            String arr[] = br.readLine().split(" ");
	            int key = Integer.parseInt(arr[0]);
	            String s = br.readLine();
    	    	Node root = buildTree(s);
    	    	
                Solution g = new Solution();
        		g.deletionBT(root,key);
        		printInorder(root);
        		System.out.println();
                    t--;
            
        }
    }
}



// } Driver Code Ends


/*
Node class is as follows:

class Node {
    int data;
    Node left, right;
    
    public Node(int data){
        this.data = data;
    }
}
*/
class Solution {
    
    public Node deletionBT(Node root, int key){
        //Write your code here and return the root of the changed tree
        ArrayList <Integer> res=new ArrayList <Integer>();
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {
 
            /* poll() removes the present head.
            For more information on poll() visit
            http://www.tutorialspoint.com/java/
            util/linkedlist_poll.htm */
            Node tempNode = queue.poll();
            res.add(tempNode.data);
 
            /*Enqueue left child */
            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }
 
            /*Enqueue right child */
            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
        delete(root, key, res.get(res.size()-1));
        return root;
        
    }
    
    private void delete(Node root, int key, int rep){
         if(root==null)
        return;
    if(root.data==key){
        root.data=rep;
    }
    if(root.left!=null && root.left.data==rep){ root.left=null; }
        if(root.right!=null && root.right.data==rep){ root.right=null; }
    delete(root.left, key, rep);
    delete(root.right, key, rep);
    }
}
