/*
Given a Binary Tree of size N, your task is to complete the function rightLeafSum(), which should return the sum of all the leaf nodes that are the right child of their parent of the given binary tree.
Example 1:

Input :
         52
        /    \
      12      55
     /  \     /  \
    83   6   17  82
   /    /  \   
  56   61  35
Output :
117
Explanation:
All the right leaf nodes
presents are 35, 82 which
sums up to 117
Example 2:

Input:
         12
        /  \    
     20     30
    /  \     /
  40   60  90

Output:
60

Explanation:
The only right leaf node is present is 60
Constraints:
1<=T<=100
1<=N<=100
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
    static void printInorder(Node root){
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
	    	
            Solution ob = new Solution();
    		System.out.println(ob.rightLeafSum(root));
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Res{
    int res;
}

class Solution
{
    int rightLeafSum(Node root)
    {
        // code here
        Res res=new Res();
        sum(root, res, -1);
        return res.res;
    }
    
    void sum(Node root, Res res, int trigger){
        if(root==null)
            return;
        if(root.left==null && root.right==null && trigger==1)
            res.res+=root.data;
        sum(root.left, res, 0);
        sum(root.right, res, 1);
    }
}
