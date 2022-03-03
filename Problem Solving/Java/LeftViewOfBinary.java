/*
We can keep track of level of a node by passing a parameter to all recursive calls. The idea is to keep track of maximum level also. Whenever we see a node whose level is more than maximum level so far, we store the node in a list because this is the first node in its level (Note that we traverse the left subtree before right subtree).
*/
/*
Given a Binary Tree, print Left view of it. Left view of a Binary Tree is set of nodes visible when tree is visited from Left side. The task is to complete the function leftView(), which accepts root of the tree as argument.

Left view of following tree is 1 2 4 8.

          1
       /     \
     2        3
   /     \    /    \
  4     5   6    7
   \
     8   

Example 1:

Input:
   1
 /  \
3    2
Output: 1 3

Example 2:

Input:

Output: 10 20 40
Your Task:
You just have to complete the function leftView() that prints the left view. The newline is automatically appended by the driver code.
Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Height of the Tree).

Constraints:
0 <= Number of nodes <= 100
1 <= Data of a node <= 1000
*/

// { Driver Code Starts
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
                    ArrayList<Integer> result = g.leftView(root);
                    for(int value : result){
                        System.out.print(value + " ");
                    }
                    System.out.println();
                    t--;
            }
        }
    }
    // } Driver Code Ends
    
    
    //User function Template for Java
    
    /* A Binary Tree node
    class Node
    {
        int data;
        Node left, right;
    
        Node(int item)
        {
            data = item;
            left = right = null;
        }
    }*/
    class Tree
    {
       int max_level = 0;
        
        //Function to return list containing elements of left view of binary tree.
        ArrayList<Integer> leftView(Node root)
        {
            ArrayList<Integer> result = new ArrayList<Integer>();
            this.leftViewUtil(result, root, 1); //starting at level 1
            //returning the list.
            return result;
        }
        
        //Function to get the left view of the binary tree.
        void leftViewUtil(ArrayList<Integer> result, Node node, int level)
        {
            //if root is null, we simply return.
            if (node==null) return;
            
            //if this is the first node of its level then it is in the left view.
            if (max_level < level)
            {
                //storing data of current node in list.
                result.add(node.data);
                max_level = level;
            }
            
            //calling function recursively for left and right 
            //subtrees of current node.
            leftViewUtil(result, node.left, level+1);
            leftViewUtil(result, node.right, level+1);
        }
        
        
    }