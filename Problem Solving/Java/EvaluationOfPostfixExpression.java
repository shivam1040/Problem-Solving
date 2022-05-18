/*
Given string S representing a postfix expression, the task is to evaluate the expression and find the final value. Operators will only include the basic arithmetic operators like *, /, + and -.

 

Example 1:

Input: S = "231*+9-"
Output: -4
Explanation:
After solving the given expression, 
we have -4 as result.
Example 2:

Input: S = "123+*8-"
Output: -3
Explanation:
After solving the given postfix 
expression, we have -3 as result.

Your Task:
You do not need to read input or print anything. Complete the function evaluatePostfixExpression() that takes the string S denoting the expression as input parameter and returns the evaluated value.


Expected Time Complexity: O(|S|)
Expected Auixilliary Space: O(|S|)


Constraints:
1 ≤ |S| ≤ 105

0 ≤ |Si|≤ 9 (And given operators)
*/


// { Driver Code Starts
    import java.util.*;
    import java.lang.*;
    import java.io.*;
    
    class GFG {
        
        public static void main (String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine().trim());
            while(t-->0){
                System.out.println(new Solution().evaluatePostFix(br.readLine().trim()));
            }
        }
    }// } Driver Code Ends
    
    
    class Solution
    {
        //Function to evaluate a postfix expression.
        public static int evaluatePostFix(String s)
        {
            Stack<Integer> aux=new Stack<Integer>();
            for(int i=0; i<s.length(); i++){
                if(s.charAt(i)>='0' && s.charAt(i)<='9')
                    aux.push(Character.getNumericValue(s.charAt(i)));
                else{
                    int a=aux.pop();
                    int b=aux.pop();
                    switch(s.charAt(i)){
                        case '+':
                            aux.push(b+a);
                            break;
                        case '-':
                            aux.push(b-a);
                            break;
                        case '*':
                            aux.push(b*a);
                            break;
                        case '/':
                            aux.push(b/a);
                            break;
                    }
                }
            }
            return aux.pop();
        }
    }