/*
Given a matrix mat[][] of n rows and m columns, consisting of 0’s and 1’s. The task is to complete the function findPerimeter which returns an integer denoting the perimeter of sub-figures consisting of only 1’s in the matrix.

For example
Perimeter of single 1 is 4 as it can be covered from all 4 side. Perimeter of double 11 is 6.

                            
|  1  |           |  1    1  |
                            

Input:
The first line of input contains an integer T denoting the no of test cases. Then T test cases follow. The first line of each test case contains two space separated n and m denoting the size of the matrix mat[][] . Then in the next line are n*m space separated values of the matrix.

Output:
For each test case in a new line print the perimeter of sub-figure consisting only 1’s in the matrix.

Constraints:
1<=T<=100
1<=n, m<=20

Example(To be used for expected output):
Input:
2
1 2
1 1 
3 3
1 0 0 1 0 0 1 0 0

Output:
6
8

Note:The Input/Ouput format and Example given are used for system's internal purpose, and should be used by a user for Expected Output only. As it is a function problem, hence a user should not read any input from stdin/console. The task is to complete the function specified, and not to write the full code.
*/

/*
The idea is to traverse the matrix, find all ones and find their contribution in perimeter as per the below cases:

Case 1 (4 adjacent 1s) : contribution = 0
Case 2 (3 adjacent 1s) : contribution = 1
Case 3 (2 adjacent 1s) : contribution = 2
Case 4 (1 adjacent 1s) : contribution = 3
Case 5 (0 adjacent 1s) : contribution = 4

Finally return the sum of contribution of each 1 in the matrix as the answer.

Traverse the whole matrix and find the cell having value equal to 1.
Calculate the number of adjacent 1s for that cell and add, 4 – number of adjacent 1s to the total perimeter.

*/

//{ Driver Code Starts
import java.util.*;
class Perimeter{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0){
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] a = new int[n][m];
			for(int i = 0 ; i < n; i++ )
				for(int j = 0 ; j < m; j++)
					a[i][j] = sc.nextInt();
			GfG g = new GfG();
			System.out.println(g.findPerimeter(a,n,m));
		}
	}
}
// } Driver Code Ends


/*Complete the function given below*/
class GfG
{
       public static int findPerimeter(int[][] mat, int n, int m)
            {//add code here.
                int count=0, neighbour=0;
                
                for(int i=0; i<n; i++)
                    for(int j=0; j<m; j++)
                        if(mat[i][j]==1){
                            count++;
                            
                            if(i!=0 && mat[i-1][j]==1)
                                neighbour++;
                            if(j!=0 && mat[i][j-1]==1)
                                neighbour++;
                        }
                return 4*count-neighbour*2;
            }
}
