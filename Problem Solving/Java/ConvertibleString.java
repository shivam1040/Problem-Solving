/*
Given two strings check whether first string could be converted to the second string but the conditions are:

1.If the character is at odd place you can swap this character with the characters only at the odd places in    the given first string.
2.If the character is at even place you can swap this character with the characters only at the even places      in the given first string.
3.You cannot insert or delete any character on your own.

 

Example 1:

Input: geeks for

Output: 0

Explanation: Two strings are of
different length. They can't be equal.
Example 2:

Input: skeeg geeks

Output: 1

Explanation:

In first string characters at odd indices are 
's', 'e', 'g'
In second string characters at odd indices are 
'g', 'e', 's'
After swaping index 1st and 3rd of first
string all the characters at odd positions 
become equal.
Same for even indices.
 

Your Task:

You don't need to read or print anything. Your task is to complete the function EqualString() which takes first string as first parameter and second string as second parameter and returns 1 if first string can be made equal to the second string otherwise returns 0.

 

Expected Time Complexity: O(n)

Expected Space Complexity: O(K) where K is constant.

 

Constraints:

1 <= length of both strings <= 1000


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
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        while(T-->0)
        {
            String s = sc.next();
            String t = sc.next();
            Solution ob = new Solution();
            int res  = ob.EqualString(s, t);
            System.out.println(res);                        
        }
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution {
    public int EqualString(String s, String t)
    {
        // Code here
        Map<Character, Integer> aux=new HashMap<>();
        Map<Character, Integer> aux1=new HashMap<>();
        
        if(s.length()!=t.length())
            return 0;
        //ensuring net difference of characters is zero b/w both strings for both even and odd pos
        for(int i=0; i<s.length(); i++)
            if(i%2==0){
                aux.put(s.charAt(i), aux.getOrDefault(s.charAt(i), 0)+1);
                aux.put(t.charAt(i), aux.getOrDefault(t.charAt(i), 0)-1);
            }
            else{
                aux1.put(s.charAt(i), aux1.getOrDefault(s.charAt(i), 0)+1);
                aux1.put(t.charAt(i), aux1.getOrDefault(t.charAt(i), 0)-1);
            }
        for(int i:aux.values())
            if(i!=0)
                return 0;
        for(int i:aux1.values())
            if(i!=0)
                return 0;  
        return 1;
    }
}
