/*
Given elements of a stack, clone the stack without using extra space.


Example 1:

Input:
N = 10
st[] = {1, 1, 2, 2, 3, 4, 5, 5, 6, 7}
Output:
1 

Your Task:  
You don't need to read input or print anything. Your task is to complete the function clonestack() which takes the input stack st[], an empty stack cloned[], you have to clone the stack st into stack cloned.
The driver code itself prints 1 in the output if the stack st is cloned properly and prints 0 otherwise.


Expected Time Complexity: O(N*N)
Expected Auxiliary Space: O(1)
 

Constraints:
1 <= N <= 1000
1<= st[i] <= 105
*/

// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
    
            String S[] = read.readLine().split(" ");
            
            Stack<Integer> st = new Stack<Integer>();
            ArrayList<Integer> copy = new ArrayList<>();
            
            for(int i=0; i<N; i++)
            {
                st.push(Integer.parseInt(S[i]));
                copy.add(Integer.parseInt(S[i]));
            }
            
            Collections.reverse(copy);
            
            Stack<Integer> cloned = new Stack<Integer>();
            
            Solution ob = new Solution();
            
            ob.clonestack(st,cloned);
            
            ArrayList<Integer> check = new ArrayList<>();
            while(cloned.size() != 0)
                check.add(cloned.pop());
            
            int flag = 0;
            
            if(copy.equals(check))
                flag = 0;
            else
                flag = 1;
            
            System.out.println(1-flag);
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    void clonestack(Stack<Integer> st, Stack<Integer> cloned) {
        /*
        int count=0;
        while(!st.empty()){
            while(st.size()!=1){
                cloned.push(st.peek());
                st.pop();
            }
            int temp=st.peek();
            st.pop();
            while(!cloned.empty() && cloned.size()!=count){
                st.push(cloned.top());
                cloned.pop();
            }
            cloned.push(temp);
            count++;
        }
        */
        if(st.empty())
            return;
        int element=st.peek();
        st.pop();
        clonestack(st, cloned);
        cloned.push(element);
    }
}