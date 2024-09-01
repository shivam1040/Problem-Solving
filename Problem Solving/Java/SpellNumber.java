/*
Given a  number N such that it may contain many continuous digits. Find the number of ways to spell the number.
For example, consider 8884441100, one can spell it simply as triple eight triple four double two and double zero. One can also spell as double eight, eight, four, double four, two, two, double zero.

 

Example 1:

Input:
N = 100
Output:
2
Explanation:
The number 100 has only 2 possibilities, 
1) one zero zero 
2) one double zero.

Example 2:

Input:
N = 11112
Output:
8
Explanation:
1 1 1 1 2, 11 1 1 2, 1 1 11 2, 1 11 1 2,
11 11 2, 1 111 2, 111 1 2, 1111 2

Example 3:

Input:
N = 12345
Output:
1
Explanation:
The number 12345 has only 1 possibility, 
one two three four five
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function differentWaysToSpell() which takes a String N as input and returns the number of possible ways.

 

Expected Time Complexity: O(|N|)
Expected Auxiliary Space: O(1)

 

Constraints:
1 <= |N| <= 1050
*/

/*
This is a simple problem of permutation and combination. If we take example test case given in the question, 11112. The answer depends on the number of possible substrings of 1111. The number of possible substrings of “1111” is 2^3 = 8 because it is the number of combinations of 4 – 1 =  3 separators ‘|’ between two characters of the string (digits of number represented by the string) : “1|1|1|1”. As our combinations will depend on whether we choose a particular 1 and for “2” there will be only one possibility 2^0 = 1, so answer for “11112” will be 8*1 = 8. 

So, the approach is to count the particular continuous digit in string and multiply 2^(count-1) with previous result. 
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
            String N = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.differentWaysToSpell(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static long differentWaysToSpell(String N) {
        // code here
        long res=1;
        int count=1;
        
        for(int i=1; i<N.length(); i++){
            if(N.charAt(i)==N.charAt(i-1))
                count++;
            
            res*=(long)Math.pow(2, count-1);
            count=1;
        }
        return res*(long)Math.pow(2, count-1);
    }
};
