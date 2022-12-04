/*
Given a Binary tree. Find the level in binary tree which has the maximum number of nodes.

Example 1:

Input:
      2
    /    \ 
   1      3
 /   \     \
4    6      8
     / 
    5
Output: 2
Explanation: The level 2 with nodes 4,
6 and 8 is the level with maximum
number of nodes. 

Your Task:
You don't need to read input or print anything. Your task is to complete the function maxNodeLevel() that takes root node of the tree as input and returns an integer which is level of the tree with maximum nodes. The root is at level 0. If two or more levels have same number of maximum nodes , then return smallest level.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
1<=Number of level<=10
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
			    int ans = g.maxNodeLevel(root);
			    System.out.println(ans);
                t--;
            
        }
    }
  
}


// } Driver Code Ends


/*Complete the function below
Node is as follows:
class Node{
	int data;
	Node left,right;
	
	Node(int item)
	{
	    data = item;
	    left = right = null;
	}
}
*/
class Tree
{
    // Return the level (0-indexed) with maximum number of nodes.
    public static int maxNodeLevel(Node root)
    {
        // add your code here
        Map<Integer, Integer> aux=new HashMap<>();
        int max=Integer.MIN_VALUE, res=0;
        
        level(root, 0, aux);
        for(Map.Entry<Integer, Integer> i:aux.entrySet()){
            if(i.getValue()>max){
                max=i.getValue();
                res=i.getKey();
            }
        }
        return res;
    }
    
    private static void level(Node root, int level, Map<Integer, Integer> aux){
        if(root==null)
            return;
        aux.put(level, aux.getOrDefault(level, 0)+1);
        level(root.left, level+1, aux);
        level(root.right, level+1, aux);
    }
}
