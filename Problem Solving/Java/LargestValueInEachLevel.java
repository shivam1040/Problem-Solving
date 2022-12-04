/*
Given a binary tree, find the largest value in each level.

Example 1:

Input :
        1
       / \
      2   3 

Output : 1 3
Explanation : 
There are two levels in the tree :
1. {1}, max = 1
2. {2, 3}, max = 3
Example 2:

Input :
        4
       / \
      9   2
     / \   \
    3   5   7 

Output : 4 9 7
Explanation : 
There are three levels in the tree:
1. {4}, max = 4
2. {9, 2}, max = 9
3. {3, 5, 7}, max=7
Your task :
You don't need to read input or print anything. Your task is to complete the function largestValues() which takes the root node of the tree as input and returns a vector containing the largest value in each level. 
 
Expected Time Complexity : O(n) , where n = number of nodes
Expected Auxiliary Space : O(n) , where n = number of nodes
 
Constraints : 
1 ≤ Number of nodes ≤ 10^5
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
    	    	
                Solution g = new Solution();
               ArrayList<Integer> ans = g.largestValues(root);
               
                for(int i=0;i<ans.size();i++)
                    System.out.print(ans.get(i)+" ");
                    
                System.out.println();
        	
                t--;
            
        }
    }
}



// } Driver Code Ends


//User function Template for Java

class Solution
{
    
    public ArrayList<Integer> largestValues(Node root)
    {
        //code here
        TreeMap<Integer, Integer> aux=new TreeMap<>();
        ArrayList<Integer> res=new ArrayList<>();
        
        largest(root, aux, 0);
        for (Map.Entry<Integer, Integer> entry : aux.entrySet())
            res.add(entry.getValue());
        return res;
    }
    
    private void largest(Node root, TreeMap<Integer, Integer> aux, int level){
        if(root==null)
            return;
        largest(root.left, aux, level+1);
        if(aux.containsKey(level)){
            int node=aux.get(level);
            if(node<root.data)
                aux.put(level, root.data);
        }
        else
            aux.put(level, root.data);
        largest(root.right, aux, level+1);
    }
}
