/*
Given a linked list sorted in ascending order and an integer called data, insert data in the linked list such that the list remains sorted.

Example 1:

Input:
LinkedList: 25->36->47->58->69->80
data: 19
Output: 19 25 36 47 58 69 80
Example 2:

Input:
LinkedList: 50->100
data: 75
Output: 50 75 100
Your Task:
The task is to complete the function sortedInsert() which should insert the element in sorted Linked List and return the head of the linked list

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Constraints:
1 <= N <= 104
-99999 <= A[i] <= 99999, for each valid i
*/

// { Driver Code Starts
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
            
            while(t > 0){
                int n = sc.nextInt();
                
                Node head = new Node(sc.nextInt());
                Node tail = head;
                
                for(int i=0; i<n-1; i++)
                {
                    tail.next = new Node(sc.nextInt());
                    tail = tail.next;
                }
                
                int k = sc.nextInt();
                
                Solution g = new Solution();
                head = g.sortedInsert(head,k);
                
                printList(head); 
                t--;
            }
        } 
    } 
    // } Driver Code Ends
    
    
    /*class Node
        {
            int data;
            Node next;
            Node(int d) {data = d; next = null; }
        }*/
    
    // sortedInsert method should return the head of the modified linked list.
    class Solution {
        Node sortedInsert(Node head, int key) {
           Node last=head;
            if(last.data>=key){
                Node insert=new Node(key);
                insert.next=last;
                return insert;
            }
            
            while(last.next!=null){
                if(last.next.data>=key){
                   Node insert=new Node(key);
                   insert.next=last.next;
                   last.next=insert;
                   return head;
                }
                last=last.next;
            }
            
            if(last.next==null){
                last.next=new Node(key);
                return head;
            }
            return last;
        }
    }