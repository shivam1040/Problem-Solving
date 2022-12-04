/*
Given a Matrix mat of N*N size, the task is to complete the function constructLinkedMatrix(), that constructs a 2D linked list representation of the given matrix.

Input : 2D matrix 
1 2 3
4 5 6
7 8 9

Output :
1 -> 2 -> 3 -> NULL
|    |    |
v    v    v
4 -> 5 -> 6 -> NULL
|    |    |
v    v    v
7 -> 8 -> 9 -> NULL
|    |    |
v    v    v
NULL NULL NULL
Input:
The fuction takes 2 argument as input, first the 2D matrix mat[][] and second an integer variable N, denoting the size of the matrix.
There will be T test cases and for each test case the function will be called separately.

Output:
The function must return the reference pointer to the head of the linked list.

Constraints:
1<=T<=100
1<=N<=150

Example:
Input:
2
3
1 2 3 4 5 6 7 8 9
2
1 2 3 4
Output:
1 2 3 4 5 6 7 8 9
1 2 3 4
*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.Scanner;
class Node
{
    int data;
    Node right,down;
    
    Node(int data){
        this.data = data;
        right = null;
        down = null;
    }
}
public class Linked_list_2D_Matrix {
 
    // node of linked list
 
    static void display(Node head) {
         
        Node Rp;
    	Node Dp = head;
    	while (Dp != null) {
    		Rp = Dp;
    		while (Rp != null) {
    			System.out.print(Rp.data + " ");
    			if(Rp.right != null) System.out.print(Rp.right.data + " ");
    			else System.out.print("Null ");
    			if(Rp.down != null)System.out.print(Rp.down.data + " ");
    			else System.out.print("Null ");
    			Rp = Rp.right;
    		}
    		
    		Dp = Dp.down;
    	}
    }
 
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
        int n=sc.nextInt();
        int [][]arr=new int[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++){
            int p=sc.nextInt();arr[i][j]=p;}
        }
        GFG obj=new GFG();
        Node head = obj.construct(arr, n);
        display(head);
        System.out.println();
        }
    }
 
}
// } Driver Code Ends


//User function Template for Java

 /*class Node

class Node
{
    int data;
    Node right,down;
    
    Node(int data){
        this.data = data;
        right = null;
        down = null;
    }
}
*/
/*Function should return the head of the 2D LL.*/
class GFG
{
    static Node construct(int arr[][],int n)
    {
        //Add your code here
        Node head=null;
        return build(arr, 0, 0, n, head);
    }
    
    static Node build(int arr[][], int r, int c, int n, Node head){
        if(r>=n || c>=n)
            return null;
        head=new Node(arr[r][c]);
        head.right=build(arr, r, c+1, n, head.right);
        head.down=build(arr, r+1, c, n, head.down);
        return head;
    }
}
