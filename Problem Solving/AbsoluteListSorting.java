/*
Given a linked list L of N nodes, sorted in ascending order based on the absolute values of its data,i.e. negative values are considered as positive ones. Sort the linked list according to the actual values, consider negative numbers as negative and positive number as positive.


Example 1:

Input: 
List: 1, -2, -3, 4, -5
Output: 
List: -5, -3, -2, 1, 4
 

Example 2:

Input: 
List: 5, -10
Output: 
List: -10, 5
 

Your Task:
You don't need to read or print anyhting. Your Task is to comple the function sortList() which takes the head of the Linked List as input parameter and sort the list in ascending order. Don't create a new Linked List instead rearrange the given List.

 

Expected Time Complexity: O(N)
Expected Space Complexity: O(1)


Constraints
1 ≤  N  ≤ 104
-105 ≤ L[i] ≤ 105
*/

//{ Driver Code Starts
import java.util.*;

class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
}
		
public class Absolute_List_Sort
{
    Node head;  
	
	/* Function to print linked list */
    void printList(Node head)
    {
        Node temp = head;
        while (temp != null)
        {
           System.out.print(temp.data+" ");
           temp = temp.next;
        }  
        System.out.println();
    }
	
 
    /* Inserts a new Node at front of the list. */
    public void addToTheLast(Node node) 
	{

		if (head == null) 
			head = node;
		else 
		{
		   Node temp = head;
		   while (temp.next != null)
		   temp = temp.next;

		   temp.next = node;
		}
    }
	  
    /* Drier program to test above functions */
    public static void main(String args[])
    {
       
        /* Constructed Linked List is 1->2->3->4->5->6->
           7->8->8->9->null */
        Scanner sc = new Scanner(System.in);
		int t=sc.nextInt();
		 
		while(t>0)
        {
			int n = sc.nextInt();
			Absolute_List_Sort llist = new Absolute_List_Sort();
			//int n=Integer.parseInt(br.readLine());
			int a1=sc.nextInt();
			Node head= new Node(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < n; i++) 
			{
				int a = sc.nextInt(); 
				llist.addToTheLast(new Node(a));
			}
          
            GfG gfgobj = new GfG(); 
    		llist.head = gfgobj.sortList(llist.head);
    		llist.printList(llist.head);
		
			t--;
		}
	}
}
// } Driver Code Ends


/* The structure of the node of the Linked List is
class Node
{
   int data;
   Node next;
   Node(int d) {data = d; next = null; }
 }
*/

class GfG
{
	Node sortList(Node head) {
		// Your code here
				Node prev=head, curr=head.next;
		
		while(curr!=null){
		    if(prev.data>curr.data){
		        //delinking current node;
		        prev.next=curr.next;
		        
		        //moving current node to front;
		        curr.next=head;
		        //making head point to curr node;
		        head=curr;
		        
		        //updating curr node for further operations
		        curr=prev;
		    }
		    else
		    //if fail consition then everything is fine, just move forward
		        prev=curr;
		    curr=curr.next;
		}
		return head;
	}
}
