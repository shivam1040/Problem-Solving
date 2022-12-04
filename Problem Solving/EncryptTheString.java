/*
Bingu was testing all the strings he had at his place and found that most of them were prone to a vicious attack by Banju, his arch-enemy. Bingu decided to encrypt all the strings he had, by the following method. Every substring of identical letters is replaced by a single instance of that letter followed by the number of occurrences of that letter. Then, the string thus obtained is further encrypted by reversing it.

Example 1:

Input:
s = "aabc"
Output: 1c1b2a
Explanation: aabc
Step1: a2b1c1
Step2: 1c1b2a
Example 2:

Input:
s = "aaaaa"
Output: 5a
Explanation: aaaaa
Step 1: a5
Step 2: 5a
Your Task:
You don't need to read input or print anything.Your task is to complete the function encryptString() which takes a single argument(s) and returns the encrypted string.

Expected Time Complexity: O(|s|).
Expected Auxiliary Space: O(|s|).

Constraints
1 <= |s| <=1000

|s| denotes the length of the string s
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
            String s = read.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.encryptString(s));
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    String encryptString(String s) 
    {
        // code here
        int count=1;
        StringBuilder aux=new StringBuilder();
        
        for(int i=1; i<s.length(); i++){
            if(s.charAt(i-1)==s.charAt(i))
                count++;
            else{
                aux.append(s.charAt(i-1));
                aux.append(count);
                count=1;
            }
        }
        aux.append(s.charAt(s.length()-1));
        aux.append(count);
        return aux.reverse().toString();
    }
} 
