/*
Given a Binary Tree of size N, find the sum of all the leaf nodes that are at minimum level of the given binary tree.
Example 1:

Input: 
         1
        /  \
       2    3
     /  \     \
    4    5     8 
  /  \ 
 7    2      
Output:
sum = 5 + 8 = 13
Example 2:

Input: 
            1
      /    \
     2      3
    / \    / \
   4   5  6   7
Output: 22
Your Task:
You don't need to read input or print anything. Your task is to complete the function minLeafSum() which takes root node of the tree as input parameter and returns an integer denoting the sum of all the leaf nodes that are at minimum level of the given binary tree. If the tree is empty, return 0. 
 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)


Constraints:
1<=N<=103
1<=data on node<=103
*/

/*
Perform iterative level order traversal using queue and find the first level containing a leaf node. Sum up all the leaf nodes at this level and then stop performing the traversal further.
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
		    int res = obj.minLeafSum(root);
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
class Solution{
     public int minLeafSum(Node root){
        //code here
        Queue<Node> aux=new LinkedList<>();
        int res=0;
        boolean found=false;
        aux.add(root);
        
        while(!found){
            int count=aux.size();
            while(count-- > 0){
                Node ele=aux.poll();
                if(ele.left==null && ele.right==null){
                    res+=ele.data;
                    found=true;
                }
                else{
                    if(ele.left!=null)
                        aux.add(ele.left);
                    if(ele.right!=null)
                        aux.add(ele.right);
                }
            }
        }
        return res;
    }
}
