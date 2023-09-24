/*
Convert a given string to its cross string (i.e Diagonal from left-right and from right-left). 

See examples for better understanding.

 

Example 1:

Input:
abc
Output:
a c  b  a c
Explanation:
The above is the proper 
cross manner for the 
test case.
a c
 b 
a c

Example 2:

Input:
geeks
Output:
g   s e k   e   e k g   s
Explanation:
For the 1st test case where 
the string is geeks

G   S
 E K
  E
 E K
G   S

The above is the proper cross 
the manner for the test case, but 
when printed in a single line 
it becomes as shown in the output.
 

Your Task:

You don't need to read input or print anything. Your task is to complete the function crossPattern() which takes the string S and returns a single string in the following way first-line output of the string concatenated with 2nd line and so on till the Nth line.

 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

 

Constraints:

1 ≤ length of string ≤ 1000
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
            String S = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.crossPattern(S));
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    static String crossPattern(String S){
        // code here
        String res="";
        
        for(int i=0; i<S.length(); i++){
            for(int j=0; j<S.length(); j++){
                //this condition check for diagonal equality similar to matrix
                if(i==j || i+j==S.length()-1)
                    res+=S.charAt(j);
                else
                    res+=" ";
            }
        }
        
        return res;
    }
}
