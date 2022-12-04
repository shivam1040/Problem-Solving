/*
A frog starts at the point 0. In his first turn, he can make a jump of 1 unit. Now for all consequent turns, if the frog is currently at a distance x (from the start), his jump will take him x units forward. Given a leaf at a distance N, you have to find if the frog can reach that leaf or not.

 

Example 1:

Input:
N = 3
Output:
False
Explanation:
The frog can't reach the position 3.
Example 2:

Input:
N = 2
Output:
True
Explanation:
The frog will jump to position 1 in
the first jump. Now, he is at a distance
of 1 from the start, so he cam jump 1m.
So, he reaches the point 2.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function canJump() which takes an Integer N as input and return "True" if the frog can reach N else return "False".

 

Expected Time Complexity: O(1)
Expected Auxiliary Space: O(1)

 

Constraints:
1 <= N <= 1018
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
            Long N = Long.parseLong(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.canJump(N));
        }
    }
}
// } Driver Code Ends



class Solution {
    static String canJump(Long N) {
        // code here
        //return (N&(N-1))==0 ? "True":"False";
        
        long n=1, jump=0;
        
        while(jump<N){
            //adding prev jump as the new jump factor
            jump+=n;
            n=jump;
        }
        if(jump==N)
            return "True";
        return "False";
    }
}
