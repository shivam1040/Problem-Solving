/*
An english word is given as input and it is modified using some format. Identify the format using the examples given below (examples given are sufficient to identify the format) and print the modified word as output.
STEWART is modified as EWARTSTAY, AMAR is modified as AMAR, MAN is modified as ANMAY etc.

Note: Input contains uppercase english words.

 

Example 1:

Input:
S = "GEEK"
Output:
EEKGAY
Explanation:
The string when modified gives "EEKGAY".
Example 2:

Input:
S = "ALL"
Output:
ALL
Explanation:
The string when modified remains the same.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function englishWords() which takes a String S as input and returns the modified String.

 

Expected Time Complexity: O(|S|)
Expected Auxiliary Space: O(|S|)

 

Constraints:
1 <= |S| <= 105
*/

//{ Driver Code Starts


import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.englishWords(S));
        }
    }
}
// } Driver Code Ends




class Solution {
    static String englishWords(String S) {
        // code here
        int i;
        
        for(i=0; i<S.length(); i++)
            if(S.charAt(i)=='A' || S.charAt(i)=='E' || S.charAt(i)=='I' || S.charAt(i)=='O' || S.charAt(i)=='U')
                break;
        if(i==0)
            return S;
        String a=S.substring(i, S.length()), b=S.substring(0, i);
        
        return a+b+"AY";
    }
};
