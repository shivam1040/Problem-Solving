/*
Given two numbers in the form of Strings. Find the count of carries in their addition.

 

Example 1:

Input:
N = "34", M = "25"
Output:
0
Explanation:
There are no carries when N and M
are added.
Example 2:

Input:
N = "4634", M = "1757"
Output:
2
Explanation:
There are 2 carries when N and M
are added.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function getCarries() which takes two Strings N and M as input and returns an integer denoting the answer.

 

Expected Time Complexity: O(|N|)
Expected Auxiliary Space: O(|N|)

 

Constraints:
1 <= |N|,|M| <= 105
*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            
            String N = S[0];
            String M = S[1];

            Solution ob = new Solution();
            System.out.println(ob.getCarries(N,M));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int getCarries(String N , String M) {
        // code here
       int i=N.length()-1, j=M.length()-1, sum=0, count=0, carry=0, x, y;
       
       while(i>=0 || j>=0){
           if(i>=0)
            x=N.charAt(i)-'0';
           else
            x=0;
           
           if(j>=0)
            y=M.charAt(j)-'0';
           else
            y=0;
            
           sum=x+y+carry;
           
           if(sum>9){
               count++;
               carry=1;
           }
           else
            carry=0;
           i--;
           j--;
       }
       
       return count;
    }
}
