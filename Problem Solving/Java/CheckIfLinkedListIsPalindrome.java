/*
Given a singly linked list of size N of integers. The task is to check if the given linked list is palindrome or not.

Example 1:

Input:
N = 3
value[] = {1,2,1}
Output: 1
Explanation: The given linked list is
1 2 1 , which is a palindrome and
Hence, the output is 1.
Example 2:

Input:
N = 4
value[] = {1,2,3,4}
Output: 0
Explanation: The given linked list
is 1 2 3 4 , which is not a palindrome
and Hence, the output is 0.
Your Task:
The task is to complete the function isPalindrome() which takes head as reference as the only parameter and returns true or false if linked list is palindrome or not respectively.

Expected Time Complexity: O(N)
Expected Auxialliary Space Usage: O(1)  (ie, you should not use the recursive stack space as well)

Constraints:
1 <= N <= 105
*/

/*
Intuition:
The idea is to first reverse the second half part of the linked list and then compare second half with first half of linked list if these two halves are identical then linked lit is palindrome.

Implementation
Get the middle of the linked list and divide the linked list into two halves, take special care if number of nodes are odd i.e. then ignore the middle element. 
Reverse the second half of the linked list. 
Now check if the first half and second half are identical, 
If yes, then the linked list is palindrome.
Else, its not palindrome.
Construct the original linked list by reversing the second half again and attaching it back to the first half.
*/

//{ Driver Code Starts
import java.util.*;

class Node
{
	int data;
	Node next;
	
	Node(int d)
	{
		data = d;
		next = null;
	}
}

class Is_LinkedList_Palindrom
{
	 Node head;  
	 Node tail;
	
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
		{
			head = node;
			tail = node;
		} else 
		{
		    tail.next = node;
		    tail = node;
		}
    }
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		 
		while(t>0)
        {
			int n = sc.nextInt();
			//int k = sc.nextInt();
			Is_LinkedList_Palindrom llist = new Is_LinkedList_Palindrom();
			//int n=Integer.parseInt(br.readLine());
			int a1=sc.nextInt();
			Node head= new Node(a1);
            Node tail = head;
            for (int i = 1; i < n; i++) 
			{
				int a = sc.nextInt(); 
			    tail.next = new Node(a);
			    tail = tail.next;
			}
			
			Solution g = new Solution();
			if(g.isPalindrome(head) == true)
			    System.out.println(1);
		    else
			    System.out.println(0);
			t--;
		}
		
	}
}




// } Driver Code Ends


/* Structure of class Node is
class Node
{
	int data;
	Node next;
	
	Node(int d)
	{
		data = d;
		next = null;
	}
}*/

class Solution
{
    //Function to check whether the list is palindrome.
    boolean isPalindrome(Node head) 
    {
        //Your code here
        int size=0;
        Node ptr;
        
        //finding number of nodes
        for(ptr=head; ptr!=null; ptr=ptr.next)
            size++;
        if(size<2)
            return true;
        ptr=head;
        int mid=(size-1)/2;
        //getting to mid
        while(mid>0){
            ptr=ptr.next;
            mid--;
        }
        //getting the second half
        Node head2=ptr.next;
        //putting first head next to null so that it doesn't got to second half
        ptr.next=null;
        //reversing it
        head2=reverse_list(head2);
        
        return is_identical(head, head2);
    }
    
    private Node reverse_list(Node head)
    {
        Node prev = null;   
        Node curr = head; 
        Node next;  
        
        while(curr!=null)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr; 
            curr = next;
        }
        
        return prev;
    }
    
    private boolean is_identical(Node n1, Node n2){
        for(;n1!=null&&n2!=null; n1=n1.next, n2=n2.next)
            if(n1.data!=n2.data)
                return false;
        return true;
    }
}


