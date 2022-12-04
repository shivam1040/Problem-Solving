/*
Given a Linked list, rearrange it such that converted list should be of the form a < b > c < d > e < f .. where a, b, c are consecutive data node of linked list and such that the order of linked list is sustained.
For example: In 11 15 20 5 10 we consider only 11 20 5 15 10 because it satisfies the above condition and the order of linked list. 5 20 11 15 10 is not considered as it does not follow the order of linked list.

To maintain the order, keep swapping the adjacent nodes of the linked list (whenever required) to get the desired output.  

Example 1:

Input:
LinkedList: 1->2->3->4 
Output: 1 3 2 4
Example 2:

Input:
LinkedList: 11->15->20->5->10
Output: 11 20 5 15 10
Explanation: In the given linked list,
after arranging them as 11 < 20 > 5
< 15 > 10 in the pattern as asked above.
Your Task:
The task is to complete the function zigZag() which should reorder the list as required and return the head of the linked list.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints:
1 <= size of linked list(a) <= 1000
*/

//{ Driver Code Starts
import java.util.*;
import java.io.*;

class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
}

class GFG{
	static void printList(Node node) 
	{ 
		while (node != null) 
		{ 
			System.out.print(node.data + " "); 
			node = node.next; 
		} 
		System.out.println(); 
	}
	
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0){
            int n = sc.nextInt();
            
            Node head = new Node(sc.nextInt());
            Node tail = head;
            for(int i=0; i<n-1; i++)
            {
                tail.next = new Node(sc.nextInt());
                tail = tail.next;
            }
            
            Solution g = new Solution();
            printList(g.zigZag(head));
        }
    } 
}

// } Driver Code Ends


/*Node is as follows:

class Node {
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}

*/

class Solution{
	public static Node zigZag(Node head){
        //add code here.
        Node curr=head;
        boolean flag=true;
        
        //here zigzag basically means swapping data at odd/even occurences if they satisfy the comparison
        while(curr.next!=null){
            if(flag){
                if(curr.data>curr.next.data){
                    int data=curr.data;
                    curr.data=curr.next.data;
                    curr.next.data=data;
                }
            }
                else if(!flag){
                if(curr.data<curr.next.data){
                     int data=curr.data;
                    curr.data=curr.next.data;
                    curr.next.data=data;
                }
            }
            curr=curr.next;
            flag=!flag;
        }
        return head;
    }
}
