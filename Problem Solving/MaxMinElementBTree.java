/*
Given a Binary Tree, find maximum and minimum elements in it.

Example 1:

Input: 
           
Output: 11 1
Explanation:                           
 The maximum and minimum element in 
this binary tree is 11 and 1 respectively.
Example 2:

Input: 
           6
        / \
       5   8
      /
     2
Output: 8 2
Your Task:
You don't need to read input or print anything. Your task is to complete findMax() and findMin() functions which take root node of the tree as input parameter and return the maximum and minimum elements in the binary tree respectively.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)


Constraints:
1 <= Number of nodes <= 105
1 <= Data of a node <= 105
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
		    int mx = obj.findMax(root);
		    int mn = obj.findMin(root);
		    System.out.println(mx+" "+mn);
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
    public static int findMax(Node root){
        //code here
        
        if(root==null)
            return Integer.MIN_VALUE;
        int left=findMax(root.left);
        int right=findMax(root.right);
        int n=root.data;
        int temp=Math.max(left, right);
        n=Math.max(temp, n);
        return n;
    }
    public static int findMin(Node root){
        //code here
        
        if(root==null)
            return Integer.MAX_VALUE;
        int left=findMin(root.left);
        int right=findMin(root.right);
        int n=root.data;
        int temp=Math.min(left, right);
        n=Math.min(n, temp);
        return n;
    }
}
