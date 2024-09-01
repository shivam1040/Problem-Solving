/*
Given a string, find the number of pairs of characters that are same. Pairs (s[i], s[j]), (s[j], s[i]), (s[i], s[i]), (s[j], s[j]) should be considered different.

Example 1:

Input:
S = "air"
Output: 3
Explanation: 3 pairs that are equal:
(S[0], S[0]), (S[1], S[1]) and (S[2], S[2])
â€‹Example 2:

Input: 
S = "aa"
Output: 4
Explanation: 4 pairs that are equal:
(S[0], S[0]), (S[0], S[1]), (S[1], S[0])
and (S[1], S[1])

Your Task:
You don't need to read input or print anything. Your task is to complete the function equalPairs() which takes the string S as input and returns the number of equal pairs as described in the problem description.


Expected Time Complexity: O(|S|).
Expected Auxiliary Space: O(1).


Constraints:
1<=|S|<=105
*/

/*
 Since pairs (x, y) and pairs (y, x) are considered different. We need to use a hash table to store the count of all occurrences of a character.So we know if a character occurs twice, then it will have 4 pairs – (i, i), (j, j), (i, j), (j, i). So using a hash function, store the occurrence of each character, then for each character the number of pairs will be occurrence^2
*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            
            String s = sc.next ();
            System.out.println (new Sol().equalPairs (s));
        }
        
    }
}
// } Driver Code Ends


//User function Template for Java

class Sol
{
    long equalPairs (String s)
    {
        // your code here
        Map<Character, Integer> aux=new HashMap<>();
        long res=0;
        
        for(char i:s.toCharArray())
            aux.put(i, aux.getOrDefault(i, 0)+1);
        for(int i:aux.values())
        //Calculating Equal Pairs: After counting the occurrences of each character, the code iterates through the values in the aux map (which represent character counts). For each count i, it adds i*i to the res variable. This is because each character can form i*(i-1)/2 equal pairs. Since i*i is the square of the count, it represents the total number of equal pairs for that character. The code accumulates the counts for all characters in the string.
            res+=i*i;
        return res;
    }
}
