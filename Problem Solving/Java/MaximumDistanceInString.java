/*
Given a String S (in lowerCase only). Starting from letter 'a' which is the only source. for example:- "aaabcahd..." . Now you can only jump from one character to another in the form that a to b; b to c; c to d and so on. You have to find the maximum distance from source to destination. And if there is no place to jump on then print -1.

 

Example 1:

Input: aaabcb

Output: 6

Explanation: As 'a' will only jump to 'b' 
and the maximum distance will is 6.
Example 2:

Input: aabac

Output: 5

Explanation: As 'a' will only jump to 'b' 
and 'b' will jump to 'c' and distance 
is 5.
 

Your Task:

You don't need to read input or print anything. Your task is to complete the function maximum_distance() which takes the string S as input parameter and returns the maximum distance. If not possible to reach at destination then return -1.


Expected Time complexity: O(n)

Expected Space complexity: O(n)

 

Constraints:

1 <= size of string <= 1000
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
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String s = br.readLine().trim();
            Solution ob = new Solution();
            int res  = ob.maximum_distance(s);
            System.out.println(res);                        
        }
	}
}
// } Driver Code Ends


class Solution
{
    public int maximum_distance(String s)
    {
        // Code here
        Map<Character, Integer> aux=new HashMap<>();
        char c=s.charAt(0);
        
        c++;
        
        int res=-1;
        
        for(int i=0; i<s.length(); i++)
            aux.put(s.charAt(i), i);
        for(int i=0; i<s.length(); i++){
            if(!aux.containsKey(c))
                break;
            //always get the last occurence to jump to
            res=Math.max(aux.get(c), res);
            //this ensures the jump is always in forward direction
            if(s.charAt(i)==c)
                c++;
        }
        return res==-1 ? res : res+1;
    }
}



