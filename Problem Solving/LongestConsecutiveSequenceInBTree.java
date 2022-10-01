/*
Given a Binary Tree find the length of the longest path which comprises of connected nodes with consecutive values in increasing order. 

 

Example 1:

Input :      
           1                               
         /   \                          
        2     3                      

Output: 2

Explanation : Longest sequence is 1, 2.

 

Example 2:

Input :    
            10                               
         /     \                          
       20       30                      
      /  \      /
     40      60   90    

Output :  -1

Explanation: For the above test case no 
sequence is possible. So output is -1.
 

Your Task:  
You dont need to read input or print anything. Complete the function longestConsecutive() which takes root node as input parameter and returns the length of the longest consecutive increasing sequence (of at least length 2) in the given Binary Tree. If such a sequence does not exist, return -1.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(Height of Tree)


Constraints:
1 ≤ N ≤ 10^3
*/

//{ Driver Code Starts
import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node
{
    int data;
    Node left;
    Node right;
    Node(int data)
    {
        this.data = data;
        left=null;
        right=null;
    }
}

class Main
{
    static Node buildTree(String str)
    {
        
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
    
    public static void main (String[] args) throws IOException
    {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t=Integer.parseInt(br.readLine());
        
        while(t-- > 0)
        {
            String s = br.readLine();
            Node root = buildTree(s);
            
            Solution g = new Solution();
            System.out.println(g.longestConsecutive(root));
        }
	}
}


// } Driver Code Ends


/*Complete the function below
Node is as follows
class TreeNode
{
    int key;
    TreeNode left, right;
    public TreeNode(int key)
    {
        this.key = key;
        left = right = null;
    }
}*/

class Res{
    int res;
}
class Solution
{
	public int longestConsecutive(Node root)
        {
         //add code here.
         Res res=new Res();
         cons(root, root.data+1, 0, res);
         return res.res==1 ? -1 : res.res;
        }
        
        //here the idea is to check every node with its parent that if the current node is greater then parent or not
        //if so then update current counter and global result
        private void cons(Node root, int expected, int currLength, Res res){
            if(root==null)
                return;
            if(root.data==expected)
                currLength+=1;
            else
                currLength=1;
            res.res=Math.max(res.res, currLength);
            cons(root.left, root.data+1, currLength, res);
            cons(root.right, root.data+1, currLength, res);
        }
}

