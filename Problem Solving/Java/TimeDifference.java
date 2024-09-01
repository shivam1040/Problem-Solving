/*
Given the start time st and end time et of a race in the format hh:mm:ss. You task is to print the time taken to complete the race.

Example 1:

Input: st = 13:50:45
et = 14:55:50
Output: 01:05:05
Explaination: The time gap is 1 hour 5 
minutes and 5 seconds.
Example 2:

Input: st = 12:00:00
et = 24:00:00
Output: 12:00:00
Explaination: The time gap is of 12 hours.
Your Task:
You do not need to read input or print anything. Your task is to complete the function timeGap() which takes st and et as input parameters and returns the time difference between them.

Expected Time Complexity: O(1)
Expected Auxiliary Space: O(1)

Constraints:
0 ≤ hh ≤ 24
0 ≤ mm ≤ 59
0 ≤ ss ≤ 59
*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String st = in.readLine();
            String et = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.timeGap(st, et));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static String timeGap(String st, String et){
        // code here
                java.time.format.DateTimeFormatter formatter = java.time.format.DateTimeFormatter.ofPattern("HH:mm:ss");
        java.time.LocalTime start = java.time.LocalTime.parse(st, formatter);
        java.time.LocalTime end = java.time.LocalTime.parse(et, formatter);
        java.time.LocalTime elapsed = end.minusHours(start.getHour()).minusMinutes(start.getMinute()).minusSeconds(start.getSecond());
        return String.format("%02d:%02d:%02d", elapsed.getHour(), elapsed.getMinute(), elapsed.getSecond());
    }
}

