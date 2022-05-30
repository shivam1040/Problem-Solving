/*
Given a matrix mat[][] of size N x M, where every row and column is sorted in increasing order, and a number X is given. The task is to find whether element X is present in the matrix or not.


Example 1:

Input:
N = 3, M = 3
mat[][] = 3 30 38 
         44 52 54 
         57 60 69
X = 62
Output:
0
Explanation:
62 is not present in the
matrix, so output is 0

Example 2:

Input:
N = 1, M = 6
mat[][] = 18 21 27 38 55 67
X = 55
Output:
1
Explanation:
55 is present in the
matrix at 5th cell.

Your Task:
You don't need to read input or print anything. You just have to complete the function matSearch() which takes a 2D matrix mat[][], its dimensions N and M and integer X as inputs and returns 1 if the element X is present in the matrix and 0 otherwise.


Expected Time Complexity: O(N+M).
Expected Auxiliary Space: O(1).


Constraints:
1 <= N, M <= 1005
1 <= mat[][] <= 10000000
1<= X <= 10000000
*/

/*
 The simple idea is to remove a row or column in each comparison until an element is found. Start searching from the top-right corner of the matrix. There are three possible cases. 

The given number is greater than the current number: This will ensure that all the elements in the current row are smaller than the given number as the pointer is already at the right-most elements and the row is sorted. Thus, the entire row gets eliminated and continues the search for the next row. Here, elimination means that a row needs not be searched.
The given number is smaller than the current number: This will ensure that all the elements in the current column are greater than the given number. Thus, the entire column gets eliminated and continues the search for the previous column, i.e. the column on the immediate left.
The given number is equal to the current number: This will end the search.
*/
// { Driver Code Starts
    import java.util.*;
    import java.io.*;
    import java.lang.*;
    
    class gfg
    {
        public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            
            while(t-- > 0)
            {
                int n = sc.nextInt();
                int m = sc.nextInt();
                
                int mat[][] = new int[n][m];
                for(int i = 0; i < n; i++)
                {
                    for(int j = 0; j < m; j++)
                      mat[i][j] = sc.nextInt();
                }
                
                int x = sc.nextInt();
                
                System.out.println (new Sol().matSearch(mat, n, m, x));
            }
            
        }
    }// } Driver Code Ends
    
    
    class Sol
    {
        public static int matSearch(int matrix[][], int N, int M, int x)
        {
             int i=0, j=M-1;
        while(i<N && j>=0){
            if(matrix[i][j]==x)
                return 1;
            else if(matrix[i][j]>x)
                j--;
            else
                i++;
        }
        return 0;
        }
    }