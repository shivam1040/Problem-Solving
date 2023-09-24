/*
You are given a string S. Every sub-string of identical letters is replaced by a single instance of that letter followed by the hexadecimal representation of the number of occurrences of that letter. Then, the string thus obtained is further encrypted by reversing it [ See the sample for more clarity ]. Print the Encrypted String.

Note: All Hexadecimal letters should be converted to Lowercase letters.

 

Example 1:

Input:
S = "aaaaaaaaaaa"
Output:
ba 
Explanation: 
aaaaaaaaaaa
Step1: a11 (a occurs 11 times)
Step2: a11 is ab [since 11 is b in
hexadecimal]
Step3: ba [After reversing]
Example 2:

Input:
S = "abc"
Output:
1c1b1a
Explanation: 
abc
Step1: a1b1c1
Step2: 1c1b1a [After reversing]
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function encryptString() which takes a String S and returns the answer.

 

Expected Time Complexity: O(|S|)
Expected Auxiliary Space: O(1)


Constraints
1 <= |S| <= 105
*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String S = read.readLine();

            Solution ob = new Solution();

            System.out.println(ob.encryptString(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static String encryptString(String S){
        // code here
        int count=1;
        S+=" ";
        String temp="";
        
        for(int i=0; i<S.length()-1; i++){
            if(S.charAt(i)==S.charAt(i+1))
                count++;
            else{
                temp=Integer.toHexString(count)+S.charAt(i)+temp;
                count=1;
            }
        }
        //StringBuilder input1 = new StringBuilder();
        //input1.append(temp);
        return temp;
    }
};
