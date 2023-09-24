/*
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
            int n = sc.nextInt();
            int matrix[][] = new int[n][n];
            
            for(int i = 0; i < n; i++)
            {
                for(int j = 0; j < n; j++)
                  matrix[i][j] =sc.nextInt();
            }
            Solution ob = new Solution();
            System.out.println(ob.determinantOfMatrix(matrix, n));
        }
    }
}
// } Driver Code Ends




class Solution
{
    //Function for finding determinant of matrix.
    static int determinantOfMatrix(int matrix[][], int n)
    {
        // code here 
        if(n==1)
            return matrix[0][0];
        
        int res=0;
        
        for(int i=0; i<n; i++){
            int mat[][]= sMat(matrix, n, i);
            
            if(i%2==0)
                res+=matrix[0][i]*determinantOfMatrix(mat, n-1);
            else
                res+=-1*matrix[0][i]*determinantOfMatrix(mat, n-1);
        }
        
        return res;
    }
    
    //stores current row/column elements in temp array
        static int[][] sMat(int matrix[][], int n, int i) {
        
        int mat[][] = new int[n-1][n-1];
            
            for(int j=1; j<n; j++){
            	int c=0;
                for(int k=0; k<n; k++) {
                    
                    if(k!=i) {
                        mat[j-1][c] = matrix[j][k];
                        c++;
                    }
                }
        }
        
        return mat;
        
    }
}


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
            int n = sc.nextInt();
            int matrix[][] = new int[n][n];
            
            for(int i = 0; i < n; i++)
            {
                for(int j = 0; j < n; j++)
                  matrix[i][j] =sc.nextInt();
            }
            Solution ob = new Solution();
            System.out.println(ob.determinantOfMatrix(matrix, n));
        }
    }
}
// } Driver Code Ends




class Solution
{
    //Function for finding determinant of matrix.
    static int determinantOfMatrix(int matrix[][], int n)
    {
        // code here 
        if(n==1)
            return matrix[0][0];
        
        int res=0;
        
        for(int i=0; i<n; i++){
            int mat[][]= sMat(matrix, n, i);
            
            if(i%2==0)
                res+=matrix[0][i]*determinantOfMatrix(mat, n-1);
            else
                res+=-1*matrix[0][i]*determinantOfMatrix(mat, n-1);
        }
        
        return res;
    }
    
    //stores current row/column elements in temp array
        static int[][] sMat(int matrix[][], int n, int i) {
        
        int mat[][] = new int[n-1][n-1];
            
            for(int j=1; j<n; j++){
            	int c=0;
                for(int k=0; k<n; k++) {
                    
                    if(k!=i) {
                        mat[j-1][c] = matrix[j][k];
                        c++;
                    }
                }
        }
        
        return mat;
        
    }
}


