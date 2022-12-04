/*
Write a program that calculates the day of the week for any particular date in the past or future.

Example 1:

Input:
d = 28, m = 12, y = 1995
Output:
Thursday
Explanation:
28 December 1995 was a Thursday.
Example 2:

Input:
d = 30, m = 8, y = 2010
Output:
Monday
Explanation:
30 August 2010 was a Monday.
Your Task:
You don't need to read input or print anything. Your task is to complete the function getDayOfWeek() which takes 3 Integers d, m and y denoting day, month and year as input and return a String denoting the answer.

Expected Time Complexity: O(1)
Expected Auxiliary Space: O(1)

Constraints:
1 <= d <= 31
1 <= m <= 12
1990 <= y <= 2100
https://en.wikipedia.org/wiki/Zeller%27s_congruence
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
            
            int d = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            int y = Integer.parseInt(S[2]);

            Solution ob = new Solution();
            System.out.println(ob.getDayOfWeek(d,m,y));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static String getDayOfWeek(int d, int m, int y) {
        // code here
        String days[] = { "Saturday", "Sunday",    "Monday",   "Tuesday",
                         "Wednesday", "Thursday", "Friday" };
                         
        if(m<3){
            m+=12;
            y-=1;
        }
        
        int k=y%100;
        int j=y/100;
        int day=(
            (
                d+(
                    ((m+1)*26)/10
                    )+k+(k/4)+(j/4)
                )+(5*j)
            )%7;
        
        return days[day];
    }
};
