/*
Given two sorted linked lists consisting of nodes respectively. The task is to merge both lists and return the head of the merged list.

Examples:

Input: LinkedList1: 5->10->15->40, ListedList2: 2->3->20
Output: 2->3->5->10->15->20->40
Explanation:

Input: LinkedList1: 1->1, LinkedList2: 2->4
Output: 1->1->2->4
Explanation:

Expected Time Complexity: O(n+m)
Expected Auxilliary Space: O(1)

Constraints:
1 <= no. of nodes<= 105
0 <= node->data <= 105


*/

//{ Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

public class Main {
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        while (T-- > 0) {
            Node head1 = null, tail1 = null;
            Node head2 = null, tail2 = null;

            String input1 = sc.nextLine();
            String[] elems1 = input1.split(" ");
            for (String elem : elems1) {
                Node newNode = new Node(Integer.parseInt(elem));
                if (head1 == null) {
                    head1 = newNode;
                    tail1 = newNode;
                } else {
                    tail1.next = newNode;
                    tail1 = newNode;
                }
            }

            String input2 = sc.nextLine();
            String[] elems2 = input2.split(" ");
            for (String elem : elems2) {
                Node newNode = new Node(Integer.parseInt(elem));
                if (head2 == null) {
                    head2 = newNode;
                    tail2 = newNode;
                } else {
                    tail2.next = newNode;
                    tail2 = newNode;
                }
            }

            Solution obj = new Solution();
            Node head = obj.sortedMerge(head1, head2);
            printList(head);
        }
        sc.close();
    }
}

// } Driver Code Ends


/*
  Merge two linked lists
  head pointer input could be NULL as well for empty list
  Node is defined as
    class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
*/

class Solution {
    // Function to merge two sorted linked list.
    Node sortedMerge(Node head1, Node head2) {
        // This is a "method-only" submission.
        // You only need to complete this method
        Node dummyNode = new Node(0);
        Node tail=dummyNode;
        
        while(true){
            if(head1.data<=head2.data){
                tail.next=head1;
                head1=head1.next;
            }
            else{
                tail.next=head2;
                head2=head2.next;
            }
            tail=tail.next;
            
            if(head1==null){
                tail.next=head2;
                break;
            }
            if(head2==null){
                tail.next=head1;
                break;
            }
        }
        return dummyNode.next;
    }
}
