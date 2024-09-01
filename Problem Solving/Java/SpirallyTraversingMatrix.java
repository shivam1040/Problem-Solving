/*
Given a matrix of size r*c. Traverse the matrix in spiral form.

Example 1:

Input:
r = 4, c = 4
matrix[][] = {{1, 2, 3, 4},
           {5, 6, 7, 8},
           {9, 10, 11, 12},
           {13, 14, 15,16}}
Output: 
1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
Explanation:

Example 2:

Input:
r = 3, c = 4  
matrix[][] = {{1, 2, 3, 4},
           {5, 6, 7, 8},
           {9, 10, 11, 12}}
Output: 
1 2 3 4 8 12 11 10 9 5 6 7
Explanation:
Applying same technique as shown above, 
output for the 2nd testcase will be 
1 2 3 4 8 12 11 10 9 5 6 7.

Your Task:
You dont need to read input or print anything. Complete the function spirallyTraverse() that takes matrix, r and c as input parameters and returns a list of integers denoting the spiral traversal of matrix. 

Expected Time Complexity: O(r*c)
Expected Auxiliary Space: O(r*c), for returning the answer only.

Constraints:
1 <= r, c <= 100
0 <= matrixi <= 100
*/

/*
Intuition:
The problem can be solved by dividing the matrix into loops or squares or boundaries. It can be seen that the elements of the outer loop are printed first in a clockwise manner then the elements of the inner loop are printed. 
So printing the elements of a loop can be solved using four loops that print all the elements. Every ‘for’ loop defines a single-direction movement along with the matrix. The first for loop represents the movement from left to right, whereas the second crawl represents the movement from top to bottom, the third represents the movement from the right to left, and the fourth represents the movement from bottom to up

Implementation:
Take 4 variables row = 0, col = 0, r(number of rows of matrix),c(number of columns of the matrix), to track the completion of the spiral matrix and an output array to store the answer.
Run a loop until all the squares of loops are printed (row < r && col < c).
In each outer loop traversal store the elements of a square in the output array in a clockwise manner.
For the upper edge of the matrix perform a for loop from (j = col to j < c) and store the upper edge in the output by matrix[row][j] and increment the row by 1 to contract the boundary for future iteration (row++).
For the right edge of the matrix loop from (i = row to i < r) and store the right edge of the matrix by matrix[i][c-1] into the output array and decrement c by 1 (c--).
for the lower edge of the matrix loop from (j = c-1 to j >= col) and store the lower edge by matrix[r-1][j] into the output array and decrement r by 1 (r--) to contract the boundary.
Now for the left edge of the matrix loop from (i = r-1 to i >= row) and store the left edge by matrix[i][col] into the output array and increment col by 1(col++).
Return the output array.
Note: every time we are completing one edge we are either incrementing or decrementing one of the variables just to restrict or contract the boundary of the matrix for the spiral rotation.
*/

//{ Driver Code Starts
import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int r = sc.nextInt();
            int c = sc.nextInt();
            
            int matrix[][] = new int[r][c];
            
            for(int i = 0; i < r; i++)
            {
                for(int j = 0; j < c; j++)
                 matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.spirallyTraverse(matrix, r, c);
            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to return a list of integers denoting spiral traversal of matrix.
    static ArrayList<Integer> spirallyTraverse(int matrix[][], int r, int c)
    {
        // code here 
        ArrayList<Integer> res=new ArrayList<>();
        int dir=1, top=0, bottom=r-1, left=0, right=c-1;
        
        while(top<=bottom && left<=right){
            if(dir==1){
                for(int i=left; i<=right; i++)
                    res.add(matrix[top][i]);
                top++;
                dir=2;
            }
            else if(dir==2){
                for(int i=top; i<=bottom; i++)
                    res.add(matrix[i][right]);
                right--;
                dir=3;
            }
            else if(dir==3){
                for(int i=right; i>=left; i--)
                    res.add(matrix[bottom][i]);
                bottom--;
                dir=4;
            }
            else{
                for(int i=bottom; i>=top; i--)
                    res.add(matrix[i][left]);
                left++;
                dir=1;
            }
        }
        return res;
    }
}

