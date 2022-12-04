/*
Given a Binary Tree. Check whether the Binary tree is a full binary tree or not.

Example 1:

Input:
          1
       /    \
      2      3
    /   \
   4     5
Output: 1
Explanation: Every node except leaf node
has two children so it is a full tree.
Example 2:

Input:
          1
       /    \
      2      3
    /   
   4     
Output: 0
Explanation: Node 2 has only one child
so this is not a full tree.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function isFullTree() which takes the root node of the tree as input and returns True if the given Binary Tree is full. Else, it returns False. (The driver code will print 1 if the returned value is true, otherwise 0).

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Height of the Tree).

Constraints:
1<=Number of nodes<=1000

Note:The Input/Ouput format and Example given are used for system's internal purpose, and should be used by a user for Expected Output only. As it is a function problem, hence a user should not read any input from stdin/console. The task is to complete the function specified, and not to write the full code.
*/

/*
To check whether a binary tree is a full binary tree we need to test the following cases:-

If a binary tree node is NULL then it is a full binary tree. 
If a binary tree node does have empty left and right sub-trees, then it is a full binary tree by definition. 
If a binary tree node has left and right sub-trees, then it is a part of a full binary tree by definition. In this case recursively check if the left and right sub-trees are also binary trees themselves. 
In all other combinations of right and left sub-trees, the binary tree is not a full binary tree.

*/

//{ Driver Code Starts
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

class Tree {
    
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
    	    	
                GfG g = new GfG();
        		if(g.isFullTree(root))
			    	System.out.println("1");
			    else
			    	System.out.println("0"); 
                t--;
            
        }
    }
}



// } Driver Code Ends


/*Complete the function below
Node is as follows:
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
class GfG
{
    // Return True if the given Binary Tree is a Full Binary Tree. Else return False
	boolean isFullTree(Node node)
    {
        //add code here.
        if(node==null)
            return true;
        if(node.left==null && node.right==null)
            return true;
        if(node.left!=null && node.right!=null){
            boolean left=isFullTree(node.left); //checking the entire subtree if it is not null
            boolean right=isFullTree(node.right);
            return left && right;
        }
        return false;
    }
}
