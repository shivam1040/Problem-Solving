/*
You are given a string str of lower case english alphabets. You can choose any two characters in the string and replace all the occurences of the first character with the second character and replace all the occurences of the second character with the first character. Your aim is to find the lexicographically smallest string that can be obtained by doing this operation at most once.
 

Exampel 1:

Input: str = "ccad"
Output: "aacd"
Explanation: In ccad, we choose ‘a’ and ‘c’
and after doing the replacement operation 
once we get, aacd and this is the 
lexicographically smallest string possible.
Example 2:

Input: "abba"
Output: "abba"
Explanation: In abba, we can get baab after 
doing the replacement operation once for ‘a’ 
and ‘b’ but that is not lexicographically 
smaller than abba and so the answer is abba.
 

Your Task:
You don't need to read or print anything. Your task is to complete the function LexicographicallyMinimum() which takes string str as input parameter and retruns the lexicographically minimum possible string after doing the operation.
 

Expected Time Complexity: O(n)
Expected Space Complexity: O(1)
 

Constraints:
1 <= |str| <= 104
*/


//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String str = br.readLine().trim();
            Solution ob = new Solution();
            String ans = ob.LexicographicallyMinimum(str);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String LexicographicallyMinimum(String str)
    {
        // code here
        List<Character> aux=new ArrayList<>();
        int flag=0;
        char one='A', two='A';
        
        for(char c:str.toCharArray())
            if(!aux.contains(c))
                aux.add(c);
        for(int i=0; i<aux.size(); i++){
            char x=aux.get(i);
            for(int j=i+1; j<aux.size(); j++){
                if(x>aux.get(j)){
                    flag=1;
                    one=aux.get(i);
                    two=aux.get(j);
                    x=aux.get(j);
                }
            }
            if(flag==1)
                break;
        }
        if(flag==1){
            for(int i=0; i<str.length(); i++){
                if(str.charAt(i)==one)
                    str=str.substring(0, i)+(two+"")+str.substring(i+1);
                else if(str.charAt(i)==two)
                    str=str.substring(0, i)+(one+"")+str.substring(i+1);
            }
        }
        return str;
    }
}
