/*
CBI agents are investigating a case in which they came across certain names of the culprits. They decided to encode the names into the number format.

"Riya" is encoded as "729611390","Sumitha" as "73108101981109993" ,"Anandita" as "55101891039410011294" and so on. Given a String S denoting a name, Encode the name.

 

Example 1:

Input:
S = "Soni"
Output:
7310210298
Explanation:
The name when encoded gives the given Output.
Example 2:

Input:
S = " Pawan"
Output:
708811190104 
Explanation:
The name when encoded gives the given Output.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function encodeTheName() which takes a String S as input and returns a String as the encoded format.

 

Expected Time Complexity: O(|S|)
Expected Auxiliary Space: O(|S|)

 

Constraints:
1 <= |S| <= 104
*/

/*
Refer the ASCII values of the english alphabets and some trends explained as follows.

For eg : For the name Mona

ASCII value of M=77 subtract it by 10,77-10=67 and since it is the first character of the name it is encoded as 67+0=67.

ASCII value of o=111,111-10=101,It is the second character of the string so 101+1=102,so 'o'is encoded as 102.

ASCII value of n=110,110-10=100,It is the third character of the string so 100+2=102,so 'o'is also encoded as 102.

ASCII value of a=97,97-10=87,It is the fourth character of the string so 87+3=90,so 'a' is encoded as 90.
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
            System.out.println(ob.encodeTheName(S));
        }
    }
}
// } Driver Code Ends



class Solution {
    static String encodeTheName(String S) {
        // code here
        StringBuilder res=new StringBuilder();
        
        for(int i=0; i<S.length(); i++)
            res.append(S.charAt(i)-10+i);
        return res.toString();
    }
};
