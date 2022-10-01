/*
Given two linked lists, your task is to complete the function makeUnion(), that returns the union of two linked lists. This union should include all the distinct elements only.

Example 1:

Input:
L1 = 9->6->4->2->3->8
L2 = 1->2->8->6->2
Output: 1 2 3 4 6 8 9
Your Task:
The task is to complete the function makeUnion() which makes the union of the given two lists and returns the head of the new list.

Note: The new list formed should be in non-decreasing order.

Expected Time Complexity: O(N * Log(N))
Expected Auxiliary Space: O(N)

Constraints:
1
*/

//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node 
{
    int data;
    Node next;
    
    Node(int a)
        {
            data = a;
            next = null;
        }
}

class GfG
{
    static Scanner sc = new Scanner(System.in);
    
    public static Node inputList(int size)
    {
        Node head, tail;
        int val;
        
        val = sc.nextInt();
        
        head = tail = new Node(val);
        
        size--;
        
        while(size-->0)
        {
            val = sc.nextInt();
            tail.next = new Node(val);
            tail = tail.next;
        }
        
        return head;
    }
    
    public static void printList(Node n)
    {
        while(n!=null)
        {
            System.out.print(n.data + " ");
            n = n.next;
        }
    }
    
    public static void main(String args[])
    {
        int t = sc.nextInt();
        while(t-->0)
        {
            int n , m;
            
            n = sc.nextInt();
            Node head1 = inputList(n);
            
            m = sc.nextInt();
            Node head2 = inputList(m);
            
            Sol obj = new Sol();
            
            printList(obj.findUnion(head1, head2));
            System.out.println();
        }
    }
}
// } Driver Code Ends


/*
    class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
*/

class Sol
{
	public static Node findUnion(Node head1,Node head2)
	{
	    //Add your code here.
	    Set<Integer> aux=new TreeSet<Integer>();
	    Node temp=head1;
	    
	    while(temp!=null){
	        aux.add(temp.data);
	        temp=temp.next;
	    }
	    
	    temp=head2;
	    
	    while(temp!=null){
	        aux.add(temp.data);
	        temp=temp.next;
	    }
	    head1=new Node(0);
	    temp=head1;
	    for(int i: aux){
	        temp.next=new Node(i);
	        temp=temp.next;
	    }
	    return head1.next;
	}
}
