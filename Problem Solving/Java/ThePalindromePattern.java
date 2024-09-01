/*
Given a 2-D integer array A of order NXN, consisting of only zeroes and ones, find the row or column whose all elements form a palindrome. If more than one palindrome is found, the palindromes found in rows will have priority over the ones found in columns and within rows and columns, the one with lesser index gets the highest priority. Print the palindrome with the highest priority along with it's index and indication of it being a row or column.

 

Example 1:

Input:
N = 3
A[][] = [[1, 0, 0], [0, 1, 0], [1, 1, 0]]
Output: 1 R
Explanation:
In the first test case, 0-1-0 is a palindrome 
occuring in a row having index 1.
 

Example 2:

Input:
N = 2
A[][] = [[1, 0], [1, 0]]
Output: 0 C
Explanation:
1-1 occurs before 0-0 in the 0th column.
And there is no palindrome in the two rows.


Your Task:  
You don't need to read input or print anything. Your task is to complete the function pattern() which takes the integer N and 2-d array A[][] as input parameters and returns the First, the index of either row or column(0 based indexing) , followed by either of the two characters 'R' or 'C', representing whether the palindrome was found in a row or column. All the characters return as output should be space separated. If no palindrome is found, return -1 as string.

Expected Time Complexity: O(N2)
Expected Auxiliary Space: O(1)

 

Constraints:

1<=N<=50

A[i][j]=0 or 1, where i and j denote row and column indices of the matrix respectively.
*/

//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        Solution ob = new Solution();
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input_line[] = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input_line[0]);
            String input_line1[] = read.readLine().trim().split("\\s+");
            int [][]a = new int[N][N];
            int c = 0;
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    a[i][j] = Integer.parseInt(input_line1[c]);
                    c++;
                }
            }
            String ans = ob.pattern(a, N);
            System.out.println(ans);
        }
    }
}



// } Driver Code Ends


//User function Template for Java

class Solution{
    
    String pattern(int [][]a, int N){
        // Code here
        int m=a.length, n=a[0].length;
        
        for(int i=0; i<m; i++){
            String temp="";
            
            for(int j=0; j<n; j++)
                temp+=a[i][j];
            if(isPalindrome(temp))
                return i+ " R";
        }
        for(int i=0; i<n; i++){
            String temp="";
            
            for(int j=0; j<m; j++)
                temp+=a[j][i];
            if(isPalindrome(temp))
                return i+ " C";
        }
        return "-1";
    }
    
    static boolean isPalindrome(String str){
 
        // Pointers pointing to the beginning
        // and the end of the string
        int i = 0, j = str.length() - 1;
 
        // While there are characters to compare
        while (i < j) {
 
            // If there is a mismatch
            if (str.charAt(i) != str.charAt(j))
                return false;
 
            // Increment first pointer and
            // decrement the other
            i++;
            j--;
        }
 
        // Given string is a palindrome
        return true;
    }
    
}

