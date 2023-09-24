/*
You are given the root of a complete binary tree. Your task is to find the count of nodes.

A complete binary tree is a binary tree whose, all levels except the last one are completely filled, the last level may or may not be completely filled and Nodes in the last level are as left as possible.

Design an algorithm that runs better than O(n).

Example:

Input: 
root = [1,2,3,4,5,6]
Output: 
6
Explanation: 
There are a total of 6 nodes in the given tree.
Your Task:

Complete the function int cnt_nodes(Node *root), which takes the pointer of the root of the given Binary tree and returns the count of its number of nodes.

Expected Time Complexity: O((LogN)2).

Expected Auxiliary Space: O(Log N).

Constraints:

0 <= N (number of nodes) <= 5 * 104 

0 <= value of nodes <= 5 * 104

The tree is guaranteed to be complete.
*/

//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class Node {
    int val;
    Node left;
    Node right;

    Node(int val) {
        this.val = val;
        left = null;
        right = null;
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] v = new int[n];
            for (int i = 0; i < n; i++) {
                v[i] = sc.nextInt();
            }
            Node root = new Node(v[0]);
            int cnt = 0;
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            Node cur = null;
            for (int i = 1; i < n; i++) {
                Node node = new Node(v[i]);
                if (cnt == 0) {
                    cur = q.peek();
                    q.poll();
                }
                if (cnt == 0) {
                    cnt++;
                    cur.left = node;

                } else {
                    cnt = 0;
                    cur.right = node;
                }
                if (v[i] >= 0) {
                    q.add(node);
                }
            }

            Solution obj = new Solution();
            int ans = obj.countNodes(root);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    public static int countNodes(Node root) {
        // Code here
        Queue<Node> aux=new LinkedList<>();
        int count=0;
        
        aux.add(root);
        while(!aux.isEmpty()){
            int n=aux.size();
            
            for(int i=0; i<n; i++){
                Node temp=aux.poll();
                count++;
                
                if(temp.left!=null)
                    aux.add(temp.left);
                if(temp.right!=null)
                    aux.add(temp.right);
            }
        }
        return count;
    }
}
