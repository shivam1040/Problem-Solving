/*
Given a number (as string) and two integers a and b, divide the string in two non-empty parts such that the first part is divisible by a and the second part is divisible by b. In case multiple answers exist, return the string such that the first non-empty part has minimum length.

 

Example 1:

Input:
1200 4 3
Output:
12 00
Explanation:
12 is divisible by 4, and
00 is divisible by 3.
 

Example 2:

Input: 
125 12 5
Output: 
12 5
Explanation: 
12 is divisible by 12, and 
5 is divisible by 5.
 

Your Task:

You don't need to read input or print anything. Your task is to complete the function stringPartition() which takes the string S and returns a string which will be in the form of first sub-string + " " (Single Space) + second sub-string. If not found return -1 as a string.

 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)
 

Constraints:

1<=N<=106

1<=a,b<=N
*/

//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String str[] = read.readLine().split(" ");
            String S= str[0];
            int a = Integer.parseInt(str[1]);
            int b = Integer.parseInt(str[2]);
            Solution ob = new Solution();
            System.out.println(ob.stringPartition(S,a,b));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution{
    static String stringPartition(String S, int a, int b){
        // code here
        for(int i=0; i<S.length()-1; i++){
            String first=S.substring(0, i+1);
            String second=S.substring(i+1);
            
            if(Integer.parseInt(first)%a==0 && Integer.parseInt(second)%b==0)
                return first+" "+second;
        }
        
        return "-1";
    }
}
