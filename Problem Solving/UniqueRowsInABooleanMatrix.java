/*
Given a binary matrix your task is to find all unique rows of the given matrix.

Example 1:

Input:
row = 3, col = 4 
M[][] = {{1 1 0 1},{1 0 0 1},{1 1 0 1}}
Output: 1 1 0 1 $1 0 0 1 $
Explanation: Above the matrix of size 3x4
looks like
1 1 0 1
1 0 0 1
1 1 0 1
The two unique rows are 1 1 0 1 and
1 0 0 1 .
Your Task:
You only need to implement the given function uniqueRow(). The function takes three arguments the first argument is a matrix M and the next two arguments are row and col denoting the rows and columns of the matrix. The function should return the list of the unique row of the martrix. Do not read input, instead use the arguments given in the function.

Note: The drivers code print the rows "$" separated.

Expected Time Complexity: O(row * col)
Expected Auxiliary Space: O(row * col)

Constraints:
1<=row,col<=40
0<=M[][]<=1
*/

//{ Driver Code Starts
import java.lang.Math;
import java.util.*;
class UniqueRows{
public static void main(String[] args)
 {  Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int r=sc.nextInt();
			int c=sc.nextInt();
			int[][] a=new int [r][c];
			for(int i=0;i<r;i++)
				for(int j=0;j<c;j++)
					a[i][j]=sc.nextInt();
			GfG g=new GfG();
			ArrayList<ArrayList<Integer>> arr = g.uniqueRow(a,r,c);
			for(int i = 0;i<arr.size();i++){
			    ArrayList<Integer> demo = arr.get(i);
			    for(int j = 0;j<demo.size();j++){
			        System.out.print(demo.get(j)+" ");
			    }
			    System.out.print("$");
			}
			System.out.println();
		}
 }
}
// } Driver Code Ends


/*Complete the given function*/
class GfG
{
    public static ArrayList<ArrayList<Integer>> uniqueRow(int arr[][],int r, int c)
    {
        //add code here.
        Set<String> set = new HashSet<>();
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        
        for(int i = 0; i < r; i++)
        {
            String s = "";
            ArrayList<Integer> aux=new ArrayList<>();
            
            for(int j = 0; j < c; j++) 
                s += String.valueOf(arr[i][j]);
            if(!set.contains(s)){
                set.add(s);
                for(char cc:s.toCharArray())
                    aux.add(cc - '0');
                res.add(aux);
            }
        }
        return res;
    }
}
