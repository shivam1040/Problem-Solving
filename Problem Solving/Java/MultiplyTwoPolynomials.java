/*
Given two polynomials represented by two arrays that contains the coefficients of poynomials, returns the polynomial in form of array formed after multiplication of given polynomials.


Example 1:

Input:
M = 4, N = 3
Arr1 = {1 , 0, 3, 2}
Arr2 = {2, 0, 4}
Output: {2, 0, 10, 4, 12, 8}
Explaination: 
First polynomial: 
1 + 0x1 + 3x2 + 2x3
Second polynomial: 
2 + 0x1 + 4x2
Product polynomial:
2 + 0x1 + 10x2 + 4x3 + 12x4 + 8x5

Example 2:

Input:
M = 5, N = 4
Arr1 = {1, 9, 3, 4, 7}
Arr1 = {4, 0, 2, 5}
Output: {4, 36, 14, 39, 79, 23, 34, 35}
Explaination: 
First polynomial: 
1 + 9x1 + 3x2 + 4x3 + 7x4
Second polynomial: 
4 + 0x1 + 2x2 + 5x3
Product polynomial:
4 + 36x1 + 14x2 + 39x3 + 79x4 + 23x5 + 34x6 + 35x7

Your Task:
You don't need to read input or print anything. Your task is to complete the function polyMultiply() which takes the array Arr1[] and Arr2[]and their size M and N as input parameters and returns the polynomial in form of array formed after multiplication of given polynomials..


Expected Time Complexity: O(M*N)
Expected Auxiliary Space: O(M+N)


Constraints:
1 ≤ M, N ≤ 100
1 ≤  Arr1[i] , Arr2[i]  ≤ 100
*/

//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String[] input = new String[2]; 
            input = read.readLine().split(" "); 
            int M = Integer.parseInt(input[0]); 
            int N = Integer.parseInt(input[1]);
            String input_line[] = read.readLine().trim().split("\\s+");
            int Arr1[]= new int[M];
            for(int i = 0; i < M; i++)
                Arr1[i] = Integer.parseInt(input_line[i]);
            
            String input_line1[] = read.readLine().trim().split("\\s+");
            int Arr2[]= new int[N];
            for(int i = 0; i < N; i++)
                Arr2[i] = Integer.parseInt(input_line1[i]);
            
            Solution ob = new Solution();
            int[] ans = ob.polyMultiply(Arr1,Arr2,M,N);
            for(int i = 0; i < ans.length; i++)
            {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution
{
    public int[] polyMultiply(int Arr1[], int Arr2[], int M, int N)
    {
        // code here
        int arr[]=new int[M+N-1];
        
        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                arr[i+j]+=Arr1[i]*Arr2[j];
            }
        }
        
        return arr;
    }
}
