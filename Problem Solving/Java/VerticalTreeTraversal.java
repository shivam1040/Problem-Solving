/*
Given a Binary Tree, find the vertical traversal of it starting from the leftmost level to the rightmost level.
If there are multiple nodes passing through a vertical line, then they should be printed as they appear in level order traversal of the tree.

Example 1:

Input:
           1
         /   \
       2       3
     /   \   /   \
   4      5 6      7
              \      \
               8      9           
Output: 
4 2 1 5 6 3 8 7 9 
Explanation:

Example 2:

Input:
       1
    /    \
   2       3
 /    \      \
4      5      6
Output: 4 2 1 5 3 6
Your Task:
You don't need to read input or print anything. Your task is to complete the function verticalOrder() which takes the root node as input parameter and returns an array containing the vertical order traversal of the tree from the leftmost to the rightmost level. If 2 nodes lie in the same vertical level, they should be printed in the order they appear in the level order traversal of the tree.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

Constraints:
1 <= Number of nodes <= 3*104
*/

/*
Intuition:
The key idea behind the vertical order traversal of a binary tree is to use a breadth-first search (BFS) to traverse the tree while keeping track of the horizontal distance of each node from the root. Nodes that lie on the same vertical line have the same horizontal distance. Using a map to store nodes at each horizontal distance and a queue to facilitate BFS, we can efficiently collect and order the nodes for the vertical traversal.

Example:
Input: tree = [1, 2, 3, 4, 5, 6, 7, 8, 9]

Untitled-design-(1)
Untitled-design-(3).pngUntitled-design-(3).png
Implementation:
Initialize Data Structures:
Create a map to store nodes based on their horizontal distances from the root.
Use a queue to perform a level order traversal (BFS). Each entry in the queue should store a node along with its horizontal distance.
Start BFS: Push the root node into the queue with a horizontal distance of 0.
Traverse the Tree:
While the queue is not empty:
Dequeue an element from the front of the queue.
Extract the node and its horizontal distance.
Insert the node's value into the map at the corresponding horizontal distance.
If the node has a left child, enqueue the left child with a horizontal distance one less than the current node.
If the node has a right child, enqueue the right child with a horizontal distance one greater than the current node.
Collect Results:
Traverse the map from the smallest to the largest horizontal distance.
For each horizontal distance, add the list of node values to the result vector.
Return the Result: Return the vector containing the vertical order traversal of the binary tree.
*/

//{ Driver Code Starts
//Initial Template for Java

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
                Solution obj = new Solution();
                ArrayList <Integer> res = obj.verticalOrder(root);
                for (Integer num : res) System.out.print(num + " "); 
                System.out.println();
    	        
	        }
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to find the vertical order traversal of Binary Tree.
    static ArrayList <Integer> verticalOrder(Node root)
    {
        // add your code here
        ArrayList<Integer> res=new ArrayList<>();
        Queue<Pair> q=new LinkedList<>();
        Map<Integer, ArrayList<Integer>> mp=new TreeMap<>();
        
        q.add(new Pair(root, 0));
        while(!q.isEmpty()){
            Pair temp=q.poll();
            Node tempRoot=temp.node;
            int hd=temp.hd;
            
            if(mp.containsKey(hd)){
                ArrayList<Integer> al=mp.get(hd);
                
                al.add(tempRoot.data);
                mp.put(hd, al);
            }
            else{
                ArrayList<Integer> al=new ArrayList<>();
                
                al.add(tempRoot.data);
                mp.put(hd, al);
            }
            if(tempRoot.left!=null)
                q.add(new Pair(tempRoot.left, hd-1));
            if(tempRoot.right!=null)
                q.add(new Pair(tempRoot.right, hd+1));
        }
        for(Map.Entry<Integer, ArrayList<Integer>> m: mp.entrySet()){
            ArrayList<Integer> al=m.getValue();
            
            for(int i=0; i<al.size(); i++)
                res.add(al.get(i));
        }
        return res;
    }
    
    private static class Pair
    {
        Node node;
        int hd;
        Pair(Node n, int h)
        {
            node = n;
            hd = h;
        }
    }
}
