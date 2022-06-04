/*
Given two strings of lowercase alphabets and a value K, your task is to complete the given function which tells if  two strings are K-anagrams of each other or not.

Two strings are called K-anagrams if both of the below conditions are true.
1. Both have same number of characters.
2. Two strings can become anagram by changing at most K characters in a string.

Example:

Input:
str1 = "fodr", str2="gork"
k = 2
Output:
1
Explanation: Can change fd to gk
Your Task:
Since this is a function problem, you don't need to take any input. Just complete the given function areKAnagrams that returns true if the strings can be turned into K-anagrams, else return false.

Constraints:
1 ≤ length of String ≤ 105
1 ≤ K ≤ length of String
*/

// { Driver Code Starts
//Initial template for JAVA

import java.util.*;
import java.lang.*;
class GFG {
    public static void main(String[] args)
    {   Scanner sc = new Scanner(System.in);
    	int t=sc.nextInt();
    	while(t-->0)
    	{
    		String str1=sc.next();
    		String str2=sc.next();
    		int k=sc.nextInt();
            Solution ob = new Solution();
    		if (ob.areKAnagrams(str1, str2, k) == true)
    			System.out.println("1");
    		else
    			System.out.println("0");
    	}
    }
}// } Driver Code Ends


//User function template for JAVA

class Solution {
    boolean areKAnagrams(String a, String b, int k) {
        // Check if length of both strings is same or not
            if (a.length() != b.length()) {
                return false;
            }
            // Create a HashMap containing Character as Key and
            // Integer as Value. We will be storing character as
            // Key and count of character as Value.
            HashMap<Character, Integer> map = new HashMap<>();
            HashMap<Character, Integer> map1 = new HashMap<>();
            // Loop over all character of String a and put in
            // HashMap.
            for (int i = 0; i < a.length(); i++) {
                // Check if HashMap already contain current
                // character or not
                if (map.containsKey(a.charAt(i))) {
                    // If contains increase count by 1 for that
                    // character
                    map.put(a.charAt(i),
                            map.get(a.charAt(i)) + 1);
                }
                else {
                    // else put that character in map and set
                    // count to 1 as character is encountered
                    // first time
                    map.put(a.charAt(i), 1);
                }
            }
            
            for (int i = 0; i < b.length(); i++) {
                // Check if HashMap already contain current
                // character or not
                if (map1.containsKey(b.charAt(i))) {
                    // If contains increase count by 1 for that
                    // character
                    map1.put(b.charAt(i),
                            map1.get(b.charAt(i)) + 1);
                }
                else {
                    // else put that character in map and set
                    // count to 1 as character is encountered
                    // first time
                    map1.put(b.charAt(i), 1);
                }
            }
            
            int aa=diff(a, map1);
            int bb=diff(b, map);
            return Math.min(aa, bb)<=k ? true : false;
    }
    
    public int diff(String check, HashMap<Character, Integer> aux){
        int count=0;
        for(int i=0; i<check.length(); i++){
            if(aux.containsKey(check.charAt(i)) && aux.get(check.charAt(i))>0){
                aux.put(check.charAt(i),
                            aux.get(check.charAt(i)) - 1);
            }
            else
                count++;
        }
        return count;
    }
}