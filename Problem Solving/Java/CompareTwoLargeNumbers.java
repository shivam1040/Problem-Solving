/*
You will be given two numbers a and b. Your task is to print 1 if a < b, print 2 if a > b and print 3 if a = b.

Example 1:

Input: 
a = 1234
b = 12345
Output: 1
Explanation: a < b so answer is 1.
Example 2:

Input:
a = 100
b = 1
Output: 2
Explanation: a > b, so answer is 2.
User Task:
Your task is to complete the function check() which takes 2 arguments(string a, string b) and returns the answer. You need not take input or print anything.

Expected Time Complexity: O(|a| + |b|).
Expected Auxiliary Space: O(|a| - |b|).

Constraints:
1 ≤ |a|, |b| ≤ 155      
'0' ≤  ai,bi  ≤  '9'
*/

//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String a = sc.next ();
            String b = sc.next();
            Solution obj = new Solution();
    		System.out.println (obj.check (a, b));
        }
        
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution
{
    int check (String a, String b)
    {
        // your code here
       int i = 0, j = 0;
       //excluding all zeroes
    while(i< a.length() && a.charAt(i) == '0') i++;
    while(j<b.length() && b.charAt(j) == '0') j++;
    
    //System.out.println(i+" "+j);
    
    //checking which number is bigger in length after excluding zeroes
        if((a.length() - i) < (b.length()-j)) {
        return 1;
    }
    
    if((a.length() - i) > (b.length()-j)) {
        return 2;
    }
    
    
    while(i < a.length() && j < b.length()) {
        if(a.charAt(i) != b.charAt(j)) {
            int x = a.charAt(i)-'0';
            int y = b.charAt(j)-'0';
            //if number is not equal then the one which is greater return res accordingly
            if(x < y) {
                return 1;
            }
            else {
                return 2;
            }
        }
        i++;
        j++;
    }

     return 3;
    }
    
    
}
