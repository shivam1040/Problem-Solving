/*
Given a value N. Find number of values X (1<=X<=N) which satisfy the equation.
X + S(F(X)) + S(F(S(F(X))) = N, where F(X) is a function which returns the product of digits of X, and S(X) is a function which returns sum of digits of X.

 

Example 1:

Input:
N = 6
Output:
1
Explanation:
There is only one solution when N = 6,
i.e. X = 2. F(X) = 2, S(F(X)) = 2,
F(S(F(X))) = 2, S(F(S(F(X))) = 2. Therefore,
X + S(F(X)) + S(F(S(F(X))) = 2+2+2 = 6
Example 2:

Input:
N = 2
Output:
0
Explanation:
There are no possible solutions for N = 2.
Your Task:
You don't need to read input or print anything. Your task is to complete the function findX() which takes an Integer N as input and returns the count of numbers satisfying the given equation.

 

Expected Time Complexity: O(log10N)
Expected Auxiliary Space: O(1)

 

Constraints:
1 <= N <= 105
*/

/*
The value of S(F(X)) +S(F(S(F(X))) can never exceed 100 so X will lie in the range [max(N-100,0),N]. To check for each value of X in the following we range we need nearly 4Log N operations. Each of the query can be solved in 100*4 Log N i.e. O(Log N) time.
*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.findX(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int findX(int N) {
        // code here
        int X, max=0, cnt=0;
        
        if(N-100>0)
            max=N-100;
        for(X=max; X<=N; X++){
            int temp=X+S(F(X))+S(F(S(F(X))));
            
            if(N==temp)
                cnt++;
        }
        return cnt;
    }
    
       private static int S(int X){
        int dig=0;
        int sum=0;
        while(X>0){
            dig=X%10;
            sum=sum+dig;
            X=X/10;
        }
        return sum*1;
    }
    private static int F(int X){
       int dig=0;
        int pro=1;
       while(X>0){
           dig=X%10;
            pro=pro*dig*1;
            X=X/10; 
       }
    return pro;
    }
       
};
