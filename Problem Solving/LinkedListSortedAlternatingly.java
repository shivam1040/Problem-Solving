/*
Given a Linked list of size N, the list is in alternating ascending and descending orders. Sort the given linked list in non-decreasing order.

 

Example 1:

Input:
LinkedList: 1->9->2->8->3->7
Output: 1 2 3 7 8 9
Explanation: After sorting the given
list will be 1-> 2-> 3-> 7-> 8-> 9.
 

Example 2:

Input:
LinkedList: 13->99->21->80->50
Output: 13 21 50 80 99
Explanation: After sorting the given list 
will be 12-> 21-> 50-> 80-> 99.
 

Your Task:
You do not need to read input or print anything. The task is to complete the function sort() which should sort the linked list in non-decreasing order. 

 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

 

Constraints:
1 <= Number of nodes <= 100
0 <= Values of the linked list <= 103
*/

//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;
    
    public Node (int data){
        this.data = data;
        this.next = null;
    }
}

class GFG {
    static void printList(Node node) 
	{ 
		while (node != null) 
		{ 
			System.out.print(node.data + " "); 
			node = node.next; 
		} 
		System.out.println(); 
	}
	public static void main (String[] args) {
		Scanner sc  = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0){
		    int n = sc.nextInt();
		    
		    Node head = new Node(sc.nextInt());
		    Node tail = head;
		    
		    for(int i=1; i<n; i++){
		        tail.next = new Node(sc.nextInt());
		        tail = tail.next;
		    }
		    Solution obj = new Solution();
		    head = obj.sort(head);
		    printList(head);
		}
	}
}

// } Driver Code Ends


/*
Structure of node class is:

class Node {
    int data;
    Node next;
    
    public Node (int data){
        this.data = data;
        this.next = null;
    }
}
*/
class Solution {
    
   public Node sort(Node head){
        //your code here, return the head of the sorted list
        ArrayList<Integer> adj = new ArrayList<>();
        while(head != null){
            adj.add(head.data);
            head = head.next;
        }
        Collections.sort(adj);
        Node Result = null, dummy = null;
        for(Integer item: adj){
            if(Result == null){
                Result = new Node(item);
                dummy = Result;
            } else {
                dummy.next = new Node(item);
                dummy = dummy.next;
            }
        }
        return Result;
   }

}
