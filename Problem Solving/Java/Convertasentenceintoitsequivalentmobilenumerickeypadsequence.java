/*
Given a sentence in the form of a string in uppercase, convert it into its equivalent mobile numeric keypad sequence.



 

Example 1:

Input:
S = "GFG"
Output: 43334
Explanation: For 'G' press '4' one time.
For 'F' press '3' three times.
Example 2:

Input:
S = "HEY U"
Output: 4433999088
Explanation: For 'H' press '4' two times.
â€‹For 'E' press '3' two times. For 'Y' press '9' 
three times. For white space press '0' one time.
For 'U' press '8' two times.
 

Your Task:  
You dont need to read input or print anything. Complete the function printSequence() which takes a string as input parameter and returns its equivalent mobile numeric keypad sequence as a string.
 

Expected Time Complexity: O(Length of String)
Expected Auxiliary Space: O(Length of String)
 

Constraints:

1 <= Length of String <= 105
Characters of string can be empty space or capital alphabets.
*/

//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0){
            String S = read.readLine();
            Solution obj = new Solution();
            System.out.println(obj.printSequence(S));
            
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    String printSequence(String S) 
    { 
        // code here
        String aux[]={ "2","22","222",

             "3","33","333",

             "4","44","444",

             "5","55","555",

             "6","66","666",

             "7","77","777","7777",

             "8","88","888",

             "9","99","999","9999"};
        String res="";
        
        for(int i=0; i<S.length(); i++){
            if(S.charAt(i)==' '){
                res+="0";
                continue;
            }
            int a=Character.getNumericValue(S.charAt(i));
            res+=aux[a-Character.getNumericValue('a')];
        }
        return res;
    }
}
