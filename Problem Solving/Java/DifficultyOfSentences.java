/*
Given a sentence as a string S. Calculate difficulty of a given sentence.

Difficulty of sentence is defined as 5*(number of hard words) + 3*(number of easy words). A word in the given string is considered hard if it has 4 consecutive consonants or number of consonants are more than number of vowels. Else the word is easy.
Note: uppercase and lowercase characters are same.

Example

Input:
S = "Difficulty of sentence"
Output:
13
Explanation:
2 hard words + 1 easy word
Example

Input:
S = "I am good"
Output:
9
Explanation:
3 easy words
Your task:
You don't have to read input or print anything. Your task is to complete the functioin calcDiff() which takes the string S as input and returns the difficulty of the sentence.
 
Expected Time Complexity : O(len(s)
Expected Auxilliary Space : O(1)

Constraints:
1<= length( S ) <= 105
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
            int result = ob.calcDiff(S);
            
            System.out.println(result);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int calcDiff(String s)
    {
        //code here
        	
        //s=s+" ";
        String vowel="aeiou";
        int conse=0, v=0, c=0, h=0, e=0;
        boolean skip=false;
        
        for(int i=0; i<s.length(); i++){
            String temp=(s.charAt(i)+"").toLowerCase();
            
            if(!temp.equals(" ") && vowel.contains(temp)){
                v++;
                conse=0;
            }
            else if(!temp.equals(" ")){
                c++;
                conse++;
            }
            if(conse==4){
                h++;
                
                while(i<s.length() && s.charAt(i)!=' '){
                    i++;
                }
                
                conse=0;
                v=0;
                c=0;
            }
            else if(temp.equals(" ") || i==s.length()-1){
                if(c>v)
                    h++;
                else
                    e++;
                    
                conse=0;
                v=0;
                c=0;
            }
        }
        
        return 5*h+3*e;
    }
}
