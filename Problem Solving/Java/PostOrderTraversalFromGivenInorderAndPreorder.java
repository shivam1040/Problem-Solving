/*
Given a preOrder and inOrder traversal of a binary tree your task is to print the postOrder traversal of the tree .You are required to complete the function printPostOrder which prints the node of the tree in post order fashion . You should not read any input from stdin/console. There are multiple test cases. For each test case, this method will be called individually.

Example 1:

Input
6
4 2 5 1 3 6
1 2 4 5 3 6
Output 4  5  2  6  3 1
Input Format:
The task is to complete the function printPostOrder which takes 3 argument, the first being the array of inOrder Traversal of the tree (in) , the second beeing the preOrder traversal of the tree (pre) and third being the no of nodes of the Tree (N).
There are multiple test cases. For each test case, this method will be called individually.

Output Format:
The function should print the PostOrder traversal of the binary tree separated by space.

Your Task:
Complete the function printPostOrder.

Constraints:
1 <=T<= 30
1 <=Number of nodes<= 100
1 <=Data of a node<= 1000
*/

//{ Driver Code Starts
import java.util.*;


class PostOrder
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int  T = sc.nextInt();
		while(T>0)
		{
			int N = sc.nextInt();
			int pre[] = new int[N];
			int in[] = new int[N];
			for(int i=0;i<N;i++)
				in[i]=sc.nextInt();
			for(int i=0;i<N;i++)
				pre[i]=sc.nextInt();
			GfG g = new GfG();
			g.printPostOrder(in,pre,N);
			System.out.println();
		T--;
		}
	}
}
// } Driver Code Ends


/*prints the post order traversal of the 
tree */
class GfG
{
	void printPostOrder(int in1[], int pre[], int n)
	{
		    // The first element in pre[] is
    // always root, search it in in[]
    // to find left and right subtrees
    int root = search(in1, pre[0], n);
 
    // If left subtree is not empty,
    // print left subtree
    if (root != 0)
        printPostOrder(in1, Arrays.copyOfRange(pre, 1, n), root);
 
    // If right subtree is not empty,
    // print right subtree
    if (root != n - 1)
        printPostOrder(Arrays.copyOfRange(in1, root+1, n),
            Arrays.copyOfRange(pre, 1+root, n), n - root - 1);
 
    // Print root
    System.out.print( pre[0] + " ");
		
	}
	
	private int search(int arr[], int x, int n){
	    for(int i=0; i<n; i++)
	        if(arr[i]==x)
	            return i;
	   return -1;
	}
}
