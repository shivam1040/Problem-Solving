/*
Given a large positive number N having x digits, the task is to count all rotations of the given number which are divisible by 4.

Example 1:

Input: N = 8
Output: 1
Explaination: The number 8 is divisible by 4.
Example 2:

Input: N = 20
Output: 1
Explaination: The number 20 is divisible by 4. 
But after rotation 02 is not divisible by 4.
Your Task:
You do not need to read input or print anything. Your task is to complete the function countRotations() which takes N as input parameter and returns the number of rotations divisible by 4.

Expected Time Complexity: O(x)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ x ≤ 105
*/

/*
Consider a number 928160
Its rotations are 928160, 092816, 609281, 160928, 
    816092, 281609.
Now form pairs from the original number 928160
as mentioned in the approach.
Pairs: (9,2), (2,8), (8,1), (1,6), 
         (6,0), (0,9)
We can observe that the 2-digit number formed by the these 
pairs, i.e., 92, 28, 81, 16, 60, 09, are present in the last
2 digits of some rotation.
Thus, checking divisibility of these pairs gives the required
number of rotations. 

Note: A single digit number can directly
be checked for divisibility.
*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String N = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.countRotations(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int countRotations(String n){
        // code here
        String N=n;
        if(N.length()==1){
            if((N.charAt(0)-'0')%4==0)
                return 1;
        return 0;
        }
                int len = n.length();
      
      
        // At-least 2 digit
        // number (considering all
        // pairs)
        int twoDigit, count = 0;
        for (int i = 0; i < (len-1); i++)
        {
          twoDigit = (n.charAt(i)-'0') * 10 +
                     (n.charAt(i+1)-'0');
 
          if (twoDigit%4 == 0)
              count++;
        }
      
        // Considering the number
        // formed by the pair of
        // last digit and 1st digit
        twoDigit = (n.charAt(len-1)-'0') * 10 +
                   (n.charAt(0)-'0');
 
        if (twoDigit%4 == 0)
            count++;
      
        return count;
    }
}
