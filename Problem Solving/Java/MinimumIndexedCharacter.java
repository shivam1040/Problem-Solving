/*
Given a string S and another string patt. Find the character in patt that is present at the minimum index in S.
 

Example 1:

Input: S = "zsyle", patt = "bjz"
Output: "z"
Example 2:

Input: S = "anskg", patt = "me"
Output: "$"
 

Your Task:
You don't need to read or print anything. Your task is to complete the function printMinIndexChar() which takes S and patt as input parameter and returns the character in patt that is present at the minimum index in S. If not possible returns "$".
 

Expected Time Complexity: O(max(|str|, |patt|))
Expected Auxilary Space: O(K) where K <= 26
 

Constraints:
1 ≤ |S|, |patt| ≤ 104
*/

//{ Driver Code Starts
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
            String patt = br.readLine().trim();
            Solution obj = new Solution();
            System.out.println(obj.printMinIndexChar(str, patt));
        }
    }
}
// } Driver Code Ends


class Solution{
    
    // Function to find the character in patt which is present in str at min index
    public static String printMinIndexChar(String S, String patt){
        
        // Your code here
        
        // you don't need to print anything
        Map<Character, Integer> aux=new HashMap<>();
        int min=Integer.MAX_VALUE;
        String res="$";
        
        for(int i=0; i<S.length(); i++){
            char c=S.charAt(i);
            if(!aux.containsKey(c))
                aux.put(c, i);
        }
        for(int i=0; i<patt.length(); i++){
            char c=patt.charAt(i);
            if(aux.containsKey(c) && aux.get(c)<min){
                min=aux.get(c);
                res=String.valueOf(c);
            }
        }
        return res;
    }
    
}

