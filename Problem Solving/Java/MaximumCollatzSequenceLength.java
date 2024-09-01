/*
Starting with any positive integer N, we define the Collatz sequence corresponding to N as the
numbers formed by the following operations:
If N is even, N→ N/2
if N is odd,   N→ 3N+ 1
It is conjectured but not yet proven that no matter which positive integer we start with; we always
end up with 1.
For example, 10 → 5  → 16  → 8  → 4  → 2  → 1. You have to give the maximum collatz
sequence length among all the numbers from 1 to N(both included).
Example 1:
Input: N = 1
Output: 1
Explaination: Here N can have only one
value 1.
Example 2:
Input: N = 3
Output: 8
Explaination: For N= 3 we need to check
sequence length when sequence starts with
1, 2, and 3.
when sequence starts with 1, it's : 1
length = 1
when sequence starts with 2, it's : 2->1,
length = 2
when sequence starts with 3, it's :
3->10->5->16->8->4->2->1, length = 8.
Your Task:
You do not need to read input or print anything. Your task is to complete the
27/09/2023, 14:37 Maximum Collatz sequence length | Practice | GeeksforGeeks
https://practice.geeksforgeeks.org/problems/maximum-collatz-sequence-length5849/1?page=70&difficulty[]=-1&difficulty[]=0&status[]=solved&status[]=unsol… 2/2
function collatzLength()which takes N as input parameter and returns the maximum collatz
sequence length.
Expected Time Complexity:O(N)
Expected Auxiliary Space: O(N)
Constraints:
1 < N < 106
*/

/*
//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.collatzLength(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int collatzLength(int N){
        // code here
        int res=0;
        
        while(N>0){
            int temp1=1;
            int temp=N;
            
            while(temp>1){
            
            if(temp%2==0)
                temp/=2;
            else
                temp=temp*3+1;
            temp1++;
            }
            res=Math.max(temp1, res);
            N--;
        }
        return res;
    }
}
*/
