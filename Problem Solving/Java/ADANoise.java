/*
You are given a message string S consisting of lowercase English alphabet letters. "ada" is a noise word and all the words that can be formed by adding “da” any number of times at the end of any noise word is also considered as a noise word. For example, the words “adada”, “adadadadada”, ”adada” are noise words but “dada”, ”ad”, ”aad” are not considered noise words.
You have to move all the noise words present in the message signal to the end of the message (in the same order as they occur in the message S) so that the filter can truncate the noise from the end.

Example 1:

Input:
S = "heyadadahiadahi"
Output: "heyhihiadadaada" 
Explanation: ”adada” and “ada” are the 
noise words. Noises are moved to the end 
in the same order as they appear in the 
string S.
Example 2:

Input:
S = "heyheyhello"
Output: "heyheyhello"
Explanation: There is no noise in the signal.
Your Task:
You need not take any input or print anything. Your task is to complete the function updateString() which takes string S as input parameter and returns the message string with noise words at the end.

Expected Time Complexity: O(|S|).
Expected Auxiliary Space: O(|S|).

Constraints:
1 ≤ length (string) ≤ 10^5
*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        while(t > 0){
            String S = sc.nextLine();
            Solution ob = new Solution(); 
            System.out.println(ob.updateString(S));
            t--;
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java

class Solution 
{ 
    static String updateString(String S) 
    { 
        // code here
        String res="", noise="";
        
        for(int i=0; i<S.length(); i++){
            while(i+2<S.length() && S.substring(i, i+3).equals("ada")){
                noise+="ada";
                i+=3;
                while(i+1<S.length() && S.charAt(i)=='d' && S.charAt(i+1)=='a'){
                    noise+="da";
                    i+=2;
                }
            }
            if(i<S.length())
                res+=S.charAt(i);
        }
        return res+noise;
    }
} 
