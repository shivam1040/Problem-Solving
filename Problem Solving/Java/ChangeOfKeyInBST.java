/*
Given a Binary Search Tree ,change old key value present in the tree to the given new key value.
Example 1:

Input: Root of below tree
              50
           /     \
          30      70
         /  \    /  \
       20   40  60   80 
     Old key value:  40
     New key value:  10

Output: BST should be modified to following
              50
           /     \
          30      70
         /       /  \
       20      60   80  
       /
     10
Your Task:
The task is to complete the function changeKey() which takes root, oldVal and newVal as the input argument, and returns the root of tree after changing the old value with new value in BST. The driver code will print the inorder traversal of the updated tree in output itself.

Expected Time Complexity: O(Height of tree)
Expected Auxiliary Space: O(1).

Constraints:
1<=Number of Nodes in tree<=500
*/

//{ Driver Code Starts
import java.util.Scanner;
import java.util.*;
import java.lang.*;
import java.io.*;

class Node
{
	int data;
	Node left,right;
	
	Node(int d)
	{
		data = d;
		left = right = null;		
	}
}

class BinarySearchTree
{
     
static Node buildTree(String str)
    {
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
    
         public static void main (String[] args) throws IOException
    {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            
            int t=Integer.parseInt(br.readLine());
            
            while(t > 0){
                String s = br.readLine();
                Node root = buildTree(s);
                String nums = br.readLine();
                String[] s1 = nums.split(" ");
                int oldKey=Integer.parseInt(s1[0]);
                int new_key=Integer.parseInt(s1[1]);

			GfG g=new GfG();
			root=g.changeKey(root,oldKey,new_key);
			inorder(root);
			System.out.println();
                t--;
        }
    }
    
  static void inorder(Node root)
    {
        if(root != null)
         {
        inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
         }
    }
    

}

// } Driver Code Ends


/* A binary search tree node class
class Node
{
	int data;
	Node left,right;
	
	Node(int d)
	{
		data = d;
		left = right = null;		
	}
} */
// your task is to complete the below function
class GfG
{
    public static Node changeKey(Node root, int old_key, int new_key)
    {
        // your code here
        //funda is delete node and insert node
        del(root, old_key);
        insert(root, new_key);
        return root;
    }
    
    private static Node del(Node root, int old){
        if(root==null)
            return root;
        if(old<root.data)
            root.left=del(root.left, old);
        else if(old>root.data)
            root.right=del(root.right, old);
        else{
            if(root.left==null)
                return root.right;
            else if(root.right==null)
                return root.left;
            root.data=min(root.right);
            root.right=del(root.right, root.data);
        }
        return root;
    }
    
   static int min(Node root){
       int a=0;
       while(root.left!=null){
           a=root.left.data;
         root=root.left;
       }
       return a;
   }
   
   static Node insert(Node root, int newX){
       if(root==null){
        Node temp=new Node(newX);
        return temp;
       }
       if(root.data>=newX)
        root.left=insert(root.left, newX);
        if(root.data<newX)
            root.right=insert(root.right, newX);
        return root;
   }
}
