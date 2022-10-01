/*
Given two BSTs containing N1 and N2 distinct nodes respectively and given a value x. Your task is to complete the function countPairs(), that returns the count of all pairs from both the BSTs whose sum is equal to x.


Example 1:

Input:
BST1:
       5
     /   \
    3     7
   / \   / \
  2   4 6   8

BST2:
       10
     /    \
    6      15
   / \    /  \
  3   8  11   18

x = 16
Output:
3
Explanation:
The pairs are: (5, 11), (6, 10) and (8, 8)
 

Example 2:

Input:
BST1:
  1
   \
    3
   /
  2
BST2:
    3
   / \
  2   4
 /     
1

x = 4
Output:
3
Explanation:
The pairs are: (2, 2), (3, 1) and (1, 3)

Your Task:
You don't need to read input or print anything. Your task is to complete the function countPairs(), which takes 2 BST's as parameter in form of root1 and root2 and the integer x, that returns the count of all pairs from both the BSTs whose sum is equal to x.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)


Constraints:
1 ≤ Number of nodes ≤ 105
1 ≤ Data of a node ≤ 106
*/

//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

class Node
{
	int data;
	Node left, right;

	Node(int val) {
		data = val;
		left = right = null;
	}
}


// } Driver Code Ends
//User function Template for Java

/*Structure of the Node of the BST is as
class Node
{
	int data;
	Node left, right;

	Node(int val) {
		data = val;
		left = right = null;
	}
}
*/

class Solution
{
    static int count;
	public static int countPairs(Node root1, Node root2, int x)
	{
		// Code here
		count=0;
		toList(root1, root2, x);
		return count;
	}
	
	//traversing through root 1
	private static void toList(Node root, Node root2, int x){
	    if(root==null)
	        return;
	    toList(root.left, root2, x);
	    toList(root.right, root2, x);
	    int diff=x-root.data;
	    pair(root2, diff);
	}
	
	//traversing through root 2 to find diff
	private static void pair(Node root, int diff){
	    if(root==null)
	        return;
	    if(diff>root.data)
	        pair(root.right, diff);
	    else if(diff<root.data)
	        pair(root.left, diff);
	    else
	        count++;
	}
}

//{ Driver Code Starts.

public class Main
{
    static FastIO f;

    // Function to Build Tree
    static Node buildTree(String str)
    {
    	// Corner Case
    	if(str.length() == 0 || str.charAt(0) == 'N')
    		return null;

    	// Creating array of strings from input
    	// string after spliting by space
    	String[] ip = str.split(" ");

    	// Create the root of the tree
    	Node root = new Node(Integer.parseInt(ip[0]));

    	// Push the root to the queue
    	Queue<Node> queue = new LinkedList<>();
    	queue.add(root);

    	// Starting from the second element
	    int i = 1;
	    while (!queue.isEmpty() && i < ip.length) {

	        // Get and remove the front of the queue
	        Node currNode = queue.poll();

	        // Get the current node's value from the string
	        String currVal = ip[i];

	        // If the left child is not null
	        if (!currVal.equals("N")) {

	            // Create the left child for the current Node
	            currNode.left = new Node(Integer.parseInt(currVal));

	            // Push it to the queue
	            queue.add(currNode.left);
	        }

	        // For the right child
	        i++;
	        if (i >= ip.length)
	            break;
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
    
    public static void main(String args[]) throws IOException
    {
        f = new FastIO();
        
        int t = f.nextInt();
        
        while(t-->0)
        {
            String tree1 = f.nextLine(), tree2 = f.nextLine();
            Node root1 = buildTree(tree1), root2 = buildTree(tree2);
            int x = f.nextInt();

            f.out(Solution.countPairs(root1, root2, x) + "\n");
        }
        
        f.flush();
    }
}

class FastIO
{
	BufferedReader br;
	PrintWriter bw, be;
	StringTokenizer st;

	public FastIO()
	{
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new PrintWriter(System.out);
		be = new PrintWriter(System.err);
		st = new StringTokenizer("");
	}

	private void read() throws IOException
	{
		st = new StringTokenizer(br.readLine());
	}

	public String nextLine() throws IOException
	{
		return br.readLine();
	}

	public String next() throws IOException
	{
		while(!st.hasMoreTokens())
			read();
		return st.nextToken();
	}

	public int nextInt() throws IOException
	{
		return Integer.parseInt(next());
	}

	public long nextLong() throws IOException
	{
		return Long.parseLong(next());
	}

	public float nextFloat() throws IOException
	{
		return Float.parseFloat(next());
	}

	public double nextDouble() throws IOException
	{
		return Double.parseDouble(next());
	}

	public char nextChar() throws IOException
	{
		return next().charAt(0);
	}

	public void out(String s) throws IOException
	{
		bw.print(s);
	}

	public void flush() throws IOException
	{
		bw.flush();
		be.flush();
	}

	public void err(String s) throws IOException
	{
		be.print(s);
	}
}
// } Driver Code Ends
