/*
Given an integer N, check if it is possible to represent it as a function(a, b) such that : a2 + b2 = N where "a" and "b" are whole numbers. Print 1 if it's possible, else Print 0.

 

Example 1:

Input:
N = 1
Output:
1
Explanation:
12 + 02 = 1. So, the Output is 1
Example 2:

Input:
N = 2
Output:
1
Explanation:
12 + 12 = 2. So, the Output is 1
Example 3:

Input:
N = 7
Output:
0
Explanation:
We don't have a or b, which when summed
after squaring gives 7. So, Output is 0.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function checkSquares() which takes an Integer N as input and returns the answer.

 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

 

Constraints:
1 <= N <= 106
*/

//{ Driver Code Starts
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
            System.out.println(ob.checkSquares(N));
        }
    }
}
// } Driver Code Ends


class Solution {
    static int checkSquares(int N) {
        // code here
        if(perfectSquare(N) || N<=1)
            return 1;
        for(int i=1; i*i<=N; i++){
            int temp=N-(i*i);
            
            if(perfectSquare(temp))
                return 1;
        }
        return 0;
    }
    
    static boolean perfectSquare(int a){
        int temp=(int)Math.sqrt(a);
        
        return temp*temp==a;
    }
};
