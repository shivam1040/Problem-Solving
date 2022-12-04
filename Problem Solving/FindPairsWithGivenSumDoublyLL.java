/*
Given a sorted doubly linked list of positive distinct elements, the task is to find pairs in a doubly-linked list whose sum is equal to given value target.

 

Example 1:

Input:  
1 <-> 2 <-> 4 <-> 5 <-> 6 <-> 8 <-> 9
target = 7
Output: (1, 6), (2,5)
Explanation: We can see that there are two pairs 
(1, 6) and (2,5) with sum 7.
 

Example 2:

Input: 
1 <-> 5 <-> 6
target = 6
Output: (1,5)
Explanation: We can see that there is one pairs  (1, 5) with sum 6.

 

Your Task:
You don't need to read input or print anything. Your task is to complete the function findPairsWithGivenSum() which takes head node of the doubly linked list and an integer target as input parameter and returns an array of pairs. If there is no such pair return empty array.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)
Constraints:
1 <= N <= 105
1 <= target <= 105
*/

//{ Driver Code Starts
import java.io.*;
import java.util.*;


class Node
{
    int data;
    Node next,prev;
    
    Node(int x)
    {
        data = x;
        next = null;
        prev = null;
    }
    
    public static Node inputList(BufferedReader br) throws IOException
    {
        int n = Integer.parseInt(br.readLine().trim()); // Length of Linked List
        
        String[] s = br.readLine().trim().split(" ");
        Node head = new Node(Integer.parseInt(s[0])), tail = head;
        for(int i = 1; i < s.length; i++){
            Node temp=new Node(Integer.parseInt(s[i]));
            tail.next = temp;
            tail.next.prev = tail;
            tail = tail.next;
        }
        return head;
    }
    
    public static void printList(Node node)
    {
        while (node != null)
        { 
    		System.out.print(node.data + " ");
    		node = node.next; 
    	}  
    	System.out.println();
    }
}


class IntMatrix
{
    public static int[][] input(BufferedReader br, int n, int m) throws IOException
    {
        int[][] mat = new int[n][];
        
        for(int i = 0; i < n; i++)
        {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for(int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }
        
        return mat;
    }
    
    public static void print(int[][] m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
    
    public static void print(ArrayList<ArrayList<Integer>> m)
    {
        if(m.size()==0){
            System.out.println("-1");
        }else{
            for(var a : m)
            {
                System.out.print("(" + a.get(0) + "," + a.get(1) + ")" + " ");
            }
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int target; 
            target = Integer.parseInt(br.readLine());
            
            
            Node head = Node.inputList(br);
            
            Solution obj = new Solution();
            ArrayList<ArrayList<Integer>> res = obj.findPairsWithGivenSum(target, head);
            
            IntMatrix.print(res);
            
        }
    }
}

// } Driver Code Ends


/*

Definition for singly Link List Node
class Node
{
    int data;
    Node next,prev;
    
    Node(int x){
        data = x;
        next = null;
        prev = null;
    }
}

You can also use the following for printing the link list.
Node.printList(Node node);
*/

class Solution {
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, Node head) {
        // code here
        Node end=null;
        Node curr=head;
        ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
        
        while(curr.next!=null){
            curr=curr.next;
            end=curr;
        }
        curr=head;
        
        while(curr.data<end.data){
            int a=curr.data;
            int b=end.data;
            if((a+b)==target){
                ArrayList<Integer> aux=new ArrayList<>();
                aux.add(a);
                aux.add(b);
                res.add(aux);
                curr=curr.next;
                end=end.prev;
            }
            else if((a+b)<target)
                curr=curr.next;
            else
                end=end.prev;
        }
        return res;
    }
}
