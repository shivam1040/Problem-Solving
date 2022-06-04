/*
Given a Binary Tree having positive and negative nodes. Find the maximum sum of a level in the given Binary Tree.

Example 1:

Input :               
             4
          /    \
         2     -5
        / \    / \
      -1   3  -2  6

Output: 6

Explanation :
Sum of all nodes of 0'th level is 4
Sum of all nodes of 1'th level is -3
Sum of all nodes of 2'th level is 6
Hence maximum sum is 6

Example 2:

Input :          
            1
          /   \
         2     3
        / \     \
       4   5     8
                / \
               6   7  

Output :  17

Explanation: Maximum sum is at level 2.

Your Task:  
You dont need to read input or print anything. Complete the function maxLevelSum() which takes root node as input parameter and returns the maximum sum of any horizontal level in the given Binary Tree.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)


Constraints:
1 ≤ N ≤ 104
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
    
    class Main {
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
    
        public static void main(String[] args) throws IOException {
            BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
    
            int t = Integer.parseInt(br.readLine().trim());
    
            while (t-- > 0) {
                String s = br.readLine().trim();
                Node root = buildTree(s);
    
                Solution g = new Solution();
                System.out.println(g.maxLevelSum(root));
            }
        }
    }// } Driver Code Ends
    
    
    /*Complete the finction below
    Node is as follows
    class Node{
        int data;
        Node left,right;
        Node(int d){
            data=d;
            left=right=null;
        }
    }*/
    class Solution {
        public int maxLevelSum(Node root) {
                Queue<Node> queue = new LinkedList<Node>();
                queue.add(root);
                int count=0;
                Node tempNode=null;
                int temp=0;
                int sum=Integer.MIN_VALUE;
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
                    temp+=tempNode.data;
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
                    if(temp>sum)
                        sum=temp;
                    temp=0;
                    
                }
                
                return sum;
        }
    }