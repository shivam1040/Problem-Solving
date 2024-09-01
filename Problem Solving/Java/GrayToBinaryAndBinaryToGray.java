/*
Given to strings B and G. String B represents a binary code and string G represents a Gray Code. You need to write a program which converts binary code to gray code and vice versa.

 

Example 1:

Input:
B = "0011"
G = "01101"
Output:
0010
01001
Explanation:
Grey Code of 0011 is 0010.
Binary of 01101 is 01001.
Example 2:

Input:
B = "01001"
G = "01101"
Output:
01101
01001
Explanation:
Grey Code of 01001 is 01101.
Binary of 01101 is 01001.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the functions binToGrey() and greyToBin() which takes Strings B and G as input and returns the answers.

 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

 

Constraints:
1 <= |B| <= 105
1 <= |G| <= 105
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
            String B = read.readLine();
            String G = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.binToGrey(B));
            System.out.println(ob.greyToBin(G));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static String binToGrey(String B) {
        // code here
        String res=B.charAt(0)+"";
        
        for(int i=1; i<B.length(); i++)
            res+=B.charAt(i)^B.charAt(i-1);
        return res;
    }
    static String greyToBin(String G) {
        // code here
        String res="";
        
        for(int i=0; i<G.length(); i++)
            if(i==0)
                res+=G.charAt(i);
            else
                res+=G.charAt(i)^res.charAt(i-1);
        return res;
    }
};
