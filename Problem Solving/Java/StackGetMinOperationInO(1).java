/*
Design a data-structure SpecialStack that supports all the stack operations like push(), pop(), isEmpty(), isFull() and an additional operation getMin() which should return minimum element from the SpecialStack. Your task is to complete all the functions, using stack data-Structure.


Example 1:

Input:
Stack: 18 19 29 15 16
Output: 15
Explanation:
The minimum element of the stack is 15.
 


Your Task:
Since this is a function problem, you don't need to take inputs. You just have to complete 5 functions, push() which takes the stack and an integer x as input and pushes it into the stack; pop() which takes the stack as input and pops out the topmost element from the stack; isEmpty() which takes the stack as input and returns true/false depending upon whether the stack is empty or not; isFull() which takes the stack and the size of the stack as input and returns true/false depending upon whether the stack is full or not (depending upon the
given size); getMin() which takes the stack as input and returns the minimum element of the stack. 
Note: The output of the code will be the value returned by getMin() function.


Expected Time Complexity: O(N) for getMin, O(1) for remaining all 4 functions.
Expected Auxiliary Space: O(1) for all the 5 functions.


Constraints:
1 ≤ N ≤ 104
*/

// { Driver Code Starts
    import java.util.Scanner;
    import java.util.Stack;
    class SpeStack{
        public static void main(String[] args){
            Scanner sc=new Scanner(System.in);
            int t=sc.nextInt();
            while(t-->0){
                int n=sc.nextInt();
                Stack<Integer> s=new Stack<>();
                GfG g=new GfG();
                while(!g.isEmpty(s)){
                    g.pop(s);
                }
                while(!g.isFull(s,n)){
                    g.push(sc.nextInt(),s);
                }
            System.out.println(g.min(s));
            }
        }
    }// } Driver Code Ends
    
    
    /*Complete the function(s) below*/
    class GfG{
        int temp=Integer.MAX_VALUE;
        public void push(int a,Stack<Integer> s)
        {   
            if(a<temp)
                temp=a;
            s.push(a);
        }
        public int pop(Stack<Integer> s)
            {
                return s.pop();
        }
        public int min(Stack<Integer> s)
            {
                /*
                int temp=Integer.MAX_VALUE;
               for(int x:s){
                    if(x<temp)
                        temp=x;
               }
               */
               return temp;
        }
        public boolean isFull(Stack<Integer>s, int n)
            {
               if(s.size()==n)
                return true;
            return false;
        }
        public boolean isEmpty(Stack<Integer>s)
            {
               if(s.isEmpty())
                return true;
            return false;
        }
    }