/*
Given a doubly linked list, rotate the linked list counter-clockwise by P nodes. Here P is a given positive integer and is smaller than the count of nodes(N) in a linked list.

Example 1:

Input: 1 <-> 2 <-> 3 <-> 4 <-> 5 <-> 6 , P = 2
Output: 3 <-> 4 <-> 5 <-> 6 <-> 1 <-> 2
Explanation: Doubly linked list after rotating
2 nodes is: 3 4 5 6 1 2.
Example 2:

Input: 3 <-> 4 <-> 5 <-> 1 ,P = 3
Output: 1<-> 3 <-> 4 <-> 5
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function rotateDLL() which takes head node of the linked list and an integer P as input parameters and returns the head node after rotating the linked list by P nodes.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints:
2 <= N <= 100
1 <= P <  N
*/

//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Node{
	int data;
	Node next, prev;
	Node(int data){
		this.data = data;
		next = null;
		prev = null;
	}
}

class MaximumFrequency{
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			String [] str = br.readLine().trim().split(" ");
			int n = Integer.parseInt(str[0]);
			int p = Integer.parseInt(str[1]);
			
			Node start = null;
			Node cur = null;
			Node ptr = null;
			str = br.readLine().trim().split(" ");
			for(int i = 0; i < n; i++) {
				int a = Integer.parseInt(str[i]);
				ptr = new Node(a);
				if(start == null) {
					start = ptr;
					cur = ptr;
				}
				else {
					cur.next=ptr;
	                ptr.prev=cur;
	                cur=ptr;
				}
			}
			Solution obj = new Solution();
			Node node = obj.rotateDLL(start, p);
			while(true)
	        {
				System.out.print(node.data+" ");
	            if(node.next == null)
	            	break;
	            node = node.next;
	        }
	        while(node != null)
	        {
	        	System.out.print(node.data+" ");
	            node = node.prev;
	        }
	        System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java

/*
class Node{
	int data;
	Node next, prev;
	Node(int data){
		this.data = data;
		next = null;
		prev = null;
	}
}
*/

class Solution{
	public Node rotateDLL(Node head, int p) {
	    Node temp=head;
	    int count=1;
	    
	    //counting no of nodes
	    while(temp.next!=null){
	        count++;
	        temp=temp.next;
	    }
	    
	    //converting to circularLL for easy operation
	    head.prev=temp;
	    temp.next=head;
	    //finding coutn of rotation
	    int rotations= p%count;
	    
	    //moving ahead until rotation count
	    while(rotations!=0){
	        head=head.next;
	        rotations--;
	    }
	    
	    //disabling CLL, for instance 123456 rotated by 2 will be be 345612 since 2 points 3 and 3 points 2 in previous link, we need to null it
	    head.prev.next=null;
	    head.prev=null;
	    return head;
}
}
