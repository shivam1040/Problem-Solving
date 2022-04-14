/*
Given a Binary Tree, your task is to find its level order traversal.
For the below tree the output will be 1 $ 2 3 $ 4 5 6 7 $ 8 $.

          1
       /     \
     2        3
   /    \     /   \
  4     5   6    7
    \
     8

Example 1:

Input:
          1
        /
       4
     /   \
    4     2
Output:1 $ 4 $ 4 2 $

Example 2:

Input:
            10
          /    \
        20      30
     /     \
    40     60
Output: 10 $ 20 30 $ 40 60 $
Your Task:
This is a function problem. You don't need to read input. Just complete the function levelOrder() that takes nodes as parameter and returns level order traversal as a 2D list.

Note: The driver code prints the levels '$' separated.
Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
1 <= Number of edges <= 1000
0 <= Data of a node <= 100
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
                    Level_Order_Traverse g = new Level_Order_Traverse();
                    ArrayList<ArrayList<Integer>> result = g.levelOrder(root);
                    for(ArrayList<Integer> values : result){
                        for(int value : values){
                            System.out.print(value + " ");
                        }
                        System.out.print("$ ");
                    }
                    System.out.println();
                    t--;
                
            }
        }
       
    }// } Driver Code Ends
    
    
    /*class Node
    {
        int data;
        Node left, right;
    
        Node(int item)
        {
            data = item;
            left = right = null;
        }
    }*/
    
    
    class Level_Order_Traverse
    {
        //Function to return the level order traversal line by line of a tree.
        static ArrayList<ArrayList<Integer>> levelOrder(Node root) 
        {
            ArrayList <ArrayList<Integer>> res=new ArrayList <ArrayList<Integer>>();
            Queue<Node> queue = new LinkedList<Node>();
            queue.add(root);
            ArrayList<Integer> temp=new ArrayList<Integer>();
            int count=0;
            Node tempNode=null;
            while (true) {
                
                /* poll() removes the present head.
                For more information on poll() visit
                http://www.tutorialspoint.com/java/
                util/linkedlist_poll.htm */
                count=queue.size();
                
                if(count==0)
                    break;
                
                while(count>0){ //this loop keeps check on number of nodes at any level and stores that data
                tempNode = queue.poll();
                int a=tempNode.data;
                temp.add(a);
                /*Enqueue left child */
                if (tempNode.left != null) {
                    queue.add(tempNode.left);
                }
                /*Enqueue right child */
                if (tempNode.right != null) {
                    queue.add(tempNode.right);
                }
                count--;
                }
                res.add(temp);
                temp=new ArrayList<Integer>();
                
            }
            
            return res;
        }
        
    }