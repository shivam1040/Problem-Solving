/*
Given a 2D matrix g contains only 1 and 0, count the number of triangles in it.
Take 3 index i,j,k (0<=i,j,k<n). {i,j}, {j,k}, {k,i} will form a triangle if i!=j and i!=k and j!=k and g[i][j]=1 and g[j][k]=1 and g[k][i]=1.

Example 1:

Input:
N=4
graph[][]={{0, 0, 1, 0}, 
           {1, 0, 0, 1},
           {0, 1, 0, 0}, 
           {0, 0, 1, 0}}
Output:
2
Explanation;
Triangle 1: {{0,2}, {2,1}, {1,0}}
graph[][]={{0, 0, 1, 0},
           {1, 0, 0, 1},
           {0, 1, 0, 0},
           {0, 0, 1, 0}}.  

Triangle 2: {{1,3}, {3,2}, {2,1}}
graph[][]={{0, 0, 1, 0},
           {1, 0, 0, 1},
           {0, 1, 0, 0},
           {0, 0, 1, 0}}. 

 

Your Task:
You don't need to read input or print anything. Your task is to complete the function numberOfTriangles() which takes the 2D matrix g[][], it's number of nodes N as input parameters and returns the number of triangles in it.

 

Expected Time Complexity: O(N*N*N)
Expected Auxiliary Space: O(1)
 

Constraints:
1<=N<=100
0<=g[i][j]<=1
*/

//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntMatrix
{
    public static int[][] input(BufferedReader br, int n, int m) throws IOException
    {
        int[][] mat = new int[n][];
        
        for(int i = 0; i < n; i++)
        {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for(int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }
        
        return mat;
    }
    
    public static void print(int[][] m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
    
    public static void print(ArrayList<ArrayList<Integer>> m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n; 
            n = Integer.parseInt(br.readLine());
            
            
            int[][] g = IntMatrix.input(br, n, n);
            
            Solution obj = new Solution();
            int res = obj.numberOfTriangles(n, g);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int numberOfTriangles(int n, int[][] g) {
        // code here
        int res=0;
        
        for(int i=0; i<n; i++)
            for(int j=0; j<n; j++)
                for(int k=0; k<n; k++)
                    if(i!=j && i!=k && j!=k && g[i][j]==1 && g[j][k]==1 && g[k][i]==1)
                        res++;
        return res/3;
    }
}
        

