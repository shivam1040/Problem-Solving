/*
Given two strings 'str1' and 'str2', check if these two strings are isomorphic to each other.
Two strings str1 and str2 are called isomorphic if there is a one to one mapping possible for every character of str1 to every character of str2 while preserving the order.
Note: All occurrences of every character in ‘str1’ should map to the same character in ‘str2’

Example 1:

Input:
str1 = aab
str2 = xxy
Output: 1
Explanation: There are two different
charactersin aab and xxy, i.e a and b
with frequency 2and 1 respectively.
Example 2:

Input:
str1 = aab
str2 = xyz
Output: 0
Explanation: There are two different
charactersin aab but there are three
different charactersin xyz. So there
won't be one to one mapping between
str1 and str2.
Your Task:
You don't need to read input or print anything.Your task is to complete the function areIsomorphic() which takes the string str1 and string str2 as input parameter and  check if two strings are isomorphic. The function returns true if strings are isomorphic else it returns false.

Expected Time Complexity: O(|str1|+|str2|).
Expected Auxiliary Space: O(Number of different characters).
Note: |s| represents the length of string s.

Constraints:
1 <= |str1|, |str2| <= 2*104
*/
// { Driver Code Starts
    import java.io.BufferedReader;
    import java.io.InputStreamReader;
    import java.io.IOException;
    import java.util.Arrays;
    import java.util.*;
    
    
    public class Driver {
        
        public static void main(String[] args)throws IOException {
           
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int tc = Integer.parseInt(br.readLine());
            while(tc-->0)
            {
                String s1 = br.readLine();
                String s2 = br.readLine();
                
                Solution obj = new Solution();
                
                boolean a = obj.areIsomorphic(s1,s2);
                if(a)
                System.out.println(1);
                else
                System.out.println(0);
            }
        }
        
    }
    // } Driver Code Ends
    
    
    class Solution
    {
    
        public static boolean areIsomorphic(String str1,String str2)
        {
            /*
    
        
    
            */
            
            
             if(str1.length()!=str2.length())
                return false;
                
            Map<Character, Character> s1=new HashMap<Character, Character>();
            Map<Character, Character> s2=new HashMap<Character, Character>();
            
            for(int i=0; i<str1.length(); i++){
                char ch1=str1.charAt(i);
                char ch2=str2.charAt(i);
                
                if(!s1.containsKey(ch1) && !s2.containsKey(ch2)){ //store 1 to 1 mapping of characters not present in map
                    s1.put(ch1, ch2);
                    s2.put(ch2, ch1);
                }
                else if(s1.containsKey(ch1) && s1.get(ch1)!=ch2) //if present then check if current mapping in string is equal to previous mappings stored in map
                    return false;
                else if(s2.containsKey(ch2) && s2.get(ch2)!=ch1)
                    return false;
            }
            
            return true;
            
        }
    }