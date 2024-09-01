/*
An Encryption algorithm works in the following way
Message: eNEMYwILLaTTACK
Enrypted Form: eYLA NwaC EITK MLT

The way to do it is that the number of rows and the number of columns in the figure (formed from the alphabets of the Message) lie between floor (sqrt(len(message))) and ceil (sqrt(len(message))). It also states that the number of rows is less than or equal to the number of columns, and that the area of rectangle thus formed is minimum. Based on the this criteria, we have to choose a set of values for rows and columns.

For the string haveaniceday, we have floor(sqrt(len(message))) = 3 and ceil(sqrt(len(message))) = 4.

3 * 3 = 9 < len(message) = 15
3 * 4 = 12 = len(message)
4 * 3 = 12 = len(message)
4 * 4 = 16 > len(message)

Out of the 4 possible squares, we can see that, rows = 3 and columns = 4 is the best fit.
On building the figure, we get

have
anic
eday

So, the Encrypted form is "hae and via ecy".

 

Example 1:

Input:
S = "eNEMYwILLaTTACK"
Output:
eYLA NwaC EITK MLT
Explanation:
The encrypted form of the given String
is printed.
Example 2:

Input:
S = "SavetheMines"
Output:
Sti ahn vee eMs
Explanation:
The encrypted form of the given String
is printed.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function encryptString() which takes an String S as input and returns the encrypted form as a String.

 

Expected Time Complexity: O(|S|)
Expected Auxiliary Space: O(1)

 

Constraints:
1 <= |S| <= 105
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
            String S = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.encryptString(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static String encryptString(String S) {
        // code here
       StringBuilder result=new StringBuilder();
       int steps;
       int len = S.length(), flor = (int)Math.floor(Math.sqrt(len)), cel = (int)Math.ceil(Math.sqrt(len));
       
       if(flor*flor==len){
           steps=flor;
       }else{
           steps=cel;
       } 
       //taking strings in steps to simulate row/col
        for(int i=0;i<steps;i++){
            for(int j = i; j < len; j=j+steps)
                result.append(S.charAt(j));
           result.append(" ");
        }
        return result.toString();
    }
};
