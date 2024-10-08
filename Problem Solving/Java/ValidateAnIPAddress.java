/*
Write a program to Validate an IPv4 Address.
According to Wikipedia, IPv4 addresses are canonically represented in dot-decimal notation, which consists of four decimal numbers, each ranging from 0 to 255, separated by dots, e.g., 172.16.254.1 .
A valid IPv4 Address is of the form x1.x2.x3.x4 where 0 <= (x1, x2, x3, x4) <= 255.
Thus, we can write the generalized form of an IPv4 address as (0-255).(0-255).(0-255).(0-255).
Note: Here we are considering numbers only from 0 to 255 and any additional leading zeroes will be considered invalid.

Your task is to complete the function isValid which returns 1 if the given IPv4 address is valid else returns 0. The function takes the IPv4 address as the only argument in the form of string.

Example 1:

Input:
IPv4 address = 222.111.111.111
Output: 1
Explanation: Here, the IPv4 address is as
per the criteria mentioned and also all
four decimal numbers lies in the mentioned
range.

Example 2:

Input:
IPv4 address = 5555..555
Output: 0
Explanation: 5555..555 is not a valid
IPv4 address, as the middle two portions
are missing.
Your Task:
Complete the function isValid() which takes the address in the form of string s as an input parameter and returns 1 if this is a valid address otherwise returns 0.

Expected Time Complexity: O(N), N = length of the string.
Expected Auxiliary Space: O(1)

Constraints:
1<=length of string <=50
*/

//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.util.*;
import java.io.*;

  public class validip {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            String s = sc.next();
            Solution obj = new Solution();

            if (obj.isValid(s))
                System.out.println(1);
            else
                System.out.println(0);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    public boolean isValid(String s) {
        // Write your code here
         int count=0;

        for(int i=0; i<s.length(); i++){
            String temp="";

            while(i<s.length() && s.charAt(i)!='.'){
                if(s.charAt(i)<'0' || s.charAt(i)>'9')
                    return false;
                temp+=s.charAt(i);
                i++;
            }
            count++;
            if(temp.length()==0 || (temp.length() >= 2 && temp.charAt(0) == '0'))
                return false;
            if(Integer.parseInt(temp)<0 || Integer.parseInt(temp)>255)
                return false;
            if(count>4)
                return false;
        }
        if(count!=4)
            return false;
        if(s.charAt(s.length()-1)=='.')
            return false;
        return true;
    }
}
