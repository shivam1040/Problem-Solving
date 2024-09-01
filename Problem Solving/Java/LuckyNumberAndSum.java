/*
Given a number N.Find the minimum Lucky number, the sum of whose digits is equal to N.
Note:-Lucky numbers are the positive integers whose decimal representations contain only the lucky digits 4 and 7. 


Example 1:

Input:
N=29
Output:
44777
Explanation:
44777 is the smallest number whose 
digit-sum(4+4+7+7+7) is equal to 29.

Example 2:

Input:
N=9
Output:
-1
Explanation:
There is no lucky number whose digit-sum
is equal to 9.

Your Task:
You don't need to read input or print anything.Your task is to complete the function minimumLuckyNumber() which takes a number N as input parameters and returns the minimum Lucky number(in the form of a string) whose digit-sum is equal to N. If there is no lucky number whose digit-sum is equal to N, then return -1.


Expected Time Complexity:O(N)
Expected Auxillary Space:O(1)


Constraints:
1<=N<=105

Note:The answer may not fit in 64 bit integer representations.
*/

//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.minimumLuckyNumber(N));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    String minimumLuckyNumber(int N) {
        // code here
        String res="";
        
        while(N>0){
            if(N%7==0){
                res+="7";
                N-=7;
            }
            else{
                res+="4";
                N-=4;
            }
            if(N==0)
                return res;
        }
        return "-1";
    }
}
