/*
Given a string S that represents column title of an Excel sheet, find the number that represents that column.
In excel A column is number 1, AA is 27 and so on.

Example 1:

Input:
S = A
Output: 1

Example 2:

Input:
S = AA
Output: 27
Your Task:
Complete the function ExcelColumnNumber() which takes a string as input and returns an integer.

Expected Time Complexity: O(|S|)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ |S| <=7
*/

/*
The process is similar to binary to decimal conversion. 
For example, to convert AB, the formula is 26 * 1 + 2
To convert CDA,
3*26*26 + 4*26 + 1
= 26(3*26 + 4) + 1
= 26(0*26 + 3*26 + 4) + 1
So it is very much similar to converting binary to decimal keeping the base as 26. 
Take the input as string and the traverse the input string from the left to right and calculate the result as follows: 

result = 26*result + s[i] - 'A' + 1
*/
//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	    int t=Integer.parseInt(br.readLine());
    
	    while(t > 0){
	        String s = br.readLine();
	        Solution T = new Solution();
	        
	        System.out.println(T.excelColumnNumber(s));
	        
            t--;
	    }
	}
    
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public int excelColumnNumber(String s) {
        // Code here
        int res=0;
        
        for(int i=0; i<s.length(); i++){
            res*=26;
            res+=s.charAt(i)-'A'+1;
        }
        return res;
    }
}
