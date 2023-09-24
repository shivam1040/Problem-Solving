/*
Jack is very fond of reading. He reads a lot many pages of books in a day. Since he is obsessed with reading, he reads K times more pages than the number of pages he read the previous day.He read 1 page on the first day. He wants to see that on any given day N, how many pages will he read.Since the answer can be very large, find the answer in modulo 109+7.

Example 1:

Input: N = 5, K = 2 
Output: 16 
Explanation: 
On Day 1 : 1
On Day 2 : 2
On Day 3 : 4
On Day 4 : 8
On Day 5 : 16
So the answer is 16. 

Example 2:

Input: N = 2, K = 3 
Output: 3
Explanation: 
On Day 1 : 1
On Day 2 : 3
So the answer is 3. 

Your Task:  
You dont need to read input or print anything. Complete the function nthDayPage() which takes N and K as input parameter and returns the answer.

Expected Time Complexity: O(1)
Expected Auxiliary Space: O(1)

Constraints:
1<= N <=106
1<= K <=103


*/

//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String[] input = new String[2]; 
            input = read.readLine().split(" "); 
            long N = Integer.parseInt(input[0]); 
            long K = Integer.parseInt(input[1]);
            Solution ob = new Solution();

            System.out.println(ob.nthDayPage(N,K));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    static long nthDayPage(long N, long K){
        // code here
        long res=1, mod=1000000007;
        
        for(long i=1; i<N; i++)
            res=(res*K)%mod;
        return res;
    }
}
