/*
Given two numbers, num1 and num2, represented by linked lists of size n and m respectively. The task is to return a linked list that represents the sum of these two numbers.

For example, the number 190 will be represented by the linked list, 1->9->0->null, similarly 25 by 2->5->null. Sum of these two numbers is 190 + 25 = 215, which will be represented by 2->1->5->null. You are required to return the head of the linked list 2->1->5->null.

Note: There can be leading zeros in the input lists, but there should not be any leading zeros in the output list.

Example 1:

Input:
n = 2
num1 = 45 (4->5->null)
m = 3
num2 = 345 (3->4->5->null)
Output: 
3->9->0->null  
Explanation: 
For the given two linked list (4 5) and (3 4 5), after adding the two linked list resultant linked list will be (3 9 0).
Example 2:

Input:
n = 4
num1 = 0063 (0->0->6->3->null)
m = 2
num2 = 07 (0->7->null)
Output: 
7->0->null
Explanation: 
For the given two linked list (0 0 6 3) and (0 7), after adding the two linked list resultant linked list will be (7 0).
Your Task:
The task is to complete the function addTwoLists() which has node reference of both the linked lists and returns the head of the sum list.   

Expected Time Complexity: O(n+m)
Expected Auxiliary Space: O(max(n,m)) for the resultant list.

Constraints:
1 <= n, m <= 104
*/

/*
Intuition:
In this approach, we simulate how in reality we add two numbers. In the code we have taken 9->8->7(987) and 1->2->3(123) as two numbers to add. What we do is reverse these two lists to get 7->8->9 and 3->2->1 and start from the head of the lists to add numbers of individual nodes like we would in practice if we add two numbers. We reversed the linked list since we can move only in one direction so it becomes easy to add while traversing in forward to backward direction. 

For example,  first we add 7 and 3 to get 10, which means carry = 1 and value of new node will be 0. Now we continue this till the end of the list.

Implementation:
Reverse the two number lists.
Simulate addition on nodes one by one. Append each node before the already calculated sum nodes.( You will better understand this step in code)
In the end, we will get the final answer and we can return the head node.
Example:
3.png3.png

*/

//{ Driver Code Starts
// driver

import java.util.*;


// } Driver Code Ends
/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/

class Solution {
    // Function to add two numbers represented by linked list.
    static Node addTwoLists(Node num1, Node num2) {
        // code here
        // return head of sum list
                num1=reverse(num1);
        num2=reverse(num2);
        Node sum=null;
        int carry=0;
        
        while(num1!=null || num2!=null || carry>0){
            int temp=carry;
            
            if(num1!=null)
                temp+=num1.data;
            if(num2!=null)
                temp+=num2.data;
            carry=temp/10;
            //Gives the digit to put in sum
            temp%=10;
            Node temp1=new Node(temp);
            temp1.next=sum;
            sum=temp1;
            
            if(num1!=null)
                num1=num1.next;
            if(num2!=null)
                num2=num2.next;
        }
        //removing starting zeroes
        while(sum!=null && sum.data==0){
            Node temp=sum.next;
            sum.next=null;
            sum=temp;
        }
                if (sum == null) return new Node(0);
        return sum;
    }
    
       private static Node reverse(Node head) {
        Node prev = null;
        Node curr = head;
        Node next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}

//{ Driver Code Starts.

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG {

    static void printList(Node n) {
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {

            int n = sc.nextInt();
            int val = sc.nextInt();

            Node num1 = new Node(val);
            Node tail = num1;
            for (int i = 0; i < n - 1; i++) {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }

            int m = sc.nextInt();
            val = sc.nextInt();

            Node num2 = new Node(val);
            tail = num2;
            for (int i = 0; i < m - 1; i++) {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }

            Solution g = new Solution();
            Node res = g.addTwoLists(num1, num2);
            printList(res);
        }
    }
}

// } Driver Code Ends
