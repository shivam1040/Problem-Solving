/*
Given a string contains 'E' and 'O', 'E' represents a number is even and 'O' represents a number is odd. To make an element even, you can add 1 to any odd element of the array. Also, when any element of the array is converted to even, any neighboring element which is odd, can also be made even without adding 1. The task is to find the minimum number of additions required to make all the elements even.

Example 1:

Input: S = "EOOE"
Output: 1
Explanation: Add 1 to 2nd element, 
it's neighbour 3rd element will 
convert into even. 
Example 1:

Input: S = "EOOOOE"
Output: 1
Explanation: Add 1 to 2nd element, 
it's neighbour 3rd element will 
convert into even. Then 4th and 
5th elements too
Your Task:
You don't need to read input or print anything. Your task is to complete the function convertToEven() which takes a string as inputs and returns the minimum number of additions required.


Expected Time Complexity: O(|S|).
Expected Auxiliary Space: O(1).


Constraints:
1 <= |S| < 105
*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])throws IOException
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String S = sc.next();
                    Solution ob = new Solution();
                    System.out.println(ob.convertToEven(S));
                }
        }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int convertToEven(String s)
    {
        // Your code goes here
        int count=0;
        
        if(s.length()==1 && s.charAt(0)=='O')
            return 1;
        
        for(int i=0; i<s.length()-1; i++){
            // the basic idea is the count will only increase if there is two different characters else adjacent will take care of repeating Os
            if(i==0 && s.charAt(i)=='O')
                count++;
            if(s.charAt(i)=='E' && s.charAt(i+1)=='O')
                count++;
        }
        
        return count;
    }
}
