/*
Given a Binary Tree, write a function to check whether the given Binary Tree is a prefect Binary Tree or not. A Binary tree is Perfect Binary Tree in which all internal nodes have two children and all leaves are at same level.

Example 1:

Input: 
          7
      /  \
     4    9
Output: YES
Explanation: 
As the root node 7 has two children and 
two leaf nodes 4 and 9 are at same level 
so it is a perfect binary tree.
Example 2:

Input: 
                   7
              /   \
             3     8
           /   \     \
          2     5     10
        /
       1
Output: NO
Your task:

You don't need to read input or print anything. Your task is to complete the function isPerfect() which takes root node of the tree as input parameter and returns a boolean value.If the tree is a perfect binary tree return true other wise return false.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

Constraints:
1<=T<=10^5
1<=N<=10^5
1<=data of node<=10^5
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
		    boolean res = obj.isPerfect(root);
		    if(res) {
		        System.out.println("YES");
		    } else {
		        System.out.println("NO");
		    }
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
    public boolean isPerfect(Node root){
        //code here
        int depth=depth(root);
        return check(root, depth, 0);
    }
    
    private int depth(Node root){
        int depth=0;
        
        while(root!=null){
            depth++;
            root=root.left;
        }
        return depth;
    }
    
    private boolean check(Node root, int depth, int level){
        //empty tree always balanced
        if(root==null)
            return true;
        //all leaves at same depth
        if(root.left==null && root.right==null)
            return depth==(level+1);
        //in between leaves and root, every branch is not null
        if(root.left==null || root.right==null)
            return false;
        boolean left=check(root.left, depth, level+1);
        boolean right=check(root.right, depth, level+1);
        return left && right;
    }
}
