/*
The tower of Hanoi is a famous puzzle where we have three rods and n disks. The objective of the puzzle is to move the entire stack to another rod. You are given the number of discs n. Initially, these discs are in the rod 1. You need to print all the steps of discs movement so that all the discs reach the 3rd rod. Also, you need to find the total moves.

You only need to complete the function toh() that takes following parameters: n (number of discs), from (The rod number from which we move the disc), to (The rod number to which we move the disc), aux (The rod that is used as an auxiliary rod) and prints the required moves inside function body (See the example for the format of the output) as well as return the count of total moves made.

Note: The discs are arranged such that the top disc is numbered 1 and the bottom-most disc is numbered n. Also, all the discs have different sizes and a bigger disc cannot be put on the top of a smaller disc. Refer the provided link to get a better clarity about the puzzle.

 

 

Examples:

Input:
n = 2
Output:
move disk 1 from rod 1 to rod 2
move disk 2 from rod 1 to rod 3
move disk 1 from rod 2 to rod 3
3
Explanation: For N=2 , steps will be as follows in the example and total 3 steps will be taken.
Input:
n = 3
Output:
move disk 1 from rod 1 to rod 3
move disk 2 from rod 1 to rod 2
move disk 1 from rod 3 to rod 2
move disk 3 from rod 1 to rod 3
move disk 1 from rod 2 to rod 1
move disk 2 from rod 2 to rod 3
move disk 1 from rod 1 to rod 3
7
Explanation: For N=3 , steps will be as follows in the example and total 7 steps will be taken.
Expected Time Complexity: O(2n).
Expected Auxiliary Space: O(n).

Constraints:
0 <= n <= 16
*/

/*
Intuition: 
The idea is to use the helper node to reach the destination using recursion. Below is the pattern for this problem:

 Shift ‘N-1’ disks from ‘A’ to ‘B’, using C.
 Shift the last disk from ‘A’ to ‘C’.
 Shift ‘N-1’ disks from ‘B’ to ‘C’, using A.
Steps 1 and 3 are actually the same as the original problem. Thus we have derived a recursive solution for the given problem.


Let's derive the base case.
Base Case:
N=1 then simply move the disk from the source rod to the destination rod.

Implementation:
Create a function towerOfHanoi where pass the N (current number of disk), srcRod, destRod, helperRod.
Make a function call for  N – 1 disk. (move them from srcRod to helperRod)
Then print the current disk along with srcRod and destRod
Again make a function call for N – 1  disk (move them from helperRod to srcRod).

Move for 3 disks

*/

//{ Driver Code Starts
// Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Recursion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt(); // total testcases
        while (T-- > 0) {
            Hanoi obj = new Hanoi();
            int N;

            // taking input N
            N = sc.nextInt();

            // calling toh() method
            System.out.println(obj.toh(N, 1, 3, 2));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

// avoid space at the starting of the string in "move disk....."
class Hanoi {

    public long toh(int n, int from, int to, int aux) {
        // Your code here
        long moves=0L;
        
        if(n>=1){
            moves+=toh(n-1, from, aux, to);
            System.out.println("move disk " + n + " from rod " + from + " to rod " +
                               to);
            moves++;
            
            moves+=toh(n-1, aux, to, from);
        }
        return moves;
    }
}

