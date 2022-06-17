/*
Given the binary Tree of and two-node values. Check whether the two-node values are cousins of each other or not.

Example 1:

Input:
      1
    /   \
   2     3
a = 2, b = 3
Output: 0

Example 2:

Input:
       1
     /   \ 
    2     3
   /       \
  5         4 
a = 5, b = 4
Output: 1
Explanation: Here, nodes 5 and 4 are
at the same level and have different
parent nodes. Hence, they both are cousins 

Your Task:
You don't need to read input or print anything. Your task is to complete the function isCousins() that takes the root node of the tree (having all nodes distinct), and two integers 'a' and 'b' as inputs. It returns true if the nodes with given values 'a' and 'b' are Cousins of each other and returns false otherwise. 
Two nodes value are cousins of each other if they are at the same level and have different parents. (The driver code will print 1 if the returned values is true,otherwise 0.)

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Height of the Tree).

Constraints:
1<=Number of Nodes<=1000
*/

// { Driver Code Starts
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
    
	public static void main (String[] args) throws Exception{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
            //Scanner sc = new Scanner(System.in);
	        while(t > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
        	    Solution g = new Solution();
        	    String X = br.readLine();
        	    String arr[] = X.split(" ");
        	    int x , y;
			    x = Integer.parseInt(arr[0]);
			    y = Integer.parseInt(arr[1]);
			    if(g.isCousins(root,x,y))
			        System.out.println(1);
			     else
			        System.out.println(0);
                t--;
            
        }
    }
  
}

// } Driver Code Ends


/*
Node is as follows:
class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
*/
//User function Template for Java

class Solution {
    
    // Returns true if the nodes with values 'a' and 'b' are cousins. Else returns false
    public boolean isCousins(Node root, int a, int b) {
        // your code here
        // This function should return true if x and y are cousins, else return false
        Res res=new Res();
        return check(root, res, 1, a, b)==1 ? true : false;
    }
    
class Res{
    int ap, al, bp, bl;
}
    
    private int check(Node root, Res res, int level, int a, int b){
        if(root==null)
            return 0;
        int parent=root.data;
        if(root.left!=null && (root.left.data==a || root.left.data==b)){
            if(root.left.data==a){
                res.ap=parent;
                res.al=level;
            }
            else{
                res.bp=parent;
                res.bl=level;
            }
        }
        else if(root.right!=null && (root.right.data==a || root.right.data==b)){
            if(root.right.data==a){
                res.ap=parent;
                res.al=level;
            }
            else{
                res.bp=parent;
                res.bl=level;
            }
        }
        check(root.left, res, level+1, a, b);
        check(root.right, res, level+1, a, b);
        if(res.ap>0 && res.bp>0 && res.ap!=res.bp && res.al==res.bl)
            return 1;
        return 0;
    }

}