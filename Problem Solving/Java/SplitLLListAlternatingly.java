/*
Given a singly linked list of size N. Your task is to complete the function alternatingSplitList() that splits the given linked list into two smaller list. The sublists should be made from alternating elements from the original list.
Note: the sublist should in the order with respect to original list.

Input Format:
First line of input contains number of testcaes T. First line of each input contains length of the linked list and next line contains the elements of the linked list.

Output Format:
For each test case, in new lines, print the two sublists formed after the split.

User Task:
The task is to complete the function alternatingSplitList() which takes the head as parameter and splits the lists into two. The head of the first list should be stored in the provided variable a, and the head of the second should be stored in the provided variable b. The printing is done by the driver code.

Constraints:
1 <= T <= 100
1 <= N <= 100

Example:
Input:
2
6
0 1 0 1 0 1
5
2 5 8 9 6

Output:
0 0 0
1 1 1
2 8 6
5 9

Explanation:
Testcase 1: After forming two sublists of the given list as required, we have two lists as: 0->0->0 and 1->1->1.
*/

//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class Node {
    int data;
    Node next;
    
    public Node(int head){
        this.data = head;
        this.next = null;
    }
}

class GFG {
    public static Node a;
    public static Node b;
    
    public static void printList(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }
    
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		int t = sc.nextInt();
		while(t-- > 0){
		    a=null;
		    b=null;
		    int n = sc.nextInt();
		    Node head = new Node(sc.nextInt()), tail = head;
		    while(n-- > 1){
		        tail.next = new Node(sc.nextInt());
		        tail = tail.next;
		    }
		    Solution obj = new Solution();
		    obj.alternatingSplitList(head);
		    printList(a);
		    printList(b);
		}
	}
}



// } Driver Code Ends


/*
The structure of node class is:
class Node {
    int data;
    Node next;
    
    public Node(int head){
        this.data = head;
        this.next = null;
    }
}
*/

/*

class GFG {
    public static Node a; //store the head of first list in this
    public static Node b; //store the head of second list in this
}
*/


class Solution {
    public void alternatingSplitList(Node head){
       //Your code here
       Node res1=new Node(-1);
       Node res2=new Node(-1);
       Node cr1=res1;
       Node cr2=res2;
       
       while(head!=null){
           cr1.next=head;
           cr1=cr1.next;
           if(head.next!=null){
               cr2.next=head.next;
               cr2=cr2.next;
               head=head.next.next;
               continue;
           }
           head=head.next;
       }
       cr1.next=null;
       cr2.next=null;
       res1=res1.next;
       res2=res2.next;
       GFG.a=res1;
       GFG.b=res2;
    }
}
