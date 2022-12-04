/*
Given a binary tree of size N+1, your task is to complete the function tiltTree(), that return the tilt of the whole tree. The tilt of a tree node is defined as the absolute difference between the sum of all left subtree node values and the sum of all right subtree node values. Null nodes are assigned tilt to be zero. Therefore, tilt of the whole tree is defined as the sum of all nodes’ tilt.

Examples 1:

Input: 
       1
      / \
     2   3
Output: 1
Explanation:
Tilt of node 2 : 0
Tilt of node 3 : 0
Tilt of node 1 : |2-3| = 1
Tilt of binary tree : 0 + 0 + 1 = 1
Example 2:

Input:
        4 
       / \
      2   9 
     / \   \
    3   5   7 
Output: 15 
Explanation:
Tilt of node 3 : 0 
Tilt of node 5 : 0 
Tilt of node 7 : 0
Tilt of node 2 : |3-5| = 2 
Tilt of node 9 : |0-7| = 7 
Tilt of node 4 : |(3+5+2)-(9+7)| = 6 
Tilt of binary tree : 0 + 0 + 0 + 2 + 7 + 6 = 15
Your Task:
You don't need to read input or print anything. Your task is to complete the function tiltTree() which takes root node of the tree as input parameter and returns an integer denoting the tilt of the tree. If the tree is empty, return 0. 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)
Constraints:
1<=T<=100
0<=N<=500
*/

/*
The idea is to recursively traverse tree. While traversing, we keep track of two things, sum of subtree rooted under current node, tilt of current node. Sum is needed to compute tilt of parent. 
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
		    int res = obj.tiltTree(root);
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
class Res{
    int res;
}

class Solution{
    
    public int tiltTree(Node root){
        //code here
        Res res=new Res();
        abs(root, res);
        return res.res;
    }
    
    //traversing the tree to bottom
    //from there calculating left and right sums and absolutes
    private int abs(Node root, Res res){
        if(root==null)
            return 0;
        
        int left=abs(root.left, res);
        int right=abs(root.right, res);
        res.res+=Math.abs(left-right);
        
        //this takes care of return the sum left right at partiular subnode
        return left+right+root.data;
        
    }
}
