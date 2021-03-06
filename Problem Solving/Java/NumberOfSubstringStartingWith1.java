/*
Given a binary string S. The task is to count the number of substrings that start and end with 1. For example, if the input string is “00100101”, then there are three substrings “1001”, “100101” and “101”.

Example 1:

Input:
N = 4
S = 1111
Output: 6
Explanation: There are 6 substrings from
the given string. They are 11, 11, 11,
111, 111, 1111.
Example 2:

Input:
N = 5
S = 01101
Output: 3
Explanation: There 3 substrings from the
given string. They are 11, 101, 1101.
Your Task:
The task is to complete the function binarySubstring() which takes the length of binary string n and a binary string a as input parameter and counts the number of substrings starting and ending with 1 and returns the count.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Constraints:
1 ≤ |S| ≤ 104
*/

/*
a) Count the number of 1's. Let the count of 1's be m. 
b) Return m(m-1)/2 
The idea is to count total number of possible pairs of 1's.
*/

// { Driver Code Starts
    import java.util.*;
    import java.lang.*;
    import java.io.*;
    
    class GFG{
        public static Scanner sc = new Scanner(System.in);
        public static void main (String[] args){
            int t;
            t=sc.nextInt();
            sc.nextLine();
            while((t--)!=0){
                int n=sc.nextInt();
                sc.nextLine();
                String s = new String();
                s=sc.nextLine();
                Solution obj = new Solution();
                System.out.println(obj.binarySubstring(n, s));
            }
        }
    }// } Driver Code Ends
    
    
    
    
    class Solution
    {
        //Function to count the number of substrings that start and end with 1.
        public static int binarySubstring(int a, String str)
        {
            a=0;
            for(int i=0; i<str.length(); i++)
                if(str.charAt(i)=='1')
                    a++;
            return a*(a-1)/2;
        }
    }