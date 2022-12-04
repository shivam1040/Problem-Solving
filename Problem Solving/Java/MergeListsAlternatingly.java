/*
Given two linked lists, your task is to complete the function mergeList() which inserts nodes of second list into first list at alternate positions of first list.

Input:
First line of input contains number of testcases T. For each testcase there will be 4 lines. First line consists of the length of the first linked list, next line contains elements of the linked list inreverse order. Third line contains length of another linked list and next line contains elements of the linked list.

Output:
For each test case first print space separated vales of the first linked list, then in the next line print space separated values of the second linked list.

User Task:
The task is to complete the function mergeList() which should merge the two lists as required.

Constraints:
1 <= T <= 100
1 <= N <= 100

Example:
Input:
2
2
9 10
6
5 4 3 2 1 6
5
99 88 77 66 55
5
55 44 33 22 11

Output:
10 6 9 12 3 4 5
55 11 66 22 77 33 88 44 99 55

Explanation:
Testcase 1:

The two linked list are 10 -> 9 and 6 -> 1-> 2 -> 3 -> 4 -> 5

After merging the two lists as required, the new list is like: 10-> 6-> 9-> 1-> 2-> 3-> 4-> 5.
*/

//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;
    
    public Node(int data){
        this.data = data;
    }
}

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0){
		    
		    Node head1 = null, head2 = null, tail1 = null, tail2 = null;
		    
		    //Input first LL
		    int n1 = sc.nextInt();
            int d1 = sc.nextInt();		    
		    head1 = new Node(d1);
		    tail1 = head1;
		    
		    while(n1-- > 1){
		        Node n = new Node(sc.nextInt());
		        n.next = head1;
		        head1 = n;
		    }
		    
		    //Input second LL
		    int n2 = sc.nextInt();
            int d2 = sc.nextInt();		    
		    head2 = new Node(d2);
		    tail2 = head2;
		    
		    while(n2-- > 1){
		        Node n = new Node(sc.nextInt());
		        n.next = head2;
		        head2 = n;
		    }
		    
		    Solution obj = new Solution();
		    obj.mergeAlt(head1, head2);
		    System.out.println();
		}
	}
	
	public static void po(Object o){
	    System.out.println(o);
	}
	
	public static void show(Node head){
        while(head != null){
            System.out.print(head.data+" ");
            head = head.next;
        }
        System.out.println();
    }
}

// } Driver Code Ends


/*
The structure of node class is : 
class Node {
    int data;
    Node next;
    
    public Node(int data){
        this.data = data;
    }
}
*/
class Solution {
    
    public void mergeAlt(Node head1, Node head2){
        //write your code here, and print the result
        Node first=head1;
        Node second=head2;
        Node nextOfFirst=null;
        Node nextOfSecond=null;
        
        while(head1!=null && head2!=null){
            nextOfFirst=head1.next;
            head1.next=head2;
            head1=nextOfFirst;
            //doing all swaps her alternatively by swapping next nodes
            nextOfSecond=head2.next;
            head2.next=head1;
            head2=nextOfSecond;
        }
        while(first!=null){
            System.out.print(first.data+" ");
            first=first.next;
        }
        System.out.println();
        //this takes care of remaining ele if any
        while(head2!=null){
            System.out.print(head2.data+" ");
            head2=head2.next;
        }
    }
}
