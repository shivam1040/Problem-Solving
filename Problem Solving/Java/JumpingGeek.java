/*
Once there was a Geek he was quite intelligent and was also fond of jumping. But he jumped in a pattern like 1 leap, 2 leap, 3 leap and again from the start after 3rd leap.
1 leap means if Geek is at point P then he will jump to P+1.
2 leap means if Geek is at point P then he will jump to P+2.
3 leap means if Geek is at point P then he will jump to P+3.
Find whether he could land up to a point N or not.
Note- He starts from point 0.

 

Example 1:

Input: N = 0
Output: yes
Explanation:
Geek is already at Position 0.
Example 2:

Input: N = 1
Output: yes
Explanation:
Geek will land at Position 1
after the 1st jump.
Example 3:

Input: N = 8
Output: no
Explanation:
Geek can't land at Position 8.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function jumpingGeek() which takes an Integer N as input and returns "yes" if geek can reach N, otherwise return "no".

 

Expected Time Complexity: O(1)
Expected Auxiliary Space: O(1)

 

Constraints:
0 <= N <= 108
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
            System.out.println(ob.jumpingGeek(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static String jumpingGeek(int N) {
        // code here
        int i=0;
        // N%6, it would always havd remainder of 0, 1, 3, which means yes it can reach N
        while(i<=N){
            if(i==N)
                return "yes";
            i+=1;
            if(i==N)
                return "yes";
            i+=2;
            if(i==N)
                return "yes";
            i+=3;
            if(i==N)
                return "yes";
        }
        return "no";
    }
};
