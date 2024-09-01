/*
Given a string S, sort it in the following manner. Sorted string must contain a vowel as first letter and a consonant as next letter and so on OR a consonant as first letter and a vowel as next letter and so on, depending on the string. If there is no vowel left then print the remaining consonant in ascending order and vice versa. 

Note: Order of vowel must be a->e->i->o->u and order of consonant must be b->c->d... and so on.


Example 1:

Input: abcdei 

Output: abecid 

Explanation: 'a' (Vowel) came first so the
pattern of sorted string is vcvcvcvc... 
Example 2:

Input: bcadefgh

Output: bacedfgh 

Explanation: 'b' (consonant) came first so
the pattern of sorted string is cvcvcvcv....
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function SortedString() which takes the string s as input parameters and returns the sorted string.

 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

 

Constraints:

1<=|S|<=1000000


*/

//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String s = br.readLine().trim();
            Solution obj = new Solution();
            String ans = obj.SortedString(s);
            System.out.println(ans);
        }
	}
}
// } Driver Code Ends


//User function Template for Java


class Solution
{
    public String SortedString(String str){
        // Code here
        List<Character> v=new ArrayList<>();
        List<Character> c=new ArrayList<>();
        StringBuilder res=new StringBuilder();
        int i=0, j=0;
        
        for(char k:str.toCharArray())
            if(k=='a' || k=='e' || k=='i' || k=='o' || k=='u')
                v.add(k);
            else
                c.add(k);
        Collections.sort(v);
        Collections.sort(c);
        while(i<v.size() && j<c.size())
            if(str.charAt(0)=='a' || str.charAt(0)=='e' || str.charAt(0)=='i' || str.charAt(0)=='o' || str.charAt(0)=='u'){
                res.append(v.get(i++));
                res.append(c.get(j++));
            }
            else{
                res.append(c.get(j++));
                res.append(v.get(i++));
            }
        while(i<v.size())
            res.append(v.get(i++));
        while(j<c.size())
            res.append(c.get(j++));
        return res.toString();
    }
}

