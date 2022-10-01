/*
Given array A[] of integers, the task is to complete the function findMaxDiff which finds the maximum absolute difference between nearest left and right smaller element of every element in array.If the element is the leftmost element, nearest smaller element on left side is considered as 0. Similarly if the element is the rightmost elements, smaller element on right side is considered as 0.

Examples:

Input : arr[] = {2, 1, 8}
Output : 1
Left smaller  LS[] {0, 0, 1}
Right smaller RS[] {1, 0, 0}
Maximum Diff of abs(LS[i] - RS[i]) = 1 

Input  : arr[] = {2, 4, 8, 7, 7, 9, 3}
Output : 4
Left smaller   LS[] = {0, 2, 4, 4, 4, 7, 2}
Right smaller  RS[] = {0, 3, 7, 3, 3, 3, 0}
Maximum Diff of abs(LS[i] - RS[i]) = 7 - 3 = 4 

Input : arr[] = {5, 1, 9, 2, 5, 1, 7}
Output : 1
Input:
The first line of input contains an integer T denoting the no of test cases. Then T test cases follow .Each test case contains an integer N denoting the size of the array A. In the next line are N space separated values of the array A.

Output:
For each test case output will be in a new line denoting the the maximum absolute difference between nearest left and right smaller element of every element in array.

Constraints:
1<=T<=100
1<=N<=100
1<=A[ ]<=100

Example(To be used only for expected output) :
Input:
2
3
2 1 8
7
2 4 8 7 7 9 3
Output
1
4
*/

/*
Find all smaller element on left side
     1. Create a new empty stack S and an array LS[]
     2. For every element 'arr[i]' in the input arr[],
          where 'i' goes from 0 to n-1.
        a) while S is nonempty and the top element of 
           S is greater than or equal to 'arr[i]':
           pop S
    
        b) if S is empty:
           'arr[i]' has no preceding smaller value 
            LS[i] = 0 
            
        c) else:
            the nearest smaller value to 'arr[i]' is top
            of stack
              LS[i] = s.top()

        d) push 'arr[i]' onto S   

Find all smaller element on right side
     3. First reverse array arr[]. After reversing the array, 
        right smaller become left smaller.
     4. Create an array RRS[] and repeat steps  1 and 2 to 
        fill RRS (in-place of LS).
         
5. Initialize result as -1 and do following for every element
   arr[i]. In the reversed array right smaller for arr[i] is
   stored at RRS[n-i-1]
      return result = max(result, LS[i]-RRS[n-i-1])
*/

//{ Driver Code Starts
import java.util.*;

class GFG
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			int n = sc.nextInt();
			int a[] = new int[n];
			for(int i=0; i<n; i++)
				a[i] = sc.nextInt();
			Solution ob = new Solution();
			System.out.println(ob.findMaxDiff(a,n));
		t--;
		}
	}
}
// } Driver Code Ends


class Solution
{
    int findMaxDiff(int a[], int n)
    {
	// Your code here
	int ls[]=new int[n];
	int rs[]=new int[n];
	Stack<Integer> aux=new Stack<>();
	int res=Integer.MIN_VALUE;
	
	//the idea is to store checked values in stack to avoid reiterating them again and again
	for(int i=0; i<n; i++){
	    // a/q if stack is empty then there is no nearest smaller
	    if(aux.isEmpty())
	        ls[i]=0;
	        //this ensures either 0 or nearest lowest value
	   while(aux.size()>0){
	       int b=aux.peek();
	       if(b<a[i]){
	        ls[i]=b;
	        break;
	       }
	       else{
	           aux.pop();
	        ls[i]=0;
	       }
	   }
	   //pushing the last traveresed element in stack so that it can take part in checking, above while loop, when we move forward in array
	   aux.push(a[i]);
	}
	
	aux.clear();
	
		for(int i=n-1; i>=0; i--){
	    if(aux.isEmpty())
	        rs[i]=0;
	   while(aux.size()>0){
	       int b=aux.peek();
	       if(b<a[i]){
	        rs[i]=b;
	        break;
	       }
	       else{
	           aux.pop();
	        rs[i]=0;
	       }
	   }
	   aux.push(a[i]);
	}
	
	for(int i=0; i<n; i++){
	    int diff=Math.abs(ls[i]-rs[i]);
	    if(diff>res)
	        res=diff;
	}
	return res;
    }
}
