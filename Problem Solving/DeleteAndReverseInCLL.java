/*
Given a Circular Linked List of size N. The task is to delete the given node (excluding the first and last node) in the circular linked list and then print the reverse of the circular linked list.

 

Example 1:


Input:
5
2 5 7 8 10
8

Output:
10 7 5 2
Explanation: 
After deleting 8 from the given circular linked 
list, it has elements as 2, 5, 7, 10. Now, 
reversing this list will result in 10, 7, 5, 2.
 

Example 2:

Input:
4
1 7 8 10
8

Output:
10 7 1

Explanation:
After deleting 8 from the given circular linked 
list, it has elements as 1, 7,10. Now, reversing 
this list will result in 10, 7, 1.
 

Your Task:
You don't need to read, input, or print anything. Your task is to complete the function deleteNode( ), which takes Node head, and integer key as input parameters, and delete the node with data key. Also Complete function reverse() which reverses the linked list.

 

Constraints:
1 <= T <= 100
1 <= n <= 100
1 <= data <= 100
*/

//{ Driver Code Starts
import java.util.Scanner;
import java.io.*;

class Node
{
    int data;
    Node next;
    Node(int d)
    {
        data=d;
        next=null;
    }
}
class GFG1 {
    public static void printList(Node head)
    {
        Node start=head;
        System.out.print(head.data+" ");
        head=head.next;
        while(head!=start)
        {
            System.out.print(head.data+" ");
            head=head.next;
        }
        System.out.println();
    }
	public static void main (String[] args) {
	    Scanner sc=new Scanner(System.in);
	    int t=sc.nextInt();
	    while(t-->0)
	    {
	        int n=sc.nextInt();
	        Node start=null,cur=null;
	        for(int i=0;i<n;i++)
	        {
	            int a=sc.nextInt();
	            Node ptr=new Node(a);
	            if(start==null)
	            {
	                start=ptr;
	                cur=ptr;
	            }
	            else
	            {
	                cur.next=ptr;
	                cur=ptr;
	            }
	        }
	        int delNode=sc.nextInt();
	        cur.next=start;
	        GFG obj=new GFG();
	        Node head=obj.deleteNode(start,delNode);
	        start=obj.reverse(head);
	        printList(start);
	    }
	}
}
// } Driver Code Ends


/*class Node
{
    int data;
    Node next;
    Node(int d)
    {
        data=d;next=null;
    }
}*/

class GFG
{
    //This method returns the head of the LL after deleting node with value d.
    public static Node deleteNode(Node head,int d)
    {
        //Add your code here.
          Node prev=null,temp=head;
        
        //check to ensure we dont traverse cll inifinitel
        while(temp.next!=head){
            if(temp.data==d){
                prev.next=temp.next;
            }else{
                prev=temp;
            }
            temp=temp.next;
        }
        return head;
    }
    //This method returns the head node of the reversed Linked list.
    public static Node reverse(Node head)
    {
        //Add your code here
        Node curr=head, reverse=null, nxt=head.next;
        
        
        while(curr.next!=head){
            curr.next=reverse;
            reverse=curr;
            curr=nxt;
            nxt=nxt.next;
        }
        //making to cll again
        curr.next=reverse;
        reverse=curr;
        head.next=reverse;
        return reverse;
    }
}
