/*
Given a string S, in an operation you can remove 3 consecutive characters which are duplicates and concatenate the rest string. You can perform this operation any number of times. Find the reduced string.

Note: Return '-1' if the string is empty after removing the duplicates.

Example 1:

Input: S = "aabbbaccddddc"
Output: ccdc
Explanation: First remove 3 consecutive
b's and d's and then a's
Example 2:

Input: S = "aabbaccddc"
Output: aabbaccddc
Explanation: No three consecutive 
duplicates exists
Your Task:
You don't need to read input or print anything. Your task is to complete the function remove3ConsecutiveDuplicates() which takes a string S as input and returns the string.

Expected Time Complexity: O(|S|).
Expected Auxiliary Space: O(|S|).


Constraints:
1 <= |S| <= 105
S contains lower case English alphabets
*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])throws IOException
        {
            BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine());
            while(t-->0)
                {
                    String s = br.readLine();
                    Solution ob = new Solution();
                    System.out.println(ob.remove3ConsecutiveDuplicates(s));
                }
        }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String remove3ConsecutiveDuplicates(String str)
    {
        // Your code goes here
                List<Character> aux=new ArrayList<>();
        StringBuilder res=new StringBuilder("");

        aux.add('@');
        for(int i=0; i<str.length(); i++){
            aux.add(str.charAt(i));
            
            char temp=str.charAt(i);

            if(aux.size()>=3 && aux.get(aux.size()-3)==temp && aux.get(aux.size()-2)==temp && aux.get(aux.size()-1)==temp){
                aux.remove(aux.size()-3);
                aux.remove(aux.size()-2);
                aux.remove(aux.size()-1);
            }
        }
        if(aux.size()==1)
            return "-1";
        for(int i=1; i<aux.size(); i++)
            res.append(aux.get(i));
        return res.toString();
    }
}
