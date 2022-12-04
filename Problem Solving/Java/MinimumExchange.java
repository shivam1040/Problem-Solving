/*
Given a matrix of size n*m. Every cell of matrix contains either 'A' or 'B'. Exchange is defined as swaping the characters between two cells. Your task is to find the minimum number of exchange needed to rearrange the given matrix such that no adjacent cell contains the same characters.
Two cells are adjacent if they share one of their common sides (left,right,front or back if exists). 

Note: There will not be any case that answer does not exist.
 

Example 1:

Input: matrix = {{A,A,B,A},{B,A,B,A},{B,B,A,B}}
Output: 2
Explanation: Minimum number of students whose 
sets got changed are 4 (indexes: ((0,1),(0,2),
(0,3),(2,0))). The final alloted sets are:
A B A B
B A B A
A B A B
Here 2 exchange are done so answer is 2.
Example 2:

Input: matrix = {{A,B},{B,A}}
Output: 0
Explanation: No two adjacent cell contains same
character.
 

Your Task:
You don' t need to read or print anything. Your task is to complete the function MinimumExchange() which takes matrix as input parameter and returns minimum number of  exchange needed.
 

Expected Time Complexity: O(n*m)
Expected Space Compelxity: O(1)
 

Constraints:
1 <= n, m <= 100
*/

/*
The idea is to use Odd and Even places, put 'A' at odd(i.e- row+column is odd) and 'B' at even(i.e- row+column is even) Places, and calculate the number of exchanges required according to the initial matrix and again use vice versa ( i.e:- B at odd and A at even) and then return in which one required exchanges is minimum.

Note:- Every odd place has even adjacents and vice versa because when we want to move to the adjacent of any cell then we have to increase/decrease from a row or column from the current cell and if we increase or decrease by one then odd becomes even and even becomes odd, that's why every odd has even adjacent and even has odd adjacent.

Implementation:
Steps:-

Initialize two variables temporary1 and temporary2 and assume the Number of exchanges is temp1 for 'A' at even places and temp2 for 'A' at odd places.
Run a nested loop for every column of each row and check whether it is the odd place or even place
If it's an even place and it has 'A' then increase temp2 else increase temp1 and check accordingly for odd places also.
At the end of loops return the minimum of temp1 and temp2.
*/

//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s1[0]);
            int m = Integer.parseInt(s1[1]);
            char[][] matrix = new char[n][m];
            for(int i = 0; i < n; i++){
                String S = br.readLine().trim();
                for(int j = 0; j < m; j++){
                    matrix[i][j] = S.charAt(j);
                }
            }
            Solution obj = new Solution();
            int ans = obj.MinimumExchange(matrix);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution
{
    public int MinimumExchange(char[][] matrix)
    {
        // Code here
        int seq1=0, seq2=0;
        
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[i].length; j++){
                if(matrix[i][j]=='A'){
                    if((i+j)%2==1)
                        seq1++;
                    else
                        seq2++;
                }
                else{
                    if((i+j)%2==1)
                        seq2++;
                    else
                        seq1++;
                }
            }
        }
        //this returns seq one as the answer beacause if matrix is odd then seq 1 will always be the answer
          if((matrix.length*matrix[0].length)%2==1)
             return seq1/2;
        //since we are accounting for both the sequences in loop A B A, or B A B, so this /2 eliminates the repition
        return Math.min(seq1, seq2)/2;
    }
}
