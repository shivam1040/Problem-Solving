/*
Given two lists sorted in increasing order, create a new list representing the intersection of the two lists. The new list should be made with its own memory — the original lists should not be changed.
Note: The list elements are not necessarily distinct.

Example 1:

Input:
L1 = 1->2->3->4->6
L2 = 2->4->6->8
Output: 2 4 6
Explanation: For the given first two
linked list, 2, 4 and 6 are the elements
in the intersection.
Example 2:

Input:
L1 = 10->20->40->50
L2 = 15->40
Output: 40
Your Task:
The task is to complete the function intersection() which should find the intersection of two linked list and add all the elements in intersection to the third linked list and return the head of the third linked list.

Expected Time Complexity : O(n+m)
Expected Auxilliary Space : O(n+m)
Note: n,m are the size of the linked lists.

Constraints:
1 <= size of linked lists <= 5000
1 <= Data in linked list nodes <= 1000
*/

// { Driver Code Starts
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
                        m = sc.nextInt();
                        
                        Node head1 = inputList(n);
                        Node head2 = inputList(m);
                        
                        Sol obj = new Sol();
                        
                        Node result = obj.findIntersection(head1, head2);
            
                        printList(result);
                        System.out.println();
                    }
            }
    }// } Driver Code Ends
    
    
    /* Node of a linked list
     class Node {
       int data;
        Node next;
        Node(int d)  { data = d;  next = null; }
    }
    */
    
    class Sol
    {
       public static Node findIntersection(Node head1, Node head2)
        {
            Node res=new Node(0);
            int temp2=Integer.MIN_VALUE;
            Node temp=res;
    
            while(head1!=null && head2!=null){
                if(head1.data<head2.data)
                    head1=head1.next;
                else if(head1.data>head2.data)
                    head2=head2.next;
                else if(head1.data==head2.data){
                    if(head1.data==temp2 && temp2>Integer.MIN_VALUE){ //optimisation to ensure no duplicates are not entered
                        head1=head1.next;
                        head2=head2.next;
                        continue;
                    }
                    temp2=head1.data;
                    temp.next=new Node(head1.data);
                    temp=temp.next; //two pointers have been intiallized above so we can always take the next value of temp(refrencing var res internally so changes made in temp would also be reflected in res)
                    
                    head1=head1.next;
                    head2=head2.next;
                }
            }
            return res.next;
        }
    }