/*
Given below is a binary tree. The task is to print the top view of binary tree. Top view of a binary tree is the set of nodes visible when the tree is viewed from the top. For the given below tree

       1
    /     \
   2       3
  /  \    /   \
4    5  6   7

Top view will be: 4 2 1 3 7
Note: Return nodes from leftmost node to rightmost node. Also if 2 nodes are outside the shadow of the tree and are at same position then consider the left ones only(i.e. leftmost). 
For ex - 1 2 3 N 4 5 N 6 N 7 N 8 N 9 N N N N N will give 8 2 1 3 as answer. Here 8 and 9 are on the same position but 9 will get shadowed.

Example 1:

Input:
      1
   /    \
  2      3
Output: 2 1 3
Example 2:

Input:
       10
    /      \
  20        30
 /   \    /    \
40   60  90    100
Output: 40 20 10 30 100
Your Task:
Since this is a function problem. You don't have to take input. Just complete the function topView() that takes root node as parameter and returns a list of nodes visible from the top view from left to right.

Expected Time Complexity: O(NlogN)
Expected Auxiliary Space: O(N).

Constraints:
1 ≤ N ≤ 105
1 ≤ Node Data ≤ 105
 
*/

/*
Intuition
Perform a level-order traversal of the binary tree while maintaining the horizontal distance from the root for each node. As nodes are encountered in the traversal, they are added to a map where the horizontal distance serves as the key, and the value is the value of the first encountered node at that horizontal distance. This way, we keep track of the top view nodes for each horizontal distance.

Implementation
Create an empty ArrayList<Integer> called ans to store the nodes visible in the top view.
Initialize a queue q for level-order traversal and add the root node with a horizontal distance of 0 (root's horizontal distance is considered as 0).
Create a TreeMap map where the keys represent horizontal distances, and the values represent the values of the first nodes encountered at those distances.
While the queue is not empty:
Dequeue a qObj from the queue.
If the map does not already contain a key for the horizontal distance (popped.level), add an entry with the current node's value as the value.
Enqueue the left child of the current node with a horizontal distance decreased by 1 if it exists.
Enqueue the right child of the current node with a horizontal distance increased by 1 if it exists.
After the level-order traversal is complete, the map will contain the first nodes encountered at each horizontal distance.
Traverse the map and add the values to the ans list.
Return the ans list, which contains the nodes visible from the top view.

*/

//{ Driver Code Starts
// Initial Template for JAVA

import java.io.*;
import java.util.*;
import java.util.LinkedList;
import java.util.Queue;


// } Driver Code Ends
// User function Template for Java

/*
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
*/

class Solution {
    // Function to return a list of nodes visible from the top view
    // from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root) {
        // add your code
        ArrayList<Integer> res=new ArrayList<>();
        Queue<Pair> aux=new LinkedList<>();
        //ensures the level is sorted
        Map<Integer, Integer> aux1=new TreeMap<>();
        
        aux.add(new Pair(root, 0));
        while(!aux.isEmpty()){
            Pair temp=aux.poll();
            //just take the first level ele seen
            if(!aux1.containsKey(temp.second))
                aux1.put(temp.second, temp.first.data);
            if(temp.first.left!=null)
                aux.add(new Pair(temp.first.left, temp.second-1));
            if(temp.first.right!=null)
                aux.add(new Pair(temp.first.right, temp.second+1));
        }
        for(int i:aux1.values())
            res.add(i);
        return res;
    }
}

class Pair{
    Node first;
    int second;
    
    Pair(Node first, int second){
        this.first=first;
        this.second=second;
    }
}

//{ Driver Code Starts.

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

public class Tree {

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
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            String s = br.readLine();
            Node root = buildTree(s);

            Solution ob = new Solution();

            ArrayList<Integer> vec = ob.topView(root);
            for (int x : vec) System.out.print(x + " ");
            System.out.println();

            t--;
        }
    }
}
// } Driver Code Ends
