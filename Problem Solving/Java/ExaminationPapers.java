/*
A professor teaches Computer Science in his University. After the End Semester Examination, he checks all the papers and keeps them in descending order based on marks in the form of a pile. However he realizes that he has kept the papers in the box meant for Chemistry papers. He has to transfer the papers to the actual box that too in a pile with descending order of marks, and with some conditions.

1) He can withdraw a paper from the top of a pile only, and also he can place a paper on the top of a pile only.

2) He can keep a paper only at three places: box meant for computer science paper, box meant for chemistry paper, and he can keep the papers on the table also while withdrawing another paper from the top of a pile.

3) He can't keep the papers upon the table separately, i.e, he has to keep those papers in a single pile upon the table.

4) A paper with lower marks never comes below the paper with higher marks in a pile.

Displacing a paper to any pile would be called a move.

He wants to know in advance how many moves would he require. Compute the number of moves.

Example 1:

Input: N = 2
Output: 3 
Explanation: First paper to table,
second paper to actual box, then
again first paper to actual box.

Example 2:

Input: N = 3
Output: 7
Explanation: First paper to actual box,
second paper to table,first paper to table,
third paper to actual box,first paper to
chemistry box,second paper to actual box,
first paper to actual box.

Your Task:  
You dont need to read input or print anything. Complete the function totalMoves() which takes N as input parameter and returns the number of moves. 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints:
1<= N <=50
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
            long N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.totalMoves(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static long totalMoves(long N) {
        // code here
        return (long)Math.pow(2,N)-1;
    }
}
