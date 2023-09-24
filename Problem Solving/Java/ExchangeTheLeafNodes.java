/*
Given a binary tree of size N, your task is to complete the function pairwiseSwap(), that swap leaf nodes in the given binary tree pairwise starting from from left to right.
Example 1:

Input: 


Output: 7 2 1 4 5 9 3 8 6 10 

Explanation:
The sequence of leaf nodes in original binary tree
from left to right is (4, 7, 8, 9, 10). Now if we 
try to form pairs from this sequence, we will have 
two pairs as (4, 7), (8, 9). The last node (10) is 
unable to form pair with any node and thus left unswapped
 

Example 2:

Input: 
          1
       /     \
      2       3
       \    /    \
        5  6      7
Output: 2 6 1 5 3 7
        1
     /     \
    2       3
     \    /   \
      6  5     7
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function pairwiseSwap() which takes root node of the tree as input parameter.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints:
1<=N<=103
1<=Data of a node <=103
*/

/*
The idea to solve this problem is to first traverse the leaf nodes of the binary tree from left to right. While traversing the leaf nodes, we maintain two pointers to keep track of first and second leaf nodes in a pair and a variable count to keep track of count of leaf nodes traversed. Now, if we observe carefully then we see that while traversing if the count of leaf nodes traversed is even, it means that we can form a pair of leaf nodes. To keep track of this pair we take two pointers firstPtr and secondPtr as mentioned above. Every time we encounter a leaf node we initialize secondPtr with this leaf node. Now if the count is odd, we initialize firstPtr with secondPtr otherwise we simply swap these two nodes. 
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
		    obj.pairwiseSwap(root);
		    inorder(root);
		    System.out.println();
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
}*/

class Solution {
    
    Node first;
    
    public void pairwiseSwap(Node root){
        //code here
        first=null;
        swap(root);
    }
    
    private void swap(Node root){
        if(root==null)
            return;
        
        if(root.left==null && root.right==null){
            if(first==null)
                first=root;
            else{
                int temp=root.data;
                root.data=first.data;
                first.data=temp;
                first=null;
            }
        }
        
        swap(root.left);
        swap(root.right);
    }
}
