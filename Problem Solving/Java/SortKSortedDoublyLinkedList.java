/*
Given a doubly linked list containing N nodes, where each node is at most K-indices away from its target position in the list. The problem is to sort the given doubly linked list. The distance can be assumed in either of the directions (left and right).

Example 1:

Input:  3 <-> 2 <-> 1 <-> 5 <-> 6 <-> 4
K = 2
Output: 1 <-> 2 <-> 3 <-> 4 <-> 5 <-> 6
Explanation: 
After sorting the given 2 sorted
list is 1 <-> 2 <-> 3 <-> 4 <-> 5 <-> 6.
Example 2:

Input: 5 <-> 6 <-> 7 <-> 3 <-> 4 <-> 4
K = 3
Output: 3 <-> 4 <-> 4 <-> 5 <-> 6 <-> 7
Explanation: 
After sorting the given 3 sorted
list is 3 <-> 4 <-> 4 <-> 5 <-> 6 <-> 7.
Your Task:
You don't need to read input or print anything. Your task is to complete the function sortAKSortedDLL() which takes head node of the doubly linked list as input parameter and returns the head node after sorting.


Expected Time Complexity: O(N*logK)
Expected Auxiliary Space: O(k)


Constraints:
1 <= N <= 105
1 <= K < N
*/

/*
Sort the given doubly linked list using the insertion sort technique. While inserting each element in the sorted part of the list, there will be at most k swaps to place the element to its correct position since it is at most k steps away from its correct position.

Implementation
Start by making a Node *current = head and then run a loop till current is not NULL.
Make a Node *back = current -> prev and an integer variable named key = current->data.
Now run a loop till back is not NULL and the key is less than current->data.
Inside this loop update back -> next -> data = back -> data and back= back -> prev.
After exiting this loop check if the back is NULL or not. If it is NULL, then update head -> data = key;
Else update back -> next -> data = key, and after this update current = current -> next.
At last return head, which is our answer.
*/

//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next, prev;

    Node(int key) {
        data = key;
        next = null;
        prev = null;
    }
}

public class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine().trim());
            int k = Integer.parseInt(in.readLine().trim());
            String s[] = in.readLine().trim().split(" ");
            Node head = new Node(Integer.parseInt(s[0]));
            Node tail = head;
            for (int i = 1; i < n; i++) {
                Node temp = new Node(Integer.parseInt(s[i]));
                tail.next = temp;
                temp.prev = tail;
                tail = temp;
            }
            Solution ob = new Solution();
            Node ans = ob.sortAKSortedDLL(head, k);
            Node temp = ans;
            while (temp != null) {
                out.print(temp.data + " ");
                temp = temp.next;
            }out.println();
        }
        out.close();

    }
}

// } Driver Code Ends


//User function Template for Java
class Solution {
    public Node sortAKSortedDLL(Node head, int k) {
        if(head==null || head.next==null)
            return head;
        for(Node i=head.next; i!=null; i=i.next){
            Node j=i;
            
            while(j.prev!=null && j.data<j.prev.data){
                Node temp=j.prev.prev, temp2=j.prev, temp3=j.next;
                j.prev.next=temp3;
                j.prev.prev=j;
                j.prev=temp;
                j.next=temp2;
                
                if(temp!=null)
                    temp.next=j;
                if(temp3!=null)
                    temp3.prev=temp2;
            }
            if(j.prev==null)
                head=j;
        }
        return head;
    }
}

