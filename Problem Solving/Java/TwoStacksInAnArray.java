/*
Your task is to implement  2 stacks in one array efficiently.

 

Example 1:

Input:
push1(2)
push1(3)
push2(4)
pop1()
pop2()
pop2()

Output:
3 4 -1

Explanation:
push1(2) the stack1 will be {2}
push1(3) the stack1 will be {2,3}
push2(4) the stack2 will be {4}
pop1()   the poped element will be 3 
from stack1 and stack1 will be {2}
pop2()   the poped element will be 4 
from stack2 and now stack2 is empty
pop2()   the stack2 is now empty hence -1 .
 

Your Task:
You don't need to read input or print anything. You are required to complete the 4 methods push1, push2 which takes one argument an integer 'x' to be pushed into stack one and two and pop1, pop2 which returns the integer poped out from stack one and two. If no integer is present in the array return -1.

 

Expected Time Complexity: O(1) for all the four methods.
Expected Auxiliary Space: O(1) for all the four methods.

 

Constraints:
1 <= Number of queries <= 100
1 <= value in the stack <= 100
The sum of elements in both the stacks < size of the given array
*/

// { Driver Code Starts
    import java.util.*;

    class TwoStack
    {
        
        int size;
        int top1,top2;
        //int arr[] = new int[size];
        int arr[] = new int[100]; 
        
        TwoStack()
        {
            int n =100;
            size = n;
            //arr[] = new int[n];
            top1 = -1;
            top2 = size;
        }
        
        
        public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in); 
            int T = sc.nextInt();
            while(T>0)
            {
                TwoStack sq = new TwoStack();
                
                int Q = sc.nextInt();
                while(Q>0)
                {
                    int stack_no = sc.nextInt();
                    int QueryType = sc.nextInt();
                    
                    Stacks g = new Stacks();
                    
                    if(QueryType == 1)
                    {
                        int a = sc.nextInt();
                        if(stack_no == 1)
                         g.push1(a,sq);
                        else if(stack_no ==2)
                         g.push2(a,sq);
                    }else if(QueryType == 2)
                    {
                        if(stack_no==1)
                        System.out.print(g.pop1(sq)+" ");
                        else if(stack_no==2)
                        System.out.print(g.pop2(sq)+" ");
                    }
                
                    Q--;
                }
                    System.out.println();
              T--;
            }
        }
    }
    
    // } Driver Code Ends
    
    
    /* Structure of the class is
    class TwoStack
    {
    
        int size;
        int top1,top2;
        int arr[] = new int[100];
    
        TwoStack()
        {
            size = 100;
            top1 = -1;
            top2 = size;
        }
    }*/
    
    class Stacks
    {
        //Function to push an integer into the stack1.
        void push1(int x, TwoStack sq)
        {
         if(sq.top1==-1){
             sq.top1++;
             sq.arr[sq.top1]=x;
         }
         else{
             sq.top1++;
             sq.arr[sq.top1]=x;
         }
        }
    
        //Function to push an integer into the stack2.
        void push2(int x, TwoStack sq)
        {
          if(sq.top2==sq.size){
             sq.top2--;
             sq.arr[sq.top2]=x;
         }
         else{
             sq.top2--;
             sq.arr[sq.top2]=x;
         }  
        }
    
        //Function to remove an element from top of the stack1.
        int pop1(TwoStack sq)
        {
            int temp=0;
            if(sq.top1==-1){
                return -1;
         }
         else{
             
             temp=sq.arr[sq.top1];
             sq.arr[sq.top1]=-1;
             sq.top1--;
         }
         return temp;
        }
    
        //Function to remove an element from top of the stack2.
        int pop2(TwoStack sq)
        {
            int temp=0;
            if(sq.top2==sq.size){
                return -1;
         }
         else{
             
             temp=sq.arr[sq.top2];
             sq.arr[sq.top2]=-1;
             sq.top2++;
         }
         return temp;
        }
    }