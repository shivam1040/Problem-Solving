/*
Given a binary tree of N nodes, where every node value is a number. Find the sum of all the numbers which are formed from root to leaf paths.

Example 1:

Input :      
           6                               
         /   \                          
        3     5                      
      /   \     \
     2    5      4             
        /  \                        
       7    4  

Output: 13997

Explanation :
There are 4 leaves, hence 4 root to leaf paths:
Path                      Number
6->3->2                   632
6->3->5->7                6357
6->3->5->4                6354
6->5>4                    654   
Answer = 632 + 6357 + 6354 + 654 = 13997 
Example 2:

Input :    
           10                               
         /   \                          
        20     30                      
      /   \     
     40       60    

Output :  2630

Explanation:
Path                      Number
10->20->40                1240
10->20->60                1260
10->30                    130
1240+1260+130 = 2630

Your Task:  
You dont need to read input or print anything. Complete the function treePathsSum() which takes root node as input parameter and returns the sum of all the numbers formed by the root to leaf paths in the given Binary Tree.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(Height of Tree)


Constraints:
1 ≤ N ≤ 12
*/

//{ Driver Code Starts
//Contributed by Sudarshan Sharma
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
    
	        while(t-- > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
    	        Tree1 g = new Tree1();
    	        System.out.println(g.treePathsSum(root));
    	       // System.out.println();
	        }
	}
}


// } Driver Code Ends


/*Complete the function below.
Node is as follows:
class Tree
{
      int data;
      Tree left,right;
      Tree(int d){
          data=d;
          left=null;
          right=null;
}
}*/

class Res{
    String s;
    long res;
}
class Tree1
{
	public static long treePathsSum(Node root)
        {
         //add code here.
       Res res=new Res();
       res.s="";
       sum(root, res);
       return res.res;
	}
	
	private static void sum(Node root, Res res){
         if(root==null)
            return;
        res.s+=String.valueOf(root.data);
        if(root.left==null && root.right==null){
            res.res+=Long.parseLong(res.s); //way to add list to list and without having any impact in res list when aux is modified later
        }
        else{ //this block only executes if left & right are not null to ensure at every leaf data is added to aux
            sum(root.left, res);
            sum(root.right, res);
        }
        res.s=res.s.substring(0, res.s.length()-1); //removing last character before going back in recursion, since number formed from this number hase been accounted for already
	}
}
