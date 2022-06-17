/*
Given a binary tree of size N. Your task is to complete the function sumOfLongRootToLeafPath(), that find the sum of all nodes on the longest path from root to leaf node.
If two or more paths compete for the longest path, then the path having maximum sum of nodes is being considered.

Example 1:

Input: 
        4        
       / \       
      2   5      
     / \ / \     
    7  1 2  3    
      /
     6
Output: 13
Explanation:
        4        
       / \       
      2   5      
     / \ / \     
    7  1 2  3 
      /
     6

The highlighted nodes (4, 2, 1, 6) above are 
part of the longest root to leaf path having
sum = (4 + 2 + 1 + 6) = 13
Example 2:

Input: 
          1
        /   \
       2     3
      / \   / \
     4   5 6   7
Output: 11
Your Task:
You don't need to read input or print anything. Your task is to complete the function sumOfLongRootToLeafPath() which takes root node of the tree as input parameter and returns an integer denoting the sum of the longest root to leaf path of the tree. If the tree is empty, return 0.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

Constraints:
1 <= Number of nodes <= 104
1 <= Data of a node <= 104
*/

// { Driver Code Starts
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
		    int res = obj.sumOfLongRootToLeafPath(root);
		    System.out.println(res);
		}
	}
}// } Driver Code Ends


//User function Template for Java

/*
node class of binary tree
class Node {
    int data;
    Node left, right;
    
    public Node(int data){
        this.data = data;
    }
}
*/
class Res{
    int sum;
    int max;
    int maxLevel;
}
class Solution{
    public int sumOfLongRootToLeafPath(Node root)
    {
        List<Integer> aux=new ArrayList<Integer>();
        Res res=new Res();
        res.max=Integer.MIN_VALUE;
        //path(root, res, aux, 0);
        path2(root, res, 0, 0);
        return res.max;
    }
    
    //method1
    private void path(Node root, Res res, List<Integer> aux, int level){
        if(root==null)
            return;
        aux.add(root.data);
        if(root.left==null && root.right==null){
            if(res.maxLevel<=level){
                res.maxLevel=level;
            for(int i:aux){
                res.sum+=i;
            }
            if(res.sum>res.max)
                res.max=res.sum;
            res.sum=0;
            }
        }
        else{ //this block only executes if left & right are not null to ensure at every leaf data is added to aux
            path(root.left, res, aux, level+1);
            path(root.right, res, aux, level+1);
        }
        aux.remove(aux.size()-1); //removing last element everytime a new addition is done to res, to ensure immediate node data is not present in aux when going back
    }
    
    //method2
    private void path2(Node root, Res res, int level, int sum){
        if(root==null){ //checking only when root is null which means leaf node
            if(res.maxLevel<=level){ //ensuring the max level of tree
                res.maxLevel=level;
                if(sum>res.max)
                    res.max=sum;
            }
            return;
        }
        path2(root.left, res, level+1, sum+root.data); //recursing level by level, adding data at current level to sum
        path2(root.right, res, level+1, sum+root.data);
    }
}