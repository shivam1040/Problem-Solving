/*
Given a binary tree. The task is to check whether the given tree follows the max heap property or not.
Note: Properties of a tree to be a max heap - Completeness and Value of node greater than or equal to its child.

Example 1:

Input:
      5
    /  \
   2    3
Output: 1
Explanation: The given tree follows max-heap property since 5,
is root and it is greater than both its children.

Example 2:

Input:
       10
     /   \
    20   30 
  /   \
 40   60
Output: 0

Your Task:
You don't need to read input or print anything. Your task is to complete the function isHeap() which takes the root of Binary Tree as parameter returns True if the given binary tree is a heap else returns False.

Expected Time Complexity: O(N)
Expected Space Complexity: O(N)

Constraints:
1 ≤ Number of nodes ≤ 100
1 ≤ Data of a node ≤ 1000
*/

/*
We check each of the above condition separately, for checking completeness isComplete and for checking heap isHeapUtil function are written. 
Detail about isComplete function can be found here.
isHeapUtil function is written considering the following things –  


Every Node can have 2 children, 0 child (last level nodes) or 1 child (there can be at most one such node).
If Node has No child then it’s a leaf node and returns true (Base case)
If Node has one child (it must be left child because it is a complete tree) then we need to compare this node with its single child only.
If the Node has both child then check heap property at Node at recur for both subtrees. 
Complete code.
*/
// { Driver Code Starts
    import java.util.LinkedList;
    import java.util.Queue;
    import java.io.*;
    import java.util.*;
    
    class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
    
      public class GfG {
    
        static Node buildTree(String str) {
    
            if (str.length() == 0 || str.charAt(0) == 'N') {
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
            while (queue.size() > 0 && i < ip.length) {
    
                // Get and remove the front of the queue
                Node currNode = queue.peek();
                queue.remove();
    
                // Get the current node's value from the string
                String currVal = ip[i];
    
                // If the left child is not null
                if (!currVal.equals("N")) {
    
                    // Create the left child for the current node
                    currNode.left = new Node(Integer.parseInt(currVal));
                    // Push it to the queue
                    queue.add(currNode.left);
                }
    
                // For the right child
                i++;
                if (i >= ip.length) break;
    
                currVal = ip[i];
    
                // If the right child is not null
                if (!currVal.equals("N")) {
    
                    // Create the right child for the current node
                    currNode.right = new Node(Integer.parseInt(currVal));
    
                    // Push it to the queue
                    queue.add(currNode.right);
                }
                i++;
            }
    
            return root;
        }
        static void printInorder(Node root) {
            if (root == null) return;
    
            printInorder(root.left);
            System.out.print(root.data + " ");
    
            printInorder(root.right);
        }
    
        public static void main(String[] args) throws IOException {
            BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
    
            int t = Integer.parseInt(br.readLine());
            while (t-- > 0) {
                String s = br.readLine();
                Node root = buildTree(s);
    
                Solution ob = new Solution();
                if (ob.isHeap(root))
                    System.out.println(1);
                else
                    System.out.println(0);
            }
        }
    }// } Driver Code Ends
    
    
    // User Function template for JAVA
    
    /*
    Node defined as
    class Node{
        int data;
        Node left,right;
        Node(int d){
            data=d;
            left=right=null;
        }
    }
    */
    
    
    
    class Solution {
        boolean isHeap(Node root) {
           Queue<Node> aux=new LinkedList<Node>();
           aux.add(root);
           boolean isNull=false;
           while(!aux.isEmpty()){
               Node temp=aux.remove();
               if(temp.left!=null){
                   if(isNull || temp.left.data>temp.data)
                    return false;
                   aux.add(temp.left);
               }
               else{
                   isNull=true;
               }
               if(temp.right!=null){
                   if(isNull || temp.right.data>temp.data)
                    return false;
                   aux.add(temp.right);
               }
               else{
                   isNull=true;
               }
           }
           return true;
                
        }
        
       
    }