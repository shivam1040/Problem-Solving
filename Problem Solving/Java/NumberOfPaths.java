/*
The problem is to count all the possible paths from top left to bottom right of a MxN matrix with the constraints that from each cell you can either move to right or down.

Example 1:

Input:
M = 3 and N = 3
Output: 6
Explanation:
Let the given input 3*3 matrix is filled 
as such:
A B C
D E F
G H I
The possible paths which exists to reach 
'I' from 'A' following above conditions 
are as follows:ABCFI, ABEHI, ADGHI, ADEFI, 
ADEHI, ABEFI
 

Example 2:

Input:
M = 2 and N = 8
Output: 8

Your Task:  
You don't need to read input or print anything. Your task is to complete the function numberOfPaths() which takes the integer M and integer N as input parameters and returns the number of paths..

Expected Time Complexity: O(m + n - 1))
Expected Auxiliary Space: O(1)

 

Constraints:
1 ≤ M, N ≤ 10
*/

/*
m = number of rows, n = number of columns

Total number of moves in which we have to move down to reach the last row = m - 1 (m rows, since we are starting from (1, 1) that is not included)

Total number of moves in which we have to move right to reach the last column = n - 1 (n column, since we are starting from (1, 1) that is not included)

Down moves = (m - 1)
Right moves = (n - 1)

Total moves = Down moves + Right moves = (m - 1) + (n - 1) 

Now think moves as a string of 'R' and 'D' character where 'R' at any ith index will tell us to move 'Right' and 'D' will tell us to move 'Down'

Now think of how many unique strings (moves) we can make where in total there should be (n - 1 + m - 1) characters and there should be (m - 1) 'D' character and (n - 1) 'R' character? 

Choosing positions of (n - 1) 'R' characters, results in automatic choosing of (m - 1) 'D' character positions 

Calculate nCr 
Number of ways to choose positions for (n - 1) 'R' character = Total positions C n - 1 = Total positions C m - 1 = (n - 1 + m - 1) != \frac {(n - 1 + m - 1)!} {(n - 1) ! (m - 1)!}        
*/

//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GfG { 
    
	public static void main (String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    String inputLine[] = br.readLine().trim().split(" ");
		    int m = Integer.parseInt(inputLine[0]);
		    int n = Integer.parseInt(inputLine[1]);
		    Solution ob = new Solution();
		    System.out.println(ob.numberOfPaths(m, n));
		}
	}
}




// } Driver Code Ends


class Solution{
    
    long numberOfPaths(int m, int n) {
        // Code Here
        // We have to calculate m+n-2 C n-1 here
        // which will be (m+n-2)! / (n-1)! (m-1)!
        long path = 1;
        for (int i = n; i < (m + n - 1); i++) {
            path *= i;
            path /= (i - n + 1);
        }
        return path;
    }
    
}
